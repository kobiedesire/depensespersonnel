/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mae.controller;

import com.itextpdf.io.font.constants.StandardFonts;
import com.mae.bd.connexionBD;
import com.mae.model.Agent;
import com.mae.vue.InterfaceStatistiqueAgentProgramme;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.table.TableModel;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Cell;
import java.io.FileOutputStream;
import java.io.IOException;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Table;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Cell;
import com.mae.controller.PiedDePageController;
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

/**
 *
 * @author hp
 */
public class StatAgentExportPDFByProgrammeController {

    //exporter en pdf
    public static void exportPDF() {
        // Créateur du sélecteur de fichier
        JFileChooser selecteurFichier = new JFileChooser();
        selecteurFichier.setDialogTitle("Sélectionner un emplacement");

        int maSelection = selecteurFichier.showSaveDialog(null);
        if (maSelection == JFileChooser.APPROVE_OPTION) {
            try {
                String chemin = selecteurFichier.getSelectedFile().getAbsolutePath() + ".pdf";
                PdfWriter writer = new PdfWriter(chemin);
                PdfDocument pdfDoc = new PdfDocument(writer);
                pdfDoc.setDefaultPageSize(com.itextpdf.kernel.geom.PageSize.A4.rotate());
                Document document = new Document(pdfDoc);
                // gestion du timbre
                float[] largeurtableau = {600, 400};
                PdfFont police = PdfFontFactory.createFont(StandardFonts.COURIER_BOLD);

                Table table = new Table(largeurtableau); // Largeur des colonnes (proportionnelle)
                table.setAutoLayout(); // Ajuster la largeur du tableau au document
                table.setTextAlignment(TextAlignment.CENTER);
                table.setBorder(com.itextpdf.layout.borders.Border.NO_BORDER);

                table.addCell(new Cell().add(new Paragraph("MINISTERE DES AFFAIRES ETRANGERES, DE LA COOPERATION REGIONALE ET DES BURKINABE DE L'EXTERIEUR")).setBorder(Border.NO_BORDER)).setFont(police);
                table.addCell(new Cell().add(new Paragraph("BURKINA FASO")).setBorder(Border.NO_BORDER)).setFont(police);

                table.addCell(new Cell().add(new Paragraph("***********")).setBorder(Border.NO_BORDER)).setFont(police);
                table.addCell(new Cell().add(new Paragraph("***********")).setBorder(Border.NO_BORDER)).setFont(police);

                table.addCell(new Cell().add(new Paragraph("SECRETARIAT GENERAL")).setBorder(Border.NO_BORDER)).setFont(police);
                table.addCell(new Cell().add(new Paragraph("La patrie ou la mort, nous vaincrons !!")).setBorder(Border.NO_BORDER)).setFont(police);

                table.addCell(new Cell().add(new Paragraph("***********")).setBorder(Border.NO_BORDER)).setFont(police);
                table.addCell(new Cell().add(new Paragraph("")).setBorder(Border.NO_BORDER)).setFont(police);

                table.addCell(new Cell().add(new Paragraph("DIRECTION DES RESSOURCES HUMAINES")).setBorder(Border.NO_BORDER)).setFont(police);
                table.addCell(new Cell().add(new Paragraph("")).setBorder(Border.NO_BORDER)).setFont(police);
                document.add(table);
                
                //ajout d'interligne
                 Paragraph interligne = new Paragraph("")
                .setMultipliedLeading(2.5f); // Interligne de 2.5x
 
                // Ajout d'un titre
                Paragraph title = new Paragraph("EFFECTIF DES AGENTS PAR PROGRAMME BUDGETAIRE")
                        .setFont(police)
                        .setFontSize(16)
                        .setTextAlignment(TextAlignment.CENTER)
                        .setUnderline()
                        .setFontColor(ColorConstants.BLACK);
                
                //  .setTextAlignment(TextAlignment.CENTER);
                document.add(title);

                // Ajouter un paragraphe avec une police normale
                Paragraph paragraph = new Paragraph("Rapport généré par le Système de Gestion des Dépenses du Personnel.")
                        .setFont(PdfFontFactory.createFont("Helvetica"))
                        .setFontSize(9)
                        .setItalic()
                        .setFontColor(ColorConstants.BLACK)
                        .setTextAlignment(TextAlignment.CENTER);                                            
                document.add(paragraph);      
                
                //ajout d'interligne
                 Paragraph interligne2 = new Paragraph("")
                .setMultipliedLeading(2.5f); // Interligne de 2.5x
            
            /**********************************TABLEAU DU DONNEES*************************************************************************/            
                ///tableau de données
                int columnCount = InterfaceStatistiqueAgentProgramme.tableau_agentprogramme.getColumnCount();
                PdfFont policeContenu = PdfFontFactory.createFont(StandardFonts.COURIER);
                float[] largeurtableauDeDonnees = {50, 100, 200, 400, 100, 150 };
                Table pdfTable = new Table(largeurtableauDeDonnees);
                pdfTable.setAutoLayout();               

                // Ajouter les en-têtes
                for (int i = 0; i < columnCount; i++) {
                    pdfTable.addCell(InterfaceStatistiqueAgentProgramme.tableau_agentprogramme.getColumnName(i)).setFont(policeContenu).setTextAlignment(TextAlignment.CENTER);
                 //   pdfTable.addHeaderCell(new Cell().add(InterfaceStatistiqueAgent.tableau_agent.getColumnName(i)).setBackgroundColor(ColorConstants.LIGHT_GRAY));
                }

                // Ajouter les données
                for (int i = 0; i < InterfaceStatistiqueAgentProgramme.tableau_agentprogramme.getRowCount(); i++) {
                    for (int j = 0; j < columnCount; j++) {
                        Object value = InterfaceStatistiqueAgentProgramme.tableau_agentprogramme.getValueAt(i, j);
                        pdfTable.addCell(value != null ? value.toString() : "").setFont(policeContenu);
                    }
                }       
                
                
                // Créer un tableau pour afficher le nombre de resultats
                       Table tableResultat = new Table(new float[]{100, 50}); // Colonnes ajustables
                       PdfFont police2 = PdfFontFactory.createFont(StandardFonts.COURIER_BOLD);
                       tableResultat.setAutoLayout(); // Ajuster la largeur du tableau au document
                       tableResultat.setTextAlignment(TextAlignment.LEFT);
                       tableResultat.setBorder(com.itextpdf.layout.borders.Border.NO_BORDER);
                       
                       String nbResult = (InterfaceStatistiqueAgentProgramme.statNombreEnreg.getText());                
                       tableResultat.addCell(new Cell().add(new Paragraph("NOMBRE D'ENREGISTREMENTS : ")).setBorder(Border.NO_BORDER).setFont(police2));
                       tableResultat.addCell(new Cell().add(new Paragraph(nbResult)).setBorder(Border.NO_BORDER).setFont(police));
                 // Ajouter le tableau au document
                       document.add(tableResultat);
                
                
                // Ajouter un gestionnaire d'événements pour le pied de page
                pdfDoc.addEventHandler(PdfDocumentEvent.END_PAGE, new PiedDePageController());          
                
               
                document.add(pdfTable);
                document.close();
                JOptionPane.showMessageDialog(null, "Document généré avec succès ! ");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }   
    
}
