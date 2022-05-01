package com.allisaudiobook.client.texttospeech

import com.google.cloud.texttospeech.v1.AudioConfig
import com.google.cloud.texttospeech.v1.AudioEncoding.MP3
import com.google.cloud.texttospeech.v1.SsmlVoiceGender.MALE
import com.google.cloud.texttospeech.v1.SynthesisInput
import com.google.cloud.texttospeech.v1.TextToSpeechClient
import com.google.cloud.texttospeech.v1.VoiceSelectionParams
import java.io.FileOutputStream

class GoogleTextToSpeechClient(
    val client: TextToSpeechClient,
) {
    fun convertTextToSpeech(text: String, languageCode: String) {
        val input = SynthesisInput.newBuilder().setText(text).build()
        val voice = VoiceSelectionParams.newBuilder()
            .setLanguageCode(languageCode)
            .setSsmlGender(MALE)
            .build()

        val audioConfig = AudioConfig.newBuilder()
            .setAudioEncoding(MP3)
            .build()

        val response = client.synthesizeSpeech(input, voice, audioConfig)

        val audioContents = response.audioContent

        val out = FileOutputStream("output.mp3")
        out.write(audioContents.toByteArray())

    }
}