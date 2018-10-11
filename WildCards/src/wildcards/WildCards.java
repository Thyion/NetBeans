
package wildcards;

import java.util.ArrayList;
import java.util.List;

class SuperClass {
    public static void tester(List<? extends SuperClass> lista) {
        // /\/\ ten "extends" ogranicza ze tylko ten rodzaj clasy mozna wczytywać i jej pochodne
        // ten <?> to jest wildcard > znak wieloznacznosci
    }
    
    
    
}

class SubClass extends SuperClass {
    
}

public class WildCards {

    
    public static void main(String[] args) {
        
        List<String> listaStringow = new ArrayList();
        
        
        List<SuperClass> listaClass = new ArrayList<SuperClass>();
        listaClass.add(new SuperClass());
        listaClass.add(new SubClass());
        
        SuperClass.tester(listaClass);
        
        ArrayList<String> listaS = new ArrayList<String>();
        ArrayList<Object> listaO = new ArrayList<Object>();
        
    }
    
}
