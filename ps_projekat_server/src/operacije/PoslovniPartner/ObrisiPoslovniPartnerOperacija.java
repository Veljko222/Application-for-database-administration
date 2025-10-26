/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije.PoslovniPartner;

import modeli.PoslovniPartner;
import operacije.ApstraktnaGenerickaOperacija;

/**
 *
 * @author User
 */
public class ObrisiPoslovniPartnerOperacija extends ApstraktnaGenerickaOperacija {
    @Override
    protected void preduslovi(Object param) throws Exception {
         if(param==null || !(param instanceof PoslovniPartner)){
                throw new Exception("Niste selektovali zaposlenog");
            }
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        PoslovniPartner partner=(PoslovniPartner) param;
        broker.delete(partner);
        System.out.println("Uspesno obrisan partner");
    }
}
