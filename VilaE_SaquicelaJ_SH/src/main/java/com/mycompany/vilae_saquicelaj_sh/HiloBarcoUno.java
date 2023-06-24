/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.vilae_saquicelaj_sh;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jonna
 */
public class HiloBarcoUno extends Thread {

    Naufragos isla;
    int capacidadMaxima;
    int tiempo;

    public HiloBarcoUno(Naufragos isla, int capacidadMaxima, int tiempo) {
        this.isla = isla;
        this.capacidadMaxima = capacidadMaxima;
        this.tiempo = tiempo;
    }

    @Override
    public void run() {
        int empezar;
        int capacidad;
        while (isla.getPrincipal().pause == false) {
            capacidad = (int) (Math.random() * capacidadMaxima);
            empezar = (int) ((Math.random() * 50) + 1);
            try {
                //System.out.println("    +El barco 1 empezara en: " + empezar);
                HiloBarcoUno.sleep(empezar);
                isla.desenbarcoUno(capacidad, (tiempo * 1000));

            } catch (InterruptedException ex) {
                Logger.getLogger(HiloBarcoUno.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
