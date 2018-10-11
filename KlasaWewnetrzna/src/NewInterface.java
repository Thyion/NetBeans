/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Krzysztof
 */
public interface NewInterface {
    
    
    default void dupa(){
        System.out.println("ddssd");
    };
    
    void sss();
    
}

class Pracownik implements NewInterface {

    @Override
    public void sss() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    Pracownik pracownik = new Pracownik();
    
    public Pracownik() {
        
    }
    
    
}
