/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije.Iznajmljivanje;

import modeli.Iznajmljivanje;
import modeli.StavkeIznajmljivanja;
import operacije.ApstraktnaGenerickaOperacija;

/**
 *
 * @author User
 */
public class PromeniIznajmljivanjeOperacija extends ApstraktnaGenerickaOperacija {

    @Override
    protected void preduslovi(Object param) throws Exception {
        
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
       if( param instanceof Iznajmljivanje){

        Iznajmljivanje partner=(Iznajmljivanje) param;
        broker.edit(partner);
        System.out.println("Uspesno izmenjeno iznajmljivanje");
       }else{
           if(kljuc.equals("obrisi")){
        StavkeIznajmljivanja stavka=(StavkeIznajmljivanja) param;
        broker.delete(param);
        System.out.println("Uspesno obrisano stavku");
           }else{
               StavkeIznajmljivanja stavka=(StavkeIznajmljivanja) param;
                       broker.edit(stavka);
                       System.out.println("Uspesno izmenjena stavka iznajmljivanja");
           }
       }
    }
    
}
