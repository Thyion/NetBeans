
package listy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class Listy extends JFrame{
    
    public Listy()
    {
        initComponents();
    }
    
    public void initComponents() {
        this.setTitle("Listy");
        this.setBounds(300, 300, 300, 300);
        
        //this.getContentPane().add(listaPrzedmiotow);
        
        panelListy.add(scrollListy);
        listaPrzedmiotow.setVisibleRowCount(3);
        listaPrzedmiotow.setPrototypeCellValue("dddddddddddd"); //ustawia szerokość na ile znaków ma być miejsca
        listaPrzedmiotow.setFixedCellWidth(50);
        listaPrzedmiotow.setFixedCellHeight(20);
        listaPrzedmiotow.setBackground(Color.YELLOW);
        listaPrzedmiotow.setSelectionBackground(Color.lightGray);
        listaPrzedmiotow.setSelectionForeground(Color.GREEN);//zmienia kolor tekstu po zaznaczeniu
        listaPrzedmiotow.setLayoutOrientation(JList.VERTICAL_WRAP);//ustawia innaczej elementy listy
        //listaPrzedmiotow.setLayoutOrientation(JList.HORIZONTAL_WRAP);// ustawia ineczej elementy listy
        listaPrzedmiotow.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION); // ustawia ile możemy i jak zaznaczyć (sa 3 opcje)
        panelKomunikatu.add(komunikat);
        
        listaPrzedmiotow.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                System.out.println("Zmieniłem się " + (i++));
                
                if(e.getValueIsAdjusting()) 
                    System.out.println("Trzymam button myszy");
                else 
                    System.out.println("Puściłem button myszy");
                
                if (!e.getValueIsAdjusting())
                {
                    //String zawartosc = (String) (((JList)e.getSource()).getSelectedValue());
                    //System.out.println(zawartosc);
                    // to powyżej jest pobieranie 1 wartości
                    
                    Object[] wartosciWLiscie = (((JList)e.getSource()).getSelectedValues());
                
                    String przedmioty = "";
                    
                    for (int i =0; i < wartosciWLiscie.length; i++)
                        przedmioty += (String)wartosciWLiscie[i] + " ";
                    
                    komunikat.setText("Nie lubię tych przedmiotów : " + przedmioty);
                    System.out.println(przedmioty);
                    
                }
            }
        });
        
        //uczymy się jak dodawać do listy
        DefaultListModel modelListy = new DefaultListModel();
        String[] tekst = new String[] {"Matematyka", "Polski", "Fizyka", "Chemia", "Historia"};
        
        for (int i = 0; i <tekst.length; i++)
            modelListy.addElement(tekst[i]);
        
        modelListy.addElement("trolo");
        modelListy.addElement("k");
        modelListy.addElement("g");
        JList lista2 = new JList(modelListy);
        
        modelListy.addElement("tafsaf");
        
        lista2.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                for (int i = 0; i <tekst.length; i++)
                    modelListy.addElement(tekst[i]);
                //modelListy.remove(1); - usuwanie 
            }
        });
        
        
        this.getContentPane().add(panelListy, BorderLayout.NORTH);
        this.getContentPane().add(panelKomunikatu, BorderLayout.CENTER);
        this.getContentPane().add(lista2, BorderLayout.SOUTH);
        
        this.setDefaultCloseOperation(3);
        //System.out.println(listaPrzedmiotow);
    }
    
    private JList listaPrzedmiotow = new JList(new String[]{"Matematyka", "Polski", "Fizyka", "Chemia", "Historia"});
    private JPanel panelListy = new JPanel();
    private JScrollPane scrollListy = new JScrollPane(listaPrzedmiotow);
    private JPanel panelKomunikatu = new JPanel();
    private JLabel komunikat = new JLabel("hhh");
    private int i = 0;
    
    public static void main(String[] args) {
        new Listy().setVisible(true);
    }
    
}
