/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sokabanban;

/**
 *Clase Pista del juego
 * @author Sulay Fernanda Cupitra Cupitra
 * @since 16 Noviembre 2016
 * @version 1.5
 */
public class tablero {
    String[][] M;
    String[][] Final;
    int filas;
    int columnas;
    int posJfila;
    int posJcolumna;
    /*
    se crea una pista y  y esta se duplica generando dos pistas una pista original y otra modificable.
    una vez que el jugador llegue al limite de sus movimientos o llegue a las lineas del juego.
    la pista original y la modificada se compara si coincide gano el juego, de lo contrario no.
    Adicional a esto se debe dar la posicion excata del J para poder moverlo en el juego.
    */
    public tablero tablero1() {
        tablero T = new tablero();
        T.columnas = 5;
        T.filas = 5;
        String[][] m = {
            {"*", "*", "*", "*", "*"},
            {"*", "*", "O", "O", "*"},
            {"*", "O", "*", "O", "J"},
            {"*", "*", "X", "X", "X"},
            {"*", "*", "X", "X", "X"}
        };

        String[][] f = {
            {"*", "*", "*", "*", "*"},
            {"*", "*", "*", "*", "*"},
            {"*", "*", "*", "*", "*"},
            {"_", "_", "*", "*", "*"},
            {"_", "_", "*", "*", "*"}
        };

        T.M = m;
        T.Final = f;
        T.posJfila = 2;
        T.posJcolumna = 4;

        return T;
    }
    
    public tablero tablero2() {
        tablero T = new tablero();
        T.columnas = 6;
        T.filas = 4;
        String[][] m = {
            {"X", "X", "*", "*", "X", "X"},
            {"X", "*", "*", "*", "*", "*"},
            {"*", "*", "J", "O", "O", "*"},
            {"*", "*", "*", "X", "*", "*"}
        };

        String[][] f = {
            {"*", "*", "*", "*", "*", "*"},
            {"*", "*", "*", "*", "*", "*"},
            {"*", "*", "*", "*", "*", "_"},
            {"*", "*", "*", "*", "*", "_"}
        };

        T.M = m;
        T.Final = f;
        T.posJfila = 2;
        T.posJcolumna = 2;

        return T;
    }
    
     public tablero tablero3() {
        tablero T = new tablero();
        T.columnas = 4;
        T.filas = 4;
        String[][] m = {
            {"X", "*", "*", "*",},
            {"X", "*", "*", "*",},
            {"*", "O", "O", "*",},
            {"*", "*", "J", "X",}
        };

        String[][] f = {
            {"*", "*", "*", "*",},
            {"*", "*", "*", "_",},
            {"*", "*", "*", "*",},
            {"*", "_", "*", "*",}
        };

        T.M = m;
        T.Final = f;
        T.posJfila = 3;
        T.posJcolumna = 2;

        return T;
    }
}
