/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatserver;

import chatproject.donnees;
import java.awt.HeadlessException;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class ChatServer {

    Socket socket;
    DataInputStream key;
    Vector<Socket> lesSocket=new Vector<Socket>();

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    
    //public chatServer(){}
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        new ChatServer().runServer();
    }

    public void runServer() throws IOException {
        ServerSocket serversocket = new ServerSocket(donnees.getPort());
        System.out.println("Server already  conncted....");

        while (true) {
            socket = serversocket.accept();
            lesSocket.add(socket);
           
        
        
        try {
                
                

                key = new DataInputStream(socket.getInputStream());
                int cle = key.readInt();

                switch (cle) {
                    case 1: {
                        System.out.println("dans server login");
                        new serverLogin(socket).start();
                        break;
                    }
                    case 2: {
                        System.out.println("dans server add client");
                        new serverAddClient(socket).start();
                        break;
                    }

                    case 3: {

                        System.out.println("dans server liste connected");
                        new serverConnected(socket).start();
                        break;
                    }
                    
                    case 4 : {
                        System.out.println("Dans deconnecter..");
                        new serverDec(socket).start();break;
                    }
                    
                    case 5 : {
                        System.out.println("Dans clientt..");
                        new serverClient(socket,lesSocket).start();break;
                    }
                    
                    

                    default: {
                        JOptionPane.showMessageDialog(null, "dans Default...");
                        break;
                    }

                }

            } catch (HeadlessException | IOException e) {

                System.err.println("Chat Server : " + e.getMessage());

            }

                
        }

    }

}
