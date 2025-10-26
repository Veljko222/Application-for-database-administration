/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeli;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author User
 */
public class Zaposleni_Termin implements ApstraktniDomenskiObjekat {
    
    private Zaposleni zaposleni;
    private TerminDezurstva termin;
    private LocalDate datum;

    public Zaposleni_Termin(Zaposleni zaposleni, TerminDezurstva termin, LocalDate datum) {
        this.zaposleni = zaposleni;
        this.termin = termin;
        this.datum = datum;
    }

    public Zaposleni getZaposleni() {
        return zaposleni;
    }

    public void setZaposleni(Zaposleni zaposleni) {
        this.zaposleni = zaposleni;
    }

    public TerminDezurstva getTermin() {
        return termin;
    }

    public void setTermin(TerminDezurstva termin) {
        this.termin = termin;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }
    

    @Override
    public String vratiNazivTabele() {
return "zaposleni-termin";    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
                return "idZaposleni, idTerminDezurstva, datumTermina";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
return zaposleni.getIdZaposlenog() + ", " + 
           termin.getIdDezurstva()+ ", " + 
           "'" + datum + "'";    }

    @Override
    public ApstraktniDomenskiObjekat vratiobjekatIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZalzmenu() {
return "idZaposlenog=" + zaposleni.getIdZaposlenog()+ ", idTerminDezurstva=" + termin.getIdDezurstva()+ ", datum='" + datum + "'";
    }

    @Override
    public String vratiPrimarniKljuc() {
return "zaposleni-termin.datumTermina="+datum+ " and zaposleni-termin.idTerminDezurstva="+termin.getIdDezurstva()+ " and zaposleni-termin.idZaposlenog="+zaposleni.getIdZaposlenog();     }
    
}
