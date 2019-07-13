package dev.william.samples.kotlin.jpademo.controller

import dev.william.samples.kotlin.jpademo.controller.representation.CustomerRepresentation
import dev.william.samples.kotlin.jpademo.controller.representation.toRepresentation
import dev.william.samples.kotlin.jpademo.controller.request.customer.CreateCustomerRequest
import dev.william.samples.kotlin.jpademo.entity.Customer
import dev.william.samples.kotlin.jpademo.service.CustomerService
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid

@RestController
@RequestMapping("/customers")
class CustomerController(val customerService: CustomerService) {

    @GetMapping
    fun findAll(): List<CustomerRepresentation> {
        return customerService.findAll().map { it.toRepresentation() }
    }

    @GetMapping("/{customerId}")
    fun findById(@PathVariable customerId: String): CustomerRepresentation {
        return customerService.findById(customerId).toRepresentation()
    }

    @PostMapping
    fun createCustomer(@RequestBody @Valid createCustomerRequest: CreateCustomerRequest): CustomerRepresentation {
        return customerService.create(Customer(UUID.randomUUID().toString(), createCustomerRequest.name))
            .toRepresentation()
    }
}
