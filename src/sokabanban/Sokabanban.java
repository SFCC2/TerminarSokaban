/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sokabanban;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *Clase Funcion del juego
 * @author Sulay Fernanda Cupitra Cupitra
 * @since 16 Noviembre 2016
 * @version 1.5
 */
public class Sokabanban {

    /**
     * @param args the command line arguments
     * es la interface de comunicacion entre el estudiante y el programa.
     * por tanto aqui se le menciona al usuario las reglas apra poder jugar esta aplicacion
     */
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        tableros tab = new tableros();
        JOptionPane.showMessageDialog(null, "JUEGO SOKOBAN version 1.5");
       
       JOptionPane.showMessageDialog(null, "El proposito del juego es mover los circulos a las lines y el jugador esta represantdo con la letra J\nLos tableros disponibles en el juego son dos digite el numero:\n0) para tablero 1\n1) para tablero 2.\n\nLas forma de moverse en el juego es de la siguiente manera usando las letras del teclado:\nARRIBA=        w\nABAJO=         s\nDERECHO=    d\nIZQUIERDO=  a\n\npara SALIR seleccione el simbolo del teclado= +\n", "Warning",
        JOptionPane.WARNING_MESSAGE);
       System.out.println("Seleccione un tablero:");
        int tableroActual = leer.nextInt();
        System.out.println(" ");

        int filaActual = ((tablero) tab.list.get(tableroActual)).posJfila;
        int columnaActual = ((tablero) tab.list.get(tableroActual)).posJcolumna;
        int filaNueva = ((tablero) tab.list.get(tableroActual)).posJfila;
        int columnaNueva = ((tablero) tab.list.get(tableroActual)).posJcolumna;

        tab.imprimirTablero(tableroActual);

        char mov = ' ';
        while (mov != '+' && !tab.finalizo(tableroActual)) {
            System.out.println();
            mov = leer.next().charAt(0);
            System.out.println();

            switch (mov) {
                case 'w':
                    //arriba
                    filaNueva = tab.arriba(tableroActual, filaActual, columnaActual, "J");
                    if (filaNueva != filaActual) {
                        tab.adicionarMovimiento(mov);
                    }
                    filaActual = filaNueva;
                    tab.imprimirTablero(tableroActual);
                    break;
                case 'a':
                    //izquerda
                    columnaNueva = tab.izquierda(tableroActual, filaActual, columnaActual, "J");
                    if (columnaActual != columnaNueva) {
                        tab.adicionarMovimiento(mov);
                    }
                    columnaActual = columnaNueva;
                    tab.imprimirTablero(tableroActual);
                    break;
                case 's':
                    //abajo
                    filaNueva = tab.abajo(tableroActual, filaActual, columnaActual, "J");
                    if (filaNueva != filaActual) {
                        tab.adicionarMovimiento(mov);
                    }
                    filaActual = filaNueva;
                    tab.imprimirTablero(tableroActual);
                    break;
                case 'd':
                    //derecha
                    columnaNueva = tab.derecha(tableroActual, filaActual, columnaActual, "J");
                    if (columnaActual != columnaNueva) {
                        tab.adicionarMovimiento(mov);
                    }
                    columnaActual = columnaNueva;
                    tab.imprimirTablero(tableroActual);
                    break;
                default:
                    break;
            }
        }

        if (tab.finalizo(tableroActual)) {
            //System.out.println("");
           // System.out.println("!! FELICIDADES !!");
           JOptionPane.showMessageDialog(null, "!! FELICIDADES GANASTE !!");
        }
        
        System.out.println("");
        System.out.println("Sus movimientos del mas reciente al mas antiguo son:");
        tab.imprimirMovientos();
        

JOptionPane.showMessageDialog(null, "Hasta luego");
    }

}
