/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clientechat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author capea
 */
public class HiloRecibirMensaje extends Thread{
    private Cliente ventanaCliente;
    private Socket cliente;
    private DataInputStream input;
    

    public HiloRecibirMensaje(Cliente ventanaCliente, DataInputStream inputStream) {
        this.ventanaCliente = ventanaCliente;
        this.cliente = ventanaCliente.getCliente();
        this.input = inputStream;
    }

    @Override
    public void run() {
        while(cliente.isClosed()==false){
        recibirMsg();}
    }
    
    private void recibirMsg(){
        try {
            String msg = input.readUTF();
            ventanaCliente.getTxtChat().setText(ventanaCliente.getTxtChat().getText()+"\n"+msg);
        } catch (IOException ex) {
            
        }
        
    };
    
}
