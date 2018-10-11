
package porownywanieelementowtreeset;


import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

class Element implements Comparable{
    
    int wartosc;
    String opis;
    
    
    public Element (int wartosc) {
        this.wartosc = wartosc;
    }
    
    public Element (int wartosc, String opis) {
        this.wartosc = wartosc;
        this.opis = opis;
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
    
    
    public String PobierzOpis(){
        return opis;
    }

    @Override
    public int compareTo(Object o) {
        return wartosc - ((Element)o).wartosc;
    }
    
    
}








public class PorownywanieElementowTreeSet {

   
    public static void main(String[] args) {
       
        long mili = 0;
        long totalMili = 0;
        
        Set<Element> set = new TreeSet<Element>(
                new Comparator<Element>() {
                    @Override
                    public int compare(Element o1, Element o2) {
                        String opisO1 = o1.PobierzOpis();
                        String opisO2 = o2.PobierzOpis();
                        
                        return opisO1.compareTo(opisO2);
                    }
                    
                }
        
        );
        set.add(new Element(1541, "dupek"));
        set.add(new Element(11, "kowboj"));
        set.add(new Element(117, "dudus"));
        
        Iterator<Element> iter = set.iterator();
        while(iter.hasNext())
            System.out.println(iter.next().wartosc);
        
        System.out.println("Czas wykowania: "+ totalMili + "ms");
        System.out.println("Wielkość zbioru: "+ set.size());
        
    }
    
}
