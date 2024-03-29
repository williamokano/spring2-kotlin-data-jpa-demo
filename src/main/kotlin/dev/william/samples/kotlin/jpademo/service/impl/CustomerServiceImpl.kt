package dev.william.samples.kotlin.jpademo.service.impl

import dev.william.samples.kotlin.jpademo.entity.Customer
import dev.william.samples.kotlin.jpademo.exception.NotFoundException
import dev.william.samples.kotlin.jpademo.repository.CustomerRepository
import dev.william.samples.kotlin.jpademo.service.CustomerService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class CustomerServiceImpl(val customerRepository: CustomerRepository) : CustomerService {
    override fun findAll(pageable: Pageable): Page<Customer> {
        return customerRepository.findAll(pageable)
    }

    override fun findById(id: String): Customer {
        return customerRepository.findById(id)
            .orElseThrow { NotFoundException("customer", id) }
    }

    override fun create(customer: Customer): Customer {
        return customerRepository.save(customer)
    }
}
