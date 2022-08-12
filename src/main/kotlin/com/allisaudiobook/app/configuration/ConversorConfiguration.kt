package com.allisaudiobook.app.configuration

import com.allisaudiobook.client.GoogleTextToSpeechClient
import com.allisaudiobook.domain.convertion.ConversionUseCase
import com.allisaudiobook.domain.convertion.TextConversor
import com.allisaudiobook.domain.convertion.TextExtractor
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ConversorConfiguration {
    @Bean
    fun textConversor(client: GoogleTextToSpeechClient): TextConversor = TextConversor(client)

    @Bean
    fun textExtractor(): TextExtractor = TextExtractor()

    @Bean
    fun conversionUseCase(textConversor: TextConversor, textExtractor: TextExtractor): ConversionUseCase =
        ConversionUseCase(textConversor, textExtractor)
}