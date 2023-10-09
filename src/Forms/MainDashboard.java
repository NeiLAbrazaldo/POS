/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Forms;

import static Forms.AdminDashboard.con;
import static Forms.AdminDashboard.pst;
import static Forms.AdminDashboard.rs;
import static Forms.ManagerDashboard.*;
import static Forms.orderList.*;
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
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;


public class MainDashboard extends javax.swing.JFrame {
    
    
                    Date date = new Date();
                    String cat = "MILKTEA";
                    String Size1,Size2;
                    
                    String Mop,order,staff,PaY;
                    java.sql.Date sqldate = new java.sql.Date(date.getTime());
                    java.sql.Time sqltime = new java.sql.Time(date.getTime());
                    String getQTY1,getQTY2,getQTY3,getQTY4,getQTY5,getQTY6,getQTY7,getQTY8,getQTY9,getQTY10,getQTY11,getQTY12;
                    int qty1,qty2,qty3,qty4,qty5,qq,qty7,qty8,qty9,qty10,qty11,qty12;
                    int total1,total2,total3,total4,total5,total6,total7,total8,total9,total10,total11,total12;
                    
    public MainDashboard() {
        initComponents ();
        dt             ();
        time           ();
        check          ();
        checkOrderSlot1();
        checkOrderSlot2();
        /*
        TableActionEvent event = new TableActionEvent(){
        public void onEdit (int row){
            System.out.println("Edit row : " + row);
        }
        public void onDelete (int row){
            if(MainTable.isEditing()){
            MainTable.getCellEditor().stopCellEditing();
        }
        }
        public void onView (int row){
            System.out.println("View row : " + row);
        }
    };
            MainTable.getColumnModel().getColumn(4).setCellRenderer(new TableActionCellRender());
            MainTable.getColumnModel().getColumn(4).setCellEditor(new TableActionCellEditor(event));
        */
    }
    MainDashboard (String an) {
                    this();
                    name.setText(an);
    }
    
    static Connection con       ;
    static PreparedStatement pst;
    static ResultSet rs         ;
    Timer t                     ;
    SimpleDateFormat st         ;
    
    
    public void dt () {
        
                            Date date = new Date();    
                            SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");

                            String dd = sdf.format(date);
                            l_date.setText(dd);
    
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
                        }
    

    public void check () {
    data d = new data();
    int id = 24001;
    try {
             
         Class.forName("com.mysql.cj.jdbc.Driver");
         con = DriverManager.getConnection("jdbc:mysql://localhost/POSDataBase","root","");
         String sql = "SELECT * FROM statusmanagement ";
         pst = con.prepareStatement(sql);
         rs = pst.executeQuery();
         if(rs.next()){
            int getID = rs.getInt("ID");
                                                                                        
                      if (getID == d.milkteaID[0]) {
                          String getstat = rs.getString("Status");
                                                 if (getstat.equals("Unavailable")) {
                                                     tapsilog.setForeground(Color.red);
                                                     btn1.setEnabled(false);
                                                     q1.disable();
                                                     System.out.println("DARK CHOCOLATE : Unavailable");
                                                  }
                                                                                        
                       }else if (getID == d.milkteaID[1]) {
                                String getstat = rs.getString("Status");
                                                               if (getstat.equals("Unavailable")) {
                                                                   hungariansilog.setForeground(Color.red);
                                                                   btn2.setEnabled(false);
                                                                   q2.disable();
                                                                   System.out.println("OKINAWA : Unavailable");
                                                               }
                       }
         }
        } catch (Exception e) {
                System.out.println(e);
        } 
    }
    
    public void checkOrderSlot1(){
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/POSDataBase","root","");
            String sql = "SELECT count(ITEM) FROM orderlist1";
            pst = con.prepareCall(sql);
            rs = pst.executeQuery();
            
                        if (rs.next()) {
                            String getItem = rs.getString("count(ITEM)");
                            int convertItemIntoInteger = Integer.parseInt(getItem);
                            if (convertItemIntoInteger > 0){
                            or1.setForeground(Color.GREEN);
                            }
                        }
        }catch (Exception e){
        
        System.out.println(e);
        
        }
    }
    
    public void checkOrderSlot2(){
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/POSDataBase","root","");
            String sql = "SELECT count(ITEM) FROM orderlist2";
            pst = con.prepareCall(sql);
            rs = pst.executeQuery();
            
                        if (rs.next()) {
                            String getItem = rs.getString("count(ITEM)");
                            int convertItemIntoInteger = Integer.parseInt(getItem);
                            if (convertItemIntoInteger > 0){
                            or2.setForeground(Color.GREEN);
                            }
                        }
        }catch (Exception e){
        
        System.out.println(e);
        
        }
    }
    
    public void ord1table_update(){
    
     try {
         
            int c;
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/POSDataBase","root","");
            String sql = "SELECT * FROM orderlist1";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            ResultSetMetaData rsd = rs.getMetaData();
            c = rsd.getColumnCount();
            
            DefaultTableModel d = (DefaultTableModel)order1.getModel();
            d.setRowCount(0);
            
            while (rs.next()) {
            
                Vector v2 = new Vector();
                for(int i= 1;i<=c; i++){
                
                v2.add(rs.getString("ITEM"    ));
                v2.add(rs.getString("SIZE"    ));
                v2.add(rs.getString("QUANTITY"));
                
                
                }
                d.addRow(v2);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
   }
    
    public void ord2table_update(){
    
     try {
         
            int c;
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/POSDataBase","root","");
            String sql = "SELECT * FROM orderlist2";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            ResultSetMetaData rsd = rs.getMetaData();
            c = rsd.getColumnCount();
            
            DefaultTableModel d = (DefaultTableModel)order2.getModel();
            d.setRowCount(0);
            
            while (rs.next()) {
            
                Vector v2 = new Vector();
                for(int i= 1;i<=c; i++){
                
                v2.add(rs.getString("ITEM"    ));
                v2.add(rs.getString("SIZE"    ));
                v2.add(rs.getString("QUANTITY"));
                
                
                }
                d.addRow(v2);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
   }
    
    public void ord3table_update(){
    
     try {
         
            int c;
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/POSDataBase","root","");
            String sql = "SELECT * FROM orderlist3";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            ResultSetMetaData rsd = rs.getMetaData();
            c = rsd.getColumnCount();
            
            DefaultTableModel d = (DefaultTableModel)order03.getModel();
            d.setRowCount(0);
            
            while (rs.next()) {
            
                Vector v2 = new Vector();
                for(int i= 1;i<=c; i++){
                
                v2.add(rs.getString("ITEM"    ));
                v2.add(rs.getString("SIZE"    ));
                v2.add(rs.getString("QUANTITY"));
                
                
                }
                d.addRow(v2);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
   }
    
    public void ord4table_update(){
    
     try {
         
            int c;
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/POSDataBase","root","");
            String sql = "SELECT * FROM orderlist4";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            ResultSetMetaData rsd = rs.getMetaData();
            c = rsd.getColumnCount();
            
            DefaultTableModel d = (DefaultTableModel)order4.getModel();
            d.setRowCount(0);
            
            while (rs.next()) {
            
                Vector v2 = new Vector();
                for(int i= 1;i<=c; i++){
                
                v2.add(rs.getString("ITEM"    ));
                v2.add(rs.getString("SIZE"    ));
                v2.add(rs.getString("QUANTITY"));
                
                
                }
                d.addRow(v2);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
   }
    
    public void ord5table_update(){
    
     try {
         
            int c;
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/POSDataBase","root","");
            String sql = "SELECT * FROM orderlist5";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            ResultSetMetaData rsd = rs.getMetaData();
            c = rsd.getColumnCount();
            
            DefaultTableModel d = (DefaultTableModel)order5.getModel();
            d.setRowCount(0);
            
            while (rs.next()) {
            
                Vector v2 = new Vector();
                for(int i= 1;i<=c; i++){
                
                v2.add(rs.getString("ITEM"    ));
                v2.add(rs.getString("SIZE"    ));
                v2.add(rs.getString("QUANTITY"));
                
                
                }
                d.addRow(v2);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
   }
    
    public void ord6table_update(){
    
     try {
         
            int c;
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/POSDataBase","root","");
            String sql = "SELECT * FROM orderlist6";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            ResultSetMetaData rsd = rs.getMetaData();
            c = rsd.getColumnCount();
            
            DefaultTableModel d = (DefaultTableModel)order6.getModel();
            d.setRowCount(0);
            
            while (rs.next()) {
            
                Vector v2 = new Vector();
                for(int i= 1;i<=c; i++){
                
                v2.add(rs.getString("ITEM"    ));
                v2.add(rs.getString("SIZE"    ));
                v2.add(rs.getString("QUANTITY"));
                
                
                }
                d.addRow(v2);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
   }
    
    public void ord7table_update(){
    
     try {
         
            int c;
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/POSDataBase","root","");
            String sql = "SELECT * FROM orderlist7";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            ResultSetMetaData rsd = rs.getMetaData();
            c = rsd.getColumnCount();
            
            DefaultTableModel d = (DefaultTableModel)order7.getModel();
            d.setRowCount(0);
            
            while (rs.next()) {
            
                Vector v2 = new Vector();
                for(int i= 1;i<=c; i++){
                
                v2.add(rs.getString("ITEM"    ));
                v2.add(rs.getString("SIZE"    ));
                v2.add(rs.getString("QUANTITY"));
                
                
                }
                d.addRow(v2);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
   }
    
    public void ord8table_update(){
    
     try {
         
            int c;
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/POSDataBase","root","");
            String sql = "SELECT * FROM orderlist8";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            ResultSetMetaData rsd = rs.getMetaData();
            c = rsd.getColumnCount();
            
            DefaultTableModel d = (DefaultTableModel)order8.getModel();
            d.setRowCount(0);
            
            while (rs.next()) {
            
                Vector v2 = new Vector();
                for(int i= 1;i<=c; i++){
                
                v2.add(rs.getString("ITEM"    ));
                v2.add(rs.getString("SIZE"    ));
                v2.add(rs.getString("QUANTITY"));
                
                
                }
                d.addRow(v2);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
   }
    
    public void orderHistoryTable_Update(){
    
     try {
         
            int c;
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/POSDataBase","root","");
            String sql = "SELECT * FROM orderhistory";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            ResultSetMetaData rsd = rs.getMetaData();
            c = rsd.getColumnCount();
            
            DefaultTableModel d1 = (DefaultTableModel)orderHistory.getModel();
            d1.setRowCount(0);
            
            while (rs.next()) {
            
                Vector v2 = new Vector();
                for(int i= 1;i<=c; i++){
                v2.add(rs.getString("ID"      ));
                v2.add(rs.getString("NAME"    ));
                v2.add(rs.getString("CATEGORY"));
                v2.add(rs.getString("SIZE"    ));
                v2.add(rs.getString("DATE"    ));
                v2.add(rs.getString("TIME"    ));
                v2.add(rs.getString("MOP"     ));
                v2.add(rs.getString("QTY"     ));
                v2.add(rs.getString("PRICE"   ));
                v2.add(rs.getString("STAFF"   ));
                
                }
                d1.addRow(v2);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
   }
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        totalcost = new javax.swing.JPanel();
        tapsilog = new javax.swing.JLabel();
        q1 = new javax.swing.JTextField();
        btn1 = new javax.swing.JButton();
        hungariansilog = new javax.swing.JLabel();
        q2 = new javax.swing.JTextField();
        btn2 = new javax.swing.JButton();
        staffname18 = new javax.swing.JLabel();
        hungariansilog1 = new javax.swing.JLabel();
        q3 = new javax.swing.JTextField();
        btn3 = new javax.swing.JButton();
        hungariansilog2 = new javax.swing.JLabel();
        q4 = new javax.swing.JTextField();
        btn4 = new javax.swing.JButton();
        hungariansilog3 = new javax.swing.JLabel();
        q5 = new javax.swing.JTextField();
        btn5 = new javax.swing.JButton();
        hungariansilog4 = new javax.swing.JLabel();
        q6 = new javax.swing.JTextField();
        btn6 = new javax.swing.JButton();
        hungariansilog5 = new javax.swing.JLabel();
        q7 = new javax.swing.JTextField();
        btn7 = new javax.swing.JButton();
        hungariansilog6 = new javax.swing.JLabel();
        q8 = new javax.swing.JTextField();
        btn8 = new javax.swing.JButton();
        hungariansilog7 = new javax.swing.JLabel();
        q9 = new javax.swing.JTextField();
        btn9 = new javax.swing.JButton();
        hungariansilog8 = new javax.swing.JLabel();
        q10 = new javax.swing.JTextField();
        btn10 = new javax.swing.JButton();
        s1 = new javax.swing.JComboBox<>();
        s2 = new javax.swing.JComboBox<>();
        s3 = new javax.swing.JComboBox<>();
        s4 = new javax.swing.JComboBox<>();
        s5 = new javax.swing.JComboBox<>();
        s6 = new javax.swing.JComboBox<>();
        s7 = new javax.swing.JComboBox<>();
        s8 = new javax.swing.JComboBox<>();
        s9 = new javax.swing.JComboBox<>();
        s10 = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        billl = new javax.swing.JTextPane();
        jPanel4 = new javax.swing.JPanel();
        Option = new javax.swing.JComboBox<>();
        staffname1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        total = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        MainTable = new javax.swing.JTable();
        l_time = new javax.swing.JLabel();
        l_date = new javax.swing.JLabel();
        acn = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        btnPRINT = new javax.swing.JButton();
        btnPAY = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        mop = new javax.swing.JComboBox<>();
        change = new javax.swing.JLabel();
        pay = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        name = new javax.swing.JLabel();
        staffname2 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        or4 = new javax.swing.JLabel();
        or1 = new javax.swing.JLabel();
        or2 = new javax.swing.JLabel();
        or3 = new javax.swing.JLabel();
        or5 = new javax.swing.JLabel();
        or6 = new javax.swing.JLabel();
        or7 = new javax.swing.JLabel();
        or8 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        PAY = new javax.swing.JMenu();
        cont = new javax.swing.JMenuItem();
        logout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 51, 75));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 51, 75));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(204, 204, 204)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        totalcost.setBackground(new java.awt.Color(0, 51, 75));
        totalcost.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(204, 204, 204)));
        totalcost.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tapsilog.setFont(new java.awt.Font("Stencil", 0, 14)); // NOI18N
        tapsilog.setForeground(new java.awt.Color(255, 255, 255));
        tapsilog.setText("DARK CHOCOLATE");
        totalcost.add(tapsilog, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, 20));

        q1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        q1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                q1KeyPressed(evt);
            }
        });
        totalcost.add(q1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 80, -1));

        btn1.setBackground(new java.awt.Color(51, 255, 51));
        btn1.setFont(new java.awt.Font("Nirmala UI", 1, 10)); // NOI18N
        btn1.setText("add");
        btn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn1MouseClicked(evt);
            }
        });
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });
        totalcost.add(btn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 70, 60, -1));

        hungariansilog.setFont(new java.awt.Font("Stencil", 0, 14)); // NOI18N
        hungariansilog.setForeground(new java.awt.Color(255, 255, 255));
        hungariansilog.setText("OKINAWA");
        totalcost.add(hungariansilog, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, 20));

        q2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        q2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                q2KeyPressed(evt);
            }
        });
        totalcost.add(q2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 80, -1));

        btn2.setBackground(new java.awt.Color(51, 255, 51));
        btn2.setFont(new java.awt.Font("Nirmala UI", 1, 10)); // NOI18N
        btn2.setText("add");
        btn2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn2MouseClicked(evt);
            }
        });
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });
        totalcost.add(btn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 110, 60, -1));

        staffname18.setFont(new java.awt.Font("Stencil", 0, 25)); // NOI18N
        staffname18.setForeground(new java.awt.Color(153, 153, 153));
        staffname18.setText("ORDER MENU");
        totalcost.add(staffname18, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 160, 30));

        hungariansilog1.setFont(new java.awt.Font("Stencil", 0, 14)); // NOI18N
        hungariansilog1.setForeground(new java.awt.Color(255, 255, 255));
        hungariansilog1.setText("WINTERMELON");
        totalcost.add(hungariansilog1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, 20));

        q3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        q3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                q3KeyPressed(evt);
            }
        });
        totalcost.add(q3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 80, -1));

        btn3.setBackground(new java.awt.Color(51, 255, 51));
        btn3.setFont(new java.awt.Font("Nirmala UI", 1, 10)); // NOI18N
        btn3.setText("add");
        btn3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn3MouseClicked(evt);
            }
        });
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });
        totalcost.add(btn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 150, 60, -1));

        hungariansilog2.setFont(new java.awt.Font("Stencil", 0, 14)); // NOI18N
        hungariansilog2.setForeground(new java.awt.Color(255, 255, 255));
        hungariansilog2.setText("CHEESECAKE");
        totalcost.add(hungariansilog2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, 20));

        q4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        q4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                q4KeyPressed(evt);
            }
        });
        totalcost.add(q4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, 80, -1));

        btn4.setBackground(new java.awt.Color(51, 255, 51));
        btn4.setFont(new java.awt.Font("Nirmala UI", 1, 10)); // NOI18N
        btn4.setText("add");
        btn4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn4MouseClicked(evt);
            }
        });
        btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4ActionPerformed(evt);
            }
        });
        totalcost.add(btn4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 190, 60, -1));

        hungariansilog3.setFont(new java.awt.Font("Stencil", 0, 14)); // NOI18N
        hungariansilog3.setForeground(new java.awt.Color(255, 255, 255));
        hungariansilog3.setText("COOKIES n cream");
        totalcost.add(hungariansilog3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, 20));

        q5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        q5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                q5KeyPressed(evt);
            }
        });
        totalcost.add(q5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, 80, -1));

        btn5.setBackground(new java.awt.Color(51, 255, 51));
        btn5.setFont(new java.awt.Font("Nirmala UI", 1, 10)); // NOI18N
        btn5.setText("add");
        btn5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn5MouseClicked(evt);
            }
        });
        btn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn5ActionPerformed(evt);
            }
        });
        totalcost.add(btn5, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 230, 60, -1));

        hungariansilog4.setFont(new java.awt.Font("Stencil", 0, 14)); // NOI18N
        hungariansilog4.setForeground(new java.awt.Color(255, 255, 255));
        hungariansilog4.setText("salted caramel");
        totalcost.add(hungariansilog4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, 20));

        q6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        q6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                q6KeyPressed(evt);
            }
        });
        totalcost.add(q6, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 270, 80, -1));

        btn6.setBackground(new java.awt.Color(51, 255, 51));
        btn6.setFont(new java.awt.Font("Nirmala UI", 1, 10)); // NOI18N
        btn6.setText("add");
        btn6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn6MouseClicked(evt);
            }
        });
        btn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn6ActionPerformed(evt);
            }
        });
        totalcost.add(btn6, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 270, 60, -1));

        hungariansilog5.setFont(new java.awt.Font("Stencil", 0, 14)); // NOI18N
        hungariansilog5.setForeground(new java.awt.Color(255, 255, 255));
        hungariansilog5.setText("TARO");
        totalcost.add(hungariansilog5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, -1, 20));

        q7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        q7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                q7KeyPressed(evt);
            }
        });
        totalcost.add(q7, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 310, 80, -1));

        btn7.setBackground(new java.awt.Color(51, 255, 51));
        btn7.setFont(new java.awt.Font("Nirmala UI", 1, 10)); // NOI18N
        btn7.setText("add");
        btn7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn7MouseClicked(evt);
            }
        });
        btn7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn7ActionPerformed(evt);
            }
        });
        totalcost.add(btn7, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 310, 60, -1));

        hungariansilog6.setFont(new java.awt.Font("Stencil", 0, 14)); // NOI18N
        hungariansilog6.setForeground(new java.awt.Color(255, 255, 255));
        hungariansilog6.setText("MATCHA");
        totalcost.add(hungariansilog6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, -1, 20));

        q8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        q8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                q8KeyPressed(evt);
            }
        });
        totalcost.add(q8, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 350, 80, -1));

        btn8.setBackground(new java.awt.Color(51, 255, 51));
        btn8.setFont(new java.awt.Font("Nirmala UI", 1, 10)); // NOI18N
        btn8.setText("add");
        btn8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn8MouseClicked(evt);
            }
        });
        btn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn8ActionPerformed(evt);
            }
        });
        totalcost.add(btn8, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 350, 60, -1));

        hungariansilog7.setFont(new java.awt.Font("Stencil", 0, 14)); // NOI18N
        hungariansilog7.setForeground(new java.awt.Color(255, 255, 255));
        hungariansilog7.setText("STRAWBERRY");
        totalcost.add(hungariansilog7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, -1, 20));

        q9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        q9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                q9KeyPressed(evt);
            }
        });
        totalcost.add(q9, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 390, 80, -1));

        btn9.setBackground(new java.awt.Color(51, 255, 51));
        btn9.setFont(new java.awt.Font("Nirmala UI", 1, 10)); // NOI18N
        btn9.setText("add");
        btn9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn9MouseClicked(evt);
            }
        });
        btn9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn9ActionPerformed(evt);
            }
        });
        totalcost.add(btn9, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 390, 60, -1));

        hungariansilog8.setFont(new java.awt.Font("Stencil", 0, 14)); // NOI18N
        hungariansilog8.setForeground(new java.awt.Color(255, 255, 255));
        hungariansilog8.setText("CLASSIC");
        totalcost.add(hungariansilog8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, -1, 20));

        q10.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        q10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                q10KeyPressed(evt);
            }
        });
        totalcost.add(q10, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 430, 80, -1));

        btn10.setBackground(new java.awt.Color(51, 255, 51));
        btn10.setFont(new java.awt.Font("Nirmala UI", 1, 10)); // NOI18N
        btn10.setText("add");
        btn10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn10MouseClicked(evt);
            }
        });
        btn10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn10ActionPerformed(evt);
            }
        });
        totalcost.add(btn10, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 430, 60, -1));

        s1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        s1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "M", "L", "1L" }));
        s1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s1ActionPerformed(evt);
            }
        });
        s1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                s1KeyPressed(evt);
            }
        });
        totalcost.add(s1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, 80, -1));

        s2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        s2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "M", "L", "1L" }));
        s2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s2ActionPerformed(evt);
            }
        });
        s2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                s2KeyPressed(evt);
            }
        });
        totalcost.add(s2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 430, 80, -1));

        s3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        s3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "M", "L", "1L" }));
        s3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s3ActionPerformed(evt);
            }
        });
        s3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                s3KeyPressed(evt);
            }
        });
        totalcost.add(s3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 110, 80, -1));

        s4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        s4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "M", "L", "1L" }));
        s4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s4ActionPerformed(evt);
            }
        });
        s4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                s4KeyPressed(evt);
            }
        });
        totalcost.add(s4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 150, 80, -1));

        s5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        s5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "M", "L", "1L" }));
        s5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s5ActionPerformed(evt);
            }
        });
        s5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                s5KeyPressed(evt);
            }
        });
        totalcost.add(s5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 190, 80, -1));

        s6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        s6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "M", "L", "1L" }));
        s6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s6ActionPerformed(evt);
            }
        });
        s6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                s6KeyPressed(evt);
            }
        });
        totalcost.add(s6, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 230, 80, -1));

        s7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        s7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "M", "L", "1L" }));
        s7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s7ActionPerformed(evt);
            }
        });
        s7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                s7KeyPressed(evt);
            }
        });
        totalcost.add(s7, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 270, 80, -1));

        s8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        s8.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "M", "L", "1L" }));
        s8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s8ActionPerformed(evt);
            }
        });
        s8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                s8KeyPressed(evt);
            }
        });
        totalcost.add(s8, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 310, 80, -1));

        s9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        s9.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "M", "L", "1L" }));
        s9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s9ActionPerformed(evt);
            }
        });
        s9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                s9KeyPressed(evt);
            }
        });
        totalcost.add(s9, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 350, 80, -1));

        s10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        s10.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "M", "L", "1L" }));
        s10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s10ActionPerformed(evt);
            }
        });
        s10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                s10KeyPressed(evt);
            }
        });
        totalcost.add(s10, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 390, 80, -1));

        jPanel2.add(totalcost, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 470, 550));

        jPanel3.setBackground(new java.awt.Color(0, 51, 75));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(204, 204, 204)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        billl.setEditable(false);
        billl.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N
        jScrollPane2.setViewportView(billl);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 300, 490));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 80, 320, 510));

        jPanel4.setBackground(new java.awt.Color(0, 51, 75));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(204, 204, 204)));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Option.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Option.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<select>", "order1", "order2", "order3", "order4", "order5", "order6", "order7", "order8" }));
        Option.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                OptionKeyPressed(evt);
            }
        });
        jPanel4.add(Option, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 100, -1));

        staffname1.setFont(new java.awt.Font("Stencil", 0, 10)); // NOI18N
        staffname1.setForeground(new java.awt.Color(255, 255, 255));
        staffname1.setText("order #");
        jPanel4.add(staffname1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 20));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 10, 140, 70));

        jPanel5.setBackground(new java.awt.Color(0, 51, 75));
        jPanel5.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(204, 204, 204)));
        jPanel5.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        total.setFont(new java.awt.Font("DialogInput", 1, 24)); // NOI18N
        total.setForeground(new java.awt.Color(0, 153, 102));
        total.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        total.setText("0");
        jPanel5.add(total, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 80, 30));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("TOTAL COST :");
        jPanel5.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 80, 20));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("₱");
        jPanel5.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 20, 30));

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 10, 180, 70));

        MainTable.setFont(new java.awt.Font("Nirmala UI", 1, 10)); // NOI18N
        MainTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ITEM", "SIZE", "QTY", "PRICE"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        MainTable.setRowHeight(30);
        jScrollPane1.setViewportView(MainTable);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 20, 470, 550));

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
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(204, 204, 204)), "BILLING SECTION", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Stencil", 0, 14), new java.awt.Color(204, 204, 204))); // NOI18N
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnPRINT.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnPRINT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesAndGIF/print btnn.png"))); // NOI18N
        btnPRINT.setText("PRINT");
        btnPRINT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPRINTActionPerformed(evt);
            }
        });
        jPanel6.add(btnPRINT, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 70, 130, 30));

        btnPAY.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnPAY.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagesAndGIF/payy.png"))); // NOI18N
        btnPAY.setText("PAYMENT");
        btnPAY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPAYActionPerformed(evt);
            }
        });
        jPanel6.add(btnPAY, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 30, 130, 30));

        jLabel3.setFont(new java.awt.Font("MS Gothic", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("MODE OF PAYMENT");
        jPanel6.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, -1, 20));

        jLabel4.setFont(new java.awt.Font("MS Gothic", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("TENDERED AMOUNT (₱)");
        jPanel6.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jLabel7.setFont(new java.awt.Font("MS Gothic", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("CHANGE (₱)");
        jPanel6.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, -1, -1));

        mop.setFont(new java.awt.Font("MS UI Gothic", 1, 14)); // NOI18N
        mop.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<SELECT>", "CASH", "GCASH", "COD" }));
        mop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mopActionPerformed(evt);
            }
        });
        jPanel6.add(mop, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 50, 110, 30));

        change.setFont(new java.awt.Font("DialogInput", 1, 24)); // NOI18N
        change.setForeground(new java.awt.Color(0, 153, 102));
        change.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        change.setText("0");
        jPanel6.add(change, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, 90, 30));

        pay.setFont(new java.awt.Font("MS UI Gothic", 1, 14)); // NOI18N
        pay.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pay.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                payKeyPressed(evt);
            }
        });
        jPanel6.add(pay, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 90, 30));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("₱");
        jPanel6.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 20, 30));

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 0, 630, 110));

        jPanel7.setBackground(new java.awt.Color(0, 51, 75));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(204, 204, 204)), "STORE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Stencil", 0, 14), new java.awt.Color(204, 204, 204))); // NOI18N
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Stencil", 0, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("JPOS");
        jPanel7.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 190, 40));

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, 280, 110));

        jPanel8.setBackground(new java.awt.Color(0, 51, 75));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(204, 204, 204)), "ACCOUNT", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Stencil", 0, 14), new java.awt.Color(204, 204, 204))); // NOI18N
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        name.setFont(new java.awt.Font("Stencil", 0, 14)); // NOI18N
        name.setForeground(new java.awt.Color(255, 255, 255));
        name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        name.setText("NAME");
        jPanel8.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 150, 20));

        staffname2.setFont(new java.awt.Font("Stencil", 0, 10)); // NOI18N
        staffname2.setForeground(new java.awt.Color(255, 255, 255));
        staffname2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        staffname2.setText("STAFF             :");
        jPanel8.add(staffname2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 100, 20));

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 260, 50));

        jPanel9.setBackground(new java.awt.Color(0, 51, 75));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(204, 204, 204)), "ORDER SLOT", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Stencil", 0, 14), new java.awt.Color(204, 204, 204))); // NOI18N
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        or4.setFont(new java.awt.Font("Stencil", 0, 14)); // NOI18N
        or4.setForeground(new java.awt.Color(255, 255, 255));
        or4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        or4.setText("4");
        jPanel9.add(or4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 50, 30));

        or1.setFont(new java.awt.Font("Stencil", 0, 14)); // NOI18N
        or1.setForeground(new java.awt.Color(255, 255, 255));
        or1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        or1.setText("1");
        jPanel9.add(or1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 50, 30));

        or2.setFont(new java.awt.Font("Stencil", 0, 14)); // NOI18N
        or2.setForeground(new java.awt.Color(255, 255, 255));
        or2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        or2.setText("2");
        jPanel9.add(or2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 50, 30));

        or3.setFont(new java.awt.Font("Stencil", 0, 14)); // NOI18N
        or3.setForeground(new java.awt.Color(255, 255, 255));
        or3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        or3.setText("3");
        jPanel9.add(or3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 50, 30));

        or5.setFont(new java.awt.Font("Stencil", 0, 14)); // NOI18N
        or5.setForeground(new java.awt.Color(255, 255, 255));
        or5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        or5.setText(" 5");
        jPanel9.add(or5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, 50, 30));

        or6.setFont(new java.awt.Font("Stencil", 0, 14)); // NOI18N
        or6.setForeground(new java.awt.Color(255, 255, 255));
        or6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        or6.setText("6");
        jPanel9.add(or6, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, 50, 30));

        or7.setFont(new java.awt.Font("Stencil", 0, 14)); // NOI18N
        or7.setForeground(new java.awt.Color(255, 255, 255));
        or7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        or7.setText("7");
        jPanel9.add(or7, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, 50, 30));

        or8.setFont(new java.awt.Font("Stencil", 0, 14)); // NOI18N
        or8.setForeground(new java.awt.Color(255, 255, 255));
        or8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        or8.setText("8");
        jPanel9.add(or8, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, 50, 30));

        jPanel1.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 420, 60));

        jButton2.setBackground(new java.awt.Color(0, 51, 75));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("ORDER LIST");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 70, 140, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 777));

        PAY.setText("Shortcut Key");

        cont.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ENTER, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        cont.setText("Continue");
        cont.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contActionPerformed(evt);
            }
        });
        PAY.add(cont);

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

    private void contActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contActionPerformed
        // TODO add your handling code here:
        String contin = cont.getText();
        if (contin.equalsIgnoreCase("Continue")) {
            this.setVisible(false);
          String staff = name.getText();  
        new MainDashboard(staff).setVisible(true);
        }
        
    }//GEN-LAST:event_contActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        // TODO add your handling code here:
        String logO = logout.getText();
        if (logO.equalsIgnoreCase("logout")) {
                                    
            String staff = name.getText();
            Date date = new Date();
            java.sql.Date logoutdate = new java.sql.Date(date.getTime());
            java.sql.Time logouttime = new java.sql.Time(date.getTime());
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/POSDataBase","root","");
            String sql = "SELECT * FROM loginhistory WHERE Username = ?";
            pst = con.prepareCall(sql);
            pst.setString(1, staff);
            rs = pst.executeQuery();
            
                        if (rs.next()) {
                                String aID = rs.getString("Account_ID");
                            
                                Class.forName("com.mysql.cj.jdbc.Driver");
                                con = DriverManager.getConnection("jdbc:mysql://localhost/POSDataBase","root","");
                                String sqll = "UPDATE loginhistory SET Logout_Date = ?,Logout_Time = ? WHERE Account_ID = ?";
                                pst = con.prepareStatement(sqll);

                                pst.setDate(1, logoutdate);
                                pst.setTime(2, logouttime);
                                pst.setString(3, aID);
                                
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

    private void OptionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_OptionKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_OptionKeyPressed

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        // TODO add your handling code here:
                    data d = new data();
                    
                    order = Option.getSelectedItem().toString();
                    
                   if (order.equals("<select>")) {
                        JOptionPane.showMessageDialog(null, "Choose order number first then input quantity", "Instruction", JOptionPane.ERROR_MESSAGE);
                    }else{
                        Size1 = s1.getSelectedItem().toString();
                        getQTY1= q1.getText();
                        qty1=Integer.parseInt(getQTY1);
                        
                        
                        if(Size1.equalsIgnoreCase("M")){
                        total1= d.mediumPrice * qty1;   
                        MainDashboard.addrow(new Object[] {d.milkteaProduct[0],Size1,getQTY1,total1});
                        cal(); 
                        
                        
                        }else if(Size1.equalsIgnoreCase("L")) {
                        total1= d.largePrice * qty1;  
                        MainDashboard.addrow(new Object[] {d.milkteaProduct[0],Size1,getQTY1,total1});
                        cal(); 
                        
                        
                        }else if(Size1.equalsIgnoreCase("1L")) {
                        total1= d.oneLiterPrice * qty1;  
                        MainDashboard.addrow(new Object[] {d.milkteaProduct[0],Size1,getQTY1,total1});
                        cal(); 
                        
                        
                        }
                        
                        
                    }
    }//GEN-LAST:event_btn1ActionPerformed

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
        // TODO add your handling code here:
                    data d = new data();
                    
                    order = Option.getSelectedItem().toString();
                    
                    if (order.equals("<select>")) {
                        JOptionPane.showMessageDialog(null, "Please Select Order Number First", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                    }else{
                        Size2 = s3.getSelectedItem().toString();
                        getQTY2= q2.getText();
                        qty2=Integer.parseInt(getQTY2);
                        
                        
                        if(Size2.equalsIgnoreCase("M")){
                        total2= d.mediumPrice * qty2;   
                        MainDashboard.addrow(new Object[] {d.milkteaProduct[8],Size2,getQTY2,total2});
                        cal(); 
                        
                        
                        }else if(Size2.equalsIgnoreCase("L")) {
                        total2= d.largePrice * qty2;  
                        MainDashboard.addrow(new Object[] {d.milkteaProduct[8],Size2,getQTY2,total2});
                        cal(); 
                        
                        
                        }else if(Size2.equalsIgnoreCase("1L")) {
                        total2= d.oneLiterPrice * qty2;  
                        MainDashboard.addrow(new Object[] {d.milkteaProduct[8],Size2,getQTY2,total2});
                        cal(); 
                        
                        
                        }
                    }
    }//GEN-LAST:event_btn2ActionPerformed

    private void q1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_q1KeyPressed
        // TODO add your handling code here:
        String quantity = q1.getText();
        
        int length = quantity.length();
        char c = evt.getKeyChar();
        
        if(evt.getKeyChar() >= '0' && evt.getKeyChar() <='9'){
            if (length <3){
            q1.setEditable(true);
            }else {
            q1.setEditable(false);
            }
        }else {
            
            if(evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE){
                q1.setEditable(true);
            }else {
                q1.setEditable(false);
            }
        }
        /*char c = evt.getKeyChar();
        if(Character.isLetter(c) || Character.isWhitespace(c) || Character.isISOControl(c)){
        qty.setEditable(true);
        
        }else{
        qty.setEditable(false);
        }*/
    }//GEN-LAST:event_q1KeyPressed

    private void btn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn1MouseClicked
       
    }//GEN-LAST:event_btn1MouseClicked

    private void btn2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn2MouseClicked
        // TODO add your handling code here:
       
    }//GEN-LAST:event_btn2MouseClicked

    private void q2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_q2KeyPressed
        // TODO add your handling code here:
        String quantity = q1.getText();
        
        int length = quantity.length();
        char c = evt.getKeyChar();
        
        if(evt.getKeyChar() >= '0' && evt.getKeyChar() <='9'){
            if (length <3){
            q1.setEditable(true);
            }else {
            q1.setEditable(false);
            }
        }else {
            
            if(evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE){
                q1.setEditable(true);
            }else {
                q1.setEditable(false);
            }
        }
    }//GEN-LAST:event_q2KeyPressed

    private void btnPAYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPAYActionPerformed
        // TODO add your handling code here:
        data d = new data();
        
        staff = name.getText                     ();
        PaY =   pay.getText                      ();
        Mop =   mop.getSelectedItem().toString   ();
        order = Option.getSelectedItem().toString();
        
        if(Mop.equals("<SELECT>") || PaY.equals("") || order.equals("<select>")){
            JOptionPane.showMessageDialog(rootPane, "Some Field Are Empty", "System Error", JOptionPane.ERROR_MESSAGE);
        }else {
                String value = change.getText           ();
                String totalll = total.getText          ();
                int negative = Integer.parseInt(value  );
                int totalA =   Integer.parseInt(totalll);
                int cash =     Integer.parseInt(PaY    );
                
                int Change = cash - totalA;

                change.setText(String.valueOf(Change));
                
                
                        if (negative < 0) {
                            change.setForeground(Color.red);
                            JOptionPane.showMessageDialog(null, "Insufficient Amount", "System Error", JOptionPane.ERROR_MESSAGE);
                        }else if (order.equalsIgnoreCase("order1")){
                            int numRow = MainTable.getRowCount();
                            
                            for (int i = 0; i < numRow; i++){
                                DefaultTableModel dtm = (DefaultTableModel) MainTable.getModel();
                                String getitem = dtm.getValueAt(i, 0).toString();
                                String getsize = dtm.getValueAt(i, 1).toString();
                                String getqty =  dtm.getValueAt(i, 2).toString();
                                
                                MainDashboard.ord1(getitem,getsize,getqty);
                                
                                if (getitem.equals("DARKCHOCO")){
                                    orderHistory(d.milkteaID[0]      ,d.milkteaProduct[0],cat,Size1,sqldate,sqltime,Mop,qty1,total1,staff);
                                }else if (getitem.equals("OKINAWA**")){
                                    orderHistory(d.milkteaID[1]      ,d.milkteaProduct[8],cat,Size2,sqldate,sqltime,Mop,qty2,total2,staff);
                                }
                            }
                       }else if (order.equalsIgnoreCase("order2")){
                            int numRow = MainTable.getRowCount();
                            
                            for (int i = 0; i < numRow; i++){
                                DefaultTableModel dtm = (DefaultTableModel) MainTable.getModel();
                                String getitem = dtm.getValueAt(i, 0).toString();
                                String getsize = dtm.getValueAt(i, 1).toString();
                                String getqty =  dtm.getValueAt(i, 2).toString();
                                
                                MainDashboard.ord2(getitem,getsize,getqty);
                                
                                if (getitem.equals("DARKCHOCO")){
                                    orderHistory(d.milkteaID[0]      ,d.milkteaProduct[0]      ,cat,Size1,sqldate,sqltime,Mop,qty1,total1,staff);
                                }else if (getitem.equals("OKINAWA**")){
                                    orderHistory(d.milkteaID[1],d.milkteaProduct[8],cat,Size2,sqldate,sqltime,Mop,qty2,total2,staff);
                                }
                            }
                       }
        }        
    }//GEN-LAST:event_btnPAYActionPerformed

    private void btnPRINTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPRINTActionPerformed
        // TODO add your handling code here:
        String value = change.getText                   ();
        int negative = Integer.parseInt          (value);
        String printMop = mop.getSelectedItem().toString();
        if (negative < 0 ) {
            change.setForeground(Color.red);
            JOptionPane.showMessageDialog(null, "Please Pay Exact Amount", "System Error", JOptionPane.ERROR_MESSAGE);
        }else if (pay.getText().equals("") || Option.getSelectedItem().equals("<select>") || printMop.equals("<SELECT>")) {
            JOptionPane.showMessageDialog(null, "Some Field Are Empty", "System Error", JOptionPane.ERROR_MESSAGE);
        
        }else{
            
            try{

                billl.setText(billl.getText() + "------------------------------------------------------\n"                          );
                billl.setText(billl.getText() + "                                SAMPLE RECEIPT \n"                                 );
                billl.setText(billl.getText() + "------------------------------------------------------\n"                          );
                billl.setText(billl.getText() + "Name                        " + "Size               " + "Qty          " + "Price\n");
                billl.setText(billl.getText() + "------------------------------------------------------\n"                          );

                DefaultTableModel d = (DefaultTableModel)MainTable.getModel();

                for (int i = 0; i < MainTable.getRowCount(); i++) {

                    String item =  d.getValueAt(i, 0).toString ();
                    String size =  d.getValueAt(i, 1).toString ();
                    String qty =   d.getValueAt(i, 2).toString ();
                    String price = d.getValueAt(i, 3).toString ();
                billl.setText(billl.getText() + item + "   " +size+"         "+qty+"            "+price+"\n");

                }

                billl.setText(billl.getText() + "------------------------------------------------------\n"             );
                billl.setText(billl.getText() + "Subtotal                 :  " + total.getText()                  +"\n");
                billl.setText(billl.getText() + "Tendered Amount :  " + pay.getText()                    + "\n"        );
                billl.setText(billl.getText() + "Change                  :  " +change.getText()                  +"\n" );
                billl.setText(billl.getText() + "Mode of payment :  " + printMop + "\n"                                );
                billl.setText(billl.getText() + "Staff :  " + staff + "\n"                                );
                System.out.println("print MOP : " + printMop                                                           );
                billl.setText(billl.getText() + "------------------------------------------------------\n"             );
                billl.setText(billl.getText() + "CUSTOMER INFORMATION \n"                                              );
                billl.setText(billl.getText() + "------------------------------------------------------\n"             );
                billl.setText(billl.getText() + "NAME                :"+" _________________________________\n"         );
                billl.setText(billl.getText() + "CONTACT NO   :"+" _________________________________\n"                );
                billl.setText(billl.getText() + "SIGNATURE       :"+" _________________________________\n"             );
                billl.setText(billl.getText() + "------------------------------------------------------\n"             );
                billl.print();
                int option = JOptionPane.showConfirmDialog(null, "Press OK to Continue", "24 TAPSI", JOptionPane.OK_CANCEL_OPTION);
                if (option == JOptionPane.OK_OPTION){
                    this.dispose();
                    new MainDashboard(name.getText()).setVisible(true);
                    
                }

            }
            catch (Exception e) {
                System.out.println(e);
            }
        }

    }//GEN-LAST:event_btnPRINTActionPerformed

    private void payKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_payKeyPressed
        // TODO add your handling code here:
         String quantity = pay.getText();
        
        int length = quantity.length();
        char c = evt.getKeyChar();
        
        if(evt.getKeyChar() >= '0' && evt.getKeyChar() <='9'){
            if (length <10){
            pay.setEditable(true);
            }else {
            pay.setEditable(false);
            }
        }else {
            
            if(evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE){
                pay.setEditable(true);
            }else {
                pay.setEditable(false);
            }
        }
    }//GEN-LAST:event_payKeyPressed

    private void mopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mopActionPerformed
        // TODO add your handling code here:
        String selectMop = mop.getSelectedItem().toString();
        if (selectMop.equals("GCASH")) {
            new Gcash().setVisible(true);
            System.out.println("select MOP : " + selectMop);
        }
    }//GEN-LAST:event_mopActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        new orderList().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void q3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_q3KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_q3KeyPressed

    private void btn3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn3MouseClicked

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn3ActionPerformed

    private void q4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_q4KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_q4KeyPressed

    private void btn4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn4MouseClicked

    private void btn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn4ActionPerformed

    private void q5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_q5KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_q5KeyPressed

    private void btn5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn5MouseClicked

    private void btn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn5ActionPerformed

    private void q6KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_q6KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_q6KeyPressed

    private void btn6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn6MouseClicked

    private void btn6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn6ActionPerformed

    private void q7KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_q7KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_q7KeyPressed

    private void btn7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn7MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn7MouseClicked

    private void btn7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn7ActionPerformed

    private void q8KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_q8KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_q8KeyPressed

    private void btn8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn8MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn8MouseClicked

    private void btn8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn8ActionPerformed

    private void q9KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_q9KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_q9KeyPressed

    private void btn9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn9MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn9MouseClicked

    private void btn9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn9ActionPerformed

    private void q10KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_q10KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_q10KeyPressed

    private void btn10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn10MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn10MouseClicked

    private void btn10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn10ActionPerformed

    private void s1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s1ActionPerformed

    private void s1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_s1KeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_s1KeyPressed

    private void s2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s2ActionPerformed

    private void s2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_s2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_s2KeyPressed

    private void s3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s3ActionPerformed

    private void s3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_s3KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_s3KeyPressed

    private void s4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s4ActionPerformed

    private void s4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_s4KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_s4KeyPressed

    private void s5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s5ActionPerformed

    private void s5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_s5KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_s5KeyPressed

    private void s6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s6ActionPerformed

    private void s6KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_s6KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_s6KeyPressed

    private void s7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s7ActionPerformed

    private void s7KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_s7KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_s7KeyPressed

    private void s8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s8ActionPerformed

    private void s8KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_s8KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_s8KeyPressed

    private void s9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s9ActionPerformed

    private void s9KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_s9KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_s9KeyPressed

    private void s10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s10ActionPerformed

    private void s10KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_s10KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_s10KeyPressed

    public static void orderHistory (int ID,String NAME,String CATEGORY,String SIZE,java.sql.Date DATE,java.sql.Time TIME,String MoP,int QUANTITY,int PRICE,String Staff)
    {
        try {

               Class.forName("com.mysql.cj.jdbc.Driver");
               con = DriverManager.getConnection("jdbc:mysql://localhost/POSDataBase","root","");
               String sql = "INSERT INTO orderhistory (ID,NAME,CATEGORY,SIZE,DATE,TIME,MOP,QTY,PRICE,STAFF) VALUES (?,?,?,?,?,?,?,?,?,?)";
               pst = con.prepareStatement(sql);
               pst.setInt   (1, ID         );
               pst.setString(2, NAME    );
               pst.setString(3, CATEGORY);
               pst.setString(4, SIZE    );
               pst.setDate  (5, DATE      );
               pst.setTime  (6, TIME      );
               pst.setString(7, MoP     );
               pst.setInt   (8, QUANTITY   );
               pst.setInt   (9, PRICE      );
               pst.setString(10, Staff  );
               pst.executeUpdate();
               //JOptionPane.showMessageDialog(rootPane, "Gumana NEIL"); 
               System.out.println(MoP);
               System.out.println("Order Record : Insert Successful");

        } catch (Exception e) {
               System.out.println(e);
        } 
    
    }
    
   public static void ord1 (String ITEM,String SIZE,String QUANTITY)
    {
        try {

               Class.forName("com.mysql.cj.jdbc.Driver");
               con = DriverManager.getConnection("jdbc:mysql://localhost/POSDataBase","root","");
               String sql = "INSERT INTO orderlist1 (ITEM,SIZE,QUANTITY) VALUES (?,?,?)";
               pst = con.prepareStatement(sql);
               pst.setString(1, ITEM    );
               pst.setString(2, SIZE    );
               pst.setString(3, QUANTITY);
               pst.executeUpdate();
               System.out.println("Order List 1 : Successful");

        } catch (Exception e) {
               System.out.println(e);
        } 
    
    }
    
    public static void ord2 (String ITEM,String SIZE,String QUANTITY)
    {
        try {

               Class.forName("com.mysql.cj.jdbc.Driver");
               con = DriverManager.getConnection("jdbc:mysql://localhost/POSDataBase","root","");
               String sql = "INSERT INTO orderlist2 (ITEM,SIZE,QUANTITY) VALUES (?,?,?)";
               pst = con.prepareStatement(sql);
               pst.setString(1, ITEM    );
               pst.setString(2, SIZE    );
               pst.setString(3, QUANTITY);
               pst.executeUpdate();
               System.out.println("Order List 2 : Successful");

        } catch (Exception e) {
               System.out.println(e);
        } 
    
    }
    
    public static void ord3 (String ITEM,String SIZE,String QUANTITY)
    {
        try {

               Class.forName("com.mysql.cj.jdbc.Driver");
               con = DriverManager.getConnection("jdbc:mysql://localhost/POSDataBase","root","");
               String sql = "INSERT INTO orderlist3 (ITEM,SIZE,QUANTITY) VALUES (?,?,?)";
               pst = con.prepareStatement(sql);
               pst.setString(1, ITEM    );
               pst.setString(2, SIZE    );
               pst.setString(3, QUANTITY);
               pst.executeUpdate();
               System.out.println("Order List 3 : Successful");

        } catch (Exception e) {
               System.out.println(e);
        } 
    
    }
    
    public static void ord4 (String ITEM,String SIZE,String QUANTITY)
    {
        try {

               Class.forName("com.mysql.cj.jdbc.Driver");
               con = DriverManager.getConnection("jdbc:mysql://localhost/POSDataBase","root","");
               String sql = "INSERT INTO orderlist4 (ITEM,SIZE,QUANTITY) VALUES (?,?,?)";
               pst = con.prepareStatement(sql);
               pst.setString(1, ITEM    );
               pst.setString(2, SIZE    );
               pst.setString(3, QUANTITY);
               pst.executeUpdate();
               System.out.println("Order List 4 : Successful");

        } catch (Exception e) {
               System.out.println(e);
        } 
    
    }
    
    public static void ord5 (String ITEM,String SIZE,String QUANTITY)
    {
        try {

               Class.forName("com.mysql.cj.jdbc.Driver");
               con = DriverManager.getConnection("jdbc:mysql://localhost/POSDataBase","root","");
               String sql = "INSERT INTO orderlist5 (ITEM,SIZE,QUANTITY) VALUES (?,?,?)";
               pst = con.prepareStatement(sql);
               pst.setString(1, ITEM    );
               pst.setString(2, SIZE    );
               pst.setString(3, QUANTITY);
               pst.executeUpdate();
               System.out.println("Order List 5 : Successful");

        } catch (Exception e) {
               System.out.println(e);
        } 
    
    }
    
    public static void ord6 (String ITEM,String SIZE,String QUANTITY)
    {
        try {

               Class.forName("com.mysql.cj.jdbc.Driver");
               con = DriverManager.getConnection("jdbc:mysql://localhost/POSDataBase","root","");
               String sql = "INSERT INTO orderlist6 (ITEM,SIZE,QUANTITY) VALUES (?,?,?)";
               pst = con.prepareStatement(sql);
               pst.setString(1, ITEM    );
               pst.setString(2, SIZE    );
               pst.setString(3, QUANTITY);
               pst.executeUpdate();
               System.out.println("Order List 6 : Successful");

        } catch (Exception e) {
               System.out.println(e);
        } 
    
    }
    
    public static void ord7 (String ITEM,String SIZE,String QUANTITY)
    {
        try {

               Class.forName("com.mysql.cj.jdbc.Driver");
               con = DriverManager.getConnection("jdbc:mysql://localhost/POSDataBase","root","");
               String sql = "INSERT INTO orderlist7 (ITEM,SIZE,QUANTITY) VALUES (?,?,?)";
               pst = con.prepareStatement(sql);
               pst.setString(1, ITEM    );
               pst.setString(2, SIZE    );
               pst.setString(3, QUANTITY);
               pst.executeUpdate();
               System.out.println("Order List 7 : Successful");

        } catch (Exception e) {
               System.out.println(e);
        } 
    
    }
    
    public static void ord8 (String ITEM,String SIZE,String QUANTITY)
    {
        try {

               Class.forName("com.mysql.cj.jdbc.Driver");
               con = DriverManager.getConnection("jdbc:mysql://localhost/POSDataBase","root","");
               String sql = "INSERT INTO orderlist8 (ITEM,SIZE,QUANTITY) VALUES (?,?,?)";
               pst = con.prepareStatement(sql);
               pst.setString(1, ITEM    );
               pst.setString(2, SIZE    );
               pst.setString(3, QUANTITY);
               pst.executeUpdate();
               System.out.println("Order List 8 : Successful");

        } catch (Exception e) {
               System.out.println(e);
        } 
    
    }
    
    
    public static void addrow (Object [] datarow){
    
    DefaultTableModel model = (DefaultTableModel)MainTable.getModel();
    model.addRow(datarow);
    System.out.println("Add Row : Successful");
    }
    public static void getTableValue (int row, int column){
    
        DefaultTableModel model = (DefaultTableModel)MainTable.getModel();
        String value = String.valueOf(model.getValueAt(row, column));
        System.out.println("getTableValue : Successful");
    }
    
    public static void cal () {
        int numrow = MainTable.getRowCount();
        
        int tot = 0;
        
        for (int i = 0; i < numrow; i++) {
        
        int val = Integer.valueOf(MainTable.getValueAt(i, 3).toString());
        tot += val;
        }
        
        total.setText(Integer.toString(tot));
        System.out.println("Calculation : Successful");
        
      }

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
            java.util.logging.Logger.getLogger(MainDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTable MainTable;
    public static javax.swing.JComboBox<String> Option;
    private javax.swing.JMenu PAY;
    private javax.swing.JLabel acn;
    private javax.swing.JTextPane billl;
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn10;
    private javax.swing.JButton btn2;
    private javax.swing.JButton btn3;
    private javax.swing.JButton btn4;
    private javax.swing.JButton btn5;
    private javax.swing.JButton btn6;
    private javax.swing.JButton btn7;
    private javax.swing.JButton btn8;
    private javax.swing.JButton btn9;
    private javax.swing.JButton btnPAY;
    private javax.swing.JButton btnPRINT;
    private javax.swing.JLabel change;
    private javax.swing.JMenuItem cont;
    private javax.swing.JLabel hungariansilog;
    private javax.swing.JLabel hungariansilog1;
    private javax.swing.JLabel hungariansilog2;
    private javax.swing.JLabel hungariansilog3;
    private javax.swing.JLabel hungariansilog4;
    private javax.swing.JLabel hungariansilog5;
    private javax.swing.JLabel hungariansilog6;
    private javax.swing.JLabel hungariansilog7;
    private javax.swing.JLabel hungariansilog8;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel l_date;
    private javax.swing.JLabel l_time;
    private javax.swing.JMenuItem logout;
    public static javax.swing.JComboBox<String> mop;
    private javax.swing.JLabel name;
    public static javax.swing.JLabel or1;
    private javax.swing.JLabel or2;
    private javax.swing.JLabel or3;
    private javax.swing.JLabel or4;
    private javax.swing.JLabel or5;
    private javax.swing.JLabel or6;
    private javax.swing.JLabel or7;
    private javax.swing.JLabel or8;
    public static javax.swing.JTextField pay;
    public static javax.swing.JTextField q1;
    private javax.swing.JTextField q10;
    private javax.swing.JTextField q2;
    private javax.swing.JTextField q3;
    private javax.swing.JTextField q4;
    private javax.swing.JTextField q5;
    private javax.swing.JTextField q6;
    private javax.swing.JTextField q7;
    private javax.swing.JTextField q8;
    private javax.swing.JTextField q9;
    private javax.swing.JComboBox<String> s1;
    private javax.swing.JComboBox<String> s10;
    private javax.swing.JComboBox<String> s2;
    private javax.swing.JComboBox<String> s3;
    private javax.swing.JComboBox<String> s4;
    private javax.swing.JComboBox<String> s5;
    private javax.swing.JComboBox<String> s6;
    private javax.swing.JComboBox<String> s7;
    private javax.swing.JComboBox<String> s8;
    private javax.swing.JComboBox<String> s9;
    private javax.swing.JLabel staffname1;
    private javax.swing.JLabel staffname18;
    private javax.swing.JLabel staffname2;
    public static javax.swing.JLabel tapsilog;
    public static javax.swing.JLabel total;
    private javax.swing.JPanel totalcost;
    // End of variables declaration//GEN-END:variables
}
