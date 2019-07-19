package dev.william.samples.kotlin.jpademo.controller.representation

import dev.william.samples.kotlin.jpademo.entity.JuridicPerson
import dev.william.samples.kotlin.jpademo.entity.Person
import dev.william.samples.kotlin.jpademo.entity.PhysicalPerson

sealed class PersonRepresentation

data class PfRepresentation(
    val id: String,
    val name: String,
    val cpf: String
) : PersonRepresentation()

data class PjRepresentation(
    val id: String,
    val name: String,
    val cnpj: String
) : PersonRepresentation()

fun Person.toRepresentation(): PersonRepresentation {
    return when (this) {
        is JuridicPerson -> PjRepresentation(this.id, this.name, this.cnpj)
        is PhysicalPerson -> PfRepresentation(this.id, this.name, this.cpf)
        else -> throw RuntimeException("WTF")
    }
}

