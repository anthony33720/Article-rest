package org.example.articlekotlin

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/articles")
class ArticleController {

        val articles: MutableList<Article> = mutableListOf(Article("My title", "my content"))

        @GetMapping
        fun getAllArticles(): List<Article> = articles


        @PostMapping
        fun createArticle(@RequestBody article: Article): ResponseEntity<String> {
                articles.add(article)
                return ResponseEntity("Article created successfully", HttpStatus.CREATED)
        }

        @GetMapping("/{slug}")
        fun getArticleBySlug(@PathVariable slug: String): ResponseEntity<Any> {
                val article = articles.find { it.slug == slug }
                return if (article != null) {
                        ResponseEntity(article, HttpStatus.OK)
                } else {
                        ResponseEntity("Article not found", HttpStatus.NOT_FOUND)
                }
        }


        @PutMapping("/{slug}")
        fun updateArticle(@PathVariable slug: String, @RequestBody updatedArticle: Article): ResponseEntity<String> {
                val index = articles.indexOfFirst { it.slug == slug }
                return if (index != -1) {
                        articles[index] = updatedArticle.copy(slug = updatedArticle.title.toSlug())
                        ResponseEntity("Article updated successfully", HttpStatus.OK)
                } else {
                        ResponseEntity("Article not found", HttpStatus.NOT_FOUND)
                }
        }

        @DeleteMapping("/{slug}")
        fun deleteArticle(@PathVariable slug: String): ResponseEntity<String> {
                val article = articles.find { it.slug == slug }
                return if (article != null) {
                        articles.remove(article)
                        ResponseEntity("Article deleted successfully", HttpStatus.OK)
                } else {
                        ResponseEntity("Article not found", HttpStatus.NOT_FOUND)
                }
        }
}
