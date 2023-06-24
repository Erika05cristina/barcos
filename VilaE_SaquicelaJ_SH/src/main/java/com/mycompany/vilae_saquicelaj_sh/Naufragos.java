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

    private HiloBarcoUno hb1;
    private HiloBarcoDos hb2;
    private HiloBarcoTres hb3;
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
            //notificar();
            //ocupado = false;

        } catch (InterruptedException ex) {
            Logger.getLogger(Naufragos.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Se notificará");
        //notifyAll();
    }

    public synchronized void desenbarcoUno(int limite, int tiempo) {
        System.out.println("Barco uno, atributo ocupado: " + ocupado);

        if (ocupado) {
            System.out.println("Va a espererar el barco 1");
            try {
                //Hay un barco en el puerto
                System.out.println("\n    ** Barco Uno esperando");
                principal.espera(1);
                ocupado = false;
                System.out.println("atributo ocupado: " + ocupado);
                wait();

            } catch (InterruptedException ex) {
                Logger.getLogger(Naufragos.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            ocupado = true;
            System.out.println("Llego el barco 1");
            moverBarco(1, tiempo, limite);

        }

    }

    public synchronized void desenbarcoDos(int limite, int tiempo) {
        System.out.println("Barco dos, atributo ocupado: " + ocupado);
        if (ocupado) {
            try {
                //Hay un barco en el puerto
                System.out.println("\n    -- Barco Dos esperando");
                principal.espera(2);

                ocupado = false;
                System.out.println("atributo ocupado: " + ocupado);
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Naufragos.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            ocupado = true;
            System.out.println("Llego el barco 2");
            moverBarco(2, tiempo, limite);

        }

    }

    public synchronized void desenbarcoTres(int limite, int tiempo) {
        System.out.println("Barco tres, atributo ocupado: " + ocupado);
        if (ocupado) {
            try {
                //Hay un barco en el puerto
                System.out.println("\n    ++ Barco Tres esperando");
                principal.espera(3);

                ocupado = false;
                System.out.println("atributo ocupado: " + ocupado);
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Naufragos.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            ocupado = true;
            System.out.println("Llego el barco 3");
            moverBarco(3, tiempo, limite);
        }

    }

    public synchronized void notificar() {
        notifyAll();
        System.out.println("Se notificó");
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

    public HiloBarcoUno getHb1() {
        return hb1;
    }

    public void setHb1(HiloBarcoUno hb1) {
        this.hb1 = hb1;
    }

    public HiloBarcoDos getHb2() {
        return hb2;
    }

    public void setHb2(HiloBarcoDos hb2) {
        this.hb2 = hb2;
    }

    public HiloBarcoTres getHb3() {
        return hb3;
    }

    public void setHb3(HiloBarcoTres hb3) {
        this.hb3 = hb3;
    }

}
