/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datatamu;

import datakamar.datakamar;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author cyber61
 */
public interface tamuinterface {

    public List<datakamar> loadkamar();

    public void read(JTable tabel);

    public void create(datatamu tamu);
    
    public void delete(int id);
    
    public void cekout(int data);
}
