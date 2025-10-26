/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije.Iznajmljivanje;

import java.util.List;
import modeli.Iznajmljivanje;
import modeli.StavkeIznajmljivanja;
import operacije.ApstraktnaGenerickaOperacija;

/**
 *
 * @author User
 */
public class KreirajIznajmljivanjeOperacija extends ApstraktnaGenerickaOperacija {
        @Override
    protected void preduslovi(Object param) throws Exception {
        
        
 
         
        
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        if( param instanceof Iznajmljivanje){
        
        Iznajmljivanje iznajmljivanje=(Iznajmljivanje) param;
        
             
             
             
                 broker.add(iznajmljivanje);
                 System.out.println("Uspesno uneto iznajmljivanje");
        }else{
            StavkeIznajmljivanja stavka=(StavkeIznajmljivanja) param;
        
             List<StavkeIznajmljivanja> stavke = broker.getAll(stavka, kljuc);
             
             if(stavke.isEmpty()){
                 broker.add(stavka);
                 System.out.println("Uspesno uneto stavka");
             }
             else{System.out.println("Vec postoji stavka sa tim nazivom");
        }
        }    
       
    }     
}
