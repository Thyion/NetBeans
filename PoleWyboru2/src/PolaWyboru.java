
import java.awt.Font;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Krzysztof
 */
public class PolaWyboru extends javax.swing.JFrame {

    /**
     * Creates new form PolaWyboru
     */
    public PolaWyboru() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pogrubionyCheckBox = new javax.swing.JCheckBox();
        pochylonyCheckBox = new javax.swing.JCheckBox();
        etykieta = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pogrubionyCheckBox.setText("pogrubiony");
        pogrubionyCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pogrubionyCheckBoxActionPerformed(evt);
            }
        });

        pochylonyCheckBox.setText("pochylony");
        pochylonyCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pochylonyCheckBoxActionPerformed(evt);
            }
        });

        etykieta.setText("trololo");
        etykieta.setFont(new Font("Monospaced",Font.PLAIN, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(pogrubionyCheckBox)
                        .addGap(18, 18, 18)
                        .addComponent(pochylonyCheckBox))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(etykieta)))
                .addContainerGap(162, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pogrubionyCheckBox)
                    .addComponent(pochylonyCheckBox))
                .addGap(18, 18, 18)
                .addComponent(etykieta)
                .addContainerGap(194, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pogrubionyCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pogrubionyCheckBoxActionPerformed
        zmienStyle();
    }//GEN-LAST:event_pogrubionyCheckBoxActionPerformed

    private void pochylonyCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pochylonyCheckBoxActionPerformed
        zmienStyle();
    }//GEN-LAST:event_pochylonyCheckBoxActionPerformed
    private void zmienStyle() {
        int style = Font.PLAIN;
        
        if (pochylonyCheckBox.isSelected()) style += Font.ITALIC;
        if (pogrubionyCheckBox.isSelected()) style += Font.BOLD;
    
        etykieta.setFont(new Font(etykieta.getFont().getFamily(), style, etykieta.getFont().getSize()));
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PolaWyboru.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PolaWyboru.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PolaWyboru.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PolaWyboru.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PolaWyboru().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel etykieta;
    private javax.swing.JCheckBox pochylonyCheckBox;
    private javax.swing.JCheckBox pogrubionyCheckBox;
    // End of variables declaration//GEN-END:variables
}
