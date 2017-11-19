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
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Juan Ignacio
 */
public class AltaUsuario extends javax.swing.JFrame{
    
    JPanel panelSuperior, panelMedio, panelInferior;
    JLabel labelAgregar, labelNumeroDNI, labelNombres, labelApellido, labelFechaNac, labelTipoUsuario, labelMail, labelUsuario;
    JTextField textNumeroDNI, textNombres, textApellido, textFechaNac, textMail, textUsuario;
    JComboBox tipoUsuario;
    JButton botonVolver, botonConfirmar;
    
    public AltaUsuario (){
        
        inicializar();
        
    }
    
    public void inicializar(){
        
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setSize(new Dimension(600,600));
        this.setResizable(false);
        this.setTitle("Alta Usuario");
        
        /*DEFINICION PANEL SUPERIOR CON TITULO*/
        
        panelSuperior = new JPanel(new GridBagLayout());
        panelSuperior.setLayout(new GridBagLayout());
        panelSuperior.setBorder(BorderFactory.createMatteBorder(4,4,4,4,Color.darkGray));
        panelSuperior.setBackground(Color.white);        
        
        this.getContentPane().add(panelSuperior, BorderLayout.NORTH);
        
        GridBagConstraints conPanelSuperior = new GridBagConstraints();
       
        Font font = new Font("SansSerif", Font.BOLD, 20);
        
        labelAgregar = new JLabel("ALTA USUARIO");
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
        
        //*****************************************************************//
        
        //numero documento
        
        
        
        labelNumeroDNI = new JLabel("Numero Documento:");
        labelNumeroDNI.setFont(font1);
        
        conPanelMedio.gridx = 0;
        conPanelMedio.gridy = 0;
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
        conPanelMedio.gridy = 0;
        conPanelMedio.anchor = GridBagConstraints.LINE_START;
        
        panelMedio.add(textNumeroDNI, conPanelMedio);
        
        //apellido
                
        labelApellido = new JLabel("Apellido: ");
        labelApellido.setFont(font1);
        
        conPanelMedio.gridx = 0;
        conPanelMedio.gridy = 1;
        conPanelMedio.anchor = GridBagConstraints.LINE_END;
        
        panelMedio.add(labelApellido, conPanelMedio);
        
        
        //text apellido
              
        textApellido = new JFormattedTextField();
        textApellido.setColumns(15);
                        
        conPanelMedio.gridx = 1;
        conPanelMedio.gridy = 1;
        conPanelMedio.anchor = GridBagConstraints.LINE_START;
        
        panelMedio.add(textApellido, conPanelMedio);
    
        
        //nombres
                
        labelNombres = new JLabel("Nombres: ");
        labelNombres.setFont(font1);
        
        conPanelMedio.gridx = 0;
        conPanelMedio.gridy = 2;
        conPanelMedio.anchor = GridBagConstraints.LINE_END;
        
        panelMedio.add(labelNombres, conPanelMedio);
        
        
        //text nombres
              
        textNombres = new JFormattedTextField();
        textNombres.setColumns(20);
                        
        conPanelMedio.gridx = 1;
        conPanelMedio.gridy = 2;
        conPanelMedio.anchor = GridBagConstraints.LINE_START;
        
        panelMedio.add(textNombres, conPanelMedio);
        
        //fecha nacimiento
                
        labelFechaNac = new JLabel("Fecha de Nacimiento:");
        labelFechaNac.setFont(font1);
        
        conPanelMedio.gridx = 0;
        conPanelMedio.gridy = 3;
        conPanelMedio.anchor = GridBagConstraints.LINE_END;
        
        panelMedio.add(labelFechaNac, conPanelMedio);
        
        
        //text fecha nacimiento
        
        MaskFormatter mascaraFechaNac = null;
        try {
            mascaraFechaNac = new MaskFormatter("##/##/####");
            mascaraFechaNac.setPlaceholderCharacter(' ');
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        
        textFechaNac = new JFormattedTextField(mascaraFechaNac);
        textFechaNac.setColumns(8);
                        
        conPanelMedio.gridx = 1;
        conPanelMedio.gridy = 3;
        conPanelMedio.anchor = GridBagConstraints.LINE_START;
        
        panelMedio.add(textFechaNac, conPanelMedio);
        
        //tipo Usuario
        
        labelTipoUsuario = new JLabel("Tipo Usuario:");
        labelTipoUsuario.setFont(font1);
        
        conPanelMedio.gridx = 0;
        conPanelMedio.gridy = 4;
        conPanelMedio.anchor = GridBagConstraints.LINE_END;
        
        panelMedio.add(labelTipoUsuario, conPanelMedio);
        
        //combobox
        
        String[] tiposDocumentos = { "Administrador","Regular" };
        
        tipoUsuario = new JComboBox(tiposDocumentos);
        
        tipoUsuario.setSelectedItem(null);
               
        conPanelMedio.gridx = 1;
        conPanelMedio.gridy = 4;
        conPanelMedio.anchor = GridBagConstraints.LINE_START;
        
        panelMedio.add(tipoUsuario, conPanelMedio);
        
        //mail
                
        labelMail = new JLabel("Email: ");
        labelMail.setFont(font1);
        
        conPanelMedio.gridx = 0;
        conPanelMedio.gridy = 5;
        conPanelMedio.anchor = GridBagConstraints.LINE_END;
        
        panelMedio.add(labelMail, conPanelMedio);
        
        
        //text Mail
              
        textMail = new JFormattedTextField();
        textMail.setColumns(20);
                        
        conPanelMedio.gridx = 1;
        conPanelMedio.gridy = 5;
        conPanelMedio.anchor = GridBagConstraints.LINE_START;
        
        panelMedio.add(textMail, conPanelMedio);
        
        //nombre usuario
                
        labelUsuario = new JLabel("Nombre Usuario: ");
        labelUsuario.setFont(font1);
        
        conPanelMedio.gridx = 0;
        conPanelMedio.gridy = 6;
        conPanelMedio.anchor = GridBagConstraints.LINE_END;
        
        panelMedio.add(labelUsuario, conPanelMedio);
        
        
        //text nombre usuario
              
        textUsuario = new JFormattedTextField();
        textUsuario.setColumns(15);
                        
        conPanelMedio.gridx = 1;
        conPanelMedio.gridy = 6;
        conPanelMedio.anchor = GridBagConstraints.LINE_START;
        
        panelMedio.add(textUsuario, conPanelMedio);
        
        
        /*DEFINICION PANEL INFERIOR CON BOTONES*/
        
        panelInferior = new JPanel(new GridBagLayout());
        panelInferior.setLayout(new GridBagLayout());
        
        
        
        this.getContentPane().add(panelInferior, BorderLayout.SOUTH);
        
        GridBagConstraints conPanelInferior = new GridBagConstraints();
        
        conPanelInferior.insets = new Insets(25, 75, 45, 75);
        
        //*****************************************************//
        
        // boton confirmar
        
        botonConfirmar = new JButton("Confirmar");
        botonConfirmar.setPreferredSize(new Dimension(150,30));
        
        conPanelInferior.gridx = 0;
        conPanelInferior.gridy = 0;
        
        
        conPanelInferior.anchor = GridBagConstraints.CENTER;
        
        panelInferior.add(botonConfirmar, conPanelInferior);
        
        botonConfirmar.addActionListener(new ActionListener() {
           @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonConfirmarActionPerformed(); 
            }
    });
        
        // boton volver
        
        botonVolver = new JButton("Volver");
        botonVolver.setPreferredSize(new Dimension(150,30));
        
        conPanelInferior.gridx = 1;
        conPanelInferior.gridy = 0;
        
        
        conPanelInferior.anchor = GridBagConstraints.CENTER;
        
        panelInferior.add(botonVolver, conPanelInferior);
        
        botonVolver.addActionListener(new ActionListener() {
           @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVolverActionPerformed();
            }
    });
        
    }
    
    public static void main(String args[]){
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                
                    new AltaUsuario().setVisible(true);
                
            }
        });
        
    }
    
    public void botonVolverActionPerformed(){
    
        this.dispose();
    
    }
    
    public void botonConfirmarActionPerformed(){
    
        this.dispose();
    
    }
    
}
