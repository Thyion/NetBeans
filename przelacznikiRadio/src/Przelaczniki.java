
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
public class Przelaczniki extends javax.swing.JFrame {

    /**
     * Creates new form Przelaczniki
     */
    public Przelaczniki() {
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

        przelacznikiRozmiaru = new javax.swing.ButtonGroup();
        Small = new javax.swing.JRadioButton();
        Medium = new javax.swing.JRadioButton();
        Big = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();

        przelacznikiRozmiaru.add(Small);
        przelacznikiRozmiaru.add(Medium);
        przelacznikiRozmiaru.add(Big);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Small.setText("Small");
        Small.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SmallActionPerformed(evt);
            }
        });

        Medium.setText("Medium");
        Medium.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MediumActionPerformed(evt);
            }
        });

        Big.setText("Big");
        Big.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BigActionPerformed(evt);
            }
        });

        jLabel1.setText("Coś");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Small)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Medium)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Big)
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(117, 117, 117))))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {Big, Medium, Small});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Small)
                    .addComponent(Medium)
                    .addComponent(Big))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {Big, Medium, Small});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SmallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SmallActionPerformed
        jLabel1.setFont(new Font("Monospace", Font.BOLD, 14));
    }//GEN-LAST:event_SmallActionPerformed

    private void MediumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MediumActionPerformed
        jLabel1.setFont(new Font("Monospace", Font.BOLD, 24));
    }//GEN-LAST:event_MediumActionPerformed

    private void BigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BigActionPerformed
        jLabel1.setFont(new Font("Monospace", Font.BOLD, 34));
    }//GEN-LAST:event_BigActionPerformed

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
            java.util.logging.Logger.getLogger(Przelaczniki.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Przelaczniki.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Przelaczniki.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Przelaczniki.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Przelaczniki().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton Big;
    private javax.swing.JRadioButton Medium;
    private javax.swing.JRadioButton Small;
    private javax.swing.JLabel jLabel1;
    private javax.swing.ButtonGroup przelacznikiRozmiaru;
    // End of variables declaration//GEN-END:variables
}
