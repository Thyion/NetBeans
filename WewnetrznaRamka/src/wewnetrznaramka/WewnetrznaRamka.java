
package wewnetrznaramka;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;


public class WewnetrznaRamka extends JFrame{

    public WewnetrznaRamka() {
        initComponents();
    }
    
    public void initComponents() {
        this.setTitle("Wewnętrzne Ramki");
        this.setBounds(300, 300, 300, 300);
        
        JInternalFrame wewRamka = new JInternalFrame("Wewnętrzna Ramka", true, true, true, true);
        JInternalFrame wewRamka2 = new JInternalFrame("Wewnętrzna Ramka", true, true, true, true);
        
       
        wewRamka.add(new JButton("TEŚCIOR"), BorderLayout.NORTH);   
        wewRamka2.add(new JButton("T"), BorderLayout.NORTH); 
        wewRamka.setVisible(true);
        wewRamka2.setVisible(true);
         
       
        wewRamka.pack(); //pojawia ramke i jakby generuje w niej to co w kodzie powyżej
        wewRamka2.pack();
        desktopPane.add(wewRamka);
        desktopPane.add(wewRamka2);
        wewRamka.setDefaultCloseOperation(JInternalFrame.DO_NOTHING_ON_CLOSE);
        wewRamka.addInternalFrameListener(new InternalFrameListener() {
            @Override
            public void internalFrameOpened(InternalFrameEvent e) {
                System.out.println("Otwarte");
            }

            @Override
            public void internalFrameClosing(InternalFrameEvent e) {
                
                String odp = JOptionPane.showInternalInputDialog(e.getInternalFrame(), "Wpisz wyjść lub zamknij");
                
                if (odp != null) {
                    if (odp.equals("W")) {
                        System.exit(0);
                    }
                    else if (odp.equals("Z")) {
                        e.getInternalFrame().dispose();
                    }
                    
                }
            }

            @Override
            public void internalFrameClosed(InternalFrameEvent e) {
                System.out.println("Zamknięte");
            }

            @Override
            public void internalFrameIconified(InternalFrameEvent e) {
                System.out.println("Minimalozacja");
            }

            @Override
            public void internalFrameDeiconified(InternalFrameEvent e) {
                System.out.println("Maksymalizacja");
            }

            @Override
            public void internalFrameActivated(InternalFrameEvent e) {
                System.out.println("Aktywacja");
            }

            @Override
            public void internalFrameDeactivated(InternalFrameEvent e) {
                System.out.println("Deaktywacja");
            }
        });
        
        this.getContentPane().add(desktopPane, BorderLayout.CENTER);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private JDesktopPane desktopPane = new JDesktopPane();
    
    
    
    public static void main(String[] args) {
        new WewnetrznaRamka().setVisible(true);
    }
    
}
