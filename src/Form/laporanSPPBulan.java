/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Aries
 */
public class laporanSPPBulan extends javax.swing.JInternalFrame {

    /**
     * Creates new form laporanSPP
     */
    ResultSet r;
    Statement s;
    Connection c;
    public laporanSPPBulan() {
        initComponents();
        
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jcbulan = new javax.swing.JComboBox<>();
        txtTahun = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();

        setTitle("Input Parameter Cetak");

        jPanel1.setBackground(new java.awt.Color(51, 51, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Print_17px.png"))); // NOI18N
        jButton1.setText("Cetak");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, 90, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Cancel_17px.png"))); // NOI18N
        jButton2.setText("Keluar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, 90, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("Pilih Tahun :");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 90, -1));

        jcbulan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { ".. Bulan ..", "Januari", "Februai", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember" }));
        jPanel2.add(jcbulan, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, -1, -1));

        txtTahun.setText("2018");
        txtTahun.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTahunKeyTyped(evt);
            }
        });
        jPanel2.add(txtTahun, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 80, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("Pilih Bulan :");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 90, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 380, 120));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private static String path = System.getProperty("user.dir")+"/src/Laporan/";
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String Bulan = String.valueOf(jcbulan.getSelectedItem());
         String Tahun = (txtTahun.getText());
        if("..Bulan..".equals(jcbulan.getSelectedItem())){
            JOptionPane.showMessageDialog(null,"Bulan masih Kosong");
        }else{
            String filename = path+"LaporanSPPBulan.jrxml";
            JasperReport jasrep;
            JasperPrint japri;
            JasperViewer javie = null;
            HashMap param = new HashMap(2);
            JasperDesign jasdes;
            try {
                param.put("bulan",Bulan);
                param.put("tahun",Tahun);
   //             param.put("tglsampai",Selesai);
                
     //           if(jComboBox1.getSelectedIndex()==0){
                    File report = new File(filename);
                    jasdes = JRXmlLoader.load(report);
                    jasrep = JasperCompileManager.compileReport(jasdes);
                    japri = JasperFillManager.fillReport(jasrep,param,Komponen.koneksi.GetConnection());
                    javie.viewReport(japri,false);
       //         }
            } catch (Exception e) {
                System.out.print(e);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtTahunKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTahunKeyTyped
         char enter=evt.getKeyChar();  
        if(txtTahun.getText().length() == 4){
         evt.consume();
     } else if(!(Character.isDigit(enter))){//hanya bisa menginput angka
        evt.consume();
        }
    }//GEN-LAST:event_txtTahunKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JComboBox<String> jcbulan;
    private javax.swing.JTextField txtTahun;
    // End of variables declaration//GEN-END:variables
}
