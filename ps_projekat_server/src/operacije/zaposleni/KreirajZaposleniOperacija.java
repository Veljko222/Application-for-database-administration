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
public class KreirajZaposleniOperacija extends ApstraktnaGenerickaOperacija {

    @Override
    protected void preduslovi(Object param) throws Exception {
        if(param==null || !(param instanceof Zaposleni)){
                throw new Exception("Niste uneli odgovarajuc zaposleni");
            }else{
                Zaposleni zaposleni=(Zaposleni) param;
                String ime= zaposleni.getIme();

                String prezime= zaposleni.getPrezime();
                 String email = zaposleni.getEmail();
                
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
            
                        if (email == null || email.isEmpty()) {
                    throw new Exception("Email ne može biti prazan!");
                }
                if (!email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$")) { 
                    throw new Exception("Neispravan format email adrese!");
                }
            }
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        Zaposleni zaposleni=(Zaposleni) param;
        
             List<Zaposleni> sviTrotinei = broker.getAll(zaposleni, kljuc);
             
             if(sviTrotinei.isEmpty()){
                 broker.add(zaposleni);
                 System.out.println("Uspesno unet zaposleni");
             }
             else{System.out.println("Vec postoji taj zaposleni");
             
             }
    }
    
}
