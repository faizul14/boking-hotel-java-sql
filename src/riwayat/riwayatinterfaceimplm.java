/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package riwayat;

import datakamar.datakamar;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import koneksi.Koneksi;
import login.datalogin;
import login.login;

/**
 *
 * @author cyber61
 */
public class riwayatinterfaceimplm implements riwayatinterface {

    private int id_tamu;
    private Koneksi con = new Koneksi();
    private Statement s;
    private PreparedStatement ps;
    private ResultSet rs;
    private ResultSet ru;
    private DefaultTableModel dtm;

    private final String[] column = {"NAMA", "NO KTP", "NO HP", "ALAMAT", "JENIS KAMAR", "QTY", "CEK IN", "CEK OUT", "TOTAL", "USER"};

    private String view = "select * from riwayat JOIN user WHERE id=id_user ";
    private String loadva = "SELECT * FROM tamu ORDER BY id DESC LIMIT 1";
    private String view1 = "SELECT kamar.jenis_kamar,riwayat.*,user.* FROM riwayat JOIN kamar ON riwayat.id_kamar=kamar.kode_kamar JOIN user ON riwayat.id_user=user.id ";
    private String view2 = "SELECT kamar.jenis_kamar,riwayat.*,user.*,tamu.* FROM riwayat JOIN kamar ON riwayat.id_kamar=kamar.kode_kamar JOIN user ON riwayat.id_user=user.id JOIN tamu ON riwayat.id_tamu=tamu.id WHERE tamu.status='CEKOUT'";
    private String insert = "insert into riwayat (id_user, id_kamar, nama , no_ktp, no_telp, alamat, qty, tanggal_cekin, tanggal_cekout,sub_total) values (?, ?, ?, ?, ?,?, ?, ?, ?, ?)";
    private String insert1 = "insert into riwayat (id_user, id_kamar, id_tamu) values (?, ?, ?)";
    private String search1 = "SELECT kamar.jenis_kamar,riwayat.*,user.* FROM riwayat JOIN kamar ON riwayat.id_kamar=kamar.kode_kamar JOIN user ON riwayat.id_user=user.id WHERE riwayat.nama LIKE '%?%'";

    @Override
    public void read(JTable tabel) {
        try {
            dtm = new DefaultTableModel(null, column);
            s = con.getCon().createStatement();
            rs = s.executeQuery(view2);  //eksekusi yg tdk merubah isi tabel
            while (rs.next()) {
                Object[] col = new Object[10];
                col[0] = rs.getString("tamu.nama");
                col[1] = rs.getString("tamu.no_ktp");
                col[2] = rs.getString("no_telp");
                col[3] = rs.getString("tamu.alamat");
                col[4] = rs.getString("jenis_kamar");
                col[5] = rs.getInt("tamu.jkdb");
                col[6] = rs.getString("tamu.tanggal_cekin");
                col[7] = rs.getString("tamu.tanggal_cekout");
                col[8] = rs.getInt("tamu.subtotal");
                col[9] = rs.getString("user.nama");

                dtm.addRow(col);
            }
            tabel.setModel(dtm);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    @Override
    public void create(datariwayat data) {
        try {
            ps = con.getCon().prepareStatement(insert1);
            ps.setInt(1, data.getId_user());
            ps.setInt(2, data.getKode_kamar());
            ps.setInt(3, data.getId_tamu());

            ps.executeUpdate();
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }

    @Override
    public void search(JTable tabel, String nama) {

        DefaultTableModel dtm = new DefaultTableModel(null, column);
        String search12 = "SELECT kamar.jenis_kamar,riwayat.*,user.* FROM riwayat JOIN kamar ON riwayat.id_kamar=kamar.kode_kamar JOIN user ON riwayat.id_user=user.id WHERE riwayat.nama LIKE '%" + nama + "%'";

        try {
//            ps = con.getCon().prepareStatement(search1);
//            ps.setString(1, nama);
//            s = con.getCon().createStatement();
//            rs = ps.executeQuery();  //eksekusi yg tdk merubah isi tabel
            s = con.getCon().createStatement();
            rs = s.executeQuery(search12);  //eksekusi yg tdk merubah isi tabel
            while (rs.next()) {
                Object[] col = new Object[10];
                col[0] = rs.getString("nama");
                col[1] = rs.getString("no_ktp");
                col[2] = rs.getString("no_telp");
                col[3] = rs.getString("alamat");
                col[4] = rs.getString("jenis_kamar");
                col[5] = rs.getInt("qty");
                col[6] = rs.getString("tanggal_cekin");
                col[7] = rs.getString("tanggal_cekout");
                col[8] = rs.getInt("sub_total");
                col[9] = rs.getString("user.nama");

                dtm.addRow(col);
            }
            tabel.setModel(dtm);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        tabel.setModel(dtm);
    }



    @Override
    public void loadva1() {
        datalogin login = new datalogin();
        try {
            s = con.getCon().createStatement();
            rs = s.executeQuery(loadva);  //eksekusi yg tdk merubah isi tabel
            while (rs.next()) {
                datariwayat data = new datariwayat();
                data.setId_tamu(rs.getInt("id"));
                data.setKode_kamar(rs.getInt("id_kamar"));
                data.setId_user(login.USER_ID);
                create(data);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }

}
