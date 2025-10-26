/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forme.modeli_tabela;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modeli.Zaposleni;

/**
 *
 * @author User
 */
public class ModelTblZaposleni extends AbstractTableModel {
     List<Zaposleni> sviZaposleni= new ArrayList<>();
    String[] columns={"ID", "Naziv", "Ime", "Prezime", "Lozinka"};

    public ModelTblZaposleni(List<Zaposleni> sviZaposleni) {
        this.sviZaposleni=sviZaposleni;
    }
    
    

    @Override
    public int getRowCount() {
        if(sviZaposleni!=null)
        return sviZaposleni.size();
        
        return 0;
    }

    @Override
    public int getColumnCount() {
           return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Zaposleni mesto=sviZaposleni.get(rowIndex);
        
        switch(columnIndex){
            case 0: return mesto.getIdZaposlenog();
            case 1: return mesto.getIme();
            case 2: return mesto.getPrezime();
            case 3: return mesto.getEmail();
            case 4: return mesto.getLozinka();
            default: return "N/A";
        }
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }
}
