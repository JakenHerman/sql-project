/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javadb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Addison
 */
public class MainMenuUser extends javax.swing.JFrame {

    /**
     * Creates new form MainMenuUser
     */
    public MainMenuUser() {
        initComponents();
        Show_Agents_In_JTable();
    }

     public ArrayList<Agent> getAgentsList()
   {
       //arraylist full of suspect class
        ArrayList<Agent> agentList = new ArrayList<Agent>();
        Connection connection = new DBConnection().connect();
       
       String query = "SELECT * FROM  `agent` ";
       Statement st;
       ResultSet rs;
       
       try {
           st = connection.createStatement();
           rs = st.executeQuery(query);
           Agent agent;
           while(rs.next())
           {
               agent = new Agent(rs.getInt("ID"),rs.getString("Name"),rs.getInt("AssignedSuspect"));
               agentList.add(agent);
           }
           connection.close();
       } catch (Exception e) {
           e.printStackTrace();
       }
       return agentList;
   }
   
public void Show_Agents_In_JTable()
   {
       ArrayList<Agent> list = getAgentsList();
       DefaultTableModel model = (DefaultTableModel)tableUserMainMenu.getModel();
       Object[] row = new Object[5];
       for(int i = 0; i < list.size(); i++)
       {
           //Fill up with the AGENT column names
           row[0] = list.get(i).getId();
           row[1] = list.get(i).getName();
           row[2] = list.get(i).getAssignedSuspect();
           model.addRow(row);
       }
    }
    
   


    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelAgentID = new javax.swing.JLabel();
        labelAgentName = new javax.swing.JLabel();
        labelAssignedSuspect = new javax.swing.JLabel();
        textFieldAgentID = new javax.swing.JTextField();
        textFieldAgentName = new javax.swing.JTextField();
        textFieldAssignedSuspect = new javax.swing.JTextField();
        buttonLookUp = new javax.swing.JButton();
        buttonExit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableUserMainMenu = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelAgentID.setText("Agent ID");

        labelAgentName.setText("Agent Name");

        labelAssignedSuspect.setText("Assigned Suspect");

        textFieldAgentID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldAgentIDActionPerformed(evt);
            }
        });

        buttonLookUp.setText("Lookup");
        buttonLookUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLookUpActionPerformed(evt);
            }
        });

        buttonExit.setText("Exit");
        buttonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExitActionPerformed(evt);
            }
        });

        tableUserMainMenu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Agent ID", "Agent Name", "Assigned Suspect"
            }
        ));
        tableUserMainMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableUserMainMenuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableUserMainMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonLookUp)
                        .addGap(18, 18, 18)
                        .addComponent(buttonExit))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelAgentID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelAgentName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelAssignedSuspect, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textFieldAgentID, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                            .addComponent(textFieldAgentName)
                            .addComponent(textFieldAssignedSuspect))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldAgentID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelAgentID))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldAgentName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelAgentName))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldAssignedSuspect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelAssignedSuspect))
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonLookUp)
                    .addComponent(buttonExit))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textFieldAgentIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldAgentIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldAgentIDActionPerformed

    private void buttonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_buttonExitActionPerformed

    private void buttonLookUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLookUpActionPerformed
           int ID = Integer.parseInt(textFieldAgentID.getText());
           String Agentname = textFieldAgentName.getText();
           String SuspectName = textFieldAssignedSuspect.getText();
           ArrayList<Agent> agentList = new ArrayList<Agent>();
           Statement st;
           ResultSet rs;    
         try {
            Connection conn = new DBConnection().connect();
            PreparedStatement ps = conn.prepareStatement("select * from agent where id = ?");
            ps.setInt(1,ID);
            rs = ps.executeQuery();
            Agent agent;
           if(rs.next())
           {
              
               
               agent = new Agent(rs.getInt("ID"),rs.getString("Name"),rs.getInt("AssignedSuspect"));
               agentList.add(agent);
               
       DefaultTableModel model = (DefaultTableModel)tableUserMainMenu.getModel();
       model.setRowCount(0);
       Object[] row = new Object[5];
       for(int i = 0; i < agentList.size(); i++)
       {
           //Fill up with the AGENT column names
           row[0] = agentList.get(i).getId();
           row[1] = agentList.get(i).getName();
           row[2] = agentList.get(i).getAssignedSuspect();
           model.addRow(row);
       }
           }else {
               JOptionPane.showMessageDialog(null, "Nothing found");
           }
           
           conn.close();
           
           
           
       
        } catch (SQLException ex) {
            ex.printStackTrace();
                   
        }        
        
        
        
             
    }//GEN-LAST:event_buttonLookUpActionPerformed

    private void tableUserMainMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableUserMainMenuMouseClicked
        // Displays mouse selected rows in the text fields
                                                 
      // Displays mouse selected rows in the text fields
        
        int i = tableUserMainMenu.getSelectedRow();

        TableModel model = tableUserMainMenu.getModel();
        
        textFieldAgentID.setText(model.getValueAt(i,0).toString());
        
        textFieldAgentName.setText(model.getValueAt(i,1).toString());

        textFieldAssignedSuspect.setText(model.getValueAt(i,2).toString());

     
                                             
    }//GEN-LAST:event_tableUserMainMenuMouseClicked

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainMenuUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenuUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenuUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenuUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenuUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonExit;
    private javax.swing.JButton buttonLookUp;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelAgentID;
    private javax.swing.JLabel labelAgentName;
    private javax.swing.JLabel labelAssignedSuspect;
    private javax.swing.JTable tableUserMainMenu;
    private javax.swing.JTextField textFieldAgentID;
    private javax.swing.JTextField textFieldAgentName;
    private javax.swing.JTextField textFieldAssignedSuspect;
    // End of variables declaration//GEN-END:variables
}
