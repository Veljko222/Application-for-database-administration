/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije.zaposleni;

import java.util.List;
import modeli.Zaposleni;
import operacije.ApstraktnaGenerickaOperacija;

/**
 *
 * @author User
 */
public class VratiListuSvihZaposlenihOperacija extends ApstraktnaGenerickaOperacija {
private List<Zaposleni> sviZaposleni;
    @Override
    protected void preduslovi(Object param) throws Exception {
       
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        Zaposleni zaposleni= new Zaposleni();
        sviZaposleni = broker.getAll(zaposleni, null);
         
    }

    public List<Zaposleni> getSviZaposleni() {
        return sviZaposleni;
    }
}
