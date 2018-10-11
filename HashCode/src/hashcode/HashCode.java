package hashcode;

class Element{
    
    public Element(int wartosc){
        this.wartosc = wartosc;
    }
    
    @Override
    public boolean equals(Object obj) {
        
        if(this == obj) return true;
        if(obj==null || this.getClass() != obj.getClass()) return false;
        return this.wartosc ==((Element)obj).wartosc;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 14 * hash + this.wartosc;
        return hash;
    }
    
    int wartosc;
    
}



public class HashCode {

    
    
    
    public static void main(String[] args) {
        
        Element a = new Element(5);
        Element b = new Element(9);
        
        System.out.println(a==b); // takie wywowałnie sprawdza równośc adresów a nie wartości
        System.out.println(a.equals(b));
        
        System.out.println(a.hashCode()%32);
        System.out.println(b.hashCode()%32);
                
    }
    
}
