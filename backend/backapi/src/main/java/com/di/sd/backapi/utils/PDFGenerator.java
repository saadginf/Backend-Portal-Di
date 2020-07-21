package com.di.sd.backapi.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.di.sd.backapi.modals.Theme;
import com.di.sd.backapi.modals.Unite;
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
public class PDFGenerator {
  
  private static Logger logger = LoggerFactory.getLogger(PDFGenerator.class);
  
  public static ByteArrayInputStream customerPDFReport(List<Inventaire> inventaire, Unite unite, Theme theme) {
    Document document = new Document(PageSize.A4.rotate(),10,10,10,10);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        
        try {
          
          PdfWriter.getInstance(document, out);
            document.open();
          
            // Add Text to PDF file ->
          Font font = FontFactory.getFont(FontFactory.TIMES, 13, BaseColor.BLACK);
          

          Paragraph para1 = new Paragraph( "ROYAUME DU MAROC\nFORCES ARMEE ROYALES\nCORPS: "+unite.getLibbele(), font);
          
          document.add(new Paragraph(""));
          







          Paragraph para = new Paragraph( "CATALOGUE INVENTAIRE DES VOLUMES\nModèle 01/DOC/FAR\nDésignation du thèmr des documents: " +theme.getLibbele(), font);
          para.setLeading(15);
         
          Font font2 = FontFactory.getFont(FontFactory.TIMES, 13, BaseColor.BLACK);
          
          
          PdfPTable tableTest = new PdfPTable(3);
          
          tableTest.setWidthPercentage(100);
          tableTest.setWidths(new int[]{1, 2,1});
          PdfPCell cellEmpt = new PdfPCell(new Paragraph(""));
          cellEmpt.setBorder(Rectangle.NO_BORDER);
          tableTest.addCell(cellEmpt);


          PdfPCell cellTitle = new PdfPCell(para);
          cellTitle.setBorder(Rectangle.NO_BORDER);
          cellTitle.setUseAscender(true);
          cellTitle.setVerticalAlignment(Element.ALIGN_MIDDLE);
          cellTitle.setHorizontalAlignment(Element.ALIGN_CENTER);
            tableTest.addCell(cellTitle);

            PdfPCell cellAttache = new PdfPCell(para1);
            cellAttache.setBorder(Rectangle.NO_BORDER);
            cellAttache.setUseAscender(true);
            cellAttache.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cellAttache.setHorizontalAlignment(Element.ALIGN_CENTER);
              tableTest.addCell(cellAttache);

          document.add(tableTest);
          document.add(Chunk.NEWLINE);

          PdfPTable table = new PdfPTable(9);
          table.setWidthPercentage(100);
          table.setWidths(new int[]{1, 2, 3,4,2,2,2,1,1});
        
          // Add PDF Table Header ->
          //  Stream.of("ID", "First Name", "Last Name")
            //  .forEach(headerTitle -> {
              //    PdfPCell header = new PdfPCell();
                //  Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
                  //header.setBackgroundColor(BaseColor.LIGHT_GRAY);
                  //header.setHorizontalAlignment(Element.ALIGN_CENTER);
                  //header.setBorderWidth(2);
                  //header.setPhrase(new Phrase(headerTitle, headFont));
                 // table.addCell(header);
           //   });

           PdfPCell cellnum = new PdfPCell(new Phrase("N°"));
              cellnum.setRowspan(2);
              cellnum.setUseAscender(true);
              cellnum.setVerticalAlignment(Element.ALIGN_MIDDLE);
              cellnum.setHorizontalAlignment(Element.ALIGN_CENTER);
              table.addCell(cellnum);

              PdfPCell cellDate = new PdfPCell(new Phrase("Date"));
              cellDate.setRowspan(2);
              cellnum.setUseAscender(true);
              cellDate.setVerticalAlignment(Element.ALIGN_MIDDLE);
              cellDate.setHorizontalAlignment(Element.ALIGN_CENTER);
              table.addCell(cellDate);
             
             
             
             
             
             
          PdfPCell cell = new PdfPCell(new Phrase("Désignation des documents"));
           
           cell.setColspan(6);
           cell.setUseAscender(true);
           cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
           cell.setHorizontalAlignment(Element.ALIGN_CENTER);
           table.addCell(cell);

           
           PdfPCell cellDatee = new PdfPCell(new Phrase("OBS"));
           cellDatee.setRowspan(2);
           cellDatee.setUseAscender(true);
           cellDatee.setVerticalAlignment(Element.ALIGN_MIDDLE);
           cellDatee.setHorizontalAlignment(Element.ALIGN_CENTER);
           table.addCell(cellDatee);
           
        
           
           
           
           
           PdfPCell cellAut = new PdfPCell(new Phrase("Ateur(s)"));
             
           cellAut.setUseAscender(true);
           cellAut.setVerticalAlignment(Element.ALIGN_MIDDLE);
           cellAut.setHorizontalAlignment(Element.ALIGN_CENTER);
          table.addCell(cellAut);
         
          PdfPCell cellTit = new PdfPCell(new Phrase("Titre"));
          cellTit.setUseAscender(true);
          cellTit.setVerticalAlignment(Element.ALIGN_MIDDLE);
          cellTit.setHorizontalAlignment(Element.ALIGN_CENTER);
         table.addCell(cellTit);

         PdfPCell cellEdit = new PdfPCell(new Phrase("Maison Edition"));
         cellEdit.setUseAscender(true);
         cellEdit.setVerticalAlignment(Element.ALIGN_MIDDLE);
         cellEdit.setHorizontalAlignment(Element.ALIGN_CENTER);
         table.addCell(cellEdit);


         PdfPCell cellAnp = new PdfPCell(new Phrase("Année Publication"));
         cellAnp.setUseAscender(true);
         cellAnp.setVerticalAlignment(Element.ALIGN_MIDDLE);
         cellAnp.setHorizontalAlignment(Element.ALIGN_CENTER);
         table.addCell(cellAnp);

         PdfPCell cellTome = new PdfPCell(new Phrase("Tomes"));
         cellTome.setUseAscender(true);
         cellTome.setVerticalAlignment(Element.ALIGN_MIDDLE);
         cellTome.setHorizontalAlignment(Element.ALIGN_CENTER);
         table.addCell(cellTome);
          
         PdfPCell cellQte = new PdfPCell(new Phrase("Qte"));
         cellQte.setUseAscender(true);
         cellQte.setVerticalAlignment(Element.ALIGN_MIDDLE);
         cellQte.setHorizontalAlignment(Element.ALIGN_CENTER);
         table.addCell(cellQte);


         for (Inventaire inv : inventaire) {
          PdfPCell idCell = new PdfPCell(new Phrase(inv.getNumber(), font2));
          idCell.setPaddingLeft(4);
          idCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
          idCell.setHorizontalAlignment(Element.ALIGN_CENTER);
          idCell.setRowspan(inv.getTomes().size());
          table.addCell(idCell);

            PdfPCell dateAc = new PdfPCell(new Phrase(""+inv.getDate_ac(), font2));
            dateAc.setPaddingLeft(4);
            dateAc.setVerticalAlignment(Element.ALIGN_MIDDLE);
            dateAc.setHorizontalAlignment(Element.ALIGN_CENTER);
            dateAc.setRowspan(inv.getTomes().size());
            table.addCell(dateAc);

            PdfPCell autCell = new PdfPCell(new Phrase(inv.getAuteurs(), font2));
            autCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            autCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            autCell.setPaddingRight(4);
            autCell.setRowspan(inv.getTomes().size());
            table.addCell(autCell);



            PdfPCell titreCell = new PdfPCell(new Phrase(inv.getTitre(), font2));
            titreCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            titreCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            titreCell.setPaddingRight(4);
            titreCell.setRowspan(inv.getTomes().size());
            table.addCell(titreCell);

            PdfPCell editeurCell = new PdfPCell(new Phrase(inv.getEditeur(), font2));
            editeurCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            editeurCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            editeurCell.setPaddingRight(4);
            editeurCell.setRowspan(inv.getTomes().size());

            table.addCell(editeurCell);


            PdfPCell pubCell = new PdfPCell(new Phrase(""+inv.getDate_pub(), font2));
            pubCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            pubCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            pubCell.setPaddingRight(4);
            pubCell.setRowspan(inv.getTomes().size());
          
            table.addCell(pubCell);

            if (inv.getTomes().size()==1) {
              PdfPCell tomcCell = new PdfPCell(new Phrase("-",font2));
              tomcCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
              tomcCell.setHorizontalAlignment(Element.ALIGN_CENTER);
              tomcCell.setPaddingRight(4);
              table.addCell(tomcCell);


              PdfPCell qteCell = new PdfPCell(new Phrase(inv.getQte().get(0).toString(), font2));
              qteCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
              qteCell.setHorizontalAlignment(Element.ALIGN_CENTER);
              qteCell.setPaddingRight(4);
              table.addCell(qteCell);

              PdfPCell obsCell = new PdfPCell(new Phrase("-", font2));
              obsCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
              obsCell.setHorizontalAlignment(Element.ALIGN_CENTER);
              obsCell.setPaddingRight(4);
              table.addCell(obsCell);
            } else {
              for (int i = 0; i < inv.getTomes().size(); i++) {
                PdfPCell obsCell = new PdfPCell(new Phrase(inv.getTomes().get(i), font2));
              obsCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
              obsCell.setHorizontalAlignment(Element.ALIGN_CENTER);
              obsCell.setPaddingRight(4);
              table.addCell(obsCell);
              PdfPCell qteCell = new PdfPCell(new Phrase(inv.getQte().get(i).toString(), font2));
              qteCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
              qteCell.setHorizontalAlignment(Element.ALIGN_CENTER);
              qteCell.setPaddingRight(4);
              table.addCell(qteCell);
              PdfPCell obsfCell = new PdfPCell(new Phrase("-", font2));
              obsfCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
              obsfCell.setHorizontalAlignment(Element.ALIGN_CENTER);
              obsfCell.setPaddingRight(4);
              table.addCell(obsfCell);
              }
             
            }
              
        
        
          }   











         
       
           document.add(table);
            document.close();
        }catch(DocumentException e) {
          logger.error(e.toString());
        }
        
    return new ByteArrayInputStream(out.toByteArray());
  }
}