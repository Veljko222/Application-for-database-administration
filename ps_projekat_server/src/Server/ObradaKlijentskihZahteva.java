/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kontroler.Kontroler;
import modeli.Iznajmljivanje;
import modeli.Mesto;
import modeli.PoslovniPartner;
import modeli.StavkeIznajmljivanja;
import modeli.TerminDezurstva;
import modeli.Trotinet;
import modeli.Zaposleni;


import transfer.Zahtev;
import transfer.Posiljalac;
import transfer.Primalac;
import transfer.Odgovor;
import operacije.Operacije;

/**
 *
 * @author User
 */
public class ObradaKlijentskihZahteva extends Thread {
    
    private Socket s;
    
    Posiljalac posiljalac;
    Primalac primalac;
    
    public ObradaKlijentskihZahteva(Socket s) {
        this.s = s;
     
      posiljalac= new Posiljalac(s);
      primalac=new Primalac(s);
    }

    @Override
    public void run() {
        while(true){
        Zahtev kz= (Zahtev) primalac.primi(); //(operacija, param)
            System.out.println("Primljen zahtev "+Operacije.getNazivOperacije(kz.getOperacija())+"---------------------------");
        Odgovor odgovor= new Odgovor();
       try {  
           switch(kz.getOperacija()){
            case Operacije.VratiListuMesta:
                List<Mesto> mesta=new ArrayList<>();
                mesta= Kontroler.getInstance().vratiListuSvihMesta();
                odgovor.setOdgovor(mesta);
                break;
               
            case Operacije.Login:
                Zaposleni z= (Zaposleni) kz.getParam();
                z= Kontroler.getInstance().login(z);
                odgovor.setOdgovor(z);
                
                break;
               
            case Operacije.KreirajMesto:
                try {
                    Mesto mesto = (Mesto) kz.getParam();
                    Kontroler.getInstance().kreirajMesto(mesto);
                    odgovor.setOdgovor(null);
                } catch (Exception e) {
                    odgovor.setOdgovor(e);
                }
                
                break;
            
            case Operacije.ObrisiMesto:
                 try {
                    Mesto mesto = (Mesto) kz.getParam();
                    Kontroler.getInstance().obrisiMesto(mesto);
                    odgovor.setOdgovor(null);
                } catch (Exception e) {
                    odgovor.setOdgovor(e);
                }
                
                break;
            
            case Operacije.PromeniMesto:
                 try {
                    Mesto mesto = (Mesto) kz.getParam();
                    Kontroler.getInstance().promeniMesto(mesto);
                    odgovor.setOdgovor(null);
                     System.out.println(odgovor.getOdgovor());
                } catch (Exception e) {
                     
                    odgovor.setOdgovor(e);
                }
                 break;
                 
            case Operacije.PretraziMesto:
                try {
                    Mesto mesto = (Mesto) kz.getParam();
                    mesta= Kontroler.getInstance().pretraziMesto(mesto);
                    odgovor.setOdgovor(mesta);
                } catch (Exception e) {
                    odgovor.setOdgovor(e);
                }
                break;
                
            case Operacije.VratiListuTrotineta:
                List<Trotinet> trotineti=new ArrayList<>();
                trotineti= Kontroler.getInstance().vratiListuSvihTrotineta();
                odgovor.setOdgovor(trotineti);
                break;
            
            case Operacije.KreirajTrotinet:
                try {
                    Trotinet trotinet = (Trotinet) kz.getParam();
                    Kontroler.getInstance().kreirajTrotinet(trotinet);
                    odgovor.setOdgovor(null);
                } catch (Exception e) {
                   
                    odgovor.setOdgovor(e);
                }
                
                break;
                
            case Operacije.ObrisiTrotinet:
                try {
                    Trotinet trotinet = (Trotinet) kz.getParam();
                    Kontroler.getInstance().obrisiTrotinet(trotinet);
                    odgovor.setOdgovor(null);
                } catch (Exception e) {
                    odgovor.setOdgovor(e);
                }
                
                break;
                
            case Operacije.PromeniTrotinet:
                try {
                    Trotinet trotinet = (Trotinet) kz.getParam();
                    Kontroler.getInstance().promeniTrotinet(trotinet);
                    odgovor.setOdgovor(null);
                } catch (Exception e) {
                    odgovor.setOdgovor(e);
                }
                
                break;
                
            case Operacije.PretraziTrotinet:
                try {
                    Trotinet trotinet = (Trotinet) kz.getParam();
                    trotineti= Kontroler.getInstance().pretraziTrotinet(trotinet);
                    odgovor.setOdgovor(trotineti);
                } catch (Exception e) {
                    odgovor.setOdgovor(e);
                }
                
                break;
                
            case Operacije.VratiListuZaposlenih:
                List<Zaposleni> sviZaposleni=new ArrayList<>();
                sviZaposleni= Kontroler.getInstance().vratiListuSvihZaposlenih();
                odgovor.setOdgovor(sviZaposleni);
                break;
                
            case Operacije.KreirajZaposleni:
                try {
                    Zaposleni zaposleni = (Zaposleni) kz.getParam();
                    Kontroler.getInstance().kreirajZaposleni(zaposleni);
                   odgovor.setOdgovor(null);
                } catch (Exception e) {
                    odgovor.setOdgovor(e);
                }
                
                break;
                
            case Operacije.ObrisiZaposleni:
                try {
                    Zaposleni zaposleni = (Zaposleni) kz.getParam();
                    Kontroler.getInstance().obrisiZaposleni(zaposleni);
                    odgovor.setOdgovor(null);
                } catch (Exception e) {
                    odgovor.setOdgovor(e);
                }
                
                break;
                
            case Operacije.PromeniZaposleni:
                try {
                    Zaposleni zaposleni = (Zaposleni) kz.getParam();
                    Kontroler.getInstance().promeniZaposleni(zaposleni);
                    odgovor.setOdgovor(null);
                } catch (Exception e) {
                    odgovor.setOdgovor(e);
                }
                
                break;
                
            case Operacije.PretraziZaposleni:
                try {
                    Zaposleni zaposleni = (Zaposleni) kz.getParam();
                    sviZaposleni= Kontroler.getInstance().pretraziZaposleni(zaposleni);
                    odgovor.setOdgovor(sviZaposleni
                    );
                } catch (Exception e) {
                    odgovor.setOdgovor(e);
                }
                
                break;
                
            case Operacije.VratiListuTerminaD:
                List<TerminDezurstva> termini=new ArrayList<>();
                termini= Kontroler.getInstance().vratiListuSvihTermina();
                odgovor.setOdgovor(termini);
                break;
                
            case Operacije.KreirajTerminD:
                try {
                    TerminDezurstva termin = (TerminDezurstva) kz.getParam();
                    Kontroler.getInstance().kreirajTermin(termin);
                   odgovor.setOdgovor(null);
                } catch (Exception e) {
                    odgovor.setOdgovor(e);
                }
                
                break;
                
            case Operacije.ObrisiTerminD:
                try {
                    TerminDezurstva termin = (TerminDezurstva) kz.getParam();
                    Kontroler.getInstance().obrisiTermin(termin);
                    odgovor.setOdgovor(null);
                } catch (Exception e) {
                    odgovor.setOdgovor(e);
                }
                
                break;
                
            case Operacije.PromeniTerminD:
                try {
                    TerminDezurstva termin = (TerminDezurstva) kz.getParam();
                    Kontroler.getInstance().promeniTermin(termin);
                    odgovor.setOdgovor(null);
                } catch (Exception e) {
                    odgovor.setOdgovor(e);
                }
                
                break;
                
            case Operacije.PretraziTerminD:
                try {
                    TerminDezurstva termin = (TerminDezurstva) kz.getParam();
                    termini= Kontroler.getInstance().pretraziTermin(termin);
                    odgovor.setOdgovor(termini);
                } catch (Exception e) {
                    odgovor.setOdgovor(e);
                }
                
            case Operacije.VratiListuPoslovniPartner:
                List<PoslovniPartner> partneri=new ArrayList<>();
                partneri= Kontroler.getInstance().vratiListuSvihPartnera();
                odgovor.setOdgovor(partneri);
                break;
                
            case Operacije.KreirajPoslovniPartner:
                try {
                    PoslovniPartner partner = (PoslovniPartner) kz.getParam();
                    Kontroler.getInstance().kreirajPoslovniPartner(partner);
                   odgovor.setOdgovor(null);
                } catch (Exception e) {
                    odgovor.setOdgovor(e);
                }
                
                break;
                
            case Operacije.ObrisiPoslovniPartner:
                try {
                    PoslovniPartner partner = (PoslovniPartner) kz.getParam();
                    Kontroler.getInstance().obrisiPoslovniPartner(partner);
                    odgovor.setOdgovor(null);
                } catch (Exception e) {
                    odgovor.setOdgovor(e);
                }
                
                break;
                
            case Operacije.PromeniPoslovniPartner:
                try {
                    PoslovniPartner partner = (PoslovniPartner) kz.getParam();
                    Kontroler.getInstance().promeniPoslovniPartner(partner);
                    odgovor.setOdgovor(null);
                } catch (Exception e) {
                    odgovor.setOdgovor(e);
                }
                
                break;
                
            case Operacije.PretraziPoslovniPartner:
                try {
                    PoslovniPartner partner = (PoslovniPartner) kz.getParam();
                    partneri= Kontroler.getInstance().pretraziPoslovniPartner(partner);
                    odgovor.setOdgovor(partneri);
                } catch (Exception e) {
                    odgovor.setOdgovor(e);
                }
                
                break;
                
            case Operacije.VratiListuStavkeIznajmljivanja:
                List<StavkeIznajmljivanja> stavke=new ArrayList<>();
                int id=(int) kz.getParam();
                stavke= Kontroler.getInstance().vratiListuStavkeIznajmljivanja(id);
                odgovor.setOdgovor(stavke);
                break;
                
            case Operacije.KreirajStavkeIznajmljivanja:
                try {
                    StavkeIznajmljivanja stavka = (StavkeIznajmljivanja) kz.getParam();
                    Kontroler.getInstance().kreirajStavkeIznajmljivanja(stavka);
                   odgovor.setOdgovor(null);
                } catch (Exception e) {
                    odgovor.setOdgovor(e);
                }
                
                break;
                
            case Operacije.ObrisiStavkeIznajmljivanja:
                try {
                    StavkeIznajmljivanja stavka = (StavkeIznajmljivanja) kz.getParam();
                    Kontroler.getInstance().obrisiStavkeIznajmljivanja(stavka);
                    odgovor.setOdgovor(null);
                } catch (Exception e) {
                    odgovor.setOdgovor(e);
                }
                
                break;
                
            case Operacije.PromeniStavkuIznajmljivanja:
                try {
                    StavkeIznajmljivanja stavka = (StavkeIznajmljivanja) kz.getParam();
                    Kontroler.getInstance().promeniStavkeIznajmljivanja(stavka);
                    odgovor.setOdgovor(null);
                } catch (Exception e) {
                    odgovor.setOdgovor(e);
                }
                
                break;
                
            case Operacije.VratiListuIznajmljivanje:
                List<Iznajmljivanje> iznajmljivanja=new ArrayList<>();
                
                iznajmljivanja= Kontroler.getInstance().vratiListuIznajmljivanja();
                odgovor.setOdgovor(iznajmljivanja);
                break;
                
            case Operacije.KreirajIznajmljivanje:
                try {
                    
                    Iznajmljivanje iznajmljivanje = (Iznajmljivanje) kz.getParam();
                    Kontroler.getInstance().kreirajIznajmljivanje(iznajmljivanje);
                   odgovor.setOdgovor(null);
                } catch (Exception e) {
                    odgovor.setOdgovor(e);
                }
                
                break;
                
            case Operacije.PretraziIznajmljivanje:
                try {
                    Iznajmljivanje iznajmljivanje = (Iznajmljivanje) kz.getParam();
                    iznajmljivanja= Kontroler.getInstance().pretraziIznajmljivanje(iznajmljivanje);
                    odgovor.setOdgovor(iznajmljivanja);
                } catch (Exception e) {
                    odgovor.setOdgovor(e);
                }
                
                break;
             
            case Operacije.PromeniIznajmljivanje:
                try {
                    Iznajmljivanje iznajmljivanje = (Iznajmljivanje) kz.getParam();
                    Kontroler.getInstance().promeniIznajmljivanje(iznajmljivanje);
                    odgovor.setOdgovor(null);
                } catch (Exception e) {
                    odgovor.setOdgovor(e);
                }
                
                break;
           
           
                
            default:
                System.out.println("Nepostojeca operacija");
        
            }
           
           
        
        posiljalac.posalji(odgovor);
        
        } catch (Exception ex) {
                    Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
    }


    
    
    
}
