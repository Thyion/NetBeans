
package hashsetandtreeset;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

class Element {
    
    public Element (int wartosc) {
        this.wartosc = wartosc;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        return this.wartosc == ((Element)obj).wartosc;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.wartosc;
        return hash;
    }
    
    
    int wartosc;
    
    
}


public class HashSetAndTreeSet {

    //hashset nie ma upporzadkowanych elementow
    //TreeSet jest uporzadkowany alfabetycznie
    
    public static void main(String[] args) {
       
        
        long mili = 0;
        long totalMili = 0;
        
            Set<String> set = new HashSet<String>(512);
            set = new TreeSet<String>();
            
        try {    
            Scanner reader = new Scanner(new BufferedReader(new FileReader("informatyka.txt")));
            
            while (reader.hasNext()){
                
            
            
            mili = System.currentTimeMillis();
            
            set.add(reader.next());
            
            totalMili += System.currentTimeMillis() - mili;
            
            }
            reader.close();
            
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Nie ten plik");
        }
        
        Iterator<String> iter = set.iterator();
        while(iter.hasNext())
            System.out.println(iter.next());
        
        System.out.println("Czas wykowania: "+ totalMili + "ms");
        System.out.println("Wielkość zbioru: "+ set.size());
        
    }
    
}
