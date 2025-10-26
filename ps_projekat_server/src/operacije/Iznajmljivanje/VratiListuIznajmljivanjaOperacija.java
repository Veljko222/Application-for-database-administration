/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije.Iznajmljivanje;

import java.util.List;
import modeli.Iznajmljivanje;
import modeli.StavkeIznajmljivanja;
import operacije.ApstraktnaGenerickaOperacija;

/**
 *
 * @author User
 */
public class VratiListuIznajmljivanjaOperacija extends ApstraktnaGenerickaOperacija {
    private List<Iznajmljivanje> iznajmljivanja;
     private List<StavkeIznajmljivanja> stavke;
    @Override
    protected void preduslovi(Object param) throws Exception {
       
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
       
        if( param instanceof Iznajmljivanje){
        Iznajmljivanje iznajmljivanje= new Iznajmljivanje();
        
        
        iznajmljivanja = broker.getAll(iznajmljivanje, kljuc);
        }else{
            
            StavkeIznajmljivanja stavka= new StavkeIznajmljivanja();
        
        
            stavke = broker.getAll(stavka, kljuc);
        }
         
    }

    public List<Iznajmljivanje> getIznajmljivanja() {
        return iznajmljivanja;
    }
    
    public List<StavkeIznajmljivanja> getStavke() {
        return stavke;
    }
}
