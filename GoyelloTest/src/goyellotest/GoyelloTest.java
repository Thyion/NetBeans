/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goyellotest;

/**
 *
 * @author Krzysztof
 */
public class GoyelloTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         X x1 = new X();
         X x2 = new X();
         
         x1.setX(9);
         x2.setX(10);
         
         System.out.println(x1.getX());
         System.out.println(x2.getX());
         
         System.out.println(X.y);
         X.y = 7;
         System.out.println(X.y);
         
         x1.setY(X.y + 1);
         System.out.println(x1.getY());
    }
    
}

class X {
    final int x = 0;
    static int y;
    void setX (int n) { x=n;}
    void setY (int n) { y=n;}
    int getX () {return x;}
    int getY () { return y;}
}