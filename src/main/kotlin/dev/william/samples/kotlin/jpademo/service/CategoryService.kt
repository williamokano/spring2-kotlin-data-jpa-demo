package dev.william.samples.kotlin.jpademo.service

import dev.william.samples.kotlin.jpademo.entity.Category

interface CategoryService {
    fun findAll(): List<Category>
    fun findById(id: String): Category
    fun create(category: Category): Category
    fun delete(id: String): Category
    fun update(category: Category): Category
}
