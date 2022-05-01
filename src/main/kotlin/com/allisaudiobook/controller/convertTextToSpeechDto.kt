package com.allisaudiobook.controller

data class ConvertTextToSpeechDto(
    val text: String,
    val languageCode: String,
)
