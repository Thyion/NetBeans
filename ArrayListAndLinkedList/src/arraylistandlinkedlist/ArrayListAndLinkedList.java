
package arraylistandlinkedlist;

import java.util.ArrayList;
import java.util.LinkedList;

/*
TABLICA - ArrayList
PLUS - Szybki dostęp do zawartości (wiemy co jest w jakiej kolejności)
MINUS - Bardzo wolna przy dodawaniu nowych elementów i usuwaniu
        (za każdym 
UŻYWAMY GDY - chcemy mieć szybki dostęp ale nie będziemy zbyt wiele dodawać

*-----
* | 1 |
* |   |
* -----
* -----
* | 2 |
* |   |
* -----
* -----
* | 3 |
* |   |
* -----
* -----
* | 4 |
* |   |
* -----
*

----------------------------------------------
LINKED LIST
PLUS - bardzo szybka mozliwosc dodawania oraz usuwania elementu
MINUS - bardzo wolne przegladanie - musimy szukać w kazdym poziomie pokolei
Każda linkedLIst wskazuje na nastepna (moze tez na poprzedni) ktora tworzy sie z jej wnetrza(zostaje wywolana)
*-----
* | 1 |
* |   |
* -----

INNY OBIEKT
LINKED LIST tak tworzy że pomiędzy są miejsca w pamięci , mogą tu być inne obiekty
*-----
* | 2 |
* |   |
* -----

INNY OBIEKT

*-----
* | 3 |
* |   |
* -----



*-----
* | 4 |
* |   |
* -----





*/

class ListaPolaczona {
    int wartosc;
    ListaPolaczona nastepna;
    ListaPolaczona poprzedni;
}


public class ArrayListAndLinkedList {

    
    public static void main(String[] args) {
       ArrayList listaTablicowa = new ArrayList(4); //można suatwić CAPACITY > czyli ile ma mieć miejsc, ale nie trzeba
       listaTablicowa.add(new Object());
       listaTablicowa.add(new Object());
       listaTablicowa.add(new Object());
       listaTablicowa.add(new Object());
       listaTablicowa.add(new Object()); //Gdy dodamy 5 to od nowa Stworzy ArrayList z 5 miejscami
       LinkedList listaPolaczona;
       
       
       
       ListaPolaczona listaaPolaczona = new ListaPolaczona();
       listaaPolaczona.wartosc = 110;
       listaaPolaczona.nastepna = new ListaPolaczona();
       listaaPolaczona.nastepna.wartosc = 52;
               
       System.out.println(listaaPolaczona.wartosc);
       System.out.println(listaaPolaczona.nastepna.wartosc);
    }
    
}
