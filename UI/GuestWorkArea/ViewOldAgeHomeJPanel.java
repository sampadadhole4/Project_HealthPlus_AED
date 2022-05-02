/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.GuestWorkArea;

import Healthplus.E_System;
import Healthplus.Enterprises.Enterprise;
import Healthplus.Network.City;
import Healthplus.Network.Country;
import Healthplus.Network.State;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;


public class ViewOldAgeHomeJPanel extends javax.swing.JPanel {
    
     private JPanel userProcessContainer;
    E_System system;


    /**
     * Creates new form ViewOldAgeHomeJPanel
     */
    public ViewOldAgeHomeJPanel(JPanel userProcessContainer, E_System system) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.system = system;
        populateCountry();
        populateState();
        populateCity();

    }
    private void populateCountry() {
        combo_country.removeAllItems();
        for (Country c : system.getNetworkList()) {
            combo_country.addItem(c);
        }
    }
    private void populateState() {
        combo_satet.removeAllItems();
        if (combo_country.getSelectedItem() != null) {
            for (Country c : system.getNetworkList()) {
                if (c.equals(combo_country.getSelectedItem())) {
                    for (State s : c.getStateList()) {
                        combo_satet.addItem(s);
                    }
                }
            }
        }
    }
    private void populateCity() {
        tcombo_city.removeAllItems();
        if (combo_satet.getSelectedItem() != null) {
            for (Country c : system.getNetworkList()) {
                for (State s : c.getStateList()) {
                    if (s.equals(combo_satet.getSelectedItem())) {
                        for (City city : s.getCityList()) {
                            tcombo_city.addItem(city);
                        }
                    }
                }
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

        btn_back = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        label_country = new javax.swing.JLabel();
        combo_country = new javax.swing.JComboBox();
        combo_satet = new javax.swing.JComboBox();
        label_state = new javax.swing.JLabel();
        label_city = new javax.swing.JLabel();
        tcombo_city = new javax.swing.JComboBox();
        btn_submit = new javax.swing.JButton();
        tblScrollPane = new javax.swing.JScrollPane();
        tbloldAgeHome = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 225, 221));

        btn_back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/backicon.jpeg"))); // NOI18N
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("View Old Age Home");

        label_country.setText("Country:");

        combo_country.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_countryActionPerformed(evt);
            }
        });

        combo_satet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_satetActionPerformed(evt);
            }
        });

        label_state.setText("State:");

        label_city.setText("City:");

        btn_submit.setBackground(new java.awt.Color(255, 255, 255));
        btn_submit.setText("Submit");
        btn_submit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn_submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_submitActionPerformed(evt);
            }
        });

        tbloldAgeHome.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "OldAge Home"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbloldAgeHome.setColumnSelectionAllowed(true);
        tbloldAgeHome.setMinimumSize(new java.awt.Dimension(375, 0));
        tbloldAgeHome.getTableHeader().setReorderingAllowed(false);
        tblScrollPane.setViewportView(tbloldAgeHome);
        tbloldAgeHome.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(239, 239, 239)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tblScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(label_city)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tcombo_city, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(label_country)
                                    .addGap(35, 35, 35)
                                    .addComponent(combo_country, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(label_state)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(combo_satet, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(btn_back, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(348, 348, 348)
                        .addComponent(btn_submit, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(274, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo_country, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_country))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_state)
                    .addComponent(combo_satet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_city)
                    .addComponent(tcombo_city, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(btn_submit, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(tblScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(btn_back, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(164, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btn_backActionPerformed

    private void combo_countryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_countryActionPerformed
        // TODO add your handling code here:
        populateState();
    }//GEN-LAST:event_combo_countryActionPerformed

    private void combo_satetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_satetActionPerformed
        // TODO add your handling code here:
        populateCity();
    }//GEN-LAST:event_combo_satetActionPerformed

    private void btn_submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_submitActionPerformed
        // TODO add your handling code here:
        DefaultTableModel dtm = (DefaultTableModel) tbloldAgeHome.getModel();
        dtm.setRowCount(0);

        Country country = (Country) combo_country.getSelectedItem();
        State state = (State) combo_satet.getSelectedItem();
        City city = (City) tcombo_city.getSelectedItem();

        for (Country c : system.getNetworkList()) {
            if (c.equals(country)) {
                for (State s : c.getStateList()) {
                    if (s.equals(state)) {
                        for (City cy : s.getCityList()) {
                            if (cy.equals(city)) {
                                for (Enterprise e : city.getEnterpriseDirectory().getEnterpriseList()) {
                                    if(e.getEnterpriseType().getValue().equals("OldAgeHome")){
                                        Object row[] = new Object[1];

                                        row[0] = e;
                                        dtm.addRow(row);
                                    }
                                }
                            }
                        }
                    }
                }
            }

        }
    }//GEN-LAST:event_btn_submitActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_submit;
    private javax.swing.JComboBox combo_country;
    private javax.swing.JComboBox combo_satet;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel label_city;
    private javax.swing.JLabel label_country;
    private javax.swing.JLabel label_state;
    private javax.swing.JScrollPane tblScrollPane;
    private javax.swing.JTable tbloldAgeHome;
    private javax.swing.JComboBox tcombo_city;
    // End of variables declaration//GEN-END:variables
}
