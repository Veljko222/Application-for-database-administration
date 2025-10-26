/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije.mesto;

import modeli.Mesto;
import operacije.ApstraktnaGenerickaOperacija;

/**
 *
 * @author User
 */
public class ObrisiMestoOperacija extends ApstraktnaGenerickaOperacija {

    @Override
    protected void preduslovi(Object param) throws Exception {
        if(param==null || !(param instanceof Mesto)){
                throw new Exception("Niste selektovali mesto");
            }
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        Mesto mesto=(Mesto) param;
        broker.delete(param);
        System.out.println("Uspesno obrisano mesto");
    }
    
}
