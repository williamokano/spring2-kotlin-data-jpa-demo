package dev.william.samples.kotlin.jpademo.controller.representation

import dev.william.samples.kotlin.jpademo.entity.Customer

data class CustomerRepresentation(
    val id: String,
    val name: String
)

fun Customer.toRepresentation(): CustomerRepresentation {
    return CustomerRepresentation(
        id = this.id,
        name = this.name
    )
}
