package com.allisaudiobook.controller

import com.allisaudiobook.client.texttospeech.GoogleTextToSpeechClient
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class TextToSpeechController(
    val client: GoogleTextToSpeechClient,
) {
    @PostMapping("/convert-text-to-voice")
    fun convertTextToSpeech(@RequestBody input: ConvertTextToSpeechDto) {
        client.convertTextToSpeech(input.text, input.languageCode)
    }
}