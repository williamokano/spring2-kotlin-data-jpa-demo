package dev.william.samples.kotlin.jpademo.controller

import dev.william.samples.kotlin.jpademo.controller.representation.TorrentRepresentation
import dev.william.samples.kotlin.jpademo.controller.representation.toRepresentation
import dev.william.samples.kotlin.jpademo.controller.request.torrent.CreateTorrentRequest
import dev.william.samples.kotlin.jpademo.entity.Torrent
import dev.william.samples.kotlin.jpademo.service.CategoryService
import dev.william.samples.kotlin.jpademo.service.TorrentService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid

@RestController
@RequestMapping("/torrents")
class TorrentController(
    val torrentService: TorrentService,
    val categoryService: CategoryService
) {
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun findAll(): List<TorrentRepresentation> {
        return torrentService.findAll().map { it.toRepresentation() }
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun findById(@PathVariable id: String): TorrentRepresentation {
        return torrentService.findById(id).toRepresentation()
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody @Valid createTorrentRequest: CreateTorrentRequest): TorrentRepresentation {
        return torrentService.create(
            Torrent(
                id = UUID.randomUUID().toString(),
                name = createTorrentRequest.name,
                category = categoryService.findById(createTorrentRequest.categoryId)
            )
        ).toRepresentation()
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: String): TorrentRepresentation {
        return torrentService.delete(id).toRepresentation()
    }
}
