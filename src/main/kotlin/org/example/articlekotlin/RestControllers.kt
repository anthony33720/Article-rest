package org.example.articlekotlin

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/articles")
class ArticleController(
        val articles: MutableList<Article> = mutableListOf(Article("My title", "my content"))
)