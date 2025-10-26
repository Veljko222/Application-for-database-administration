/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije.TerminD;

import java.time.LocalTime;
import modeli.TerminDezurstva;
import operacije.ApstraktnaGenerickaOperacija;

/**
 *
 * @author User
 */
public class PromeniTerminOperacija extends ApstraktnaGenerickaOperacija {
    @Override
    
        protected void preduslovi(Object param) throws Exception {
         if(param==null || !(param instanceof TerminDezurstva)){
                throw new Exception("Niste selektovali termin");    }else{
                TerminDezurstva termin=(TerminDezurstva) param;
                LocalTime pocetak= termin.getPocetak();
                LocalTime kraj= termin.getKraj();
                if(pocetak.isAfter(kraj))
                    throw new Exception("Pocetak mora biti pre kraja");
                
                
                
         }
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        TerminDezurstva termin=(TerminDezurstva) param;
        broker.edit(termin);
        System.out.println("Uspesno izmenjen termin");
    }
}
