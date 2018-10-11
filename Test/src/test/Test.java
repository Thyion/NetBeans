/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author Krzysztof
 */
public class Test {

    public class Kupa {
        Kupa() {
                    
        }
    }
    
    public class Ttt extends Kupa{
        
    }
    
    public static void main(String[] args) {
        
        int i = 5;
        Integer j = 10;
        changePrimitive(i);
        changeObject(j);
        
        System.out.println(i);
        System.out.println(j);
        
        
        
    }
    
    static void changePrimitive(int i) {
        i = 5;
        
    }
    static void changeObject(int j) {
        j=30;
    }
}
