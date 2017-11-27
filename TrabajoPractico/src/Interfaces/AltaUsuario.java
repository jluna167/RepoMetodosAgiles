/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import DAO.DAOUsuario;
import Persistencia.GestorUsuario;
import Entidades.Usuario;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Juan Ignacio
 */
public class AltaUsuario extends javax.swing.JFrame{
    
    GestorUsuario gestor;
    Usuario usuario;
    public JPanel panelSuperior, panelMedio, panelInferior;
    public JLabel labelAgregar, labelNumeroDNI, labelNombres, labelApellido, labelFechaNac, labelTipoUsuario, labelMail, labelUsuario;
    public JTextField textNumeroDNI, textNombres, textApellido, textMail, textUsuario;
    public JFormattedTextField textFechaNac;
    public JComboBox tipoUsuario;
    public JButton botonVolver, botonConfirmar;
    
    private static final String PATTERN_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";            
    
    public AltaUsuario (){
        gestor = new GestorUsuario();
        //titular = new DTOTitular();
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
        textApellido.addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e){
                
                
               
                    char vchar = e.getKeyChar();
                    //JOptionPane.showMessageDialog(null, textPiso.getText().length());
                    if ((!Character.isLetterOrDigit(vchar) && !Character.isSpaceChar(vchar)) || (vchar == KeyEvent.VK_BACK_SPACE)) {
                                                
                            e.consume();                 
                    
                    }
                    else if (textApellido.getText().length() >= 15){
                        
                        e.consume();
                        
                    }
                    else if((vchar == KeyEvent.VK_COMMA)) JOptionPane.showMessageDialog(null, "coma");
                   
                    
                
            }

            @Override
            public void keyPressed(KeyEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyReleased(KeyEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
                        
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
        textNombres.addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e){
                
                
               
                    char vchar = e.getKeyChar();
                    //JOptionPane.showMessageDialog(null, textPiso.getText().length());
                    if ((!Character.isLetterOrDigit(vchar) && !Character.isSpaceChar(vchar)) || (vchar == KeyEvent.VK_BACK_SPACE)) {
                                                
                            e.consume();                 
                    
                    }
                    else if (textNombres.getText().length() >= 20){
                        
                        e.consume();
                        
                    }
                    else if((vchar == KeyEvent.VK_COMMA)) JOptionPane.showMessageDialog(null, "coma");
                   
                    
                
            }

            @Override
            public void keyPressed(KeyEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyReleased(KeyEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
                        
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
        textMail.addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e){
                
                
               
                    char vchar = e.getKeyChar();
                    //JOptionPane.showMessageDialog(null, textPiso.getText().length());
                    if ((!Character.isLetterOrDigit(vchar) && (vchar == KeyEvent.VK_AT)) || (vchar == KeyEvent.VK_BACK_SPACE)) {
                                                
                            e.consume();                 
                    
                    }
                    else if (textMail.getText().length() >= 40){
                        
                        e.consume();
                        
                    }
                    else if((vchar == KeyEvent.VK_COMMA)) JOptionPane.showMessageDialog(null, "coma");
                   
                    
                
            }

            @Override
            public void keyPressed(KeyEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyReleased(KeyEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
                        
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
        textUsuario.addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e){
                
                
               
                    char vchar = e.getKeyChar();
                    //JOptionPane.showMessageDialog(null, textPiso.getText().length());
                    if ((!Character.isLetterOrDigit(vchar) && !Character.isSpaceChar(vchar)) || (vchar == KeyEvent.VK_BACK_SPACE)) {
                                                
                            e.consume();                 
                    
                    }
                    else if (textUsuario.getText().length() >= 15){
                        
                        e.consume();
                        
                    }
                    else if((vchar == KeyEvent.VK_COMMA)) JOptionPane.showMessageDialog(null, "coma");
                   
                    
                
            }

            @Override
            public void keyPressed(KeyEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyReleased(KeyEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
                        
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
               try { 
                   botonConfirmarActionPerformed();
               } catch (ParseException ex) {
                   Logger.getLogger(AltaUsuario.class.getName()).log(Level.SEVERE, null, ex);
               }
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
    
    public boolean pantallaCorrecta(){
        //Validación de todos los campos llenos
        if(textNumeroDNI.getText().equals("") 
           || textApellido.getText().equals("")
           || textNombres.getText().equals("")
           || tipoUsuario.getSelectedItem().toString().equals("")
           || textUsuario.getText().equals("") 
           || textFechaNac.getText().equals("")
           ){
                return false;
        }   
        //Validación de el correcto ingreso de fecha e Email
        else if (!validarFecha() || !validarEmail()){
            return false;
        }
        else{
            return true;
        }
    }
    
    public void botonConfirmarActionPerformed() throws ParseException{
        if (pantallaCorrecta()){
            usuario = new Usuario(1,
                        Integer.parseInt(textNumeroDNI.getText()),                                      
                        textNombres.getText(),
                        textApellido.getText(),                                    
                        strigToDate(textFechaNac.getText()),
                        tipoUsuario.getSelectedItem().toString(),
                        textMail.getText(),
                        textUsuario.getText(),
                        textNumeroDNI.getText());
            if(gestor.guardarUsuario(usuario)){
                JOptionPane.showMessageDialog(this,"El usuario ha sido agregado", "Usuario agregado", JOptionPane.PLAIN_MESSAGE);
                this.dispose();    
            }
            else{
                if(gestor.existeUsuario(usuario)){
                    JOptionPane.showMessageDialog(null,"El usuario con ese numero de DNI ya fue ingresado");
                }
                JOptionPane.showMessageDialog(this,"Hubo un error en el guardado del usuario", "Usuario no agregado", JOptionPane.PLAIN_MESSAGE);
            }
        }
        else{
            JOptionPane.showMessageDialog(this,"Existe un error en los datos ingresados.", "Usuario no agregado", JOptionPane.PLAIN_MESSAGE);
        }
    }
    
    private Date strigToDate (String fecha) throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String strFecha = fecha;
        Date fechaDate = null;
        
        fechaDate = formato.parse(strFecha);
        return fechaDate;
    }

    public boolean validarFecha(){
        String fecha = (String) textFechaNac.getValue();

        int dia = Integer.parseInt(fecha.substring(0,2));
        int mes = Integer.parseInt(fecha.substring(3,5));
        int año = Integer.parseInt(fecha.substring(6,10));
        int añoActual = Calendar.getInstance().get(Calendar.YEAR);

        if((dia<1 || dia>31) || (mes<1 || mes>12) || (año>añoActual))
            return false;
        else
            return true;
     }

    public boolean validarEmail(){
        // Compiles the given regular expression into a pattern.
        Pattern pattern = Pattern.compile(PATTERN_EMAIL);

        // Match the given input against this pattern
        Matcher matcher = pattern.matcher(textMail.getText());
        return matcher.matches();
    }
}
