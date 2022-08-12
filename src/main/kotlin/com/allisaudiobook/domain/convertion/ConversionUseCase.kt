package com.allisaudiobook.domain.convertion

import com.allisaudiobook.app.controller.ConversorConfig

class ConversionUseCase(
    val textConversor: TextConversor,
    val textExtractor: TextExtractor,
) {
    fun execute(inputConfig: ConversorConfig) {
        val textInput = textExtractor.execute(inputConfig.inputPdfFile)
        val variableInput = inputConfig.copy(text = textInput)
        textConversor.convert(variableInput)
    }
}