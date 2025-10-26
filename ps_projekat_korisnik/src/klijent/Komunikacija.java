/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package klijent;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
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
import operacije.Operacije;
import transfer.Zahtev;
import transfer.Posiljalac;
import transfer.Primalac;
import transfer.Odgovor;

/**
 *
 * @author User
 */
public class Komunikacija {
    
    private Socket s;
    
    private static Komunikacija instance;
    private Posiljalac posiljalac;
    private Primalac primalac;
    
    public Komunikacija() {
      try {
            s = new Socket("localhost", 9000) ;
            posiljalac= new Posiljalac(s);
          
            primalac=new Primalac(s);
        } catch (IOException ex) {
            System.out.println("Server nije povezan");
        }
    }
    

    public static Komunikacija getInstance() {
        if(instance==null)
            instance=new Komunikacija();
        return instance;
    }
    
  


    public Socket getS() {
        return s;
    }

    public static void setInstance(Komunikacija instance) {
        Komunikacija.instance = instance;
    }

    public Zaposleni login(String mail, String pass) {
        Zaposleni z = new Zaposleni() ;
        z.setLozinka(pass) ;
        z.setEmail(mail) ;
        Zahtev zahtev= new Zahtev(Operacije.Login, z);
        posiljalac.posalji(zahtev);
        Odgovor odg= (Odgovor) primalac.primi();
        z= (Zaposleni) odg.getOdgovor();
        return z;
    }
    
  public List<Mesto> vratiListuSvihMesta() {
       Zahtev zahtev= new Zahtev(Operacije.VratiListuMesta, null);
       posiljalac.posalji(zahtev);
        Odgovor odg= (Odgovor) primalac.primi();
        return (List<Mesto>) odg.getOdgovor();
    }
  
  
    public Boolean kreirajMesto(Mesto mesto) {
        Zahtev zahtev= new Zahtev(Operacije.KreirajMesto, mesto);
        posiljalac.posalji(zahtev);
        Odgovor odg= (Odgovor) primalac.primi();
        
        
        if(odg.getOdgovor()==null){
            return true;
        }else{
        return false;
            
        }
        
    }


    public Boolean obrisiMesto(Mesto mesto) {
        Zahtev zahtev= new Zahtev(Operacije.ObrisiMesto, mesto);
        posiljalac.posalji(zahtev);
        Odgovor odg= (Odgovor) primalac.primi();
        
        
        if(odg.getOdgovor()==null){
            return true;
        }else{
        return false;
            
        }
    }

    public Boolean promeniMesto(Mesto mesto) {
        Zahtev zahtev= new Zahtev(Operacije.PromeniMesto, mesto);
        posiljalac.posalji(zahtev);
        Odgovor odg= (Odgovor) primalac.primi();
        
       
        if(odg.getOdgovor()==null){
            
            return true;
        }else{
        return false;
            
        }
    }

    public List<Mesto> pretraziMesto(Mesto mesto) {
        
        Zahtev zahtev= new Zahtev(Operacije.PretraziMesto, mesto);
        posiljalac.posalji(zahtev);
        Odgovor odg= (Odgovor) primalac.primi();
        
        
        return (List<Mesto>) odg.getOdgovor();
    }
    
    
    public List<Trotinet> vratiListuSvihTrotineta() {
            Zahtev zahtev= new Zahtev(Operacije.VratiListuTrotineta, null);
       posiljalac.posalji(zahtev);
        Odgovor odg= (Odgovor) primalac.primi();
        return (List<Trotinet>) odg.getOdgovor();
        }
    
    
    public Boolean kreirajTrotinet(Trotinet trotinet) {
       Zahtev zahtev= new Zahtev(Operacije.KreirajTrotinet, trotinet);
        posiljalac.posalji(zahtev);
        Odgovor odg= (Odgovor) primalac.primi();
        
        
        if(odg.getOdgovor()==null){
            return true;
        }else{
        return false;
            
        }
    }

    public Boolean obrisiTrotinet(Trotinet trotinet) {
        Zahtev zahtev= new Zahtev(Operacije.ObrisiTrotinet, trotinet);
        posiljalac.posalji(zahtev);
        Odgovor odg= (Odgovor) primalac.primi();
        
        
        if(odg.getOdgovor()==null){
            return true;
        }else{
        return false;
            
        }
    }

    public Boolean promeniTrotinet(Trotinet trotinet) {
        Zahtev zahtev= new Zahtev(Operacije.PromeniTrotinet, trotinet);
        posiljalac.posalji(zahtev);
        Odgovor odg= (Odgovor) primalac.primi();
        
        
        if(odg.getOdgovor()==null){
            return true;
        }else{
        return false;
            
        }
    }

    public List<Trotinet> pretraziTrotinet(Trotinet trotinet) {
        Zahtev zahtev= new Zahtev(Operacije.PretraziTrotinet, trotinet);
        posiljalac.posalji(zahtev);
        Odgovor odg= (Odgovor) primalac.primi();
        
        
        return (List<Trotinet>) odg.getOdgovor();
            
        }

    public List<Zaposleni> vratiListuSvihZaposlenih() {
         Zahtev zahtev= new Zahtev(Operacije.VratiListuZaposlenih, null);
       posiljalac.posalji(zahtev);
        Odgovor odg= (Odgovor) primalac.primi();
        return (List<Zaposleni>) odg.getOdgovor();
    }

    public Odgovor kreirajZaposleni(Zaposleni trotinet) {
         Zahtev zahtev= new Zahtev(Operacije.KreirajZaposleni, trotinet);
        posiljalac.posalji(zahtev);
        Odgovor odg= (Odgovor) primalac.primi();
        return odg;
        
        
    }

    public Boolean obrisiZaposleni(Zaposleni trotinet) {
        Zahtev zahtev= new Zahtev(Operacije.ObrisiZaposleni, trotinet);
        posiljalac.posalji(zahtev);
        Odgovor odg= (Odgovor) primalac.primi();
        
        
        if(odg.getOdgovor()==null){
            return true;
        }else{
        return false;
            
        }
    }

    public Boolean promeniZaposleni(Zaposleni trotinet) {
        Zahtev zahtev= new Zahtev(Operacije.PromeniZaposleni, trotinet);
        posiljalac.posalji(zahtev);
        Odgovor odg= (Odgovor) primalac.primi();
        
        
        if(odg.getOdgovor()==null){
            return true;
        }else{
        return false;
            
        }
    }

    public List<Zaposleni> pretraziZaposleni(Zaposleni trotinet) {
        Zahtev zahtev= new Zahtev(Operacije.PretraziZaposleni, trotinet);
        posiljalac.posalji(zahtev);
        Odgovor odg= (Odgovor) primalac.primi();
        
        
        return (List<Zaposleni>) odg.getOdgovor();
    }

    public List<TerminDezurstva> vratiListuSvihTermina() {
        Zahtev zahtev= new Zahtev(Operacije.VratiListuTerminaD, null);
       posiljalac.posalji(zahtev);
        Odgovor odg= (Odgovor) primalac.primi();
        return (List<TerminDezurstva>) odg.getOdgovor();
    }
    
    public Boolean kreirajTerminDezurstva(TerminDezurstva termin) {
         Zahtev zahtev= new Zahtev(Operacije.KreirajTerminD, termin);
        posiljalac.posalji(zahtev);
        Odgovor odg= (Odgovor) primalac.primi();
        if(odg.getOdgovor()==null){
            return true;
        }else{
        return false;
            
        }
        
        
    }

    public Boolean obrisiTerminDezurstva(TerminDezurstva termin) {
        Zahtev zahtev= new Zahtev(Operacije.ObrisiTerminD, termin);
        posiljalac.posalji(zahtev);
        Odgovor odg= (Odgovor) primalac.primi();
        
        
        if(odg.getOdgovor()==null){
            return true;
        }else{
        return false;
            
        }
    }

    public Boolean promeniTerminDezurstva(TerminDezurstva termin) {
        Zahtev zahtev= new Zahtev(Operacije.PromeniTerminD, termin);
        posiljalac.posalji(zahtev);
        Odgovor odg= (Odgovor) primalac.primi();
        
        
        if(odg.getOdgovor()==null){
            return true;
        }else{
        return false;
            
        }
    }

    public List<TerminDezurstva> pretraziTerminDezurstva(TerminDezurstva termin) {
        Zahtev zahtev= new Zahtev(Operacije.PretraziTerminD, termin);
        posiljalac.posalji(zahtev);
        Odgovor odg= (Odgovor) primalac.primi();
        
        
        return (List<TerminDezurstva>) odg.getOdgovor();
    }

    public List<PoslovniPartner> vratiListuPoslovniPartner() {
        Zahtev zahtev= new Zahtev(Operacije.VratiListuPoslovniPartner, null);
       posiljalac.posalji(zahtev);
        Odgovor odg= (Odgovor) primalac.primi();
        return (List<PoslovniPartner>) odg.getOdgovor();
    }

    public Boolean kreirajPoslovniPartner(PoslovniPartner partner) {
        Zahtev zahtev= new Zahtev(Operacije.KreirajPoslovniPartner, partner);
        posiljalac.posalji(zahtev);
        Odgovor odg= (Odgovor) primalac.primi();
        if(odg.getOdgovor()==null){
            return true;
        }else{
        return false;
            
        }
    }

    public Boolean obrisiPoslovniPartner(PoslovniPartner partner) {
        Zahtev zahtev= new Zahtev(Operacije.ObrisiPoslovniPartner, partner);
        posiljalac.posalji(zahtev);
        Odgovor odg= (Odgovor) primalac.primi();
        
        
        if(odg.getOdgovor()==null){
            return true;
        }else{
        return false;
            
        }
    }

    public Boolean promeniPoslovniPartner(PoslovniPartner partner) {
        Zahtev zahtev= new Zahtev(Operacije.PromeniPoslovniPartner, partner);
        posiljalac.posalji(zahtev);
        Odgovor odg= (Odgovor) primalac.primi();
        
        
        if(odg.getOdgovor()==null){
            return true;
        }else{
        return false;
            
        }
    }

    public List<PoslovniPartner> pretraziPoslovniPartner(PoslovniPartner partner) {
        Zahtev zahtev= new Zahtev(Operacije.PretraziPoslovniPartner, partner);
        posiljalac.posalji(zahtev);
        Odgovor odg= (Odgovor) primalac.primi();
        
        
        return (List<PoslovniPartner>) odg.getOdgovor();
    }

    public List<Iznajmljivanje> vratiListuIznajmljivanje() {
        Zahtev zahtev= new Zahtev(Operacije.VratiListuIznajmljivanje, null);
       posiljalac.posalji(zahtev);
        Odgovor odg= (Odgovor) primalac.primi();
        return (List<Iznajmljivanje>) odg.getOdgovor();
    }

    public Boolean kreirajIznajmljivanje(Iznajmljivanje iznajmljivanje) {
        Zahtev zahtev= new Zahtev(Operacije.KreirajIznajmljivanje, iznajmljivanje);
        posiljalac.posalji(zahtev);
        Odgovor odg= (Odgovor) primalac.primi();
        if(odg.getOdgovor()==null){
            return true;
        }else{
        return false;
            
        }
    }



    public Boolean promeniIznajmljivanje(Iznajmljivanje iznajmljivanje) {
        Zahtev zahtev= new Zahtev(Operacije.PromeniIznajmljivanje, iznajmljivanje);
        posiljalac.posalji(zahtev);
        Odgovor odg= (Odgovor) primalac.primi();
        
        
        if(odg.getOdgovor()==null){
            return true;
        }else{
        return false;
            
        }
    }

    public List<Iznajmljivanje> pretraziIznajmljivanje(Iznajmljivanje iznajmljivanje) {
        Zahtev zahtev= new Zahtev(Operacije.PretraziIznajmljivanje, iznajmljivanje);
        posiljalac.posalji(zahtev);
        Odgovor odg= (Odgovor) primalac.primi();
        
        
        return (List<Iznajmljivanje>) odg.getOdgovor();
    }

    public List<StavkeIznajmljivanja> vratiListuStavkeIznajmljivanja(int idIznajmljivanja) {
        Zahtev zahtev= new Zahtev(Operacije.VratiListuStavkeIznajmljivanja, idIznajmljivanja);
       posiljalac.posalji(zahtev);
        Odgovor odg= (Odgovor) primalac.primi();
        return (List<StavkeIznajmljivanja>) odg.getOdgovor();
    }

    public Boolean kreirajStavkeIznajmljivanja(StavkeIznajmljivanja stavka) {
        Zahtev zahtev= new Zahtev(Operacije.KreirajStavkeIznajmljivanja, stavka);
        posiljalac.posalji(zahtev);
        Odgovor odg= (Odgovor) primalac.primi();
        if(odg.getOdgovor()==null){
            return true;
        }else{
        return false;
            
        }
    }

    public Boolean obrisiStavkeIznajmljivanja(StavkeIznajmljivanja stavka) {
        Zahtev zahtev= new Zahtev(Operacije.ObrisiStavkeIznajmljivanja, stavka);
        posiljalac.posalji(zahtev);
        Odgovor odg= (Odgovor) primalac.primi();
        
        
        if(odg.getOdgovor()==null){
            return true;
        }else{
        return false;
            
        }
    }

    public Boolean promeniStavkuIznajmljivanja(StavkeIznajmljivanja iznajmljivanje) {
         Zahtev zahtev= new Zahtev(Operacije.PromeniStavkuIznajmljivanja, iznajmljivanje);
        posiljalac.posalji(zahtev);
        Odgovor odg= (Odgovor) primalac.primi();
        
        
        if(odg.getOdgovor()==null){
            return true;
        }else{
        return false;
            
        }

    }
    

    
    
}