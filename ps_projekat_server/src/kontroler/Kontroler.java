/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroler;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modeli.Iznajmljivanje;
import modeli.Mesto;
import modeli.PoslovniPartner;
import modeli.StavkeIznajmljivanja;
import modeli.TerminDezurstva;
import modeli.Trotinet;
import modeli.Zaposleni;
import operacije.Iznajmljivanje.KreirajIznajmljivanjeOperacija;
import operacije.Iznajmljivanje.PretraziIznajmljivanjeOperacija;
import operacije.Iznajmljivanje.PromeniIznajmljivanjeOperacija;
import operacije.Iznajmljivanje.VratiListuIznajmljivanjaOperacija;
import operacije.PoslovniPartner.KreirajPoslovniPartnerOperacija;
import operacije.PoslovniPartner.ObrisiPoslovniPartnerOperacija;
import operacije.PoslovniPartner.PretraziPoslovniPartnerOperacija;
import operacije.PoslovniPartner.PromeniPoslovniPartnerOperacija;
import operacije.PoslovniPartner.VratiListuSvihPartneraOperacija;

import operacije.TerminD.KreirajTerminOperacija;
import operacije.TerminD.ObrisiTerminOperacija;
import operacije.TerminD.PretraziTerminOperacija;
import operacije.TerminD.PromeniTerminOperacija;
import operacije.TerminD.VratiListuSvihTerminaOperacija;
import operacije.mesto.KreirajMestoOperacija;
import operacije.login.LoginOperacija;
import operacije.mesto.ObrisiMestoOperacija;
import operacije.mesto.PretraziMestoOperacija;
import operacije.mesto.PromeniMestoOperacija;
import operacije.mesto.VratiListuSvihMestaOperacija;
import operacije.trotinet.KreirajTrotinetOperacija;
import operacije.trotinet.ObrisiTrotinetOperacija;
import operacije.trotinet.PretraziTrotinetOperacija;
import operacije.trotinet.PromeniTrotinetOperacija;
import operacije.trotinet.VratiListuSvihTrotinetaOperacija;
import operacije.zaposleni.KreirajZaposleniOperacija;
import operacije.zaposleni.ObrisiZaposleniOperacija;
import operacije.zaposleni.PretraziZaposleniOperacija;
import operacije.zaposleni.PromeniZaposleniOperacija;
import operacije.zaposleni.VratiListuSvihZaposlenihOperacija;

/**
 *
 * @author User
 */
public class Kontroler {
       private static Kontroler instance;

    public Kontroler() {
    }
 
    

    public static Kontroler getInstance() {
        if(instance==null)
            instance=new Kontroler();
        return instance;
    }

    public Zaposleni login(Zaposleni z) throws Exception {
        LoginOperacija lo= new LoginOperacija();
        lo.izvrsi(z, null);
        System.out.println("Klasa kontroler: "+ lo.getZaposleni() );
        return lo.getZaposleni();
    }
    
    public List<Mesto> vratiListuSvihMesta(){
            VratiListuSvihMestaOperacija vmo= new VratiListuSvihMestaOperacija();
            Mesto mesto= new Mesto();
               try {
                   vmo.izvrsi(mesto, null);
                   return vmo.getSvaMesta();
               } catch (Exception ex) {
                   Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
               }
               return null;
        }
    
    public void kreirajMesto(Mesto mesto) throws Exception {
        KreirajMestoOperacija kmo= new KreirajMestoOperacija();
           try {
               kmo.izvrsi(mesto, " where naziv like \"" + mesto.getNaziv()+ "\"");
           } catch (Exception ex) {
               System.out.println("Neuspesno upisivanje mesta u bazu " +ex.getMessage());
               Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
               throw ex;
           }
    }

    

    public void obrisiMesto(Mesto mesto) throws Exception {
        ObrisiMestoOperacija kmo= new ObrisiMestoOperacija();
           try {
               kmo.izvrsi(mesto, null);
           } catch (Exception ex) {
               System.out.println("Neuspesno brisanje mesta iz baze " +ex.getMessage());
               Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
               throw ex;
           }
    }

    public void promeniMesto(Mesto mesto) throws Exception {
        PromeniMestoOperacija pmo= new PromeniMestoOperacija();
           try {
               pmo.izvrsi(mesto, null);
           } catch (Exception ex) {
               System.out.println("Neuspesno menjanje mesta u bazi " +ex.getMessage());
               Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
               throw ex;
           }
    }

    public List<Mesto> pretraziMesto(Mesto mesto) {
        PretraziMestoOperacija pmo= new PretraziMestoOperacija();
           try {
               pmo.izvrsi(mesto, "");
               return pmo.getSvaMesta();
           } catch (Exception ex) {
               System.out.println("Neuspesno nalazenje mesta u bazi " +ex.getMessage());
               Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
               
           }
           return null;
    }

    public List<Trotinet> vratiListuSvihTrotineta() {
        VratiListuSvihTrotinetaOperacija vlt= new VratiListuSvihTrotinetaOperacija();
            Trotinet trotinet= new Trotinet();
               try {
                   vlt.izvrsi(trotinet, null);
                   return vlt.getSveTrotinete();
               } catch (Exception ex) {
                   Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
                   
               }
               return null;
    }

    public void kreirajTrotinet(Trotinet trotinet) throws Exception {
        KreirajTrotinetOperacija kmo= new KreirajTrotinetOperacija();
           try {
               kmo.izvrsi(trotinet, " where naziv like \"" + trotinet.getNaziv()+ "\" and cenaPoSatu="+trotinet.getCenaPoSatu());
           } catch (Exception ex) {
               System.out.println("Neuspesno upisivanje trotineta u bazu " +ex.getMessage());
               Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
               throw ex;
           }
    }

    public void obrisiTrotinet(Trotinet trotinet) throws Exception {
        ObrisiTrotinetOperacija kmo= new ObrisiTrotinetOperacija();
           try {
               kmo.izvrsi(trotinet, null);
           } catch (Exception ex) {
               System.out.println("Neuspesno brisanje trotineta iz baze " +ex.getMessage());
               Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
               throw ex;
           }
    }

    public void promeniTrotinet(Trotinet trotinet) throws Exception {
        PromeniTrotinetOperacija kmo= new PromeniTrotinetOperacija();
           try {
               kmo.izvrsi(trotinet, null);
           } catch (Exception ex) {
               System.out.println("Neuspesna promena trotineta u bazi " +ex.getMessage());
               Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
               throw ex;
           }
    }

    public List<Trotinet> pretraziTrotinet(Trotinet trotinet) {
        PretraziTrotinetOperacija kmo= new PretraziTrotinetOperacija();
           try {
               kmo.izvrsi(trotinet, "");
               return kmo.getTrotineti();
           } catch (Exception ex) {
               System.out.println("Neuspesna pretraga trotineta u bazi " +ex.getMessage());
               Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
           }
           
           return null;
    }

    public List<Zaposleni> vratiListuSvihZaposlenih() {
        VratiListuSvihZaposlenihOperacija vlt= new VratiListuSvihZaposlenihOperacija();
            Zaposleni zaposleni= new Zaposleni();
               try {
                   vlt.izvrsi(zaposleni, null);
                   return vlt.getSviZaposleni();
               } catch (Exception ex) {
                   Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
               }
               return null;
    }

    public void kreirajZaposleni(Zaposleni zaposleni) throws Exception {
        KreirajZaposleniOperacija kmo= new KreirajZaposleniOperacija();
           try {
               kmo.izvrsi(zaposleni, " where ime like \"" + zaposleni.getIme()+ "\" and prezime like \""+zaposleni.getPrezime()+ "\" and email like \""+zaposleni.getEmail()+ "\" and lozinka like \""+zaposleni.getLozinka()+ "\"");
           } catch (Exception ex) {
               System.out.println("Neuspesno upisivanje zaposlenog u bazu " +ex.getMessage());
               Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
               throw ex;
           }
    }

    public void obrisiZaposleni(Zaposleni zaposleni) throws Exception {
        ObrisiZaposleniOperacija kmo= new ObrisiZaposleniOperacija();
           try {
               kmo.izvrsi(zaposleni, null);
           } catch (Exception ex) {
               System.out.println("Neuspesno brisanje zaposlenog iz baze " +ex.getMessage());
               Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
               throw ex;
           }
    }

    public void promeniZaposleni(Zaposleni zaposleni) throws Exception {
        PromeniZaposleniOperacija kmo= new PromeniZaposleniOperacija();
           try {
               kmo.izvrsi(zaposleni, null);
           } catch (Exception ex) {
               System.out.println("Neuspesna promena zaposlenog u bazi " +ex.getMessage());
               Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
               throw ex;
           }
    }

    public List<Zaposleni> pretraziZaposleni(Zaposleni zaposleni) {
        PretraziZaposleniOperacija kmo= new PretraziZaposleniOperacija();
           try {
               kmo.izvrsi(zaposleni, "");
               return kmo.getZaposleni();
           } catch (Exception ex) {
               System.out.println("Neuspesna pretraga zaposlenog u bazi " +ex.getMessage());
               Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
           }
           
           return null;
    }

    public List<TerminDezurstva> vratiListuSvihTermina() {
        
        VratiListuSvihTerminaOperacija vlt= new VratiListuSvihTerminaOperacija();
            TerminDezurstva termin= new TerminDezurstva();
               try {
                   vlt.izvrsi(termin, null);
                   return vlt.getTermini();
               } catch (Exception ex) {
                   Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
               }
               return null;
    }

    public void kreirajTermin(TerminDezurstva termin) throws Exception {
        KreirajTerminOperacija kmo= new KreirajTerminOperacija();
           try {
               kmo.izvrsi(termin, " where pocetak= '" + termin.getPocetak()+ "' and kraj='"+termin.getKraj()+ "' and trajanje="+termin.getTrajanje());
           } catch (Exception ex) {
               System.out.println("Neuspesno upisivanje termina u bazu " +ex.getMessage());
               Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
               throw ex;
           }
    }

    public void obrisiTermin(TerminDezurstva termin) throws Exception {
        ObrisiTerminOperacija kmo= new ObrisiTerminOperacija();
           try {
               kmo.izvrsi(termin, null);
           } catch (Exception ex) {
               System.out.println("Neuspesno brisanje termina iz baze " +ex.getMessage());
               Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
               throw ex;
           }
    }

    public void promeniTermin(TerminDezurstva termin) throws Exception {
        PromeniTerminOperacija kmo= new PromeniTerminOperacija();
           try {
               kmo.izvrsi(termin, null);
           } catch (Exception ex) {
               System.out.println("Neuspesna promena termina u bazi " +ex.getMessage());
               Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
               throw ex;
           }
    }

    public List<TerminDezurstva> pretraziTermin(TerminDezurstva termin) {
        PretraziTerminOperacija kmo= new PretraziTerminOperacija();
           try {
               kmo.izvrsi(termin, "");
               return kmo.getTermini();
           } catch (Exception ex) {
               System.out.println("Neuspesna pretraga termina u bazi " +ex.getMessage());
               Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
           }
           
           return null;
    }

    public void kreirajPoslovniPartner(PoslovniPartner partner) throws Exception {
        KreirajPoslovniPartnerOperacija kmo= new KreirajPoslovniPartnerOperacija();
           try {
               kmo.izvrsi(partner, " where ime like \"" + partner.getIme()+ "\" and prezime like \""+partner.getPrezime()+ "\" and idMesta="+partner.getMesto().getIdMesta());
           } catch (Exception ex) {
               System.out.println("Neuspesno upisivanje partnera u bazu " +ex.getMessage());
               Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
               throw ex;
           }
    }

    public void obrisiPoslovniPartner(PoslovniPartner partner) throws Exception {
        ObrisiPoslovniPartnerOperacija kmo= new ObrisiPoslovniPartnerOperacija();
           try {
               kmo.izvrsi(partner, null);
           } catch (Exception ex) {
               System.out.println("Neuspesno brisanje termina iz baze " +ex.getMessage());
               Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
               throw ex;
           }
    }

    public void promeniPoslovniPartner(PoslovniPartner partner) throws Exception {
        PromeniPoslovniPartnerOperacija kmo= new PromeniPoslovniPartnerOperacija();
           try {
               kmo.izvrsi(partner, null);
           } catch (Exception ex) {
               System.out.println("Neuspesna promena termina u bazi " +ex.getMessage());
               Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
               throw ex;
           }
    }

    public List<PoslovniPartner> pretraziPoslovniPartner(PoslovniPartner partner) {
        PretraziPoslovniPartnerOperacija kmo= new PretraziPoslovniPartnerOperacija();
           try {
               kmo.izvrsi(partner, " join mesto on "+ partner.vratiNazivTabele()+".idMesta=mesto.idMesta");
               return kmo.getPoslovniPartner();
           } catch (Exception ex) {
               System.out.println("Neuspesna pretraga termina u bazi " +ex.getMessage());
               Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
           }
           
           return null;
    }

    public List<PoslovniPartner> vratiListuSvihPartnera() {
        VratiListuSvihPartneraOperacija vlt= new VratiListuSvihPartneraOperacija();
            PoslovniPartner partner= new PoslovniPartner();
               try {
                   vlt.izvrsi(partner, null);
                   return vlt.getSviPartneri();
               } catch (Exception ex) {
                   Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
               }
               return null;
    }

    public List<StavkeIznajmljivanja> vratiListuStavkeIznajmljivanja(int id) {
        VratiListuIznajmljivanjaOperacija vlt= new VratiListuIznajmljivanjaOperacija();
            StavkeIznajmljivanja stavka= new StavkeIznajmljivanja();
            
            String kljuc= " join iznajmljivanje on "+ stavka.vratiNazivTabele()+".idIznajmljivanje=iznajmljivanje.idIznajmljivanje join trotinet on stavkaiznajmljivanja.idTrotineta=trotinet.idTrotineta where iznajmljivanje.idIznajmljivanje="+ id;
               try {
                   vlt.izvrsi(stavka, kljuc);
                   return vlt.getStavke();
               } catch (Exception ex) {
                   Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
               }
               return null;
    }

    public void kreirajStavkeIznajmljivanja(StavkeIznajmljivanja stavka) throws Exception {
        KreirajIznajmljivanjeOperacija kmo= new KreirajIznajmljivanjeOperacija();
           try {
               kmo.izvrsi(stavka, " where idStavke= " + stavka.getIdStavke());
           } catch (Exception ex) {
               System.out.println("Neuspesno upisivanje stavke u bazu " +ex.getMessage());
               Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
               throw ex;
           }
    }

    public void obrisiStavkeIznajmljivanja(StavkeIznajmljivanja stavka) throws Exception {
        PromeniIznajmljivanjeOperacija kmo= new PromeniIznajmljivanjeOperacija();
           try {
               kmo.izvrsi(stavka, "obrisi");
           } catch (Exception ex) {
               System.out.println("Neuspesno brisanje stavke iz baze " +ex.getMessage());
               Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
               throw ex;
           }
    }

    public List<Iznajmljivanje> vratiListuIznajmljivanja() {
        VratiListuIznajmljivanjaOperacija vlt= new VratiListuIznajmljivanjaOperacija();
            Iznajmljivanje iznajmljivanje= new Iznajmljivanje();
            
            String kljuc= " JOIN zaposleni ON zaposleni.idZaposlenog=iznajmljivanje.idZaposlenog JOIN poslovnipartner ON poslovnipartner.idPoslovniPartner=iznajmljivanje.idPoslovnogPartnera JOIN mesto ON mesto.idMesta=poslovnipartner.IdMesta";
               try {
                   vlt.izvrsi(iznajmljivanje, kljuc);
                   return vlt.getIznajmljivanja();
               } catch (Exception ex) {
                   Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
               }
               return null;
    }
    
    public void kreirajIznajmljivanje(Iznajmljivanje iznajmljivanje) throws Exception {
        KreirajIznajmljivanjeOperacija kmo= new KreirajIznajmljivanjeOperacija();
           try {
               kmo.izvrsi(iznajmljivanje, null);
           } catch (Exception ex) {
               System.out.println("Neuspesno upisivanje partnera u bazu " +ex.getMessage());
               Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
               throw ex;
           }
    }

    public List<Iznajmljivanje> pretraziIznajmljivanje(Iznajmljivanje iznajmljivanje) throws Exception {
        PretraziIznajmljivanjeOperacija kmo= new PretraziIznajmljivanjeOperacija();
           try {
               kmo.izvrsi(iznajmljivanje, " JOIN zaposleni ON zaposleni.idZaposlenog=iznajmljivanje.idZaposlenog JOIN poslovnipartner ON poslovnipartner.idPoslovniPartner=iznajmljivanje.idPoslovnogPartnera JOIN mesto ON mesto.idMesta=poslovnipartner.IdMesta");
               return kmo.getIznajmljivanje();
           } catch (Exception ex) {
               System.out.println("Neuspesno brisanje termina iz baze " +ex.getMessage());
               Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
               throw ex;
           }
    }

    public void promeniIznajmljivanje(Iznajmljivanje iznajmljivanje) throws Exception {
        PromeniIznajmljivanjeOperacija kmo= new PromeniIznajmljivanjeOperacija();
           try {
               kmo.izvrsi(iznajmljivanje, null);
           } catch (Exception ex) {
               System.out.println("Neuspesna promena iznajmljivanja u bazi " +ex.getMessage());
               Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
               throw ex;
           }
    }

    public void promeniStavkeIznajmljivanja(StavkeIznajmljivanja stavka) {
        PromeniIznajmljivanjeOperacija kmo= new PromeniIznajmljivanjeOperacija();
           try {
               kmo.izvrsi(stavka, "");
           } catch (Exception ex) {
               System.out.println("Neuspesna promena stavke u bazi " +ex.getMessage());
               Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
            
           }
    }
}
