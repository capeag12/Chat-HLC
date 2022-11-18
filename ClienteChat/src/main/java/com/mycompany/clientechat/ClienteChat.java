/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.clientechat;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dam
 */
public class ClienteChat {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        try {
            Socket cliente = new Socket("localhost", 5600);
            HiloRecibirMensaje hiloRecibir = new HiloRecibirMensaje(cliente);
            hiloRecibir.start();
            while(true){
                
                DataOutputStream output = new DataOutputStream(cliente.getOutputStream());
                System.out.println("Enviar mensage:");
                String mensaje = leer.next();
                output.writeUTF(mensaje);
                
            }
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(ClienteChat.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
