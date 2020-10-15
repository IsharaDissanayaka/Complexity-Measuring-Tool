/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Complexity_Mesuring_Tool;

/**
 *
 * @author User
 */
public class StackX {

    private int maxSize;  //size of stack array
    private int top;      //top of the stack
    private char[] stackArray;

    public StackX(int s) {
        super();
        maxSize = s;   //set array to size
        top = -1;   //no items
        stackArray = new char[maxSize];
    }

    public void push(char value) {
        if (top != maxSize - 1) {
            stackArray[++top] = value;
        } else {
            System.out.println("Stack is Full");
        }
    }

    public char pop() {
        if (top != -1) {
            return stackArray[top--];
        } else {
            return 'a';
        }
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == maxSize - 1);
    }
}
