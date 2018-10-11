/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goyello2;

/**
 *
 * @author Krzysztof
 */
public class Test {
    
    /*
    static class MyException extends RuntimeException {}
    
    public static void main(String args[]) {
        try {
            throw new MyException();
        } catch (MyException e) {
            System.out.println("1");
        } catch (RuntimeException e) {
                    System.out.println("2");
                    return;
        } catch (Exception e) {
            System.out.println("3");
        } finally {
            System.out.println("5");
        }
        
    }
    */
    
    static class MyException1 extends RuntimeException {
        
    }
    static class MyException2 extends RuntimeException {
        
    }
    static class MyException3 extends RuntimeException {
        
    }
    
    public static void main(String args[]) {
        
        try {
            throw new MyException1();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }
    
    
}
