
package zakladki;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Zakladki extends JFrame {
    
    public Zakladki() {
        initComponents();
    }
    
    public void initComponents () {
        this.setTitle("Zakładki");
        this.setBounds(300, 300, 300, 300);
        
        zakladki.addTab("Zakładka 1", panel1);
        zakladki.addTab("Zakładka 2", new JLabel("TO jest pierwsza zakładka"));
        zakladki.setMnemonicAt(0, KeyEvent.VK_T);
        panel1.add(new JLabel("Stwórz nowy plik o nazwie:"));
        JTextField nazwaNowejZakladki = new JTextField(7);
        panel1.add(nazwaNowejZakladki);
        JButton stworzZakladke = new JButton("Stwórz");
        panel1.add(stworzZakladke);
        
        stworzZakladke.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               JPanel panelTekstowy = new JPanel();
               panelTekstowy.setLayout(new GridLayout(1, 1));
               JTextArea obszarTekstowy = new JTextArea();
               panelTekstowy.add(new JScrollPane(obszarTekstowy));
               
               zakladki.addTab(nazwaNowejZakladki.getText()+".txt", panelTekstowy);
               zakladki.setSelectedIndex(zakladki.getTabCount()-1);
               
               obszarTekstowy.addKeyListener(new KeyAdapter() {
                   @Override
                   public void keyPressed(KeyEvent e) {
                      if (!(tytulZakladki+e.getKeyChar()).equals(przedZmianaObszarTekstowego) && czyToAscii(e.getKeyChar()) && flagaZapisu==true){
                          przedZmianaObszarTekstowego = tytulZakladki+e.getKeyChar();
                          zakladki.setTitleAt(indexZakladki, tytulZakladki+"*");
                          flagaZapisu = false;
                      }    
                      else if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_S && flagaZapisu == false){
                          zakladki.setTitleAt(indexZakladki, tytulZakladki);
                          flagaZapisu = true;
                      }
                   }
                   private boolean czyToAscii(char zn)
                    {
                        for (int i = 0; i <256; i++)
                            if (zn == i)
                                return true;
                        return false;
                    }
                   String przedZmianaObszarTekstowego = "";
                   int indexZakladki = zakladki.getSelectedIndex();
                   String tytulZakladki = zakladki.getTitleAt(indexZakladki);
                   boolean flagaZapisu = true;
                });
               
            }
        });
        
        zakladki.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        this.getContentPane().add(zakladki);
        this.setDefaultCloseOperation(3);
    }
    
    private JTabbedPane zakladki = new JTabbedPane();
    private JPanel panel1 = new JPanel();
    
    public static void main(String[] args) {
        new Zakladki().setVisible(true);
    }
    
}
