/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.vilae_saquicelaj_sh;

import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jonna
 */
public class IslaNaufragos {

    private int numNaufragos;
    private boolean ocupado = false;
    private Isla principal; //Formulario principal del programa

    public IslaNaufragos(Isla principal, int numNaufragos) {
        this.principal = principal;
        this.numNaufragos = numNaufragos;
    }

    public synchronized void desenbarcoUno(int limite, int tiempo) {
        if ((ocupado == false)) {
            try {
                System.out.println("Capacidad del barco 1: " + limite);
                numNaufragos -= limite;
                
                if (numNaufragos <= 0) {
                    numNaufragos = 0;
                    principal.sinNaufragos();
                    return;
                }

                principal.llegarIsla(1,limite);
                ocupado = true;
                System.out.println("1) Se notificará que ocupado = " + ocupado);
                notifyAll();

                Thread.sleep(tiempo);
                ocupado = false;
                System.out.println("1)  Se notificará que ocupado = " + ocupado);
                notifyAll();

            } catch (InterruptedException ex) {
                Logger.getLogger(IslaNaufragos.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            try {
                //Hay un barco en el puerto
                System.out.println("\n    ** Barco Uno esperando");
                principal.espera(1);
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(IslaNaufragos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public synchronized void desenbarcoDos(int limite, int tiempo) {
        if ((ocupado == false)) {
            try {
                System.out.println("Capacidad del barco 2: " + limite);
                numNaufragos -= limite;
                if (numNaufragos <= 0) {
                    numNaufragos = 0;
                    principal.sinNaufragos();
                    return;
                }
                

                principal.llegarIsla(2,limite);
                ocupado = true;
                System.out.println("2) Se notificará que ocupado = " + ocupado);
                notifyAll();

                Thread.sleep(tiempo);
                ocupado = false;
                System.out.println("2)  Se notificará que ocupado = " + ocupado);
                notifyAll();

            } catch (InterruptedException ex) {
                Logger.getLogger(IslaNaufragos.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {

            try {
                //Hay un barco en el puerto
                System.out.println("\n    -- Barco Dos esperando");
                principal.espera(2);
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(IslaNaufragos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public synchronized void desenbarcoTres(int limite, int tiempo) {
        if ((ocupado == false)) {
            try {
                System.out.println("Capacidad del barco 3: " + limite);
                numNaufragos -= limite;
                if (numNaufragos <= 0) {
                    numNaufragos = 0;
                    principal.sinNaufragos();
                    return;
                }                

                principal.llegarIsla(3,limite);
                ocupado = true;
                System.out.println("3) Se notificará que ocupado = " + ocupado);
                notifyAll();

                Thread.sleep(tiempo);
                ocupado = false;
                System.out.println("3)  Se notificará que ocupado = " + ocupado);
                notifyAll();

            } catch (InterruptedException ex) {
                Logger.getLogger(IslaNaufragos.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            try {
                //Hay un barco en el puerto
                System.out.println("\n    ++ Barco Tres esperando");
                principal.espera(3);
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(IslaNaufragos.class.getName()).log(Level.SEVERE, null, ex);
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
