package dev.william.samples.kotlin.jpademo.controller.request.torrent

import com.fasterxml.jackson.annotation.JsonProperty
import org.jetbrains.annotations.NotNull
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty

data class CreateTorrentRequest(
    @NotNull
    @NotEmpty
    @NotBlank
    val name: String,

    @NotNull
    @NotEmpty
    @NotBlank
    @JsonProperty(value = "category_id")
    val categoryId: String
)
