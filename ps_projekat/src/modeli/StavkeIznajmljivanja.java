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
public class StavkeIznajmljivanja implements ApstraktniDomenskiObjekat {
    private int idIznajmljivanja;
    private int idStavke;
    private Trotinet trotinet;
    private int brojSati;
    private int cenaPoSatu;
    public StavkeIznajmljivanja() {
    }

    
    
    public StavkeIznajmljivanja(int idStavke, int iznajmljivanja, Trotinet trotinet, int brojSati, int cenaPoSatu) {
        this.idIznajmljivanja = iznajmljivanja;
        this.idStavke = idStavke;
        this.trotinet = trotinet;
        this.brojSati=brojSati;
        this.cenaPoSatu=cenaPoSatu;
    }

    public int getCenaPoSatu() {
        return cenaPoSatu;
    }

    public void setCenaPoSatu(int cenaPoSatu) {
        this.cenaPoSatu = cenaPoSatu;
    }

    
    public int getIdIznajmljivanja() {
        return idIznajmljivanja;
    }

    public void setIdIznajmljivanja(int iznajmljivanja) {
        this.idIznajmljivanja = iznajmljivanja;
    }

    public int getIdStavke() {
        return idStavke;
    }

    public void setIdStavke(int idStavke) {
        this.idStavke = idStavke;
    }

    public Trotinet getTrotinet() {
        return trotinet;
    }

    public void setTrotinet(Trotinet trotinet) {
        this.trotinet = trotinet;
    }

    public int getBrojSati() {
        return brojSati;
    }

    public void setBrojSati(int brojSati) {
        this.brojSati = brojSati;
    }
    
    
    

    @Override
    public String vratiNazivTabele() {
return "stavkaiznajmljivanja";    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>(); 
    while (rs.next()) {
        int idTrotineta = rs.getInt("idTrotineta");
        int idIznajmljivanja = rs.getInt("idIznajmljivanje");
        int idStavke= rs.getInt("idStavke");
        int brojSati=rs.getInt("brojSati");
        int cenaPoSatu=rs.getInt("cenaPoSatu");
        String naziv= rs.getString("naziv");
        int cena=rs.getInt("cenaPoSatu");
                
         Trotinet trotinet= new Trotinet(idTrotineta, naziv, cena);
        
        StavkeIznajmljivanja z = new StavkeIznajmljivanja(idIznajmljivanja, idStavke, trotinet, brojSati, cenaPoSatu);
        lista.add(z);
    }    
    return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
return "idStavke, idTrotineta, idIznajmljivanje, brojSati, cenaPoSatu";    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
return idStavke+ ", " + 
         trotinet.getIdTrotineta()  + ", " + idIznajmljivanja + ", "+ brojSati + ", "+ cenaPoSatu;    }

    @Override
    public ApstraktniDomenskiObjekat vratiobjekatIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZalzmenu() {
return "idIznajmljivanje=" + idIznajmljivanja + 
       ", idStavke=" + idStavke + 
       ", idTrotineta=" + trotinet.getIdTrotineta() +
        ", brojSati="+ brojSati+
        ", cenaPoSatu="+ cenaPoSatu;
    }

    @Override
    public String vratiPrimarniKljuc() {
return "stavkaiznajmljivanja.idStavke="+idStavke;     }
    
}
