package org.example.articlekotlin

import java.time.LocalDateTime

data class Article(
        var title : String,
        var content : String?,
        var createdAt: LocalDateTime = LocalDateTime.now(),
        var slug: String = title.toSlug()
)

