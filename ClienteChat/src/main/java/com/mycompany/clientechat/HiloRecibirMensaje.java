/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clientechat;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dam
 */
public class HiloRecibirMensaje extends Thread{
    private Socket cliente;

    public HiloRecibirMensaje(Socket cliente) {
        this.cliente = cliente;
    }

    @Override
    public void run() {
        while(true){
        try {
            DataInputStream input = new DataInputStream(cliente.getInputStream());
            System.out.println(input.readUTF());
            
        } catch (IOException ex) {
            Logger.getLogger(HiloRecibirMensaje.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        
            
        
        
        
        
    }
    
    
    
}
