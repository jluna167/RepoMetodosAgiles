/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.awt.*;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Juan Ignacio
 */
public class ListarLicencias extends javax.swing.JFrame{
    
    JPanel panelSuperior, panelMedio, panelInferior;
    JLabel labelAgregar;
    JButton botonVigentes, botonVencidas;
    JTable tabla;
    JScrollPane scroll;
    DefaultTableModel formatoTabla;
    Object dataTabla [][];
    
    public ListarLicencias (){
                
        inicializar();
        
    }
    
    public void inicializar(){
    
    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setSize(new Dimension(700,500));
        this.setResizable(false);
        this.setTitle("Listar Licencias");
        
        /*DEFINICION PANEL SUPERIOR CON TITULO*/
        
        panelSuperior = new JPanel(new GridBagLayout());
        panelSuperior.setLayout(new GridBagLayout());
        panelSuperior.setBorder(BorderFactory.createMatteBorder(4,4,4,4,Color.darkGray));
        panelSuperior.setBackground(Color.white);        
        
        this.getContentPane().add(panelSuperior, BorderLayout.NORTH);
        
        GridBagConstraints conPanelSuperior = new GridBagConstraints();
       
        Font font = new Font("SansSerif", Font.BOLD, 20);
        
        labelAgregar = new JLabel("LISTAR LICENCIAS");
        labelAgregar.setFont(font);
        
        conPanelSuperior.gridx = 0;
        conPanelSuperior.gridy = 0;
        
        panelSuperior.add(labelAgregar, conPanelSuperior);
        
        //*******************************************************//
        
        /*DEFINICION PANEL MEDIO CON ELEMENTOS DE BUSQUEDA*/
        
        panelMedio = new JPanel(new GridBagLayout());
        panelMedio.setLayout(new GridBagLayout());
        
        
        this.getContentPane().add(panelMedio, BorderLayout.CENTER);
        
        GridBagConstraints conPanelMedio = new GridBagConstraints();
        
        conPanelMedio.insets = new Insets(5, 5, 15, 5);
        
        
        
        //***************************************************//
        
         // boton Vigentes
        
        botonVigentes = new JButton("Vigentes");
        botonVigentes.setPreferredSize(new Dimension(150,30));
        
        conPanelMedio.gridx = 0;
        conPanelMedio.gridy = 0;
        
        
        conPanelMedio.anchor = GridBagConstraints.CENTER;
        
        panelMedio.add(botonVigentes, conPanelMedio);
        
        botonVigentes.addActionListener(new ActionListener() {
           @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVigentesActionPerformed();
            }
    });
        
        // boton vencidas
        
        botonVencidas = new JButton("Vencidas");
        botonVencidas.setPreferredSize(new Dimension(150,30));
        
        conPanelMedio.gridx = 1;
        conPanelMedio.gridy = 0;
        
        
        conPanelMedio.anchor = GridBagConstraints.CENTER;
        
        panelMedio.add(botonVencidas, conPanelMedio);
        
        botonVencidas.addActionListener(new ActionListener() {
           @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVencidasActionPerformed();
            }
    });
        /*DEFINICION PANEL INFERIOR CON */
        
        panelInferior = new JPanel(new GridBagLayout());
        panelInferior.setLayout(new GridBagLayout());
        
        
        this.getContentPane().add(panelInferior, BorderLayout.SOUTH);
        
        GridBagConstraints conPanelInferior = new GridBagConstraints();
        
        conPanelInferior.insets = new Insets(5, 5, 15, 5);
        
        
        
        //Tabla con scroll pane
        
        String[] columnas = {"llenar"};
        formatoTabla = new DefaultTableModel(dataTabla, columnas);
        tabla = new JTable(formatoTabla);
        tabla.setDragEnabled(true);
        
        tabla.getColumnModel().getColumn(0).setMinWidth(50);
        tabla.setPreferredSize(new Dimension(100,190));
        scroll = new JScrollPane(tabla, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setPreferredSize(new Dimension(100,150));
        tabla.setDragEnabled(true);
        tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        tabla.setDropMode(DropMode.INSERT_ROWS);
        
        conPanelInferior.gridx=0;
        conPanelInferior.gridy=2;
        conPanelInferior.weightx = 1;
        conPanelInferior.fill = GridBagConstraints.HORIZONTAL;
        
        panelInferior.add(scroll,conPanelInferior);
    }
    
    public static void main(String args[]){
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                
                    new ListarLicencias().setVisible(true);
                
            }
        });
        
    }
    
    public void botonVigentesActionPerformed(){
    
        this.dispose();
    
    }
    
    public void botonVencidasActionPerformed(){
    
        this.dispose();
    
    }
}
