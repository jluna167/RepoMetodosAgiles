/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Entidades.Licencia;
import Entidades.Titular;
import Persistencia.GestorLicencia;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Juan Ignacio
 */
public class EmitirLicencia extends javax.swing.JFrame{
    
    JPanel panelSuperior, panelMedio, panelDerecho, panelInferior;
    JLabel labelAgregar, labelTipoLicencia, labelFechaNac, labelDonante, labelFechaEmision, labelFechaVencimiento, labelCosto, labelSeleccionarFoto, 
            labelFoto, labelApellido, labelNombres, labelDocumento;
    JComboBox tipoLicencia;
    JTextField textFechaNac, textDonante, textFechaEmision, textFechaVencimiento, textCosto, textApellido, textNombres, textDocumento;
    JButton buscarImagen, buttonGEI, buttonVolver;
    Titular titular;
    
    public EmitirLicencia (){
        
        inicializar();
        
    }
    
    public EmitirLicencia (Titular titular){
        inicializar();
        this.titular = titular;
        cargarContenido(titular);
    }
    
    public void inicializar(){
    
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setSize(new Dimension(800,700));
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
        
        labelAgregar = new JLabel("EMITIR LICENCIA");
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
        
        //apellido
                
        labelApellido = new JLabel("Apellido:");
        labelApellido.setFont(font1);
        
        conPanelMedio.gridx = 0;
        conPanelMedio.gridy = 0;
        conPanelMedio.anchor = GridBagConstraints.LINE_START;
        
        panelMedio.add(labelApellido, conPanelMedio);
        
        
        //text Apellido
        
           
        textApellido = new JTextField();
        textApellido.setColumns(15);
        textApellido.setEditable(false);
                
        conPanelMedio.gridx = 1;
        conPanelMedio.gridy = 0;
        conPanelMedio.anchor = GridBagConstraints.LINE_START;
        
        panelMedio.add(textApellido, conPanelMedio);
        
        //Nombres
                
        labelNombres = new JLabel("Nombres:");
        labelNombres.setFont(font1);
        
        conPanelMedio.gridx = 0;
        conPanelMedio.gridy = 1;
        conPanelMedio.anchor = GridBagConstraints.LINE_START;
        
        panelMedio.add(labelNombres, conPanelMedio);
        
        
        //text Nombres
        
           
        textNombres = new JTextField();
        textNombres.setColumns(25);
        textNombres.setEditable(false);
                
        conPanelMedio.gridx = 1;
        conPanelMedio.gridy = 1;
        conPanelMedio.anchor = GridBagConstraints.LINE_START;
        
        panelMedio.add(textNombres, conPanelMedio);
        
        
        //Documento
                
        labelDocumento = new JLabel("Documento:");
        labelDocumento.setFont(font1);
        
        conPanelMedio.gridx = 0;
        conPanelMedio.gridy = 2;
        conPanelMedio.anchor = GridBagConstraints.LINE_START;
        
        panelMedio.add(labelDocumento, conPanelMedio);
        
        
        //text Documentos
        
           
        textDocumento = new JTextField();
        textDocumento.setColumns(8);
        textDocumento.setEditable(false);
                
        conPanelMedio.gridx = 1;
        conPanelMedio.gridy = 2;
        conPanelMedio.anchor = GridBagConstraints.LINE_START;
        
        panelMedio.add(textDocumento, conPanelMedio);
        
        //tipo licencia
        
        labelTipoLicencia = new JLabel("Tipo Licencia:");
        labelTipoLicencia.setFont(font1);
        
        conPanelMedio.gridx = 0;
        conPanelMedio.gridy = 3;
        conPanelMedio.anchor = GridBagConstraints.LINE_START;
        
        panelMedio.add(labelTipoLicencia, conPanelMedio);
        
        //combobox
        
        String[] tiposDocumentos = { "A","B","C","E","G" };
        
        tipoLicencia = new JComboBox(tiposDocumentos);
        
        tipoLicencia.setSelectedItem(null);
               
        conPanelMedio.gridx = 1;
        conPanelMedio.gridy = 3;
        
        panelMedio.add(tipoLicencia, conPanelMedio);
        
        

        //fecha nacimiento
                
        labelFechaNac = new JLabel("Fecha de Nacimiento:");
        labelFechaNac.setFont(font1);
        
        conPanelMedio.gridx = 0;
        conPanelMedio.gridy = 4;
        conPanelMedio.anchor = GridBagConstraints.LINE_START;
        
        panelMedio.add(labelFechaNac, conPanelMedio);
        
        
        //text fecha nacimiento
        
        textFechaNac = new JTextField();
        textFechaNac.setColumns(8);
        textFechaNac.setEditable(false);
                
        conPanelMedio.gridx = 1;
        conPanelMedio.gridy = 4;
        conPanelMedio.anchor = GridBagConstraints.LINE_START;
        
        panelMedio.add(textFechaNac, conPanelMedio);
        
        
        
        //text donante
                
        labelDonante = new JLabel("Donante:");
        labelDonante.setFont(font1);
        
        conPanelMedio.gridx = 0;
        conPanelMedio.gridy = 5;
        conPanelMedio.anchor = GridBagConstraints.LINE_START;
        
        panelMedio.add(labelDonante, conPanelMedio);
        
        
        //text donante
        
           
        textDonante = new JTextField();
        textDonante.setColumns(3);
        textDonante.setEditable(false);
                
        conPanelMedio.gridx = 1;
        conPanelMedio.gridy = 5;
        conPanelMedio.anchor = GridBagConstraints.LINE_START;
        
        panelMedio.add(textDonante, conPanelMedio);
        
        
        //fecha emision
                
        labelFechaEmision = new JLabel("Fecha de Emision:");
        labelFechaEmision.setFont(font1);
        
        conPanelMedio.gridx = 0;
        conPanelMedio.gridy = 6;
        conPanelMedio.anchor = GridBagConstraints.LINE_START;
        
        panelMedio.add(labelFechaEmision, conPanelMedio);
        
        
        //text emision
//        
//        MaskFormatter mascaraFechaEmision = null;
//        try {
//            mascaraFechaEmision  = new MaskFormatter("##/##/####");
//            mascaraFechaEmision .setPlaceholderCharacter(' ');
//        }
//        catch (ParseException e) {
//            e.printStackTrace();
//        }
//        
//        textFechaEmision = new JFormattedTextField(mascaraFechaEmision);
        textFechaEmision = new JTextField();
        textFechaEmision.setColumns(8);
        textFechaEmision.setEditable(false);
                
        conPanelMedio.gridx = 1;
        conPanelMedio.gridy = 6;
        conPanelMedio.anchor = GridBagConstraints.LINE_START;
        
        panelMedio.add(textFechaEmision, conPanelMedio);
        
        
        //fecha vencimiento
                
        labelFechaVencimiento = new JLabel("Fecha de Vencimiento:");
        labelFechaVencimiento.setFont(font1);
        
        conPanelMedio.gridx = 0;
        conPanelMedio.gridy = 7;
        conPanelMedio.anchor = GridBagConstraints.LINE_START;
        
        panelMedio.add(labelFechaVencimiento, conPanelMedio);
        
        
        //text vencimiento

        textFechaVencimiento = new JTextField();
        textFechaVencimiento.setColumns(8);
        textFechaVencimiento.setEditable(false);
                
        conPanelMedio.gridx = 1;
        conPanelMedio.gridy = 7;
        conPanelMedio.anchor = GridBagConstraints.LINE_START;
        
        panelMedio.add(textFechaVencimiento, conPanelMedio);
        
        
        //text costo
                
        labelCosto = new JLabel("Costo: ");
        labelCosto.setFont(font1);
        
        conPanelMedio.gridx = 0;
        conPanelMedio.gridy = 8;
        conPanelMedio.anchor = GridBagConstraints.LINE_START;
        
        panelMedio.add(labelCosto, conPanelMedio);
        
        
        //text costo
        
           
        textCosto = new JTextField();
        textCosto.setColumns(8);
        textCosto.setEditable(false);
                
        conPanelMedio.gridx = 1;
        conPanelMedio.gridy = 8;
        conPanelMedio.anchor = GridBagConstraints.LINE_START;
        
        panelMedio.add(textCosto, conPanelMedio);
        
        
        /*DEFINICION PANEL DERECHO CON ELEMENTOS DE IMAGEN*/
        
        panelDerecho = new JPanel(new GridBagLayout());
        panelDerecho.setLayout(new GridBagLayout());
        //panelDerecho.setBorder( BorderFactory.createLoweredBevelBorder());
        
        
        
        this.getContentPane().add(panelDerecho, BorderLayout.EAST);
        
        GridBagConstraints conPanelDerecho = new GridBagConstraints();
        
        conPanelDerecho.insets = new Insets(15, 75, 15, 75);
        
        //label seleccionar foto
        
        
        labelSeleccionarFoto = new JLabel("Seleccionar Foto");
        labelSeleccionarFoto.setFont(font1);
        
        conPanelDerecho.gridx = 0;
        conPanelDerecho.gridy = 0;
        
        
        conPanelDerecho.anchor = GridBagConstraints.CENTER;
        
        panelDerecho.add(labelSeleccionarFoto, conPanelDerecho);
        
        
        // label con foto
        
        labelFoto = new JLabel();
        labelFoto.setPreferredSize(new Dimension(150,150));
        labelFoto.setBorder(BorderFactory.createLineBorder(Color.black));
        
        conPanelDerecho.gridx = 0;
        conPanelDerecho.gridy = 1;
        
        
        conPanelDerecho.anchor = GridBagConstraints.CENTER;
        
        panelDerecho.add(labelFoto, conPanelDerecho);
        
        // boton buscar imagen
        
        buscarImagen = new JButton("Examinar");
        
        conPanelDerecho.gridx = 0;
        conPanelDerecho.gridy = 2;
        
        
        conPanelDerecho.anchor = GridBagConstraints.CENTER;
        
        panelDerecho.add(buscarImagen, conPanelDerecho);
        
        buscarImagen.addActionListener(new ActionListener() {
           @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarImagenActionPerformed(evt, labelFoto);
            }
    });
        
        
        
        /*DEFINICION PANEL INFERIOR CON BOTONES*/
        
        panelInferior = new JPanel(new GridBagLayout());
        panelInferior.setLayout(new GridBagLayout());
        
        
        
        this.getContentPane().add(panelInferior, BorderLayout.SOUTH);
        
        GridBagConstraints conPanelInferior = new GridBagConstraints();
        
        conPanelInferior.insets = new Insets(95, 75, 45, 75);
        
        
         // boton guardar e imprimir
        
        buttonGEI = new JButton("Guardar e Imprimir");
        buttonGEI.setPreferredSize(new Dimension(150,30));
        
        conPanelInferior.gridx = 0;
        conPanelInferior.gridy = 0;
        
        
        conPanelInferior.anchor = GridBagConstraints.CENTER;
        
        panelInferior.add(buttonGEI, conPanelInferior);
        
        buttonGEI.addActionListener(new ActionListener() {
           @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGEIActionPerformed();
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
                
                    new EmitirLicencia().setVisible(true);
                
            }
        });
        
    }
    
    public void buscarImagenActionPerformed(ActionEvent e, JLabel labelFoto) {
        
          JFileChooser imagen = new JFileChooser();
          imagen.setCurrentDirectory(new File(System.getProperty("user.home") + "/Desktop"));
          
          
          //filtrado para que solo busque imagenes
          
          FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.Imagenes", "jpg","gif","png");
          imagen.addChoosableFileFilter(filtro);
          int resultado = imagen.showSaveDialog(null);
          
          
           //se asegura que se elija una imagen
           
          if(resultado == JFileChooser.APPROVE_OPTION){
              
              //en la siguiente sentencia se guarda la imagen cargada en la variable "archivoSeleccionado"
              //el path, o camino, vendria a ser por ejemplo /user/escritorio/foto.jpg
              
              File archivoSeleccionado = imagen.getSelectedFile();
              String direccion = archivoSeleccionado.getAbsolutePath();
              labelFoto.setIcon(RedimensionarImagen(direccion, labelFoto));
          }
           
         
        }
    
    public ImageIcon RedimensionarImagen(String direccion, JLabel labelFoto){
        ImageIcon MyImage = new ImageIcon(direccion);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(labelFoto.getWidth(), labelFoto.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }
    
    public void buttonGEIActionPerformed(){
        GestorLicencia gestorCosto = new GestorLicencia();
        int vigencia = gestorCosto.calcularVigencia(titular);
        int costo = gestorCosto.calcularCosto(tipoLicencia.getSelectedItem().toString(), vigencia);
        
        int respuesta = JOptionPane.showConfirmDialog(null, "El costo de la licencia será de " + costo + " pesos, ¿desea continuar?","ATENCION",JOptionPane.YES_NO_OPTION);
                
        if(respuesta == JOptionPane.YES_OPTION){
        
        int algo = tipoLicencia.getSelectedIndex();
        if(textApellido.getText()=="" || textNombres.getText()=="" ||
                textCosto.getText()=="" || textDocumento.getText()==""||
                textDonante.getText()=="" || textFechaEmision.getText()==""||
                textFechaNac.getText()==""|| textFechaVencimiento.getText()==""||
                tipoLicencia.getSelectedIndex()==-1){
            JOptionPane.showMessageDialog(this,"Todos los campos deben estar completos", "Error", JOptionPane.ERROR_MESSAGE);                
        }
        else{
            Licencia licencia = new Licencia();
            GestorLicencia gestor = new GestorLicencia();
            //no se pone el de fechaEmision porque se crea por defencto en el constructor de dTOLicencia
            licencia.fechaVencimiento = strigToDate(textFechaVencimiento.getText());
            licencia.tipo = tipoLicencia.getSelectedItem().toString();
            licencia.titular = titular;
            //licencia.setUsuario(usuario);
            licencia.vigencia = gestor.calcularVigencia(titular);
            if(gestor.almacenarLicencia(licencia))
                JOptionPane.showMessageDialog(this,"Se guardó la licencia con éxito.", "Atencion", JOptionPane.PLAIN_MESSAGE);
            else
                JOptionPane.showMessageDialog(this,"Hubo un error al guardar la licencia.", "Error", JOptionPane.ERROR_MESSAGE);
        }}
    }
    
    public void buttonVolverActionPerformed(){
    
        this.dispose();
    
    }

    private void cargarContenido(Titular titular) {
        textNombres.setText(titular.nombre);
        textApellido.setText(titular.apellido);
        textDocumento.setText(String.valueOf(titular.dni));
        String fechaNac = titular.fechaNacimiento.toString();
        textFechaNac.setText(String.valueOf(fechaNac.substring(0, 10)));
        textDonante.setText(titular.donante);
        textFechaEmision.setText(LocalDate.now().toString());
        GestorLicencia gestor = new GestorLicencia();
        int vigencia = gestor.calcularVigencia(titular);
        textFechaVencimiento.setText(LocalDate.now().plusYears(vigencia).toString());
        textCosto.setText("No definido");
    }

    private Date strigToDate (String fecha){
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
        String strFecha = fecha;
        Date fechaNueva = null;
        try {

            fechaNueva = formatoDelTexto.parse(strFecha);

        } catch (ParseException ex) {

            ex.printStackTrace();

        }
        return fechaNueva;
    }
}
