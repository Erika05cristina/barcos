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

    public Naufragos(int numNaufragos, Isla principal) {
        this.numNaufragos = numNaufragos;
        this.principal = principal;
    }

    public synchronized void moverBarco(int barco, int tiempo, int limite) {
        try {
            principal.tiempoBarco(barco, tiempo);
            if (numNaufragos <= 0) {
                numNaufragos = 0;
                principal.sinNaufragos();
                return;
            }
            numNaufragos -= limite;
            principal.llegarIsla(barco, limite);
            Thread.sleep(tiempo);
            System.out.println("Se notificará");
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
                wait();

            } catch (InterruptedException ex) {
                Logger.getLogger(Naufragos.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            ocupado = true;
            moverBarco(1, tiempoUno, limite);

        }

    }

    public synchronized void desenbarcoDos(int limite, int tiempoDos) {
        if (ocupado) {
            try {
                //Hay un barco en el puerto                
                principal.espera(2);
                ocupado = false;
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Naufragos.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            ocupado = true;

            moverBarco(2, tiempoDos, limite);

        }

    }

    public synchronized void desenbarcoTres(int limite, int tiempoTres) {

        if (ocupado) {
            try {
                //Hay un barco en el puerto
                principal.espera(3);
                ocupado = false;
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Naufragos.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            ocupado = true;

            moverBarco(3, tiempoTres, limite);
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
