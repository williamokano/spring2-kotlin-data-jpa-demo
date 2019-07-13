package dev.william.samples.kotlin.jpademo.service.impl

import dev.william.samples.kotlin.jpademo.entity.Torrent
import dev.william.samples.kotlin.jpademo.exception.NotFoundException
import dev.william.samples.kotlin.jpademo.repository.TorrentRepository
import dev.william.samples.kotlin.jpademo.service.TorrentService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class TorrentServiceImpl(val torrentRepository: TorrentRepository) : TorrentService {
    override fun findAll(): List<Torrent> {
        return torrentRepository.findAll()
    }

    override fun findById(id: String): Torrent {
        return torrentRepository.findById(id)
            .orElseThrow { NotFoundException("torrent", id) }
    }

    override fun create(torrent: Torrent): Torrent {
        return torrentRepository.save(torrent)
    }

    @Transactional
    override fun delete(id: String): Torrent {
        return findById(id)
            .also { torrentRepository.delete(it) }
    }

    override fun update(torrent: Torrent): Torrent {
        return torrentRepository.save(torrent)
    }
}
