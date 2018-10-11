/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zdarzenia;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.Clock;


/**
 *
 * @author Krzysztof
 */
public class Zdarzenia extends JFrame{

    /**
     * @param args the command line arguments
     */
    public Zdarzenia(){
        super("Zdarzenia");
        this.setBounds(300, 300, 300, 200);
        initComponents();
        this.setDefaultCloseOperation(3);
    }    
    
    public void initComponents() {
        JButton kolorCzerwony = new JButton("Czerwony");
        JButton kolorZielony = new JButton("Zielony");
        JButton kolorZolty = new JButton("Zolty");
        panel.add(kolorCzerwony);
        panel.add(kolorZielony);
        panel.add(kolorZolty);
        this.getContentPane().add(panel);
        kolorCzerwony.addActionListener(new sluchaczKolorow(Color.RED));
        kolorZielony.addActionListener(new sluchaczKolorow(Color.GREEN));
        kolorZolty.addActionListener(new sluchaczKolorow(Color.YELLOW));
        
        budujButton("Czarny", Color.BLACK);
        
    }
    JPanel panel = new JPanel();
    JButton kolorCzerwony;
    JButton kolorZielony;
    JButton kolorZolty;
    
    public void budujButton(String nazwa, Color k) {
        JButton przycisk = new JButton(nazwa);
        panel.add(przycisk);
        przycisk.addActionListener(new sluchaczKolorow(k));
        
    }    
    
    private class sluchaczKolorow implements ActionListener {
        public sluchaczKolorow(Color k) {
            this.kolor = k;
            
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            panel.setBackground(kolor);
        }
    Color kolor;
    
        
    } 
    
    public static void main(String[] args) {
        // TODO code application logic here
        new Zdarzenia().setVisible(true);
    }
    
}
