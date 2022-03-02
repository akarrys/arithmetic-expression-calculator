/*
* ArrayStack is generic ADT with generic Stack implementation.
* Elements are stored in array Data.
* MAX_CAPACITY is fixed default array value.
* Cap is given value for size of array for 100.
* Bottom element is always data[0].
* Top element of stack in cell data[top] for index top is equal to -1.
* Author: akarrys
* Java SE 17
* 22-02-21
*/
import java.util.*;
import java.io.*;

public class ArrayStack <E> implements Stack <E> {
    public static final int MAX_CAPACITY = 100; //array stack size is set to 100.
    private E[] data; //generic array used for stack elements
    private int tops = -1; //index of the top element of stack.


   public ArrayStack(){
       this(MAX_CAPACITY);
   }

    public ArrayStack(int cap){ //constructor for given capacity of 100
        data = (E[]) new Object [MAX_CAPACITY];
    }


    @Override
    public int size() { //accessor method to determine number of items in stack.
        return (tops + 1); //return number of items in stack.
    }


    @Override
    public boolean isEmpty() { //check if elements are in stack and stored
        return (tops == -1); //stack is empty when equal to top is -1
    }

    @Override
    public void push(E e) throws IllegalStateException { //push new e into stack
        if (size() == data.length) throw
                new IllegalStateException("Stack is full capacity"); //if stack is at full cap.
        data[++tops] = e; //increment stack E to make room for e cell item to insert.
    }

    @Override
    public E top() { //if stack is not empty
        if(isEmpty()) //fetch
        {
           return null; //no data indicated
        }
            return data[tops]; //return last inserted item without removing
    }


    @Override
    public E pop() { //get top item removing it from stack, if stack is not empty
       if(isEmpty())
       { //if empty make null ref for top to refer
           return null;
       }
        E ANSWER = data[tops];
        data[tops] = null; //de reference for garabage collection
        tops--; //detach last element in stack
        return ANSWER; //return top item removed from stack
    }
}





