/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author capea
 */
public class ServidorChat {
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            ServerSocket servidor = new ServerSocket(6500);
            System.out.println("Se inició el programa");
            while(true){
            Socket cliente = servidor.accept();
            
            System.out.println("Se conectó un cliente");
            HiloServidor hilo = new HiloServidor(cliente);
            hilo.start();
            
            }
        } catch (IOException ex) {
            Logger.getLogger(ServidorChat.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
