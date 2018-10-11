
package aplikacjezwielomaramkami;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NewClass  extends JFrame {

    public NewClass(JFrame parent){
        initComponents();
        int szer = (int)parent.getBounds().getWidth();
        int wys = (int)parent.getBounds().getHeight();
        int szerRamki = this.getSize().width;
        int wysRamki = this.getSize().height;
        
        this.setLocation(parent.getBounds().x+(szer-szerRamki)/2,parent.getBounds().y+(wys-wysRamki)/2);
    }
    
    public void initComponents () {
        this.setTitle("To jest ramka numer"+(++i));
        this.setBounds(300, 300, 300, 75);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.getContentPane().add(panel);
        
    }   
    JPanel panel = new JPanel();
    
    public static void main(String[] args) {
        new AplikacjeZWielomaRamkami().setVisible(true);
    }
    
    static int i=0;
    
}
