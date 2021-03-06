/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.ManagerWorkArea;

import Healthplus.Account.Account;
import Healthplus.Enterprises.Enterprise;
import Healthplus.Org.Org;
import Healthplus.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;


public class AccountJPanel extends javax.swing.JPanel {

    /**
     * Creates new form Account
     */
    private JPanel userProcessContainer;
    private UserAccount userAccount;
    private Org organization;
    private Enterprise enterprise;
    public AccountJPanel(JPanel userProcessContainer, UserAccount userAccount, Org organization, Enterprise enterprise) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = userAccount;
        this.organization = organization;
        this.enterprise = enterprise;
        populateAgencyTable();
    }

     public void populateAgencyTable() {
        DefaultTableModel model = (DefaultTableModel) tblAccount.getModel();
        model.setRowCount(0);
        for (Account account : enterprise.getAccountDirectory().getAccountList()) {
                Object[] row = new Object[2];
                row[0] = account.getAgency().getName();
                row[1] = account.getAgency().getAmount();
                model.addRow(row);
            }
        String total = String.valueOf(enterprise.getAccountDirectory().getTotal());
        String balance = String.valueOf(enterprise.getAccountDirectory().getBalance());
        label_totalvalue.setText(total);
        label_balancevalue.setText(balance);
    }
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBack = new javax.swing.JButton();
        label_total = new javax.swing.JLabel();
        label_totalvalue = new javax.swing.JLabel();
        label_balance = new javax.swing.JLabel();
        label_balancevalue = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAccount = new javax.swing.JTable();
        lblHeader = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 231, 224));
        setMaximumSize(new java.awt.Dimension(700, 700));
        setMinimumSize(new java.awt.Dimension(700, 700));
        setPreferredSize(new java.awt.Dimension(700, 700));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/backicon.jpeg"))); // NOI18N
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 550, 100, 80));

        label_total.setFont(new java.awt.Font("Comic Sans MS", 0, 13)); // NOI18N
        label_total.setText("Total : ");
        add(label_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 340, -1, -1));

        label_totalvalue.setFont(new java.awt.Font("Comic Sans MS", 0, 13)); // NOI18N
        label_totalvalue.setText("<TotalValue>");
        add(label_totalvalue, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 340, 111, -1));

        label_balance.setFont(new java.awt.Font("Comic Sans MS", 0, 13)); // NOI18N
        label_balance.setText("Balance:");
        add(label_balance, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 400, -1, -1));

        label_balancevalue.setFont(new java.awt.Font("Comic Sans MS", 0, 13)); // NOI18N
        label_balancevalue.setText("<BalanceValue>");
        add(label_balancevalue, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 400, -1, -1));

        tblAccount.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Agency Name", "Account"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblAccount);
        if (tblAccount.getColumnModel().getColumnCount() > 0) {
            tblAccount.getColumnModel().getColumn(0).setResizable(false);
            tblAccount.getColumnModel().getColumn(1).setResizable(false);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 476, 210));

        lblHeader.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        lblHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeader.setText("Accounts");
        add(lblHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 270, 26));
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_balance;
    private javax.swing.JLabel label_balancevalue;
    private javax.swing.JLabel label_total;
    private javax.swing.JLabel label_totalvalue;
    private javax.swing.JLabel lblHeader;
    private javax.swing.JTable tblAccount;
    // End of variables declaration//GEN-END:variables
}
