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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class size_table extends javax.swing.JFrame {

    /**
     * Creates new form userInterface
     */
    
    public int ws1, ws2, ws3, ws4, ws5;
    String[] printwQ  = new String[] {};

ArrayList<String> printQ = new ArrayList<String>();
    public size_table() {
        initComponents();
        
                try{
       
          int x1 = Integer.parseInt(SizeWeightt.ws1.getText());
          int x2 = Integer.parseInt(SizeWeightt.ws2.getText());
          int x3 = Integer.parseInt(SizeWeightt.ws3.getText());
          int x4 = Integer.parseInt(SizeWeightt.ws4.getText());
          int x5 = Integer.parseInt(SizeWeightt.ws5.getText());
          
        
        String text = uploadpage.l1.getText();

         int TCs =0;
        
        if (text.isEmpty()) {

            JFrame f = new JFrame();
            JOptionPane.showMessageDialog(f, "You should import a Text File for the text area !");
        } else {
            
            String[] keywords = new String[] { "long","fibonacci","number", "void", "double", "int", "float", "String", "cout","cin","get",

                    "if", "for", "while","do-while","switch","case", "main","System","out","println","args","operator","bark","count","accessFiles","FileNotFoundException","FileReader","f","catch","e","std","this","Dog","Animal"};

            int keywordSize = keywords.length;
            
            String[] stringLi = new String[] { "long","fibonacci","number", "double","String", "cout","cin","get",

                    "System","out","println","args","operator","bark","count","accessFiles","FileNotFoundException","FileReader","f","catch","e","std","this","Dog","Animal"};

            int stringLSize = stringLi.length;
            
            String[] numbers = new String[] { "long","fibonacci","number","get",

                    "if", "for", "while","do-while","switch","case","operator","accessFiles","FileNotFoundException","FileReader","f","catch"};

            int numberSize = numbers.length;
      
            String[] ariOperators = new String[] { "+", "-", "*", "%", "++", "--" };
            int arithOSize = ariOperators.length;
            
            String[] relOperators = new String[] { "==", "!=", ">", "<", ">=", "<=" };
            int relatOSize = relOperators.length;
             

             String[] logicOperators = new String[] { "&&", "||", "!" };
             int logicOSize = logicOperators.length;
             
             String[] bitwiseOperators = new String[] { "|" ,"^", "~", "<<", ">>", "<<<", ">>>" };
             int bitwOSize = bitwiseOperators.length;
             
             String[] miscellaneous  = new String[] {  "->",".","::","~"};
             int miscOSize = miscellaneous.length;
             
             String[] assignOperators = new String[] { "=","+=", "-=", "*=", "/=", ">>>=", "|=", "&=", "<<=", ">>=", "%=",
              "^=" };
             int assOSize = assignOperators.length;
           

            String[] lines = text.split("\n");
            int lineCount = lines.length;
           

            for (int i = 0; i < lineCount; i++) {

                String words[] = lines[i].split(" ");
                int keywordsCounts = 0;
                int arithOSizes = 0;
                int StringL = 0;
                int identifier = 0;
                int totCost = 0;
                int numericalVal = 0;
               
                
                
                 for (int k = 0; k < keywordSize; k++) {

                              int a = 0;

                              for (a = 0; a < words.length; a++) {

                                              if (words[a].equals(keywords[k]) ) {

                                                              TCs++;

                                                              keywordsCounts++;
                                                              totCost = keywordsCounts * Integer.parseInt(SizeWeightt.ws1.getText());

                                                              printQ.add(words[a]);

                                              }

             

                              }

                }
                for (int m = 0; m < arithOSize; m++) {
                	int b = 0;
                	   for (b = 0; b < words.length; b++) {
                		if (words[b].equals(ariOperators[m]) ) {
                			TCs++;
                			arithOSizes++;
                                        totCost = arithOSizes * Integer.parseInt(SizeWeightt.ws3.getText());
                			printQ.add(words[b]);
                		}
              
                	}
                }

               for (int m = 0; m < relatOSize; m++) {
                	int b = 0;
                	for (b = 0; b < words.length; b++) {
                		if (words[b].equals(relOperators[m]) ) {
                			TCs++;
                			arithOSizes++;
                                        totCost = arithOSizes * Integer.parseInt(SizeWeightt.ws3.getText());
                			printQ.add(words[b]);
                		}
              
                	}
                }
               
               /********Loop for logic operators**********/   
               
               for (int m = 0; m < logicOSize; m++) {
                	int b = 0;
                	    for (b = 0; b < words.length; b++) {
                		if (words[b].equals(logicOperators[m]) ) {
                			TCs++;
                			arithOSizes++;
                                        totCost = arithOSizes * Integer.parseInt(SizeWeightt.ws3.getText());
                			printQ.add(words[b]);
                		}
              
                	}
                }
               for (int m = 0; m < assOSize; m++) {
                	int b = 0;
                	for (b = 0; b < words.length; b++) {
                		if (words[b].equals(assignOperators[m]) ) {
                			TCs++;
                			arithOSizes++;
                                        totCost = arithOSizes * Integer.parseInt(SizeWeightt.ws3.getText());
                			printQ.add(words[b]);
                		}
              
                	}
                }
               
               for (int m = 0; m < bitwOSize; m++) {
                	int b = 0;
                	for (b = 0; b < words.length; b++) {
                		if (words[b].equals(bitwiseOperators[m]) ) {
                			TCs++;
                			arithOSizes++;
                                        totCost = arithOSizes * Integer.parseInt(SizeWeightt.ws3.getText());
                			printQ.add(words[b]);
                		}
              
                	}
                }
               
               for (int m = 0; m < miscOSize; m++) {
                	int b = 0;
                	    for (b = 0; b < words.length; b++) {
                		if (words[b].equals(miscellaneous[m]) ) {
                			TCs++;
                			arithOSizes++;
                                        totCost = arithOSizes * Integer.parseInt(SizeWeightt.ws3.getText());
                			printQ.add(words[b]);
                		}
              
                	}
                }
               for (int m = 0; m < assOSize; m++) {
                	int b = 0;
                	for (b = 0; b < words.length; b++) {
                		if (words[b].equals(assignOperators[m]) ) {
                			TCs++;
                			arithOSizes++;
                                        totCost = arithOSizes * Integer.parseInt(SizeWeightt.ws3.getText());
                			printQ.add(words[b]);
                		}
              
                	}
                }
               
               for (int s = 0; s < stringLSize; s++) {

                              int a = 0;

                              for (a = 0; a < words.length; a++) {

                                              if (words[a].equals(stringLi[s]) ) {

                                                              TCs++;

                                                              StringL++;
                                                              totCost = StringL * Integer.parseInt(SizeWeightt.ws5.getText());

                                                              printQ.add(words[a]);

                                              }

                              }

                }
               
               for (int n = 0; n < numberSize; n++) {

                              int a = 0;

                              for (a = 0; a < words.length; a++) {

                                              if (words[a].equals(numbers[n]) ) {

                                                              TCs++;

                                                              numericalVal++;
                                                              totCost = numericalVal * Integer.parseInt(SizeWeightt.ws4.getText());

                                                              printQ.add(words[a]);

                                              }

                              }

                }
               
               for (int k = 0; k < keywordSize; k++) {

                              int a = 0;

                              for (a = 0; a < words.length; a++) {

                                              if (words[a].equals(keywords[k]) ) {

                                                              TCs++;

                                                              identifier++;
                                                              totCost = identifier * Integer.parseInt(SizeWeightt.ws2.getText());

                                                              printQ.add(words[a]);

                                              }

             

                              }

                }
               
               
               
               
               
                Object[] row = {i, lines[i],keywordsCounts, identifier, arithOSizes, numericalVal, StringL, totCost};

                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

                model.addRow(row);                                 
                       
  
            }

        }
        
        }catch(Exception e){
          JOptionPane.showMessageDialog(this, "Please check the weight");
       e.printStackTrace();
           
     }
        
    }
    


// create object of table and table model

DefaultTableModel model;
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 255, 153));
        jPanel1.setBorder(new javax.swing.border.MatteBorder(null));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Line No", "Program Statement", "Nkw", "Nid", "Nop", "Nnv", "Nsl", "Cs"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jButton4.setBackground(new java.awt.Color(255, 0, 0));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton4.setText("Print");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(204, 204, 0));
        jButton6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton6.setText("Back");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setText("Complexity Due to Size");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(391, 391, 391)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(285, 285, 285)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(143, 143, 143)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(96, 96, 96))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        
        try{
            MessageFormat header = new MessageFormat("Code complexity due to Size - Report");
            MessageFormat footer = new MessageFormat("=======================================");
            
            jTable1.print(JTable.PrintMode.FIT_WIDTH,header,footer);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        this.setVisible(false);
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
            java.util.logging.Logger.getLogger(size_table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(size_table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(size_table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(size_table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new size_table().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

   
    
}
