package org.example.articlekotlin

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/articles")
class ArticleController{
        val articles: MutableList<Article> = mutableListOf(Article("My title",
                "my content"))

        @GetMapping
        fun articles() = articles


        @GetMapping
        fun getAllArticles(): List<Article> = articles

        @PostMapping
        fun createArticle(@RequestBody article: Article): ResponseEntity<String> {
                articles.add(article)
                return ResponseEntity("Article created successfully", HttpStatus.CREATED)
        }

        @GetMapping("/{index}")
        fun getArticleById(@PathVariable index: Int): ResponseEntity<Any> {
                return if (index < articles.size) {
                        ResponseEntity(articles[index], HttpStatus.OK)
                } else {
                        ResponseEntity("Article not found", HttpStatus.NOT_FOUND)
                }
        }

        @PutMapping("/{index}")
        fun updateArticle(@PathVariable index: Int, @RequestBody updatedArticle: Article): ResponseEntity<String> {
                return if (index < articles.size) {
                        articles[index] = updatedArticle
                        ResponseEntity("Article updated successfully", HttpStatus.OK)
                } else {
                        ResponseEntity("Article not found", HttpStatus.NOT_FOUND)
                }
        }

        @DeleteMapping("/{index}")
        fun deleteArticle(@PathVariable index: Int): ResponseEntity<String> {
                return if (index < articles.size) {
                        articles.removeAt(index)
                        ResponseEntity("Article deleted successfully", HttpStatus.OK)
                } else {
                        ResponseEntity("Article not found", HttpStatus.NOT_FOUND)
                }
        }
}
