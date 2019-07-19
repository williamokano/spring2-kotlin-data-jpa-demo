package dev.william.samples.kotlin.jpademo.service

import dev.william.samples.kotlin.jpademo.entity.Person
import dev.william.samples.kotlin.jpademo.repository.PersonRepository
import org.springframework.stereotype.Service

@Service
class PersonService(private val personRepository: PersonRepository) {
    fun findAll(): List<Person> {
        return personRepository.findAll()
    }
}