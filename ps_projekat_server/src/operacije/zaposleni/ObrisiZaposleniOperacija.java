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
public class ObrisiZaposleniOperacija extends ApstraktnaGenerickaOperacija {
    @Override
    protected void preduslovi(Object param) throws Exception {
         if(param==null || !(param instanceof Zaposleni)){
                throw new Exception("Niste selektovali zaposlenog");
            }
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        Zaposleni zaposleni=(Zaposleni) param;
        broker.delete(zaposleni);
        System.out.println("Uspesno obrisan zaposleni");
    }
}
