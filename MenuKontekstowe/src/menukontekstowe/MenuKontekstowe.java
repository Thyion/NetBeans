/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menukontekstowe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Krzysztof
 */
public class MenuKontekstowe extends JFrame{
    
    
    public MenuKontekstowe() {
        initComponents();
    }
    
    public void initComponents() {
        this.setTitle("Menu Kontekstowe");
        this.setBounds(300, 300, 300, 300);
        this.setDefaultCloseOperation(3);
        this.getContentPane().add(testowiec, BorderLayout.SOUTH);
        JPopupMenu menuKontekstowe = new JPopupMenu("Menu Kontekstowe");
        menuKontekstowe.add(new JMenuItem("Zamknij"));
        menuKontekstowe.add(new JMenuItem(new AbstractAction("Zamknij") {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        }));
        menuKontekstowe.add(new JMenuItem("Kopiuj"));
        menuKontekstowe.add(new JMenuItem("Wklej"));
        
        
        this.getContentPane().addMouseListener(new MouseAdapter() { //można użyc MouseListener wtedy trzeba nadpisac wszystkie abstrakcyjne metody
            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("Released");
                if (e.getClickCount() == 3 && e.getButton() == 1)
                    JOptionPane.showMessageDialog(rootPane, "Debil");
                
                //if (e.getButton() == 3) Można tak ale zwykle się daje domyślne to co poniżej, daje sutawienie z systemu ze prawy przycisk wywoluje menu
                if (e.isPopupTrigger())    
                    menuKontekstowe.show(e.getComponent(), e.getX(), e.getY());
            }
        });
        
    }
    
    private JButton testowiec = new JButton("Test");
    
    public static void main(String[] args) {
        new MenuKontekstowe().setVisible(true);
        // TODO code application logic here
    }

    
    
}
