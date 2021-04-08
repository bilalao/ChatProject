/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatserver;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;

public class serverLogin extends Thread {

    Socket socket;
    DataInputStream user, password, ip,port;
    DataOutputStream repond, repondInt;

    serverLogin(Socket socket) {
        this.socket = socket;

    }

    public serverLogin() {
    }

    static String name = null;
    static String ipc = null;
    static int portC;
    

    public void ClientLogin(String username, String passwordC) {

        try {

            boolean rep;

            ip = new DataInputStream(socket.getInputStream());
            port = new DataInputStream(socket.getInputStream());
            repond = new DataOutputStream(socket.getOutputStream());

            ipc = ip.readUTF();
            portC = port.readInt();
            

            System.out.println("username " + username + " password " + passwordC + " ip " + ipc+" and port is : "+portC);

            ResultSet rs = Connect.Selection("SELECT * FROM inscri WHERE username = '" + username + "' AND password = '" + passwordC + "'");
            if (rs.next()) {
                name = "" + rs.getString(2) + " " + rs.getString(3);
                
                int l = Connect.mis_a_jours("insert into amies (id,ip,port,name) values ('" + rs.getInt(1) + "','" + ipc + "','" + portC + "','" + name + "')");

                if (l != 0) {
                    System.out.println("avec succccc");

                    rep = true;
                    repond.writeBoolean(rep);
                }

            } else {
                rep = false;
                repond.writeBoolean(rep);
            }
            

        } catch (IOException | SQLException e) {

        }

    }

    @Override
    public void run() {

        System.out.println("connected.....");

        try {
            if(true){
            user = new DataInputStream(socket.getInputStream());
            password = new DataInputStream(socket.getInputStream());

            String us = user.readUTF();
            String pass = password.readUTF();

            ClientLogin(us, pass);
            
            
            socket.close();
            }
           
   
         
        } 
     
        catch (IOException e) {

            System.err.println("server Login : " + e.getMessage());

        }

    }
}
