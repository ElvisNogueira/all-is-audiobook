package com.allisaudiobook.app.controller

import com.allisaudiobook.domain.convertion.TextConversor
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class TextToSpeechController(
    val textConversor: TextConversor,
) {
    @PostMapping("/convert-text-to-voice/")
    fun convertTextToSpeech(
        @RequestBody input: ConvertTextToSpeechDto,
    ) {
        textConversor.convert(input, "output")
    }
}