/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Forms;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.DriverManager;
import java.util.Date;
import javax.swing.JOptionPane;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.Timer;

public class login extends javax.swing.JFrame {

    
    public login() {
        initComponents();
        setIcon();
        displayDate();
        displayTime();
    }
    Connection con = null ;
    PreparedStatement pst ;
    ResultSet rs          ;
    Timer t                     ;
    SimpleDateFormat st         ;
    
    public void displayDate () {
        
                            Date date = new Date();    
                            SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");

                            String dd = sdf.format(date);
                            datee.setText(dd);
    
                      }
    
    
    
    public void displayTime() {
    
                            t = new Timer (0,new ActionListener(){

                            public void actionPerformed(ActionEvent e){

                            Date dt = new Date();
                            st = new SimpleDateFormat("hh:mm:ss");

                            String tt = st.format(dt);
                            timee.setText(tt);
                            }

                            });
                            t.start();
                        }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btnLogin = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        message = new javax.swing.JLabel();
        account = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        datee = new javax.swing.JLabel();
        timee = new javax.swing.JLabel();
        copyright = new javax.swing.JLabel();
        datee1 = new javax.swing.JLabel();
        datee2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 51, 75));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Stencil", 0, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Point of sale");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, -1));

        jLabel6.setFont(new java.awt.Font("Stencil", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("SOFTWARE");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 270, 210, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 520));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(176, 0, 0));
        jPanel4.setOpaque(false);

        btnLogin.setBackground(new java.awt.Color(0, 51, 75));
        btnLogin.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        jCheckBox1.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jCheckBox1.setText("Show password");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 75));
        jLabel3.setText("PASSWORD");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 51, 75));
        jLabel4.setText("USERNAME");

        password.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N
        password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordKeyPressed(evt);
            }
        });

        message.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        message.setForeground(new java.awt.Color(204, 0, 0));
        message.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        account.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesAndGIF/passs.png"))); // NOI18N

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesAndGIF/user icon.png"))); // NOI18N

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesAndGIF/login logooo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(message, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(account, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(78, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel4)
                        .addGap(6, 6, 6)))
                .addComponent(account, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(message, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        datee.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        datee.setForeground(new java.awt.Color(0, 51, 75));
        datee.setText("yyyy/mm/dd");
        datee.setToolTipText("");

        timee.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        timee.setForeground(new java.awt.Color(0, 51, 75));
        timee.setText("hh/mm/ss");

        copyright.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        copyright.setForeground(new java.awt.Color(0, 51, 75));
        copyright.setText("Copy Right @ JPOS 2023 . Alright Reserved");

        datee1.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        datee1.setForeground(new java.awt.Color(0, 51, 75));
        datee1.setText("DATE :");
        datee1.setToolTipText("");

        datee2.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        datee2.setForeground(new java.awt.Color(0, 51, 75));
        datee2.setText("TIME :");
        datee2.setToolTipText("");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(datee1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(datee, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(datee2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(timee, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(copyright)
                .addGap(138, 138, 138))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(datee)
                    .addComponent(timee)
                    .addComponent(datee1)
                    .addComponent(datee2))
                .addGap(11, 11, 11)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(copyright)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, 510, 520));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed

        try {
            String usr = account.getText();
            String passw = password.getText();
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/POSDataBase","root","");
            String sql = "SELECT * FROM employees WHERE Username = ? AND Password = ?";
            pst = con.prepareCall(sql);
            pst.setString(1, usr   );
            pst.setString(2, passw );
            rs = pst.executeQuery();
            
                        if (rs.next()) {
                             if (usr.equals(rs.getString("Username")) && passw.equals(rs.getString("Password"))) {   
                                    String position = rs.getString("Position");
                                    String AccID = rs.getString("Account_ID" );
                                    String getstat = rs.getString("Status"   );
                                    if (getstat.equals("Offline")){
                                    
                                        JOptionPane.showMessageDialog(null, "Your Account is \"OFFLINE\" ", "ADMIN", JOptionPane.ERROR_MESSAGE);
                                    
                                    }else if (getstat.equals("Online")) {
                                                
                                                if (position.equalsIgnoreCase("Manager")) {
                                                    this.dispose();
                                                    Date date = new Date();
                                                    java.sql.Date logindate = new java.sql.Date (date.getTime());
                                                    java.sql.Time logintime = new java.sql.Time (date.getTime());
                                                    java.sql.Date logoutdate = new java.sql.Date(date.getTime());
                                                    java.sql.Time logouttime = new java.sql.Time(date.getTime());
                                                    System.out.println("Date : Successful");
                                                    System.out.println("Time : Successful");
                                                    Class.forName("com.mysql.cj.jdbc.Driver");
                                                    con = DriverManager.getConnection("jdbc:mysql://localhost/POSDataBase","root","");
                                                    String sqls = "INSERT INTO loginhistory (Account_ID,Username,Position,Login_Date,Login_Time,Logout_Date,Logout_Time) VALUES (?,?,?,?,?,?,?)";
                                                    pst = con.prepareStatement(sqls);
                                                    pst.setString(1, AccID   );
                                                    pst.setString(2, usr     );
                                                    pst.setString(3, position);
                                                    pst.setDate(4, logindate   );
                                                    pst.setTime(5, logintime   );
                                                    pst.setDate(6, logoutdate  );
                                                    pst.setTime(7, logouttime  );
                                                    pst.executeUpdate();
                                                    System.out.println("Manager login saved");
                                                    new ManagerDashboard(usr).setVisible(true);
                                                }else if (position.equalsIgnoreCase("Staff")) {
                                                    this.dispose();
                                                    Date date = new Date();
                                                    java.sql.Date logindate = new java.sql.Date (date.getTime());
                                                    java.sql.Time logintime = new java.sql.Time (date.getTime());
                                                    java.sql.Date logoutdate = new java.sql.Date(date.getTime());
                                                    java.sql.Time logouttime = new java.sql.Time(date.getTime());
                                                    System.out.println("Date : Successful");
                                                    System.out.println("Time : Successful");
                                                    Class.forName("com.mysql.cj.jdbc.Driver");
                                                    con = DriverManager.getConnection("jdbc:mysql://localhost/POSDataBase","root","");
                                                    String sqls = "INSERT INTO loginhistory (Account_ID,Username,Position,Login_Date,Login_Time,Logout_Date,Logout_Time) VALUES (?,?,?,?,?,?,?)";
                                                    pst = con.prepareStatement(sqls);
                                                    pst.setString(1, AccID   );
                                                    pst.setString(2, usr     );
                                                    pst.setString(3, position);
                                                    pst.setDate(4, logindate   );
                                                    pst.setTime(5, logintime   );
                                                    pst.setDate(6, logoutdate  );
                                                    pst.setTime(7, logouttime  );
                                                    pst.executeUpdate();
                                                    System.out.println("Staff login saved");
                                                    new MainDashboard(usr).setVisible(true);
                                                }else if (position.equalsIgnoreCase("Admin")) {
                                                    this.dispose();
                                                    Date date = new Date();
                                                    java.sql.Date logindate = new java.sql.Date (date.getTime());
                                                    java.sql.Time logintime = new java.sql.Time (date.getTime());
                                                    java.sql.Date logoutdate = new java.sql.Date(date.getTime());
                                                    java.sql.Time logouttime = new java.sql.Time(date.getTime());
                                                    System.out.println("Date : Successful");
                                                    System.out.println("Time : Successful");
                                                    Class.forName("com.mysql.cj.jdbc.Driver");
                                                    con = DriverManager.getConnection("jdbc:mysql://localhost/POSDataBase","root","");
                                                    String sqls = "INSERT INTO loginhistory (Account_ID,Username,Position,Login_Date,Login_Time,Logout_Date,Logout_Time) VALUES (?,?,?,?,?,?,?)";
                                                    pst = con.prepareStatement(sqls);
                                                    pst.setString(1, AccID   );
                                                    pst.setString(2, usr     );
                                                    pst.setString(3, position);
                                                    pst.setDate(4, logindate   );
                                                    pst.setTime(5, logintime   );
                                                    pst.setDate(6, logoutdate  );
                                                    pst.setTime(7, logouttime  );
                                                    pst.executeUpdate();
                                                    System.out.println("Admin login saved");
                                                    new AdminDashboard(usr).setVisible(true);
                                                }else {
                                                    JOptionPane.showMessageDialog(null, "Position not found", "Login Error", JOptionPane.ERROR_MESSAGE);
                                                }
                                        
                                    }
                             }else {
                                    message.setText ("Incorrect username or password, Please Try again...");
                                    account.setText ("");
                                    password.setText("");
                                    JOptionPane.showMessageDialog(null, "Invalid input", "Login Error", JOptionPane.ERROR_MESSAGE);
                             }//2nd IF
                        }else {
                                message.setText ("You don't have an account");
                                account.setText ("");
                                password.setText("");
                                JOptionPane.showMessageDialog(null, "Please register account", "Login Error", JOptionPane.ERROR_MESSAGE);
                        }//1st IF
            
        
        } catch (Exception e) 
        {
                    System.out.println(e);
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
        if (jCheckBox1.isSelected()) {
            password.setEchoChar((char)0);
        }else {
            password.setEchoChar('*');
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void passwordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
            String usr = account.getText();
            String passw = password.getText();
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/POSDataBase","root","");
            String sql = "SELECT * FROM employees WHERE Username = ? AND Password = ?";
            pst = con.prepareCall(sql);
            pst.setString(1, usr   );
            pst.setString(2, passw );
            rs = pst.executeQuery();
            
                        if (rs.next()) {
                             if (usr.equals(rs.getString("Username")) && passw.equals(rs.getString("Password"))) {   
                                    String position = rs.getString("Position");
                                    String AccID = rs.getString("Account_ID" );
                                    String getstat = rs.getString("Status"   );
                                    if (getstat.equals("Offline")){
                                    
                                        JOptionPane.showMessageDialog(null, "Your Account is \"OFFLINE\" ", "ADMIN", JOptionPane.ERROR_MESSAGE);
                                    
                                    }else if (getstat.equals("Online")) {
                                                
                                                if (position.equalsIgnoreCase("Manager")) {
                                                    this.dispose();
                                                    Date date = new Date();
                                                    java.sql.Date logindate = new java.sql.Date (date.getTime());
                                                    java.sql.Time logintime = new java.sql.Time (date.getTime());
                                                    java.sql.Date logoutdate = new java.sql.Date(date.getTime());
                                                    java.sql.Time logouttime = new java.sql.Time(date.getTime());
                                                    System.out.println("Date : Successful");
                                                    System.out.println("Time : Successful");
                                                    Class.forName("com.mysql.cj.jdbc.Driver");
                                                    con = DriverManager.getConnection("jdbc:mysql://localhost/POSDataBase","root","");
                                                    String sqls = "INSERT INTO loginhistory (Account_ID,Username,Position,Login_Date,Login_Time,Logout_Date,Logout_Time) VALUES (?,?,?,?,?,?,?)";
                                                    pst = con.prepareStatement(sqls);
                                                    pst.setString(1, AccID   );
                                                    pst.setString(2, usr     );
                                                    pst.setString(3, position);
                                                    pst.setDate(4, logindate   );
                                                    pst.setTime(5, logintime   );
                                                    pst.setDate(6, logoutdate  );
                                                    pst.setTime(7, logouttime  );
                                                    pst.executeUpdate();
                                                    System.out.println("Manager login saved");
                                                    new ManagerDashboard(usr).setVisible(true);
                                                }else if (position.equalsIgnoreCase("Staff")) {
                                                    this.dispose();
                                                    Date date = new Date();
                                                    java.sql.Date logindate = new java.sql.Date (date.getTime());
                                                    java.sql.Time logintime = new java.sql.Time (date.getTime());
                                                    java.sql.Date logoutdate = new java.sql.Date(date.getTime());
                                                    java.sql.Time logouttime = new java.sql.Time(date.getTime());
                                                    System.out.println("Date : Successful");
                                                    System.out.println("Time : Successful");
                                                    Class.forName("com.mysql.cj.jdbc.Driver");
                                                    con = DriverManager.getConnection("jdbc:mysql://localhost/POSDataBase","root","");
                                                    String sqls = "INSERT INTO loginhistory (Account_ID,Username,Position,Login_Date,Login_Time,Logout_Date,Logout_Time) VALUES (?,?,?,?,?,?,?)";
                                                    pst = con.prepareStatement(sqls);
                                                    pst.setString(1, AccID   );
                                                    pst.setString(2, usr     );
                                                    pst.setString(3, position);
                                                    pst.setDate(4, logindate   );
                                                    pst.setTime(5, logintime   );
                                                    pst.setDate(6, logoutdate  );
                                                    pst.setTime(7, logouttime  );
                                                    pst.executeUpdate();
                                                    System.out.println("Staff login saved");
                                                    new MainDashboard(usr).setVisible(true);
                                                }else if (position.equalsIgnoreCase("Admin")) {
                                                    this.dispose();
                                                    Date date = new Date();
                                                    java.sql.Date logindate = new java.sql.Date (date.getTime());
                                                    java.sql.Time logintime = new java.sql.Time (date.getTime());
                                                    java.sql.Date logoutdate = new java.sql.Date(date.getTime());
                                                    java.sql.Time logouttime = new java.sql.Time(date.getTime());
                                                    System.out.println("Date : Successful");
                                                    System.out.println("Time : Successful");
                                                    Class.forName("com.mysql.cj.jdbc.Driver");
                                                    con = DriverManager.getConnection("jdbc:mysql://localhost/POSDataBase","root","");
                                                    String sqls = "INSERT INTO loginhistory (Account_ID,Username,Position,Login_Date,Login_Time,Logout_Date,Logout_Time) VALUES (?,?,?,?,?,?,?)";
                                                    pst = con.prepareStatement(sqls);
                                                    pst.setString(1, AccID   );
                                                    pst.setString(2, usr     );
                                                    pst.setString(3, position);
                                                    pst.setDate(4, logindate   );
                                                    pst.setTime(5, logintime   );
                                                    pst.setDate(6, logoutdate  );
                                                    pst.setTime(7, logouttime  );
                                                    pst.executeUpdate();
                                                    System.out.println("Admin login saved");
                                                    new AdminDashboard(usr).setVisible(true);
                                                }else {
                                                    JOptionPane.showMessageDialog(null, "Position not found", "Login Error", JOptionPane.ERROR_MESSAGE);
                                                }
                                        
                                    }
                             }else {
                                    message.setText ("Incorrect username or password, Please Try again...");
                                    account.setText ("");
                                    password.setText("");
                                    JOptionPane.showMessageDialog(null, "Invalid input", "Login Error", JOptionPane.ERROR_MESSAGE);
                             }//2nd IF
                        }else {
                                message.setText ("You don't have an account");
                                account.setText ("");
                                password.setText("");
                                JOptionPane.showMessageDialog(null, "Please register account", "Login Error", JOptionPane.ERROR_MESSAGE);
                        }//1st IF
            
        
        } catch (Exception e) 
        {
                    System.out.println(e);
        }
        }
    }//GEN-LAST:event_passwordKeyPressed

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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }
private void setIcon() {
       setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Jframe Icon.png")));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextField account;
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel copyright;
    private javax.swing.JLabel datee;
    private javax.swing.JLabel datee1;
    private javax.swing.JLabel datee2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel message;
    private javax.swing.JPasswordField password;
    private javax.swing.JLabel timee;
    // End of variables declaration//GEN-END:variables

    
}
