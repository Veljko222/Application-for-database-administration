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
public class PromeniMestoOperacija extends ApstraktnaGenerickaOperacija {

    @Override
    
        protected void preduslovi(Object param) throws Exception {
         if(param==null || !(param instanceof Mesto)){
                throw new Exception("Niste selektovali mesto");    }else{
                Mesto mesto=(Mesto) param;
                String naziv= mesto.getNaziv();
                
                for(char c: naziv.toCharArray()){
                    if(!(Character.isLetter(c)) && c!=' ' || naziv.isEmpty()){
                        throw new Exception("U nazivu mesta smeju biti samo slova i razmaci"); 
                    }
                }
         }
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        Mesto mesto=(Mesto) param;
        broker.edit(mesto);
        System.out.println("Uspesno izmenjeno mesto");
    }
    
}
