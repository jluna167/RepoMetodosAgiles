/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Persistencia.GestorLicencia;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.SQLException;
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
    GestorLicencia gestor;
    GridBagConstraints conPanelInferior;
    
    public ListarLicencias (){
        gestor = new GestorLicencia();
        
        inicializar();
        
    }
    
    
    /*METODO QUE GENERA INTERFAZ GRAFICA*/
    
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
               try {
                   botonVigentesActionPerformed() ;
               } catch (ParseException ex) {
                   Logger.getLogger(ListarLicencias.class.getName()).log(Level.SEVERE, null, ex);
               } catch (ClassNotFoundException ex) {
                   Logger.getLogger(ListarLicencias.class.getName()).log(Level.SEVERE, null, ex);
               } catch (SQLException ex) {
                   Logger.getLogger(ListarLicencias.class.getName()).log(Level.SEVERE, null, ex);
               }
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
               try {
                   botonVencidasActionPerformed();
               } catch (ParseException ex) {
                   Logger.getLogger(ListarLicencias.class.getName()).log(Level.SEVERE, null, ex);
               } catch (ClassNotFoundException ex) {
                   Logger.getLogger(ListarLicencias.class.getName()).log(Level.SEVERE, null, ex);
               } catch (SQLException ex) {
                   Logger.getLogger(ListarLicencias.class.getName()).log(Level.SEVERE, null, ex);
               }
            }
    });
        /*DEFINICION PANEL INFERIOR CON */
        
        panelInferior = new JPanel(new GridBagLayout());
        panelInferior.setLayout(new GridBagLayout());
        
        
        this.getContentPane().add(panelInferior, BorderLayout.SOUTH);
        
        GridBagConstraints conPanelInferior = new GridBagConstraints();
        
        conPanelInferior.insets = new Insets(5, 5, 15, 5);
        
       
    }
    
    public static void main(String args[]){
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                
                    new ListarLicencias().setVisible(true);
                
            }
        });
        
    }
    
    
    /*METODO QUE PERMITE MOSTRAR LICENCIAS VENCIDAS*/
    
    public void botonVencidasActionPerformed() throws ParseException, ClassNotFoundException, SQLException{
           
        JOptionPane.showMessageDialog(null, gestor.verExpiradas());
        
    }
    
    /*METODO QUE PERMITE MOSTRAR LICENCIAS VIGENTES*/
    
    public void botonVigentesActionPerformed() throws ParseException, ClassNotFoundException, SQLException{
    
        JOptionPane.showMessageDialog(null, gestor.verVigentes());
        
    }
}
