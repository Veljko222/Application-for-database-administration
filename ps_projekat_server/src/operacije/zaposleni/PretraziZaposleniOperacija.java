/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije.zaposleni;

import java.util.List;
import modeli.Zaposleni;
import operacije.ApstraktnaGenerickaOperacija;

/**
 *
 * @author User
 */
public class PretraziZaposleniOperacija extends ApstraktnaGenerickaOperacija {
    private List<Zaposleni> Zaposleni;
    @Override
    protected void preduslovi(Object param) throws Exception {
        
   
         if(param==null || !(param instanceof Zaposleni)){
                throw new Exception("Niste uneli odgovarajuce parametre");
            }
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
         Zaposleni zaposleni=(Zaposleni) param;
        if(zaposleni.getIdZaposlenog()!=0 || zaposleni.getIme()!=null || zaposleni.getPrezime()!=null || zaposleni.getEmail()!=null || zaposleni.getLozinka()!=null){
           kljuc+=" where"; 
        if(zaposleni.getIdZaposlenog()!=0)
            kljuc+=" idZaposlenog="+zaposleni.getIdZaposlenog();
        if(zaposleni.getIme()!=null)
            kljuc+=" ime=\""+zaposleni.getIme()+"\"";
        if(zaposleni.getPrezime()!=null)
            kljuc+=" prezime="+zaposleni.getPrezime()+"\"";
        if(zaposleni.getEmail()!=null)
            kljuc+=" email=\""+zaposleni.getEmail()+"\"";
        if(zaposleni.getLozinka()!=null)
            kljuc+=" lozinka=\""+zaposleni.getLozinka()+"\"";
          
        }
        Zaposleni = broker.getAll(zaposleni, kljuc);
}
        
             
             
    

    public List<Zaposleni> getZaposleni() {
        return Zaposleni;
    }
}
