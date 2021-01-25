/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import javax.swing.JTable;

/**
 *
 * @author cyber61
 */
public interface userinterface {

    public void read(JTable tabel);

    public void create(datauser user);

    public void update(datauser user);

    public void delete(int id);

    public void cari(String key);
}
