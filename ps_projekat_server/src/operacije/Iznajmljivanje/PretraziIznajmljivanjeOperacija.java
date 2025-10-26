/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije.Iznajmljivanje;

import java.util.List;
import modeli.Iznajmljivanje;
import operacije.ApstraktnaGenerickaOperacija;

/**
 *
 * @author User
 */
public class PretraziIznajmljivanjeOperacija extends ApstraktnaGenerickaOperacija {
    private List<Iznajmljivanje> Iznajmljivanje;
    @Override
    protected void preduslovi(Object param) throws Exception {
        
   
         if(param==null || !(param instanceof Iznajmljivanje)){
                throw new Exception("Niste uneli odgovarajuce parametre");
            }
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
         Iznajmljivanje iznajmljivanje=(Iznajmljivanje) param;
        if(iznajmljivanje.getIdIznajmljivanja()!=0 || iznajmljivanje.getPartner()!=null || iznajmljivanje.getZaposleni()!=null ){
           kljuc+=" where"; 
        if(iznajmljivanje.getIdIznajmljivanja()!=0)
            kljuc+=" idIznajmljivanje="+iznajmljivanje.getIdIznajmljivanja();
        if(iznajmljivanje.getPartner()!=null)
        if(iznajmljivanje.getPartner().getIdPoslovniPartner()!=0)
            kljuc+=" poslovnipartner.IdPoslovniPartner="+iznajmljivanje.getPartner().getIdPoslovniPartner();
        if(iznajmljivanje.getZaposleni()!=null)
        if(iznajmljivanje.getZaposleni().getIdZaposlenog()!=0)
            kljuc+=" zaposleni.IdZaposlenog="+iznajmljivanje.getZaposleni().getIdZaposlenog();
        
       
        
          
        }
        Iznajmljivanje = broker.getAll(iznajmljivanje, kljuc);
}
        
             
             
    

    public List<Iznajmljivanje> getIznajmljivanje() {
        return Iznajmljivanje;
    }   
}
