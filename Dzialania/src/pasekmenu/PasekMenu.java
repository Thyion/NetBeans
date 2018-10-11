package pasekmenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PasekMenu extends JFrame{
    public PasekMenu() {
        initComponents();
    }
    
    public void initComponents() {
        this.setTitle("PasekMenu");
        this.setBounds(300, 300, 300, 300);
        this.setDefaultCloseOperation(3);
        this.setJMenuBar(pasekMenu);
        this.getContentPane().setLayout(new GridLayout(2, 1));
        this.getContentPane().add(obszarTekstowwy);
        
    
        JMenu menuPlik = pasekMenu.add(new JMenu("Plik"));
            menuPlik.addSeparator();
            Action actionSave = new ActionSave("Zapisz", "Zapisujemy plik", "ctrl S", new ImageIcon("aaa.ico"), KeyEvent.VK_Z);
            JMenuItem menuPlikZapisz = menuPlik.add(actionSave);
            
            guzik = new JButton(actionSave);
            this.getContentPane().add(guzik);
            //guzik.addActionListener(actionSave);
            
//            menuPlikZapisz.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.out.println("KOD ZAPISUJĄCY PLIK");
//                menuPlikZapisz.setEnabled(flagaObszaruTekstowego=false);
//            }
//            });
            //menuPlikZapisz.setToolTipText("Zapisanie pliku");
            //menuPlikZapisz.setMnemonic('Z'); //podkreśla jakieś znaki w nazwie pliku, można dzieki temu je wybierac alt+ten znak
            //menuPlikZapisz.setAccelerator(KeyStroke.getKeyStroke("ctrl S")); // dodaje skrót klawiszowy do wykonywania danej akcji
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
            menuPlikOpcje.add(tylkoDoOdczytu);
                    tylkoDoOdczytu.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (tylkoDoOdczytu.isSelected())
                                menuPlikZapisz.setEnabled(false);
                            else {
                                menuPlikZapisz.setEnabled(flagaObszaruTekstowego);
                            }
                        }
                    });
        obszarTekstowwy.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) 
            {
                if (tylkoDoOdczytu.isSelected())
                    e.consume();
            }
            @Override
            public void keyPressed(KeyEvent e) 
            {
                if (tylkoDoOdczytu.isSelected())
                    e.consume();
                else if (!(obszarTekstowwy.getText()+e.getKeyChar()).equals(przedZmianaObszaruTekstowego) && czyToAscii(e.getKeyChar())) {
                    przedZmianaObszaruTekstowego = obszarTekstowwy.getText()+e.getKeyChar();
                    actionSave.setEnabled(flagaObszaruTekstowego=true);
                    //guzik.setEnabled(flagaObszaruTekstowego=true);
                }
                
                System.out.println(obszarTekstowwy.getText()+e.getKeyChar());
            }
        });
     
    }
    private JMenuBar pasekMenu = new JMenuBar();
    private JCheckBoxMenuItem tylkoDoOdczytu = new JCheckBoxMenuItem("Tylko do odczytu");
    private JTextArea obszarTekstowwy = new JTextArea();
    private boolean flagaObszaruTekstowego = false;
    private String przedZmianaObszaruTekstowego = "";
    private boolean czyToAscii(char zn)
    {
        for (int i = 0; i <256; i++)
            if (zn == i)
                return true;
        return false;
    }
    private JButton guzik;
    
    private class ActionSave extends AbstractAction {
        
        public ActionSave(String name, String podpowiedz, String klawiaturySkrot, Icon ikona, int mnemonicKey){
            this.putValue(NAME, name);
            this.putValue(SHORT_DESCRIPTION, podpowiedz);
            this.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(klawiaturySkrot));
            this.putValue(SMALL_ICON, ikona);
            this.putValue(MNEMONIC_KEY, mnemonicKey);
        }   
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Action Save");
            this.setEnabled(flagaObszaruTekstowego=false);
            guzik.setEnabled(flagaObszaruTekstowego);
        }
        
    }
    
    public static void main(String[] args) {
        new PasekMenu().setVisible(true);
    }
    
}
