/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datatamu;

import datakamar.datakamar;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import koneksi.Koneksi;
import riwayat.riwayatinterface;
import riwayat.riwayatinterfaceimplm;

/**
 *
 * @author cyber61
 */
public class tamuinterfaceimplm implements tamuinterface {

    private Koneksi con = new Koneksi();
    private Statement s;
    private PreparedStatement ps;
    private ResultSet rs;
    private DefaultTableModel dtm;
    private final String[] column = {"ID", "NAMA", "NO KTP", "NO HP", "ALAMAT", "JENIS KAMAR", "QTY", "CEKIN", "CEKOUT"};
    private String insert = "insert into tamu (id_kamar, nama, no_ktp, no_telp, alamat, jkdb, tanggal_cekin, tanggal_cekout,subtotal,status) values (?, ?, ?, ?, ?, ?, ?, ?, ?,?)";

    private String loadBarang = "select * from kamar";
    private String view = "select * from tamu JOIN kamar WHERE kode_kamar=id_kamar AND tamu.status='CEKIN'";
    private String delete = "delete from tamu where id=?";
    private String update = "update tamu set status='CEKOUT' where id=?";

    private List<datatamu> listjeniskamar;

    public tamuinterfaceimplm() {
        listjeniskamar = new ArrayList<>();
    }

    @Override
    public List<datakamar> loadkamar() {
        //instansiasi kamarlist
        List<datakamar> kamarlist = new ArrayList<>();

        try {
            s = con.getCon().createStatement();
            rs = s.executeQuery(loadBarang);

            //proses pengisian barangList
            while (rs.next()) {
                datakamar kamar = new datakamar();
                kamar.setKodekamar(rs.getInt("kode_kamar"));
                kamar.setJeniskamar(rs.getString("jenis_kamar"));
                kamar.setTarifkamar(rs.getInt("tarif_kamar"));
                kamar.setStok(rs.getInt("stok"));
                kamar.setStatus(rs.getString("status_kamar"));

                kamarlist.add(kamar);
            }
        } catch (Exception ex) {
            Logger.getLogger(tamuinterfaceimplm.class.getName()).log(Level.SEVERE, null, ex);
        }

        //pengembalian nilai supplierList
        return kamarlist;
    }

    @Override
    public void read(JTable tabel) {
        try {
            dtm = new DefaultTableModel(null, column);
            s = con.getCon().createStatement();
            rs = s.executeQuery(view);  //eksekusi yg tdk merubah isi tabel
            while (rs.next()) {
                Object[] va = new Object[9];
                va[0] = rs.getInt("id");
                va[1] = rs.getString("nama");
                va[2] = rs.getInt("no_ktp");
                va[3] = rs.getInt("no_telp");
                va[4] = rs.getString("alamat");
                va[5] = rs.getString("jenis_kamar");
                va[6] = rs.getInt("jkdb");
                va[7] = rs.getDate("tanggal_cekin");
                va[8] = rs.getDate("tanggal_cekout");

                dtm.addRow(va);
            }
            tabel.setModel(dtm);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }

    @Override
    public void create(datatamu tamu) {
        try {
            ps = con.getCon().prepareStatement(insert);
            ps.setInt(1, tamu.getIdkamar());
            ps.setString(2, tamu.getNama());
            ps.setString(3, tamu.getNoktp());
            ps.setString(4, tamu.getNotelp());
            ps.setString(5, tamu.getAlamat());
            ps.setInt(6, tamu.getJkdb());
            ps.setString(7, tamu.getCekin());
            ps.setString(8, tamu.getCekout());
            ps.setString(9, tamu.getSubtotal());
            ps.setString(10, tamu.getStatus());

            ps.executeUpdate();
            riwayatinterface faezol = new riwayatinterfaceimplm();
            faezol.loadva1();
            JOptionPane.showMessageDialog(null, "Tambah data berhasil ^^");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        try {
            ps = con.getCon().prepareStatement(delete);
            ps.setString(1, String.valueOf(id));
            ps.executeUpdate();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    @Override
    public void cekout(int data) {

        try {
            ps = con.getCon().prepareStatement(update);
            ps.setInt(1, data);
//            ps.setString(2, user.getPassword());
//            ps.setString(3, user.getNama());
//            ps.setString(4, user.getNo());
//            ps.setString(5, user.getAlamat());
//
//            ps.setString(6, String.valueOf(user.getId()));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "CEKOUT BERHASIL ^^");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

}
