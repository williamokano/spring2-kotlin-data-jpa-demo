package dev.william.samples.kotlin.jpademo.entity

import javax.persistence.*

@Entity
@Table(name = "people")
@Inheritance(strategy = InheritanceType.JOINED)
abstract class Person(
    @field:Id
    open val id: String,
    open val name: String
)

@Entity
@Table(name = "juridic_people")
data class JuridicPerson(
    @field:Id
    override val id: String,
    override val name: String,
    val cnpj: String
) : Person(id, name)

@Entity
@Table(name = "physical_people")
data class PhysicalPerson(
    @field:Id
    override val id: String,
    override val name: String,
    val cpf: String
) : Person(id, name)