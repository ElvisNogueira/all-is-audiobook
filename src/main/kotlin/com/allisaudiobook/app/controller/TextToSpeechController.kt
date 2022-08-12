package com.allisaudiobook.app.controller

import com.allisaudiobook.domain.convertion.ConversionUseCase
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TextToSpeechController(
    val conversionUseCase: ConversionUseCase,
) {
    @PostMapping("/convert-text-to-voice/")
    fun convertTextToSpeech(
        @ModelAttribute input: ConversorConfig,
    ) {
        conversionUseCase.execute(inputConfig = input)
    }
}