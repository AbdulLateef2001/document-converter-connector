package com.example.dis.service;

import com.example.dis.DocumentConversionRequest;
import com.example.dis.DocumentConversionResult;

import java.io.File;

public class DocumentConversionService {

    public DocumentConversionResult convert(DocumentConversionRequest request) throws Exception {

        String source = request.getSourceFormat();
        String target = request.getTargetFormat();

        if (source == null || target == null) {
            throw new RuntimeException("Source Format or Target Format is missing.");
        }

        source = source.toLowerCase().trim();
        target = target.toLowerCase().trim();

        if (!request.getInputFile().toLowerCase().endsWith("." + source)) {
            request.setInputFile(request.getInputFile() + "." + source);
        }

        if (!request.getOutputFile().toLowerCase().endsWith("." + target)) {
            request.setOutputFile(request.getOutputFile() + "." + target);
        }

        // NOW create File object
        File inputFile = new File(request.getInputFile());

        System.out.println("Absolute Path : " + inputFile.getAbsolutePath());
        System.out.println("Exists        : " + inputFile.exists());

        if (!inputFile.exists()) {
            throw new RuntimeException(
                    "Input file not found: " + inputFile.getAbsolutePath());
        }
        // Word -> PDF
        if (source.equals("docx") && target.equals("pdf")) {
            return new WordToPdfService().convert(request);
        }

        // PDF -> Word
        if (source.equals("pdf") && target.equals("docx")) {
            return new PdfToWordService().convert(request);
        }

        throw new RuntimeException(
                "Unsupported conversion: " + source + " -> " + target);
    }
}