/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forme.modeli_tabela;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modeli.StavkeIznajmljivanja;

/**
 *
 * @author User
 */
public class ModelTblStavkeIznajmljivanja extends AbstractTableModel {
  List<StavkeIznajmljivanja> stavke= new ArrayList<>();
    String[] columns={"Id iznajmljivanja", "Id stavke","Broj sati", "Naziv trotineta", "Cena po satu", "Iznos","Trotinet"};

    public ModelTblStavkeIznajmljivanja(List<StavkeIznajmljivanja> stavke) {
        this.stavke=stavke;
    }
    
    

    @Override
    public int getRowCount() {
        if(stavke!=null)
        return stavke.size();
        
        return 0;
    }

    @Override
    public int getColumnCount() {
           return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        StavkeIznajmljivanja stavka=stavke.get(rowIndex);
        
        switch(columnIndex){
            case 0: return stavka.getIdStavke();
            case 1: return stavka.getIdIznajmljivanja();
            case 2: return stavka.getBrojSati();
            case 3: return stavka.getTrotinet().getNaziv();
            case 4: return stavka.getCenaPoSatu();
            case 5: return stavka.getBrojSati()*stavka.getCenaPoSatu();
            case 6: return stavka.getTrotinet();
            
            default: return "N/A";
        }
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }
}
