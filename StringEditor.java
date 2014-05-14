/** Jordan Buttkevitz
 *  University of Pittsburgh
 *  Data Structures
 *  Project: MyString
 *  */

package javaapplication1;

import java.util.Scanner;
/**
 *
 * @author Jordan
 */
public class StringEditor {
    public static void main(String[] args) {
        Scanner LineInput = new Scanner(System.in);
        System.out.print("Please enter a String : ");
        String str = LineInput.nextLine();
        System.out.println("String  : " + str);
        printPosition(str);
     
        MyString myStr = new MyString(str);
        
        String inputCommand = "";
        String[] commands;
        boolean positionOn = true;
        
        try {
          while(!inputCommand.equals("exit")) {
            System.out.print("\n\n> ");
            inputCommand = LineInput.nextLine();
            commands = inputCommand.split(" ");
 
            // append "INPUT STR"
            if (commands[0].equals("append")) {
                String input = getInputString(inputCommand, commands[0]);
                myStr.append(removeQuatations(input));
                  System.out.print("append input \"" + input + "\"");
                printResult(myStr, positionOn);
            }
            // insert startIndex "INPUT STR"
            if (commands[0].equals("insert")) {
                int index = Integer.parseInt(commands[1]);
                String input = getInputString(inputCommand, commands[0], commands[1]);
                myStr.insert(index, removeQuatations(input));
                printResult(myStr, positionOn);
            }
            // delete startIndex endIndex
            if (commands[0].equals("delete")) {
                myStr.delete(Integer.parseInt(commands[1]), Integer.parseInt(commands[2]));
                printResult(myStr, positionOn);
            }
            // charAt index
            if (commands[0].equals("charAt")) {
                char c = myStr.charAt(Integer.parseInt(commands[1]));
                printResult(myStr, c, positionOn);
            }
            // deleteCharAt index
            if (commands[0].equals("deleteCharAt")) {
                myStr.deleteCharAt(Integer.parseInt(commands[1]));
                printResult(myStr, positionOn);
            }
            // indexOf "String"
            if (commands[0].equals("indexOf")) {
                String input = getInputString(inputCommand, commands[0]);
                int i = myStr.indexOf(removeQuatations(input));
                printResult(myStr, i, positionOn);
            }
            // length 
            if (commands[0].equals("length")) {
                int i = myStr.length();
                printResult(myStr,i, positionOn);
            }
            // reverse
            if (commands[0].equals("reverse")) {
                myStr.reverse();
                printResult(myStr, positionOn);
            }
            // position off
            if (commands[0].equals("position")) {
                if (commands[1].equals("on")) {
                    positionOn = true;
                    printResult(myStr, positionOn);
                } else if (commands[1].equals("off")) {
                    positionOn = false;
                    printResult(myStr, positionOn);
                }
            
            }
            
            if (commands[0].equals("help")) {
                String help = "append \"str\"     - append the string str to the end of the sequence\n" +
                              "charAt x         - show the character at location x\n" +
                              "delete x y       - delete characters from x to y - 1\n" +
                              "deleteCharAt x   - Delete character that location x" +
                              "help             - Show this help message\n" +
                              "indexOf \"str\"    - Show index of first matches of the string str\n" +
                              "insert x \"str\"   - Insert string str at location x\n" +
                              "length           - Show the length of the string\n" +
                              "position on      - Show character positions under the string\n" +
                              "position off     - Do not show character positions under the string\n" +
                              "reverse          - Reverse the string\n" +
                              "quit             - Exit";
                System.out.println("\n" + help);
                printResult(myStr, positionOn);                
            }                   
          }
        } catch (Exception ex) {
            System.out.println("Invalid input! Please enter help to see the command list.");
        }
    }
    
    private static String getInputString(String commandString, String command) {
        String newStr = "";
       
        for (int i = command.length() + 1; i < commandString.length(); i++) {
            newStr = newStr.concat(String.valueOf(commandString.charAt(i)));
               
        }     
        return newStr;    
    }
    
    private static String getInputString(String commandString, String command, String input) {
        String newStr = "";
        for (int i = command.length() + input.length() + 2; i < commandString.length(); i++) {
            newStr = newStr.concat(String.valueOf(commandString.charAt(i)));
        }
        
        return newStr;   
    }
    
    private static String removeQuatations(String str) {
        String newStr = "";
        
        for (int i = 1; i < str.length() - 1; i++) {
            newStr = newStr.concat(String.valueOf(str.charAt(i)));
        }
        return newStr;
        
    }
    
    private static void printResult(MyString myStr, boolean positionOn) {
        System.out.println("\nString  : " + myStr.toString());
        if (positionOn) {
            printPosition(myStr.toString());
        }
    }
    
    private static void printResult(MyString myStr, char c, boolean positionOn) {
        System.out.println("\n" + c);
        System.out.println("String  : " + myStr.toString());
        if (positionOn) {
            printPosition(myStr.toString());
        }
    }
    
       private static void printResult(MyString myStr, int i, boolean positionOn) {
        System.out.println("\n" + i);
        System.out.println("String  : " + myStr.toString());
        if (positionOn) {
            printPosition(myStr.toString());
        }
    }
     
    private static void printPosition(String str) {
        System.out.print("Position: ");
        for (int i = 0; i < str.length(); i++) {
            System.out.print(i % 10);
        }
    }
}
