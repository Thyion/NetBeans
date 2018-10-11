/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package przelaczniki;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/**
 *
 * @author Krzysztof
 */
public class Przelaczniki extends JFrame{

    
       public Przelaczniki() {
           initComponents();
       }
   
       public void initComponents() {
           this.setTitle("Grupy Przełaczników Radio");
           this.setBounds(300, 300, 300, 200);
           panel2.add(etykieta);
           /**
           JRadioButton maly = new JRadioButton("Mały",true);
           JRadioButton sredni = new JRadioButton("Średni",false);
           JRadioButton duzy = new JRadioButton("Duży",false);
           
           maly.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                   etykieta.setFont(new Font("Serif",Font.BOLD,12));
               }
               
           });
           sredni.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                   etykieta.setFont(new Font("Serif",Font.BOLD,16));
               }
               
           });
           duzy.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                   etykieta.setFont(new Font("Serif",Font.ITALIC,42));
               }
               
           });
           
           groupSize.add(maly);
           groupSize.add(sredni);
           groupSize.add(duzy);
           panel.add(maly);
           panel.add(sredni);
           panel.add(duzy);
           */
           
           
           this.getContentPane().add(panel, BorderLayout.NORTH);
           this.getContentPane().add(panel3, BorderLayout.CENTER);
           this.getContentPane().add(panel2, BorderLayout.SOUTH); 
           
           zbudujPrzelacznikRozmiar("Small",15);
           zbudujPrzelacznikRozmiar("Medium",25);
           zbudujPrzelacznikRozmiar("Big",35);
           zbudujPrzelacznikKolor("Red",Color.RED);
           zbudujPrzelacznikKolor("Blue",Color.BLUE);
           zbudujPrzelacznikKolor("Green",Color.GREEN);
           
           this.setDefaultCloseOperation(3);
       }
       
    JPanel panel = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JLabel etykieta = new JLabel("Coś");
    ButtonGroup groupSize = new ButtonGroup();
    ButtonGroup groupColor = new ButtonGroup();
    public void zbudujPrzelacznikRozmiar(String nazwa, final int rozmiar){
        JRadioButton przelacznik = new JRadioButton(nazwa);
        
        przelacznik.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               etykieta.setFont(new Font("Monospaced", Font.PLAIN, rozmiar));
            }
        });
        
        groupSize.add(przelacznik);
        panel.add(przelacznik);
    }
     public void zbudujPrzelacznikKolor(String nazwa, final Color k){
        JRadioButton przelacznik = new JRadioButton(nazwa);
        
        przelacznik.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               etykieta.setForeground(k);
            }
        });
        
        groupColor.add(przelacznik);
        panel3.add(przelacznik);
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        new Przelaczniki().setVisible(true);
        
        
    }
    
}
