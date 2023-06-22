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
    private Isla principal;

    public IslaNaufragos(Isla principal, int numNaufragos) {
        this.principal = principal;
        this.numNaufragos = numNaufragos;
    }
    
    
    public synchronized void notificar(){
        notifyAll();
    }
    public synchronized void desenbarcoUno(int limite){        
        if( (ocupado == false)){
            if (limite < numNaufragos) {
                System.out.println("Capacidad del barco 1: " + limite);
                numNaufragos -= limite;
                principal.llegarIsla(1);
                ocupado = true;                
                notifyAll();
                
            }
                        
        }else{
            try {
                //Hay un barco en el puerto
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(IslaNaufragos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public synchronized void desenbarcoDos(int limite){        
        if( (ocupado == false)){
            if (limite < numNaufragos) {
                System.out.println("Capacidad del barco 2: " + limite);
                numNaufragos -= limite;
                principal.llegarIsla(2);
                ocupado = true;
                notifyAll();                
            }
                        
        }else{
            try {
                //Hay un barco en el puerto
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(IslaNaufragos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public synchronized void desenbarcoTres(int limite){        
        if( (ocupado == false)){
            if (limite < numNaufragos) {
                System.out.println("Capacidad del barco 3: " + limite);
                numNaufragos -= limite;
                principal.llegarIsla(3);
                ocupado = true;
                notifyAll();                
            }
                        
        }else{
            try {
                //Hay un barco en el puerto
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
    
    
    
}
