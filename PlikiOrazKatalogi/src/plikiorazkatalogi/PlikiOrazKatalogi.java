
package plikiorazkatalogi;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


public class PlikiOrazKatalogi {

    
    public static void main(String[] args) {
        
        try {
        
            File katalog = new File("Folder"+File.separator+"PodFolder");
            katalog.mkdirs();
            File plik2 = new File("Folder"+File.separator+"PodFolder", "kurs.txt");
            if (!plik2.exists()) 
            {
            
                plik2.createNewFile();
            }
            
            
            
            File plik = new File("Text.txt");
            //plik.setWritable(false);
            if (!plik.exists()) 
            {
            
                plik.createNewFile();
            }
            
            System.out.println(plik.getAbsolutePath());
            System.out.println(plik.getCanonicalPath());
            
            System.out.println("Czy mogę pisać ? :" + plik.canWrite());
            System.out.println("Czy mogę odpalić ? :" + plik.canExecute());
            System.out.println("Czy mogę czytać ? :" + plik.canRead());
            System.out.println("Czy jest ukryty ? :" + plik.isHidden());
            System.out.println("Czy jest plikiem ? :" + plik.isFile());
            System.out.println("Ostatnia modyfikacja : " + new Date(plik.lastModified()));
            System.out.println("Długość pliku w bajtach (ilość znaków) :" + plik.length());
            System.out.println("----------------");
            PlikiOrazKatalogi.wypiszSciezki(new File(System.getProperty("user.dir")));
            System.out.println("----------------");   
//plik.delete();
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
          
        
        System.out.println(System.getProperty("user.dir"));
        //można różne rzeczy sprawdzać 
        
        }
        
        public static void wypiszSciezki (File nazwaSciezki) {
           String[] nazwyPlikowIKatalogow = nazwaSciezki.list();
           System.out.println(nazwaSciezki.getPath());
           for (int i = 0;i < nazwyPlikowIKatalogow.length; i++) {
            
            File p = new File(nazwaSciezki.getPath(), nazwyPlikowIKatalogow[i]);
            //System.out.println(p.getName());
            
            System.out.println(p.getPath());
            
            if (p.isFile()) {
                System.out.println(p.getPath());
            }
            //wypisze tylko same pliki /\/\
            if (p.isDirectory())
                wypiszSciezki(new File(p.getPath()));
            //przeszuka wszystkie foldery
           }
        }
    
        
        
    }
    

