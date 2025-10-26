/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije.PoslovniPartner;

import modeli.Mesto;
import modeli.PoslovniPartner;
import operacije.ApstraktnaGenerickaOperacija;

/**
 *
 * @author User
 */
public class PromeniPoslovniPartnerOperacija extends ApstraktnaGenerickaOperacija {
    @Override
    protected void preduslovi(Object param) throws Exception {
        if(param==null || !(param instanceof PoslovniPartner)){
                throw new Exception("Niste selektovali mesto");    }
        else{
                PoslovniPartner partner=(PoslovniPartner) param;
                String ime= partner.getIme();
                String prezime= partner.getPrezime();
                                 Mesto mesto = partner.getMesto();

                if(mesto==null)
                   throw new Exception("Mesto nije izabrano"); 
               
               
                if(ime!= null)
                for(char c: ime.toCharArray()){
                    if(!(Character.isLetter(c)) || !(c!=' ') || ime.isEmpty()){
                        throw new Exception("U nazivu mesta smeju biti samo slova i razmaci"); 
                    }
                }
                if (prezime == null || prezime.isEmpty()) {
        throw new Exception("Prezime ne može biti prazno!");
            }
            for (char c : prezime.toCharArray()) {
                if (!Character.isLetter(c) && c != ' ') { // Only allow letters and spaces
                    throw new Exception("U prezimenu smeju biti samo slova i razmaci");
                }
                }
            
         }
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        PoslovniPartner partner=(PoslovniPartner) param;
        broker.edit(partner);
        System.out.println("Uspesno izmenjen partner");
    }
}
