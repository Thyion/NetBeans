
package sliders;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static javax.swing.SwingConstants.HORIZONTAL;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
/**
 *
 * @author Krzysztof
 */
public class Sliders extends JFrame{

    public Sliders() {
        initComponents();
        
    }
   
    public void initComponents() {
        this.setTitle("Sliders");
        this.setBounds(300, 300, 300, 300);
        this.setDefaultCloseOperation(3);
        this.getContentPane().add(suwak, BorderLayout.NORTH);
        this.getContentPane().add(wartoscSuwaka,BorderLayout.SOUTH);
        this.getContentPane().add(cos, BorderLayout.CENTER);
        wartoscSuwaka.setEditable(false);
        suwak.setMajorTickSpacing(25);
        suwak.setPaintTicks(true);
        suwak.setPaintLabels(true);
        suwak.setMinorTickSpacing(5);
        suwak.setSnapToTicks(true); //przeskakuje odrazu do wartości
        
        suwak.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                wartoscSuwaka.setText(""+((JSlider)e.getSource()).getValue());
                cos.setFont(new Font(cos.getFont().getFontName(), cos.getFont().getStyle(), (int)((JSlider)e.getSource()).getValue()));
            }
        });
    }
    
    JSlider suwak = new JSlider(JSlider.HORIZONTAL, 0, 100, 5);;
    JTextField wartoscSuwaka = new JTextField(""+suwak.getValue());
    JLabel cos = new JLabel("Coś");
    
    
    public static void main(String[] args) {
        new Sliders().setVisible(true);
    }
    
}
