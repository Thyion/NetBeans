/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goyello12;




public class Goyello12 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        A a = new B();
        B b = new B();
        C y = new C();
    
    String myString = "555";
    
    myString = myString.concat("777");
    System.out.println(myString);
    
    String tekst = "Ala";
// Poniższa linia zwróci tekst: Ala ma kota
    System.out.println(tekst.concat(" ma kota"));
    }
    
}

class A {
    A(int y) {
        System.out.println("A");
    }
}

class B extends A{
    B() {
        super(3);
        System.out.println("B");
    }
}
class C extends B{
    
}