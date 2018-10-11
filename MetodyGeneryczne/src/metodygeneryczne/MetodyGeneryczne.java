
package metodygeneryczne;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import static javafx.scene.input.KeyCode.T;

class Edytor {
    public static void wypisz(List<? extends Figura> lista){
        for (Figura figura : lista)
            System.out.println(figura.getName());
        
        //lista.add(new Kolo()); Kicha nie mozna teraz dodawac nic do listy
        //pozwala dodać tylko dane typu <?> czyli żadnego bo nieoznaczone....
        //można dodać tylko "null"
        lista.add(null);
              
                
        
        System.out.println("------------");
        
        for (Figura figura : lista){
            if (figura == null){
                System.out.println("null");
                break;
            }
            System.out.println(figura.getName());
                      
        }
    }
    
    public static <T extends Figura> void wypisz2(List<T> lista){
        for (T figura : lista)
            System.out.println(figura.getName());
        
        //już możemy dodawac Kolo itp
        // ale musimy je na wszelki wypadek rzutowac do <T>
        lista.add((T) new Kolo());
        lista.add((T) new Kolo());
        lista.add((T) new Kolo());
        lista.add(null);
              
                
        
        System.out.println("------------");
        
        for (T figura : lista){
            if (figura == null){
                System.out.println("null");
                break;
            }
            System.out.println(figura.getName());
                      
        }
    }
    
    public static <T> void przepiszTabliceDoKolekcji(T[] tab, Collection<T> c){
        
        //<T> - dzieki temu tworzymy METODE GENERYCZNA
        //mozna wpisac kilka typów
        
        for(T o: tab)
            c.add(o);
    }    
            
            
      
        
        
   
}

class Figura {
    String name = "";
    
        public String getName(){
            return name;
    }
}   

class Kolo extends Figura{
    public Kolo() {
        super.name = "Koło";
    }
    
    @Override
    public String toString() {
        return name;
    }
}
class Trojkat extends Figura{
    public Trojkat() {
        super.name = "Trójkąt";
    }
    
    @Override
    public String toString() {
        return name;
    }
}
    




public class MetodyGeneryczne {

    
    public static void main(String[] args) {
        
        Figura figura1 = new Kolo();
        Figura figura2 = new Trojkat();
        Figura[] figury = new Figura[50];
        
        List<Figura> listaFigur = new ArrayList<Figura>();
        listaFigur.add(figura1);
        listaFigur.add(figura2);
        System.out.println(listaFigur);
        //Edytor.wypisz(listaFigur);
        Edytor.wypisz2(listaFigur);
        
        Float[] fl = new Float[50];
        Integer[] in = new Integer[50];
        Number[] nu = new Number[50];
        Collection<Number> cn = new ArrayList<Number>();
        Edytor.przepiszTabliceDoKolekcji(fl, cn);
        Edytor.przepiszTabliceDoKolekcji(in, cn);
        Edytor.przepiszTabliceDoKolekcji(nu, cn);
        
    }
    
}
