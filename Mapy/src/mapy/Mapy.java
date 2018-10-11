
package mapy;

import java.util.*;
import java.util.Map.Entry;


public class Mapy {

    
    public static void main(String[] args) {
       
        Map <Integer, String> mapa1 = new HashMap();
        SortedMap <Integer, Pracownik> mapa2 = new TreeMap();
        Map <Integer, Integer> mapa = new TreeMap();
        
        
        Pracownik[] pracownicy = {
            new Pracownik("Agnieszka"),
            new Pracownik("Bartłomiej"),
            new Pracownik("Wacław"),
            new Pracownik("Arkadiusz"),
            new Pracownik("Duduś"),
            new Pracownik("Pankracy"),
            new Pracownik("Gerwazy"),
            new Pracownik("Krzysztof"),
            
           
        };
        
        for (Pracownik pracownik : pracownicy)
            mapa1.put(pracownik.getID(), pracownik.getImie());
        
        
        System.out.println(mapa1);
        
        mapa1.remove(3);
        
        System.out.println(mapa1);
        
        mapa1.put(3, "Kamil");
        
        System.out.println(mapa1);
        
        System.out.println("---------------------");
        
        for (Pracownik pracownik : pracownicy)
            mapa2.put(pracownik.getID(), pracownik);
        
        System.out.println(mapa2);
        
        // WIDOK MAPY //
        
      
        for(Entry<Integer, Pracownik> wpis: mapa2.entrySet()){
            System.out.println("ID praconika: " + wpis.getKey());
            System.out.println("Imię pracownika: " + wpis.getValue());
        }
        
        Map<Integer, Pracownik> subMapa = mapa2.subMap(0,5);
        
        
        
        if (subMapa.isEmpty())
            System.out.println("PUSTO");
        else
            for(Entry<Integer, Pracownik> wpis: subMapa.entrySet()){
                System.out.println("ID praconika: " + wpis.getKey());
                System.out.println("Imię pracownika: " + wpis.getValue());
            }
    }
    
}

class Pracownik {
    public Pracownik() {
        i++;
        ID = i;
    }
    public Pracownik(String imie) {
        i++;
        ID = i;
        this.imie = imie;
    }
    
    public int getID(){
        return ID;
    }
    
    public String getImie(){
        return imie;
    }
    
    @Override
    public String toString() {
        return imie;
    }
    
    String imie;
    private int ID;
    public static int i = 0;
}
