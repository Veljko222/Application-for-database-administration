/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije.PoslovniPartner;

import java.util.List;
import modeli.PoslovniPartner;
import operacije.ApstraktnaGenerickaOperacija;

/**
 *
 * @author User
 */
public class VratiListuSvihPartneraOperacija extends ApstraktnaGenerickaOperacija {
    private List<PoslovniPartner> sviPartneri;
    @Override
    protected void preduslovi(Object param) throws Exception {
       
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        PoslovniPartner partner= new PoslovniPartner();
        
        kljuc= " join mesto on "+ partner.vratiNazivTabele()+".idMesta=mesto.idMesta";
        sviPartneri = broker.getAll(partner, kljuc);
         
    }

    public List<PoslovniPartner> getSviPartneri() {
        return sviPartneri;
    }
}
