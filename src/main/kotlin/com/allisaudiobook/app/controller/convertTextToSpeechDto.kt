package com.allisaudiobook.app.controller

data class ConvertTextToSpeechDto(
    val text: String,
    val languageCode: String,
    val format: String
)
