/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije.mesto;

import java.util.List;
import modeli.Mesto;
import operacije.ApstraktnaGenerickaOperacija;

/**
 *
 * @author User
 */
public class VratiListuSvihMestaOperacija extends ApstraktnaGenerickaOperacija{
 private List<Mesto> svaMesta;
    @Override
    protected void preduslovi(Object param) throws Exception {
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        Mesto mesto= new Mesto();
        svaMesta = broker.getAll(mesto, null);
         
    }

    public List<Mesto> getSvaMesta() {
        return svaMesta;
    }

  
    
    
}
