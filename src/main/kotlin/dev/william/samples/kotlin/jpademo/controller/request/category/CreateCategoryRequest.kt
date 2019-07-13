package dev.william.samples.kotlin.jpademo.controller.request.category

import org.jetbrains.annotations.NotNull
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty

data class CreateCategoryRequest(
    @NotNull
    @NotEmpty
    @NotBlank
    val name: String
)
