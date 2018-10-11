
package aplikacjezwielomaramkami;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AplikacjeZWielomaRamkami  extends JFrame {

    public AplikacjeZWielomaRamkami(){
        initComponents();
    
    }
    
    public void initComponents () {
        this.setTitle("Aplikacja z wieloma ramkami");
        this.setBounds(300, 300, 400, 300);
        this.setDefaultCloseOperation(3);
        this.getContentPane().add(panel);
        panel.add(Ramka1);
        Ramka1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new dialog(taRamka).setVisible(true);
            }
        });
    }
    private JFrame taRamka = this;
    JButton Ramka1 = new JButton("Nowa Ramka");
    JPanel panel = new JPanel();
    
    public static void main(String[] args) {
        new AplikacjeZWielomaRamkami().setVisible(true);
    }
    
}
