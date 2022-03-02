/*
   Objects are inserted and removed according to LIFO
   Author: Artamis Karrys
   Java SE 16
 */
import java.util.EmptyStackException;
 public interface Stack<E> {



    int size();
    //return number of elements in stack

    boolean isEmpty();
    //test to see if stack is empty

    void push (E e);
    //insert element at top of stack

     E top();
     //return but not remove element at top of stack

     E pop();
 }
