/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.SupervisorWorkArea;

import Healthplus.E_System;
import Healthplus.Enterprises.Enterprise;
import Healthplus.Org.Org;
import Healthplus.UserAccount.UserAccount;
import Healthplus.WorkQueue.PostTaskWorkRequest;
import Healthplus.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;


public class OngoingProjects_Page extends javax.swing.JPanel {

    /**
     * Creates new form OngoingProjects_Page
     */
    private JPanel userProcessContainer;
    private E_System system;
    private UserAccount userAccount;
    private Org organization;
    private Enterprise enterprise;

    public OngoingProjects_Page(JPanel userProcessContainer, E_System system, UserAccount userAccount, Org organization, Enterprise enterprise) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.system = system;
        this.userAccount = userAccount;
        this.organization = organization;
        this.enterprise = enterprise;
        populateOngoingProjectsTable();
    }

    public void populateOngoingProjectsTable() {
        DefaultTableModel model = (DefaultTableModel) tblOngoingProjects.getModel();
        model.setRowCount(0);
        for (WorkRequest request : organization.getWorkQueue().getWorkRequestList()) {
            if (request instanceof PostTaskWorkRequest) {
                Object[] row = new Object[5];
                row[0] = (PostTaskWorkRequest)request;
                row[1] = ((PostTaskWorkRequest) request).getTask();
                row[2] = request.getSender().getUsername();
                row[3] = request.getReceiver() == null ? null : request.getReceiver().getUsername();
                row[4] = request.getStatus();
                model.addRow(row);
            }
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

        btn_goback = new javax.swing.JButton();
        lblHeader = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblOngoingProjects = new javax.swing.JTable();
        btn_assigntome = new javax.swing.JButton();
        btn_processapplication = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 226, 215));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_goback.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/backicon.jpeg"))); // NOI18N
        btn_goback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_gobackActionPerformed(evt);
            }
        });
        add(btn_goback, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 530, 110, 80));

        lblHeader.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        lblHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeader.setText("Ongoing Projects");
        add(lblHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, 270, 26));

        tblOngoingProjects.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Project Name", "Task", "Sender", "Receiver", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblOngoingProjects);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 580, 230));

        btn_assigntome.setBackground(new java.awt.Color(255, 255, 255));
        btn_assigntome.setText("Assign to me");
        btn_assigntome.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn_assigntome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_assigntomeActionPerformed(evt);
            }
        });
        add(btn_assigntome, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 400, 90, 30));

        btn_processapplication.setBackground(new java.awt.Color(255, 255, 255));
        btn_processapplication.setText("Process");
        btn_processapplication.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn_processapplication.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_processapplicationActionPerformed(evt);
            }
        });
        add(btn_processapplication, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 400, 100, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void btn_gobackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_gobackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btn_gobackActionPerformed

    private void btn_assigntomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_assigntomeActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblOngoingProjects.getSelectedRow();

        if (selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a row","Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String str = (String) tblOngoingProjects.getValueAt(selectedRow, 4);
        if(str.equals("Sent") || str.equals("Processing")){
            WorkRequest request = (WorkRequest)tblOngoingProjects.getValueAt(selectedRow, 0);
            request.setReceiver(userAccount);
            request.setStatus("Pending");
            populateOngoingProjectsTable();
        }
        else{
            JOptionPane.showMessageDialog(null, "Select Pending Projects","Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
    }//GEN-LAST:event_btn_assigntomeActionPerformed

    private void btn_processapplicationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_processapplicationActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblOngoingProjects.getSelectedRow();
        if (selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a row","Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        PostTaskWorkRequest request = (PostTaskWorkRequest)tblOngoingProjects.getValueAt(selectedRow, 0);
        if(request.getStatus()=="Pending")
        {
            request.setStatus("Processing");

            if(request.getProject().getName().equals("Provide Treatment")){
                ProcessTreatmentWorkRequest_Page processWorkRequestJPanel = new ProcessTreatmentWorkRequest_Page(userProcessContainer, system, userAccount, organization, request);
                userProcessContainer.add("processWorkRequestJPanel", processWorkRequestJPanel);
                CardLayout layout = (CardLayout) userProcessContainer.getLayout();
                layout.next(userProcessContainer);
            }
            else if(request.getProject().getName().equals("Provide Medication")){
                ProcessWorkRequest_Page processWorkRequestJPanel = new ProcessWorkRequest_Page(userProcessContainer, system, userAccount, organization, request);
                userProcessContainer.add("processWorkRequestJPanel", processWorkRequestJPanel);
                CardLayout layout = (CardLayout) userProcessContainer.getLayout();
                layout.next(userProcessContainer);
            }
            else{
                DonationsJPanel donationsJPanel = new DonationsJPanel(userProcessContainer, request);
                userProcessContainer.add("donationsJPanel", donationsJPanel);
                CardLayout layout = (CardLayout) userProcessContainer.getLayout();
                layout.next(userProcessContainer);
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "Please assign a task to yourself and then process","Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btn_processapplicationActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_assigntome;
    private javax.swing.JButton btn_goback;
    private javax.swing.JButton btn_processapplication;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblHeader;
    private javax.swing.JTable tblOngoingProjects;
    // End of variables declaration//GEN-END:variables
}
