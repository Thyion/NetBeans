
package oknowyboruplikow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.util.Arrays;


public class OknoWyboruPlikow extends JFrame{

    
    public OknoWyboruPlikow() {
        this.setDefaultCloseOperation(3);
        this.setBounds(300, 300, 300, 300);
        this.setTitle("Okno wyboru plików");
        
        final JFileChooser wyborPlikow = new JFileChooser();
        
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int tmp = wyborPlikow.showOpenDialog(rootPane);
                if (tmp ==0)
                   stworzPlikZip(wyborPlikow.getSelectedFiles()); 
                
            }
        });
        
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //wyborPlikow.showSaveDialog(rootPane);
                wyborPlikow.showDialog(rootPane, "Zip in that place");
            }
        });
        
        this.getContentPane().add(panel);
        this.panel.add(button1);
        this.panel.add(button2);
        
        wyborPlikow.setCurrentDirectory(new File(System.getProperty("user.dir")));
        wyborPlikow.setMultiSelectionEnabled(true);
        wyborPlikow.setAcceptAllFileFilterUsed(true); //pozwala na wybieranie rodzaju pliku
        
        String[] aaa = new String[2];
        aaa[0] = ".mf";
        aaa[1] = ".xml";
        wyborPlikow.setFileFilter(new FiltrRozszerzen("Pola tekstowe", aaa));
        
        wyborPlikow.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                return f.isDirectory();
            }

            @Override
            public String getDescription() {
                return "Katalogi";
            }
        });
    
    
    }
    
    
    
    private JPanel panel = new JPanel();
    private JButton button1 = new JButton("Otwórz");
    private JButton button2 = new JButton("Zapisz");
    
    
    public void stworzPlikZip(File[] pliki){
        for (int i =0; i < pliki.length; i++){
            System.out.println(pliki[i].getPath());
        }
    }
    
    public static void main(String[] args) {
        new OknoWyboruPlikow().setVisible(true);
    }
    
    private class FiltrRozszerzen extends FileFilter {
        public FiltrRozszerzen(String opis, String[] rozszerzenia){
            this.opis = opis;
            this.rozszarzenia = rozszerzenia;
        }
        
        @Override
        public boolean accept(File f) {
            for (int i=0;i < this.rozszarzenia.length; i++)
                
                if (f.getName().toLowerCase().endsWith(this.rozszarzenia[i]) || f.isDirectory())
                    return true;
                return false;
            
        }    
        

        @Override
        public String getDescription() {
           return opis;
        }
        
        private String opis;
        private String[] rozszarzenia;
    }
    
    
}
