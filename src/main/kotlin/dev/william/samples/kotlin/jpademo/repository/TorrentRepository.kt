package dev.william.samples.kotlin.jpademo.repository

import dev.william.samples.kotlin.jpademo.entity.Torrent
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TorrentRepository : JpaRepository<Torrent, String>
