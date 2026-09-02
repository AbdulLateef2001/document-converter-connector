# Document Converter Connector

This connector enables **Camunda 8** processes to convert documents between **Microsoft Word (.docx)** and **PDF (.pdf)** formats.

Supported conversions:

- Word (.docx) → PDF (.pdf)
- PDF (.pdf) → Word (.docx)

---

# Principle

The connector receives the source document path, destination path, and conversion type as inputs. It performs the requested conversion and generates the output document at the specified location.

---

# Inputs

| Name | Description | Required |
|------|-------------|----------|
| conversionType | WORD_TO_PDF or PDF_TO_WORD | ✅ |
| inputFilePath | Source document path | ✅ |
| outputFilePath | Destination document path | ✅ |

---

# Output

| Name | Description |
|------|-------------|
| success | Conversion status |
| outputFilePath | Path of the converted document |
| message | Success or error message |

---

# Build

```bash
mvn clean package
```

Run locally:

```bash
mvn spring-boot:run
```

---

# Element Template

The element template is available under:

```
src/main/resources/element-templates/document-converter.json
```

---

# Compatibility

- Camunda 8.7+
- Camunda 8.8+
- Camunda 8.9+

---

# License

Apache License 2.0
