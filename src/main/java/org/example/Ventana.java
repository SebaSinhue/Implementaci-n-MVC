package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Ventana extends JFrame{
    private JLabel lblNombre;
    private JTextField txtNombre;
    private JButton boton;
    private JComboBox Combo;
    private NombreModeloCombo modelo;


    public Ventana(String title) throws HeadlessException {
        super(title);
        this.setSize(400, 600);
        setLayout(new FlowLayout());
        lblNombre =  new JLabel("Ingresa un nombre");
        this.getContentPane().add(lblNombre);
        txtNombre = new JTextField(30);
        this.getContentPane().add(txtNombre);
        boton = new JButton("Agregar");
        this.getContentPane().add(boton);
        //configuracion del modelo
        modelo = new NombreModeloCombo();
        modelo.agregarNombre("Diana");
        modelo.agregarNombre("Diego");
        modelo.agregarNombre("Susana");
        Combo = new JComboBox<>(modelo);
        this.getContentPane().add(Combo);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        boton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String nuevo = txtNombre.getText();
                modelo.agregarNombre(nuevo);
                txtNombre.setText("");
            }
        });
        Combo.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(Combo.getSelectedIndex());
                System.out.println(Combo.getSelectedItem());
                JOptionPane.showMessageDialog(null, "Hola " + Combo.getSelectedItem());
            }
        });
    }
}
