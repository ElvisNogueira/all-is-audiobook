package com.allisaudiobook.app.controller

import org.springframework.web.multipart.MultipartFile

data class ConversorConfig(
    val text: String,
    val languageCode: String,
    val format: String,
    val inputPdfFile: MultipartFile,
    val outputFileName: String,
    val outputUrl: String,
)
