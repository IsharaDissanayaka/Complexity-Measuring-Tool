/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Complexity_Mesuring_Tool;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Asus
 */
public class uploadpage extends javax.swing.JFrame {

    public uploadpage() {
        initComponents();

    }
//cal total complexity by column values sum
    public int getsum(int no) {
        int sum = 0;
        for (int i = 0; i < no; i++) {
            sum = sum + Integer.parseInt(program_compexity_table.getValueAt(i, 1).toString());

        }
        return sum;
    }
// adding files and total complexity into the table
    public static void addrow2(Object[] datarow) {
        DefaultTableModel model1 = (DefaultTableModel) program_compexity_table.getModel();
        model1.addRow(datarow);

    }
    
    
    //////////////////////////////////////////////////////////////// METHODS OF CONTROL STRUCTURES ///////////////////////////////////////////////////////////////////////////////////////
//check the if statment and return no of arguments  
    public int ifStatement(String a, String line) {

        int Nc = 0;
        try {
            char array[] = new char[16];
            a.getChars(0, 2, array, 0);
            if ((array[0] == 'i') && (array[1] == 'f')) {
                //String st = line;
                Nc = 1;
                String[] newString = line.split("\\s+");
                for (String ss : newString) {
                    switch (ss) {
                        case "&&":
                        case "||":
                            Nc++;
                            break;
                        default:
                            Nc = Nc;
                    }
                }

            }
            return Nc;
        } catch (Exception e) {
            return Nc;
        }
    }

     //check the do statment 
    public int doStatement(String a) {

        int Nc = 0;
        try {
            char array[] = new char[16];
            a.getChars(0, 3, array, 0);
            if ((array[0] == 'd') && (array[1] == 'o') && (array[2] == '{')) {

                Nc = 1;

            }

            return Nc;
        } catch (Exception e) {
            return Nc;
        }
    }
//check the for statment and return no of arguments 
    public int forStatement(String a) {

        int Nc = 0;
        try {
            char array[] = new char[16];
            a.getChars(0, 3, array, 0);
            if ((array[0] == 'f') && (array[1] == 'o') && (array[2] == 'r')) {

                Nc = 1;

            }

            return Nc;
        } catch (Exception e) {
            return Nc;
        }
    }
//check the while statment and return no of arguments
    public int doWhileStatement(String a) {
        int Nc = 0;
        try {
            char array[] = new char[16];
            a.getChars(0, 6, array, 0);
            if ((array[0] == '}') && (array[1] == 'w') && (array[2] == 'h') && (array[3] == 'i') && (array[4] == 'l') && (array[5] == 'e')) {
                Nc = 1;
            }
            return Nc;
        } catch (Exception e) {
            return Nc;
        }
    }

//check the else statment 
    public int elseifStatement(String a) {

        int Nc = 0;
        try {
            char array[] = new char[16];
            a.getChars(0, 6, array, 0);
            if ((array[0] == 'e') && (array[1] == 'l') && (array[2] == 's') && (array[3] == 'e') && (array[4] == 'i') && (array[5] == 'f')) {

                Nc = 2;

            }
            return Nc;
        } catch (Exception e) {
            return Nc;
        }
    }
//check the if statment end 
    public int endIfStatement(String a) {

        int Ccspps = 0;
        try {
            char array[] = new char[16];
            a.getChars(0, 4, array, 0);
            if ((array[0] == 'e') && (array[1] == 'l') && (array[2] == 's') && (array[3] == 'e')) {

                Ccspps = 0;

            }
            return Ccspps;
        } catch (Exception e) {
            return Ccspps;
        }
    }
//check the switch statment and return no of arguments  
    public int switchStatement(String a) {
        int Nc = 0;
        try {

            char array[] = new char[16];
            a.getChars(0, 6, array, 0);
            if ((array[0] == 's') && (array[1] == 'w') && (array[2] == 'i') && (array[3] == 't') && (array[4] == 'c') && (array[5] == 'h')) {

                Nc = 1;

            }
            return Nc;
        } catch (Exception e) {
            return Nc;
        }

    }
//check the case statment and return no of arguments    
    public int caseStatement(String a) {

        int Nc = 0;
        try {
            char array[] = new char[16];
            a.getChars(0, 4, array, 0);
            if ((array[0] == 'c') && (array[1] == 'a') && (array[2] == 's') && (array[3] == 'e')) {

                Nc = 1;

            }
            return Nc;
        } catch (Exception e) {
            return Nc;
        }
    }
    //////////////////////////////////////////////////////////////// ENDING METHODS OF CONTROL STRUCTURES ///////////////////////////////////////////////////////////////////////////////////////

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileUploadPannel = new javax.swing.JPanel();
        browseButton = new javax.swing.JButton();
        fileName = new javax.swing.JTextField();
        chooseFileLbl = new javax.swing.JLabel();
        process = new javax.swing.JButton();
        fileUpLbl = new javax.swing.JLabel();
        add = new javax.swing.JButton();
        l1 = new java.awt.TextArea();
        jButton2 = new javax.swing.JButton();
        table = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        Contral_Structure = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        count1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        MultipleBrowse = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        program_compexity_table = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        program_complexity = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 153, 255));

        fileUploadPannel.setBackground(new java.awt.Color(204, 204, 255));

        browseButton.setBackground(new java.awt.Color(51, 204, 255));
        browseButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        browseButton.setText("Browse");
        browseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseButtonActionPerformed(evt);
            }
        });

        fileName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileNameActionPerformed(evt);
            }
        });

        chooseFileLbl.setBackground(new java.awt.Color(255, 51, 51));
        chooseFileLbl.setFont(new java.awt.Font("Sylfaen", 0, 24)); // NOI18N
        chooseFileLbl.setText("Choose your file:");

        process.setBackground(new java.awt.Color(102, 0, 102));
        process.setFont(new java.awt.Font("Sitka Small", 1, 18)); // NOI18N
        process.setText("Process");
        process.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processActionPerformed(evt);
            }
        });

        fileUpLbl.setFont(new java.awt.Font("Sitka Small", 1, 48)); // NOI18N
        fileUpLbl.setText("Upload Your Project");

        add.setBackground(new java.awt.Color(0, 204, 204));
        add.setText("complexity due to variables");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 204, 204));
        jButton2.setText("complexity due to methods");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        table.setBackground(new java.awt.Color(0, 204, 204));
        table.setText("complexity due to size");
        table.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tableActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(0, 204, 204));
        jButton1.setText("complexity due to inheritance");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(0, 204, 204));
        jButton3.setText("complexity due to coupling");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        Contral_Structure.setBackground(new java.awt.Color(0, 204, 204));
        Contral_Structure.setText("complexity due to control structures");
        Contral_Structure.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Contral_StructureActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(0, 255, 204));
        jButton5.setText("complete complexity");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        count1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                count1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("No of Lines of the program :");

        jButton6.setBackground(new java.awt.Color(255, 0, 204));
        jButton6.setText("Change Weigt");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(255, 0, 204));
        jButton7.setText("Change Weigt");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(255, 0, 204));
        jButton8.setText("Change Weigt");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setBackground(new java.awt.Color(255, 0, 204));
        jButton9.setText("Change Weigt");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setBackground(new java.awt.Color(255, 0, 204));
        jButton10.setText("Change Weigt");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setBackground(new java.awt.Color(255, 0, 204));
        jButton11.setText("Change Weigt");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        MultipleBrowse.setBackground(new java.awt.Color(102, 51, 255));
        MultipleBrowse.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        MultipleBrowse.setText("Multiple Files Upload");
        MultipleBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MultipleBrowseActionPerformed(evt);
            }
        });

        program_compexity_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "File Name", "Complexity"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(program_compexity_table);

        jLabel2.setFont(new java.awt.Font("Sylfaen", 1, 24)); // NOI18N
        jLabel2.setText("Multiple Files Complexity Table");

        jButton4.setBackground(new java.awt.Color(204, 0, 204));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setText("Calculate program complexity");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Total Program Complexity");

        javax.swing.GroupLayout fileUploadPannelLayout = new javax.swing.GroupLayout(fileUploadPannel);
        fileUploadPannel.setLayout(fileUploadPannelLayout);
        fileUploadPannelLayout.setHorizontalGroup(
            fileUploadPannelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fileUploadPannelLayout.createSequentialGroup()
                .addGroup(fileUploadPannelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(fileUploadPannelLayout.createSequentialGroup()
                        .addGap(368, 368, 368)
                        .addComponent(fileUpLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(fileUploadPannelLayout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 703, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addGroup(fileUploadPannelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(fileUploadPannelLayout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(program_complexity, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(fileUploadPannelLayout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(chooseFileLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(fileUploadPannelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(process, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fileName, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE))
                        .addGap(390, 390, 390)
                        .addComponent(table, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(fileUploadPannelLayout.createSequentialGroup()
                        .addGroup(fileUploadPannelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(fileUploadPannelLayout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jLabel1)
                                .addGap(717, 717, 717)
                                .addGroup(fileUploadPannelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(fileUploadPannelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Contral_Structure, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(fileUploadPannelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, fileUploadPannelLayout.createSequentialGroup()
                                    .addGap(66, 66, 66)
                                    .addComponent(count1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(l1, javax.swing.GroupLayout.PREFERRED_SIZE, 557, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, fileUploadPannelLayout.createSequentialGroup()
                                    .addGap(593, 593, 593)
                                    .addGroup(fileUploadPannelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(browseButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(MultipleBrowse, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)))))
                        .addGap(28, 28, 28)
                        .addGroup(fileUploadPannelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton6)
                            .addComponent(jButton8)
                            .addComponent(jButton7)
                            .addComponent(jButton10)
                            .addComponent(jButton11)
                            .addComponent(jButton9)))
                    .addGroup(fileUploadPannelLayout.createSequentialGroup()
                        .addGap(322, 322, 322)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        fileUploadPannelLayout.setVerticalGroup(
            fileUploadPannelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fileUploadPannelLayout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(fileUpLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(fileUploadPannelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chooseFileLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fileName, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(browseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(fileUploadPannelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(fileUploadPannelLayout.createSequentialGroup()
                        .addGroup(fileUploadPannelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(process, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MultipleBrowse, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fileUploadPannelLayout.createSequentialGroup()
                                .addComponent(jButton8)
                                .addGap(14, 14, 14)))
                        .addGroup(fileUploadPannelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(fileUploadPannelLayout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(fileUploadPannelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(fileUploadPannelLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(count1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(fileUploadPannelLayout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addGroup(fileUploadPannelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton7))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(fileUploadPannelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton10))
                                        .addGap(1, 1, 1))))
                            .addGroup(fileUploadPannelLayout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(l1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(fileUploadPannelLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(fileUploadPannelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton6))
                                .addGap(104, 104, 104)
                                .addGroup(fileUploadPannelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton9)))))
                    .addGroup(fileUploadPannelLayout.createSequentialGroup()
                        .addComponent(table, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(265, 265, 265)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(fileUploadPannelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Contral_Structure, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton11))
                .addGap(5, 5, 5)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(fileUploadPannelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fileUploadPannelLayout.createSequentialGroup()
                        .addGroup(fileUploadPannelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(program_complexity, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fileUploadPannelLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fileUploadPannel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fileUploadPannel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void browseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseButtonActionPerformed
      // BROWSE THE FILE 
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File file = chooser.getSelectedFile();
        String FileName = file.getName();
        String filename = file.getAbsolutePath();
        fileName.setText(filename);
    }//GEN-LAST:event_browseButtonActionPerformed

    private void fileNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileNameActionPerformed


    }//GEN-LAST:event_fileNameActionPerformed

    private void processActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processActionPerformed
        //File file = new File(fileName.getText());
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(fileName.getText()));
            String line;
            int count = 0;
            while ((line = br.readLine()) != null) {
         
             
                // PRINT THE TEXT IN TEXT AREA
                count++;
                l1.append(line + "\n");

                //    }
            }
            count1.setText(Integer.toString(count));

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {

                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_processActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
           // OPENING THE VARIABLE PAGE
        try{
       
          int a1 = Integer.parseInt(VariableWeight.va1.getText());
        new variables_table().setVisible(true);
            }catch(Exception e){
          JOptionPane.showMessageDialog(this, "Please check the weight");
       e.printStackTrace();
           
     }
    }//GEN-LAST:event_addActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
           // OPENING THE METHOD PAGE
        try{
       
          int x1 = Integer.parseInt(MethodWeight.mw1.getText());
        new Methods_table().setVisible(true);
           }catch(Exception e){
          JOptionPane.showMessageDialog(this, "Please check the weight");
       e.printStackTrace();
           
     }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tableActionPerformed
           // OPENING THE SIZE PAGE
        try{
          int x1 = Integer.parseInt(SizeWeightt.ws1.getText());
        new size_table().setVisible(true);
          }catch(Exception e){
          JOptionPane.showMessageDialog(this, "Please check the weight");
       e.printStackTrace();
           
     }
    }//GEN-LAST:event_tableActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
         // OPENING THE COUPLING PAGE
            try{
         Integer.parseInt(Coupling_weight.w1.getText());
        new Coupling_table().setVisible(true);
         }catch(Exception e){
          JOptionPane.showMessageDialog(this, "Please check the weight");
       e.printStackTrace();
           
     }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       // OPENING THE COMPLETE COMPLEXITY PAGE
        try{
       
          int xx = Integer.parseInt(ContralStructure_weight.weightIF.getText());
            int x2 = Integer.parseInt(InheritanceWeightUI.w1.getText());
            Integer.parseInt(Coupling_weight.w1.getText());
             int x3 = Integer.parseInt(SizeWeightt.ws1.getText());
              int x4 = Integer.parseInt(MethodWeight.mw1.getText());
              int a1 = Integer.parseInt(VariableWeight.va1.getText());
         new CompleteComplexity().setVisible(true);
          }catch(Exception e){
          JOptionPane.showMessageDialog(this, "Please check weight of all the factors! ");
       e.printStackTrace();
           
     }
        
      
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    // OPENING THE iNHERITANCE PAGE
        try{
       
          int x1 = Integer.parseInt(InheritanceWeightUI.w1.getText());
        new InheritanceUI().setVisible(true);
          }catch(Exception e){
          JOptionPane.showMessageDialog(this, "Please check the weight");
       e.printStackTrace();
           
     }
       
    }//GEN-LAST:event_jButton1ActionPerformed
/////////////////////////////////////////////////////////////// CODE OF THE CONTROL STRUCTURES ///////////////////////////////////////////////////////////////////////////////////
    
    
    private void Contral_StructureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Contral_StructureActionPerformed
        BufferedReader br = null;
        try {
            // READ THE FILE
            br = new BufferedReader(new FileReader(fileName.getText()));
            String line = null;
            Scanner x;
            int NCcspps = 0;
            int fCcspps = 0;
            int dCcspps = 0;
            int linesCal = Integer.parseInt(count1.getText());
            int i = 1;
            try {
             int xx = Integer.parseInt(ContralStructure_weight.weightIF.getText());
                // OPENING THE TABLE PAGE
                new ControlStructure().setVisible(true);
                // CHECK LINE BY LINE
                while (i <= linesCal) {
                    line = br.readLine();
                    x = new Scanner(line);
                    // while(x.hasNext()){
                    try {
                        String a = x.next();
                        int no = 0;
                        int wtcs = 0;
                        int Ccs = 0;
                        int Ccspps = 0;
                        //GETING TO STRING TO THE CHAR ARRAY 
                        char array[] = new char[16];
                        a.getChars(0, 1, array, 0);
                        // CHECKING CONDITHIONS BY CALLING METHODS
                        if ((array[0] == 'i') || (array[0] == 's') || (array[0] == 'c') || (array[0] == 'e') || (array[0] == 'd') || (array[0] == 'w') || (array[0] == 'f') || (array[0] == '}')) {

                            if ((array[0] == 'i') || (array[0] == 'e')) {
                                no = ifStatement(a, line);
                                if (no > 0) {
                                    //wtcs = 2;
                                    wtcs = Integer.parseInt(ContralStructure_weight.weightIF.getText());
                                    Ccspps = fCcspps;
                                    Ccs = (wtcs * no) + Ccspps;
                                    fCcspps = Ccs;
                                }

                                if ((array[0] == 'e')) {
                                    fCcspps = endIfStatement(a);
                                }
                                // ADDING A ROW TO THE TABLE IN NEXT PAGE
                                ControlStructure.addrow(new Object[]{line, wtcs, no, Ccspps, Ccs});
                            }
                           

                            if ((array[0] == 'f')) {
                                no = forStatement(a);
                                if (no > 0) {
                                    // wtcs = 2;
                                    wtcs = Integer.parseInt(ContralStructure_weight.weightFOR.getText());
                                    Ccspps = fCcspps;
                                    Ccs = (wtcs * no) + Ccspps;
                                    fCcspps = Ccs;
                                      // ADDING A ROW TO THE TABLE IN NEXT PAGE
                                    ControlStructure.addrow(new Object[]{line, wtcs, no, Ccspps, Ccs});
                                }
                            }

                            if ((array[0] == '}')) {
                                no = doWhileStatement(a);
                                if (no > 0) {
                                    // wtcs = 2;
                                    wtcs = Integer.parseInt(ContralStructure_weight.weightFOR.getText());
                                    Ccspps = 0;
                                    Ccs = (wtcs * no) + Ccspps;
                                    fCcspps = 0;
                                      // ADDING A ROW TO THE TABLE IN NEXT PAGE
                                    ControlStructure.addrow(new Object[]{line, wtcs, no, Ccspps, Ccs});
                                } else {
                                    wtcs = 0;
                                    // no = 0;
                                    Ccs = (wtcs * no) + Ccspps;
                                      // ADDING A ROW TO THE TABLE IN NEXT PAGE
                                    ControlStructure.addrow(new Object[]{line, wtcs, no, Ccspps, Ccs});
                                }
                            }

                                       
                          
                            if ((array[0] == 'c')) {
                                no = caseStatement(a);
                                if (no > 0) {
                                    //  wtcs = 1;
                                    wtcs = Integer.parseInt(ContralStructure_weight.weightCASE.getText());
                                    Ccspps = NCcspps;
                                    Ccs = (wtcs * no) + Ccspps;
                                }
                                  // ADDING A ROW TO THE TABLE IN NEXT PAGE
                                ControlStructure.addrow(new Object[]{line, wtcs, no, Ccspps, Ccs});
                            }

                                           
                            if ((array[0] == 'd')) {
                                no = doStatement(a);
                                if (no > 0) {
                                    // wtcs = 2;
                                    int xwtcs = Integer.parseInt(ContralStructure_weight.weightFOR.getText());
                                    wtcs = 0;
                                    Ccspps = 0;
                                    Ccs = 0;
                                    fCcspps = fCcspps + xwtcs;
                                }
                                  // ADDING A ROW TO THE TABLE IN NEXT PAGE
                                ControlStructure.addrow(new Object[]{line, wtcs, no, Ccspps, Ccs});
                            }

                            if ((array[0] == 's')) {
                                no = switchStatement(a);
                                if (no > 0) {
                                    // wtcs = 2;
                                    wtcs = Integer.parseInt(ContralStructure_weight.weightSWITCH.getText());
                                    Ccspps = 0;
                                    Ccs = (wtcs * no) + Ccspps;
                                    NCcspps = Ccs;

                                }
                                  // ADDING A ROW TO THE TABLE IN NEXT PAGE
                                ControlStructure.addrow(new Object[]{line, wtcs, no, Ccspps, Ccs});
                            }

                        } else {
                            wtcs = 0;
                            no = 0;
                            Ccs = (wtcs * no) + Ccspps;
                              // ADDING A ROW TO THE TABLE IN NEXT PAGE
                            ControlStructure.addrow(new Object[]{line, wtcs, no, Ccspps, Ccs});
                        }

                    } catch (Exception e) {
                        // CHECKING EMPTY LINES
                          // ADDING A ROW TO THE TABLE IN NEXT PAGE
                        ControlStructure.addrow(new Object[]{"", 0, 0, 0, 0});
                        e.printStackTrace();
                    }

                    i++;
                }

            } catch (Exception e) {

                JOptionPane.showMessageDialog(this, "Please check the weight");
                e.printStackTrace();
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {

                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_Contral_StructureActionPerformed

    private void count1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_count1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_count1ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        new MethodWeight().setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        new ContralStructure_weight().setVisible(true);

    }//GEN-LAST:event_jButton11ActionPerformed

    private void MultipleBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MultipleBrowseActionPerformed
        new MultipleFileUploader().setVisible(true);
    }//GEN-LAST:event_MultipleBrowseActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        new InheritanceWeightUI().setVisible(true);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        new Coupling_weight().setVisible(true);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
         new SizeWeightt().setVisible(true);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        int linesCal = program_compexity_table.getRowCount();
        int sum = getsum(linesCal);
        program_complexity.setText(Integer.toString(sum));
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        new VariableWeight().setVisible(true);
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
            java.util.logging.Logger.getLogger(uploadpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(uploadpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(uploadpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(uploadpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new uploadpage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Contral_Structure;
    private javax.swing.JButton MultipleBrowse;
    private javax.swing.JButton add;
    private javax.swing.JButton browseButton;
    private javax.swing.JLabel chooseFileLbl;
    public static javax.swing.JTextField count1;
    public static javax.swing.JTextField fileName;
    private javax.swing.JLabel fileUpLbl;
    private javax.swing.JPanel fileUploadPannel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    public static java.awt.TextArea l1;
    private javax.swing.JButton process;
    private static javax.swing.JTable program_compexity_table;
    private javax.swing.JTextField program_complexity;
    private javax.swing.JButton table;
    // End of variables declaration//GEN-END:variables
}
