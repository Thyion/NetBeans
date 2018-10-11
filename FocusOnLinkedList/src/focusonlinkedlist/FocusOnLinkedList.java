
package focusonlinkedlist;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;


public class FocusOnLinkedList {

   
    public static void main(String[] args) {
        LinkedList<String> listaPowiazana = new LinkedList();
        listaPowiazana.add("lala1");
        listaPowiazana.add("lala2");
        listaPowiazana.add("lala3");
        listaPowiazana.add("lala4");
        listaPowiazana.add("lala5");
        FocusOnLinkedList.wypiszElementyListy(listaPowiazana);
        
        //poniższe wypisanie jest tragiczne i strasznie długie dla LinkedList
        //poniewaz aby dojść do 89 pozycji musi przejsc wszystkie pokolei (każdy nastepny mowi gdzie jest kolejny usadowiony element)
        /*
        for (int i=0; i<listaPowiazana.size();i++){
            System.out.println(listaPowiazana.get(i));
        }
        */
        
        Iterator<String> iter = listaPowiazana.iterator();
        
        iter.next();
    //  iter.remove(); //ta komenda zawsze usuwa poprzednika w LinkedList
        FocusOnLinkedList.wypiszElementyListy(listaPowiazana);
        
        ListIterator<String> listIter = listaPowiazana.listIterator(listaPowiazana.size());
        // ten iterator ma wiecej metod, dodawanie itp
        while (listIter.hasPrevious()){
            System.out.println(listIter.previous());
             listIter.set("podmiana"); //podmienia wartości na "cos"
           
        }
        
        listIter = listaPowiazana.listIterator();
        
        listIter.add("nowylala");
        
        FocusOnLinkedList.wypiszElementyListy(listaPowiazana);
        
        
        
        
            
        
    }
    
    public static void wypiszElementyListy(LinkedList<?> lista){
        Iterator iteratorListy = lista.iterator();
        
        while(iteratorListy.hasNext())
            System.out.println(iteratorListy.next()); 
            //po wypisaniu skacze do nastepnego elementu listy i czeka na polecenie
        
    }
}
