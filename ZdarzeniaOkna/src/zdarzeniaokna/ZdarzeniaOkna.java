package zdarzeniaokna;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class ZdarzeniaOkna extends JFrame implements WindowListener{

    public ZdarzeniaOkna() {
        initComponents();
    }
    
    public void initComponents() {
        this.setTitle("Zdarzenia Okna");
        this.setBounds(300, 300, 400, 300);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        //String nazwaWygladu = "javax.swing.plaf.metal.MetalLookAndFeel";
        String nazwaWygladu = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
        //String nazwaWygladu = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
        
        try
        {
        UIManager.setLookAndFeel(nazwaWygladu);
        SwingUtilities.updateComponentTreeUI(this);
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
       
        this.addWindowListener(this);
        //jeśli nie chcemy implementować wszystkim metod abstrakcyjnych
        //to możemy napisać:
        //this.addWindowListener(new WindowAdapter(){ 
        //    public void windowOpened(WindowEvent e) {
        //        JOptionPane.showMessageDialog(rootPane, "Witaj");
        //    }
        //});
        
        
        
    }

    
    public static void main(String[] args) {
        new ZdarzeniaOkna().setVisible(true);
    }

    @Override
    public void windowOpened(WindowEvent e) {
        JOptionPane.showMessageDialog(rootPane, "Witaj");
    }

    @Override
    public void windowClosing(WindowEvent e) {
        int opcja = JOptionPane.showConfirmDialog(rootPane, "Czy napewno chcesz zamknąć ten ultra fajny program??");
        if (opcja ==0){
            JOptionPane.showMessageDialog(rootPane, "Do zobaczenia!!");
            this.dispose();
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {
        System.out.println("Zapisujemy dane na dysku");
               
    }

    @Override
    public void windowIconified(WindowEvent e) {
        //minimalizacja
        System.out.println("Jestem minimalizowany");
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        //maksymalizacja
        System.out.println("Jestem maksymalizowany");
    }

    @Override
    public void windowActivated(WindowEvent e) {
        //aktywacja
        System.out.println("Jestem aktywny");
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        //deaktywacja
        System.out.println("Jestem nieaktywny");
    }
    
}
