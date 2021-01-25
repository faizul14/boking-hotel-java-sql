/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import koneksi.Koneksi;

/**
 *
 * @author cyber61
 */
public class logininterfaceimpl implements logininterface {

    private String loginquery = "select * from user where username = ? and password= ?";
    private PreparedStatement ps;
    private ResultSet rs;
    private final Koneksi koneksi = new Koneksi();

    @Override
    public void login(String username, String password) {
        try {
            ps = koneksi.getCon().prepareStatement(loginquery);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            while (rs.next()) {
                datalogin.session = true;
                datalogin.NAMA = rs.getString("nama");
                datalogin.USER_ID = rs.getInt("id");
            }
        } catch (Exception ex) {
            //Logger.getLogger(LoginDAOImp.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    @Override
    public void logout() {
        datalogin.session = false;
        datalogin.NAMA = "";
        datalogin.USER_ID = 0;
        datalogin.STATUS = "";
    }

}
