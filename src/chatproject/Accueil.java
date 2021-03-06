/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatproject;

import java.io.DataInputStream;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Accueil extends javax.swing.JFrame {

    Socket socket;
    ObjectInputStream list1;

    DataOutputStream cle, ipp;
    DataInputStream rep;
    ArrayList repp = new ArrayList();

    /**
     * Creates new form Accueil
     */
    public Accueil() {
        initComponents();

        table();
        time();

    }

    public void table() {

        try {
            InetAddress localHost = InetAddress.getLocalHost();
             String ipc = localHost.getHostAddress();

            socket = new Socket(donnees.getIp_Server(), donnees.getPort());

            try {
                //  socket = new Socket(donnees.getIp_Server(),donnees.getPort());

                cle = new DataOutputStream(socket.getOutputStream());
                ipp = new DataOutputStream(socket.getOutputStream()); 

                int key = 3;
                if (true) {

                    cle.writeInt(key);
                    ipp.writeUTF(ipc);

                }

            } catch (IOException e) {

            }
            DefaultListModel list = new DefaultListModel();

            list1 = new ObjectInputStream(socket.getInputStream());

            if (true) {

                Object lis = list1.readObject();

                repp = (ArrayList) lis;
                for (Object arr : repp) {
                    list.addElement(arr.toString());
                    

                }

                jList2.setModel(list);

            }

        } catch (IOException | ClassNotFoundException e) {

        }

    }

    public void time() {
        new Thread() {
            @Override
            public void run() {
                for (;;) {
                    Calendar cal = new GregorianCalendar();
                    int hh = cal.get(Calendar.HOUR_OF_DAY);
                    int mm = cal.get(Calendar.MINUTE);
                    int ss = cal.get(Calendar.SECOND);
                    int jj = cal.get(Calendar.DAY_OF_MONTH);
                    int MM = cal.get(Calendar.MONTH);
                    int AA = cal.get(Calendar.YEAR);

                    if (hh < 10) {
                        if (mm < 10) {
                            if (ss < 10) {
                                clock.setText("0" + hh + " : 0" + mm + " : 0" + ss);
                            } else {
                                clock.setText("0" + hh + " : 0" + mm + " : " + ss);
                            }

                        } else {

                            if (ss < 10) {
                                clock.setText("0" + hh + " : " + mm + " : 0" + ss);
                            } else {
                                clock.setText("0" + hh + " : " + mm + " : " + ss);
                            }

                        }

                    } else {
                        if (mm < 10) {
                            if (ss < 10) {
                                clock.setText("" + hh + " : 0" + mm + " : 0" + ss);
                            } else {
                                clock.setText("" + hh + " : 0" + mm + " : " + ss);
                            }

                        } else {

                            if (ss < 10) {
                                clock.setText("" + hh + " : " + mm + " : 0" + ss);
                            } else {
                                clock.setText("" + hh + " : " + mm + " : " + ss);
                            }

                        }
                    }
                    

                    if (jj < 10) {
                        if (MM < 10) {
                            date.setText("0" + jj + " / 0" + MM + " / " + AA);

                        } else {
                            date.setText("0" + jj + " / " + MM + " / " + AA);
                        }

                    } else {
                        if (MM < 10) {
                            date.setText("" + jj + " / 0" + MM + " / " + AA);

                        } else {
                            date.setText("" + jj + " / " + MM + " / " + AA);
                        }

                    }
                    
               }

            }

        }.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        clock = new javax.swing.JLabel();
        date = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Accueil");
        setLocation(new java.awt.Point(200, 200));
        setMinimumSize(new java.awt.Dimension(600, 500));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "les amies connect", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(26, 255, 0))); // NOI18N

        jList2.setOpaque(false);
        jList2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList2MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jList2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jButton1.setText("Actualiser");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Deconnecte");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        clock.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        clock.setForeground(new java.awt.Color(51, 255, 133));

        date.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        date.setForeground(new java.awt.Color(51, 255, 231));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(43, 43, 43)
                        .addComponent(jButton2))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62)
                .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(clock, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(clock, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(195, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        table();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened


    }//GEN-LAST:event_formWindowOpened

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int op = (int) JOptionPane.showConfirmDialog(null, "are u sure", "by by", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (op == JOptionPane.YES_OPTION) {
            InetAddress localHost;
            LoginFoorm ll = new LoginFoorm();
            try {
                socket = new Socket(donnees.getIp_Server(), donnees.getPort());
                ipp = new DataOutputStream(socket.getOutputStream());
                cle = new DataOutputStream(socket.getOutputStream());
                rep = new DataInputStream(socket.getInputStream());

                localHost = InetAddress.getLocalHost();
                String ip = localHost.getHostAddress();

                int key = 4;
                if(true) {
                    cle.writeInt(key);
                    ipp.writeUTF(ip);
                    int ree = rep.readInt();

                    if (ree == 2) {
                        System.out.println("mis a jours avec succes");
                        ll.setVisible(true);
                        this.setVisible(false);
                    }
                    
                    rep.close();
                cle.close();
                ipp.close();
                socket.close();
                }
                
               

            } catch (IOException e) {

            }

        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jList2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList2MouseClicked
        // TODO add your handling code here:
        int[] selected = jList2.getSelectedIndices();

        for (int l = 0; l < selected.length; l++) {
            try {
                String cli = (String) jList2.getModel().getElementAt(selected[l]);
                
                Client nn = new Client(cli);
            } catch (IOException ex) {
                Logger.getLogger(Accueil.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }//GEN-LAST:event_jList2MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Accueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Accueil().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel clock;
    private javax.swing.JLabel date;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    public static javax.swing.JList<String> jList2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables

}
