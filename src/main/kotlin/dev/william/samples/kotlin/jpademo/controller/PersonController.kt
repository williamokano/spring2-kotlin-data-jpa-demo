package dev.william.samples.kotlin.jpademo.controller

import dev.william.samples.kotlin.jpademo.controller.representation.PersonRepresentation
import dev.william.samples.kotlin.jpademo.controller.representation.toRepresentation
import dev.william.samples.kotlin.jpademo.service.PersonService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/people")
class PersonController(private val personService: PersonService) {
    @GetMapping
    fun findAll(): List<PersonRepresentation> {
        return personService.findAll().map { it.toRepresentation() }
    }
}