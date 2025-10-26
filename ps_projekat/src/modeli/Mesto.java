/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeli;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class Mesto implements ApstraktniDomenskiObjekat {
    private int idMesta;
    private String naziv;

    public Mesto(int idMesta, String naziv) {
        this.idMesta = idMesta;
        this.naziv = naziv;
    }

    public Mesto() {
    }

    public int getIdMesta() {
        return idMesta;
    }

    public void setIdMesta(int idMesta) {
        this.idMesta = idMesta;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
    
    

    @Override
    public String vratiNazivTabele() {
return "mesto";    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>() ;
        while (rs.next()){
        int id= rs.getInt("idMesta");
        String naziv = rs.getString("naziv") ;

        Mesto m = new Mesto(id, naziv);

        lista.add(m) ;
        }    
        return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
                return "naziv";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
return "'"+naziv+"'";    }

    @Override
    public ApstraktniDomenskiObjekat vratiobjekatIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZalzmenu() {
return "naziv='" + naziv + "'";
   }

    @Override
    public String vratiPrimarniKljuc() {
return "mesto.idMesta="+idMesta;     }

    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
