/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Complexity_Mesuring_Tool;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import Complexity_Mesuring_Tool.Cuupling_Method;
import static Complexity_Mesuring_Tool.uploadpage.fileName;

/**
 *
 * @author User
 */
public class Coupling_table extends javax.swing.JFrame {

	public static List <Integer>  defaultWeight= Arrays.asList(2,2,3,3,4,4,5,3,4,1,2,1,2);
	
	/**
	 * Creates new form Coupling_table
	 */
	public Coupling_table() {
		initComponents();
		String regexString = uploadpage.fileName.getText();

		List<String> list = new ArrayList();
		// Set<String> listOfOtherMethodCallsThisFile = new HashSet();

		Map<String, String> normalToNormal = new LinkedHashMap();
		Map<String, String> normalToRecursive = new LinkedHashMap();
		Map<String, String> RecursiveToNormal = new LinkedHashMap();
		Map<String, String> RecursiveToRecursive = new LinkedHashMap();

		Map<String, String> globalVar = new LinkedHashMap();

		DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
		model.setRowCount(0);

		jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		jTable1.getColumnModel().getColumn(0).setPreferredWidth(55);
		jTable1.getColumnModel().getColumn(1).setPreferredWidth(320);
		jTable1.getColumnModel().getColumn(2).setPreferredWidth(70);
		jTable1.getColumnModel().getColumn(3).setPreferredWidth(70);
		jTable1.getColumnModel().getColumn(4).setPreferredWidth(70);
		jTable1.getColumnModel().getColumn(5).setPreferredWidth(70);
		jTable1.getColumnModel().getColumn(6).setPreferredWidth(70);
		jTable1.getColumnModel().getColumn(7).setPreferredWidth(70);
		jTable1.getColumnModel().getColumn(8).setPreferredWidth(70);
		jTable1.getColumnModel().getColumn(9).setPreferredWidth(70);
		jTable1.getColumnModel().getColumn(10).setPreferredWidth(70);
		jTable1.getColumnModel().getColumn(11).setPreferredWidth(70);
		jTable1.getColumnModel().getColumn(12).setPreferredWidth(70);
		jTable1.getColumnModel().getColumn(13).setPreferredWidth(70);
		jTable1.getColumnModel().getColumn(14).setPreferredWidth(70);
		jTable1.getColumnModel().getColumn(15).setPreferredWidth(80);

		try (BufferedReader br = new BufferedReader(new FileReader(uploadpage.fileName.getText()))) {

			String line;
			int no = 1;

			while ((line = br.readLine()) != null) {
				// process the line.
				// Add to list for no and codeline
				list.add(no + "#" + line);

				no++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// String regexString = "";

		for (int x = 0; x < list.size(); x++)
			regexString += list.get(x) + "\n";

		// finding the main class name of the file

		// Finding methods
		// Map designed with method name and method body
		Map<String, Cuupling_Method> thisFileMethods = new HashMap();

		// replace if } with +if to resolve complexity
		Pattern p = Pattern.compile("if( )*\\((.)*\\)( )*\\{(.|\\n)*?(\\d+#.*})");
		Matcher mif = p.matcher(regexString);
		while (mif.find()) {
			// replace first number with "number" and second number with the first
			String identifier = mif.group(5);
			String ifIdentify = identifier.replace("}", "-if");
			regexString = regexString.replace(identifier, ifIdentify);
		}
		// replace if end

		// replace for } with +for to resolve complexity
		Pattern p1 = Pattern.compile("for( )*\\((.)*\\)( )*\\{(.|\\n)*?(\\d+#.*})");
		Matcher mif1 = p1.matcher(regexString);
		while (mif1.find()) {
			// replace first number with "number" and second number with the first
			String identifier = mif1.group(5);
			String ifIdentify = identifier.replace("}", "-for");
			regexString = regexString.replace(identifier, ifIdentify);
		}
		// replace for end

		Matcher m = Pattern.compile("((.+\\(.*\\))( )*\\{(\\n|\\r|\\n|.)*?\\})").matcher(regexString);
		while (m.find()) {

			// name with access and return
			String methodName = m.group(2);

			String methodWithAccessAndReturn = (methodName.replaceAll("\\(.*\\)", ""));

			String onlyMethodName = methodWithAccessAndReturn.substring(methodWithAccessAndReturn.lastIndexOf(" "));

			// System.out.println(onlyMethodName);
			System.out.println("\n__________________________________________");

			Cuupling_Method method = new Cuupling_Method();
			String methodBody = m.group().substring(m.group().indexOf("{"));
			method.setMethodBody(methodBody);

			// get no of the recursive call to own mwthod
			Pattern pattern = Pattern.compile("(\\d*)#.*" + onlyMethodName);
			Matcher matcher = pattern.matcher(methodBody);
			// set recursive call no and put to method object
			if (matcher.find()) {

				// check if method recursive
				method.setRecursiveCall(true);
				// System.out.println(matcher.group() + " own method call found");
				// System.out.println(matcher.group(1));
				method.setRecursiveCallNo(matcher.group(1));
			}
			System.out.println(thisFileMethods + "\n_________________________________________");

			thisFileMethods.put(onlyMethodName, method);
		}
		// all methods are added

		// check global vaiables

		// remove methods from class
		String[] removeMetho = { regexString };

		thisFileMethods.entrySet().forEach(e -> {
			removeMetho[0] = removeMetho[0].replace(e.getValue().getMethodBody(), "");
		});

		Matcher globalVariables = Pattern.compile("(\\d)+#.+ (.+)=.+;").matcher(removeMetho[0]);
		while (globalVariables.find()) {

			// System.out.println(globalVariables.group(1) + " Globle variable found");
			globalVar.put(globalVariables.group(1), globalVariables.group(2));
		}

		// System.out.println(removeMetho[0]);

		// find other methods called in this method

		thisFileMethods.entrySet().stream().forEach((entry) -> {
			System.out.println("\n\n");
			// System.out.println(entry.getKey() + " a mwthod in this file");
			// System.out.println(entry.getValue().isRecursiveCall() + " is rec");

			String bodyWithOutMethod = entry.getValue().getMethodBody().replaceAll(entry.getKey(), "");
			thisFileMethods.entrySet().stream().filter(e -> !e.getKey().equals(entry.getKey())).forEach(methodName -> {
				// get other method calls from this method
				// System.out.println(methodName.getKey());
				// System.out.println(bodyWithOutMethod);

				Pattern pattern = Pattern.compile("(\\d*)#.*" + methodName.getKey().trim());
				Matcher matcher = pattern.matcher(bodyWithOutMethod);

				// set recursive call no and put to method object
				if (matcher.find()) {
					System.out.println(entry.getKey() + " method  inner call " + methodName.getKey());
					System.out.println(matcher.group(1) + " number ");

					if (entry.getValue().isRecursiveCall()) {
						// inside recursive method
						if (methodName.getValue().isRecursiveCall()) {
							// calling method recursive
							RecursiveToRecursive.put(methodName.getKey(), matcher.group(1));
						} else {
							// calling method not recursive
							RecursiveToNormal.put(methodName.getKey(), matcher.group(1));
						}

					} else {
						// inside normal method
						if (methodName.getValue().isRecursiveCall()) {
							// calling method recursive
							normalToRecursive.put(methodName.getKey(), matcher.group(1));
						} else {
							// calling method normal
							normalToNormal.put(methodName.getKey(), matcher.group(1));

						}

					}

				}
				System.out.println();
				System.out.println();
				System.out.println();

			});

		});

		System.out.println(normalToNormal + "  normalToNormal");
		System.out.println(normalToRecursive + " normalToRecursive");
		System.out.println(RecursiveToNormal + " RecursiveToNormal");
		System.out.println(RecursiveToRecursive + " RecursiveToRecursive");

		for (int i1 = 0; i1 < list.size(); i1++) {

			String originalCodeLine = list.get(i1).toString();
			String codeLine[] = { list.get(i1).toString() };
			String number = codeLine[0].substring(0, codeLine[0].indexOf("#"));

			boolean[] isRecursiveMethod = { false };

			int[] normalToNormalVal = { 0 };
			int[] normalToRecursiveVal = { 0 };
			int[] RecursiveToNormalVal = { 0 };
			int[] RecursiveToRecursiveVal = { 0 };

			int[] normalToOtherNormalM = { 0 };
			int[] normalToOtherRecursiveM = { 0 };
			int[] RecursiveToOtherNormalM = { 0 };
			int[] RecursiveToOtherRecursiveM = { 0 };

			// check map for any lines match this line
			// check map for any lines match this line
			int noOfRCall = 0;

			thisFileMethods.entrySet().forEach(e -> {
				if (e.getValue().getRecursiveCallNo().equals(number)) {
					isRecursiveMethod[0] = true;
					System.out.println(e.getValue().getRecursiveCallNo() + "this line own recursive call happens");
				}
			});

			normalToNormal.entrySet().forEach(normal -> {

				if (normal.getValue().equals(number))
					normalToNormalVal[0]++;
			});

			normalToRecursive.entrySet().forEach(normal -> {

				if (normal.getValue().equals(number))
					normalToRecursiveVal[0]++;
			});

			RecursiveToNormal.entrySet().forEach(normal -> {

				if (normal.getValue().equals(number))
					RecursiveToNormalVal[0]++;
			});

			RecursiveToRecursive.entrySet().forEach(normal -> {

				if (normal.getValue().equals(number))
					RecursiveToRecursiveVal[0]++;
			});

			int globelVarUse[] = { 0 };

			int globalUsedByR = 0;
			int globalUsedByNonR = 0;

			int globalFromOtherR = 0;
			int globalFromOtherNonR = 0;

			// check about globle var calling from other files

			int globleFromOther[] = { 0 };

			String[] replacement = { "" };

//    				allGlobalVar.entrySet().stream().forEach(e -> {
//    					if (codeLine[0].contains(e.getKey().split(",")[1].trim() + "." + e.getValue())) {
//
//    				codeLine[0] = (codeLine[0].replaceAll(e.getKey().split(",")[1].trim() + "." + e.getValue(), ""));
//
//    				globleFromOther[0]++;
//    					}
//
//    				});

			globalVar.entrySet().forEach(e -> {
				// declare karapu thana magaharinna
				if (!e.getKey().trim().equals(number)) {

					// if (codeLine.matches("(.*)[ \\(=]*" + e.getValue().trim() + "[ \\)=;](.*)"))
					{

						// System.out.println(codeLine + " line founded val " + e.getValue().trim());

						int noOfVarInLine = 0;
						Matcher matcher = Pattern.compile("(.*)[ \\(=+]*(" + e.getValue().trim() + ")[ \\)=;+](.*)")
								.matcher(codeLine[0]);
						while (matcher.find()) {
							// System.out.println(matcher.group(2) + " varrrrrrrrrrr " + e.getValue());
							noOfVarInLine++;
						}

						globelVarUse[0] += noOfVarInLine;

					}

				}

			});

			boolean[] isGloblalCalledFromRecursive = { false };
			boolean[] isMethodRecursive = { false };

			// System.out.println(globalVar);
			thisFileMethods.values().stream().filter(e -> e.isRecursiveCall()).collect(Collectors.toList())
					.forEach(e -> {

						if (e.getMethodBody().contains(codeLine[0])) {
							isMethodRecursive[0] = true;
							if (globelVarUse[0] > 0)
								isGloblalCalledFromRecursive[0] = true;
							// System.out.println(codeLine + " globle in recursive");
						}
					});

			// check is this method recursive and called one
			if (isGloblalCalledFromRecursive[0]) {
				// System.out.println("this global from recursive
				// sssssssssssssssssssssssssssss");
				globalFromOtherR = globleFromOther[0];

				globalUsedByR = globelVarUse[0];

			} else {
				globalUsedByNonR = globelVarUse[0];
				globalFromOtherNonR = globleFromOther[0];
			}

			if (!number.equals("")) {

System.out.println(number+" Codeline  "+((isRecursiveMethod[0]) ? 2 : 0) +"1 "+ normalToNormalVal[0] * 2 
		+" 2"+ normalToRecursiveVal[0] * 3 
		+" 3"+ RecursiveToRecursiveVal[0] * 4 
		+" 4"+ RecursiveToNormalVal[0] * 3 +" 5"+ globalUsedByNonR * 1
		+" 6 "+ globalUsedByR * 1 );    		        	

				model.addRow(new Object[] { number, originalCodeLine.substring(originalCodeLine.indexOf("#")),
						(isRecursiveMethod[0]) ? "1" : "0"
							, normalToNormalVal[0], "0", normalToRecursiveVal[0], "0",
						RecursiveToRecursiveVal[0], "0", RecursiveToNormalVal[0], "0", globalUsedByNonR, "0",
						globalUsedByR, "0",
						
						((isRecursiveMethod[0]) ? Integer.parseInt(Coupling_weight.w1.getText()) : 0) + normalToNormalVal[0] * Integer.parseInt(Coupling_weight.w2.getText())
						+ normalToRecursiveVal[0] * Integer.parseInt(Coupling_weight.w3.getText()) 
						+ RecursiveToRecursiveVal[0] * Integer.parseInt(Coupling_weight.w5.getText())
						+ RecursiveToNormalVal[0] *  Integer.parseInt(Coupling_weight.w6.getText())  + globalUsedByNonR *  Integer.parseInt(Coupling_weight.w7.getText())
						+ globalUsedByR *  Integer.parseInt(Coupling_weight.w8.getText()) 

				});
			}
		}

	}
        


        
        
	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 255, 153));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Line No", "Program Statement", "Nr", "Nmcms", " Nmcmd ", "Nmcrms", "Nmcrmd ", "Nrmcrms", "Nrmcrm", "Nrmcms", "Nrmcmd", "Nmrgvs", "Nmrgvd", "Nrmrgvs", "Nrmrgvd", "Ccp"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jButton1.setBackground(new java.awt.Color(204, 204, 0));
        jButton1.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel3.setText("Mesuring Complexity Due TO Coupling");

        jButton2.setBackground(new java.awt.Color(255, 51, 51));
        jButton2.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        jButton2.setText("Print");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 148, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1629, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(427, 427, 427)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(72, 72, 72)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(606, 606, 606)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(109, 109, 109))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         try{
            MessageFormat header = new MessageFormat("Measuring Complexity Due to Coupling ");
            MessageFormat footer = new MessageFormat("======================================");
            
            jTable1.print(JTable.PrintMode.FIT_WIDTH,header,footer);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

	private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jTable1MouseClicked

	}// GEN-LAST:event_jTable1MouseClicked

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
		
		this.setVisible(false);
	}// GEN-LAST:event_jButton1ActionPerformed

	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton3ActionPerformed
		//new Coupling_weight().setVisible(true);
		////this.setVisible(false);
	}// GEN-LAST:event_jButton3ActionPerformed

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
		// (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the default
		 * look and feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
		 */

		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(Coupling_table.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Coupling_table.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Coupling_table.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Coupling_table.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}
		// </editor-fold>
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Coupling_table().setVisible(true);

			}
		});
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
