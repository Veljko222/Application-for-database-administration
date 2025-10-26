/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije.trotinet;

import java.util.List;
import modeli.Trotinet;
import operacije.ApstraktnaGenerickaOperacija;

/**
 *
 * @author User
 */
public class VratiListuSvihTrotinetaOperacija extends ApstraktnaGenerickaOperacija {
    private List<Trotinet> sviTrotineti;
    @Override
    protected void preduslovi(Object param) throws Exception {

    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
         Trotinet mesto= new Trotinet();
        sviTrotineti = broker.getAll(mesto, null);
         
    }

    public List<Trotinet> getSveTrotinete() {
        return sviTrotineti;
    }
}
