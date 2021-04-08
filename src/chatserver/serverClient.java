
package chatserver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.ResultSet;
import java.util.Vector;


public class serverClient extends Thread {

    Socket socket;
    DataInputStream inIp, inMsg;
    DataOutputStream outMsg;
    Vector<Socket> lesSocket;

    serverClient(Socket socket,Vector<Socket> lesSocket) {

        this.socket = socket;
        this.lesSocket = lesSocket;

    }

    public String getIp(String nam) {
        String ipr = null;
        int port;
        try {

            ResultSet t = Connect.Selection("select * from amies where name ='" + nam + "'");
            while (t.next()) {

                ipr = t.getString("ip");
                port = t.getInt("port");

            }
        } catch (Exception e) {

        }

        return ipr;
    }

    public int getPort(String nam) {

        int port = 0;
        try {

            ResultSet t = Connect.Selection("select * from amies where name ='" + nam + "'");
            while (t.next()) {

                port = t.getInt("port");

            }
        } catch (Exception e) {
            System.out.println("error catch getPort");
        }

        return port;
    }

    public void recevoirMsg(String ip, int por, String msg) throws IOException {
            
        try {
            System.out.println("sendiiiing.............");

            
             //socket = new Socket(ip, por);
             for(int i=0;i<lesSocket.size();i++){
                 if(lesSocket.elementAt(i).getPort() == por){


                outMsg = new DataOutputStream(lesSocket.elementAt(i).getOutputStream());
                outMsg.writeUTF(msg);
                System.out.println("after sendiiiing.............");
                 }

                 else{
                     System.out.println("dans else de serverClient");break;
                 }
             }

        } catch (IOException e) {

        }

    }

    @Override

    public void run() {
        try {
            String sms;
            inIp = new DataInputStream(socket.getInputStream());
            String name = inIp.readUTF();
            //System.out.println("voila ip : "+getIp(name)); 
            System.out.println("name is : " + name);
            inMsg = new DataInputStream(socket.getInputStream());
            sms = inMsg.readUTF();
            while(true){

            String q = getIp(name);
            int p = getPort(name);
            System.out.println("voila ip destinataire " + q + "et le port : " + p);

            if (!sms.equals("")) {

                System.out.println(" voila le msg : " + sms);

                recevoirMsg(q, p, name+" : "+sms);

            }
        }

        } catch (Exception e) {

        }

    }

}
