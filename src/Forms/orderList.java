/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Forms;

import static Forms.MainDashboard.MainTable;
import static Forms.MainDashboard.con;
import static Forms.MainDashboard.or1;
import static Forms.MainDashboard.pst;
import java.awt.Color;
import java.sql.DriverManager;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import static Forms.MainDashboard.q1;


public class orderList extends javax.swing.JFrame {

      
    public orderList() {
        initComponents();
       
        MainDashboard m = new MainDashboard();
        m.ord1table_update();
        m.ord2table_update();
        m.ord3table_update();
        m.ord4table_update();
        m.ord5table_update();
        m.ord6table_update();
        m.ord7table_update();
        m.ord8table_update();
        
    }
    
    Connection con;
    ResultSet rs;
    PreparedStatement pst;
    
    
    
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        order1 = new javax.swing.JTable();
        jScrollPane11 = new javax.swing.JScrollPane();
        order2 = new javax.swing.JTable();
        jButton10 = new javax.swing.JButton();
        jScrollPane12 = new javax.swing.JScrollPane();
        order03 = new javax.swing.JTable();
        jScrollPane13 = new javax.swing.JScrollPane();
        order4 = new javax.swing.JTable();
        jScrollPane14 = new javax.swing.JScrollPane();
        order5 = new javax.swing.JTable();
        jScrollPane15 = new javax.swing.JScrollPane();
        order6 = new javax.swing.JTable();
        jScrollPane16 = new javax.swing.JScrollPane();
        order7 = new javax.swing.JTable();
        jScrollPane17 = new javax.swing.JScrollPane();
        order8 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        c = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        order1.setFont(new java.awt.Font("Nirmala UI", 1, 12)); // NOI18N
        order1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ITEM", "SIZE", "QUANTITY"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane8.setViewportView(order1);

        jPanel1.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 310, 250));

        order2.setFont(new java.awt.Font("Nirmala UI", 1, 12)); // NOI18N
        order2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ITEM", "SIZE", "QUANTITY"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane11.setViewportView(order2);

        jPanel1.add(jScrollPane11, new org.netbeans.lib.awtextra.AbsoluteConstraints(338, 30, 310, 250));

        jButton10.setBackground(new java.awt.Color(0, 153, 0));
        jButton10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setText("DONE");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 283, 150, 31));

        order03.setFont(new java.awt.Font("Nirmala UI", 1, 12)); // NOI18N
        order03.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ITEM", "SIZE", "QUANTITY"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane12.setViewportView(order03);

        jPanel1.add(jScrollPane12, new org.netbeans.lib.awtextra.AbsoluteConstraints(666, 30, 310, 250));

        order4.setFont(new java.awt.Font("Nirmala UI", 1, 12)); // NOI18N
        order4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ITEM", "SIZE", "QUANTITY"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane13.setViewportView(order4);

        jPanel1.add(jScrollPane13, new org.netbeans.lib.awtextra.AbsoluteConstraints(994, 30, 310, 250));

        order5.setFont(new java.awt.Font("Nirmala UI", 1, 12)); // NOI18N
        order5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ITEM", "SIZE", "QUANTITY"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane14.setViewportView(order5);

        jPanel1.add(jScrollPane14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 310, 250));

        order6.setFont(new java.awt.Font("Nirmala UI", 1, 12)); // NOI18N
        order6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ITEM", "SIZE", "QUANTITY"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane15.setViewportView(order6);

        jPanel1.add(jScrollPane15, new org.netbeans.lib.awtextra.AbsoluteConstraints(338, 370, 310, 250));

        order7.setFont(new java.awt.Font("Nirmala UI", 1, 12)); // NOI18N
        order7.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ITEM", "SIZE", "QUANTITY"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane16.setViewportView(order7);

        jPanel1.add(jScrollPane16, new org.netbeans.lib.awtextra.AbsoluteConstraints(666, 370, 310, 250));

        order8.setFont(new java.awt.Font("Nirmala UI", 1, 12)); // NOI18N
        order8.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ITEM", "SIZE", "QUANTITY"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane17.setViewportView(order8);

        jPanel1.add(jScrollPane17, new org.netbeans.lib.awtextra.AbsoluteConstraints(994, 370, 310, 250));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ORDER # 8");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1122, 350, 80, -1));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ORDER # 1");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 10, 80, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ORDER # 2");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(453, 10, 80, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("ORDER # 3");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(781, 10, 80, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("ORDER # 4");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1111, 10, 80, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("ORDER # 5");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 350, 80, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("ORDER # 6");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(453, 350, 80, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("ORDER # 7");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(781, 350, 80, -1));

        jButton11.setBackground(new java.awt.Color(0, 153, 0));
        jButton11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton11.setForeground(new java.awt.Color(255, 255, 255));
        jButton11.setText("DONE");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(419, 286, 150, 31));

        jButton12.setBackground(new java.awt.Color(0, 153, 0));
        jButton12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton12.setForeground(new java.awt.Color(255, 255, 255));
        jButton12.setText("DONE");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(744, 286, 150, 31));

        jButton15.setBackground(new java.awt.Color(0, 153, 0));
        jButton15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton15.setForeground(new java.awt.Color(255, 255, 255));
        jButton15.setText("DONE");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(1082, 286, 150, 31));

        jButton16.setBackground(new java.awt.Color(0, 153, 0));
        jButton16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton16.setForeground(new java.awt.Color(255, 255, 255));
        jButton16.setText("DONE");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton16, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 626, 150, 31));

        jButton17.setBackground(new java.awt.Color(0, 153, 0));
        jButton17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton17.setForeground(new java.awt.Color(255, 255, 255));
        jButton17.setText("DONE");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton17, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 626, 150, 31));

        jButton19.setBackground(new java.awt.Color(0, 153, 0));
        jButton19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton19.setForeground(new java.awt.Color(255, 255, 255));
        jButton19.setText("DONE");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton19, new org.netbeans.lib.awtextra.AbsoluteConstraints(747, 626, 150, 31));

        jButton20.setBackground(new java.awt.Color(0, 153, 0));
        jButton20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton20.setForeground(new java.awt.Color(255, 255, 255));
        jButton20.setText("DONE");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton20, new org.netbeans.lib.awtextra.AbsoluteConstraints(1086, 626, 150, 31));

        jPanel2.setBackground(new java.awt.Color(0, 51, 75));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1320, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 730, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1320, 730));

        jMenu1.setText("Shortcut Key");

        c.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        c.setText("Close");
        c.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cActionPerformed(evt);
            }
        });
        jMenu1.add(c);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cActionPerformed
        // TODO add your handling code here:
        String CLOSE = c.getText();
        if (CLOSE.equalsIgnoreCase("Close")) {
        
        this.dispose();
        
       
        }
    }//GEN-LAST:event_cActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure?", "PLEASE CONFIRM", JOptionPane.YES_NO_OPTION);
            if (dialogResult == JOptionPane.YES_OPTION){
                
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    con = DriverManager.getConnection("jdbc:mysql://localhost/POSDataBase","root","");
                    String sqlsss = "DELETE FROM orderlist1 ";
                    pst = con.prepareStatement(sqlsss);
                    pst.executeUpdate();
                    MainDashboard m = new MainDashboard();
                    m.ord1table_update();
                    
                    
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        
        
        
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure?", "PLEASE CONFIRM", JOptionPane.YES_NO_OPTION);
            if (dialogResult == JOptionPane.YES_OPTION){
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    con = DriverManager.getConnection("jdbc:mysql://localhost/POSDataBase","root","");
                    String sqlsss = "DELETE FROM orderlist2 ";
                    pst = con.prepareStatement(sqlsss);
                    pst.executeUpdate();
                    MainDashboard m = new MainDashboard();
                    m.ord2table_update();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure?", "PLEASE CONFIRM", JOptionPane.YES_NO_OPTION);
            if (dialogResult == JOptionPane.YES_OPTION){
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    con = DriverManager.getConnection("jdbc:mysql://localhost/POSDataBase","root","");
                    String sqlsss = "DELETE FROM orderlist3 ";
                    pst = con.prepareStatement(sqlsss);
                    pst.executeUpdate();
                    MainDashboard m = new MainDashboard();
                    m.ord3table_update();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
        int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure?", "PLEASE CONFIRM", JOptionPane.YES_NO_OPTION);
            if (dialogResult == JOptionPane.YES_OPTION){
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    con = DriverManager.getConnection("jdbc:mysql://localhost/POSDataBase","root","");
                    String sqlsss = "DELETE FROM orderlist4 ";
                    pst = con.prepareStatement(sqlsss);
                    pst.executeUpdate();
                    MainDashboard m = new MainDashboard();
                    m.ord4table_update();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:
        int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure?", "PLEASE CONFIRM", JOptionPane.YES_NO_OPTION);
            if (dialogResult == JOptionPane.YES_OPTION){
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    con = DriverManager.getConnection("jdbc:mysql://localhost/POSDataBase","root","");
                    String sqlsss = "DELETE FROM orderlist5 ";
                    pst = con.prepareStatement(sqlsss);
                    pst.executeUpdate();
                    MainDashboard m = new MainDashboard();
                    m.ord5table_update();
                    
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        // TODO add your handling code here:
        int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure?", "PLEASE CONFIRM", JOptionPane.YES_NO_OPTION);
            if (dialogResult == JOptionPane.YES_OPTION){
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    con = DriverManager.getConnection("jdbc:mysql://localhost/POSDataBase","root","");
                    String sqlsss = "DELETE FROM orderlist6 ";
                    pst = con.prepareStatement(sqlsss);
                    pst.executeUpdate();
                    MainDashboard m = new MainDashboard();
                    m.ord6table_update();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        // TODO add your handling code here:
        int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure?", "PLEASE CONFIRM", JOptionPane.YES_NO_OPTION);
            if (dialogResult == JOptionPane.YES_OPTION){
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    con = DriverManager.getConnection("jdbc:mysql://localhost/POSDataBase","root","");
                    String sqlsss = "DELETE FROM orderlist7 ";
                    pst = con.prepareStatement(sqlsss);
                    pst.executeUpdate();
                    MainDashboard m = new MainDashboard();
                    m.ord7table_update();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        // TODO add your handling code here:
        int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure?", "PLEASE CONFIRM", JOptionPane.YES_NO_OPTION);
            if (dialogResult == JOptionPane.YES_OPTION){
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    con = DriverManager.getConnection("jdbc:mysql://localhost/POSDataBase","root","");
                    String sqlsss = "DELETE FROM orderlist8 ";
                    pst = con.prepareStatement(sqlsss);
                    pst.executeUpdate();
                    MainDashboard m = new MainDashboard();
                    m.ord8table_update();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
    }//GEN-LAST:event_jButton20ActionPerformed

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
            java.util.logging.Logger.getLogger(orderList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(orderList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(orderList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(orderList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new orderList().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem c;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton20;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane8;
    public static javax.swing.JTable order03;
    public static javax.swing.JTable order1;
    public static javax.swing.JTable order2;
    public static javax.swing.JTable order4;
    public static javax.swing.JTable order5;
    public static javax.swing.JTable order6;
    public static javax.swing.JTable order7;
    public static javax.swing.JTable order8;
    // End of variables declaration//GEN-END:variables
}
