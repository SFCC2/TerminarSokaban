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
public interface Stack {
    //  pila: es apilar(encima unas sobre otras(FIFO= primero en entrar y primero en salir= Cola), (LIFO= ultimo en entrar y primero en salir=pila) 
    //(FIFO= first input,  first  out), (LIFO= Last input,  first  out), 
    //pila solo entran y salgan por un mismo lado. para sacar debe sacar todo lo que esta ahi hasta encontarlo
    // y luego vuelve a meter todo para poder meter el numero ingresado
  


	public boolean empty();
        // si esta vacia
	public Object peek();
        /*
        peek que es? en donde esta el pico
        x4 La punta del arreglo o el ultimo dato que ingreso
        c3 dato4
        x2 dato3
        x2 dato2
        x  dato1
        */
	public void push(Object theObject);
        /*
        poner el primero o el ultimo de la fila
        */
	public Object pop();
        /*
        sacar el primero o eltulmo de la fila
        */
}
