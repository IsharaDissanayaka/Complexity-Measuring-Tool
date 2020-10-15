/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Complexity_Mesuring_Tool;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Asus
 */
public class CompleteComplexity extends javax.swing.JFrame {

    /**
     * Creates new form CompleteComplexity
     */
    public CompleteComplexity() {
        initComponents();
        int nc = 0;
        int fc = 0;
        BufferedReader br = null;
        try {
            // reading text
            br = new BufferedReader(new FileReader(uploadpage.fileName.getText()));
            String line;
            Scanner x;

            // int dCcspps = 0;
            int[] getArray = null;
            DefaultTableModel model1 = (DefaultTableModel) complete.getModel();
            int linesCal = Integer.parseInt(uploadpage.count1.getText());
            int i = 1;
            try {
                int xx = Integer.parseInt(ContralStructure_weight.weightIF.getText());
// scan line by line
                while (i <= linesCal) {
                    line = br.readLine();
                    x = new Scanner(line);
                    // while(x.hasNext()){
                    int NCcspps = nc;
                    int fCcspps = fc;
                    try {
                        String a = x.next();/////
                        //calling methods and values assign to variables
                        getArray = Ccs(a, fCcspps, NCcspps);
                        int Ccs = getArray[0];
                        nc = getArray[2];
                        fc = getArray[1];
                        int Ci = Ci(line);
                        int Cs = Cs(line);
                        int Cm = Cm(line);
                        int Cv = Cv(line);
                        int Ccp = Ccp(line, i);
                        int total = Ccs + Ci + Ccp + Cs + Cv + Cm;
                        //print the values in the table
                        model1.addRow(new Object[]{
                            line, Cs, Cv, Cm, Ci, Ccp, Ccs, total
                        });

                    } catch (Exception e) {
                        // empty lines
                        model1.addRow(new Object[]{
                            "", 0, 0, 0, 0, 0, 0, 0
                        });

                        e.printStackTrace();
                    }
                    //    nc = NCcspps;
                    // fc = fCcspps;  
                    i++;
                }
                //print total complexity
                int sum = getsum(linesCal);
                totalcomplexity.setText(Integer.toString(sum));

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

    }
//cal total complexity by column values sum
    public int getsum(int no) {
        int sum = 0;
        for (int i = 0; i < no; i++) {
            sum = sum + Integer.parseInt(complete.getValueAt(i, 7).toString());

        }
        return sum;
    }
    ////////////////////////////////////////////////////////////////////////////////////////// SIZE ////////////////////////////////////////////////////////////////////////////////

    public int Cs(String line) {

        int totCost = 0;
        int ws1, ws2, ws3, ws4, ws5;
        String[] printwQ = new String[]{};

        ArrayList<String> printQ = new ArrayList<String>();
        try {

            int x1 = Integer.parseInt(SizeWeightt.ws1.getText());
            int x2 = Integer.parseInt(SizeWeightt.ws2.getText());
            int x3 = Integer.parseInt(SizeWeightt.ws3.getText());
            int x4 = Integer.parseInt(SizeWeightt.ws4.getText());
            int x5 = Integer.parseInt(SizeWeightt.ws5.getText());

            int TCs = 0;

            String[] keywords = new String[]{"long", "fibonacci", "number", "void", "double", "int", "float", "String", "cout", "cin", "get",
                "if", "for", "while", "do-while", "switch", "case", "main", "System", "out", "println", "args", "operator", "bark", "count", "accessFiles", "FileNotFoundException", "FileReader", "f", "catch", "e", "std", "this", "Dog", "Animal"};

            int keywordSize = keywords.length;

            String[] stringLi = new String[]{"long", "fibonacci", "number", "double", "String", "cout", "cin", "get",
                "System", "out", "println", "args", "operator", "bark", "count", "accessFiles", "FileNotFoundException", "FileReader", "f", "catch", "e", "std", "this", "Dog", "Animal"};

            int stringLSize = stringLi.length;

            String[] numbers = new String[]{"long", "fibonacci", "number", "get",
                "if", "for", "while", "do-while", "switch", "case", "operator", "accessFiles", "FileNotFoundException", "FileReader", "f", "catch"};

            int numberSize = numbers.length;

            String[] ariOperators = new String[]{"+", "-", "*", "%", "++", "--"};
            int arithOSize = ariOperators.length;

            String[] relOperators = new String[]{"==", "!=", ">", "<", ">=", "<="};
            int relatOSize = relOperators.length;

            String[] logicOperators = new String[]{"&&", "||", "!"};
            int logicOSize = logicOperators.length;

            String[] bitwiseOperators = new String[]{"|", "^", "~", "<<", ">>", "<<<", ">>>"};
            int bitwOSize = bitwiseOperators.length;

            String[] miscellaneous = new String[]{"->", ".", "::", "~"};
            int miscOSize = miscellaneous.length;

            String[] assignOperators = new String[]{"=", "+=", "-=", "*=", "/=", ">>>=", "|=", "&=", "<<=", ">>=", "%=",
                "^="};
            int assOSize = assignOperators.length;

            String words[] = line.split(" ");
            int keywordsCounts = 0;
            int arithOSizes = 0;
            int StringL = 0;
            int identifier = 0;

            int numericalVal = 0;

            for (int k = 0; k < keywordSize; k++) {

                int a = 0;

                for (a = 0; a < words.length; a++) {

                    if (words[a].equals(keywords[k])) {

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
                    if (words[b].equals(ariOperators[m])) {
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
                    if (words[b].equals(relOperators[m])) {
                        TCs++;
                        arithOSizes++;
                        totCost = arithOSizes * Integer.parseInt(SizeWeightt.ws3.getText());
                        printQ.add(words[b]);
                    }

                }
            }

            //********Loop for logic operators**********  
            for (int m = 0; m < logicOSize; m++) {
                int b = 0;
                for (b = 0; b < words.length; b++) {
                    if (words[b].equals(logicOperators[m])) {
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
                    if (words[b].equals(assignOperators[m])) {
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
                    if (words[b].equals(bitwiseOperators[m])) {
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
                    if (words[b].equals(miscellaneous[m])) {
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
                    if (words[b].equals(assignOperators[m])) {
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

                    if (words[a].equals(stringLi[s])) {

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

                    if (words[a].equals(numbers[n])) {

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

                    if (words[a].equals(keywords[k])) {

                        TCs++;

                        identifier++;
                        totCost = identifier * Integer.parseInt(SizeWeightt.ws2.getText());

                        printQ.add(words[a]);

                    }

                }

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Please check the weight");
            e.printStackTrace();

        }
        return totCost;
    }

    /////////////////////////////////////////////////////////////////////////////////////////// VARIABLE /////////////////////////////////////////////////////////////////////////////
    public int Cv(String line) {

        int totCost = 0;
        try {

            String[] variables = new String[]{"boolean", "byte", "char", "short", "long", "int", "float", "double"};

            int variableSize = variables.length;

            String words[] = line.split(" ");
            int variablesCounts = 0;
            int primVariable = 0;

            for (int k = 0; k < variableSize; k++) {

                int a = 0;

                for (a = 0; a < words.length; a++) {

                    if (words[a].equals(variables[k])) {

                        variablesCounts++;
                        totCost = variablesCounts * Integer.parseInt(VariableWeight.va1.getText());

                    }

                }

            }

            for (int k = 0; k < primVariable; k++) {

                int a = 0;

                for (a = 0; a < words.length; a++) {

                    if (words[a].equals(variables[k])) {

                        primVariable++;
                        totCost = primVariable * Integer.parseInt(VariableWeight.va3.getText());

                    }

                }

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Please check the weight");
            e.printStackTrace();

        }
        return totCost;
    }

    /////////////////////////////////////////////////////////////////////////////////////////// Methods /////////////////////////////////////////////////////////////////////////////
    public int Cm(String line) {

        String[] printwQ = new String[]{};

        ArrayList<String> printQ = new ArrayList<String>();
        int totCost = 0;

        try {
            int TCs = 0;

            String[] methods = new String[]{"boolean", "byte", "char", "short", "long", "int", "float", "double"};

            int keywordmethod = methods.length;

            String words[] = line.split(" ");
            int methodCounts = 0;

            for (int k = 0; k < keywordmethod; k++) {

                int a = 0;

                for (a = 0; a < words.length; a++) {

                    if (words[a].equals(methods[k])) {
                        TCs++;
                        methodCounts++;
                        totCost = methodCounts * Integer.parseInt(MethodWeight.mw4.getText());
                        printQ.add(words[a]);

                    }

                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Please check the weight");
            e.printStackTrace();

        }
        return totCost;
    }

    /////////////////////////////////////////////////////////////////////////////////////// INHERITANCE/////////////////////////////////////////////////////////////////
    public int Ci(String line) {
        int count_ci;
        String indirect;
        String direct;
        String first;
        String second;
        int countstar;
        int count_indirect;
        int count_direct;
        int count_total;
        int count;
        int w1, w2, w3, w4, w5;
        int Tot;
        String words[] = line.split("\\s");

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
                countstar = countstar + 1;
                first = words[++x];
                System.out.print("class " + first + " ");

            }

            count_direct = countstar;

        }

        //-------------------------Indirect------------------------------------
        for (int x = 0; x < words.length; x++) {
            indirect = "extends";

            if (words[x].equals(indirect)) {

                count = count + 1;
                second = words[++x];
                System.out.println("extends " + second + " ");

            }

            count_indirect = count;

        }

        //--------------------------Total-------------------------------------
        count_total = count_direct + count_indirect;

        //---------------------------Ci----------------------------------------
        if (count_direct == 0) {

            count_ci = count_total * Integer.parseInt(InheritanceWeightUI.w1.getText());

        } else if (count_total == 1) {

            count_ci = count_total * Integer.parseInt(InheritanceWeightUI.w2.getText());

        } else if (count_total == 2) {

            count_ci = (count_total) * Integer.parseInt(InheritanceWeightUI.w3.getText());

        } else if (count_total == 3) {

            count_ci = (count_total) * Integer.parseInt(InheritanceWeightUI.w4.getText());

        } else {
            count_ci = (count_total) * Integer.parseInt(InheritanceWeightUI.w5.getText());
        }
        return count_ci;

    }

    //////////////////////////////////////////////////////////////////// COUPLING /////////////////////////////////////////////////////////////////////////////////////////////////    
    public int Ccp(String line, int no) {
       // String regexString = line;
String regexString = uploadpage.fileName.getText();
        List<String> list = new ArrayList();
        List<String> list2 = new ArrayList();
        // Set<String> listOfOtherMethodCallsThisFile = new HashSet();

        Map<String, String> normalToNormal = new LinkedHashMap();
        Map<String, String> normalToRecursive = new LinkedHashMap();
        Map<String, String> RecursiveToNormal = new LinkedHashMap();
        Map<String, String> RecursiveToRecursive = new LinkedHashMap();

        Map<String, String> globalVar = new LinkedHashMap();

        list.add(no + "#" + line);

        ////////
        
        try (BufferedReader br = new BufferedReader(new FileReader(uploadpage.fileName.getText()))) {

			String line1;
			int no1 = 1;

			while ((line1 = br.readLine()) != null) {
				// process the line.
				// Add to list for no and codeline
				list2.add(no1 + "#" + line1);

				no1++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        //////////
        
        
         //String regexString = uploadpage.l1.getText();
        	for (int x = 0; x < list2.size(); x++)
        	regexString += list2.get(x) + "\n";
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
        String[] removeMetho = {regexString};

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

        //System.out.println(normalToNormal + "  normalToNormal");
        //System.out.println(normalToRecursive + " normalToRecursive");
        //System.out.println(RecursiveToNormal + " RecursiveToNormal");
        //System.out.println(RecursiveToRecursive + " RecursiveToRecursive");
        //for (int i1 = 0; i1 < list.size(); i1++) {
        //  public int Ccp(String a, String line) {
        int Ccp = 0;

        //String originalCodeLine = list.get(i1).toString();
        String codeLine[] = {list.get(0).toString()};
        String number = codeLine[0].substring(0, codeLine[0].indexOf("#"));

        boolean[] isRecursiveMethod = {false};

        int[] normalToNormalVal = {0};
        int[] normalToRecursiveVal = {0};
        int[] RecursiveToNormalVal = {0};
        int[] RecursiveToRecursiveVal = {0};

        int[] normalToOtherNormalM = {0};
        int[] normalToOtherRecursiveM = {0};
        int[] RecursiveToOtherNormalM = {0};
        int[] RecursiveToOtherRecursiveM = {0};

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

            if (normal.getValue().equals(number)) {
                normalToNormalVal[0]++;
            }
        });

        normalToRecursive.entrySet().forEach(normal -> {

            if (normal.getValue().equals(number)) {
                normalToRecursiveVal[0]++;
            }
        });

        RecursiveToNormal.entrySet().forEach(normal -> {

            if (normal.getValue().equals(number)) {
                RecursiveToNormalVal[0]++;
            }
        });

        RecursiveToRecursive.entrySet().forEach(normal -> {

            if (normal.getValue().equals(number)) {
                RecursiveToRecursiveVal[0]++;
            }
        });

        int globelVarUse[] = {0};

        int globalUsedByR = 0;
        int globalUsedByNonR = 0;

        int globalFromOtherR = 0;
        int globalFromOtherNonR = 0;

        // check about globle var calling from other files
        int globleFromOther[] = {0};

        String[] replacement = {""};

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

        boolean[] isGloblalCalledFromRecursive = {false};
        boolean[] isMethodRecursive = {false};

        // System.out.println(globalVar);
        thisFileMethods.values().stream().filter(e -> e.isRecursiveCall()).collect(Collectors.toList())
                .forEach(e -> {

                    if (e.getMethodBody().contains(codeLine[0])) {
                        isMethodRecursive[0] = true;
                        if (globelVarUse[0] > 0) {
                            isGloblalCalledFromRecursive[0] = true;
                        }
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

            System.out.println(number + " Codeline  " + ((isRecursiveMethod[0]) ? 2 : 0) + "1 " + normalToNormalVal[0] * 2
                    + " 2" + normalToRecursiveVal[0] * 3
                    + " 3" + RecursiveToRecursiveVal[0] * 4
                    + " 4" + RecursiveToNormalVal[0] * 3 + " 5" + globalUsedByNonR * 1
                    + " 6 " + globalUsedByR * 1);

            Ccp = ((isRecursiveMethod[0]) ? Integer.parseInt(Coupling_weight.w1.getText()) : 0) + normalToNormalVal[0] * Integer.parseInt(Coupling_weight.w2.getText())+ normalToRecursiveVal[0] * Integer.parseInt(Coupling_weight.w3.getText()) + RecursiveToRecursiveVal[0] * Integer.parseInt(Coupling_weight.w5.getText())+ RecursiveToNormalVal[0] *  Integer.parseInt(Coupling_weight.w6.getText())  + globalUsedByNonR *  Integer.parseInt(Coupling_weight.w7.getText())+ globalUsedByR *  Integer.parseInt(Coupling_weight.w8.getText()) ;

           // return Ccp;

        }

        return Ccp;
    }

/////////////////////////////////////////////////////////////////////////////////////// CONTRAL STRUCTURES/////////////////////////////////////////////////////////////////
//check the if statment and return no of arguments    
    public int ifStatement(String a, String line) {

        String line1 = line;
        int Nc = 0;
        try {
            char array[] = new char[16];
            a.getChars(0, 2, array, 0);
            if ((array[0] == 'i') && (array[1] == 'f')) {
                //String st = line;
                Nc = 1;

                String[] newString = line1.split("\\s+");
                for (String ss : newString) {
                    switch (ss) {
                        case "&&":
                        case "||":
                            Nc += 1;
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

//check line by line
    public int[] Ccs(String line, int fCcspps, int NCcspps) {

        String a = line;
        int fCcspp = fCcspps;
        int NCcspp = NCcspps;
        //  int dCcspp = dCcspps;
        int no = 0;
        int wtcs = 0;
        int Ccs = 0;
        int Ccspps = 0;
        char array[] = new char[16];
        int[] csvalues = new int[3];
        a.getChars(0, 1, array, 0);
        if ((array[0] == 'i') || (array[0] == 's') || (array[0] == 'c') || (array[0] == 'e') || (array[0] == 'd') || (array[0] == 'w') || (array[0] == 'f') || (array[0] == '}')) {

            if ((array[0] == 'i') || (array[0] == 'e')) {
                no = ifStatement(a, line);
                if (no > 0) {
                    //wtcs = 2;
                    wtcs = Integer.parseInt(ContralStructure_weight.weightIF.getText());
                    Ccspps = fCcspp;
                    Ccs = (wtcs * no) + Ccspps;
                    fCcspp = Ccs;
                }

                if ((array[0] == 'e')) {
                    fCcspp = endIfStatement(a);
                }

            }

            if ((array[0] == 'f')) {
                no = forStatement(a);
                if (no > 0) {
                    // wtcs = 2;
                    wtcs = Integer.parseInt(ContralStructure_weight.weightFOR.getText());
                    Ccspps = fCcspp;
                    Ccs = (wtcs * no) + Ccspps;
                    fCcspp = Ccs;

                }
            }

            if ((array[0] == '}')) {
                no = doWhileStatement(a);
                if (no > 0) {
                    // wtcs = 2;
                    wtcs = Integer.parseInt(ContralStructure_weight.weightFOR.getText());
                    Ccspps = 0;
                    Ccs = (wtcs * no) + Ccspps;
                    fCcspp = 0;

                } else {
                    wtcs = 0;
                    // no = 0;
                    Ccs = (wtcs * no) + Ccspps;

                }
            }

            if ((array[0] == 'c')) {
                no = caseStatement(a);
                if (no > 0) {
                    //  wtcs = 1;
                    wtcs = Integer.parseInt(ContralStructure_weight.weightCASE.getText());
                    Ccspps = NCcspp;
                    Ccs = (wtcs * no) + Ccspps;
                }

            }

            if ((array[0] == 'd')) {
                no = doStatement(a);
                if (no > 0) {
                    // wtcs = 2;
                    int xwtcs = Integer.parseInt(ContralStructure_weight.weightFOR.getText());
                    wtcs = 0;
                    Ccspps = 0;
                    Ccs = 0;
                    fCcspp = fCcspp + xwtcs;
                }

            }

            ///new
            if ((array[0] == 's')) {
                no = switchStatement(a);
                if (no > 0) {
                    // wtcs = 2;
                    wtcs = Integer.parseInt(ContralStructure_weight.weightSWITCH.getText());
                    Ccspps = 0;
                    Ccs = (wtcs * no) + Ccspps;
                    NCcspp = Ccs;
                }
            }
        } else {
            wtcs = 0;
            no = 0;
            Ccs = (wtcs * no) + Ccspps;
        }
//returning values in an array
        csvalues[0] = Ccs;
        csvalues[1] = fCcspp;
        csvalues[2] = NCcspp;
        return csvalues;

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        complete = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        totalcomplexity = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 0));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setText("Complete Complexity");

        complete.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "program statement", "Cs", "Cv", "Cm", "Ci", "Ccp", "Ccs", "TCps"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(complete);
        if (complete.getColumnModel().getColumnCount() > 0) {
            complete.getColumnModel().getColumn(7).setResizable(false);
        }

        jButton1.setBackground(new java.awt.Color(51, 153, 0));
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Complete Complecity");

        jButton3.setBackground(new java.awt.Color(255, 153, 51));
        jButton3.setText("Save the file");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 51, 51));
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(373, 373, 373)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(totalcomplexity, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(92, 92, 92)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
                        .addGap(102, 102, 102))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(totalcomplexity, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35))))
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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        String filename = uploadpage.fileName.getText();
        int complexity = Integer.parseInt(totalcomplexity.getText());

        uploadpage.addrow2(new Object[]{filename, complexity});
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            //printing the table
            MessageFormat header = new MessageFormat("Complete Complexity!");
            MessageFormat footer = new MessageFormat("======================================");

            complete.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "can not print the table.");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(CompleteComplexity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CompleteComplexity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CompleteComplexity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CompleteComplexity.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CompleteComplexity().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable complete;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField totalcomplexity;
    // End of variables declaration//GEN-END:variables
}
