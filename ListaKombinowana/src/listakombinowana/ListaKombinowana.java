/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listakombinowana;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/**
 *
 * @author Krzysztof
 */
public class ListaKombinowana extends JFrame{
    
    public ListaKombinowana()
    {
        initComponents();
    }
    
    public void initComponents() {
        this.setTitle("Listy kombinowane");
        this.setBounds(300, 300, 300, 300);
        this.setDefaultCloseOperation(3);
        this.getContentPane().add(panel);
        
        kombinacja.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ColorHandler handler = (ColorHandler)((JComboBox)e.getSource()).getSelectedItem();
                //kombinacja.getSelectedItem(); - czyli pobierz co zostalo wybrane (2 opcja)
            //((JComboBox)e.getSource()).setBackground(handler.getColor()); - ustawia tło w COmboBOxie
            panel.setBackground(handler.getColor());
            }
        });
            
        panel.add(kombinacja);
        kombinacja.addItem(new ColorHandler("Biały", Color.WHITE));
        kombinacja.addItem(new ColorHandler("Czarny", Color.BLACK));
        kombinacja.addItem(new ColorHandler("Zielony", Color.GREEN));
        kombinacja.addItem(new ColorHandler("Czerwony", Color.RED));
    }
    private class ColorHandler{
        public ColorHandler(String colorName, Color kolor) {
            this.kolor = kolor;
            this.colorName = colorName;
        }
        public String toString() {
            return this.colorName;
        }
        public  Color getColor() {
            return this.kolor;
        }
        private Color kolor;
        private String colorName;
    }
    private JPanel panel = new JPanel();
    JComboBox kombinacja = new JComboBox();
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new ListaKombinowana().setVisible(true);
        // TODO code application logic here
    }
    
}
