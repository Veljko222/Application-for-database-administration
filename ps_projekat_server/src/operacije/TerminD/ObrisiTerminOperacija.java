/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije.TerminD;

import modeli.TerminDezurstva;
import operacije.ApstraktnaGenerickaOperacija;

/**
 *
 * @author User
 */
public class ObrisiTerminOperacija extends ApstraktnaGenerickaOperacija {
    @Override
    protected void preduslovi(Object param) throws Exception {
        if(param==null || !(param instanceof TerminDezurstva)){
                throw new Exception("Niste selektovali termin");
            }
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        TerminDezurstva termin=(TerminDezurstva) param;
        broker.delete(param);
        System.out.println("Uspesno obrisano termin");
    }
}
