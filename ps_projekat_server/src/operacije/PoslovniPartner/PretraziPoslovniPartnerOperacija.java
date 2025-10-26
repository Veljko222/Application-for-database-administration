/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije.PoslovniPartner;

import java.util.List;
import modeli.PoslovniPartner;
import operacije.ApstraktnaGenerickaOperacija;

/**
 *
 * @author User
 */
public class PretraziPoslovniPartnerOperacija extends ApstraktnaGenerickaOperacija {
     private List<PoslovniPartner> PoslovniPartner;
    @Override
    protected void preduslovi(Object param) throws Exception {
        
   
         if(param==null || !(param instanceof PoslovniPartner)){
                throw new Exception("Niste uneli odgovarajuce parametre");
            }
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
         PoslovniPartner partner=(PoslovniPartner) param;
        if(partner.getIdPoslovniPartner()!=0 || partner.getIme()!=null || partner.getPrezime()!=null || partner.getMesto()!=null ){
           kljuc+=" where"; 
        if(partner.getIdPoslovniPartner()!=0)
            kljuc+=" idPoslovniPartner="+partner.getIdPoslovniPartner();
        if(partner.getIme()!=null)
            kljuc+=" ime=\""+partner.getIme()+"\"";
        if(partner.getPrezime()!=null)
            kljuc+=" prezime="+partner.getPrezime()+"\"";
        if(partner.getMesto()!=null)
        if(partner.getMesto().getIdMesta()!=0)
            kljuc+=" mesto.idMesta="+partner.getMesto().getIdMesta();
        
          
        }
        PoslovniPartner = broker.getAll(partner, kljuc);
}
        
             
             
    

    public List<PoslovniPartner> getPoslovniPartner() {
        return PoslovniPartner;
    }   
}
