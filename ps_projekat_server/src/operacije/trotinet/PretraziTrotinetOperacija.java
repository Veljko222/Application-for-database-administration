/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije.trotinet;

import java.util.List;
import modeli.Trotinet;
import operacije.ApstraktnaGenerickaOperacija;

/**
 *
 * @author User
 */
public class PretraziTrotinetOperacija extends ApstraktnaGenerickaOperacija {
private List<Trotinet> Trotineti;
    @Override
    protected void preduslovi(Object param) throws Exception {
        
   
         if(param==null || !(param instanceof Trotinet)){
                throw new Exception("Niste uneli odgovarajuce parametre");
            }
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
         Trotinet trotinet=(Trotinet) param;
        if(trotinet.getIdTrotineta()!=0 || trotinet.getNaziv()!=null || trotinet.getCenaPoSatu()!=0){
           kljuc+=" where"; 
        if(trotinet.getIdTrotineta()!=0)
            kljuc+=" idTrotineta="+trotinet.getIdTrotineta();
        if(trotinet.getNaziv()!=null)
            kljuc+=" Naziv=\""+trotinet.getNaziv()+"\"";
        if(trotinet.getCenaPoSatu()!=0)
            kljuc+=" cenaPoSatu="+trotinet.getCenaPoSatu();
        }
        Trotineti = broker.getAll(trotinet, kljuc);
}
        
             
             
    

    public List<Trotinet> getTrotineti() {
        return Trotineti;
    }
    
}
