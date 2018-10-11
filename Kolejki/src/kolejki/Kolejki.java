
package kolejki;

import java.util.*;
import java.io.*;
import java.util.concurrent.*;

public class Kolejki {

   
    public static void main(String[] args) {
        
        BlockingQueue<File> kolejkaBlokujaca = new ArrayBlockingQueue<File>(5);
        
    }
    
    final static private File sciezkaGlowna = new File(System.getProperty("user.dir"));
    
    final static private String slowoSzukane = new String("źródło");
    
}

class PoszukiwaczSciezek implements Runnable{

    @Override
    public void run() {
        
    }
    
}

class PrzeszukiwaczPlikow implements Runnable{

    @Override
    public void run() {
        
    }
    
}

