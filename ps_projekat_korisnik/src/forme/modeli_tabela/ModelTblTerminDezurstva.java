/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forme.modeli_tabela;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modeli.TerminDezurstva;

/**
 *
 * @author User
 */
public class ModelTblTerminDezurstva extends AbstractTableModel{
    List<TerminDezurstva> termini= new ArrayList<>();
    String[] columns={"ID", "Pocetak","Kraj", "Trajanje"};

    public ModelTblTerminDezurstva(List<TerminDezurstva> termini) {
        this.termini=termini;
    }
    
    

    @Override
    public int getRowCount() {
        if(termini!=null)
            return termini.size();
        
        
        return 0;
        
    }

    @Override
    public int getColumnCount() {
           return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        TerminDezurstva termin=termini.get(rowIndex);
        
        switch(columnIndex){
            case 0: return termin.getIdDezurstva();
            case 1: return termin.getPocetak();
            case 2: return termin.getKraj();
            case 3: return termin.getTrajanje(); 
            default: return "N/A";
        }
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    } 
}
