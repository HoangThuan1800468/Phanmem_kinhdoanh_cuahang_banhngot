/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pm_quanly_cuahangbanh;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author lyhoa
 */
public class DangNhap extends javax.swing.JFrame {

    /**
     * Creates new form DangNhap
     */
    public DangNhap() {
        initComponents();
    }
    public static String ID;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        btn_dangnhap = new javax.swing.JButton();
        txt_matkhau = new javax.swing.JPasswordField();
        lb_quenmatkhau = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Phần mềm quản lý bán hàng cửa hàng bánh ngọt");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pm_quanly_cuahangbanh/image/icons8-admin-settings-male-60.png"))); // NOI18N
        jLabel1.setText("Đăng Nhập");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pm_quanly_cuahangbanh/image/icons8-test-account-24.png"))); // NOI18N
        jLabel2.setText("ID");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pm_quanly_cuahangbanh/image/icons8-key-2-24.png"))); // NOI18N
        jLabel4.setText("Mật khẩu");

        btn_dangnhap.setBackground(java.awt.Color.lightGray);
        btn_dangnhap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pm_quanly_cuahangbanh/image/icons8-login-24.png"))); // NOI18N
        btn_dangnhap.setText("Đăng Nhập");
        btn_dangnhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dangnhapActionPerformed(evt);
            }
        });

        lb_quenmatkhau.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pm_quanly_cuahangbanh/image/icons8-password-reset-24.png"))); // NOI18N
        lb_quenmatkhau.setText("Quên mật khẩu?");
        lb_quenmatkhau.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_quenmatkhauMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(121, 121, 121))
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lb_quenmatkhau)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(49, 49, 49))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_matkhau, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_id)
                            .addComponent(btn_dangnhap, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_matkhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addComponent(btn_dangnhap)
                .addGap(18, 18, 18)
                .addComponent(lb_quenmatkhau)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public boolean loi_kytu (String chuoi){
        boolean kt =false;
        if(chuoi.length()>5||chuoi.length()<5){
            kt = false;
            return kt;
        }else{
            kt=true;
            return kt;
        }
    }
    private void BatLoiID(){
        String getid = txt_id.getText();
        String mkht = txt_matkhau.getText();
        Connect a = new Connect();
        Connection conn = a.getConnection();
        if((getid.isEmpty() || mkht.isEmpty()) || (getid.isEmpty() && mkht.isEmpty())){
            JOptionPane.showMessageDialog(null, "Thiếu thông tin", "Thông báo", JOptionPane.ERROR_MESSAGE);
        }else if((getid.length()!=5 || mkht.length()!=5) || (getid.length()!=5 && mkht.length()!=5)){
            JOptionPane.showMessageDialog(null, "Thông tin đúng 5 ký tự", "Thông báo", JOptionPane.ERROR_MESSAGE);
        }else{
            try {
            PreparedStatement pr = conn.prepareStatement("select idnhanvien, matkhau from taikhoan where idnhanvien = ? and matkhau = ? and tinhtrang like 'Active'");
            pr.setString(1, getid);
            pr.setString(2, mkht);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                ID=getid;
                DangNhap.this.setVisible(false);
                new Menu().setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Sai thông tin!", "Thông báo", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Thất bại!", "Thông báo", JOptionPane.ERROR_MESSAGE);
        }
        }
    }
    
    private void btn_dangnhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dangnhapActionPerformed
        // TODO add your handling code here:
        BatLoiID();
    }//GEN-LAST:event_btn_dangnhapActionPerformed

    private void lb_quenmatkhauMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_quenmatkhauMouseClicked
        // TODO add your handling code here:

        DangNhap.this.setVisible(false);
        new Quenmatkhau().setVisible(true);
    }//GEN-LAST:event_lb_quenmatkhauMouseClicked

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
            java.util.logging.Logger.getLogger(DangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DangNhap().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_dangnhap;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lb_quenmatkhau;
    private javax.swing.JTextField txt_id;
    private javax.swing.JPasswordField txt_matkhau;
    // End of variables declaration//GEN-END:variables
}
