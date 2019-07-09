package com.milkyweb.service;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfVersion;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.WriterProperties;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.VerticalAlignment;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;

@Service
public class PdfCreatorService {
    private static final String DEST = "D:/PDF/demo.pdf";

    public void createPdfFile() {
        PdfWriter writer = null;

        try {
            writer = new PdfWriter(DEST, new WriterProperties().setPdfVersion(PdfVersion.PDF_2_0));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        PdfDocument pdfDocument = new PdfDocument(writer);
        pdfDocument.setTagged();
        Document document = new Document(pdfDocument);

        document.add(new Paragraph("Rate & Load Confirmation"));


        Table table = new Table(3);
        Cell cell = new Cell(1, 3)
                .setTextAlignment(TextAlignment.CENTER)
                .add(new Paragraph("Cell with colspan 3"));
        table.addCell(cell);
        cell = new Cell(2, 1)
                .add(new Paragraph("Cell with rowspan 2"))
                .setVerticalAlignment(VerticalAlignment.MIDDLE);
        table.addCell(cell);
        table.addCell("Cell 1.1");
        table.addCell(new Cell().add(new Paragraph("Cell 1.2")));
        table.addCell(new Cell()
                .add(new Paragraph("Cell 2.1"))
                .setMargin(5));
        table.addCell(new Cell()
                .add(new Paragraph("Cell 1.2"))
                .setPadding(5));
        document.add(table);

        document.close();
    }

}
