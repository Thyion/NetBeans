
package goyello2;



public class Goyello2 {

    
    static class MyException1 extends RuntimeException {
        
    }
    static class MyException2 extends RuntimeException {
        
    }
    static class MyException3 extends RuntimeException {
        
    }
    public static void main(String[] args) {
    /* 
        try (A a = new A()) {
            a.doSomething();
        } catch(Exception e){
            
        }
    }    
}

class A implements AutoCloseable {
    void doSomething() {
        System.out.println("A");
    }

    public void close() {
        System.out.println("B");
    }
*/
    
    
    
    
        
        try {
            throw new MyException1();
        } catch (MyException1 | MyException2 | MyException3 e) {
            //e.printStackTrace();
        }
    }
}
