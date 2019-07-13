package dev.william.samples.kotlin.jpademo.controller.request.customer

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class CreateCustomerRequest(
    @NotNull
    @NotEmpty
    @NotBlank
    val name: String
)
