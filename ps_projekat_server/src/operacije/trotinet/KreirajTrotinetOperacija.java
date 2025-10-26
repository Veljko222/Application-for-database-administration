/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije.trotinet;

import java.util.List;
import modeli.Mesto;
import modeli.Trotinet;
import operacije.ApstraktnaGenerickaOperacija;

/**
 *
 * @author User
 */
public class KreirajTrotinetOperacija extends ApstraktnaGenerickaOperacija {

    @Override
    protected void preduslovi(Object param) throws Exception {
        if(param==null || !(param instanceof Trotinet)){
                throw new Exception("Niste uneli odgovarajuc trotinet");
            }else{
                Trotinet trotinet=(Trotinet) param;
                String naziv= trotinet.getNaziv();

                int cena= trotinet.getCenaPoSatu();
                if(cena<0){
                    throw new Exception("Cena po satu mora biti veca od 0"); 
                    }
                if(naziv=="")
                    throw new Exception("Naziv nije unet"); 
                for(char c: naziv.toCharArray()){
                    if(!(Character.isLetter(c)) && c!=' '){
                        throw new Exception("U nazivu trotineta smeju biti samo slova i razmaci"); 
                    }
                }
            }
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        Trotinet trotinet=(Trotinet) param;
        
             List<Trotinet> sviTrotinei = broker.getAll(trotinet, kljuc);
             
             if(sviTrotinei.isEmpty()){
                 broker.add(trotinet);
                 System.out.println("Uspesno unet trotinet");
             }
             else{System.out.println("Vec postoji trotinet sa tim nazivom");
             
             }
    }
    
}
