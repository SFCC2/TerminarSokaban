/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sokabanban;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;
import util.ArrayLinearList;
import util.ArrayStack;
import static util.BubbleSort.bubbleSort;
import static util.InsertionSort.insertionSort;
import static util.MergeSort.mergeSort;
import static util.QuickSort.quickSort;
import static util.SelectionSort.selectionSort;

/**
 *Clase Funcion del juego
 * @author Sulay Fernanda Cupitra Cupitra
 * @since 16 Noviembre 2016
 * @version 1.5
 */
public class tableros {

int arriba, abajo,derecha,  izquierda;
    ArrayLinearList list;
    ArrayStack movimientos;

    public tableros() {
        list = new ArrayLinearList(2);
        movimientos = new ArrayStack(10000);

        
        
        list.add(0, new tablero().tablero1());
        list.add(1, new tablero().tablero2());
        list.add(2, new tablero().tablero3());
    }

    public void imprimirTablero(int tablero) {
        for (int i = 0; i < ((tablero) list.get(tablero)).filas; i++) {
            for (int j = 0; j < ((tablero) list.get(tablero)).columnas; j++) {
                if (((tablero) list.get(tablero)).Final[i][j].equals("_") && ((tablero) list.get(tablero)).M[i][j].equals("*")) {
                    System.out.print(((tablero) list.get(tablero)).Final[i][j] + " ");
                } else {
                    System.out.print(((tablero) list.get(tablero)).M[i][j] + " ");
                }
            }
            System.out.println("");
        }
    }
/*
    en este sector se creo con el proposito de mostrar cuales pasos que uso el juegador para lograr la meta o el fracaso del mismo.
    esto solo funciona cuando el jugador gana el juego o cuando este se retira del mismo
    */
    public void adicionarMovimiento(char mov) {
        movimientos.push(mov);
    }

    public void imprimirMovientos() {
        List<String> movsList = new ArrayList();

        while (!movimientos.empty()) {
            char mov = (char) movimientos.pop();
            System.out.print(mov + " ");
            movsList.add(String.valueOf(mov));
        }

        /*System.out.println("");
        System.out.println("Ordenados por:");
        */
        JOptionPane.showMessageDialog(null, "los movimientos estan ordenados por:");
        String[] a = new String[movsList.size()];
        for (int i = 0; i < movsList.size(); i++) {
            a[i] = movsList.get(i);
        }
      
        
               System.out.println("");
        System.out.println("quickSort: " );
        quickSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("");

         System.out.println("SelectionSort: " );
        selectionSort(a);
        
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("");
        
        

         System.out.println("InsertionSort: " );
        insertionSort(a);
        
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("");
        
        System.out.println("");

         System.out.println("BubbleSort: " );
        bubbleSort(a);
        
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("");
        
        System.out.println("");

         System.out.println("MergeSort: " );
        mergeSort(a);
        
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("");
/*
        System.out.println("SelectionSort: " );
        selectionSort(a);
        */
    }

    public boolean finalizo(int tablero) {
        for (int i = 0; i < ((tablero) list.get(tablero)).filas; i++) {
            for (int j = 0; j < ((tablero) list.get(tablero)).columnas; j++) {
                if (((tablero) list.get(tablero)).M[i][j].equals("O") && !((tablero) list.get(tablero)).Final[i][j].equals("_")) {
                    return false;
                }
            }
        }
        return true;
    }
/*
    en esta parte del codigo se hace una comapracion del objeto ingresado apra poder mover el jugador del juego y hacer sus diferentes accione sde este dentro del mismo
    */
    public int arriba(int tablero, int fila, int columna, String objeto) {
        arriba++;
        if (fila == 0) {
            return fila; //borde superior
        }
        String caracter = ((tablero) list.get(tablero)).M[fila - 1][columna];

        if (caracter.equals("O") && objeto.equals("O")) {
            return fila;
        }

        if (caracter.equals("*")) {
            ((tablero) list.get(tablero)).M[fila - 1][columna] = objeto;
            ((tablero) list.get(tablero)).M[fila][columna] = "*";
            return fila - 1;
        }

        if (caracter.equals("X")) {
            return fila;
        }

        if (caracter.equals("O")) {
            int nuevaJ = arriba(tablero, fila - 1, columna, "O");
            if (nuevaJ == fila - 2) {
                return arriba(tablero, fila, columna, "J");
            }
        }

        return fila;
    }

    public int izquierda(int tablero, int fila, int columna, String objeto) {
        izquierda++;
        if (columna == 0) {
            return columna; //borde izquierdo
        }
        String caracter = ((tablero) list.get(tablero)).M[fila][columna - 1];

        if (caracter.equals("O") && objeto.equals("O")) {
            return columna;
        }

        if (caracter.equals("*")) {
            ((tablero) list.get(tablero)).M[fila][columna - 1] = objeto;
            ((tablero) list.get(tablero)).M[fila][columna] = "*";
            return columna - 1;
        }

        if (caracter.equals("X")) {
            return columna;
        }

        if (caracter.equals("O")) {
            int nuevaJ = izquierda(tablero, fila, columna - 1, "O");
            if (nuevaJ == columna - 2) {
                return izquierda(tablero, fila, columna, "J");
            }
        }

        return columna;
    }

    public int abajo(int tablero, int fila, int columna, String objeto) {
        abajo++;
        if (fila == ((tablero) list.get(tablero)).filas - 1) {
            return fila; //borde inferior
        }

        String caracter = ((tablero) list.get(tablero)).M[fila + 1][columna];

        if (caracter.equals("O") && objeto.equals("O")) {
            return fila;
        }

        if (caracter.equals("*")) {
            ((tablero) list.get(tablero)).M[fila + 1][columna] = objeto;
            ((tablero) list.get(tablero)).M[fila][columna] = "*";
            return fila + 1;
        }

        if (caracter.equals("X")) {
            return fila;
        }

        if (caracter.equals("O")) {
            int nuevaJ = abajo(tablero, fila + 1, columna, "O");
            if (nuevaJ == fila + 2) {
                return abajo(tablero, fila, columna, "J");
            }
        }

        return fila;
    }

    public int derecha(int tablero, int fila, int columna, String objeto) {
       derecha++;
        if (columna == ((tablero) list.get(tablero)).columnas - 1) {
            return columna; //borde derecho
        }

        String caracter = ((tablero) list.get(tablero)).M[fila][columna + 1];

        if (caracter.equals("O") && objeto.equals("O")) {
            return columna;
        }

        if (caracter.equals("*")) {
            ((tablero) list.get(tablero)).M[fila][columna + 1] = objeto;
            ((tablero) list.get(tablero)).M[fila][columna] = "*";
            return columna + 1;
        }

        if (caracter.equals("X")) {
            return columna;
        }

        if (caracter.equals("O")) {
            int nuevaJ = derecha(tablero, fila, columna + 1, "O");
            if (nuevaJ == columna + 2) {
                return derecha(tablero, fila, columna, "J");
            }
        }

        return columna;
    }
   
}
