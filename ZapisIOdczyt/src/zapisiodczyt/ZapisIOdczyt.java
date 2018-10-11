
package zapisiodczyt;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ZapisIOdczyt {

   
    public static void main(String[] args) {
        try {
            PrintWriter drukarz = new PrintWriter(new FileWriter("dane.txt", true)); //to true znaczy że plik nie będzie ciagle tworzony od nowa tylko bedzie stały
            
            drukarz.println(1123554);
            //drukarz.flush(); //wymusza zapisanie rzeczxy z buffora
            drukarz.close();
            
            drukarz = new PrintWriter(new FileWriter("dane.txt", true));
            drukarz.append("lala"); //append znaczy dołącz cooś.
            drukarz.println(99999);
            drukarz.printf("On ma %d kilogramów oraz %.0f %s wzrostu", 50, 165.4, "cm");
            drukarz.close();
            
            
            BufferedReader reader = new BufferedReader(new FileReader("dane.txt"));
            
            
            
            //System.out.println(reader.read()); //drukuje nam kod aisi znaku - trzeba zrzutowac na (char) aby zobaczyc co to
            //System.out.println(reader.readLine()); // czyta linijke cała
            //poniższe writer umozliwia skopiowanie zawartosci pliku
            BufferedWriter writer = new BufferedWriter(new FileWriter("baza.txt"));
            
            String tresc = ""; //ponizej wypisanie wszystkiego z pliku
            while((tresc = reader.readLine()) != null) {
                System.out.println(tresc);
                writer.write(tresc);
                writer.newLine();
            }
            
            writer.close();
            reader.close();
            
        } catch (IOException e) {
            
            System.out.println(e.getMessage());
        }
        
        ZapisIOdczyt.test(23,43,346534,343);
    }
    
    static void test(Object... a){
        for (int i =0; i<a.length; i++){
           // System.out.println(a[i]);
        }
    }
    
}
