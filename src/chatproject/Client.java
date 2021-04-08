/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatproject;

import java.awt.event.KeyEvent;
import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class Client extends javax.swing.JFrame{

    /**
     * Creates new form Client
     */
    static Socket s;
    static DataInputStream in, inn, inMsg;
    static DataOutputStream out, nam, cle, outMsg;
    Thread cl = null;

    public Client() {
        initComponents();

        setLocationRelativeTo(null);

    }

    public Client(String name) throws IOException {

        initComponents();
        setTitle(name);
        //s = new Socket(donnees.getIp_Server(), donnees.getPort());
        // inMsg = new DataInputStream(s.getInputStream());
        // cl = new Thread(this);
        // cl.start();

        this.setIconImage(new ImageIcon(getClass().getResource("status_icon_connected.png")).getImage());
        setLocationRelativeTo(null);
        setVisible(true);

    }

    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        view_msg = new javax.swing.JTextArea();
        send_msg = new javax.swing.JTextField();
        btn_send = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Client");
        setBackground(new java.awt.Color(102, 153, 255));
        setMaximumSize(new java.awt.Dimension(500, 400));
        setMinimumSize(new java.awt.Dimension(500, 400));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        view_msg.setColumns(20);
        view_msg.setRows(5);
        view_msg.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        view_msg.setFocusable(false);
        jScrollPane1.setViewportView(view_msg);

        send_msg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                send_msgKeyPressed(evt);
            }
        });

        btn_send.setText("Envoyer");
        btn_send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sendActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(send_msg, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_send))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(send_msg, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_send, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void btn_sendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sendActionPerformed

        try {

            s = new Socket(donnees.getIp_Server(), donnees.getPort());
            cle = new DataOutputStream(s.getOutputStream());
            nam = new DataOutputStream(s.getOutputStream());
            outMsg = new DataOutputStream(s.getOutputStream());

            while (true) {

                int key = 5;
                String nammeeeee = this.getTitle();
                String msg = send_msg.getText();

                cle.writeInt(key);

                if (!msg.equals("")) {
                    nam.writeUTF(nammeeeee);
                    outMsg.writeUTF(msg);
                    

                    view_msg.append( send_msg.getText()+"\n");

                    send_msg.setText("");

                }
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Client ERROR" + e.getMessage());

        }
    }//GEN-LAST:event_btn_sendActionPerformed

    private void send_msgKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_send_msgKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            
             try {

            s = new Socket(donnees.getIp_Server(), donnees.getPort());
            cle = new DataOutputStream(s.getOutputStream());
            nam = new DataOutputStream(s.getOutputStream());
            outMsg = new DataOutputStream(s.getOutputStream());

            while(true) {

                int key = 5;
                String nammeeeee = this.getTitle();
                String msg = send_msg.getText();

                cle.writeInt(key);

                if (!msg.equals("")) {
                    nam.writeUTF(nammeeeee);
                    outMsg.writeUTF(msg);

                    view_msg.append(send_msg.getText()+"\n");

                    send_msg.setText("");

                }
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Client ERROR" + e.getMessage());

        }

        }

    }//GEN-LAST:event_send_msgKeyPressed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Client().setVisible(true);
        });
        
        
        

      /*  try {

            s = new Socket(donnees.getIp_Server(), donnees.getPort());
            inMsg = new DataInputStream(s.getInputStream());
            while (true) {
                String sms = inMsg.readUTF();
                if (!sms.equals("")) {
                    view_msg.append("\n\n hahowa jaaa : "+sms);

                }
                s.close();
            }
            

        } catch (Exception e) {
        }*/

        //  public void ref()
        
         new Thread(new Runnable(){
        
            @Override
            public void run(){
               // InetAddress localHost;          
                
            try {
                //localHost = InetAddress.getLocalHost();
                //String ipc = localHost.getHostAddress();
                
            
           
            while (true) {
                inMsg = new DataInputStream(s.getInputStream());
                String sms = inMsg.readUTF();
                while (!sms.equals("")) {
                    view_msg.append(" hahowa jaaa : "+sms);

                }

            }    
        } catch (IOException e) {
        } 
            }
             
        }).start();
        
    }
    
    
        
        
    
    
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_send;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField send_msg;
    private static javax.swing.JTextArea view_msg;
    // End of variables declaration//GEN-END:variables
}