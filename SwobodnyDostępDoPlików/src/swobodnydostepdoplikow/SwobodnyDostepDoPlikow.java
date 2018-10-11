/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swobodnydostepdoplikow;
import java.io.*;


public class SwobodnyDostepDoPlikow {

   
    public static void main(String[] args) {
       Towar[] towar = new Towar[3];
       
       towar[0] = new Towar();
       towar[1] = new Towar(29, "Video Kurs Java");
       towar[2] = new Towar(46, "Video Kurs C++", 2008, 11, 23);
       
       try {
            /*
            DataOutputStream outS = new DataOutputStream(new FileOutputStream("nowy.txt"));
            
            outS.writeDouble(5678324);
            outS.close();
                 
            DataInputStream inS = new DataInputStream(new FileInputStream("nowy.txt"));
            System.out.println(inS.readDouble());
            inS.close();
            */
            
            RandomAccessFile RAF = new RandomAccessFile("nowy.txt", "rw"); //"r" - czytamy, "w" zapisujemy, "rw" - czytamy i zapisujemy
            
            RAF.writeDouble(123.42);
            RAF.writeDouble(41.23);
            RAF.writeChars("lalal");
            
            System.out.println(RAF.getFilePointer()); //pokazuje ile Bajtów zajeliśmy
            RAF.seek(21); //poszukuje  dane miejsce w pliku
            System.out.println(RAF.readChar());
            
            RAF.close();
       
       
       }
       catch (IOException e){
           System.out.println(e.getMessage());
        }
       
       
    }
    
}
