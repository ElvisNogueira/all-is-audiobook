package com.allisaudiobook.app.configuration

import com.allisaudiobook.client.GoogleTextToSpeechClient
import com.allisaudiobook.domain.convertion.TextConversor
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ConversorConfiguration {
    @Bean
    fun textConversor(client: GoogleTextToSpeechClient): TextConversor = TextConversor(client)
}