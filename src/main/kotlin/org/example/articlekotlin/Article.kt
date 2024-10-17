package org.example.articlekotlin

import java.time.LocalDateTime

data class Article(
        val title : String,
        val content : String?
        val createdAt: LocalDateTime = LocalDateTime.now(),
        val slug = title.toSlug()
)

