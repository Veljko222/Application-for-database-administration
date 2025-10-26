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
public class Trotinet implements ApstraktniDomenskiObjekat {
    private int idTrotineta;
    private String naziv;
    private int cenaPoSatu;
    
    public Trotinet(){
        
    }

    public Trotinet(int idTrotinet, String naziv, int cenaPoSatu) {
        this.idTrotineta = idTrotinet;
        this.naziv = naziv;
        this.cenaPoSatu = cenaPoSatu;
    }

    public int getIdTrotineta() {
        return idTrotineta;
    }

    public void setIdTrotineta(int idTrotineta) {
        this.idTrotineta = idTrotineta;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getCenaPoSatu() {
        return cenaPoSatu;
    }

    public void setCenaPoSatu(int cenaPoSatu) {
        this.cenaPoSatu = cenaPoSatu;
    }
    
    

    @Override
    public String vratiNazivTabele() {
return "trotinet";    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
         List<ApstraktniDomenskiObjekat> lista = new ArrayList<>() ;
        while (rs.next()) {
            int id = rs.getInt("idTrotineta");
            String naziv = rs.getString("naziv");
            int cenaPoSatu = rs.getInt("cenaPoSatu");

            Trotinet t = new Trotinet(id, naziv, cenaPoSatu);
            lista.add(t);
        }    
        return lista;    
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
                return "idTrotineta, naziv, cenaPoSatu";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
return idTrotineta+", '"+ naziv+"', "+ cenaPoSatu; }

    @Override
    public ApstraktniDomenskiObjekat vratiobjekatIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZalzmenu() {
return "idTrotineta=" + idTrotineta + 
       ", naziv='" + naziv + "'" + 
       ", cenaPoSatu=" + cenaPoSatu;    }

    @Override
    public String vratiPrimarniKljuc() {
return "trotinet.idTrotineta="+idTrotineta;     }
    
}
