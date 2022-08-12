package com.allisaudiobook.domain.convertion

import com.allisaudiobook.app.exception.FileEncryptedException
import java.io.File
import java.io.FileNotFoundException
import java.io.FileOutputStream
import org.apache.pdfbox.pdmodel.PDDocument
import org.springframework.web.multipart.MultipartFile
import org.apache.pdfbox.text.PDFTextStripper

import org.apache.pdfbox.text.PDFTextStripperByArea

class TextExtractor {
    fun execute(multipartFile: MultipartFile): String {
        try {
            val file = convertMultipartFileToFile(multipartFile)
            val document = PDDocument.load(file)
            var text = ""

            if (!document.isEncrypted) {
                val stripper = PDFTextStripperByArea()
                stripper.sortByPosition = true
                val tStripper = PDFTextStripper()
                val pdfFileInText = tStripper.getText(document)
                val lines = pdfFileInText.split("\\r?\\n").toTypedArray()
                for (line in lines) {
                    text += line
                }
                return text
            } else {
                throw FileEncryptedException("File is encrypted!")
            }
        } catch (exception: FileNotFoundException) {
            throw FileNotFoundException("File not found!")
        }
    }

    private fun convertMultipartFileToFile(multipartFile: MultipartFile): File {
        return try {
            val out = FileOutputStream("PdfTemp.pdf")
            out.write(multipartFile.bytes)
            File("PdfTemp.pdf")
        } catch (exception: FileNotFoundException) {
            throw FileNotFoundException()
        }
    }
}