
package swobodnydostepdoplikow2;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SwobodnyDostepDoPlikow2 {

   
    public static void main(String[] args) {
       Towar[] towar = new Towar[3];
       
       towar[0] = new Towar();
       towar[1] = new Towar(29, "Video Kurs Java");
       towar[2] = new Towar(46, "Video Kurs C++", 2008, 11, 23);
       
       try {
           
            RandomAccessFile RAF = new RandomAccessFile("baza.txt", "rw"); //"r" - czytamy, "w" zapisujemy, "rw" - czytamy i zapisujemy
           
            Towar.SaveToFile(towar, RAF);
            
            RAF.seek(0); // cofamy FIle Pointer do 0, bo po zapisywaniu było już na koncz=u np. 240
            Towar a = new Towar();
            a.czytajDane(RAF);
            System.out.println(a);
            
            RAF.seek(0);
            Towar[] b = Towar.ReadFromFile(RAF);
            for (int i = 0; i<b.length; i++){
                System.out.println(b[i]);
            }
            
            
           
           try {
                Towar c = new Towar();
               c.czytajWskazanyRekord(RAF, 53);
               System.out.println(c);
           } catch (BrakRekordu ex) {
               System.out.println(ex.getMessage());
           }
            
            
            RAF.close();
            
            
       
       
       }
       catch (IOException e){
           System.out.println(e.getMessage());
        }
       
       
    }
    
}
