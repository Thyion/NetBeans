
package typygeneryczne;

import java.util.ArrayList;

public class TypyGeneryczne {

   
    public static void main(String[] args) {
        ArrayList<String> a = new ArrayList();
        
        a.add(new String("lala"));
        a.add(new String("fgh"));
        
        //for (int i = 0; i<a.size();i++)
           //System.out.println((String)a.get(i));
           //Teraz gdy mamy pewnosc ze sa tylko Stringi mozemy uzyc uproszczonej petli FOR
        for(String stringus:a)
            System.out.println(stringus);
        
        
    Zwykla<String> dupa = new Zwykla<String>();
    dupa.nadajWartosc("lala");
    System.out.println(dupa.zwroc());
    }
    
    
}

class Zwykla <COKOLWIEK> {
    COKOLWIEK nazwaZmiennejTypuCokolwiek;
    public COKOLWIEK zwroc() {
        return this.nazwaZmiennejTypuCokolwiek;
    }
    
    public void nadajWartosc(COKOLWIEK wartosc){
        this.nazwaZmiennejTypuCokolwiek = wartosc;
                
    }
    
    
}
