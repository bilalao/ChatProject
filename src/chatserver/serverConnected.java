/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatserver;


import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class serverConnected extends Thread {

    Socket socket;
    ObjectOutputStream list;
    DataInputStream ipin;
    

    serverConnected(Socket socket) {

        this.socket = socket;
    }

    @Override
    public void run() {
        ArrayList listo = new ArrayList();
        System.out.println("start listttt.....");
        String ippp = null;

        try {
            ipin = new DataInputStream(socket.getInputStream());
            ippp = ipin.readUTF();
            list = new ObjectOutputStream(socket.getOutputStream());
            
    
            System.out.println("ip client "+ippp);

            ResultSet r = Connect.Selection("select name from amies where ip NOT IN (SELECT ip FROM amies WHERE ip ='"+ippp+"') ");

            while (r.next()) {

                String listr = r.getString("name");
                //  System.out.println(listr);
                listo.add(listr);

            }
            list.writeObject(listo);
            list.flush();
            
            socket.close();

        } catch (IOException | SQLException e) {
            e.getMessage();
        }

    }

}
