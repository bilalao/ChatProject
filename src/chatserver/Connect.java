package chatserver;

import chatproject.donnees;
import java.sql.*;
import javax.swing.JOptionPane;


/**
 *
 * @author HP
 */
public class Connect {

    public static Connection getConnect() {
        Connection cn = null;
        try {

            //  Class.forName("com.mysql.jdbc.Driver");
            //  cn =DriverManager.getConnection( "jdbc:mysql://localhost:8889/chat","root","root");

            Class.forName("com.mysql.jdbc.Driver");
            cn =DriverManager.getConnection( "jdbc:mysql://us-cdbr-east-03.cleardb.com:3306/heroku_7ed2a2d88d2d065","baa1ac241702e1","9ac7befb");

        } catch (ClassNotFoundException | SQLException e) {
          JOptionPane.showMessageDialog(null, "dans class connect : "+e.getMessage());

        }

        return cn;

    }

    public static int mis_a_jours(String sql) {

        int i = 0;
        try {
            Connection cn = getConnect();
            Statement st = cn.createStatement();
            i = st.executeUpdate(sql);

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return i;

    }

    public static ResultSet Selection(String sql) {
        ResultSet rs = null;
        try {
            Connection cn = getConnect();
            Statement st = cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs = st.executeQuery(sql);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "selection    "+e.getMessage());
        }
        return rs;
    }
}
