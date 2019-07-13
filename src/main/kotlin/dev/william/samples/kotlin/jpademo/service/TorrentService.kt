package dev.william.samples.kotlin.jpademo.service

import dev.william.samples.kotlin.jpademo.entity.Torrent

interface TorrentService {
    fun findAll(): List<Torrent>
    fun findById(id: String): Torrent
    fun create(torrent: Torrent): Torrent
    fun delete(id: String): Torrent
    fun update(torrent: Torrent): Torrent
}
