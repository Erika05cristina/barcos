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
public class HiloBarcoDos extends Thread{
    IslaNaufragos isla;
    int capacidadMaxima;

    public HiloBarcoDos(IslaNaufragos isla, int capacidadMaxima) {
        this.isla = isla;
        this.capacidadMaxima = capacidadMaxima;
    }

    @Override
    public void run() {
        int tiempo = 0;

        while (true) {
            //tiempo = (Math.random()*(valorMinimo - valorMaximo)+ ValorMaximo);
            int capacidad = (int) (Math.random() * (capacidadMaxima - 1) + capacidadMaxima);
            try {                
                Thread.sleep(4);
                isla.desenbarcoDos(capacidad);

            } catch (InterruptedException ex) {
                Logger.getLogger(HiloBarcoUno.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
