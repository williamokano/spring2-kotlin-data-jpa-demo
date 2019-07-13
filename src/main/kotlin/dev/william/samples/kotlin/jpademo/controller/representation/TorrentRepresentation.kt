package dev.william.samples.kotlin.jpademo.controller.representation

import dev.william.samples.kotlin.jpademo.entity.Torrent

data class TorrentRepresentation(
    val id: String,
    val name: String,
    val category: CategoryRepresentation
)

fun Torrent.toRepresentation(): TorrentRepresentation {
    return TorrentRepresentation(
        id = this.id,
        name = this.name,
        category = this.category.toRepresentation()
    )
}
