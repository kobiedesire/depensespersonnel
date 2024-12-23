/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mae.controller;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.kernel.events.IEventHandler;
import com.itextpdf.kernel.events.Event;
import com.itextpdf.kernel.events.PdfDocumentEvent;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hp
 */
public class PiedDePageController implements IEventHandler {
    // Gestionnaire d'événements pour le pied de page

    @Override
    public void handleEvent(Event event) {
        PdfDocumentEvent docEvent = (PdfDocumentEvent) event;
        PdfDocument pdfDoc = docEvent.getDocument();
        PdfPage page = docEvent.getPage();

        // Récupérer les dimensions de la page
        Rectangle pageSize = page.getPageSize();

        // Créer un canvas pour dessiner le pied de page
        PdfCanvas canvas = new PdfCanvas(page);

        // Ajouter le texte du pied de page
        String footerText = "Système de Gestion Dépenses du Personnel - Page " + pdfDoc.getPageNumber(page);

        try {
            // Positionner le texte en bas de la page
            canvas.beginText()
                    .setFontAndSize(com.itextpdf.kernel.font.PdfFontFactory.createFont(), 10)
                    .moveText(pageSize.getWidth() / 2 - 50, pageSize.getBottom() + 20)
                    .showText(footerText)
                    .endText();
        } catch (IOException ex) {
            Logger.getLogger(PiedDePageController.class.getName()).log(Level.SEVERE, null, ex);
        }

        canvas.release();
    }

}
