/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije.mesto;

import java.util.List;
import modeli.Mesto;
import modeli.Zaposleni;
import operacije.ApstraktnaGenerickaOperacija;

/**
 *
 * @author User
 */
public class KreirajMestoOperacija extends ApstraktnaGenerickaOperacija {

    @Override
    protected void preduslovi(Object param) throws Exception {
        
        
            if(param==null || !(param instanceof Mesto)){
                throw new Exception("Niste uneli odgovarajuce mesto");
            }else{
                Mesto mesto=(Mesto) param;
                String naziv= mesto.getNaziv();
                if(naziv=="")
                    throw new Exception("Naziv nije unet");
                for(char c: naziv.toCharArray()){
                    if(!(Character.isLetter(c)) && c!=' '){
                        throw new Exception("U nazivu mesta smeju biti samo slova i razmaci"); 
                    }
                }
            }
        
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        Mesto mesto=(Mesto) param;
        
             List<Mesto> svaMesta = broker.getAll(mesto, kljuc);
             
             if(svaMesta.isEmpty()){
                 broker.add(mesto);
                 System.out.println("Uspesno uneto mesto");
             }
             else{System.out.println("Vec postoji mesto sa tim nazivom");
             
             }
            
       
        }
}
    

