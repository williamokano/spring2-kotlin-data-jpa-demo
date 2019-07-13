package dev.william.samples.kotlin.jpademo.repository

import dev.william.samples.kotlin.jpademo.entity.Category
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CategoryRepository : JpaRepository<Category, String>
