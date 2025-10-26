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
public class PretraziTerminOperacija extends ApstraktnaGenerickaOperacija {
    private List<TerminDezurstva> svaMesta;
    @Override
    protected void preduslovi(Object param) throws Exception {
         if(param==null || !(param instanceof TerminDezurstva)){
                throw new Exception("Niste uneli odgovarajuce parametre");
            }
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        TerminDezurstva termin=(TerminDezurstva) param;
        if(termin.getIdDezurstva()!=0 || termin.getPocetak()!=null || termin.getKraj()!=null || termin.getTrajanje()!=0){
           kljuc+=" where"; 
        if(termin.getIdDezurstva()!=0)
            kljuc+=" idTerminDezurstva="+termin.getIdDezurstva();
        if(termin.getPocetak()!=null)
               kljuc+=" pocetak='"+termin.getPocetak()+"'";
        if(termin.getKraj()!=null)
               kljuc+=" kraj='"+termin.getKraj()+"'";
        if(termin.getTrajanje()!=0)
            kljuc+=" trajanje="+termin.getTrajanje();
        }
        
             svaMesta = broker.getAll(termin, kljuc);
             
    }

    public List<TerminDezurstva> getTermini() {
        return svaMesta;
    }
}
