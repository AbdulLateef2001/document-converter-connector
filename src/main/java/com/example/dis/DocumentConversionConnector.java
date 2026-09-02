package com.example.dis;

import com.example.dis.service.DocumentConversionService;
import io.camunda.connector.api.annotation.OutboundConnector;
import io.camunda.connector.api.outbound.OutboundConnectorContext;
import io.camunda.connector.api.outbound.OutboundConnectorFunction;

@OutboundConnector(
        name = "Document Converter",
        inputVariables = {"inputFile", "outputFile", "sourceFormat", "targetFormat", "overwrite"},
        type = "io.camunda:documentconversion:1"
)
public class DocumentConversionConnector implements OutboundConnectorFunction {

    private final DocumentConversionService service = new DocumentConversionService();

    @Override
    public Object execute(OutboundConnectorContext context) throws Exception {

        DocumentConversionRequest request = context.bindVariables(DocumentConversionRequest.class);
        return service.convert(request);
    }
}