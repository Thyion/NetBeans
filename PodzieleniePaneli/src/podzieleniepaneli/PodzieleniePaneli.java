
package podzieleniepaneli;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class PodzieleniePaneli extends JFrame{

    public PodzieleniePaneli() {
        initComponents();
    }
    
    public void initComponents() {
        this.setTitle("Podzielenie Paneli");
        this.setBounds(300, 300, 300, 200);
        
        panelListy.add(lista);
        panelObrazka.add(obrazek);
        panelOpisu.add(opis);
        lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lista.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                   Obrazek img = (Obrazek)((JList)e.getSource()).getSelectedValue();
                
                   obrazek.setIcon(img.getImage());
                   opis.setText(img.getDescription());
                }
                    
            }
        });
        
        
        JSplitPane podzielenie = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panelListy, panelObrazka);
        JSplitPane podzielenieGlowne = new JSplitPane(JSplitPane.VERTICAL_SPLIT, podzielenie, panelOpisu);
        
        
        this.getContentPane().add(podzielenieGlowne);
        this.setDefaultCloseOperation(3);
    }
    
    
    JPanel panelListy = new JPanel();
    JPanel panelObrazka = new JPanel();
    JPanel panelOpisu = new JPanel();
    JList lista = new JList(new Obrazek[] {
        new Obrazek("blue", "Piękny kolor niebieski"),
        new Obrazek("red", "Piękny kolor czerwony"),
        new Obrazek("green", "Piękny kolor zielony"),
        });
    JLabel obrazek = new JLabel();
    JLabel opis = new JLabel();
    
    private class Obrazek {
        
        public Obrazek(String nazwa, String opis) {
            this.nazwa = nazwa;
            this.opis = opis;
            
            obrazek = new ImageIcon(nazwa + ".png");
        }
        
        @Override
        public String toString() {
            return nazwa;
        }
        
        public ImageIcon getImage() {
            return obrazek;
        }
           
        public String getDescription() {
            return opis;
        }
        
        String nazwa, opis;
        ImageIcon obrazek;
    }
    
    public static void main(String[] args) {
        new PodzieleniePaneli().setVisible(true);
    }
    
}
