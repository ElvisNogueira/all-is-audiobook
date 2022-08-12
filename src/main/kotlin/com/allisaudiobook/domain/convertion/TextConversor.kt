package com.allisaudiobook.domain.convertion

import com.allisaudiobook.app.controller.ConversorConfig
import com.allisaudiobook.client.GoogleTextToSpeechClient
import com.google.cloud.texttospeech.v1.AudioEncoding

class TextConversor(
    private val client: GoogleTextToSpeechClient,
) {
    fun convert(input: ConversorConfig) {
        client.convertTextToSpeech(
            text = input.text,
            languageCode = input.languageCode,
            nameFileOutput = buildNameFile(input.outputUrl, input.outputFileName, input.format),
            audioEncoding = formatEncoding(input.format),
        )
    }

    private fun buildNameFile(outputUrl: String, nameFileOutput: String, format: String) =
        "$outputUrl$nameFileOutput.$format"

    private fun formatEncoding(format: String) = when (format.lowercase()) {
        "mp3" -> AudioEncoding.MP3
        else -> AudioEncoding.OGG_OPUS
    }
}