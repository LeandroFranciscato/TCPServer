package org.linepack.tcpserver;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JOptionPane;

public class TCPServer {

    public static void main(String[] args) {
        try {
            ServerSocket servidor = new ServerSocket(12345);
            while (true) {
                Socket cliente = servidor.accept();
                
                ObjectOutputStream out = new ObjectOutputStream(cliente.getOutputStream());
                out.flush();
                out.writeObject("1");
                out.close();
                
                cliente.close();
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao iniciar  TCP Server: " + e.toString());
            System.exit(0);
        }
    }
}
