/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeli;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author User
 */
public class Zaposleni implements ApstraktniDomenskiObjekat {
    private int idZaposlenog;
    private String ime;
    private String prezime;
    private String email;
    private String lozinka;

    public Zaposleni(int idZaposlenog, String ime, String prezime, String email, String lozinka) {
        this.idZaposlenog = idZaposlenog;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.lozinka=lozinka;
    }

    public Zaposleni() {
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public int getIdZaposlenog() {
        return idZaposlenog;
    }

    public void setIdZaposlenog(int idZaposlenog) {
        this.idZaposlenog = idZaposlenog;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
    @Override
    public String vratiNazivTabele() {
return "zaposleni";    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
    List<ApstraktniDomenskiObjekat> lista = new ArrayList<>(); 
    while (rs.next()) {
        int id = rs.getInt("idZaposlenog");
        String ime = rs.getString("imeZaposlenog");
        String prezime = rs.getString("prezimeZaposlenog");
        String email = rs.getString("email");
        String lozinka = rs.getString("lozinka");
        Zaposleni z = new Zaposleni(id, ime, prezime, email, lozinka);
        lista.add(z);
    }    
    return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
return "idZaposlenog, ime, prezime, email, lozinka";    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
return idZaposlenog + ", " + 
           "'" + ime + "', " + 
           "'" + prezime + "', " + 
           "'" + email + "', " +
           "'" + lozinka + "'";   }

    @Override
    public ApstraktniDomenskiObjekat vratiobjekatIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZalzmenu() {
return "idZaposlenog=" + idZaposlenog + ", ime='" + ime + "', prezime='" + prezime + "', email='" + email + "', lozinka='" + lozinka +"'";
    }

    @Override
    public String vratiPrimarniKljuc() {
return "zaposleni.idZaposlenog="+idZaposlenog;     }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Zaposleni other = (Zaposleni) obj;
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return Objects.equals(this.lozinka, other.lozinka);
    }
    
    
    
}
