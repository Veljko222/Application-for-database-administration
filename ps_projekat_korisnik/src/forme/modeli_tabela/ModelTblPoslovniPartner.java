/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forme.modeli_tabela;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modeli.PoslovniPartner;

/**
 *
 * @author User
 */
public class ModelTblPoslovniPartner extends AbstractTableModel{
    List<PoslovniPartner> partneri= new ArrayList<>();
    String[] columns={"ID", "Ime", "Prezime", "Naziv mesta", "Mesto"};

    public ModelTblPoslovniPartner(List<PoslovniPartner> partneri) {
        this.partneri=partneri;
    }
    
    

    @Override
    public int getRowCount() {
        if(partneri!=null)
        return partneri.size();
        
        return 0;
    }

    @Override
    public int getColumnCount() {
           return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        PoslovniPartner partner=partneri.get(rowIndex);
        
        switch(columnIndex){
            case 0: return partner.getIdPoslovniPartner();
            case 1: return partner.getIme();
            case 2: return partner.getPrezime();
            case 3: return partner.getMesto().getNaziv();
            case 4: return partner.getMesto();
            default: return "N/A";
        }
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }
}
