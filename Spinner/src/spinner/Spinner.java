package spinner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.Date;

public class Spinner extends JFrame{

    public Spinner() {
        initComponents();
    }
    
    public void initComponents() {
        this.setTitle("Spinners");
        this.setBounds(300, 300, 300, 300);
        
        
        String[] miesiace = new DateFormatSymbols().getMonths();
        
        //for (int i =0; i < miesiace.length; i++)
        //    System.out.println(miesiace[i]);
        Calendar kalendarz = Calendar.getInstance();
        
        Date poczatkowaData = kalendarz.getTime();
        kalendarz.add(Calendar.DAY_OF_MONTH, -20);
        Date minimalnaData = kalendarz.getTime();
        kalendarz.add(Calendar.DAY_OF_MONTH, +40);
        Date maxData = kalendarz.getTime();
        
        SpinnerListModel modelMiesiecy = new MySpinnerListModel(obetnijArray(miesiace, 0, miesiace.length-2));
        SpinnerNumberModel modelLiczb = new SpinnerNumberModel(1, 1, 30, 1);
        SpinnerDateModel modelDat = new SpinnerDateModel(poczatkowaData, minimalnaData, maxData, Calendar.DAY_OF_MONTH );
        
        JPanel panel = new JPanel();
        
        JSpinner spinner = new JSpinner(modelMiesiecy);
        JSpinner spinner2 = new JSpinner(modelLiczb);
        JSpinner spinner3 = new JSpinner(modelDat);
           
        
        
        panel.add(spinner);
        panel.add(spinner2);
        panel.add(spinner3);
        this.getContentPane().add(panel, BorderLayout.NORTH);
        
        this.setDefaultCloseOperation(3);
    }
    
    private class MySpinnerListModel extends SpinnerListModel {
        public MySpinnerListModel(Object[] values){
            super(values);
            firstValue = values[0];
            lastValue = values[values.length-1];
            
        }
        
        @Override
        public Object getNextValue() {
            if(super.getNextValue() == null)
                return firstValue;
            else 
            return super.getNextValue();
        }
        
        @Override
        public Object getPreviousValue() {
            if(super.getPreviousValue() == null)
                return lastValue;
            else
                return super.getPreviousValue();
        }
        
        Object firstValue, lastValue;
    }
    
    /**
     * obcina tablice od <code>poczatek</code> do <code>koniec</code>
     * @param operowany tablica, któa będzie obcięta
     * @param poczatek index od któego będzie obcinane
     * @param koniec index do któego będzie obcinane
     * @return zwraca obciętą tablicę
     */
    
    private Object[] obetnijArray(Object[] operowany, int poczatek, int koniec){
        
        // koniec ?:; instrukcja warunkowa > najpierw czy coś się dzieje. jeśli tak to zrób to co po pytajniku. jak nie to to co po dwukropku
        koniec = koniec > operowany.length - 1 || koniec < 0 ? operowany.length-1 : koniec;
        poczatek = poczatek < 0 || poczatek > koniec ? 0 : poczatek;
        
        Object[] tmp = new Object[koniec+1];
        
        for(int i = poczatek, j = 0; i < koniec+1; i++,j++)
            tmp[j] = operowany[i];
        
        return tmp;
    }
    
    public static void main(String[] args) {
        new Spinner().setVisible(true);
    }
    
}
