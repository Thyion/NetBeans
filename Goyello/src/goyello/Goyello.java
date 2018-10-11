
package goyello;

import java.util.function.IntBinaryOperator;
public class Goyello {

    
    public static void main(String[] args) {
        A a = new B();
        B b = new B();
        
        IntBinaryOperator io = (x,y)->x +y;
    
    System.out.println(io.applyAsInt(2,3));
    
   
    }
    
}


class A {
    A() {
        System.out.println("A");
    }
}

class B extends A{
    B() {
        
        System.out.println("B");
    }
    
}