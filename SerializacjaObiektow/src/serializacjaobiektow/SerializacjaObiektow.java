
package serializacjaobiektow;

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;



public class SerializacjaObiektow {

    //Serializacja naraża nasze dane na wykradzenie. Poniważ widać wszystko w plikach zapisanych
   
    public static void main(String[] args) {
       Towar[] towar = new Towar[3];
       
       towar[0] = new Towar();
       towar[1] = new Towar(29, "Video Kurs Java");
       towar[2] = new Towar(46, "Video Kurs C++", 2008, 11, 23);
       
       try {
           ObjectOutputStream outS = new ObjectOutputStream(new GZIPOutputStream(new FileOutputStream("baza.txt")));
           
           //GZIP - kompresuje dane, zajmują mniej, szybciej się zapisuje i przesyła
//klasa ObjectOutputStream pozwala nam serializować obiekty
           //aby działało to klasa którą bedziemy serializować (towary w tym przypadku)
           //muszą omplementować interfejjs Serializable
           
           outS.writeObject(towar);
           outS.close();
           
           ObjectInputStream inS = new ObjectInputStream(new GZIPInputStream(new FileInputStream("baza.txt")));
            //klasa ObjectOutputStream pozwala nam serializować obiekty
            //inS.readObject();
            Towar[] a = (Towar[])inS.readObject();
            //moglibysmy tz wczytac klase co rozszerza klase Towar (np.Mleko) i tez by zassało 
            //bo by pamietalo ze to pochodzi od Towar.
            inS.close();
            for(int i = 0; i < a.length;i++)
            System.out.println(a[i].GetNazwa());
       }
       catch (IOException e){
           System.out.println(e.getMessage());
        }
       catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
       }
    }
    
}
