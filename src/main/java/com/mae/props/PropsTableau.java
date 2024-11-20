/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mae.props;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

/**
 *
 * @author kobie
 */
public class PropsTableau implements TableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel headerLabel = new JLabel(value.toString());
        headerLabel.setOpaque(true);
        headerLabel.setBackground(new java.awt.Color(0, 102, 51)); 
        headerLabel.setForeground(Color.WHITE);
        headerLabel.setFont(new Font("Arial", Font.PLAIN, 14)); 
        headerLabel.setHorizontalAlignment(SwingConstants.LEFT);
        return headerLabel;
    }
    
}
