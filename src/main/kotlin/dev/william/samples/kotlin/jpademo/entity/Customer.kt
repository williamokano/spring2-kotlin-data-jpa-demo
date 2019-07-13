package dev.william.samples.kotlin.jpademo.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "customers")
data class Customer(
    @Id
    val id: String,

    @Column(nullable = false)
    val name: String
)
