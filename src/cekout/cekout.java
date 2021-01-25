/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cekout;

import datatamu.datatamu;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import koneksi.Koneksi;

/**
 *
 * @author cyber61
 */
public class cekout {

    private Koneksi con = new Koneksi();
    private Statement s;
    private PreparedStatement ps;
    private ResultSet rs;

    private String insert = "insert into percobaan (id,kamar) values (?, ?)";

    public void save(int id, String kamar) {
        try {
            ps = con.getCon().prepareStatement(insert);
            ps.setInt(1, id);
            ps.setString(2, kamar);

            ps.executeUpdate();
//            JOptionPane.showMessageDialog(null, "Tambah data berhasil ^^");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    public void savedatariwayat(datatamu tamu){
        
    }

}
