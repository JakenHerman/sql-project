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
public class MainMenu extends javax.swing.JFrame {

    /**
     * Creates new form MainMenu
     */
    public MainMenu() {
        initComponents();
        Show_Suspects_In_JTable();       
    }
    
    public ArrayList<Suspect> getSuspectsList()
   {
       //arraylist full of suspect class
        ArrayList<Suspect> suspectsList = new ArrayList<Suspect>();
        Connection connection = new DBConnection().connect();
       
       String query = "SELECT * FROM  `suspect` ";
       Statement st;
       ResultSet rs;
       
       try {
           st = connection.createStatement();
           rs = st.executeQuery(query);
           Suspect suspect;
           while(rs.next())
           {
               suspect = new Suspect(rs.getInt("ID"),rs.getString("SuspectName"),rs.getInt("Threat"),rs.getInt("AssignedAgent"),rs.getString("LastSeen"));
               suspectsList.add(suspect);
           }
           connection.close();
       } catch (Exception e) {
           e.printStackTrace();
       }
       return suspectsList;
   }
   
public void Show_Suspects_In_JTable()
   {
       ArrayList<Suspect> list = getSuspectsList();
       DefaultTableModel model = (DefaultTableModel)tableAdminMainMenu.getModel();
       Object[] row = new Object[5];
       for(int i = 0; i < list.size(); i++)
       {
           //Fill up with the suspect column names
           row[0] = list.get(i).getId();
           row[1] = list.get(i).getName();
           row[2] = list.get(i).getThreat();
           row[3] = list.get(i).getAssignedAgent();
           row[4] = list.get(i).getLastSeen();
           
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        labelAdminMainMenu = new javax.swing.JLabel();
        buttonExit = new javax.swing.JButton();
        buttonInsert = new javax.swing.JButton();
        buttonDelete = new javax.swing.JButton();
        buttonUpdate = new javax.swing.JButton();
        LabelSuspect = new javax.swing.JLabel();
        labelThreat = new javax.swing.JLabel();
        labelAssignedAgent = new javax.swing.JLabel();
        textSuspectName = new javax.swing.JTextField();
        textThreatLevel = new javax.swing.JTextField();
        textAssignedAgent = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableAdminMainMenu = new javax.swing.JTable();
        labelLastSeen = new javax.swing.JLabel();
        textLastSeen = new javax.swing.JTextField();
        labelID = new javax.swing.JLabel();
        textID = new javax.swing.JTextField();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelAdminMainMenu.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        labelAdminMainMenu.setText("ADMIN MAIN MENU");

        buttonExit.setText("Exit");
        buttonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExitActionPerformed(evt);
            }
        });

        buttonInsert.setText("Insert");
        buttonInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonInsertActionPerformed(evt);
            }
        });

        buttonDelete.setText("Delete");
        buttonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteActionPerformed(evt);
            }
        });

        buttonUpdate.setText("Update");
        buttonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUpdateActionPerformed(evt);
            }
        });

        LabelSuspect.setText("Suspect Name");

        labelThreat.setText("Threat level");

        labelAssignedAgent.setText("Assigned Agent");

        textSuspectName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textSuspectNameActionPerformed(evt);
            }
        });

        textAssignedAgent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textAssignedAgentActionPerformed(evt);
            }
        });

        tableAdminMainMenu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Suspect name", "Threat level", "Assigned agent", "Last seen"
            }
        ));
        tableAdminMainMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableAdminMainMenuMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableAdminMainMenu);

        labelLastSeen.setText("Last Seen(State)");

        labelID.setText("ID");

        textID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textIDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelLastSeen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textLastSeen, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(labelID, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelAssignedAgent, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelThreat, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(LabelSuspect, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textThreatLevel, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                            .addComponent(textAssignedAgent, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                            .addComponent(textSuspectName, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                            .addComponent(textID)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(buttonInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(buttonExit, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 627, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(224, 224, 224)
                .addComponent(labelAdminMainMenu)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelAdminMainMenu)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelID))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textSuspectName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LabelSuspect))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textThreatLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelThreat))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textAssignedAgent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelAssignedAgent))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textLastSeen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelLastSeen)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonInsert)
                    .addComponent(buttonDelete)
                    .addComponent(buttonUpdate)
                    .addComponent(buttonExit))
                .addGap(45, 45, 45))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_buttonExitActionPerformed

    private void textAssignedAgentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textAssignedAgentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textAssignedAgentActionPerformed

    private void buttonInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonInsertActionPerformed
        
        // Get the text inside the current boxes whenever Insert is pressed and save to variables
        // Had to use ParseInt for the columns I saved as INT in MYSQL
         String name = textSuspectName.getText();
         int threat = Integer.parseInt(textThreatLevel.getText());
         int agent = Integer.parseInt(textAssignedAgent.getText());
         String seen = textLastSeen.getText();
                         
        try {
            Connection conn = new DBConnection().connect();
 
            String sql = "INSERT INTO suspect (SuspectName, Threat, AssignedAgent, LastSeen) values (?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, name);
            statement.setInt(2, threat);
            statement.setInt(3, agent);
            statement.setString(4, seen);
 
            int row = statement.executeUpdate();
            // if row > 0 it means statement executed successfully in MYSQL
            if (row > 0){
               System.out.println("Inserted SUCCESS!");
               JOptionPane.showMessageDialog(null, "Data was inserted");
               // Get the table model
               DefaultTableModel model = (DefaultTableModel)tableAdminMainMenu.getModel();
               model.setRowCount(0);
               Show_Suspects_In_JTable();
            }
            else{
                System.out.println("Warning: Data Insert Failed");
            }
           
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
                   
        }        
                                    
    }//GEN-LAST:event_buttonInsertActionPerformed

    private void textSuspectNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textSuspectNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textSuspectNameActionPerformed

    private void buttonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteActionPerformed
           int ID = Integer.parseInt(textID.getText());
           String name = textSuspectName.getText();
           int threat = Integer.parseInt(textThreatLevel.getText());
           int agent = Integer.parseInt(textAssignedAgent.getText());
           String seen = textLastSeen.getText();
                    
                   
         try {
            Connection conn = new DBConnection().connect();
            String query = "DELETE FROM suspect WHERE ID = ?";
         
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, ID);
            int row = statement.executeUpdate();
            // if row > 0 it means statement executed successfully in MYSQL
            if (row > 0){
               System.out.println("DELETE SUCCESS!");
               JOptionPane.showMessageDialog(null, "Data deleted");
               DefaultTableModel model = (DefaultTableModel)tableAdminMainMenu.getModel();
               model.setRowCount(0);
               Show_Suspects_In_JTable();
            }
            else{
                System.out.println("DELETE FAILED!");
                JOptionPane.showMessageDialog(null, "Warning: Data was not deleted");
            }
           conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
                   
        }        
        
        
        
    }//GEN-LAST:event_buttonDeleteActionPerformed

      // Displays mouse selected rows in the text fields
    private void tableAdminMainMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableAdminMainMenuMouseClicked
      // Displays mouse selected rows in the text fields
        
        int i = tableAdminMainMenu.getSelectedRow();

        TableModel model = tableAdminMainMenu.getModel();
        
        textID.setText(model.getValueAt(i,0).toString());
        
        textSuspectName.setText(model.getValueAt(i,1).toString());

        textThreatLevel.setText(model.getValueAt(i,2).toString());

        textAssignedAgent.setText(model.getValueAt(i,3).toString());

        textLastSeen.setText(model.getValueAt(i,4).toString());


    }//GEN-LAST:event_tableAdminMainMenuMouseClicked

    private void textIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textIDActionPerformed

    private void buttonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUpdateActionPerformed
                         
           int ID = Integer.parseInt(textID.getText());
           String name = textSuspectName.getText();
           int threat = Integer.parseInt(textThreatLevel.getText());
           int agent = Integer.parseInt(textAssignedAgent.getText());
           String seen = textLastSeen.getText();
                  
         try {
            Connection conn = new DBConnection().connect();
            String query = "UPDATE suspect SET SuspectName = ?, Threat = ?, AssignedAgent = ?, LastSeen = ?  WHERE ID = ?";
         
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, name);
            statement.setInt(2, threat);
            statement.setInt(3, agent);
            statement.setString(4, seen);
            statement.setInt(5, ID);
 
            int row = statement.executeUpdate();
            // if row > 0 it means statement executed successfully in MYSQL
            if (row > 0){
               System.out.println("UPDATE SUCCESS!");
               JOptionPane.showMessageDialog(null, "Data updated successfully");
               DefaultTableModel model = (DefaultTableModel)tableAdminMainMenu.getModel();
               model.setRowCount(0);
               Show_Suspects_In_JTable();
            }
            else{
                System.out.println("UPDATE FAILED!");
                 JOptionPane.showMessageDialog(null, "Data update FAILED");
            }
           conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
                   
        }   

    }//GEN-LAST:event_buttonUpdateActionPerformed

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
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelSuspect;
    private javax.swing.JButton buttonDelete;
    private javax.swing.JButton buttonExit;
    private javax.swing.JButton buttonInsert;
    private javax.swing.JButton buttonUpdate;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel labelAdminMainMenu;
    private javax.swing.JLabel labelAssignedAgent;
    private javax.swing.JLabel labelID;
    private javax.swing.JLabel labelLastSeen;
    private javax.swing.JLabel labelThreat;
    private javax.swing.JTable tableAdminMainMenu;
    private javax.swing.JTextField textAssignedAgent;
    private javax.swing.JTextField textID;
    private javax.swing.JTextField textLastSeen;
    private javax.swing.JTextField textSuspectName;
    private javax.swing.JTextField textThreatLevel;
    // End of variables declaration//GEN-END:variables
}