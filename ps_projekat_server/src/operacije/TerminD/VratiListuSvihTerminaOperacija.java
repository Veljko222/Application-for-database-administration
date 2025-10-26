/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije.TerminD;

import java.util.List;
import modeli.TerminDezurstva;
import operacije.ApstraktnaGenerickaOperacija;

/**
 *
 * @author User
 */
public class VratiListuSvihTerminaOperacija extends ApstraktnaGenerickaOperacija {
    private List<TerminDezurstva> termini;
    @Override
    protected void preduslovi(Object param) throws Exception {
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        TerminDezurstva termin= new TerminDezurstva();
        termini = broker.getAll(termin, null);
         
    }

    public List<TerminDezurstva> getTermini() {
        return termini;
    }
}
