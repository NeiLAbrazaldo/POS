/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Forms;



import static Forms.ManagerDashboard.con;
import static Forms.ManagerDashboard.pst;
import cell.TableActionCellEditor;
import cell.TableActionCellRender;
import cell.TableActionEvent;
import java.awt.*;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


public class AdminDashboard extends javax.swing.JFrame {


    public AdminDashboard() {
        initComponents();
        RegisteredAccountsTable_Update();
        LoginHistoryTable_Update();
        countStaff();
        countManager();
        countAdmin();
        dt();
        time();
        TableActionEvent event = new TableActionEvent(){
        public void onEdit (int row){
            System.out.println("Edit row : " + row);
        }
        public void onDelete (int row){
            if(AccountTable.isEditing()){
                AccountTable.getCellEditor().stopCellEditing                      ();
                DefaultTableModel d1 = (DefaultTableModel)AccountTable.getModel   ();
                int selectedIndex = AccountTable.getSelectedRow                   ();
                String getID = (d1.getValueAt(selectedIndex, 0).toString());
            try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    con = DriverManager.getConnection("jdbc:mysql://localhost/POSDataBase","root","");
                    String sqlsss = "DELETE FROM employees WHERE Account_ID = ? ";
                    pst = con.prepareStatement(sqlsss);
                    pst.setString(1, getID );
                    pst.executeUpdate             ();
                    RegisteredAccountsTable_Update();
                    countStaff                    ();
                    countManager                  ();
                    countAdmin                    ();
            } catch (Exception e) {
                    System.out.println(e);
            }
            }
        }
        public void onView (int row){
            System.out.println("View row : " + row);
        }
    };
            AccountTable.getColumnModel().getColumn(7).setCellRenderer(new TableActionCellRender()   );
            AccountTable.getColumnModel().getColumn(7).setCellEditor(new TableActionCellEditor(event));
      
    }

    AdminDashboard (String an) {
                    this();
                    name.setText(an);
    }
    
    static Connection con       ;
    static PreparedStatement pst;
    static ResultSet rs         ;
    Timer t                     ;
    SimpleDateFormat st         ;
     
   public void search(String str){
        
                        DefaultTableModel d = (DefaultTableModel)AccountTable.getModel    ();
                        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(d);
                        AccountTable.setRowSorter(trs)                                ;
                        trs.setRowFilter(RowFilter.regexFilter(str)             );
                        System.out.println("Search : Successful"                         );
    } 
    
  public void countStaff() {
                        String position = "Staff";
                    try{
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        con = DriverManager.getConnection("jdbc:mysql://localhost/POSDataBase","root","");
                        String sql = "Select count(Username) from employees  where Position =?";
                        pst = con.prepareStatement(sql);
                        pst.setString(1, position);
                        rs = pst.executeQuery();

                        if (rs.next()) {

                        String Ruser = rs.getString("count(Username)");
                        tsa.setText(Ruser);

                        }
                    }catch (Exception e) {

                            JOptionPane.showMessageDialog(null, e);

                    }
                        RegisteredAccountsTable_Update();

  }
    
    public void countManager() {
                        String position = "Manager";
                    try{
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        con = DriverManager.getConnection("jdbc:mysql://localhost/POSDataBase","root","");
                        String sql = "Select count(Username) from employees  where Position =?";
                        pst = con.prepareStatement(sql);
                        pst.setString(1, position);
                        rs = pst.executeQuery();

                        if (rs.next()) {

                        String Ruser = rs.getString("count(Username)");
                        tma.setText(Ruser);

                        }
                    }catch (Exception e) {

                            JOptionPane.showMessageDialog(null, e);

                    }
                        RegisteredAccountsTable_Update();
}
    
    public void countAdmin() {
                        String position = "Admin";
                    try{
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        con = DriverManager.getConnection("jdbc:mysql://localhost/POSDataBase","root","");
                        String sql = "Select count(Username) from employees  where Position =?";
                        pst = con.prepareStatement(sql);
                        pst.setString(1, position);
                        rs = pst.executeQuery();

                        if (rs.next()) {

                        String Ruser = rs.getString("count(Username)");
                        taa.setText(Ruser);

                        }
                    }catch (Exception e) {

                            JOptionPane.showMessageDialog(null, e);

                    }
                        RegisteredAccountsTable_Update();
}
    
public void RegisteredAccountsTable_Update(){
    
     try {
         
            int c;
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/POSDataBase","root","");
            String sql = "SELECT * FROM employees";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            ResultSetMetaData rsd = rs.getMetaData();
            c = rsd.getColumnCount();
            
            DefaultTableModel d = (DefaultTableModel)AccountTable.getModel();
            d.setRowCount(0);
            
            while (rs.next()) {
            
                Vector v2 = new Vector();
                for(int i= 1;i<=c; i++){
                
                v2.add(rs.getString("Account_ID"        ));
                v2.add(rs.getString("Username"          ));
                v2.add(rs.getString("Password"          ));
                v2.add(rs.getString("Registration_Date" ));
                v2.add(rs.getString("Registration_Time" ));
                v2.add(rs.getString("Position"          ));
                v2.add(rs.getString("Status"            ));
                }
                d.addRow(v2);
            }
            System.out.println("Registered Account Update : Successful");
        } catch (Exception e) {
            System.out.println(e);
        }
   }
    
    public void LoginHistoryTable_Update(){
    
     try {
         
            int c;
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/POSDataBase","root","");
            String sql = "SELECT * FROM loginhistory";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            ResultSetMetaData rsd = rs.getMetaData();
            c = rsd.getColumnCount();
            
            DefaultTableModel d = (DefaultTableModel)loginHIstoryTable.getModel();
            d.setRowCount(0);
            
            while (rs.next()) {
            
                Vector v2 = new Vector();
                for(int i= 1;i<=c; i++){
                
                v2.add(rs.getString("Account_ID" ));
                v2.add(rs.getString("Username"   ));
                v2.add(rs.getString("Position"   ));
                v2.add(rs.getString("Login_Date" ));
                v2.add(rs.getString("Login_Time" ));
                v2.add(rs.getString("Logout_Date"));
                v2.add(rs.getString("Logout_Time"));
                }
                d.addRow(v2);
            }
            System.out.println("Login History Update : Successful");
        } catch (Exception e) {
            System.out.println(e);
        }
   }
    
    public void dt () {
        
                            Date date = new Date();    
                            SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");

                            String dd = sdf.format(date);
                            l_date.setText(dd);
                            System.out.println("DATE : Successful");
    }
    
    public void time() {
    
                            t = new Timer (0,new ActionListener(){

                            public void actionPerformed(ActionEvent e){

                            Date dt = new Date();
                            st = new SimpleDateFormat("hh:mm:ss");

                            String tt = st.format(dt);
                            l_time.setText(tt);
                            }

                            });
                            t.start();
                            System.out.println("TIME : Successful");
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        loginHIstoryTable = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        AccountTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        setStatus = new javax.swing.JComboBox<>();
        setBTN = new javax.swing.JButton();
        name3 = new javax.swing.JLabel();
        search = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        userName = new javax.swing.JTextField();
        registerBTN = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        accountID = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        position = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        pass = new javax.swing.JTextField();
        l_time = new javax.swing.JLabel();
        l_date = new javax.swing.JLabel();
        acn = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        name1 = new javax.swing.JLabel();
        taa = new javax.swing.JLabel();
        name4 = new javax.swing.JLabel();
        tsa = new javax.swing.JLabel();
        tma = new javax.swing.JLabel();
        name5 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        staffname = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        PAY = new javax.swing.JMenu();
        logout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 51, 75));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 51, 75));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(204, 204, 204)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel10.setBackground(new java.awt.Color(0, 51, 75));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(204, 204, 204)), "LOGIN HISTORY", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Stencil", 1, 18), new java.awt.Color(204, 204, 204))); // NOI18N
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        loginHIstoryTable.setFont(new java.awt.Font("Nirmala UI", 1, 10)); // NOI18N
        loginHIstoryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ACCOUNT ID", "USERNAME", "POSITION", "LOGIN DATE", "LOGIN TIME", "LOGOUT DATE", "LOGOUT TIME"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        loginHIstoryTable.setGridColor(new java.awt.Color(204, 204, 204));
        loginHIstoryTable.setRowHeight(40);
        jScrollPane2.setViewportView(loginHIstoryTable);

        jPanel10.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 660, 310));

        jPanel2.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 680, 360));

        jPanel4.setBackground(new java.awt.Color(0, 51, 75));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(204, 204, 204)), "REGISTERED ACCOUNTS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Stencil", 1, 18), new java.awt.Color(204, 204, 204))); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        AccountTable.setFont(new java.awt.Font("Nirmala UI", 1, 10)); // NOI18N
        AccountTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "USERNAME", "PASSWORD", "RGTR DATE", "RGTR TIME", "POSITION", "STATUS", "ACTION"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        AccountTable.setGridColor(new java.awt.Color(204, 204, 204));
        AccountTable.setRowHeight(40);
        jScrollPane3.setViewportView(AccountTable);

        jPanel4.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 590, 480));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 60, 610, 530));

        jPanel3.setBackground(new java.awt.Color(0, 51, 75));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(204, 204, 204)), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Stencil", 1, 18), new java.awt.Color(176, 0, 0))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Stencil", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("UPDATE STATUS              :");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 10, -1, 30));

        setStatus.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        setStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<Select>", "Online", "Offline" }));
        setStatus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                setStatusMouseClicked(evt);
            }
        });
        jPanel3.add(setStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 10, 190, 30));

        setBTN.setBackground(new java.awt.Color(0, 51, 75));
        setBTN.setFont(new java.awt.Font("Nirmala UI", 1, 12)); // NOI18N
        setBTN.setForeground(new java.awt.Color(255, 255, 255));
        setBTN.setText("SET");
        setBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setBTNActionPerformed(evt);
            }
        });
        jPanel3.add(setBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 10, 180, 30));

        name3.setFont(new java.awt.Font("Stencil", 0, 14)); // NOI18N
        name3.setForeground(new java.awt.Color(255, 255, 255));
        name3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        name3.setText("SEARCH ACCOUNT              :");
        jPanel3.add(name3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 200, 30));

        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchKeyReleased(evt);
            }
        });
        jPanel3.add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 160, 30));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 1290, 50));

        jPanel5.setBackground(new java.awt.Color(0, 51, 75));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(204, 204, 204)), "ACCOUNT DETAILS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Stencil", 1, 18), new java.awt.Color(204, 204, 204))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Stencil", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("USERNAME");

        userName.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        userName.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        registerBTN.setBackground(new java.awt.Color(0, 51, 75));
        registerBTN.setFont(new java.awt.Font("Nirmala UI", 1, 12)); // NOI18N
        registerBTN.setForeground(new java.awt.Color(255, 255, 255));
        registerBTN.setText("REGISTER");
        registerBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerBTNActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Stencil", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("ACCOUNT ID");

        accountID.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        accountID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        accountID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accountIDMouseClicked(evt);
            }
        });
        accountID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                accountIDKeyPressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Stencil", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("POSITION");

        position.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        position.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<Select>", "Staff", "Manager", "Admin" }));
        position.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                positionMouseClicked(evt);
            }
        });
        position.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                positionActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Stencil", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("PASSWORD");

        pass.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        pass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(userName))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(accountID, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pass))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(registerBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(position, 0, 222, Short.MAX_VALUE))))
                .addGap(18, 18, 18))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(accountID, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pass, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(userName, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(position, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(registerBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 680, 170));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 1330, 600));

        l_time.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        l_time.setForeground(new java.awt.Color(255, 255, 255));
        l_time.setText("TIME");
        jPanel1.add(l_time, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 720, 80, -1));

        l_date.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        l_date.setForeground(new java.awt.Color(255, 255, 255));
        l_date.setText("DATE");
        jPanel1.add(l_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 720, 90, -1));

        acn.setFont(new java.awt.Font("Lucida Calligraphy", 1, 10)); // NOI18N
        acn.setForeground(new java.awt.Color(255, 255, 255));
        acn.setText("CREATED BY : NEIL NOLASCO ABRAZALDO");
        jPanel1.add(acn, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 720, 320, 20));

        jPanel6.setBackground(new java.awt.Color(0, 51, 75));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(204, 204, 204)), "REPORTS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Stencil", 1, 18), new java.awt.Color(204, 204, 204))); // NOI18N
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        name1.setFont(new java.awt.Font("Stencil", 0, 14)); // NOI18N
        name1.setForeground(new java.awt.Color(255, 255, 255));
        name1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        name1.setText("TOTAL ADMIN ACCOUNT");
        jPanel6.add(name1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 30, 210, 30));

        taa.setFont(new java.awt.Font("Segoe UI Historic", 1, 24)); // NOI18N
        taa.setForeground(new java.awt.Color(0, 153, 102));
        taa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        taa.setText("0");
        jPanel6.add(taa, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 60, 190, 20));

        name4.setFont(new java.awt.Font("Stencil", 0, 14)); // NOI18N
        name4.setForeground(new java.awt.Color(255, 255, 255));
        name4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        name4.setText("TOTAL STAFF ACCOUNT");
        jPanel6.add(name4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 210, 30));

        tsa.setFont(new java.awt.Font("Segoe UI Historic", 1, 24)); // NOI18N
        tsa.setForeground(new java.awt.Color(0, 153, 102));
        tsa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tsa.setText("0");
        jPanel6.add(tsa, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 190, 20));

        tma.setFont(new java.awt.Font("Segoe UI Historic", 1, 24)); // NOI18N
        tma.setForeground(new java.awt.Color(0, 153, 102));
        tma.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tma.setText("0");
        jPanel6.add(tma, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, 210, 20));

        name5.setFont(new java.awt.Font("Stencil", 0, 14)); // NOI18N
        name5.setForeground(new java.awt.Color(255, 255, 255));
        name5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        name5.setText("TOTAL MANAGER ACCOUNT");
        jPanel6.add(name5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, 210, 30));

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 0, 630, 110));

        jPanel7.setBackground(new java.awt.Color(0, 51, 75));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(204, 204, 204)), "STORE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Stencil", 1, 18), new java.awt.Color(204, 204, 204))); // NOI18N
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Stencil", 0, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("jpos");
        jPanel7.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 200, 40));

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, 280, 110));

        jPanel8.setBackground(new java.awt.Color(0, 51, 75));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(204, 204, 204)), "ACCOUNT", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Stencil", 1, 18), new java.awt.Color(204, 204, 204))); // NOI18N
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        staffname.setFont(new java.awt.Font("Stencil", 0, 10)); // NOI18N
        staffname.setForeground(new java.awt.Color(255, 255, 255));
        staffname.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        staffname.setText("ADMIN");
        jPanel8.add(staffname, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 210, 30));

        jLabel6.setFont(new java.awt.Font("Stencil", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Hi ,");
        jPanel8.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 70, 30));

        name.setFont(new java.awt.Font("Stencil", 0, 36)); // NOI18N
        name.setForeground(new java.awt.Color(255, 255, 255));
        name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        name.setText("NAME");
        jPanel8.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 210, 30));

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 420, 110));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 777));

        PAY.setText("Shortcut Key");

        logout.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        logout.setText("Logout");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });
        PAY.add(logout);

        jMenuBar1.add(PAY);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        // TODO add your handling code here:
        String logO = logout.getText();
        if (logO.equalsIgnoreCase("logout")) {
            String getname = name.getText                                 ();
            Date date = new Date                                          ();
            java.sql.Date logoutdate = new java.sql.Date(date.getTime());
            java.sql.Time logouttime = new java.sql.Time(date.getTime());
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/POSDataBase","root","");
            String sql = "SELECT * FROM loginhistory WHERE Username = ?";
            pst = con.prepareCall(sql );
            pst.setString(1, getname);
            rs = pst.executeQuery          ();
            
                        if (rs.next()) {
                                String aID = rs.getString("Account_ID");
                            
                                Class.forName("com.mysql.cj.jdbc.Driver");
                                con = DriverManager.getConnection("jdbc:mysql://localhost/POSDataBase","root","");
                                String sqll = "UPDATE loginhistory SET Logout_Date = ?,Logout_Time = ? WHERE Account_ID = ?";
                                pst = con.prepareStatement(sqll);
                                pst.setDate(1, logoutdate);
                                pst.setTime(2, logouttime);
                                pst.setString(3, aID   );
                                pst.executeUpdate();
                                System.out.println("Logout DATE and Time updated");
                        }
        } catch (Exception e) {
                System.out.println(e);
        }    
                new login().setVisible(true);
                this.dispose();
        }
    }//GEN-LAST:event_logoutActionPerformed

    private void setBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setBTNActionPerformed
        // TODO add your handling code here:
        String setStat = setStatus.getSelectedItem().toString();
        Date date = new Date();
        if (setStat.equals("<Select>")) {

            JOptionPane.showMessageDialog(null, "Please select data on table first or select valid status", "Invalid Input Found", JOptionPane.ERROR_MESSAGE);

        }else {

            DefaultTableModel d1 = (DefaultTableModel)AccountTable.getModel();
            int selectedIndex = AccountTable.getSelectedRow();
            String ID = (d1.getValueAt(selectedIndex, 0).toString());
            java.sql.Date sqldate = new java.sql.Date(date.getTime    ());
            java.sql.Time sqltime = new java.sql.Time(date.getTime    ());

            try {

                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/POSDataBase","root","");
                String sql = "UPDATE employees SET Status = ? WHERE Account_ID = ?";
                pst = con.prepareStatement(sql);
                pst.setString(1, setStat);
                pst.setString(2, ID     );
                pst.executeUpdate              ();
                RegisteredAccountsTable_Update();

                System.out.println("Status updated : Successful");

            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_setBTNActionPerformed

    private void searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyReleased
        // TODO add your handling code here:
        String searchString = search.getText();
        search(searchString);
    }//GEN-LAST:event_searchKeyReleased

    private void registerBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerBTNActionPerformed
        // TODO add your handling code here:
        Date date = new Date();
        String getID = accountID.getText();
        String getUsername = userName.getText();
        String getPassword = pass.getText();
        java.sql.Date sqldate = new java.sql.Date(date.getTime());
        java.sql.Time sqltime = new java.sql.Time(date.getTime());
        String getPosition = position.getSelectedItem().toString();
        String DefaultStatus = "Online";
        

        if (getID.equals("") || getUsername.equals("") || getPosition.equals("<Select>") || getPassword.equals("")) {

            JOptionPane.showMessageDialog(null, "Some field are empty", "Error", JOptionPane.ERROR_MESSAGE);

        }else{
            
            try {
                
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/POSDataBase","root","");
                String sql = "SELECT * FROM employees";
                pst = con.prepareCall(sql);
                rs = pst.executeQuery();
            
                        if (rs.next()) {
                            String ID = rs.getString("Account_ID");
                            String USERNAME = rs.getString("Username");
                                        if (ID.equalsIgnoreCase(getID) || USERNAME.equalsIgnoreCase(getUsername)) {
                                            JOptionPane.showMessageDialog(null, "You have the same account ID or Username");
                                            accountID.setText("");
                                            userName.setText("");
                                        }else {
                                              Class.forName("com.mysql.cj.jdbc.Driver");
                                              con = DriverManager.getConnection("jdbc:mysql://localhost/POSDataBase","root","");
                                              String sqll = "INSERT INTO employees (Account_ID,Username,Password,Registration_Date,Registration_Time,Position,Status) VALUES (?,?,?,?,?,?,?)";
                                              pst = con.prepareStatement(sqll );
                                              pst.setString(1, getID        );
                                              pst.setString(2, getUsername  );
                                              pst.setString(3, getPassword  );
                                              pst.setDate  (4, sqldate        );
                                              pst.setTime  (5, sqltime        );
                                              pst.setString(6, getPosition  );
                                              pst.setString(7, DefaultStatus);
                                              pst.executeUpdate                    ();
                                              accountID.setText(""                );
                                              userName.setText(""                 );
                                              position.setSelectedItem(-1    );
                                              pass.setText(""                     );
                                              accountID.requestFocus               ();
                                              RegisteredAccountsTable_Update       ();
                                              countStaff                           ();
                                              countManager                         ();
                                              countAdmin                           ();
                                              System.out.println("Account Created : Successful");
                                        }
                        }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_registerBTNActionPerformed

    private void accountIDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_accountIDKeyPressed
        
    }//GEN-LAST:event_accountIDKeyPressed

    private void positionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_positionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_positionActionPerformed

    private void passKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_passKeyPressed

    private void accountIDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accountIDMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_accountIDMouseClicked

    private void positionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_positionMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_positionMouseClicked

    private void setStatusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_setStatusMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_setStatusMouseClicked


    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTable AccountTable;
    private javax.swing.JMenu PAY;
    private javax.swing.JTextField accountID;
    private javax.swing.JLabel acn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel l_date;
    private javax.swing.JLabel l_time;
    public static javax.swing.JTable loginHIstoryTable;
    private javax.swing.JMenuItem logout;
    private javax.swing.JLabel name;
    private javax.swing.JLabel name1;
    private javax.swing.JLabel name3;
    private javax.swing.JLabel name4;
    private javax.swing.JLabel name5;
    private javax.swing.JTextField pass;
    private javax.swing.JComboBox<String> position;
    private javax.swing.JButton registerBTN;
    private javax.swing.JTextField search;
    private javax.swing.JButton setBTN;
    private javax.swing.JComboBox<String> setStatus;
    private javax.swing.JLabel staffname;
    private javax.swing.JLabel taa;
    private javax.swing.JLabel tma;
    public static javax.swing.JLabel tsa;
    private javax.swing.JTextField userName;
    // End of variables declaration//GEN-END:variables
}
