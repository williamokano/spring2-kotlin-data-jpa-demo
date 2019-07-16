package dev.william.samples.kotlin.jpademo.controller.representation

import org.springframework.data.domain.Page

data class PageRepresentation<T>(
    val items: List<T>,
    val totalPages: Int,
    val pageNumber: Int,
    val hasMore: Boolean
)

fun <T> Page<T>.toRepresentation(): PageRepresentation<T> {
    return PageRepresentation(
        items = this.content,
        hasMore = this.isLast.not(),
        pageNumber = this.number,
        totalPages = this.totalPages
    )
}
