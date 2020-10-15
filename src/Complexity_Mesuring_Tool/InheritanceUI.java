/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Complexity_Mesuring_Tool;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ISHARA
 */
public class InheritanceUI extends javax.swing.JFrame {

    /**
     * Creates new form InheritanceUI
     */
    
    private int count_ci;
    private String indirect;
    private String direct;
    private String first;
    private String second;
    private int countstar;
    private int count_indirect;
    private int count_direct;
    private int count_total;
    private int count;
    public int w1,w2,w3,w4,w5;
    public int Tot;
   
    public InheritanceUI() {
        initComponents();
        
          try{
       
          int x1 = Integer.parseInt(InheritanceWeightUI.w1.getText());
          int x2 = Integer.parseInt(InheritanceWeightUI.w2.getText());
          int x3 = Integer.parseInt(InheritanceWeightUI.w3.getText());
          int x4 = Integer.parseInt(InheritanceWeightUI.w4.getText());
          int x5 = Integer.parseInt(InheritanceWeightUI.w5.getText());
          
       
         String text = uploadpage.l1.getText();

        if (text.isEmpty()) {

            JFrame f = new JFrame();
            JOptionPane.showMessageDialog(f, "I should import a Text File for the text area !");
        } else {

            String[] lines = text.split("\n");
            int lineCount = lines.length;
           

           for (int i = 0; i < lineCount; i++) {

                String words[] = lines[i].split("\\s");
               
                countstar = 0; 
                count = 0;
                count_ci = 0;
                count_direct = 0;
                count_indirect = 0;
                count_total = count_direct + count_indirect;
                
                
                //-------------------------Direct-------------------------------------
                for (int x = 0; x < words.length; x++) {
                    direct = "class";
                    
                   if (words[x].equals(direct)) {
                      countstar = countstar+1;  
                        first = words[++x];
                        System.out.print("class "+first+" ");
                          
                    }           
                                                                            
                   count_direct = countstar;
                                    
                }
                
                //-------------------------Indirect------------------------------------
                
                 for (int x = 0; x < words.length; x++) {
                    indirect = "extends";
                     
                    if (words[x].equals(indirect)) {
                        
                        count = count + 1;                  
                        second = words[++x];
                        System.out.println("extends "+second+" ");
                        
                    }
                    
                    count_indirect = count;
                                    
                }
                 
                 //--------------------------Total-------------------------------------
                                
                                                                            
                       count_total = count_direct + count_indirect ;
                 
                    
                   
                //---------------------------Ci----------------------------------------
                                                                                                
            /*  if(count_total <= 3){
                       
                  count_ci = count_total;
                 }
               else{
                     count_ci = 4;
                 }*/
               
                 if (count_direct == 0){
                   
                   count_ci = count_total * Integer.parseInt(InheritanceWeightUI.w1.getText());
              
                }else if (count_total == 1){
                   
                   count_ci = count_total * Integer.parseInt(InheritanceWeightUI.w2.getText());
              
               }else if (count_total == 2){
                   
                   count_ci = (count_total) * Integer.parseInt(InheritanceWeightUI.w3.getText());
               
               }else if(count_total == 3){
              
                   count_ci = (count_total) * Integer.parseInt(InheritanceWeightUI.w4.getText());
              
               }else{
                   count_ci = (count_total) * Integer.parseInt(InheritanceWeightUI.w5.getText());
               }
              
         
                           
                Object[] row = {i, lines[i],count_direct, count_indirect, count_total, count_ci};

                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

                model.addRow(row);
            }
           

        }
      }catch(Exception e){
          JOptionPane.showMessageDialog(this, "Please check the weight");
       e.printStackTrace();
           
     }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel3 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jDesktopPane1.setBackground(new java.awt.Color(153, 255, 153));

        jPanel3.setBackground(new java.awt.Color(153, 255, 153));
        jPanel3.setBorder(new javax.swing.border.MatteBorder(null));

        jButton3.setBackground(new java.awt.Color(204, 204, 0));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setText("Back");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Complexity Due to Inheritance");

        jButton6.setBackground(new java.awt.Color(255, 0, 0));
        jButton6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton6.setText("Print");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Count", "Program Statement", "No of direct (Ndi)", "No of Indirect (Nidi)", "Total  inheritance", "Ci"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1285, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(115, 115, 115)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(321, 321, 321))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(418, 418, 418)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        jDesktopPane1.setLayer(jPanel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.setVisible(false);
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
         try{
        MessageFormat header = new MessageFormat("--------------------Inheritance complexity--------------------");
        MessageFormat footer = new MessageFormat("----------------------------------------------------------------------------------");
        
        
        jTable1.print(JTable.PrintMode.FIT_WIDTH,header,footer);
         }catch(Exception e){
           JOptionPane.showMessageDialog(null,e);
       }
    }//GEN-LAST:event_jButton6ActionPerformed

        
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
            java.util.logging.Logger.getLogger(InheritanceUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InheritanceUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InheritanceUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InheritanceUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new InheritanceUI().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton6;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
