package dev.william.samples.kotlin.jpademo.controller

import dev.william.samples.kotlin.jpademo.controller.representation.CategoryRepresentation
import dev.william.samples.kotlin.jpademo.controller.representation.toRepresentation
import dev.william.samples.kotlin.jpademo.controller.request.category.CreateCategoryRequest
import dev.william.samples.kotlin.jpademo.controller.request.category.UpdateCategoryRequest
import dev.william.samples.kotlin.jpademo.entity.Category
import dev.william.samples.kotlin.jpademo.service.CategoryService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid

@RestController
@RequestMapping("/categories")
class CategoryController(val categoryService: CategoryService) {
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun findAll(): List<CategoryRepresentation> {
        return categoryService.findAll().map { it.toRepresentation() }
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun findById(@PathVariable id: String): CategoryRepresentation {
        return categoryService.findById(id).toRepresentation()
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody @Valid createCategoryRequest: CreateCategoryRequest): CategoryRepresentation {
        return categoryService.create(Category(UUID.randomUUID().toString(), createCategoryRequest.name))
            .toRepresentation()
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun update(@PathVariable id: String, @RequestBody @Valid updateCategoryRequest: UpdateCategoryRequest): CategoryRepresentation {
        return categoryService.findById(id)
            .copy(name = updateCategoryRequest.name)
            .let { categoryService.update(it) }
            .toRepresentation()
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: String): CategoryRepresentation {
        return categoryService.delete(id).toRepresentation()
    }
}
