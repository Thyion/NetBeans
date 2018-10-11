/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package przeszukiwacztekstu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/**
 *
 * @author Krzysztof
 */
public class Przeszukiwacztekstu extends JFrame{
    
    public Przeszukiwacztekstu()
    {
        initComponents();
    }
    
    public void initComponents() {
        
        this.setTitle("Przeszukiwacz Tekstu");
        this.setBounds(300,300,500,200);
        this.setMinimumSize(new Dimension(500, 200));
        this.setDefaultCloseOperation(3);
        this.panelSzukania.add(znajdz);
        this.panelSzukania.add(szukany);
        this.panelSzukania.add(etykietaI);
        this.panelSzukania.add(zamien);
        this.panelSzukania.add(etykietaNa);
        this.panelSzukania.add(nowyTekst);
        
        //obszarTekstowy.selectAll(); - zaznacza cały tekst
        //obszarTekstowy.select(2,3); - zaznacza obszar, podany od kąd do kąd
        //obszarTekstowy.replaceSelection("DUPA"); - podmienia zaznaczony obszar
        //obszarTekstowy.replaceRange("trololo", 0, 2); - podmienia wskazany obszar
        //obszarTekstowy.insert("coś tam", 2); - wstawia teks w danej pozycji
        //obszarTekstowy.append("dupppp"); - dołącza soć na samym końcu
        //obszarTekstowy.select(obszarTekstowy.getText().indexOf("jest"), obszarTekstowy.getText().indexOf("jest")+"jest".length()); - wyszukuje i zaznacza coś od kądś do kądś
        
        this.getContentPane().add(obszarPrzewijania, BorderLayout.NORTH);
        this.getContentPane().add(panelSzukania, BorderLayout.CENTER);
        znajdz.addActionListener(new znajowanieHandler());
        zamien.addActionListener(new zamienianieHandler());
        
    }     
    
    private class znajowanieHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("znajduje");
            
            poczatekSzukanego = obszarTekstowy.getText().indexOf(szukany.getText(), poczatekSzukanego+szukany.getText().length());
            if (poczatekSzukanego == -1)
                poczatekSzukanego = obszarTekstowy.getText().indexOf(szukany.getText());
            
            if (poczatekSzukanego >= 0 && szukany.getText().length() > 0){
                obszarTekstowy.requestFocus();
                obszarTekstowy.select(poczatekSzukanego, poczatekSzukanego+szukany.getText().length());
            }
        }
        private int poczatekSzukanego = 0;
    }  
    private class zamienianieHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
            if(obszarTekstowy.getSelectionStart() != obszarTekstowy.getSelectionEnd()){
            
            zamientekst();
            } else {
                znajdz.doClick();
                if(obszarTekstowy.getSelectionStart() != obszarTekstowy.getSelectionEnd())
                zamientekst();
                }
            
        }
        public void zamientekst() {
         obszarTekstowy.requestFocus();
         int opcja = JOptionPane.showConfirmDialog(rootPane, "Czy napewno chcesz zamienić?", "UWAGA - czy zamienić", JOptionPane.YES_NO_OPTION);
         if (opcja == 0)
         obszarTekstowy.replaceRange(nowyTekst.getText(), obszarTekstowy.getSelectionStart(), obszarTekstowy.getSelectionEnd());  
        }   
        
    }
    
    private JTextArea obszarTekstowy = new JTextArea("Dupa to jest fajna sprawa",7,3);
    private JScrollPane obszarPrzewijania = new JScrollPane(obszarTekstowy);
    
    private JPanel panelSzukania = new JPanel();
    private JButton znajdz = new JButton("Znajdź");
    private JTextField szukany = new JTextField(10);
    private JLabel etykietaI = new JLabel("i");
    private JButton zamien = new JButton("Zamień");
    private JLabel etykietaNa = new JLabel("na");
    private JTextField nowyTekst = new JTextField(10);
    
    
    public static void main(String[] args) {
        new Przeszukiwacztekstu().setVisible(true);

    }
    
}
