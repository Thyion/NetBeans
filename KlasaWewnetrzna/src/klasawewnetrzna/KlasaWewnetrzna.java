/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package klasawewnetrzna;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import klasawewnetrzna.A.B;

/**
 *
 * @author Krzysztof
 */
public class KlasaWewnetrzna {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        List strings = Arrays.asList("A", "B", "C", "D");
        Predicate<String> predicate = a->!a.startsWith("A");
        /*
        Predicate<String> predicate = new Predicate<String>(){
            @Override
           public boolean test(String a){
                return a.startsWith("A");
            }
        };
        */
        /*
        //Predicate<String> predicate = a ->a.startsWith("B");
        //predicate.or(a->a.startsWith("C")).or(a->a.startsWith("D"));
        */
        /*
        Predicate<String> predicate = a -> a.startsWith("B");
        predicate = predicate.or(a->a.startsWith("C")).or(a->a.startsWith("D"));
        */
        List result = (List) strings.stream()
                .filter(predicate)
                .collect(Collectors.toList());
        System.out.println(result);
        
        A cc = new A() {};
        cc.dupa();
    }
    
}

abstract class A {
    
    void dupa(){
        
    }
    A(){
        System.out.println("ddddd");
        
        
        
    }
    
    static class B {
    B() {
        System.out.println("fsffff");
        }
    }
}

class C extends B{
    
}
