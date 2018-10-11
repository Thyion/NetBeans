/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goyello11;

/**
 *
 * @author Krzysztof
 */
public class Goyello11 {

    public void a() {
        System.out.println("A.a");
    }
    public static void main (String args[]) {
        B aaa = new B();
        aaa.a();
        aaa.a(5);
        Goyello11 bbb = new Goyello11();
        bbb.a();
    }
    
}

class B extends Goyello11 {
    @Override
    public void a(){
        super.a();
        System.out.println("B.a");
}
    public void a(int x) {
        
        System.out.println("fff");
    }
    
    
}