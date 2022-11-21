/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.servidorchat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author capea
 */
public class HiloServidor extends Thread{
    private Socket cliente;
    private static List<Socket> listaClientes = new ArrayList<>();
    private DataInputStream input;
    private DataOutputStream output;
    private boolean continuar;
    

    public HiloServidor(Socket cliente) {
        continuar =true;
        this.cliente = cliente;
        listaClientes.add(cliente);
        try {
            this.input = new DataInputStream(cliente.getInputStream());
            this.output = new DataOutputStream(cliente.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(HiloServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void run() {
        while (continuar) {            
            recibirMensaje();
        }
        
        try {
            cliente.close();
            input.close();
            output.close();
        } catch (IOException ex) {
            Logger.getLogger(HiloServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void recibirMensaje(){
        try {
            String inputMSG = this.input.readUTF();
            
            if (inputMSG.contains("-exit")) {
                continuar=false;
                System.out.println("Un cliente salió");
                
                inputMSG = inputMSG.replace("-exit", "");
                
                inputMSG = inputMSG +" salió de la sala";
                
                output.close();
                input.close();
                cliente.close();
            }
            
            for (Socket c : listaClientes) {
                if (c.isClosed()) {
                    
                } else {
                    DataOutputStream out = new DataOutputStream(c.getOutputStream());
                    out.writeUTF(inputMSG);
                }
                
                
                    
            }
            
        } catch (IOException ex) {
            Logger.getLogger(HiloServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    
    
    
}
