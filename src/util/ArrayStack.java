/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author Profesor
 * @author Sulay Cupitra de la ultima modificacion clase 8 septiembre2016
 */
import java.util.EmptyStackException;
import util.ChangeArrayLength;
public class ArrayStack implements Stack {
	// data members
    /*
    DIRECTAMENTE VOY A IMPLEMENTAR TODO EN ESTE LUGAR
    */
	int top; // current top of stack 
        Object [] stack; // element array
	
	// constructors
	public ArrayStack(int initialCapacity) {

		if (initialCapacity < 1) 
			throw new IllegalArgumentException ("initialCapacity must be >= 1");
		stack = new Object [initialCapacity];
		top = -1;
	}

	public ArrayStack() { 
		this(10);
	}
	
	// methods
	public boolean empty() { 
            /*
            POR QUE EL MENOS UNO?
            
            */
		return top == -1;
	}
	
	public Object peek() {  
		if (empty())
			throw new EmptyStackException();/*es prpio de java por que es vacia
                
                */
		return stack[top];
	}
	
	public void push(Object theElement) { 
            //incrementa el arreglo
		// increase array size if necessary
		if (top == stack.length - 1)
                    stack = ChangeArrayLength.changeLength1D(stack, 2 * stack.length);  
                /* 
                
*/


		// put theElement at the top of the stack
   		stack[++top] = theElement;
	}
	
	public Object pop() {
            // eliminar como tal las cosas
		if (empty())
   			throw new EmptyStackException();
		Object topElement = stack[top];
		stack[top--] = null; // enable garbage collection
		return topElement;
	}

    @Override
    public String toString() {
        return "ArrayStack{" + "top=" + top + ", stack=" + stack + '}';
    }

}