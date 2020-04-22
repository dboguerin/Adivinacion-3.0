/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adivinacion.pkg3.pkg0;

import java.util.ArrayList;

/**
 *
 * @author yoyo
 */
public class Carta {
    static ArrayList<Carta> cartas = new ArrayList<Carta>();
    static ArrayList<Carta> grupo1=new ArrayList<Carta>();
    static ArrayList<Carta> grupo2=new ArrayList<Carta>();
    static ArrayList<Carta> grupo3=new ArrayList<Carta>();
    String ruta;
    int valor;

    Carta(int valor) {
        this.valor = valor;
    }
    
}
