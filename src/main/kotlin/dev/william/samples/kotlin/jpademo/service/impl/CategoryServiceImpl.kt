package dev.william.samples.kotlin.jpademo.service.impl

import dev.william.samples.kotlin.jpademo.entity.Category
import dev.william.samples.kotlin.jpademo.exception.NotFoundException
import dev.william.samples.kotlin.jpademo.repository.CategoryRepository
import dev.william.samples.kotlin.jpademo.service.CategoryService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CategoryServiceImpl(val categoryRepository: CategoryRepository) : CategoryService {
    override fun findAll(): List<Category> {
        return categoryRepository.findAll()
    }

    override fun findById(id: String): Category {
        return categoryRepository.findById(id)
            .orElseThrow { NotFoundException("category", id) }
    }

    override fun create(category: Category): Category {
        return categoryRepository.save(category)
    }

    @Transactional
    override fun delete(id: String): Category {
        return findById(id)
            .also { categoryRepository.delete(it) }
    }

    override fun update(category: Category): Category {
        return categoryRepository.save(category)
    }
}
