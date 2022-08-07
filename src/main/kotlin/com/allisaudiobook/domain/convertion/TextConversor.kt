package com.allisaudiobook.domain.convertion

import com.allisaudiobook.app.controller.ConvertTextToSpeechDto
import com.allisaudiobook.client.GoogleTextToSpeechClient
import com.google.cloud.texttospeech.v1.AudioEncoding

class TextConversor(
    private val client: GoogleTextToSpeechClient,
) {
    fun convert(input: ConvertTextToSpeechDto, nameFileOutput: String) {
        client.convertTextToSpeech(
            text = input.text,
            languageCode = input.languageCode,
            nameFileOutput = buildNameFile(nameFileOutput, input.format),
            audioEncoding = formatEncoding(input.format),
        )
    }

    private fun buildNameFile(nameFileOutput: String, format: String) = "$nameFileOutput.$format"

    private fun formatEncoding(format: String) = when (format.lowercase()) {
        "mp3" -> AudioEncoding.MP3
        else -> AudioEncoding.OGG_OPUS
    }
}