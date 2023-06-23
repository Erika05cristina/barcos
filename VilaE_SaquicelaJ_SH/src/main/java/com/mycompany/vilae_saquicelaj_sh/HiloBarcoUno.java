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

    IslaNaufragos isla;
    int capacidadMaxima;
    int tiempo;
    

    public HiloBarcoUno(IslaNaufragos isla, int capacidadMaxima, int tiempo) {
        this.isla = isla;
        this.capacidadMaxima = capacidadMaxima;
        this.tiempo = tiempo;
    }

    @Override
    public void run() {        

        while (isla.getPrincipal().pause == false) {
            //tiempo = (Math.random()*(valorMinimo - valorMaximo)+ ValorMaximo);
            int capacidad = (int) (Math.random() * capacidadMaxima);
            try {                
                Thread.sleep(4);
                isla.desenbarcoUno(capacidad, (tiempo*1000));

            } catch (InterruptedException ex) {
                Logger.getLogger(HiloBarcoUno.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
