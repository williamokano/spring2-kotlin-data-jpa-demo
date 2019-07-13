package dev.william.samples.kotlin.jpademo.entity

import javax.persistence.*

@Entity
@Table(name = "torrents")
data class Torrent(
    @field:Id
    val id: String,
    val name: String,
    @field:[ManyToOne JoinColumn(name = "category_id")]
    val category: Category
)
