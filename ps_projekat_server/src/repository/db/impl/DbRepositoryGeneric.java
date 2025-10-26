/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.db.impl;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modeli.ApstraktniDomenskiObjekat;
import repository.db.DbConnectionFactory;
import repository.db.DbRepository;

/**
 *
 * @author User
 */
public class DbRepositoryGeneric implements DbRepository<ApstraktniDomenskiObjekat>{

    @Override
    public List<ApstraktniDomenskiObjekat> getAll(ApstraktniDomenskiObjekat param, String uslov) {
        List<ApstraktniDomenskiObjekat> lista= new ArrayList<>();
        try {
           
            String upit="select * from "+ param.vratiNazivTabele();
            if(uslov!=null)
                upit+=uslov;
            System.out.println(upit);
            Statement st= DbConnectionFactory.getInstance().getConnection().createStatement();
            ResultSet rs= st.executeQuery(upit);
                lista=param.vratiListu(rs);
                rs.close();
                st.close();
        } catch (SQLException ex) {
            System.out.println("Neuspesno vracanje liste (pogresan sql upit) "+ ex.getMessage());
            return null;
        } catch (Exception ex) {
            System.out.println("Neuspesno vracanje liste");
            ex.printStackTrace();
        }
        return lista;
    }

    @Override
    public void add(ApstraktniDomenskiObjekat param) throws Exception {
String upit = "INSERT INTO "+ param.vratiNazivTabele()+" ("+param.vratiKoloneZaUbacivanje() +
" ) VALUES ( "+param.vratiVrednostiZaUbacivanje() +" )";
System.out.println(upit) ;
Statement st = DbConnectionFactory.getInstance().getConnection().createStatement() ;
st.executeUpdate(upit) ;
st.close();    
    }

    @Override
    public void edit(ApstraktniDomenskiObjekat param) throws Exception {
String upit = "UPDATE "+ param. vratiNazivTabele()+" SET "+ param.vratiVrednostiZalzmenu()+ " where " + param.vratiPrimarniKljuc() ;
System.out.println(upit) ;
Statement st = DbConnectionFactory.getInstance().getConnection().createStatement() ;
st.executeUpdate(upit) ;
st.close();    

    }

    @Override
    public void delete(ApstraktniDomenskiObjekat param) throws Exception {
String upit = "DELETE FROM "+param.vratiNazivTabele()+" WHERE "+
param.vratiPrimarniKljuc() ;  
System.out.println(upit) ;
Statement st = DbConnectionFactory.getInstance().getConnection().createStatement() ;
st.executeUpdate(upit) ;
st.close();  
    }

    @Override
    public List<ApstraktniDomenskiObjekat> getAll() {
        List<ApstraktniDomenskiObjekat> lista= new ArrayList<>();
        
        
        
        return lista;
    }
    
}
