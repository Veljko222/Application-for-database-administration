/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forme.modeli_tabela;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modeli.Mesto;

/**
 *
 * @author User
 */
public class ModelTblMesto extends AbstractTableModel{
    List<Mesto> mesta= new ArrayList<>();
    String[] columns={"ID", "Naziv"};

    public ModelTblMesto(List<Mesto> mesta) {
        this.mesta=mesta;
    }
    
    

    @Override
    public int getRowCount() {
        if(mesta!=null)
        return mesta.size();
        
        return 0;
    }

    @Override
    public int getColumnCount() {
           return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Mesto mesto=mesta.get(rowIndex);
        
        switch(columnIndex){
            case 0: return mesto.getIdMesta();
            case 1: return mesto.getNaziv();
            default: return "N/A";
        }
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }
}
