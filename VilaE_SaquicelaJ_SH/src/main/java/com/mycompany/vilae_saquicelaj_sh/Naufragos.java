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
public class Naufragos {

    private int numNaufragos;
    private boolean ocupado = false;
    private Isla principal; //Formulario principal del programa

    private boolean b1 = false;
    private boolean b2 = false;
    private boolean b3 = false;

    public Naufragos(int numNaufragos, Isla principal) {
        this.numNaufragos = numNaufragos;
        this.principal = principal;
    }

    public synchronized void moverBarco(int barco, int tiempo, int limite) {
        try {
            
            if (numNaufragos <= 0) {
                numNaufragos = 0;
                principal.sinNaufragos();
                return;
            }
            principal.tiempoBarco(barco, tiempo);
            numNaufragos -= limite;
            principal.llegarIsla(barco, limite);
            Thread.sleep(tiempo);            
            notifyAll();

        } catch (InterruptedException ex) {
            Logger.getLogger(Naufragos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public synchronized void desenbarcoUno(int limite, int tiempoUno) {

        if (ocupado) {
            try {
                //Hay un barco en el puerto               
                principal.espera(1);
                ocupado = false;
                System.out.println("Barco 1 esperando");
                wait();

            } catch (InterruptedException ex) {
                Logger.getLogger(Naufragos.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            //Evitar de que el barco rescate 2 o más veces seguidas
            if (b1 == false) {
                ocupado = true;
                b1 = true;
                b2 = false;
                b3 = false;
                moverBarco(1, tiempoUno, limite);
            }

        }

    }

    public synchronized void desenbarcoDos(int limite, int tiempoDos) {
        if (ocupado) {
            try {
                //Hay un barco en el puerto                
                principal.espera(2);
                ocupado = false;
                System.out.println("Barco 2 esperando");
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Naufragos.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            //Evitar de que el barco rescate 2 o más veces seguidas
            if (b2 == false) {
                ocupado = true;
                b1 = false;
                b2 = true;
                b3 = false;
                moverBarco(2, tiempoDos, limite);
            }
        }

    }

    public synchronized void desenbarcoTres(int limite, int tiempoTres) {

        if (ocupado) {
            try {
                //Hay un barco en el puerto
                principal.espera(3);
                ocupado = false;
                System.out.println("Barco 3 esperando");
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Naufragos.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            //Evitar de que el barco rescate 2 o más veces seguidas
            if (b3 == false) {
                ocupado = true;
                b1 = false;
                b2 = false;
                b3 = true;
                moverBarco(3, tiempoTres, limite);
            }            
        }

    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public int getNumNaufragos() {
        return numNaufragos;
    }

    public void setNumNaufragos(int numNaufragos) {
        this.numNaufragos = numNaufragos;
    }

    public Isla getPrincipal() {
        return principal;
    }

    public void setPrincipal(Isla principal) {
        this.principal = principal;
    }

}
