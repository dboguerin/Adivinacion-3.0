/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adivinacion.pkg3.pkg0;

import java.util.Scanner;
import adivinacion.pkg3.pkg0.libreria.dominio;
import static java.lang.Thread.sleep;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yoyo
 */
public class Funcionalidad {

    Scanner instruccion = new Scanner(System.in);
    dominio libreria = new dominio();
    int cant;

    public void iniciar() {
        System.out.println("######################################");
        System.out.println("Bienvenido");
        System.out.println("¿Con cuantas cartas desea jugar?");
        cant = instruccion.nextInt();
        if (libreria.verifica(cant)) {
            agregar(cant);
            System.out.print("\n\nEstas son las cartas, piense en una y que se le quede...\n");
            imprime();
            System.out.println("\nya barajado: ");
            baraja();
            imprime();
        }else{
            System.out.println("El numero de cartas elegido debe ser multiplo de 3 impar... (no mayor a 100)");
            iniciar();
        }

    }

    private static int calculo(double num, int base) {
        return (int) Math.round(Math.log10(num) / Math.log10(base));
    }

    private void agregar(int cant) {
        int contador = 1;
        for (int i = 0; i < cant; i++) {
            Carta.cartas.add(new Carta(contador));
            contador++;
        }
    }

    private void imprime() {
        for (int i = 0; i < cant; i++) {
            System.out.print(Carta.cartas.get(i).valor+ "... ");
        }
    }
    
    private void baraja(){
     Collections.shuffle(Carta.cartas);
    }
}
