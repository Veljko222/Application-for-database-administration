/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeli;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author User
 */
public class Iznajmljivanje implements ApstraktniDomenskiObjekat {
    private int idIznajmljivanja;
    private Zaposleni zaposleni;
    private PoslovniPartner partner;
    private int cena;
   

    public Iznajmljivanje() { 
    }

    
    
    public Iznajmljivanje(int idIznajmljivanja, Zaposleni zaposleni, PoslovniPartner partner, int cena) {
        this.idIznajmljivanja = idIznajmljivanja;
        
        this.zaposleni = zaposleni;
        this.partner = partner;
        this.cena = cena;
        
    }


    
    

    public int getIdIznajmljivanja() {
        return idIznajmljivanja;
    }

    public void setIdIznajmljivanja(int idIznajmljivanja) {
        this.idIznajmljivanja = idIznajmljivanja;
    }

    

    public Zaposleni getZaposleni() {
        return zaposleni;
    }

    public void setZaposleni(Zaposleni zaposleni) {
        this.zaposleni = zaposleni;
    }

    public PoslovniPartner getPartner() {
        return partner;
    }

    public void setPartner(PoslovniPartner partner) {
        this.partner = partner;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }
    

    @Override
    public String vratiNazivTabele() {
return "iznajmljivanje";
        }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>(); 
    while (rs.next()) {
        int idZaposlenog = rs.getInt("idZaposlenog");
        int idIznajmljivanja = rs.getInt("idIznajmljivanje");
        int idPartnera= rs.getInt("idPoslovniPartner");
        int cena= rs.getInt("cena");
        
        
        String ime = rs.getString("imeZaposlenog");
        String prezime = rs.getString("prezimeZaposlenog");
        String email = rs.getString("email");
        String lozinka = rs.getString("lozinka");
        
        int id = rs.getInt("idPoslovniPartner");
        String imep = rs.getString("ime");
        String prezimep = rs.getString("prezime");
            int idMesto = rs.getInt("idMesta");
            String naziv= rs.getString("naziv");
         Mesto mesto= new Mesto(idMesto, naziv);
        
        PoslovniPartner p = new PoslovniPartner(id, imep, prezimep, mesto);
        
        Zaposleni z = new Zaposleni(idZaposlenog, ime, prezime, email, lozinka);
                
         
        
        Iznajmljivanje i = new Iznajmljivanje(idIznajmljivanja, z, p, cena );
        lista.add(i);
    }    
    return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
return "idIznajmljivanje, idZaposlenog,idPoslovnogPartnera, cena";    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
 return idIznajmljivanja + ", " + 
           zaposleni.getIdZaposlenog()+ ", " + 
           partner.getIdPoslovniPartner()+ ", " + 
           cena;    }

    @Override
    public ApstraktniDomenskiObjekat vratiobjekatIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZalzmenu() {
return "idIznajmljivanje=" + idIznajmljivanja +  
       ", idZaposlenog=" + zaposleni.getIdZaposlenog()+ 
       ", idPoslovnogPartnera=" + partner.getIdPoslovniPartner()+ 
       ", cena=" + cena;
    }

    @Override
    public String vratiPrimarniKljuc() {
return "iznajmljivanje.idIznajmljivanje="+ idIznajmljivanja;    }
    
}
