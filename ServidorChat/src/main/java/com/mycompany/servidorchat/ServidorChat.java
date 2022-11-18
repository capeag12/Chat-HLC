/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.servidorchat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dam
 */
public class ServidorChat {

    public static void main(String[] args) {
        ArrayList<Socket> clientes = new ArrayList<>();
        System.out.println("Se abrió el servidor");
        try {
            ServerSocket servidorChat = new ServerSocket(5600);
            while(true){
                Socket cliente = servidorChat.accept();
                System.out.println("Se conectó un cliente");
                clientes.add(cliente);
                HiloServidor hilo = new HiloServidor(clientes);
                hilo.start();
                
            }          
        } catch (IOException ex) {
            Logger.getLogger(ServidorChat.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
