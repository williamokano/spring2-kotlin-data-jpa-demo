package dev.william.samples.kotlin.jpademo.entity

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "categories")
data class Category(
    @field:Id
    val id: String,
    val name: String
)
