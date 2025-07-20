/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package cafemanagementsystem;

import Others.*;
import Classes.*;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dinis
 */
public class HRProfile extends javax.swing.JFrame {

    /**
     * Creates new form HRProfile
     */
    static Point initialClick;

    public HRProfile(String id, String name) {
        initComponents();
        
        uIDLable.setText(id);
        uNameLable.setText(name);

        dateLable.setText(DateTime.showDate());
        time();
        loadComplaints();
        hideIdColumn();
        loadRequests();
        adjustTbColums();
        hideRIdColumn();
        loadNotes();
    }

    public void time() {
        new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date d = new Date();
                SimpleDateFormat df = new SimpleDateFormat("hh:mm:ss a");
                timeLable.setText(df.format(d));
            }
        }).start();
    }

    public void loadComplaints() {

        try {

            Complaint cmp = new Complaint();
            ResultSet rs = cmp.viewComplaint("*", "status = ?", "Pending");

            DefaultTableModel df = (DefaultTableModel) complaintTable.getModel();
            int rc = df.getRowCount();
            for (int i = 0; i < rc; i++) {
                df.removeRow(0);
            }

            while (rs.next()) {

                Vector v = new Vector();
                v.add(rs.getString("description"));
                v.add(rs.getString("made_date"));
                v.add(rs.getString("status"));
                v.add(rs.getString("comp_id"));
                df.addRow(v);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void hideIdColumn() {

        complaintTable.getColumnModel().getColumn(3).setMinWidth(0);
        complaintTable.getColumnModel().getColumn(3).setMaxWidth(0);
        complaintTable.getColumnModel().getColumn(3).setWidth(0);

    }

    public void loadRequests() {

        try {

            Request req = new Request();
            User user = new User();
            ResultSet rs = req.viewRequest("*", "status = ?", "Pending");

            DefaultTableModel df = (DefaultTableModel) requestTable.getModel();
            int rc = df.getRowCount();
            for (int i = 0; i < rc; i++) {
                df.removeRow(0);
            }

            while (rs.next()) {

                Vector v = new Vector();
                String uId = rs.getString("user_id");
                v.add(uId);

                ResultSet rs2 = user.viewUser("fname", "user_id = ?", uId);
                String fName = "";
                if (rs2.next()) {
                    fName = rs2.getString("fname");
                }

                v.add(fName);
                v.add(rs.getString("description"));
                v.add(rs.getString("status"));
                v.add(rs.getString("req_id"));
                df.addRow(v);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void hideRIdColumn() {

        requestTable.getColumnModel().getColumn(4).setMinWidth(0);
        requestTable.getColumnModel().getColumn(4).setMaxWidth(0);
        requestTable.getColumnModel().getColumn(4).setWidth(0);

    }

    private void adjustTbColums() {

        requestTable.getColumnModel().getColumn(0).setPreferredWidth(70);
        requestTable.getColumnModel().getColumn(1).setPreferredWidth(60);
        requestTable.getColumnModel().getColumn(2).setPreferredWidth(200);
        requestTable.getColumnModel().getColumn(3).setPreferredWidth(60);

    }
    
    public void loadNotes() {

        try {

            Notification note = new Notification();
            ResultSet rs = note.viewNote("*", "Inner join user as u on u.user_id = n.user_id", "where n.user_id = ?", uIDLable.getText());

            DefaultTableModel df = (DefaultTableModel) noteTable.getModel();
            int rc = df.getRowCount();
            for (int i = 0; i < rc; i++) {
                df.removeRow(0);
            }

            while (rs.next()) {

                Vector v = new Vector();
                v.add(rs.getString("n.made_date"));
                v.add(rs.getString("n.description"));
                v.add(rs.getString("n.status"));
                df.addRow(v);

            }

        } catch (Exception e) {
            e.printStackTrace();
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

        jPanel3 = new javax.swing.JPanel();
        minimizeLable = new javax.swing.JLabel();
        closeLable = new javax.swing.JLabel();
        timeLable = new javax.swing.JLabel();
        dateLable = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        menuPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        uNameLable = new javax.swing.JLabel();
        uIDLable = new javax.swing.JLabel();
        updateProfileBtn = new javax.swing.JButton();
        logOutBtn = new javax.swing.JButton();
        clockOffBtn = new javax.swing.JButton();
        clockInBtn = new javax.swing.JButton();
        billTerminaBtn1 = new javax.swing.JButton();
        viewPerformanceBtn = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        empChefTxtBox = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        requestTable = new javax.swing.JTable();
        serachStockBtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        approveBtn = new javax.swing.JButton();
        denyBtn = new javax.swing.JButton();
        bmReviewBtn = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        complaintTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        markReadBtn = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        noteTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(245, 222, 179));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        jPanel3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel3MouseDragged(evt);
            }
        });
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel3MousePressed(evt);
            }
        });
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        minimizeLable.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        minimizeLable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_minimize_window_16px.png"))); // NOI18N
        minimizeLable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizeLableMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                minimizeLableMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                minimizeLableMouseExited(evt);
            }
        });
        jPanel3.add(minimizeLable, new org.netbeans.lib.awtextra.AbsoluteConstraints(1223, 1, 30, 28));

        closeLable.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        closeLable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_delete_16px.png"))); // NOI18N
        closeLable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeLableMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                closeLableMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                closeLableMouseExited(evt);
            }
        });
        jPanel3.add(closeLable, new org.netbeans.lib.awtextra.AbsoluteConstraints(1259, 1, 30, 28));

        timeLable.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        timeLable.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timeLable.setText("Time");
        timeLable.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel3.add(timeLable, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 150, 30));

        dateLable.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        dateLable.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dateLable.setText("Date");
        dateLable.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel3.add(dateLable, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 150, 30));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1290, 30));

        jPanel1.setBackground(new java.awt.Color(242, 224, 200));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menuPanel.setBackground(new java.awt.Color(210, 180, 140));
        menuPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        menuPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(210, 180, 140));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(51, 51, 51), new java.awt.Color(0, 0, 0), new java.awt.Color(153, 153, 153), new java.awt.Color(102, 102, 102)));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_manager_40px.png"))); // NOI18N

        uNameLable.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        uNameLable.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        uNameLable.setText("HR Name");
        uNameLable.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));

        uIDLable.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        uIDLable.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        uIDLable.setText("HR Id");
        uIDLable.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));

        updateProfileBtn.setBackground(new java.awt.Color(255, 239, 153));
        updateProfileBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        updateProfileBtn.setText("Update Profile");
        updateProfileBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                updateProfileBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                updateProfileBtnMouseExited(evt);
            }
        });
        updateProfileBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateProfileBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(uNameLable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(uIDLable, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(updateProfileBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(uIDLable, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                        .addGap(4, 4, 4)
                        .addComponent(uNameLable, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(updateProfileBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        menuPanel.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 300, 140));

        logOutBtn.setBackground(new java.awt.Color(255, 153, 153));
        logOutBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        logOutBtn.setText("Log Out");
        logOutBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logOutBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logOutBtnMouseExited(evt);
            }
        });
        logOutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutBtnActionPerformed(evt);
            }
        });
        menuPanel.add(logOutBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 550, 260, 30));

        clockOffBtn.setBackground(new java.awt.Color(255, 102, 102));
        clockOffBtn.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        clockOffBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_alarm_off_24px.png"))); // NOI18N
        clockOffBtn.setText(" Mark Clock off");
        clockOffBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                clockOffBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                clockOffBtnMouseExited(evt);
            }
        });
        clockOffBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clockOffBtnActionPerformed(evt);
            }
        });
        menuPanel.add(clockOffBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 300, 60));

        clockInBtn.setBackground(new java.awt.Color(153, 255, 153));
        clockInBtn.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        clockInBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_clock_checked_24px.png"))); // NOI18N
        clockInBtn.setText(" Mark Clock in");
        clockInBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                clockInBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                clockInBtnMouseExited(evt);
            }
        });
        clockInBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clockInBtnActionPerformed(evt);
            }
        });
        menuPanel.add(clockInBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 300, 60));

        billTerminaBtn1.setBackground(new java.awt.Color(64, 224, 208));
        billTerminaBtn1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        billTerminaBtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_bill_32px.png"))); // NOI18N
        billTerminaBtn1.setText(" Billing Terminal");
        billTerminaBtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                billTerminaBtn1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                billTerminaBtn1MouseExited(evt);
            }
        });
        billTerminaBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                billTerminaBtn1ActionPerformed(evt);
            }
        });
        menuPanel.add(billTerminaBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 300, 60));

        viewPerformanceBtn.setBackground(new java.awt.Color(64, 224, 208));
        viewPerformanceBtn.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        viewPerformanceBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Personal_Growth_32px.png"))); // NOI18N
        viewPerformanceBtn.setText(" View Login Details");
        viewPerformanceBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                viewPerformanceBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                viewPerformanceBtnMouseExited(evt);
            }
        });
        viewPerformanceBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewPerformanceBtnActionPerformed(evt);
            }
        });
        menuPanel.add(viewPerformanceBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 300, 60));

        jPanel1.add(menuPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 320, 590));

        jPanel4.setBackground(new java.awt.Color(245, 222, 179));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(51, 51, 51)));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Employee / Chef Requests");
        jLabel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(51, 51, 51), new java.awt.Color(0, 0, 0), new java.awt.Color(102, 102, 102), new java.awt.Color(102, 102, 102)));

        empChefTxtBox.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        empChefTxtBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empChefTxtBoxActionPerformed(evt);
            }
        });

        requestTable.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        requestTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "User ID", "Name", "Description", "Status", "id"
            }
        ));
        jScrollPane2.setViewportView(requestTable);

        serachStockBtn.setBackground(new java.awt.Color(102, 255, 102));
        serachStockBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        serachStockBtn.setText("Search");
        serachStockBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                serachStockBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                serachStockBtnMouseExited(evt);
            }
        });
        serachStockBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                serachStockBtnActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Employee / Chef Name");

        approveBtn.setBackground(new java.awt.Color(102, 255, 102));
        approveBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        approveBtn.setText("Approve");
        approveBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                approveBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                approveBtnMouseExited(evt);
            }
        });
        approveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                approveBtnActionPerformed(evt);
            }
        });

        denyBtn.setBackground(new java.awt.Color(255, 102, 102));
        denyBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        denyBtn.setText("Deny");
        denyBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                denyBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                denyBtnMouseExited(evt);
            }
        });
        denyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                denyBtnActionPerformed(evt);
            }
        });

        bmReviewBtn.setBackground(new java.awt.Color(204, 255, 153));
        bmReviewBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bmReviewBtn.setText("Send BM for Review");
        bmReviewBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bmReviewBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bmReviewBtnMouseExited(evt);
            }
        });
        bmReviewBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bmReviewBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(empChefTxtBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(serachStockBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(approveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(denyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(bmReviewBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(empChefTxtBox, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(serachStockBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(approveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(denyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bmReviewBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, 460, 590));

        jPanel5.setBackground(new java.awt.Color(245, 222, 179));
        jPanel5.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(51, 51, 51)));

        complaintTable.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        complaintTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Made date", "Description", "Status", "id"
            }
        ));
        jScrollPane1.setViewportView(complaintTable);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Complaints");
        jLabel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(51, 51, 51), new java.awt.Color(0, 0, 0), new java.awt.Color(102, 102, 102), new java.awt.Color(102, 102, 102)));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Notifications");
        jLabel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(51, 51, 51), new java.awt.Color(0, 0, 0), new java.awt.Color(102, 102, 102), new java.awt.Color(102, 102, 102)));

        markReadBtn.setBackground(new java.awt.Color(102, 255, 102));
        markReadBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        markReadBtn.setText("Mark as Reviewed");
        markReadBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                markReadBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                markReadBtnMouseExited(evt);
            }
        });
        markReadBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                markReadBtnActionPerformed(evt);
            }
        });

        noteTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Made Date", "Description", "Status"
            }
        ));
        jScrollPane3.setViewportView(noteTable);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(markReadBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(markReadBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 10, -1, 590));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 1290, 610));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void minimizeLableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeLableMouseClicked
        this.setExtendedState(LoginFrame.ICONIFIED);
    }//GEN-LAST:event_minimizeLableMouseClicked

    private void minimizeLableMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeLableMouseEntered
        minimizeLable.setOpaque(true);
        minimizeLable.setBackground(new Color(210, 180, 140));
        minimizeLable.repaint();
    }//GEN-LAST:event_minimizeLableMouseEntered

    private void minimizeLableMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeLableMouseExited
        minimizeLable.setBackground(new Color(245, 222, 179));
    }//GEN-LAST:event_minimizeLableMouseExited

    private void closeLableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeLableMouseClicked
        JFrame f = new JFrame();
        if (JOptionPane.showConfirmDialog(f, "Do you want to exit?") == JOptionPane.YES_NO_OPTION) {
            java.lang.System.exit(0);
        }
    }//GEN-LAST:event_closeLableMouseClicked

    private void closeLableMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeLableMouseEntered
        closeLable.setOpaque(true);
        closeLable.setBackground(new Color(210, 180, 140));
        closeLable.repaint();
    }//GEN-LAST:event_closeLableMouseEntered

    private void closeLableMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeLableMouseExited
        closeLable.setBackground(new Color(245, 222, 179));
    }//GEN-LAST:event_closeLableMouseExited

    private void jPanel3MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseDragged
        int xMoved = evt.getX() - initialClick.x;
        int yMoved = evt.getY() - initialClick.y;
        int x = getLocation().x + xMoved;
        int y = getLocation().y + yMoved;
        setLocation(x, y);
    }//GEN-LAST:event_jPanel3MouseDragged

    private void jPanel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MousePressed
        initialClick = evt.getPoint();
        getComponentAt(initialClick);
    }//GEN-LAST:event_jPanel3MousePressed

    private void logOutBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logOutBtnMouseEntered
        logOutBtn.setBackground(new Color(255, 51, 51));
    }//GEN-LAST:event_logOutBtnMouseEntered

    private void logOutBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logOutBtnMouseExited
        logOutBtn.setBackground(new Color(255, 153, 153));
    }//GEN-LAST:event_logOutBtnMouseExited

    private void logOutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutBtnActionPerformed
        User user = new User();
        int result = user.logOut();
        if (result == JOptionPane.YES_NO_OPTION) {
            new LoginFrame().setVisible(true);
        }
    }//GEN-LAST:event_logOutBtnActionPerformed

    private void clockOffBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clockOffBtnMouseEntered
        clockOffBtn.setBackground(new Color(255, 51, 51));
    }//GEN-LAST:event_clockOffBtnMouseEntered

    private void clockOffBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clockOffBtnMouseExited
        clockOffBtn.setBackground(new Color(255, 102, 102));
    }//GEN-LAST:event_clockOffBtnMouseExited

    private void clockOffBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clockOffBtnActionPerformed
        JFrame f = new JFrame();
        if (JOptionPane.showConfirmDialog(f, "Do you want to mark Clok off time") == JOptionPane.YES_NO_OPTION) {

            TimeSheet timeSheet = new TimeSheet();
            timeSheet.setUserID(uIDLable.getText());
            timeSheet.setClockoffTime(LocalTime.now());

            DateTimeFormatter dateFormater = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            timeSheet.setDate(LocalDate.parse(dateLable.getText(), dateFormater));

            timeSheet.markClockoff();

        }
    }//GEN-LAST:event_clockOffBtnActionPerformed

    private void clockInBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clockInBtnMouseEntered
        clockInBtn.setBackground(new Color(102, 255, 102));
    }//GEN-LAST:event_clockInBtnMouseEntered

    private void clockInBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clockInBtnMouseExited
        clockInBtn.setBackground(new Color(153, 255, 153));
    }//GEN-LAST:event_clockInBtnMouseExited

    private void clockInBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clockInBtnActionPerformed
        JFrame f = new JFrame();
        if (JOptionPane.showConfirmDialog(f, "Do you want to mark Clok off time") == JOptionPane.YES_NO_OPTION) {

            TimeSheet timeSheet = new TimeSheet();
            timeSheet.setUserID(uIDLable.getText());
            timeSheet.setClockoffTime(LocalTime.now());

            DateTimeFormatter dateFormater = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            timeSheet.setDate(LocalDate.parse(dateLable.getText(), dateFormater));

            timeSheet.markClockoff();

        }
    }//GEN-LAST:event_clockInBtnActionPerformed

    private void billTerminaBtn1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_billTerminaBtn1MouseEntered
        billTerminaBtn1.setBackground(new Color(51, 204, 255));
    }//GEN-LAST:event_billTerminaBtn1MouseEntered

    private void billTerminaBtn1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_billTerminaBtn1MouseExited
        billTerminaBtn1.setBackground(new Color(64, 224, 208));
    }//GEN-LAST:event_billTerminaBtn1MouseExited

    private void billTerminaBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_billTerminaBtn1ActionPerformed
        this.dispose();
        new BillingFrame(6,uIDLable.getText(), uNameLable.getText()).setVisible(true);
    }//GEN-LAST:event_billTerminaBtn1ActionPerformed

    private void empChefTxtBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empChefTxtBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_empChefTxtBoxActionPerformed

    private void serachStockBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_serachStockBtnMouseEntered
        serachStockBtn.setBackground(new Color(0, 204, 102));
    }//GEN-LAST:event_serachStockBtnMouseEntered

    private void serachStockBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_serachStockBtnMouseExited
        serachStockBtn.setBackground(new Color(102, 255, 102));
    }//GEN-LAST:event_serachStockBtnMouseExited

    private void serachStockBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_serachStockBtnActionPerformed

    }//GEN-LAST:event_serachStockBtnActionPerformed

    private void approveBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_approveBtnMouseEntered
        approveBtn.setBackground(new Color(0, 204, 102));
    }//GEN-LAST:event_approveBtnMouseEntered

    private void approveBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_approveBtnMouseExited
        approveBtn.setBackground(new Color(102, 255, 102));
    }//GEN-LAST:event_approveBtnMouseExited

    private void denyBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_denyBtnMouseEntered
        denyBtn.setBackground(new Color(255, 51, 51));
    }//GEN-LAST:event_denyBtnMouseEntered

    private void denyBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_denyBtnMouseExited
        denyBtn.setBackground(new Color(255, 102, 102));
    }//GEN-LAST:event_denyBtnMouseExited

    private void denyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_denyBtnActionPerformed
        DefaultTableModel df = (DefaultTableModel) requestTable.getModel();

        if (requestTable.getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Select at least one Request to approve");
        } else {
            JFrame f = new JFrame();
            if (JOptionPane.showConfirmDialog(f, "Do you want to perform this action") == JOptionPane.YES_NO_OPTION) {
                int[] selectedRows = requestTable.getSelectedRows();

                Request req = new Request();

                for (int row : selectedRows) {
                    int modelRow = complaintTable.convertRowIndexToModel(row);
                    req.setReqId(Integer.parseInt(df.getValueAt(modelRow, 4).toString()));
                    req.setStatus("Denied");
                    req.denyRequest();
                }
                loadRequests();
            }
        }
    }//GEN-LAST:event_denyBtnActionPerformed

    private void markReadBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_markReadBtnMouseEntered
        markReadBtn.setBackground(new Color(0, 204, 102));
    }//GEN-LAST:event_markReadBtnMouseEntered

    private void markReadBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_markReadBtnMouseExited
        markReadBtn.setBackground(new Color(102, 255, 102));
    }//GEN-LAST:event_markReadBtnMouseExited

    private void markReadBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_markReadBtnActionPerformed
        DefaultTableModel df = (DefaultTableModel) complaintTable.getModel();

        if (complaintTable.getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Select at least one complaint to approve");
        } else {
            JFrame f = new JFrame();
            if (JOptionPane.showConfirmDialog(f, "Do you want to perform this action") == JOptionPane.YES_NO_OPTION) {
                int[] selectedRows = complaintTable.getSelectedRows();

                Complaint cmp = new Complaint();

                for (int row : selectedRows) {
                    int modelRow = requestTable.convertRowIndexToModel(row);
                    cmp.setComId(Integer.parseInt(df.getValueAt(modelRow, 3).toString()));
                    cmp.setStatus("Reviewed");
                    cmp.approveComplaint();
                }
                loadComplaints();
            }
        }
    }//GEN-LAST:event_markReadBtnActionPerformed

    private void viewPerformanceBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewPerformanceBtnActionPerformed

    }//GEN-LAST:event_viewPerformanceBtnActionPerformed

    private void viewPerformanceBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewPerformanceBtnMouseExited
        viewPerformanceBtn.setBackground(new Color(64, 224, 208));
    }//GEN-LAST:event_viewPerformanceBtnMouseExited

    private void viewPerformanceBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewPerformanceBtnMouseEntered
        viewPerformanceBtn.setBackground(new Color(51, 204, 255));
    }//GEN-LAST:event_viewPerformanceBtnMouseEntered

    private void approveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_approveBtnActionPerformed
        DefaultTableModel df = (DefaultTableModel) requestTable.getModel();

        if (requestTable.getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Select at least one Request to approve");
        } else {
            JFrame f = new JFrame();
            if (JOptionPane.showConfirmDialog(f, "Do you want to perform this action") == JOptionPane.YES_NO_OPTION) {
                int[] selectedRows = requestTable.getSelectedRows();

                Request req = new Request();

                for (int row : selectedRows) {
                    int modelRow = requestTable.convertRowIndexToModel(row);
                    req.setReqId(Integer.parseInt(df.getValueAt(modelRow, 4).toString()));
                    req.setStatus("Approved");
                    req.approveRequest();
                }
                loadRequests();
            }
        }
    }//GEN-LAST:event_approveBtnActionPerformed

    private void bmReviewBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bmReviewBtnMouseEntered
        bmReviewBtn.setBackground(new Color(204, 255, 204));
    }//GEN-LAST:event_bmReviewBtnMouseEntered

    private void bmReviewBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bmReviewBtnMouseExited
        bmReviewBtn.setBackground(new Color(204, 255, 153));
    }//GEN-LAST:event_bmReviewBtnMouseExited

    private void bmReviewBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bmReviewBtnActionPerformed
        DefaultTableModel df = (DefaultTableModel) requestTable.getModel();

        if (requestTable.getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Select at least one Request to approve");
        } else {
            JFrame f = new JFrame();
            if (JOptionPane.showConfirmDialog(f, "Do you want to perform this action") == JOptionPane.YES_NO_OPTION) {
                int[] selectedRows = requestTable.getSelectedRows();

                Request req = new Request();

                for (int row : selectedRows) {
                    int modelRow = complaintTable.convertRowIndexToModel(row);
                    req.setReqId(Integer.parseInt(df.getValueAt(modelRow, 4).toString()));
                    req.setStatus("BM");
                    req.passRequest();
                }
                loadRequests();
            }
        }
    }//GEN-LAST:event_bmReviewBtnActionPerformed

    private void updateProfileBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateProfileBtnMouseEntered
        updateProfileBtn.setBackground(new Color(255, 255, 153));
    }//GEN-LAST:event_updateProfileBtnMouseEntered

    private void updateProfileBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateProfileBtnMouseExited
        updateProfileBtn.setBackground(new Color(255, 239, 153));
    }//GEN-LAST:event_updateProfileBtnMouseExited

    private void updateProfileBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateProfileBtnActionPerformed
        this.dispose();
        new UpdateProfileFrame(6,uIDLable.getText(), uNameLable.getText()).setVisible(true);
    }//GEN-LAST:event_updateProfileBtnActionPerformed

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
            java.util.logging.Logger.getLogger(HRProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HRProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HRProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HRProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HRProfile("", "").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton approveBtn;
    private javax.swing.JButton billTerminaBtn1;
    private javax.swing.JButton bmReviewBtn;
    private javax.swing.JButton clockInBtn;
    private javax.swing.JButton clockOffBtn;
    private javax.swing.JLabel closeLable;
    private javax.swing.JTable complaintTable;
    private javax.swing.JLabel dateLable;
    private javax.swing.JButton denyBtn;
    private javax.swing.JTextField empChefTxtBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton logOutBtn;
    private javax.swing.JButton markReadBtn;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JLabel minimizeLable;
    private javax.swing.JTable noteTable;
    private javax.swing.JTable requestTable;
    private javax.swing.JButton serachStockBtn;
    private javax.swing.JLabel timeLable;
    private javax.swing.JLabel uIDLable;
    private javax.swing.JLabel uNameLable;
    private javax.swing.JButton updateProfileBtn;
    private javax.swing.JButton viewPerformanceBtn;
    // End of variables declaration//GEN-END:variables
}
