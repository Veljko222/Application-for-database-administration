/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forme.modeli_tabela;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

import modeli.Trotinet;

/**
 *
 * @author User
 */
public class ModelTblTrotinet extends AbstractTableModel {
    List<Trotinet> trotineti= new ArrayList<>();
    String[] columns={"ID", "Naziv","Cena po satu"};

    public ModelTblTrotinet(List<Trotinet> trotineti) {
        this.trotineti=trotineti;
    }
    
    

    @Override
    public int getRowCount() {
        if(trotineti!=null)
            return trotineti.size();
        
        
        return 0;
        
    }

    @Override
    public int getColumnCount() {
           return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Trotinet trotinet=trotineti.get(rowIndex);
        
        switch(columnIndex){
            case 0: return trotinet.getIdTrotineta();
            case 1: return trotinet.getNaziv();
            case 2: return trotinet.getCenaPoSatu();
            default: return "N/A";
        }
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }
}
