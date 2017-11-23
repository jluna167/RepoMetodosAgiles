/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import DAO.DAOTitular;
import Entidades.Titular;
import Persistencia.GestorTitular;
import java.awt.Dimension;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Juan Ignacio
 */
public class BusquedaContribuyente extends javax.swing.JFrame{
    
    JLabel labelNumeroDNI, labelTipoDNI, labelAgregar;
    JFormattedTextField textNumeroDNI;
    JButton buttonBuscar, buttonVolver;
    JComboBox<String> tipoDNI;
    JPanel panelSuperior, panelMedio, panelInferior;
    JTable tablaContribuyentes;
    JScrollPane scrollContribuyentes;
    DefaultTableModel formatoTabla;
    Object dataTabla [][];
    GestorTitular gestorTitular;
    Titular titular;
    
    public BusquedaContribuyente (){
        
        inicializar();
        
    }
    
    public void inicializar(){
        
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setSize(new Dimension(800,400));
        this.setResizable(false);
        this.setTitle("Buscar Contribuyente");
        
        /*DEFINICION PANEL SUPERIOR CON TITULO*/
        
        panelSuperior = new JPanel(new GridBagLayout());
        panelSuperior.setLayout(new GridBagLayout());
        panelSuperior.setBorder(BorderFactory.createMatteBorder(4,4,4,4,Color.darkGray));
        panelSuperior.setBackground(Color.white);        
        
        this.getContentPane().add(panelSuperior, BorderLayout.NORTH);
        
        GridBagConstraints conPanelSuperior = new GridBagConstraints();
       
        Font font = new Font("SansSerif", Font.BOLD, 20);
        
        labelAgregar = new JLabel("BUSCAR CONTRIBUYENTE");
        labelAgregar.setFont(font);
        
        conPanelSuperior.gridx = 0;
        conPanelSuperior.gridy = 0;
        
        panelSuperior.add(labelAgregar, conPanelSuperior);
        
        //--------------------------------------------------------------//
        
        /*DEFINICION PANEL MEDIO CON ELEMENTOS DE BUSQUEDA*/
        
        panelMedio = new JPanel(new GridBagLayout());
        panelMedio.setLayout(new GridBagLayout());
        
        
        this.getContentPane().add(panelMedio, BorderLayout.CENTER);
        
        GridBagConstraints conPanelMedio = new GridBagConstraints();
        
        conPanelMedio.insets = new Insets(5, 5, 15, 5);
        
        Font font1 = new Font("SansSerif", Font.BOLD, 14);
        
        //tipo documento
        
        labelTipoDNI = new JLabel("Tipo Documento:");
        labelTipoDNI.setFont(font1);
        
        conPanelMedio.gridx = 0;
        conPanelMedio.gridy = 1;
        conPanelMedio.anchor = GridBagConstraints.LINE_START;
        
        panelMedio.add(labelTipoDNI, conPanelMedio);
        
        //combobox
        
        String[] tiposDocumentos = { "DNI","LC","LE","Pasaporte" };
        
        tipoDNI = new JComboBox(tiposDocumentos);
        
        tipoDNI.setSelectedIndex(0);
               
        conPanelMedio.gridx = 1;
        conPanelMedio.gridy = 1;
        
        panelMedio.add(tipoDNI, conPanelMedio);
        
        
        //numero documento
        
        
        
        labelNumeroDNI = new JLabel("Numero Documento:");
        labelNumeroDNI.setFont(font1);
        
        conPanelMedio.gridx = 0;
        conPanelMedio.gridy = 2;
        conPanelMedio.anchor = GridBagConstraints.LINE_START;
        
        panelMedio.add(labelNumeroDNI, conPanelMedio);
        
        
        //text numero dni
        
        MaskFormatter mascaraDNI = null;
        try {
            mascaraDNI = new MaskFormatter("########");
            mascaraDNI.setPlaceholderCharacter(' ');
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        
        textNumeroDNI = new JFormattedTextField(mascaraDNI);
        textNumeroDNI.setColumns(8);
                
        conPanelMedio.gridx = 1;
        conPanelMedio.gridy = 2;
        conPanelMedio.anchor = GridBagConstraints.LINE_START;
        
        panelMedio.add(textNumeroDNI, conPanelMedio);
        
        
        //button buscar
        
        buttonBuscar = new JButton("Buscar Contribuyente");
        buttonBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonBuscarActionPerformed(e);
            }
        });
        
        conPanelMedio.gridx = 1;
        conPanelMedio.gridy = 3;
        conPanelMedio.anchor = GridBagConstraints.LINE_START;
        
        panelMedio.add(buttonBuscar, conPanelMedio);
        
        
        /*DEFINICION PANEL INFERIOR CON ELEMENTOS*/
        
        panelInferior = new JPanel(new GridBagLayout());
        panelInferior.setLayout(new GridBagLayout());
        
        
        this.getContentPane().add(panelInferior, BorderLayout.SOUTH);
        
        GridBagConstraints conPanelInferior = new GridBagConstraints();
        
        conPanelInferior.insets = new Insets(5, 5, 55, 5);
        
        
       
        
        //jbutton inferior para confirmar
        
        
        buttonVolver = new JButton("Volver");
        buttonVolver.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverActionPerformed();
            }
        });
        
        
        conPanelInferior.gridy = 1;
        conPanelInferior.anchor = GridBagConstraints.CENTER;
        conPanelInferior.fill = GridBagConstraints.NONE;
        conPanelInferior.insets = new Insets(15, 5, 55, 0);
        
        panelInferior.add(buttonVolver, conPanelInferior);
        
    }
    
    public static void main(String args[]){
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                
                    new BusquedaContribuyente().setVisible(true);
                
            }
        });
        
    }

    private void buttonBuscarActionPerformed(java.awt.event.ActionEvent evt) {
        if (textNumeroDNI.getText().contains(" ")){
             JOptionPane.showMessageDialog(this,"El DNI debe tener 8 digitos.", "Error", JOptionPane.ERROR_MESSAGE);                
        }
 
        else{
            gestorTitular = new GestorTitular();
            titular = new Titular();
            titular.dni = Integer.parseInt(textNumeroDNI.getText());
            if (gestorTitular.existeTitular(titular)){
                
                int respuesta = JOptionPane.showConfirmDialog(null, "El usuario ya está dado de alta como titular, ¿desea emitirle una licencia?","ATENCION",JOptionPane.YES_NO_OPTION);
                
                if(respuesta == JOptionPane.YES_OPTION){
                
                    gestorTitular.cargarTitular(titular);
                    new EmitirLicencia(titular).setVisible(true);
                    this.dispose();
                
                }
            }
            else if (gestorTitular.esContribuyente(titular) || !gestorTitular.existeTitular(titular)){
                 
                 int respuesta = JOptionPane.showConfirmDialog(null, "El usuario es contribuyente pero no ha sido dado de alta como titular, ¿desea hacerlo ahora?","ATENCION",JOptionPane.YES_NO_OPTION);
                
                 if(respuesta == JOptionPane.YES_OPTION){
                     
                    gestorTitular.cargarContribuyente(titular); 
                    new AltaTitular(titular).setVisible(true);
                    this.dispose();
                 }
                 
                 
            }
            else{
                JOptionPane.showMessageDialog(this,"El DNI ingresado no está cargado como Contribuyente", "Error", JOptionPane.ERROR_MESSAGE);                
            }
        }
    } 
    
    private void volverActionPerformed() {
        this.dispose(); 
    }
}
