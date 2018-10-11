/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wlasnemenu;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.math.*;

/**
 *
 * @author Krzysztof
 */
public class WlasneMenu extends JFrame{
    
    public WlasneMenu() {
        initComponents();
    }
    /**
     * @param args the command line arguments
     */
    
    
    public void initComponents() {
        this.setTitle("Własne Menu");
        this.setBounds(300, 300, 300, 300);
        panelMenu.setLayout(new GridLayout(3,1));
        this.setDefaultCloseOperation(3);
        kontener.add(panelMenu);
        
        panelMenu.add(menu1);
        panelMenu.add(menu2);
        panelMenu.add(menu3);
    }
    
    private Container kontener = this.getContentPane();
    private JPanel panelMenu = new JPanel();
    private MenuButton menu1 = new MenuButton("1. Dodaj");
    private MenuButton menu2 = new MenuButton("2. Usuń");
    private MenuButton menu3 = new MenuButton("3. Zmień");
    private int i = 0;
    public static void main(String[] args) {
        new WlasneMenu().setVisible(true);
        
// TODO code application logic here
    }
    private class MenuButton extends JButton implements FocusListener, ActionListener{
        
        public MenuButton(String name) {
            super(name);
            this.addFocusListener(this);
            this.addActionListener(this);
            this.addKeyListener(new KeyAdapter() { //ten Adapter daje możliwość że nie muszę implementować wszystkich metod
                
                @Override
                public void keyPressed(KeyEvent e) {
                    keyPressedHandler(e);
                }
                
            });
            
            this.setBackground(kDefault);
        }

        @Override
        public void focusGained(FocusEvent e) {
            this.setBackground(Color.yellow);
        }

        @Override
        public void focusLost(FocusEvent e) {
            this.setBackground(kDefault);
        }
    private Color kDefault = (Color.MAGENTA);
    
    private void keyPressedHandler(KeyEvent e){
        int dlugoscMenu = panelMenu.getComponentCount();
        
        if(i==0) i = dlugoscMenu;
        if(i==20) i = dlugoscMenu;
        if(e.getKeyCode() == KeyEvent.VK_DOWN ){
            System.out.println(++i);
            panelMenu.getComponent(i%dlugoscMenu).requestFocus();
        } 
        else if(e.getKeyCode() == KeyEvent.VK_UP ){
            System.out.println(--i);
            panelMenu.getComponent(i%dlugoscMenu).requestFocus();
        }
        else if(e.getKeyCode() == KeyEvent.VK_ENTER ){
            //MenuButton tmp = (MenuButton)e.getSource();
            //tmp.doClick();
            ((MenuButton)(e.getSource())).doClick();
        }
    }

        @Override
        public void actionPerformed(ActionEvent e) {
           
            JOptionPane.showMessageDialog(this, ((MenuButton)e.getSource()).getText());
            System.out.println("coś się stało");
        }
    
    
    }
    
    
    
    
}
