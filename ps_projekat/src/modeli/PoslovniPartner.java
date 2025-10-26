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
public class PoslovniPartner implements ApstraktniDomenskiObjekat {
    
    private int idPoslovniPartner;
    private String ime;
    private Mesto mesto;
    private String prezime;

    public PoslovniPartner() {
    }
    
    

    public PoslovniPartner(int idPoslovniPartner, String ime, String prezime, Mesto mesto ) {
        this.idPoslovniPartner = idPoslovniPartner;
        this.ime = ime;
        this.mesto = mesto;
        this.prezime = prezime;
    }

    public int getIdPoslovniPartner() {
        return idPoslovniPartner;
    }

    public void setIdPoslovniPartner(int idPoslovniPartner) {
        this.idPoslovniPartner = idPoslovniPartner;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public Mesto getMesto() {
        return mesto;
    }

    public void setMesto(Mesto mesto) {
        this.mesto = mesto;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }
    

    @Override
    public String vratiNazivTabele() {
return "poslovnipartner";    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>(); 
    while (rs.next()) {
        int id = rs.getInt("idPoslovniPartner");
        String ime = rs.getString("ime");
        String prezime = rs.getString("prezime");
            int idMesto = rs.getInt("idMesta");
            String naziv= rs.getString("naziv");
         Mesto mesto= new Mesto(idMesto, naziv);
        
        PoslovniPartner z = new PoslovniPartner(id, ime, prezime, mesto);
        lista.add(z);
    }    
    return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
return "idPoslovniPartner, ime, prezime, idMesta";    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
return idPoslovniPartner + ", " + 
           "'" + ime + "', '" + 
           prezime+ "', " +mesto.getIdMesta()  ;    }

    @Override
    public ApstraktniDomenskiObjekat vratiobjekatIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZalzmenu() {
return "idPoslovniPartner=" + idPoslovniPartner + 
       ", ime=\"" + ime + "\"" + 
       ", idMesta=" + mesto.getIdMesta()+ 
       ", prezime=\"" + prezime + "\"";
    }

    @Override
    public String vratiPrimarniKljuc() {
return "poslovnipartner.idPoslovniPartner="+idPoslovniPartner;     }

    @Override
    public String toString() {
        return "PoslovniPartner{" + "idPoslovniPartner=" + idPoslovniPartner + ", ime=" + ime + ", mesto=" + mesto + ", prezime=" + prezime + '}';
    }
    
    
    
}
