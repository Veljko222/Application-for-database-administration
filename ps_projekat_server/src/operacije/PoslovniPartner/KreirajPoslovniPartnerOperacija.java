/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije.PoslovniPartner;

import java.util.List;
import modeli.Mesto;
import modeli.PoslovniPartner;
import operacije.ApstraktnaGenerickaOperacija;

/**
 *
 * @author User
 */
public class KreirajPoslovniPartnerOperacija extends ApstraktnaGenerickaOperacija {
    @Override
    protected void preduslovi(Object param) throws Exception {
        if(param==null || !(param instanceof PoslovniPartner)){
                throw new Exception("Niste uneli odgovarajuc partner");
            }else{
                PoslovniPartner partner=(PoslovniPartner) param;
                String ime= partner.getIme();

                String prezime= partner.getPrezime();
                 Mesto mesto = partner.getMesto();
                 if(mesto==null)
                   throw new Exception("Mesto nije izabrano"); 
                if(ime=="")
                    throw new Exception("Naziv nije unet");
                for(char c: ime.toCharArray()){
                    if(!(Character.isLetter(c)) && c != ' '){
                        throw new Exception("U imenu zaposlenog smeju biti samo slova i razmaci"); 
                    }
                }
                if(prezime=="")
                    throw new Exception("Naziv nije unet");
                
                    if (prezime == null || prezime.isEmpty()) {
        throw new Exception("Prezime ne može biti prazno!");
            }
            for (char c : prezime.toCharArray()) {
                if (!Character.isLetter(c) && c != ' ') { 
                    throw new Exception("U prezimenu smeju biti samo slova i razmaci");
                }
                }
            
        }           
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        PoslovniPartner partner=(PoslovniPartner) param;
        
             List<PoslovniPartner> sviTrotinei = broker.getAll(partner, kljuc);
             
             if(sviTrotinei.isEmpty()){
                 broker.add(partner);
                 System.out.println("Uspesno unet partner");
             }
             else{System.out.println("Vec postoji taj partner");
             
             }
    }
}
