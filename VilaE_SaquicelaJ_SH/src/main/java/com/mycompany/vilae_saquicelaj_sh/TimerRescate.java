package com.mycompany.vilae_saquicelaj_sh;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Kristina
 */
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class TimerRescate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
      //  System.out.print("Ingresa el valor de inicio del temporizador en segundos: ");
        //int tiempoInicial = scanner.nextInt();
        
        // Crear un objeto Timer
        Timer timer = new Timer();
        
        // Crear una tarea TimerTask
        TimerTask tarea = new TimerTask() {
            int contador = tiempoInicial;
            
            public void run() {
                if (contador >= 0) {
                    System.out.println("Cuenta regresiva: " + contador);
                    contador--;
                } else {
                    System.out.println("¡Tiempo agotado!");
                    timer.cancel(); // Detener el temporizador
                }
            }
        };
        
        // Programar la tarea para que se ejecute cada segundo (1000 ms)
        timer.scheduleAtFixedRate(tarea, 0, 1000);
    }
}




import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TemporizadorPanel extends JPanel {
    private JLabel labelTiempo;

       private int tiempoInicial; private Timer timer;
    
    public TemporizadorPanel(int tiempoInicial) {
        this.tiempoInicial = tiempoInicial;
        
        labelTiempo = new JLabel(String.valueOf(tiempoInicial), SwingConstants.CENTER);
        labelTiempo.setFont(new Font("Arial", Font.BOLD, 24));
        
        setLayout(new BorderLayout());
        add(labelTiempo, BorderLayout.CENTER);
        
        timer = new Timer(1000, new ActionListener() {
            int contador = tiempoInicial;
            
            public void actionPerformed(ActionEvent e) {
                if (contador >= 0) {
                    labelTiempo.setText(String.valueOf(contador));
                    contador--;
                } else {
                    labelTiempo.setText("¡Tiempo agotado!");
                    timer.stop();
                }
            }
        });
//    }
//    
//    public void iniciarTemporizador() {
//        timer.start();
//    }
//    
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> {
//            JFrame frame = new JFrame("Temporizador");
//            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            
//            TemporizadorPanel panel = new TemporizadorPanel(10); // Inicia con 10 segundos
//            
//            JButton btnIniciar = new JButton("Iniciar");
//            btnIniciar.addActionListener(e -> panel.iniciarTemporizador());
//            
//            frame.getContentPane().add(panel, BorderLayout.CENTER);
//            frame.getContentPane().add(btnIniciar, BorderLayout.SOUTH);
//            
//            frame.pack();
//            frame.setVisible(true);
//        });
//    }
//}
