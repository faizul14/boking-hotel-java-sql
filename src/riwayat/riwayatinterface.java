/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package riwayat;

import javax.swing.JTable;

/**
 *
 * @author cyber61
 */
public interface riwayatinterface {

    public void read(JTable tabel);

    public void create(datariwayat data);
    
    public void loadva1();
    
    public void search(JTable tabel, String nama);
}
