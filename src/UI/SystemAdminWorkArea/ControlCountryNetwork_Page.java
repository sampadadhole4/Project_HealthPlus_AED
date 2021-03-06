/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.SystemAdminWorkArea;

import Healthplus.E_System;
import Healthplus.Network.Country;
import Healthplus.Network.State;
import java.awt.CardLayout;
import java.awt.Component;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;


public class ControlCountryNetwork_Page extends javax.swing.JPanel {

    /**
     * Creates new form ControlCountryNetwork_Page
     */
    private JPanel userProcessContainer;
    E_System system;
    public ControlCountryNetwork_Page(JPanel userProcessContainer, E_System system) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.system = system;
        populateTable();
    }

    private void populateTable(){
        DefaultTableModel dtm = (DefaultTableModel) tblCountry.getModel();
        dtm.setRowCount(0);
        
           for(Country c : system.getNetworkList()){
            Object row[] = new Object[1];
            row[0] = c.getName();
            dtm.addRow(row);
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

        jLabel1 = new javax.swing.JLabel();
        tblScrollPane = new javax.swing.JScrollPane();
        tblCountry = new javax.swing.JTable();
        lblName = new javax.swing.JLabel();
        txtFldName = new javax.swing.JTextField();
        btnSubmit = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        lblHeader = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setBackground(new java.awt.Color(255, 229, 219));
        setMaximumSize(new java.awt.Dimension(700, 700));
        setMinimumSize(new java.awt.Dimension(700, 700));
        setPreferredSize(new java.awt.Dimension(375, 0));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblScrollPane.setPreferredSize(new java.awt.Dimension(375, 0));

        tblCountry.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Country"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblScrollPane.setViewportView(tblCountry);
        if (tblCountry.getColumnModel().getColumnCount() > 0) {
            tblCountry.getColumnModel().getColumn(0).setResizable(false);
        }

        add(tblScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, -1, 180));

        lblName.setFont(new java.awt.Font("Comic Sans MS", 0, 13)); // NOI18N
        lblName.setText("Name Of the Country:");
        add(lblName, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 320, -1, -1));

        txtFldName.setFont(new java.awt.Font("Comic Sans MS", 0, 13)); // NOI18N
        add(txtFldName, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 320, 150, -1));

        btnSubmit.setBackground(new java.awt.Color(255, 255, 255));
        btnSubmit.setFont(new java.awt.Font("Comic Sans MS", 0, 13)); // NOI18N
        btnSubmit.setText("Submit");
        btnSubmit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });
        add(btnSubmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 390, 90, 40));

        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/backicon.jpeg"))); // NOI18N
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 520, 100, 90));

        lblHeader.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        lblHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeader.setText("Manage Country Network");
        add(lblHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, 380, 26));
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        // TODO add your handling code here:
        
        String name = txtFldName.getText();
        if(!name.equals("")){
                // validate name
            String regex = "^[a-z A-Z]+$";
            Pattern namePattern = Pattern.compile(regex);
            Matcher nameMatcher = namePattern.matcher(name);

            if(!nameMatcher.matches()){
                 JOptionPane.showMessageDialog(null, "Invalid characters in country name", "Warning", JOptionPane.WARNING_MESSAGE);
                 return;
            }
            Country c = system.createAndAddNetwork();
            c.setName(name);
            populateTable();
            txtFldName.setText("");
            JOptionPane.showMessageDialog(null, "Country added successfully", "Info", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "Please enter text", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        SystemAdminWorkArea_Page sawajp = (SystemAdminWorkArea_Page) component;
        sawajp.populateTree();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblHeader;
    private javax.swing.JLabel lblName;
    private javax.swing.JTable tblCountry;
    private javax.swing.JScrollPane tblScrollPane;
    private javax.swing.JTextField txtFldName;
    // End of variables declaration//GEN-END:variables
}
