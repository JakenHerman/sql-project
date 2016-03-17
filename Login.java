
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.sql.ResultSet;
import java.sql.Connection;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.*;
import java.sql.ResultSet;

public class Login extends javax.swing.JFrame {
 Connection con = null;
 ResultSet rst = null;
 PreparedStatement pts = null;
 private Container screen;
 private JLabel idLabel, passwordLabel, message;
 private JPasswordField password;
 private JTextField id;
    
    public Login() {
        super( "Login" );
       
       
        
  screen = getContentPane( );
  screen.setLayout( new FlowLayout( ) );
 
  idLabel = new JLabel( "Enter id" ); // id label
  id = new JTextField( "", 12 );      // create text field for ID

  passwordLabel = new JLabel( "Enter password" ); // password label
  password = new JPasswordField( 8 ); // create password field
  password.setEchoChar( '*' );        // password will show up as '****'
  setSize( 500,400 );
  setVisible( true );

  JLabel message = new JLabel("Log in to access database", SwingConstants.CENTER);
  
 
  JButton loginButton = new JButton("Login");
  // put items into the container
  
  screen.add( idLabel );
  screen.add( id );
  screen.add( passwordLabel );
  screen.add( password );
  screen.add( message);
  screen.add(loginButton);


  Choices actionButton = new Choices();
  loginButton.addActionListener(actionButton);
  
  
 }
    
public class Choices implements ActionListener         // What to do when button is pressed
 {
 public void actionPerformed( ActionEvent eventButton )
 {
    
     boolean found = false;
    
	// If login is pressed and username/password are NOT EMPTY
 	if(eventButton.getActionCommand().equals("Login"))
 	{
            
            try {
      Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); // may not be needed since JDBC4
      Connection con=DriverManager.getConnection("jdbc:odbc:MessageStore","sa","12345"); 
      pts=con.prepareStatement("select * from UserList where username=? and password=?");
      pts.setString(1,id.getText());
      pts.setString(2, password.getText());
      ResultSet rs=pts.executeQuery();
      if( rs.next() ){
       found = true;
      }else{
       found = false;
      }
    
    
    
    }catch(Exception e){}
    
        }
 }
}

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    
    }
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

