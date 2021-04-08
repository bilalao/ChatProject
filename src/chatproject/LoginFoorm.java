package chatproject;

import static chatproject.Client.s;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import javax.swing.JFrame;
import javax.swing.JOptionPane;



public class LoginFoorm extends javax.swing.JFrame{

   
   Socket socket;
   static DataOutputStream pass,user,ipC,cle,port;
   static DataInputStream repond;
   
    
    
    public LoginFoorm() {
        initComponents();
        
        this.setLocationRelativeTo(null);
        etoi.setVisible(false);
        etoil.setVisible(false);
    }
   
        
   

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelClose = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabelMin = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        pseudo = new javax.swing.JTextField();
        passw = new javax.swing.JPasswordField();
        cancel = new javax.swing.JButton();
        conncter = new javax.swing.JButton();
        jLabelRegister = new javax.swing.JLabel();
        etoi = new javax.swing.JLabel();
        etoil = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(31, 58, 147));

        jLabelClose.setFont(new java.awt.Font("Tahoma", 3, 21)); // NOI18N
        jLabelClose.setForeground(new java.awt.Color(240, 240, 240));
        jLabelClose.setText("X");
        jLabelClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelClose.setIconTextGap(7);
        jLabelClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelCloseMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 21)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(240, 240, 240));
        jLabel2.setText("Se Connecter");
        jLabel2.setIconTextGap(7);

        jLabelMin.setFont(new java.awt.Font("Tahoma", 3, 21)); // NOI18N
        jLabelMin.setForeground(new java.awt.Color(240, 240, 240));
        jLabelMin.setText("-");
        jLabelMin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelMin.setIconTextGap(7);
        jLabelMin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelMinMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(jLabelMin, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelClose, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelClose, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMin)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16))
        );

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel4.setText("Mot de passe :");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel5.setText("Pseudo : ");

        pseudo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pseudo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pseudoActionPerformed(evt);
            }
        });

        passw.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        passw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwActionPerformed(evt);
            }
        });
        passw.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwKeyPressed(evt);
            }
        });

        cancel.setBackground(new java.awt.Color(31, 58, 147));
        cancel.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        cancel.setForeground(new java.awt.Color(240, 240, 240));
        cancel.setText("Annuler");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        conncter.setBackground(new java.awt.Color(31, 58, 147));
        conncter.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        conncter.setForeground(new java.awt.Color(240, 240, 240));
        conncter.setText("Se Connecter");
        conncter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conncterActionPerformed(evt);
            }
        });

        jLabelRegister.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabelRegister.setForeground(new java.awt.Color(31, 58, 147));
        jLabelRegister.setText("Créer un nouveau compte");
        jLabelRegister.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelRegister.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelRegisterMouseClicked(evt);
            }
        });

        etoi.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        etoi.setText("*");

        etoil.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        etoil.setText("*");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pseudo, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(passw, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabelRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(conncter)
                            .addGap(17, 17, 17)
                            .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(etoi, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etoil, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(103, 103, 103)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pseudo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etoi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passw, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etoil))
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(conncter, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabelRegister, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void passwActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwActionPerformed

    private void pseudoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pseudoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pseudoActionPerformed

    private void jLabelCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCloseMouseClicked
        
        System.exit(0);
    }//GEN-LAST:event_jLabelCloseMouseClicked

    private void jLabelMinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMinMouseClicked
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jLabelMinMouseClicked

    private void conncterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conncterActionPerformed
      
        if(pseudo.getText().equals(""))
        {
            etoi.setVisible(true);
        }
         
         if(String.valueOf(passw.getPassword()).equals(""))
        {
            etoil.setVisible(true);
        }
          
     else{     InetAddress localHost;
              try{
            
            s = new Socket(donnees.getIp_Server(), donnees.getPort());
            
            cle = new DataOutputStream(s.getOutputStream());
            user = new DataOutputStream(s.getOutputStream());
            pass = new DataOutputStream(s.getOutputStream());
            ipC = new DataOutputStream(s.getOutputStream());
            port = new DataOutputStream(s.getOutputStream());
            
            
            repond = new DataInputStream(s.getInputStream());
            
            
            localHost = InetAddress.getLocalHost();
            
            boolean rep = false;
           
            if(true){
           
            
               String u = pseudo.getText();
               String p = passw.getText();
               String ip = localHost.getHostAddress();
               int por = s.getLocalPort();
               int key = 1;
                
               cle.writeInt(key);
                user.writeUTF(u);
                pass.writeUTF(p);
                ipC.writeUTF(ip);
                port.writeInt(por);
                
                
                if((rep = repond.readBoolean()) == true){
                    Accueil ac = new Accueil();
                    
                    this.setVisible(false);
                    ac.setVisible(true);
                
                
                }
                else{
                    JOptionPane.showMessageDialog(null, "mot de passe ou pseudo et incorrect");
                    passw.setText("");
                    pseudo.setText("");
                    etoi.setVisible(true);
                    etoil.setVisible(true);
                }

              
              }
            
             
           
        }catch(HeadlessException | IOException e){
        
            JOptionPane.showMessageDialog(null,"echec");
            
        
        }
         }
    
    }//GEN-LAST:event_conncterActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
      int op = (int) JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment quitter ? ", "Attention",JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
      if(op == JOptionPane.YES_OPTION){
        System.exit(0);
      }
    }//GEN-LAST:event_cancelActionPerformed

    private void jLabelRegisterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelRegisterMouseClicked
        
        
        
        
        RegisterForm rgf = new RegisterForm();
        rgf.setVisible(true);
        rgf.pack();
        
        this.dispose();
    }//GEN-LAST:event_jLabelRegisterMouseClicked

    private void passwKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
        
            if(pseudo.getText().equals(""))
        {
            etoi.setVisible(true);
        }
         
         if(String.valueOf(passw.getPassword()).equals(""))
        {
            etoil.setVisible(true);
        }
          
     else{     InetAddress localHost;
              try{
            
            s = new Socket(donnees.getIp_Server(), donnees.getPort());
            
            cle = new DataOutputStream(s.getOutputStream());
            user = new DataOutputStream(s.getOutputStream());
            pass = new DataOutputStream(s.getOutputStream());
            ipC = new DataOutputStream(s.getOutputStream());
           port = new DataOutputStream(s.getOutputStream());
            
            
            repond = new DataInputStream(s.getInputStream());
            
            localHost = InetAddress.getLocalHost();
            
            boolean rep = false;
           
            if(true){
           
            
               String u = pseudo.getText();
               String p = passw.getText();
               String ip = localHost.getHostAddress();
               int por = s.getLocalPort();
               int key = 1;
                
               cle.writeInt(key);
                user.writeUTF(u);
                pass.writeUTF(p);
                ipC.writeUTF(ip);
                port.writeInt(por);
                
                
                if((rep = repond.readBoolean()) == true){
                    Accueil ac = new Accueil();
                    
                    this.setVisible(false);
                    ac.setVisible(true);
                
                
                }
                else{
                    JOptionPane.showMessageDialog(null, "mot de passe ou pseudo et incorrect");
                    passw.setText("");
                    pseudo.setText("");
                    etoi.setVisible(true);
                    etoil.setVisible(true);
                }

              }
            
             
           
        }catch(HeadlessException | IOException e){
        
            JOptionPane.showMessageDialog(null,"echec");
            
        
        }
         }
        
        
        }
    }//GEN-LAST:event_passwKeyPressed

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
            java.util.logging.Logger.getLogger(LoginFoorm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
       //</editor-fold>
       //</editor-fold>
       
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new LoginFoorm().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancel;
    private javax.swing.JButton conncter;
    private javax.swing.JLabel etoi;
    private javax.swing.JLabel etoil;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelClose;
    private javax.swing.JLabel jLabelMin;
    private javax.swing.JLabel jLabelRegister;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField passw;
    private javax.swing.JTextField pseudo;
    // End of variables declaration//GEN-END:variables
}


