package com.example.dis.service;

import com.example.dis.DocumentConversionRequest;
import com.example.dis.DocumentConversionResult;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.File;
import java.io.FileOutputStream;

public class PdfToWordService {

    public DocumentConversionResult convert(DocumentConversionRequest request) throws Exception {
        File inputFile = new File(request.getInputFile());
        File outputFile = new File(request.getOutputFile());

        if (!inputFile.exists()) {
            throw new RuntimeException("Input file not found: " + inputFile.getAbsolutePath());
        }

        String extractedText;
        try (PDDocument pdf = Loader.loadPDF(inputFile)) {
            PDFTextStripper stripper = new PDFTextStripper();
            extractedText = stripper.getText(pdf);
        }

        try (XWPFDocument word = new XWPFDocument()) {
            String[] lines = extractedText.split("\\r?\\n");

            for (String line : lines) {
                XWPFParagraph paragraph = word.createParagraph();
                XWPFRun run = paragraph.createRun();
                run.setText(line);
            }

            try (FileOutputStream out = new FileOutputStream(outputFile)) {
                word.write(out);
            }
        }

        DocumentConversionResult result = new DocumentConversionResult();
        result.setSuccess(true);
        result.setOutputFile(outputFile.getAbsolutePath());
        result.setMessage("PDF converted successfully (plain text, editable).");
        return result;
    }
}