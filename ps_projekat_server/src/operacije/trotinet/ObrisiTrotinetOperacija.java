/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije.trotinet;

import modeli.Trotinet;
import operacije.ApstraktnaGenerickaOperacija;

/**
 *
 * @author User
 */
public class ObrisiTrotinetOperacija extends ApstraktnaGenerickaOperacija {

    @Override
    protected void preduslovi(Object param) throws Exception {
         if(param==null || !(param instanceof Trotinet)){
                throw new Exception("Niste selektovali mesto");
            }
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        Trotinet trotinet=(Trotinet) param;
        broker.delete(trotinet);
        System.out.println("Uspesno obrisano mesto");
    }
    
}
