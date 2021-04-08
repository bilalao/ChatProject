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

/**
 *
 * @author HP
 */
public class serverAddClient extends Thread {

    Socket socket;
    DataInputStream ip, nom, prenom, passwordd, useradd;
    DataOutputStream repond, repondInt;

    serverAddClient(Socket socket) {

        this.socket = socket;
    }

    public void AddClient(int idc, String nomm, String prenoom, String useer, String passwoord) {

        int rep;
        boolean repp;

        try {

            repondInt = new DataOutputStream(socket.getOutputStream());
            repond = new DataOutputStream(socket.getOutputStream());

            ResultSet rs = Connect.Selection("select username from inscri where username = '" + useer + "'");
            if (rs.next()) {
                repp = true;
                repond.writeBoolean(repp);
            } else {
                int p = Connect.mis_a_jours("insert into inscri (id_c,nom,prenom,username,password) values ('" + idc + "','" + nomm + "','" + prenoom + "','" + useer + "','" + passwoord + "')");

                if (p != 0) {
                    System.out.println("add succccc");
                    repp = false;
                    rep = 1;
                    repond.writeBoolean(repp);
                    repondInt.writeInt(rep);

                } else {
                    System.out.println("echec d'ajouter nouveau client .....");
                }

            }

            socket.close();

        } catch (IOException | SQLException e) {

        }

    }

    @Override
    public void run() {
        String id = "";

        System.out.println("connected.....");

        try {
            ResultSet Pr = Connect.Selection(" SELECT AUTO_INCREMENT FROM information_schema.TABLES WHERE TABLE_SCHEMA = \"heroku_7ed2a2d88d2d065\" AND TABLE_NAME = \"inscri\" ");
            while (Pr.next()) {

                id = "" + Pr.getInt(1);
            }

            // ide = new DataInputStream(socket.getInputStream());
            nom = new DataInputStream(socket.getInputStream());
            prenom = new DataInputStream(socket.getInputStream());
            useradd = new DataInputStream(socket.getInputStream());
            passwordd = new DataInputStream(socket.getInputStream());

            // int idd = ide.readInt();
            int idd = Integer.parseInt(id);
            String noo = nom.readUTF();
            String pree = prenom.readUTF();
            String uss = useradd.readUTF();
            String passd = passwordd.readUTF();

            AddClient(idd, noo, pree, uss, passd);
            //  (int idc,String nomm,String prenoom,String useer,String passwoord)

        } catch (IOException | NumberFormatException | SQLException e) {

            System.err.println("server add client : " + e.getMessage());
        }

    }
}
