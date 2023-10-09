/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Forms;


import static Forms.AdminDashboard.con;
import static Forms.AdminDashboard.pst;
import static Forms.AdminDashboard.rs;
import static Forms.AdminDashboard.tsa;
import static Forms.MainDashboard.con;
import static Forms.MainDashboard.pst;
import static Forms.MainDashboard.rs;
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


public class ManagerDashboard extends javax.swing.JFrame {

    
    public ManagerDashboard() {
        initComponents();
        menuTable_Update();
        new MainDashboard().orderHistoryTable_Update();
        new MainDashboard().pack();
        dt();
        time();
        displayTotalOrder();
        /*
        TableActionEvent event = new TableActionEvent(){
        public void onEdit (int row){
            System.out.println("Edit row : " + row);
        }
        public void onDelete (int row){
            if(IngredientsTable.isEditing()){
            IngredientsTable.getCellEditor().stopCellEditing();
        }
        }
        public void onView (int row){
            System.out.println("View row : " + row);
        }
    };
            IngredientsTable.getColumnModel().getColumn(8).setCellRenderer(new TableActionCellRender());
            IngredientsTable.getColumnModel().getColumn(8).setCellEditor(new TableActionCellEditor(event));
      */
    }

    ManagerDashboard (String an) {
                    this();
                    name.setText(an);
                    System.out.println("Login Name : Successful");
    }
    
    static Connection con       ;
    static PreparedStatement pst;
    static ResultSet rs         ;
    Timer t                     ;
    SimpleDateFormat st         ;
     
   public void search(String str){
        
    DefaultTableModel d = (DefaultTableModel)MenuTable.getModel       ();
    TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(d);
    MenuTable.setRowSorter(trs);
    trs.setRowFilter(RowFilter.regexFilter(str));
    System.out.println("Search : Successful");
    } 
    public void displayTotalOrder(){
    
    try{
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        con = DriverManager.getConnection("jdbc:mysql://localhost/POSDataBase","root","");
                        String sql = "Select count(NAME) from orderhistory";
                        pst = con.prepareStatement(sql);
                        
                        rs = pst.executeQuery();

                        if (rs.next()) {

                            String Ruser = rs.getString("count(NAME)");
                            To.setText(Ruser);
                            System.out.println("count item : successful");
                        }
    }catch (Exception e) {

                            JOptionPane.showMessageDialog(null, e);

    }
    }
    public void totalSales(){
    
    int numberRow = orderHistory.getRowCount();
    int totalSale = 0;
    
    for (int i = 0 ; i < numberRow; i++){
    
        int value = Integer.valueOf(orderHistory.getValueAt(i, 8).toString());
        totalSale += value;
        
    }
    totIncome.setText(Integer.toString(totalSale));
    }
    
    public void menuTable_Update(){
    
     try {
         
            int c;
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/POSDataBase","root","");
            String sql = "SELECT * FROM statusmanagement";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            ResultSetMetaData rsd = rs.getMetaData();
            c = rsd.getColumnCount();
            
            DefaultTableModel d = (DefaultTableModel)MenuTable.getModel();
            d.setRowCount(0);
            
            while (rs.next()) {
            
                Vector v2 = new Vector();
                for(int i= 1;i<=c; i++){
                
                v2.add(rs.getString("ID"      ));
                v2.add(rs.getString("Name"    ));
                v2.add(rs.getString("Category"));
                v2.add(rs.getString("Size"    ));
                v2.add(rs.getString("Date"    ));
                v2.add(rs.getString("Time"    ));
                v2.add(rs.getString("Status"  ));
                }
                d.addRow(v2);
            }
            System.out.println("Menu Table : Successful");
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
        orderHistory = new javax.swing.JTable();
        date1 = new datechooser.beans.DateChooserCombo();
        name4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        To = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        MenuTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        setStatus = new javax.swing.JComboBox<>();
        setBTN = new javax.swing.JButton();
        name3 = new javax.swing.JLabel();
        search = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Name = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        size = new javax.swing.JComboBox<>();
        insertbtn = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        category = new javax.swing.JComboBox<>();
        l_time = new javax.swing.JLabel();
        l_date = new javax.swing.JLabel();
        acn = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        TI = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        totIncome = new javax.swing.JLabel();
        pesoSign = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        TO = new javax.swing.JLabel();
        totalIncomebtn = new javax.swing.JButton();
        totalOrderbtn = new javax.swing.JButton();
        todayincomebtn = new javax.swing.JButton();
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
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(204, 204, 204)), "ORDER HISTORY", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Stencil", 1, 18), new java.awt.Color(204, 204, 204))); // NOI18N
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        orderHistory.setFont(new java.awt.Font("Nirmala UI", 1, 10)); // NOI18N
        orderHistory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NAME", "CTGRY", "SIZE", "DATE", "TIME", "MOP", "QTY", "PRICE", "STAFF"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        orderHistory.setGridColor(new java.awt.Color(204, 204, 204));
        orderHistory.setRowHeight(40);
        jScrollPane2.setViewportView(orderHistory);

        jPanel10.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 690, 270));
        jPanel10.add(date1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, -1, -1));

        name4.setFont(new java.awt.Font("Stencil", 0, 14)); // NOI18N
        name4.setForeground(new java.awt.Color(255, 255, 255));
        name4.setText("SEARCH BY DATE");
        jPanel10.add(name4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 120, 20));

        jButton1.setBackground(new java.awt.Color(0, 51, 75));
        jButton1.setFont(new java.awt.Font("Nirmala UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, -1, -1));

        jLabel5.setFont(new java.awt.Font("Stencil", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("TOTAL ITEM :");
        jPanel10.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 21, 118, 40));

        To.setFont(new java.awt.Font("Nirmala UI", 1, 20)); // NOI18N
        To.setForeground(new java.awt.Color(255, 255, 255));
        To.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        To.setText("0");
        jPanel10.add(To, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 20, 100, 40));

        jPanel2.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 710, 360));

        jPanel4.setBackground(new java.awt.Color(0, 51, 75));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(204, 204, 204)), "PRODUCT LIST", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Stencil", 1, 18), new java.awt.Color(204, 204, 204))); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        MenuTable.setFont(new java.awt.Font("Nirmala UI", 1, 10)); // NOI18N
        MenuTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NAME", "CATEGORY", "SIZE", "DATE", "TIME", "STATUS"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class
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
        MenuTable.setGridColor(new java.awt.Color(204, 204, 204));
        MenuTable.setRowHeight(40);
        jScrollPane3.setViewportView(MenuTable);

        jPanel4.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 560, 480));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 60, 580, 530));

        jPanel3.setBackground(new java.awt.Color(0, 51, 75));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(204, 204, 204)), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Stencil", 1, 18), new java.awt.Color(176, 0, 0))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Stencil", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("UPDATE STATUS              :");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 10, -1, 30));

        setStatus.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        setStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<Select>", "Available", "Unavailable" }));
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
        name3.setText("SEARCH PRODUCT              :");
        jPanel3.add(name3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 200, 30));

        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchKeyReleased(evt);
            }
        });
        jPanel3.add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 160, 30));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 1290, 50));

        jPanel5.setBackground(new java.awt.Color(0, 51, 75));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(204, 204, 204)), "PRODUCT DETAILS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Stencil", 1, 18), new java.awt.Color(204, 204, 204))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Stencil", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("name");

        Name.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        Name.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel3.setFont(new java.awt.Font("Stencil", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("SIZE");

        size.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        size.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<Select>", "Medium", "Large", "1Liter", "Solo", "Family", "Barkada" }));
        size.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sizeActionPerformed(evt);
            }
        });

        insertbtn.setBackground(new java.awt.Color(0, 51, 75));
        insertbtn.setFont(new java.awt.Font("Nirmala UI", 1, 12)); // NOI18N
        insertbtn.setForeground(new java.awt.Color(255, 255, 255));
        insertbtn.setText("INSERT");
        insertbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertbtnActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Stencil", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("ID");

        id.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        id.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                idKeyPressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Stencil", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("CATEGORY");

        category.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        category.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<Select>", "Silog", "Tops", "Rice Meal", "Burger", "Pasta", "Ala Carte", "MilkTea", "Yakult Series", "FruiTea", "Soda", "Ice Americano", "Cheesecake", "Iced Latte", "Add-Ons" }));
        category.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryActionPerformed(evt);
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
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Name, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(37, 37, 37)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(category, 0, 252, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(insertbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(size, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(20, 20, 20))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Name, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(category, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(size, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(insertbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 710, 170));

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
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(204, 204, 204)), "ORDER REPORTS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Stencil", 1, 18), new java.awt.Color(204, 204, 204))); // NOI18N
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel9.setBackground(new java.awt.Color(153, 153, 153));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TI.setFont(new java.awt.Font("Nirmala UI", 1, 20)); // NOI18N
        TI.setForeground(new java.awt.Color(255, 255, 255));
        TI.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TI.setText("0");
        jPanel9.add(TI, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 100, 40));

        jPanel6.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 60, 190, 40));

        jPanel11.setBackground(new java.awt.Color(102, 204, 255));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        totIncome.setFont(new java.awt.Font("Nirmala UI", 1, 20)); // NOI18N
        totIncome.setForeground(new java.awt.Color(255, 255, 255));
        totIncome.setText("0");
        jPanel11.add(totIncome, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 100, 40));

        pesoSign.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        pesoSign.setForeground(new java.awt.Color(255, 255, 255));
        pesoSign.setText("₱");
        jPanel11.add(pesoSign, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 20, 40));

        jPanel6.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 190, 40));

        jPanel12.setBackground(new java.awt.Color(255, 0, 255));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TO.setFont(new java.awt.Font("Nirmala UI", 1, 20)); // NOI18N
        TO.setForeground(new java.awt.Color(255, 255, 255));
        TO.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TO.setText("0");
        jPanel12.add(TO, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 100, 40));

        jPanel6.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, 190, 40));

        totalIncomebtn.setBackground(new java.awt.Color(0, 0, 0));
        totalIncomebtn.setFont(new java.awt.Font("Stencil", 0, 14)); // NOI18N
        totalIncomebtn.setForeground(new java.awt.Color(255, 255, 255));
        totalIncomebtn.setText("VIEW TOTAL INCOME");
        totalIncomebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalIncomebtnActionPerformed(evt);
            }
        });
        jPanel6.add(totalIncomebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 190, 30));

        totalOrderbtn.setBackground(new java.awt.Color(0, 0, 0));
        totalOrderbtn.setFont(new java.awt.Font("Stencil", 0, 14)); // NOI18N
        totalOrderbtn.setForeground(new java.awt.Color(255, 255, 255));
        totalOrderbtn.setText("VIEW TOTAL ORDER");
        totalOrderbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalOrderbtnActionPerformed(evt);
            }
        });
        jPanel6.add(totalOrderbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, 190, 30));

        todayincomebtn.setBackground(new java.awt.Color(0, 0, 0));
        todayincomebtn.setFont(new java.awt.Font("Stencil", 0, 14)); // NOI18N
        todayincomebtn.setForeground(new java.awt.Color(255, 255, 255));
        todayincomebtn.setText("VIEW TODAY INCOME");
        todayincomebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                todayincomebtnActionPerformed(evt);
            }
        });
        jPanel6.add(todayincomebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 30, 190, 30));

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 0, 630, 110));

        jPanel7.setBackground(new java.awt.Color(0, 51, 75));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(204, 204, 204)), "STORE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Stencil", 1, 18), new java.awt.Color(204, 204, 204))); // NOI18N
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Stencil", 0, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("JPOS");
        jPanel7.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 200, 40));

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, 280, 110));

        jPanel8.setBackground(new java.awt.Color(0, 51, 75));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(204, 204, 204)), "EMPLOYEE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Stencil", 1, 18), new java.awt.Color(204, 204, 204))); // NOI18N
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        staffname.setFont(new java.awt.Font("Stencil", 0, 10)); // NOI18N
        staffname.setForeground(new java.awt.Color(255, 255, 255));
        staffname.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        staffname.setText("MANAGER");
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
                                    
            String getname = name.getText();
            Date date = new Date();
            java.sql.Date logoutdate = new java.sql.Date(date.getTime());
            java.sql.Time logouttime = new java.sql.Time(date.getTime());
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/POSDataBase","root","");
            String sql = "SELECT * FROM loginhistory WHERE Username = ?";
            pst = con.prepareCall(sql);
            pst.setString(1, getname);
            rs = pst.executeQuery();
            
                        if (rs.next()) {
                                String aID = rs.getString("Account_ID");
                                Class.forName("com.mysql.cj.jdbc.Driver");
                                con = DriverManager.getConnection("jdbc:mysql://localhost/POSDataBase","root","");
                                String sqll = "UPDATE loginhistory SET Logout_Date = ?,Logout_Time = ? WHERE Account_ID = ?";
                                pst = con.prepareStatement(sqll);
                                pst.setDate(1, logoutdate      );
                                pst.setTime(2, logouttime      );
                                pst.setString(3, aID         );
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

            DefaultTableModel d1 = (DefaultTableModel)MenuTable.getModel();
            int selectedIndex = MenuTable.getSelectedRow();
            int id = Integer.parseInt(d1.getValueAt(selectedIndex, 0).toString());
            java.sql.Date sqldate = new java.sql.Date(date.getTime());
            java.sql.Time sqltime = new java.sql.Time(date.getTime());

            try {

                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/POSDataBase","root","");
                String sql = "UPDATE statusmanagement SET Date = ?,Time = ?,Status = ? WHERE ID = ?";
                pst = con.prepareStatement(sql);
                pst.setDate(1, sqldate);
                pst.setTime(2, sqltime);
                pst.setString(3, setStat);
                pst.setInt(4, id);
                pst.executeUpdate();
                menuTable_Update();

                System.out.println("Order List 1 : Successful");

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

    private void sizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sizeActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_sizeActionPerformed

    private void insertbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertbtnActionPerformed
        // TODO add your handling code here:
        Date date = new Date();
        String getID = id.getText();
        int Id = Integer.parseInt(getID);
        String getName = Name.getText();
        String getCategory = category.getSelectedItem().toString();
        String getSize = size.getSelectedItem().toString();
        java.sql.Date sqldate = new java.sql.Date(date.getTime());
        java.sql.Time sqltime = new java.sql.Time(date.getTime());
        String defaultStatus = "Available";

        if (getID.equals("") || getName.equals("") || getCategory.equals("<Select>") || getSize.equals("<Select>")) {

            JOptionPane.showMessageDialog(null, "Some field are empty", "Error", JOptionPane.ERROR_MESSAGE);

        }else{

            try {

                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/POSDataBase","root","");
                String sql = "INSERT INTO statusmanagement (ID,Name,Category,Size,Date,Time,Status) VALUES (?,?,?,?,?,?,?)";
                pst = con.prepareStatement(sql);
                pst.setInt   (1, Id              );
                pst.setString(2, getName      );
                pst.setString(3, getCategory  );
                pst.setString(4, getSize      );
                pst.setDate  (5, sqldate        );
                pst.setTime  (6, sqltime        );
                pst.setString(7, defaultStatus);
                pst.executeUpdate();
                id.setText("");
                Name.setText("");
                category.setSelectedItem(-1);
                size.setSelectedItem(-1);
                id.requestFocus();
                menuTable_Update();
                System.out.println("Product Added : Successful");
            } catch (Exception e) {
                System.out.println(e);
            }

        }
    }//GEN-LAST:event_insertbtnActionPerformed

    private void idKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idKeyPressed
        // TODO add your handling code here:
        String ID = id.getText();

        int length = ID.length();
        char c = evt.getKeyChar();

        if(evt.getKeyChar() >= '0' && evt.getKeyChar() <='9'){
            if (length <10){
                id.setEditable(true);
            }else {
                id.setEditable(false);
            }
        }else {

            if(evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE){
                id.setEditable(true);
            }else {
                id.setEditable(false);
            }
        }
    }//GEN-LAST:event_idKeyPressed

    private void categoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_categoryActionPerformed

    private void todayincomebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_todayincomebtnActionPerformed
        // TODO add your handling code here:
  
    }//GEN-LAST:event_todayincomebtnActionPerformed

    private void totalIncomebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalIncomebtnActionPerformed
        // TODO add your handling code here:
    int numberRow = orderHistory.getRowCount();
    int totalSale = 0;
    
    for (int i = 0 ; i < numberRow; i++){
    
        int value = Integer.valueOf(orderHistory.getValueAt(i, 8).toString());
        totalSale += value;
        
    }
    double myTotDouble = totalSale;
    totIncome.setText(Double.toString(totalSale));
    }//GEN-LAST:event_totalIncomebtnActionPerformed

    private void totalOrderbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalOrderbtnActionPerformed
        // TODO add your handling code here:
    int numberRow = orderHistory.getRowCount();
    int totalSale = 0;
    
    for (int i = 0 ; i < numberRow; i++){
    
        int value = Integer.valueOf(orderHistory.getValueAt(i, 7).toString());
        totalSale += value;
        
    }
    TO.setText(Integer.toString(totalSale));
    }//GEN-LAST:event_totalOrderbtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    
    }//GEN-LAST:event_jButton1ActionPerformed


    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManagerDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTable MenuTable;
    private javax.swing.JTextField Name;
    private javax.swing.JMenu PAY;
    public static javax.swing.JLabel TI;
    public static javax.swing.JLabel TO;
    public static javax.swing.JLabel To;
    private javax.swing.JLabel acn;
    private javax.swing.JComboBox<String> category;
    private datechooser.beans.DateChooserCombo date1;
    private javax.swing.JTextField id;
    private javax.swing.JButton insertbtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel l_date;
    private javax.swing.JLabel l_time;
    private javax.swing.JMenuItem logout;
    private javax.swing.JLabel name;
    private javax.swing.JLabel name3;
    private javax.swing.JLabel name4;
    public static javax.swing.JTable orderHistory;
    private javax.swing.JLabel pesoSign;
    private javax.swing.JTextField search;
    private javax.swing.JButton setBTN;
    private javax.swing.JComboBox<String> setStatus;
    private javax.swing.JComboBox<String> size;
    private javax.swing.JLabel staffname;
    private javax.swing.JButton todayincomebtn;
    public static javax.swing.JLabel totIncome;
    private javax.swing.JButton totalIncomebtn;
    private javax.swing.JButton totalOrderbtn;
    // End of variables declaration//GEN-END:variables
}
