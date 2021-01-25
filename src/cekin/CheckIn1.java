/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cekin;

import datakamar.datakamar;
import datatamu.datatamu;
import datatamu.tamuinterface;
import datatamu.tamuinterfaceimplm;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import login.datalogin;
import login.login;
import riwayat.riwayatinterface;
import riwayat.riwayatinterfaceimplm;
import uas.*;
import user.datauser;

/**
 *
 * @author HP
 */
public class CheckIn1 extends javax.swing.JFrame {
    private String status= "CEKIN";
    private int barangId;
    private tamuinterface va;
    private List<datakamar> kamarlist;
    private String tglcekin, tglcekout;

    public CheckIn1() {
        if (datalogin.session == false) {
            new login().setVisible(true);
            return;
        } else {
            initComponents();
            va = new tamuinterfaceimplm();
            loadkamar();
        }
    }

    private void save() {
        if (validasi()) {
            create();
            resetui();
        } else {
            JOptionPane.showMessageDialog(null, "Belum ada Inputan ^-^");
        }
    }

    private void loadkamar() {
        kamarlist = va.loadkamar();
        //store combobox
        cbjeniskamar.removeAllItems();
        cbjeniskamar.addItem("Pilih...");
        for (datakamar b : kamarlist) {
            cbjeniskamar.addItem(b.getJeniskamar());
        }
    }

    private void masukkanidentitaskamar() {
        int index = cbjeniskamar.getSelectedIndex();
        if (index == 0) {
            barangId = 0;
            tfkodekamar.setText("");
            tfstatuskamar.setText("");
            tftarif.setText("");
        } else {
//            barangId = kamarlist.get(index - 1).getKodekamar();
//            tfjeniskamar.setText(String.valueOf(kamarlist.get(index - 1).getJeniskamar()));
            try {
                barangId = kamarlist.get(index - 1).getKodekamar();
                tfkodekamar.setText(String.valueOf(kamarlist.get(index - 1).getKodekamar()));
                tftarif.setText(String.valueOf(kamarlist.get(index - 1).getTarifkamar()));
                tfstatuskamar.setText(String.valueOf(kamarlist.get(index - 1).getStatus()));
            } catch (ArrayIndexOutOfBoundsException e) {
//                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }

    private void create() {
        datatamu tamu = new datatamu();
         
        tamu.setIdkamar(barangId);
        tamu.setNama(tfnama.getText());
        tamu.setNoktp(tfnoktp.getText());
        tamu.setNotelp(tfhp.getText());
        tamu.setAlamat(tfalamat.getText());
        tamu.setJkdb(Integer.valueOf(tfqty.getText()));
        tamu.setCekin(tglcekin);
        tamu.setCekout(tglcekout);
        tamu.setSubtotal(subtotal.getText());
        tamu.setStatus(status);

        va.create(tamu);
        
    }

    private void subtotal() {
        if (tftarif.getText().isEmpty() || tfqty.getText().isEmpty() || tglcekin.isEmpty() || tglcekout.isEmpty()) {
            subtotal.setText("0_");
        } else {
            int subtotal1;
            int lama = Integer.valueOf(hitunglamainap());
            subtotal1 = Integer.valueOf(tftarif.getText()) * Integer.valueOf(tfqty.getText()) * lama;
//            subtotal.setText(tftarif.getText());
            subtotal.setText(String.valueOf(subtotal1));
        }
    }

    private void resetui() {
        tfnama.setText("");
        tfnoktp.setText("");
        tfhp.setText("");
        tfalamat.setText("");
        tfqty.setText("");
        datecekin.setDate(null);
        datecekout.setDate(null);
        cbjeniskamar.setSelectedIndex(0);
        tfkodekamar.setText("");
        tftarif.setText("");
        tfstatuskamar.setText("");
        subtotal.setText("0_");

    }

    private String hitunglamainap() {
        String lama1 = null;
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date cekin = format.parse(tglcekin);
            Date cekout = format.parse(tglcekout);
            long cekin1 = cekin.getTime();
            long cekout1 = cekout.getTime();
            long diff = cekout1 - cekin1;
            long lama = diff / (24 * 60 * 60 * 1000);
            lama1 = String.valueOf(lama);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
        return lama1;
    }

    private boolean validasi() {
        if (tfnama.getText().isEmpty() || tfnoktp.getText().isEmpty() || tfhp.getText().isEmpty()
                || tfalamat.getText().isEmpty() || tfqty.getText().isEmpty() || datecekin.getDate() == null
                || datecekout.getDate() == null || cbjeniskamar.getSelectedItem().toString() == "Pilih..."
                || tfkodekamar.getText().isEmpty() || tftarif.getText().isEmpty() || tfstatuskamar.getText().isEmpty()
                || subtotal.getText().isEmpty()) {
            return false;
        }
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollBar1 = new javax.swing.JScrollBar();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        cbjeniskamar = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        tfkodekamar = new javax.swing.JTextField();
        tftarif = new javax.swing.JTextField();
        tfstatuskamar = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tfqty = new javax.swing.JTextField();
        tfalamat = new javax.swing.JTextField();
        tfhp = new javax.swing.JTextField();
        tfnama = new javax.swing.JTextField();
        tfnoktp = new javax.swing.JTextField();
        datecekout = new com.toedter.calendar.JDateChooser();
        jLabel13 = new javax.swing.JLabel();
        datecekin = new com.toedter.calendar.JDateChooser();
        jPanel3 = new javax.swing.JPanel();
        btnsimpan = new javax.swing.JButton();
        btnbatal = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        subtotal = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setForeground(new java.awt.Color(0, 102, 102));

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));
        jPanel2.setForeground(new java.awt.Color(0, 102, 102));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_interior_48px.png"))); // NOI18N
        jLabel7.setText("JENIS KAMAR");

        cbjeniskamar.setBackground(new java.awt.Color(0, 102, 102));
        cbjeniskamar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbjeniskamar.setForeground(new java.awt.Color(255, 255, 255));
        cbjeniskamar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "~ PILIH ~" }));
        cbjeniskamar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbjeniskamarActionPerformed(evt);
            }
        });
        cbjeniskamar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbjeniskamarKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cbjeniskamarKeyReleased(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_room_48px.png"))); // NOI18N
        jLabel10.setText("KODE KAMAR");

        jLabel11.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_price_48px_1.png"))); // NOI18N
        jLabel11.setText("TARIF");

        jLabel12.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(249, 239, 239));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/plus_grey.png"))); // NOI18N
        jLabel12.setText("STATUS");

        tftarif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tftarifActionPerformed(evt);
            }
        });
        tftarif.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tftarifKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tftarifKeyReleased(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(0, 102, 102));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_smart_card_48px.png"))); // NOI18N
        jLabel2.setText("NO.KTP");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_name_skin_type_7_48px_1.png"))); // NOI18N
        jLabel3.setText("NAMA");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_contact_details_48px.png"))); // NOI18N
        jLabel4.setText("NO.HP");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_home_address_48px.png"))); // NOI18N
        jLabel5.setText("ALAMAT");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_key_48px_2.png"))); // NOI18N
        jLabel6.setText("QTY KAMAR");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_calendar_48px_1.png"))); // NOI18N
        jLabel8.setText("TGL CHEK IN");

        tfqty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfqtyKeyReleased(evt);
            }
        });

        datecekout.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                datecekoutPropertyChange(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_calendar_48px_1.png"))); // NOI18N
        jLabel13.setText("TGL CHEK OUT\n");

        datecekin.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                datecekinAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        datecekin.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                datecekinPropertyChange(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(233, 236, 242));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 433, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(datecekout, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(tfqty)
                                .addComponent(tfalamat)
                                .addComponent(tfhp)
                                .addComponent(tfnama)
                                .addComponent(tfnoktp)
                                .addComponent(datecekin, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE))))
                    .addComponent(jLabel13))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(tfnoktp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(tfnama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(tfhp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(tfalamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(tfqty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(datecekin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addComponent(datecekout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27))))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        btnsimpan.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        btnsimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/save.png"))); // NOI18N
        btnsimpan.setText("SIMPAN");
        btnsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsimpanActionPerformed(evt);
            }
        });

        btnbatal.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        btnbatal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/document_warning.png"))); // NOI18N
        btnbatal.setText("BATAL");
        btnbatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbatalActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Ubuntu", 0, 25)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Rp :");

        subtotal.setFont(new java.awt.Font("Ubuntu", 0, 25)); // NOI18N
        subtotal.setForeground(new java.awt.Color(255, 255, 255));
        subtotal.setText("0_");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel7)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnsimpan)
                                .addComponent(jLabel10)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tftarif)
                            .addComponent(tfstatuskamar)
                            .addComponent(btnbatal)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(cbjeniskamar, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tfkodekamar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(subtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cbjeniskamar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(tfkodekamar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(tftarif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(tfstatuskamar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(subtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnbatal)
                    .addComponent(btnsimpan)))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel1.setBackground(new java.awt.Color(0, 102, 102));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_internal_48px.png"))); // NOI18N
        jLabel1.setText("CHEK IN");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(281, 281, 281)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tftarifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tftarifActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tftarifActionPerformed

    private void cbjeniskamarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbjeniskamarKeyReleased

        // TODO add your handling code here:
    }//GEN-LAST:event_cbjeniskamarKeyReleased

    private void cbjeniskamarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbjeniskamarActionPerformed
        masukkanidentitaskamar();  // TODO add your handling code here:
        subtotal();
    }//GEN-LAST:event_cbjeniskamarActionPerformed

    private void cbjeniskamarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbjeniskamarKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbjeniskamarKeyPressed

    private void btnsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsimpanActionPerformed
        save();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnsimpanActionPerformed

    private void datecekinPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_datecekinPropertyChange
        if (datecekin.getDate() != null) {
            SimpleDateFormat format_tanggal = new SimpleDateFormat("yyyy-MM-dd");
            tglcekin = format_tanggal.format(datecekin.getDate());
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_datecekinPropertyChange

    private void datecekoutPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_datecekoutPropertyChange
        if (datecekout.getDate() != null) {
            SimpleDateFormat format_tanggal = new SimpleDateFormat("yyyy-MM-dd");
            tglcekout = format_tanggal.format(datecekout.getDate());
        }// TODO add your handling code here:
    }//GEN-LAST:event_datecekoutPropertyChange

    private void tftarifKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tftarifKeyReleased

        // TODO add your handling code here:
    }//GEN-LAST:event_tftarifKeyReleased

    private void tftarifKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tftarifKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tftarifKeyPressed

    private void btnbatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbatalActionPerformed
        resetui();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnbatalActionPerformed

    private void tfqtyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfqtyKeyReleased
        subtotal();
        // TODO add your handling code here:
    }//GEN-LAST:event_tfqtyKeyReleased

    private void datecekinAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_datecekinAncestorAdded

        // TODO add your handling code here:
    }//GEN-LAST:event_datecekinAncestorAdded

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
            java.util.logging.Logger.getLogger(CheckIn1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CheckIn1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CheckIn1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CheckIn1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CheckIn1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbatal;
    private javax.swing.JButton btnsimpan;
    private javax.swing.JComboBox cbjeniskamar;
    private com.toedter.calendar.JDateChooser datecekin;
    private com.toedter.calendar.JDateChooser datecekout;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JLabel subtotal;
    private javax.swing.JTextField tfalamat;
    private javax.swing.JTextField tfhp;
    private javax.swing.JTextField tfkodekamar;
    private javax.swing.JTextField tfnama;
    private javax.swing.JTextField tfnoktp;
    private javax.swing.JTextField tfqty;
    private javax.swing.JTextField tfstatuskamar;
    private javax.swing.JTextField tftarif;
    // End of variables declaration//GEN-END:variables
}
