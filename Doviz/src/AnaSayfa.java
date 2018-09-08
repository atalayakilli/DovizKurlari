
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.text.DecimalFormat;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import org.jsoup.Jsoup;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Atakan
 */
public class AnaSayfa extends javax.swing.JFrame {

    /**
     * Creates new form AnaSayfa
     */
    public AnaSayfa() {
        initComponents();
        kurGetir();
        txtSon.setEditable(false);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblData = new javax.swing.JTable();
        cmb1 = new javax.swing.JComboBox<>();
        txtIlk = new javax.swing.JTextField();
        cmb2 = new javax.swing.JComboBox<>();
        txtSon = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblData);

        cmb1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb1ActionPerformed(evt);
            }
        });

        txtIlk.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIlkKeyReleased(evt);
            }
        });

        cmb2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmb2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1192, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cmb2, javax.swing.GroupLayout.Alignment.LEADING, 0, 79, Short.MAX_VALUE)
                            .addComponent(cmb1, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtIlk)
                            .addComponent(txtSon, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmb1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIlk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmb2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmb1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb1ActionPerformed
        cevir();
    }//GEN-LAST:event_cmb1ActionPerformed

    private void cmb2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb2ActionPerformed
        cevir();
    }//GEN-LAST:event_cmb2ActionPerformed

    private void txtIlkKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIlkKeyReleased
        cevir();
    }//GEN-LAST:event_txtIlkKeyReleased
public void cevir()
{
     String secilenKod1 = String.valueOf(cmb1.getSelectedItem());
        String secilenKod2 = String.valueOf(cmb2.getSelectedItem());
        
        int satirSayisi = tblData.getRowCount();
        int secilenSatir1 = 0;
        for(int i = 0 ; i<satirSayisi ; i++)
        {
           String kod = String.valueOf(tblData.getValueAt(i, 1));
           if(secilenKod1.equals(kod))
           {
               secilenSatir1=i;
           }
        }
        float secilenSatis1 = Float.valueOf((""+tblData.getValueAt(secilenSatir1, 3)).replace(",", "."));
        int secilenSatir2 = 0;
        for(int i = 0 ; i<satirSayisi ; i++)
        {
           String kod = String.valueOf(tblData.getValueAt(i, 1));
           if(secilenKod2.equals(kod))
           {
               secilenSatir2=i;
           }
        }
      float secilenSatis2 = Float.valueOf((""+tblData.getValueAt(secilenSatir2, 3)).replace(",", "."));
      float istenilen = (Float.valueOf(txtIlk.getText().trim())*secilenSatis1)/secilenSatis2;
      txtSon.setText(""+istenilen);
}
     public void kurGetir()
 {
     DefaultComboBoxModel combo1 = new DefaultComboBoxModel();
     DefaultComboBoxModel combo2 = new DefaultComboBoxModel();
     DefaultTableModel dtm = new DefaultTableModel();
     
      String url = "https://www.doviz.com/api/v1/currencies/all/latest";
               try {
          String data = Jsoup.connect(url).timeout(30000).ignoreContentType(true).get().body().text();
          JsonParser jpars = new JsonParser();
          JsonArray array=jpars.parse(data).getAsJsonArray();
          
            
                   
                   dtm.addColumn("Kur İsmi");
                   dtm.addColumn("Kur Kodu");
                   dtm.addColumn("Alış");
                   dtm.addColumn("Satış");
                   dtm.addColumn("Değişim Oranı");
                   
          for(int i = 0; i<array.size();i++)
          {
              String kurIsmi = array.get(i).getAsJsonObject().get("full_name").getAsString();
              String kurKodu = array.get(i).getAsJsonObject().get("code").getAsString();
              String alis = new DecimalFormat("##.####").format(array.get(i).getAsJsonObject().get("buying").getAsFloat());
              String satis = new DecimalFormat("##.####").format(array.get(i).getAsJsonObject().get("selling").getAsFloat());
              String degisimOrani = new DecimalFormat("##.###").format(array.get(i).getAsJsonObject().get("change_rate").getAsFloat());
              dtm.addRow(new String[]{kurIsmi,kurKodu,alis,satis,degisimOrani});
              combo1.addElement(kurKodu);
              combo2.addElement(kurKodu);
              
          }
          tblData.setModel(dtm);
          cmb1.setModel(combo1);
          cmb2.setModel(combo2);
          
          
 } catch (Exception e) {
                   System.out.println("hata: "+e);
      }}
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
            java.util.logging.Logger.getLogger(AnaSayfa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AnaSayfa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AnaSayfa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AnaSayfa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AnaSayfa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmb1;
    private javax.swing.JComboBox<String> cmb2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblData;
    private javax.swing.JTextField txtIlk;
    private javax.swing.JTextField txtSon;
    // End of variables declaration//GEN-END:variables
}
