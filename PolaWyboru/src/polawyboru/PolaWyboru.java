/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polawyboru;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Krzysztof
 */
public class PolaWyboru extends JFrame{

    public static void main(String[] args) {
        new PolaWyboru().setVisible(true);
    }
    
    public PolaWyboru(){
        
        initComponents();
    }
    
    public void initComponents() {
        this.setTitle("Pola Wyboru");
        this.setDefaultCloseOperation(3);
        this.setBounds(300, 300, 300, 300);
        
        this.getContentPane().add(panel1, BorderLayout.NORTH);
        this.getContentPane().add(panel2, BorderLayout.CENTER);
    
        panel1.add(pogrubiony);
        panel1.add(pochylony);
        panel2.add(etykieta);
        etykieta.setFont(new Font ("Monospaced", Font.PLAIN, 30));
        
        ActionListener sluchacz = new CheckBoxHandler();
        pogrubiony.addActionListener(sluchacz);    
        pochylony.addActionListener(sluchacz);
    }
    
    
JPanel panel1 = new JPanel();
JPanel panel2 = new JPanel();
JLabel etykieta = new JLabel("Trolololo");
JCheckBox pogrubiony = new JCheckBox("Pogrubiony");
JCheckBox pochylony = new JCheckBox("Pochylony");

    public class CheckBoxHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //System.out.println("Stała się akcja");
            
            int style = Font.PLAIN;
            if (pogrubiony.isSelected()) style += Font.BOLD;
            if (pochylony.isSelected()) style += Font.ITALIC;
            
            etykieta.setFont(new Font(etykieta.getFont().getFamily(), style, etykieta.getFont().getSize()));
        };
            
        }
        
    }

