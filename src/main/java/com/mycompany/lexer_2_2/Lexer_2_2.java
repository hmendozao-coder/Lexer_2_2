/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lexer_2_2;
import java.util.Scanner;


/**
 *
 * @author Usuario
 */
public class Lexer_2_2 {

static final int ERROR = -1;
    static final int ACEPTAR = 0;

    // ====== Variables para manejar la entrada ======
    private static String entrada = "";
    private static int posicion = 0;

    // ====== Método para obtener el siguiente carácter ======
    static char obtenerCaracter() {
        if (posicion < entrada.length()) {
            return entrada.charAt(posicion++);
        }
        return '\0'; // Fin de la entrada
    }

    // ====== Estados del autómata ======
    static int estado_0() {
        char c = obtenerCaracter();
        switch (c) {
            case 'a': return estado_1();
            case 'b': return estado_4();
            default:  return ERROR;
        }
    }

    static int estado_1() {
        char c = obtenerCaracter();
        switch (c) {
            case 'a': return estado_1();
            case 'b': return estado_2();
            default:  return ERROR;
        }
    }

    static int estado_2() {
        char c = obtenerCaracter();
        switch (c) {
            case 'a': return estado_1();
            case 'b': return estado_3();
            default:  return ERROR;
        }
    }

    static int estado_3() {
        return ACEPTAR;
    }

    static int estado_4() {
        char c = obtenerCaracter();
        switch (c) {
            case 'a': return estado_1();
            case 'b': return estado_4();
            default:  return ERROR;
        }
    }

    // ====== Método principal ======
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=================================================");
        System.out.println("  ANALIZADOR LÉXICO - Expresión regular (a|b)*abb");
        System.out.println("=================================================");
        System.out.print("Ingrese una cadena sobre {a,b}: ");

        entrada = scanner.nextLine();
        posicion = 0;

        int resultado = estado_0();

        System.out.println("-------------------------------------------------");
        System.out.println("Cadena ingresada : \"" + entrada + "\"");
        if (resultado == ACEPTAR) {
            System.out.println("Resultado        : ACEPTADA ✔ (la cadena termina en 'abb')");
        } else {
            System.out.println("Resultado        : ERROR ✘ (la cadena NO termina en 'abb')");
        }
        System.out.println("=================================================");

        scanner.close();
    }
}