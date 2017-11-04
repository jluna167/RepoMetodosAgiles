/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Entidades.DTOTitular;
import Persistencia.GestorTitular;
import java.awt.*;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Date;
import javax.swing.*;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Juan Ignacio
 */
public class AltaTitular extends javax.swing.JFrame{
    
    DTOTitular titular;
    GestorTitular gestor;
    JPanel panelSuperior, panelMedio, panelInferior;
    JLabel labelAgregar, labelTipoDocumento, labelNroDocumento, labelApellido, labelNombres, 
            labelFechaNac, labelCalle, labelNumero, labelPiso, labelDepartamento, labelPais,
            labelProvincia, labelLocalidad, labelTipoSanguineo, labelFactor, labelDonante;
    JComboBox tipoDocumento, tipoSanguineo, tipoFactor, tipoDonante;
    JTextField textNroDocumento, textApellido, textNombres, textFechaNac, textCalle, textNumero, 
            textPiso, textDepartamento, textPais, textProvincia, textLocalidad;
    JButton buttonConfirmar, buttonVolver;
    
    
    public AltaTitular (){
        
        inicializar();
        
    }
    
    public void inicializar(){
    
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setSize(new Dimension(900,900));
        this.setResizable(false);
        this.setTitle("Emitir Licencia");
        
        /*DEFINICION PANEL SUPERIOR CON TITULO*/
        
        panelSuperior = new JPanel(new GridBagLayout());
        panelSuperior.setLayout(new GridBagLayout());
        panelSuperior.setBorder(BorderFactory.createMatteBorder(4,4,4,4,Color.darkGray));
        panelSuperior.setBackground(Color.white);        
        
        this.getContentPane().add(panelSuperior, BorderLayout.NORTH);
        
        GridBagConstraints conPanelSuperior = new GridBagConstraints();
       
        Font font = new Font("SansSerif", Font.BOLD, 20);
        
        labelAgregar = new JLabel("ALTA TITULAR");
        labelAgregar.setFont(font);
        
        conPanelSuperior.gridx = 0;
        conPanelSuperior.gridy = 0;
        
        panelSuperior.add(labelAgregar, conPanelSuperior);
        
        
        /*DEFINICION PANEL MEDIO CON ELEMENTOS DE BUSQUEDA*/
        
        panelMedio = new JPanel(new GridBagLayout());
        panelMedio.setLayout(new GridBagLayout());
        
        
        this.getContentPane().add(panelMedio, BorderLayout.CENTER);
        
        GridBagConstraints conPanelMedio = new GridBagConstraints();
        
        conPanelMedio.insets = new Insets(5, 5, 15, 5);
        
        Font font1 = new Font("SansSerif", Font.BOLD, 14);
        
        //tipo documento
        
        labelTipoDocumento = new JLabel("Tipo Documento:");
        labelTipoDocumento.setFont(font1);
        
        conPanelMedio.gridx = 0;
        conPanelMedio.gridy = 1;
        conPanelMedio.anchor = GridBagConstraints.LINE_END;
        
        panelMedio.add(labelTipoDocumento, conPanelMedio);
        
        //combobox
        
        String[] tiposDocumentos = { "DNI","LE","LC" };
        
        tipoDocumento = new JComboBox(tiposDocumentos);
        
        tipoDocumento.setSelectedItem(0);
               
        conPanelMedio.gridx = 1;
        conPanelMedio.gridy = 1;
        conPanelMedio.anchor = GridBagConstraints.LINE_START;
        
        panelMedio.add(tipoDocumento, conPanelMedio);
        
        
        //numero documento
                
        labelNroDocumento = new JLabel("Numero Documento: ");
        labelNroDocumento.setFont(font1);
        
        conPanelMedio.gridx = 0;
        conPanelMedio.gridy = 2;
        conPanelMedio.anchor = GridBagConstraints.LINE_END;
        
        panelMedio.add(labelNroDocumento, conPanelMedio);
        
        
        //text numero documento
        
              
        textNroDocumento = new JFormattedTextField();
        textNroDocumento.setColumns(8);
                        
        conPanelMedio.gridx = 1;
        conPanelMedio.gridy = 2;
        conPanelMedio.anchor = GridBagConstraints.LINE_START;
        
        panelMedio.add(textNroDocumento, conPanelMedio);
        
        
        //apellido
                
        labelApellido = new JLabel("Apellido: ");
        labelApellido.setFont(font1);
        
        conPanelMedio.gridx = 0;
        conPanelMedio.gridy = 3;
        conPanelMedio.anchor = GridBagConstraints.LINE_END;
        
        panelMedio.add(labelApellido, conPanelMedio);
        
        
        //text apellido
              
        textApellido = new JFormattedTextField();
        textApellido.setColumns(15);
                        
        conPanelMedio.gridx = 1;
        conPanelMedio.gridy = 3;
        conPanelMedio.anchor = GridBagConstraints.LINE_START;
        
        panelMedio.add(textApellido, conPanelMedio);
    
        
        //nombres
                
        labelNombres = new JLabel("Nombres: ");
        labelNombres.setFont(font1);
        
        conPanelMedio.gridx = 0;
        conPanelMedio.gridy = 4;
        conPanelMedio.anchor = GridBagConstraints.LINE_END;
        
        panelMedio.add(labelNombres, conPanelMedio);
        
        
        //text nombres
              
        textNombres = new JFormattedTextField();
        textNombres.setColumns(20);
                        
        conPanelMedio.gridx = 1;
        conPanelMedio.gridy = 4;
        conPanelMedio.anchor = GridBagConstraints.LINE_START;
        
        panelMedio.add(textNombres, conPanelMedio);
        
        
        //fecha nacimiento
                
        labelFechaNac = new JLabel("Fecha de Nacimiento:");
        labelFechaNac.setFont(font1);
        
        conPanelMedio.gridx = 0;
        conPanelMedio.gridy = 5;
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
        conPanelMedio.gridy = 5;
        conPanelMedio.anchor = GridBagConstraints.LINE_START;
        
        panelMedio.add(textFechaNac, conPanelMedio);
        
        
        //calle
                
        labelCalle = new JLabel("Calle: ");
        labelCalle.setFont(font1);
        
        conPanelMedio.gridx = 0;
        conPanelMedio.gridy = 6;
        conPanelMedio.anchor = GridBagConstraints.LINE_END;
        
        panelMedio.add(labelCalle, conPanelMedio);
        
        
        //text calle
              
        textCalle = new JFormattedTextField();
        textCalle.setColumns(30);
                        
        conPanelMedio.gridx = 1;
        conPanelMedio.gridy = 6;
        conPanelMedio.anchor = GridBagConstraints.LINE_START;
        
        panelMedio.add(textCalle, conPanelMedio);
        
        
        //numero
                
        labelNumero = new JLabel("Numero: ");
        labelNumero.setFont(font1);
        
        conPanelMedio.gridx = 0;
        conPanelMedio.gridy = 7;
        conPanelMedio.anchor = GridBagConstraints.LINE_END;
        
        panelMedio.add(labelNumero, conPanelMedio);
        
        
        //text numero
              
        textNumero = new JFormattedTextField();
        textNumero.setColumns(5);
                        
        conPanelMedio.gridx = 1;
        conPanelMedio.gridy = 7;
        conPanelMedio.anchor = GridBagConstraints.LINE_START;
        
        panelMedio.add(textNumero, conPanelMedio);
        
        
        //Piso
                
        labelPiso = new JLabel("Piso: ");
        labelPiso.setFont(font1);
        
        conPanelMedio.gridx = 0;
        conPanelMedio.gridy = 8;
        conPanelMedio.anchor = GridBagConstraints.LINE_END;
        
        panelMedio.add(labelPiso, conPanelMedio);
        
        
        //text Piso
              
        textPiso = new JFormattedTextField();
        textPiso.setColumns(3);
                        
        conPanelMedio.gridx = 1;
        conPanelMedio.gridy = 8;
        conPanelMedio.anchor = GridBagConstraints.LINE_START;
        
        panelMedio.add(textPiso, conPanelMedio);
        
        
        //Departamento
                
        labelDepartamento = new JLabel("Departamento: ");
        labelDepartamento.setFont(font1);
        
        conPanelMedio.gridx = 0;
        conPanelMedio.gridy = 9;
        conPanelMedio.anchor = GridBagConstraints.LINE_END;
        
        panelMedio.add(labelDepartamento, conPanelMedio);
        
        
        //text Departamento
              
        textDepartamento = new JFormattedTextField();
        textDepartamento.setColumns(3);
                        
        conPanelMedio.gridx = 1;
        conPanelMedio.gridy = 9;
        conPanelMedio.anchor = GridBagConstraints.LINE_START;
        
        panelMedio.add(textDepartamento, conPanelMedio);
        
        
        //Pais
                
        labelPais = new JLabel("Pais: ");
        labelPais.setFont(font1);
        
        conPanelMedio.gridx = 0;
        conPanelMedio.gridy = 10;
        conPanelMedio.anchor = GridBagConstraints.LINE_END;
        
        panelMedio.add(labelPais, conPanelMedio);
        
        
        //text Pais
              
        textPais = new JFormattedTextField("Argentina");
        textPais.setEditable(false);
                        
        conPanelMedio.gridx = 1;
        conPanelMedio.gridy = 10;
        conPanelMedio.anchor = GridBagConstraints.LINE_START;
        
        panelMedio.add(textPais, conPanelMedio);
        
        
        //Provincia
                
        labelProvincia = new JLabel("Provincia: ");
        labelProvincia.setFont(font1);
        
        conPanelMedio.gridx = 0;
        conPanelMedio.gridy = 11;
        conPanelMedio.anchor = GridBagConstraints.LINE_END;
        
        panelMedio.add(labelProvincia, conPanelMedio);
        
        
        //text Provincia
              
        textProvincia = new JFormattedTextField("Santa Fe");
        textProvincia.setEditable(false);
                        
        conPanelMedio.gridx = 1;
        conPanelMedio.gridy = 11;
        conPanelMedio.anchor = GridBagConstraints.LINE_START;
        
        panelMedio.add(textProvincia, conPanelMedio);
        
        
        //Localidad
                
        labelLocalidad = new JLabel("Localidad: ");
        labelLocalidad.setFont(font1);
        
        conPanelMedio.gridx = 0;
        conPanelMedio.gridy = 12;
        conPanelMedio.anchor = GridBagConstraints.LINE_END;
        
        panelMedio.add(labelLocalidad, conPanelMedio);
        
        
        //text Localidad
              
        textLocalidad = new JFormattedTextField();
        textLocalidad.setColumns(30);
                        
        conPanelMedio.gridx = 1;
        conPanelMedio.gridy = 12;
        conPanelMedio.anchor = GridBagConstraints.LINE_START;
        
        panelMedio.add(textLocalidad, conPanelMedio);
        
        
        //grupo sanguineo
        
        labelTipoSanguineo = new JLabel("Grupo Sanguineo:");
        labelTipoSanguineo.setFont(font1);
        
        conPanelMedio.gridx = 0;
        conPanelMedio.gridy = 13;
        conPanelMedio.anchor = GridBagConstraints.LINE_END;
        
        panelMedio.add(labelTipoSanguineo, conPanelMedio);
        
        //combobox
        
        String[] tiposSanguineos = { "A","B","AB","0" };
        
        tipoSanguineo = new JComboBox(tiposSanguineos);
        
        tipoSanguineo.setSelectedItem(null);
               
        conPanelMedio.gridx = 1;
        conPanelMedio.gridy = 13;
        conPanelMedio.anchor = GridBagConstraints.LINE_START;
        
        panelMedio.add(tipoSanguineo, conPanelMedio);
        
        
        //grupo sanguineo
        
        labelFactor = new JLabel("Factor:");
        labelFactor.setFont(font1);
        
        conPanelMedio.gridx = 0;
        conPanelMedio.gridy = 14;
        conPanelMedio.anchor = GridBagConstraints.LINE_END;
        
        panelMedio.add(labelFactor, conPanelMedio);
        
        //combobox
        
        String[] tiposFactor = { "Positivo","Negativo" };
        
        tipoFactor = new JComboBox(tiposFactor);
        
        tipoFactor.setSelectedItem(null);
               
        conPanelMedio.gridx = 1;
        conPanelMedio.gridy = 14;
        conPanelMedio.anchor = GridBagConstraints.LINE_START;
        
        panelMedio.add(tipoFactor, conPanelMedio);
        
        
        //Donante
        
        labelDonante = new JLabel("Donante:");
        labelDonante.setFont(font1);
        
        conPanelMedio.gridx = 0;
        conPanelMedio.gridy = 15;
        conPanelMedio.anchor = GridBagConstraints.LINE_END;
        
        panelMedio.add(labelDonante, conPanelMedio);
        
        //combobox
        
        String[] tiposDonante = { "SI","NO" };
        
        tipoDonante = new JComboBox(tiposDonante);
        
        tipoDonante.setSelectedItem(null);
               
        conPanelMedio.gridx = 1;
        conPanelMedio.gridy = 15;
        conPanelMedio.anchor = GridBagConstraints.LINE_START;
        
        panelMedio.add(tipoDonante, conPanelMedio);
        
        
        /*DEFINICION PANEL INFERIOR CON BOTONES*/
        
        panelInferior = new JPanel(new GridBagLayout());
        panelInferior.setLayout(new GridBagLayout());
        
        
        
        this.getContentPane().add(panelInferior, BorderLayout.SOUTH);
        
        GridBagConstraints conPanelInferior = new GridBagConstraints();
        
        conPanelInferior.insets = new Insets(25, 75, 45, 75);
        
        
         // boton confirmar
        
        buttonConfirmar = new JButton("Confirmar");
        buttonConfirmar.setPreferredSize(new Dimension(150,30));
        
        conPanelInferior.gridx = 0;
        conPanelInferior.gridy = 0;
        
        
        conPanelInferior.anchor = GridBagConstraints.CENTER;
        
        panelInferior.add(buttonConfirmar, conPanelInferior);
        
        buttonConfirmar.addActionListener(new ActionListener() {
           @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonConfirmarActionPerformed();
            }
    });
        
        // boton volver
        
        buttonVolver = new JButton("Volver");
        buttonVolver.setPreferredSize(new Dimension(150,30));
        
        conPanelInferior.gridx = 1;
        conPanelInferior.gridy = 0;
        
        
        conPanelInferior.anchor = GridBagConstraints.CENTER;
        
        panelInferior.add(buttonVolver, conPanelInferior);
        
        buttonVolver.addActionListener(new ActionListener() {
           @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonVolverActionPerformed();
            }
    });
    }
    
    
    public static void main(String args[]){
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                
                    new AltaTitular().setVisible(true);
                
            }
        });
        
    }
    
    
    public void buttonConfirmarActionPerformed(){
    
        
            //Validacion de todos los campos ocupados
            if(textNroDocumento.getText().equals("") 
               || textApellido.getText().equals("")
               || textNombres.getText().equals("")
               || textCalle.getText().equals("")
               || textNumero.getText().equals("") 
               || textLocalidad.getText().equals("")
               ){
                    JOptionPane.showMessageDialog(this,"Todos los campos deben estar completos", "Error", JOptionPane.INFORMATION_MESSAGE);
            }
            
            else{
                DTOTitular objeto = new DTOTitular(Integer.parseInt(textNroDocumento.getText()), 
                                                   tipoDocumento.getSelectedItem().toString(), 
                                                   Integer.parseInt(textNumero.getText()), 
                                                   null, 
                                                   textNombres.getText(), 
                                                   textApellido.getText(), 
                                                   tipoSanguineo.getSelectedItem().toString(), 
                                                   null, 
                                                   textPais.getText(), 
                                                   textProvincia.getText(), 
                                                   textLocalidad.getText(), 
                                                   textCalle.getText(), 
                                                   textPiso.getText(), 
                                                   textDepartamento.getText(), 
                                                   tipoFactor.getSelectedItem().toString(), 
                                                   null, 
                                                   null, 
                                                   null, 
                                                   null, 
                                                   null);
                        
                if(!gestor.guardarTitular(objeto)){
                        JOptionPane.showMessageDialog(this,"Hubo un error en el guardado del titular", "Titular no agregado", JOptionPane.PLAIN_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(this,"El titular ha sido agregado", "Titular agregado", JOptionPane.PLAIN_MESSAGE);
                    this.dispose();
                }
            }
        
    
    }
    
    public void buttonVolverActionPerformed(){
    
        this.dispose();
    
    }
    
}