package dev.william.samples.kotlin.jpademo.controller.representation

import dev.william.samples.kotlin.jpademo.entity.Category

data class CategoryRepresentation(
    val id: String,
    val name: String
)

fun Category.toRepresentation(): CategoryRepresentation {
    return CategoryRepresentation(
        id = this.id,
        name = this.name
    )
}
