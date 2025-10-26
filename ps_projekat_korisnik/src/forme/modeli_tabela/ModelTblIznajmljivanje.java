/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forme.modeli_tabela;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modeli.Iznajmljivanje;

/**
 *
 * @author User
 */
public class ModelTblIznajmljivanje extends AbstractTableModel {
        List<Iznajmljivanje> iznajmljivanja= new ArrayList<>();
    String[] columns={"ID", "Iznos", "Ime zaposlenog", "Ime partnera", "Zaposleni", "Partner"};

    public ModelTblIznajmljivanje(List<Iznajmljivanje> iznajmljivanja) {
        this.iznajmljivanja=iznajmljivanja;
    }
    
    

    @Override
    public int getRowCount() {
        if(iznajmljivanja!=null)
        return iznajmljivanja.size();
        
        return 0;
    }

    @Override
    public int getColumnCount() {
           return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Iznajmljivanje iznajmljivanje=iznajmljivanja.get(rowIndex);
        
        switch(columnIndex){
            case 0: return iznajmljivanje.getIdIznajmljivanja();
            case 1: return iznajmljivanje.getCena();
            case 2: return iznajmljivanje.getZaposleni().getIme() + " " + iznajmljivanje.getZaposleni().getPrezime();
            case 3: return iznajmljivanje.getPartner().getIme()+ " " + iznajmljivanje.getPartner().getPrezime();
            case 4: return iznajmljivanje.getZaposleni();
            case 5: return iznajmljivanje.getPartner();
            default: return "N/A";
        }
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }
}
