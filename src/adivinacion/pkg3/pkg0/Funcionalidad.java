/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adivinacion.pkg3.pkg0;

import java.util.Scanner; 
import adivinacion.pkg3.pkg0.libreria.dominio;
import java.util.Collections;

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
            System.out.println("\n\nPiense en una carta y que se le quede... \n");
            juego(calculo(cant, 3));
            
            System.out.println("Desea volver a jugar? s/n");
            String elec=instruccion.next();
            switch(elec){
                case "s":
                    iniciar();
                    break;
                case "n":
                    System.out.println("adios...");
                    break;
                default:
                    System.out.println("Elija una opcion valida...");
                    iniciar();
                    break;
            }

        } else {
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
            System.out.print(Carta.cartas.get(i).valor + "... ");
        }
    }

    private void baraja() {
        Collections.shuffle(Carta.cartas);
    }

    private void juego(int noTiros) {
        int contador = 0;
        while (noTiros != contador) {
            tirada();
            grupoElegido();
            System.out.println("La nueva baraja queda asi: ");
            imprime();
            System.out.println("\n");
            contador++;
        }
        resultado();
    }

    private void tirada() {
        Carta.grupo1.clear();
        Carta.grupo2.clear();
        Carta.grupo3.clear();
        int contador = 0;
        for (int i = 0; i < Carta.cartas.size() / 3; i++) {
            Carta.grupo1.add(Carta.cartas.get(contador));
            Carta.grupo2.add(Carta.cartas.get(contador + 1));
            Carta.grupo3.add(Carta.cartas.get(contador + 2));
            contador++;
            contador++;
            contador++;
        }
        System.out.println("Grupo 1: ");
        imprimeGrupo1();
        System.out.println("Grupo 2: ");
        imprimeGrupo2();
        System.out.println("Grupo 3: ");
        imprimeGrupo3();
    }

    private void reordenamiento(int no) {
        switch (no) {
            case 1:
                Carta.cartas.clear();
                for (int i = 0; i < Carta.grupo2.size(); i++) {
                    Carta.cartas.add(Carta.grupo2.get(i));
                }
                for (int i = 0; i < Carta.grupo1.size(); i++) {
                    Carta.cartas.add(Carta.grupo1.get(i));
                }
                for (int i = 0; i < Carta.grupo3.size(); i++) {
                    Carta.cartas.add(Carta.grupo3.get(i));
                }
                break;
            case 2:
                Carta.cartas.clear();
                for (int i = 0; i < Carta.grupo1.size(); i++) {
                    Carta.cartas.add(Carta.grupo1.get(i));
                }
                for (int i = 0; i < Carta.grupo2.size(); i++) {
                    Carta.cartas.add(Carta.grupo2.get(i));
                }
                for (int i = 0; i < Carta.grupo3.size(); i++) {
                    Carta.cartas.add(Carta.grupo3.get(i));
                }
                break;
            case 3:
                Carta.cartas.clear();
                for (int i = 0; i < Carta.grupo1.size(); i++) {
                    Carta.cartas.add(Carta.grupo1.get(i));
                }
                for (int i = 0; i < Carta.grupo3.size(); i++) {
                    Carta.cartas.add(Carta.grupo3.get(i));
                }
                for (int i = 0; i < Carta.grupo2.size(); i++) {
                    Carta.cartas.add(Carta.grupo2.get(i));
                }
                break;
            default:
                System.out.println("sucedio un error inesperado, aiuuuuuda D:");
        }
    }
    
    private void resultado(){
        int posicion= ((cant+1)/2)-1;
        System.out.println("----------------------------------------------------------------------");
        System.out.println("El numero que usted penso es: "+ Carta.cartas.get(posicion).valor);
        System.out.println("----------------------------------------------------------------------");
    }

    private void grupoElegido() {
        System.out.println("En que Grupo se encuentra la carta que penso?");
        int elecc = instruccion.nextInt();
        if ((elecc == 3) || (elecc == 2) || (elecc == 1)) {
            reordenamiento(elecc);
        } else {
            System.out.println("Porfavor elija un grupo valido");
            grupoElegido();
        }
    }

    private void imprimeGrupo1() {
        for (int i = 0; i < Carta.grupo1.size(); i++) {
            System.out.println(Carta.grupo1.get(i).valor + "... ");
        }
        System.out.println("\n");
    }

    private void imprimeGrupo2() {
        for (int i = 0; i < Carta.grupo2.size(); i++) {
            System.out.println(Carta.grupo2.get(i).valor + "... ");
        }
        System.out.println("\n");
    }

    private void imprimeGrupo3() {
        for (int i = 0; i < Carta.grupo3.size(); i++) {
            System.out.println(Carta.grupo3.get(i).valor + "... ");
        }
        System.out.println("\n");
    }
}
