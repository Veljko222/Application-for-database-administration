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
public class PromeniTrotinetOperacija extends ApstraktnaGenerickaOperacija {

    @Override
    protected void preduslovi(Object param) throws Exception {
        if(param==null || !(param instanceof Trotinet)){
                throw new Exception("Niste selektovali mesto");    }
        else{
                Trotinet trotinet=(Trotinet) param;
                String naziv= trotinet.getNaziv();
                int cena= trotinet.getCenaPoSatu();
                
                if(cena<0){
                    throw new Exception("Cena po satu mora biti veca od 0"); 
                    }
                if(naziv!= null)
                for(char c: naziv.toCharArray()){
                    if(!(Character.isLetter(c)) && c!=' ' || naziv.isEmpty()){
                        throw new Exception("U nazivu mesta smeju biti samo slova i razmaci"); 
                    }
                }
         }
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        Trotinet trotinet=(Trotinet) param;
        broker.edit(trotinet);
        System.out.println("Uspesno izmenjen trotinet");
    }
    
}
