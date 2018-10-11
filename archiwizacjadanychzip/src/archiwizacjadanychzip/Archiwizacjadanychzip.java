
package archiwizacjadanychzip;


import java.io.*;
import java.util.zip.*;

public class Archiwizacjadanychzip {

    public static final int BUFOR = 1024;
    
    public static void main(String[] args) {
       
        String[] tab = new String[4]; 
        tab[0] = ("inny.txt");
        tab[1] = ("manifest.mf");
        tab[2] = ("obrazek.jpg");
        tab[3] = ("build.xml");
        
      
        byte tmpData[] = new byte[BUFOR];
        try {
            ZipOutputStream zOutS = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream("nazwamojegozipa.zip")));
            
            for (int i =0; i < tab.length; i++) 
            {
            BufferedInputStream inS = new BufferedInputStream(new FileInputStream(tab[i]), BUFOR);
            zOutS.putNextEntry(new ZipEntry(tab[i]));
            
            int counter;
            while ((counter = inS.read(tmpData, 0, BUFOR)) != -1) 
            //te -1 oznacza ze wykonuje sie dopuki nie jest koniec strumienia("pliku")
                zOutS.write(tmpData, 0, counter);
              
            zOutS.closeEntry();
            inS.close();    
            }
            
            zOutS.close();
            //BufferedInputStream - poto aby sie buforowalo szybciej
            //FIleInputStream - poto aby dalo sie otworzyc pliki
        }
        catch(IOException e) {
            System.out.println(e.getMessage());
        }
        
       
        //TERAZ OTWIERANIE ZIP
        
        
        
        File katalog = new File(System.getProperty("user.dir")+File.separator+"nazwamojegozipa");
        //user.dir służy do pobrania ścieżki gdzie jest ten program
        ZipEntry wpis = null;
        
        try {
            if(!katalog.exists())
                katalog.mkdir();
            
            ZipInputStream zInS = new ZipInputStream(new BufferedInputStream(new FileInputStream("nazwamojegozipa.zip")));
            
            while ((wpis = zInS.getNextEntry()) != null)
            {
                BufferedOutputStream fOutS = new BufferedOutputStream(new FileOutputStream(katalog+File.separator+wpis.getName()));
                
                int counter;
                while ((counter = zInS.read(tmpData, 0, BUFOR)) != -1) 
                //te -1 oznacza ze wykonuje sie dopuki nie jest koniec strumienia("pliku")
                fOutS.write(tmpData, 0, counter);
                
                fOutS.close();
                zInS.closeEntry();;
                
            }
            
            
            zInS.close();
        
        }
        catch (IOException e) {
            System.out.println(e.getMessage());        
        }
        
        
    }
    
}
