/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije.mesto;

import java.util.List;
import modeli.Mesto;
import operacije.ApstraktnaGenerickaOperacija;

/**
 *
 * @author User
 */
public class PretraziMestoOperacija extends ApstraktnaGenerickaOperacija {
    private List<Mesto> svaMesta;
    @Override
    protected void preduslovi(Object param) throws Exception {
         if(param==null || !(param instanceof Mesto)){
                throw new Exception("Niste uneli odgovarajuce parametre");
            }
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        Mesto mesto=(Mesto) param;
        if(mesto.getIdMesta()!=0 || mesto.getNaziv()!=null){
           kljuc+=" where"; 
        if(mesto.getIdMesta()!=0)
            kljuc+=" idMesta="+mesto.getIdMesta();
        if(mesto.getNaziv()!=null)
                
            kljuc+=" Naziv=\""+mesto.getNaziv()+"\"";
        }
        
             svaMesta = broker.getAll(mesto, kljuc);
             
    }

    public List<Mesto> getSvaMesta() {
        return svaMesta;
    }
    
    
    
}
