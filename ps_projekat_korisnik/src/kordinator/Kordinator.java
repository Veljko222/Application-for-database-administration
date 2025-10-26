/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kordinator;

import forme.GlavnaForma;
import forme.IznajmljivanjeForma;
import forme.LoginForma;
import forme.MestoForma;
import forme.PoslovniPartnerForma;
import forme.StavkeIznajmljivanjaForma;
import forme.TerminDForma;
import forme.TrotinetForma;
import forme.ZaposleniForma;
import kontroleri.GlavnaFormaKontroler;
import kontroleri.IznajmljivanjeKontroler;
import kontroleri.LoginKontroler;
import kontroleri.MestoKontroler;
import kontroleri.PoslovniPartnerKontroler;
import kontroleri.StavkeIznajmljivanjaKontroler;
import kontroleri.TerminDKontroler;
import kontroleri.TrotinetKontroler;
import kontroleri.ZaposleniKontroler;
import modeli.Iznajmljivanje;
import modeli.StavkeIznajmljivanja;
import modeli.Zaposleni;

/**
 *
 * @author User
 */
public class Kordinator {
     private static Kordinator instance;
     private LoginKontroler loginKont;
     private GlavnaFormaKontroler gfKont;
     private Zaposleni ulogovani;
     private MestoKontroler mKont;
     private TrotinetKontroler tKont;
     private ZaposleniKontroler zKont; 
     private TerminDKontroler dKont;
     private PoslovniPartnerKontroler pKont;
     private IznajmljivanjeKontroler iKont;
     private StavkeIznajmljivanjaKontroler sKont;

    public IznajmljivanjeKontroler getiKont() {
        return iKont;
    }
     
     
             
    public Kordinator() {
     
    }

    public Zaposleni getUlogovani() {
        return ulogovani;
    }

    public void setUlogovani(Zaposleni ulogovani) {
        this.ulogovani = ulogovani;
    }
    
    
    public static Kordinator getInstance() {
        if(instance==null)
            instance=new Kordinator();
        return instance;
    }
    
    public void otvoriLoginFormu(){
        loginKont= new LoginKontroler(new LoginForma());
        loginKont.otvoriFormu();
    }
    
    public void otvoriGlavnuFormu(){
        gfKont= new GlavnaFormaKontroler(new GlavnaForma());
        gfKont.otvoriFormu();
    }
    
    public void otvoriKreirajMestoFormu(){
        mKont= new MestoKontroler(new MestoForma(operacije.Operacije.KreirajMesto));
        mKont.otvoriMestoForma();
    }

   

    public void otvoriPromeniMestoFormu() {
        mKont= new MestoKontroler(new MestoForma(operacije.Operacije.PromeniMesto));
        mKont.otvoriMestoForma();
    }

    public void otvoriPretraziMestoFormu(PoslovniPartnerForma pf) {
        mKont= new MestoKontroler(new MestoForma(operacije.Operacije.PretraziMesto), pf);
        mKont.otvoriMestoForma();
    }

    public void otvoriKreirajTrotinetFormu() {
        tKont= new TrotinetKontroler(new TrotinetForma(operacije.Operacije.KreirajTrotinet), null);
        tKont.otvoriTrotinetForma();
    }

    public void otvoriObrisiTrotinetFormu() {
        tKont= new TrotinetKontroler(new TrotinetForma(operacije.Operacije.ObrisiTrotinet), null);
        tKont.otvoriTrotinetForma();
    }

    public void otvoriPromeniTrotinetFormu() {
         tKont= new TrotinetKontroler(new TrotinetForma(operacije.Operacije.PromeniTrotinet), null);
        tKont.otvoriTrotinetForma();
    }

    public void otvoriPretraziTrotinetFormu(StavkeIznajmljivanjaForma rf) {
        tKont= new TrotinetKontroler(new TrotinetForma(operacije.Operacije.PretraziTrotinet), rf);
        tKont.otvoriTrotinetForma();
    }
    
    public void otvoriKreirajZaposleniFormu() {
        zKont= new ZaposleniKontroler(new ZaposleniForma(operacije.Operacije.KreirajZaposleni), null);
        zKont.otvoriZaposleniForma();
    }

    public void otvoriObrisiZaposleniFormu() {
        zKont= new ZaposleniKontroler(new ZaposleniForma(operacije.Operacije.ObrisiZaposleni), null);
        zKont.otvoriZaposleniForma();
    }

    public void otvoriPromeniZaposleniFormu() {
        zKont= new ZaposleniKontroler(new ZaposleniForma(operacije.Operacije.PromeniZaposleni),null);
        zKont.otvoriZaposleniForma();
    }

    public void otvoriPretraziZaposleniFormu(IznajmljivanjeForma rf) {
        zKont= new ZaposleniKontroler(new ZaposleniForma(operacije.Operacije.PretraziZaposleni),rf);
        zKont.otvoriZaposleniForma();
    }
    
    public void otvoriKreirajTerminFormu() {
        dKont= new TerminDKontroler(new TerminDForma(operacije.Operacije.KreirajTerminD));
        dKont.otvoriTerminDForma();
    }

    public void otvoriObrisiTerminFormu() {
        dKont= new TerminDKontroler(new TerminDForma(operacije.Operacije.ObrisiTerminD));
        dKont.otvoriTerminDForma();
    }

    public void otvoriPromeniTerminFormu() {
        dKont= new TerminDKontroler(new TerminDForma(operacije.Operacije.PromeniTerminD));
        dKont.otvoriTerminDForma();
    }

    public void otvoriPretraziTerminFormu() {
        dKont= new TerminDKontroler(new TerminDForma(operacije.Operacije.PretraziTerminD));
        dKont.otvoriTerminDForma();
    }

    public void otvoriPretraziPoslovniPartnerFormu(IznajmljivanjeForma rf) {
        pKont= new PoslovniPartnerKontroler(new PoslovniPartnerForma(operacije.Operacije.PretraziPoslovniPartner), rf);
        pKont.otvoriPoslovniPartnerForma();
    }

    public void otvoriKreirajPoslovniPartnerFormu() {
        pKont= new PoslovniPartnerKontroler(new PoslovniPartnerForma(operacije.Operacije.KreirajPoslovniPartner), null);
        pKont.otvoriPoslovniPartnerForma();
    }

    public void otvoriKreirajIznajmljivanjeFormu() {
        iKont= new IznajmljivanjeKontroler(new IznajmljivanjeForma(operacije.Operacije.KreirajIznajmljivanje));
        iKont.otvoriIznajmljivanjeForma();
    }

    public void otvoriPrikaziIznajmljivanjeFormu() {
        iKont= new IznajmljivanjeKontroler(new IznajmljivanjeForma(operacije.Operacije.PretraziIznajmljivanje));
        iKont.otvoriIznajmljivanjeForma();
    }
    
    public void otvoriKreirajStavkeIznajmljivanjaFormu(Iznajmljivanje iznajmljivanje, IznajmljivanjeKontroler rf) {
        sKont= new StavkeIznajmljivanjaKontroler(new StavkeIznajmljivanjaForma(operacije.Operacije.KreirajStavkeIznajmljivanja),iznajmljivanje, rf);
        sKont.otvoriStavkeIznajmljivanjaForma();
    }

    


}
