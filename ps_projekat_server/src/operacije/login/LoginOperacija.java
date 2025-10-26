/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije.login;

import java.util.List;
import modeli.Zaposleni;
import operacije.ApstraktnaGenerickaOperacija;

/**
 *
 * @author User
 */
public class LoginOperacija extends ApstraktnaGenerickaOperacija {
    private Zaposleni zaposleni=null;
    @Override
    protected void preduslovi(Object param) throws Exception {
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        List<Zaposleni> sviZaposleni = broker.getAll((Zaposleni) param, null);
        System.out.println("KLASA LoginOperacija "+sviZaposleni);
        for(Zaposleni z: sviZaposleni){
            if(z.equals((Zaposleni)param)){
                zaposleni=z;
            }
        }
    }

    public Zaposleni getZaposleni() {
        return zaposleni;
    }
    
    
}
