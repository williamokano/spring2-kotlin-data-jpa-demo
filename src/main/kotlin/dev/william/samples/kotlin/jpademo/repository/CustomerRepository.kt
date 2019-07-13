package dev.william.samples.kotlin.jpademo.repository

import dev.william.samples.kotlin.jpademo.entity.Customer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomerRepository : JpaRepository<Customer, String>
