package dev.william.samples.kotlin.jpademo.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.NOT_FOUND)
class NotFoundException(val resource: String, val value: String, previous: Throwable? = null) :
    RuntimeException("resource $resource not found with value $value", previous)
