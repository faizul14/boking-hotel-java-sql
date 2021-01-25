/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datakamar;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import koneksi.Koneksi;

/**
 *
 * @author cyber61
 */
public class kamarinterfaceimpl implements kamarinterface {

    private Koneksi con = new Koneksi();
    private Statement s;
    private PreparedStatement ps;
    private ResultSet rs;
    private DefaultTableModel dtm;
    private final String[] column = {"ID KAMAR", "JENIS KAMAR", "TARIF", "STOK", "STATUS"};

    private String view = "select * from kamar";

    @Override
    public void read(JTable tabel) {
        try {
            dtm = new DefaultTableModel(null, column);
            s = con.getCon().createStatement();
            rs = s.executeQuery(view);  //eksekusi yg tdk merubah isi tabel
            while (rs.next()) {
                Object[] va = new Object[6];
                va[0] = rs.getInt("kode_kamar");
                va[1] = rs.getString("jenis_kamar");
                va[2] = rs.getInt("tarif_kamar");
                va[3] = rs.getInt("stok");
                va[4] = rs.getString("status_kamar");

                dtm.addRow(va);
            }
            tabel.setModel(dtm);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

}
