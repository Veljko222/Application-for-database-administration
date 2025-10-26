/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeli;

import java.sql.ResultSet;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class TerminDezurstva implements ApstraktniDomenskiObjekat {
    private int idDezurstva;
    private LocalTime pocetak;
     private LocalTime kraj;
     private int trajanje;

    public TerminDezurstva(){
    }
     
     

    public TerminDezurstva(int idDezurstva, LocalTime pocetak, LocalTime kraj, int trajanje) {
        this.idDezurstva = idDezurstva;
        this.pocetak = pocetak;
        this.kraj = kraj;
        this.trajanje= (int) this.pocetak.until(this.kraj, ChronoUnit.MINUTES);
    }

    public int getTrajanje() {
        return trajanje;
    }

    public int getIdDezurstva() {
        return idDezurstva;
    }

    public void setIdDezurstva(int idDezurstva) {
        this.idDezurstva = idDezurstva;
    }

    public LocalTime getPocetak() {
        return pocetak;
    }

    public void setPocetak(LocalTime pocetak) {
        this.pocetak = pocetak;
    }

    public LocalTime getKraj() {
        return kraj;
    }

    public void setKraj(LocalTime kraj) {
        this.kraj = kraj;
    }
    
    public void setTrajanje(){
        this.trajanje=(int) this.pocetak.until(this.kraj, ChronoUnit.MINUTES);
    }
    
    public void setTrajanjeRucno(int trajanje){
        this.trajanje= trajanje;
    }

    @Override
    public String vratiNazivTabele() {
return "termindezurstva";    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
List<ApstraktniDomenskiObjekat> lista = new ArrayList<>(); 
while (rs.next()) {
    int id = rs.getInt("idTerminDezurstva");
    LocalTime pocetak = rs.getTime("pocetak").toLocalTime();
    LocalTime kraj = rs.getTime("kraj").toLocalTime();
    int trajanje = rs.getInt("trajanje");

    TerminDezurstva d = new TerminDezurstva(id, pocetak, kraj, trajanje);
    lista.add(d);
}    
return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
                return "idTerminDezurstva, pocetak, kraj, trajanje";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
return idDezurstva + ", " + 
           "'" + pocetak + "', " + 
           "'" + kraj + "', " + 
           trajanje;    }

    @Override
    public ApstraktniDomenskiObjekat vratiobjekatIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZalzmenu() {
return "idTerminDezurstva=" + idDezurstva + 
       ", pocetak='" + pocetak + "'" + 
       ", kraj='" + kraj + "'" + 
       ", trajanje=" + trajanje;
    }

    @Override
    public String vratiPrimarniKljuc() {
return "termindezurstva.idTerminDezurstva="+idDezurstva;     }
    
}
