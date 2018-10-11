
package abstrakcyjneklasystrumieni;

import java.io.*;

public class AbstrakcyjneKlasyStrumieni {

    
    public static void main(String[] args) throws IOException {
        
        InputStream inS;
        OutputStream outS;
        Reader reader;
        Writer writer = new BufferedWriter(new FileWriter("nazwaPliku.txt"));
        
        ((BufferedWriter)writer).write("lala");
        ((BufferedWriter)writer).newLine();
        ((BufferedWriter)writer).write("nowa linia");
        //wtiter nie ma takich metod jak nowa linia
        //musimy rzutować na bufferedWriter
        
        ((BufferedWriter)writer).close();
        
        //można łączyć strumienie (tzw. FILTROWAĆ STRUMIENIE)
        //bufferefWriter - przyspiesza dzialanie bo wysyla cale pakunki. 
        //Najpierw przechowuje w buforze dane a jak zamykamy strumien to przesyla calosc
    }
    
}
