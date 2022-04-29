/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.ManagerWorkArea;

import Healthplus.Enterprises.Enterprise;
import Healthplus.Org.ManagerOrg;
import Healthplus.Org.Org;
import Healthplus.Org.CampaignOrg;
import Healthplus.Project.Project;
import Healthplus.UserAccount.UserAccount;
import Healthplus.WorkQueue.PostTaskWorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class AddPostTasksJPanel extends javax.swing.JPanel {

    /**
     * Creates new form AddPostTasksJPanel
     */
    private JPanel userProcessContainer;
    private UserAccount userAccount;
    private Org organization;
    private Enterprise enterprise;

    public AddPostTasksJPanel(JPanel userProcessContainer, UserAccount userAccount, Org organization, Enterprise enterprise) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = userAccount;
        this.organization = organization;
        this.enterprise = enterprise;
        text_trustvalue.setText(enterprise.getName());
        populateProjectName();

    }

    public void populateProjectName() {
        combo_project.removeAllItems();
        for (Project p : enterprise.getProjectDirectory().getProjectList()) {
            combo_project.addItem(p);
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

        label_trust = new javax.swing.JLabel();
        text_trustvalue = new javax.swing.JLabel();
        label_project = new javax.swing.JLabel();
        combo_project = new javax.swing.JComboBox<>();
        btn_posttask = new javax.swing.JButton();
        label_task = new javax.swing.JLabel();
        text_task = new javax.swing.JTextField();
        btn_goback = new javax.swing.JButton();
        lblHeader = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 221, 212));
        setMaximumSize(new java.awt.Dimension(700, 700));
        setMinimumSize(new java.awt.Dimension(700, 700));
        setPreferredSize(new java.awt.Dimension(700, 700));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_trust.setFont(new java.awt.Font("Comic Sans MS", 0, 13)); // NOI18N
        label_trust.setText("Trust:");
        add(label_trust, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 170, -1, -1));

        text_trustvalue.setFont(new java.awt.Font("Comic Sans MS", 0, 13)); // NOI18N
        text_trustvalue.setText("<value>");
        add(text_trustvalue, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 170, -1, -1));


        combo_project.setFont(new java.awt.Font("Comic Sans MS", 0, 13)); // NOI18N
        combo_project.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" , "Item 5"}));
        combo_project.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_projectActionPerformed(evt);
            }
        });
        add(combo_project, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 230, 149, -1));

        btn_posttask.setBackground(new java.awt.Color(255, 255, 255));
        btn_posttask.setText("Push task to emergency");
        btn_posttask.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn_posttask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_posttaskActionPerformed(evt);
            }
        });
        add(btn_posttask, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 370, 110, 30));

        label_task.setFont(new java.awt.Font("Comic Sans MS", 0, 13)); // NOI18N
        label_task.setText("Task:");
        add(label_task, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 290, -1, -1));

        text_task.setFont(new java.awt.Font("Comic Sans MS", 0, 13)); // NOI18N
        add(text_task, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 290, 206, -1));

        btn_goback.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/backicon.jpeg"))); // NOI18N
        btn_goback.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn_goback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_gobackActionPerformed(evt);
            }
        });
        add(btn_goback, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 510, 100, 90));

        lblHeader.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        lblHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeader.setText("Post a Task");
        add(lblHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 270, 26));
    }// </editor-fold>//GEN-END:initComponents

    private void btn_posttaskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_posttaskActionPerformed
        // TODO add your handling code here:

        String task = text_task.getText();
        String regex = "^[a-z A-Z .]+$";
        Pattern namePattern = Pattern.compile(regex);
        Matcher nameMatcher = namePattern.matcher(task);

        if(task.equals("")){
               JOptionPane.showMessageDialog(null, "Please enter text", "Warning", JOptionPane.WARNING_MESSAGE);
                 return;
        }
            if(!nameMatcher.matches()){
                 JOptionPane.showMessageDialog(null, "Invalid characters in task", "Warning", JOptionPane.WARNING_MESSAGE);
                 return;
            }

        PostTaskWorkRequest taskRequest = new PostTaskWorkRequest();
        taskRequest.setProject((Project) combo_project.getSelectedItem());
        taskRequest.setTask(task);
        taskRequest.setSender(userAccount);
        taskRequest.setStatus("Sent request");

        Org org = null;
        for (Org o : enterprise.getOrganizationDirectory().getOrganizationList()) {
            if (o instanceof CampaignOrg) {
                org = o;
                break;
            }
        }

        if (org != null) {
            org.getWorkQueue().getWorkRequestList().add(taskRequest);
            userAccount.getWorkQueue().getWorkRequestList().add(taskRequest);
            JOptionPane.showMessageDialog(null, "Task posted successfully", "Information", JOptionPane.INFORMATION_MESSAGE);
            text_task.setText("");
        }
    }//GEN-LAST:event_btn_posttaskActionPerformed

    private void btn_gobackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_gobackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        PostTasksJPanel ptjp = (PostTasksJPanel) component;
        ptjp.populateRequestTable();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btn_gobackActionPerformed

    private void combo_projectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_projectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_projectActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_goback;
    private javax.swing.JComboBox<Object> combo_project;
    private javax.swing.JLabel label_project;
    private javax.swing.JLabel label_task;
    private javax.swing.JLabel label_trust;
    private javax.swing.JLabel lblHeader;
    private javax.swing.JTextField text_task;
    private javax.swing.JLabel text_trustvalue;
    // End of variables declaration//GEN-END:variables
}
