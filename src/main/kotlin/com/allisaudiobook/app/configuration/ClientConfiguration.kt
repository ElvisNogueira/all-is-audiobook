package com.allisaudiobook.app.configuration

import com.allisaudiobook.client.GoogleTextToSpeechClient
import com.google.cloud.texttospeech.v1.TextToSpeechClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ClientConfiguration {
    @Bean
    fun googleTextToSpeechClient(): GoogleTextToSpeechClient = GoogleTextToSpeechClient(TextToSpeechClient.create())

}