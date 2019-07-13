package dev.william.samples.kotlin.jpademo.service

import dev.william.samples.kotlin.jpademo.entity.Customer

interface CustomerService {
    fun findAll(): List<Customer>
    fun findById(id: String): Customer
    fun create(customer: Customer): Customer
}
