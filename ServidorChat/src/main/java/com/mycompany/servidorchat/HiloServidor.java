/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.servidorchat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dam
 */
public class HiloServidor extends Thread{
    private ArrayList<Socket> listaUsuario;
    
    public HiloServidor(ArrayList<Socket> listaUsu) {
        this.listaUsuario=listaUsu;
    }

    @Override
    public void run() {
            while(true){
            recibirDatos();}
            
           
            
        
        
    }
    
    private void recibirDatos(){
        String mensaje = "";
        for (Socket usu : listaUsuario) {
            try {
                DataInputStream reader = new DataInputStream(usu.getInputStream());
                String msg = reader.readUTF();
                System.out.println(msg);
                if (msg.equals("")==false) {
                    mensaje=msg;
                    enviarDatos(mensaje);
                }
                
            } catch (IOException ex) {
                Logger.getLogger(HiloServidor.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
    private void enviarDatos(String mensaje){
        for (Socket usu : listaUsuario) {
            try {
                DataOutputStream writer = new DataOutputStream(usu.getOutputStream());
                writer.writeUTF(mensaje);
                
                
            } catch (IOException ex) {
                Logger.getLogger(HiloServidor.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
}
