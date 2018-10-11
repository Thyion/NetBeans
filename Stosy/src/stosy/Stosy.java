
package stosy;

import java.util.*;


public class Stosy {

    
    public static void main(String[] args) {
        
        
        Stack<String> stos = new Stack<String>();
        
        stos.push("ala1");
        stos.push("ala2");
        stos.push("ala3");
        stos.push("ala4");
        stos.push("ala5");
        
        System.out.println(stos);
        stos.pop();
        System.out.println(stos);
        
        String nazwa = stos.peek();
        System.out.println(nazwa);
    }
    
}
