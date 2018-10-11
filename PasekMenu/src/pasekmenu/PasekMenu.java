
package pasekmenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Krzysztof
 */
public class PasekMenu extends JFrame{

    public PasekMenu() {
        initComponents();
        
    }
    
    public void initComponents() {
        this.setTitle("PasekMenu");
        this.setBounds(300, 300, 300, 300);
        this.setDefaultCloseOperation(3);
        this.setJMenuBar(pasekMenu);
        
        JMenu menuPlik = pasekMenu.add(new JMenu("Plik"));
        
        JMenuItem menuPlikNowy = menuPlik.add(new JMenuItem("Nowy"));
                menuPlikNowy.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                      System.out.println("Tu jest kod tworzący nowy plik");
                    }
                });
            menuPlik.addSeparator();
            JMenuItem menuPlikZapisz = menuPlik.add(new JMenuItem("Zapisz"));
            menuPlik.addSeparator();
            JMenuItem menuPlikWczytaj = menuPlik.add(new JMenuItem("Wczytaj"));
            menuPlik.addSeparator();
            JMenuItem menuPlikZamknij = menuPlik.add(new JMenuItem("Zamknij"));
                menuPlikZamknij.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                       System.exit(0);
                    }
                });
            menuPlik.addSeparator();    
            JMenu menuPlikOpcje = new JMenu ("Opcje"); //chcemy aby to było menu a nie menuItem 
            menuPlik.add(menuPlikOpcje);                //dlatego tak to zapisujemy
            menuPlikOpcje.add(new JMenuItem("Lipa"));
                menuPlikOpcje.add(tylkoDoOdczytu);
                    tylkoDoOdczytu.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (tylkoDoOdczytu.isSelected())
                                menuPlikZapisz.setEnabled(false);
                            else {
                                menuPlikZapisz.setEnabled(true);
                            }
                        }
                    });
        JMenu menuEdytuj = pasekMenu.add(new JMenu("Edytuj"));
        JMenu menuPomoc = pasekMenu.add(new JMenu("Pomoc"));
            JMenuItem menuPomocFAQ = menuPomoc.add(new JMenuItem("FAQ"));
            
            
    }
    /**
     * @param args the command line arguments
     */
    
    private JMenuBar pasekMenu = new JMenuBar();
    private JCheckBoxMenuItem tylkoDoOdczytu = new JCheckBoxMenuItem("Tylko do odczytu");
    
    public static void main(String[] args) {
        new PasekMenu().setVisible(true);
    }
    
}
