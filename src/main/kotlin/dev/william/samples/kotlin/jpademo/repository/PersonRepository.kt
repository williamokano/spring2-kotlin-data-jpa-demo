package dev.william.samples.kotlin.jpademo.repository

import dev.william.samples.kotlin.jpademo.entity.JuridicPerson
import dev.william.samples.kotlin.jpademo.entity.Person
import dev.william.samples.kotlin.jpademo.entity.PhysicalPerson
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonRepository : JpaRepository<Person, String>

@Repository
interface PhysicalPersonRepository : JpaRepository<PhysicalPerson, String>

@Repository
interface JuridicPersonRepository : JpaRepository<JuridicPerson, String>