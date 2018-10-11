
package filezipper;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javax.swing.*;


public class FileZipper extends JFrame{
    
    public FileZipper() {
        
        this.setTitle("Zipper");
        this.setDefaultCloseOperation(3);
        this.setBounds(300,300,300,300);
        this.setMinimumSize(new Dimension(300, 250));
        this.setJMenuBar(pasekMenu);
        
        JMenu menuPlik = pasekMenu.add(new JMenu("Plik"));
        
        
        Action akcjaDodawania = new Akcja("Add", "Guzik do dodawania plików", "ctrl A");
        Action akcjaUsuwania = new Akcja("Erase", "Guzik do usuwania plików", "ctrl E");
        Action akcjaZipowania = new Akcja("ZIP", "Guzik do zipowania plików", "ctrl Z");
        
        JMenuItem menuOtworz = menuPlik.add(akcjaDodawania);
        JMenuItem menuUsun = menuPlik.add(akcjaUsuwania);
        JMenuItem menuZipuj = menuPlik.add(akcjaZipowania);
        
        add = new JButton(akcjaDodawania);
        erase = new JButton(akcjaUsuwania);
        zip = new JButton(akcjaZipowania);
        JScrollPane scrollek = new JScrollPane(lista);
        
        lista.setBorder(BorderFactory.createEtchedBorder());
        GroupLayout layout = new GroupLayout(this.getContentPane());
        layout.setAutoCreateContainerGaps(true);
        layout.setAutoCreateGaps(true);
        
        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                .addComponent(scrollek, 100, 150, Short.MAX_VALUE)
                .addContainerGap(0, Short.MAX_VALUE)
                .addGroup(
                layout.createParallelGroup()
                        .addComponent(add)
                        .addComponent(erase)
                        .addComponent(zip)
                )
        );
        layout.setVerticalGroup(
                layout.createParallelGroup()
                        .addComponent(scrollek, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(
                        layout.createSequentialGroup()
                                .addComponent(add)
                                .addComponent(erase)
                                .addContainerGap(50, Short.MAX_VALUE)
                                .addComponent(zip)
                        
                        )
        
        );
        
        
        
        this.getContentPane().setLayout(layout);
        
        this.pack();
        
    }
    private DefaultListModel modelListy = new DefaultListModel(){
        //tutaj rozszerzamy klase anominowa (czyli taka któa nie ma swojej postaci)
        @Override
        public void addElement(Object obj) {
            lista.add(obj);
            super.addElement(((File)obj).getName());
        }
        @Override
        public Object get(int index) {
            return lista.get(index);
        }
        
        @Override
        public Object remove(int index){
            lista.remove(index);
            return super.remove(index);
                    
        }
        
        ArrayList lista  = new ArrayList();
    };
    private JList lista = new JList(modelListy);
    private JButton add;
    private JButton erase;
    private JButton zip;
    private JMenuBar pasekMenu = new JMenuBar();
    private JFileChooser wybieracz = new JFileChooser();
    
    public static void main(String[] args) {
        new FileZipper().setVisible(true);
    }
    
    private class Akcja extends AbstractAction {

        public Akcja(String nazwa, String opis, String klawiaturowySkrot) {
            this.putValue(Action.NAME, nazwa);
            this.putValue(Action.SHORT_DESCRIPTION, opis);
            this.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(klawiaturowySkrot));
        }
        public Akcja(String nazwa, String opis, String klawiaturowySkrot, Icon ikona) {
            this.putValue(Action.NAME, nazwa);
            this.putValue(Action.SHORT_DESCRIPTION, opis);
            this.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(klawiaturowySkrot));
            this.putValue(Action.SMALL_ICON, ikona);
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().equals("Add"))
                dodajWpisyDoArchiwum();
            else if(e.getActionCommand().equals("Erase"))
                usuwanieWpisowZListy();
            else if(e.getActionCommand().equals("ZIP"))
                stworzArchiwumZip();
        }
        
        private void dodajWpisyDoArchiwum() {
            wybieracz.setCurrentDirectory(new File(System.getProperty("user.dir")));
            wybieracz.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            wybieracz.setMultiSelectionEnabled(true);
            int tmp = wybieracz.showDialog(rootPane, "Dodaj do archiwum");
            
            if (tmp == JFileChooser.APPROVE_OPTION) {
                File[] sciezki = wybieracz.getSelectedFiles();
                
                for (int i =0; i < sciezki.length; i++) {
                    if(!czyWpisSiePowtarza(sciezki[i].getPath()))
                    modelListy.addElement(sciezki[i]);
                }
                       
            }
                
        }
        
        private void usuwanieWpisowZListy() {
            int[] tmp = lista.getSelectedIndices(); //pobieramy to co zazanczone
        
            for (int i = 0; i < tmp.length; i++) 
                modelListy.remove(tmp[i]-i);
                    
        }
        
        private boolean czyWpisSiePowtarza(String testowanyWpis) {
            
            for (int i = 0; i < modelListy.getSize(); i++){
                if (((File)modelListy.get(i)).getPath().equals(testowanyWpis)){
                    return true;
            }
            }
            return false;
        }
        
        private void stworzArchiwumZip() {
            wybieracz.setCurrentDirectory(new File(System.getProperty("user.dir")));
            wybieracz.setSelectedFile(new File(System.getProperty("user.dir")+File.separator+"moja nazwa.zip"));
            int tmp = wybieracz.showDialog(rootPane, "Kompresuj");
            
            if(tmp == JFileChooser.APPROVE_OPTION)
            {
        
      
        byte tmpData[] = new byte[BUFOR];
        try {
            ZipOutputStream zOutS = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(wybieracz.getSelectedFile()),BUFOR));
            
            for (int i =0; i < modelListy.getSize(); i++) 
            {
               if (!((File)modelListy.get(i)).isDirectory())
                   zipuj(zOutS, (File)modelListy.get(i), tmpData, ((File)modelListy.get(i)).getPath());
               else {
                   wypiszSciezki((File)modelListy.get(i));
                   
                   for(int j = 0; j < listaSciezek.size(); j++)
                       zipuj(zOutS, (File)listaSciezek.get(j), tmpData, ((File)modelListy.get(i)).getPath());
                   listaSciezek.removeAll(listaSciezek);
               }
            }
            
            zOutS.close();
            //BufferedInputStream - poto aby sie buforowalo szybciej
            //FIleInputStream - poto aby dalo sie otworzyc pliki
        }
        catch(IOException e) {
            System.out.println(e.getMessage());
        }
        
        
        
            }
       }
        
        
       private void zipuj(ZipOutputStream zOutS, File sciezkaPliku, byte[] tmpData, String sciezkaBazowa) throws IOException{
           BufferedInputStream inS = new BufferedInputStream(new FileInputStream(sciezkaPliku), BUFOR);
            
            zOutS.putNextEntry(new ZipEntry(sciezkaPliku.getPath().substring(sciezkaBazowa.lastIndexOf(File.separator)+1)));
            
            int counter;
            while ((counter = inS.read(tmpData, 0, BUFOR)) != -1) 
            //te -1 oznacza ze wykonuje sie dopuki nie jest koniec strumienia("pliku")
                zOutS.write(tmpData, 0, counter);
              
            zOutS.closeEntry();
            inS.close();
       } 
       
        private void wypiszSciezki (File nazwaSciezki) {
           String[] nazwyPlikowIKatalogow = nazwaSciezki.list();
           System.out.println(nazwaSciezki.getPath());
           for (int i = 0;i < nazwyPlikowIKatalogow.length; i++) {
            
            File p = new File(nazwaSciezki.getPath(), nazwyPlikowIKatalogow[i]);
            //System.out.println(p.getName());
            
      
            
            if (p.isFile()) 
                listaSciezek.add(p);
            //wypisze tylko same pliki /\/\
            if (p.isDirectory())
                wypiszSciezki(new File(p.getPath()));
            //przeszuka wszystkie foldery
           }
        }
       ArrayList listaSciezek = new ArrayList();
       public static final int BUFOR = 1024;      
    }
       
    
}
    
    
    

