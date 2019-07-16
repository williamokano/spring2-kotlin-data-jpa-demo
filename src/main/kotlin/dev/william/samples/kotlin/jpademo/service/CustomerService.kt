package dev.william.samples.kotlin.jpademo.service

import dev.william.samples.kotlin.jpademo.entity.Customer
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface CustomerService {
    fun findAll(pageable: Pageable): Page<Customer>
    fun findById(id: String): Customer
    fun create(customer: Customer): Customer
}
