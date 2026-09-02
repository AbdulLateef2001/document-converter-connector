package com.example.dis;

public class DocumentConversionRequest {

    private String inputFile;
    private String outputFile;

    private String sourceFormat;
    private String targetFormat;

    private boolean overwrite;

    public DocumentConversionRequest() {
    }

    public String getInputFile() {
        return inputFile;
    }

    public void setInputFile(String inputFile) {
        this.inputFile = inputFile;
    }

    public String getOutputFile() {
        return outputFile;
    }

    public void setOutputFile(String outputFile) {
        this.outputFile = outputFile;
    }

    public String getSourceFormat() {
        return sourceFormat;
    }

    public void setSourceFormat(String sourceFormat) {
        this.sourceFormat = sourceFormat;
    }

    public String getTargetFormat() {
        return targetFormat;
    }

    public void setTargetFormat(String targetFormat) {
        this.targetFormat = targetFormat;
    }

    public boolean isOverwrite() {
        return overwrite;
    }

    public void setOverwrite(boolean overwrite) {
        this.overwrite = overwrite;
    }

    @Override
    public String toString() {
        return "WordToPdfRequest{" +
                "inputFile='" + inputFile + '\'' +
                ", outputFile='" + outputFile + '\'' +
                ", sourceFormat='" + sourceFormat + '\'' +
                ", targetFormat='" + targetFormat + '\'' +
                ", overwrite=" + overwrite +
                '}';
    }
}