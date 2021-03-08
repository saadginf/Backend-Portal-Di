package com.di.sd.backapi.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.di.sd.backapi.pftransapi.formations.SessionFormation;
import com.di.sd.backapi.pftransapi.inscription.InscriptionResponse;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Rectangle;

public class PDFGeneratorIns {

  private static Logger logger = LoggerFactory.getLogger(PDFGenerator.class);

  public static ByteArrayInputStream customerPDFReport(SessionFormation sForm, List<InscriptionResponse> isn,
      String retenue) {
    Document document = new Document(PageSize.A4, 10, 10, 10, 10);
    ByteArrayOutputStream out = new ByteArrayOutputStream();

    try {

      PdfWriter.getInstance(document, out);
      document.open();

      // Add Text to PDF file ->
      Font font = FontFactory.getFont(FontFactory.TIMES, 13, BaseColor.BLACK);

      Paragraph para1 = new Paragraph("", font);

      document.add(new Paragraph(""));

      Paragraph para = new Paragraph("Liste nominative des militaires " + retenue + "\n"
          + sForm.getFormation().getLabel() + "\n" + sForm.getLabel(), font);
      para.setLeading(15);

      Font font2 = FontFactory.getFont(FontFactory.TIMES, 13, BaseColor.BLACK);

      PdfPTable tableTest = new PdfPTable(3);

      tableTest.setWidthPercentage(100);
      tableTest.setWidths(new int[] { 1, 2, 1 });
      PdfPCell cellEmpt = new PdfPCell(new Paragraph(""));
      cellEmpt.setBorder(Rectangle.NO_BORDER);
      tableTest.addCell(cellEmpt);

      PdfPCell cellUnitele = new PdfPCell(para);
      cellUnitele.setBorder(Rectangle.NO_BORDER);
      cellUnitele.setUseAscender(true);
      cellUnitele.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cellUnitele.setHorizontalAlignment(Element.ALIGN_CENTER);
      tableTest.addCell(cellUnitele);

      PdfPCell cellAttache = new PdfPCell(para1);
      cellAttache.setBorder(Rectangle.NO_BORDER);
      cellAttache.setUseAscender(true);
      cellAttache.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cellAttache.setHorizontalAlignment(Element.ALIGN_CENTER);
      tableTest.addCell(cellAttache);

      document.add(tableTest);
      document.add(Chunk.NEWLINE);

      PdfPTable table = new PdfPTable(6);
      table.setWidthPercentage(100);
      table.setWidths(new int[] { 1, 2, 2, 2, 3, 2 });

      // Add PDF Table Header ->
      // Stream.of("ID", "First Name", "Last Name")
      // .forEach(headerTitle -> {
      // PdfPCell header = new PdfPCell();
      // Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
      // header.setBackgroundColor(BaseColor.LIGHT_GRAY);
      // header.setHorizontalAlignment(Element.ALIGN_CENTER);
      // header.setBorderWidth(2);
      // header.setPhrase(new Phrase(headerTitle, headFont));
      // table.addCell(header);
      // });

      PdfPCell cellnum = new PdfPCell(new Phrase("N°"));
      cellnum.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cellnum.setHorizontalAlignment(Element.ALIGN_CENTER);
      table.addCell(cellnum);

      PdfPCell cell = new PdfPCell(new Phrase("Prénom"));
      cell.setUseAscender(true);
      cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cell.setHorizontalAlignment(Element.ALIGN_CENTER);
      table.addCell(cell);

      PdfPCell cellNom = new PdfPCell(new Phrase("Nom"));

      cellnum.setUseAscender(true);
      cellNom.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cellNom.setHorizontalAlignment(Element.ALIGN_CENTER);
      table.addCell(cellNom);

      PdfPCell cellGrade = new PdfPCell(new Phrase("Grade"));
      cellGrade.setUseAscender(true);
      cellGrade.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cellGrade.setHorizontalAlignment(Element.ALIGN_CENTER);
      table.addCell(cellGrade);

      PdfPCell cellMle = new PdfPCell(new Phrase("Mle"));

      cellMle.setUseAscender(true);
      cellMle.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cellMle.setHorizontalAlignment(Element.ALIGN_CENTER);
      table.addCell(cellMle);

      PdfPCell cellUnite = new PdfPCell(new Phrase("Unité"));
      cellUnite.setUseAscender(true);
      cellUnite.setVerticalAlignment(Element.ALIGN_MIDDLE);
      cellUnite.setHorizontalAlignment(Element.ALIGN_CENTER);
      table.addCell(cellUnite);

      int i = 1;

      for (InscriptionResponse inv : isn) {

        PdfPCell idCell = new PdfPCell(new Phrase("" + i, font2));
        idCell.setPaddingLeft(4);
        idCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        idCell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(idCell);

        PdfPCell prenom = new PdfPCell(new Phrase(inv.getPrenom(), font2));
        prenom.setPaddingLeft(4);
        prenom.setVerticalAlignment(Element.ALIGN_MIDDLE);
        prenom.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(prenom);

        PdfPCell nom = new PdfPCell(new Phrase(inv.getNom(), font2));
        nom.setVerticalAlignment(Element.ALIGN_MIDDLE);
        nom.setHorizontalAlignment(Element.ALIGN_CENTER);
        nom.setPaddingRight(4);
        table.addCell(nom);

        PdfPCell grade = new PdfPCell(new Phrase(inv.getGrade(), font2));
        grade.setVerticalAlignment(Element.ALIGN_MIDDLE);
        grade.setHorizontalAlignment(Element.ALIGN_CENTER);
        grade.setPaddingRight(4);
        table.addCell(grade);

        PdfPCell mle = new PdfPCell(new Phrase(inv.getMle(), font2));
        mle.setVerticalAlignment(Element.ALIGN_MIDDLE);
        mle.setHorizontalAlignment(Element.ALIGN_CENTER);
        mle.setPaddingRight(4);
        table.addCell(mle);

        PdfPCell unite = new PdfPCell(new Phrase(inv.getUnite(), font2));
        unite.setVerticalAlignment(Element.ALIGN_MIDDLE);
        unite.setHorizontalAlignment(Element.ALIGN_CENTER);
        unite.setPaddingRight(4);
        table.addCell(unite);

        i++;

      }

      document.add(table);
      document.close();
    } catch (DocumentException e) {
      logger.error(e.toString());
    }

    return new ByteArrayInputStream(out.toByteArray());
  }
}