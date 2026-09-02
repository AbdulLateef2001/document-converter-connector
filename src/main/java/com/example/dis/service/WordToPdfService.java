package com.example.dis.service;

import com.example.dis.DocumentConversionRequest;
import com.example.dis.DocumentConversionResult;
import org.docx4j.Docx4J;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;

import java.io.File;
import java.io.FileOutputStream;

public class WordToPdfService {

    public DocumentConversionResult convert(DocumentConversionRequest request) throws Exception {

        File inputFile = new File(request.getInputFile());
        File outputFile = new File(request.getOutputFile());

        if (!inputFile.exists()) {
            throw new RuntimeException(
                    "Input file not found: " + inputFile.getAbsolutePath());
        }

        WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.load(inputFile);

        try (FileOutputStream outputStream = new FileOutputStream(outputFile)) {

            Docx4J.toPDF(wordMLPackage, outputStream);
        }

        DocumentConversionResult result = new DocumentConversionResult();
        result.setOutputFile(outputFile.getAbsolutePath());

        return result;
    }
}