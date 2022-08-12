package com.allisaudiobook.app.exception

import java.io.FileNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ExceptionHandler {
    @ExceptionHandler(value = [FileEncryptedException::class])
    fun fileEncryptedExceptionHandler(exception: FileEncryptedException): ResponseEntity<String> =
        ResponseEntity<String>(exception.message, HttpStatus.BAD_REQUEST)

    @ExceptionHandler(value = [FileNotFoundException::class])
    fun fileNotFoundExceptionHandler(exception: FileNotFoundException): ResponseEntity<String> =
        ResponseEntity<String>(exception.message, HttpStatus.NOT_FOUND)
}