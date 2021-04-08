/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatserver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 *
 * @author HP
 */
public class serverDec extends Thread {

    Socket socket;
    DataOutputStream rep;
    DataInputStream ip;

    serverDec(Socket socket) {
        this.socket = socket;

    }

    @Override
    public void run() {
        try{
            ip = new DataInputStream(socket.getInputStream());
            rep = new DataOutputStream(socket.getOutputStream());
            String ipp = ip.readUTF();
            int repp;
            if(true){
                     String req = "delete from amies where ip = '" + ipp + "'";
                int l = Connect.mis_a_jours(req);
                if (l != 0) {
                    repp = 2;
                    rep.writeInt(repp);
                }
        }
        
        }catch(Exception e){}

    }

}
