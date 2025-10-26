/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije.zaposleni;

import modeli.Zaposleni;
import operacije.ApstraktnaGenerickaOperacija;

/**
 *
 * @author User
 */
public class PromeniZaposleniOperacija extends ApstraktnaGenerickaOperacija {
    @Override
    protected void preduslovi(Object param) throws Exception {
        if(param==null || !(param instanceof Zaposleni)){
                throw new Exception("Niste selektovali mesto");    }
        else{
                Zaposleni zaposleni=(Zaposleni) param;
                String ime= zaposleni.getIme();
                String prezime= zaposleni.getPrezime();
                                 String email = zaposleni.getEmail();

                
               
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
        broker.edit(zaposleni);
        System.out.println("Uspesno izmenjen zaposleni");
    }
}
