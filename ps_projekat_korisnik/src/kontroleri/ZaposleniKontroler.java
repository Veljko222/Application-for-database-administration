/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import forme.IznajmljivanjeForma;
import forme.ZaposleniForma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import klijent.Komunikacija;
import modeli.Mesto;
import modeli.PoslovniPartner;
import modeli.Zaposleni;
import transfer.Odgovor;

/**
 *
 * @author User
 */
public class ZaposleniKontroler {
         private final ZaposleniForma tf;
         private IznajmljivanjeForma rf=null;

    public ZaposleniKontroler( ZaposleniForma tf, IznajmljivanjeForma rf) {
        this.tf = tf;
        this.rf=rf;
        vratiListuSvihZaposlenia();
        tf.popuniTblZaposleni();
        addKreirajActionListener();
        addObrisiActionListener();
       addPromeniActionListener();
        addSelectujActionListener();
        addIzadjiActionListener();
        addPretraziActionListener();
    }

    private void addKreirajActionListener() {
        tf.kreirajAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               String prezime;
                String naziv=tf.getTxtIme().getText().trim();
                
                     prezime = tf.getTxtPrezime().getText().trim();
               String email= tf.getTxtMail().getText().trim();
               String lozinka= tf.getTxtLozinka().getText().trim();
                Zaposleni zaposleni= new Zaposleni();
                zaposleni.setIme(naziv);
                zaposleni.setPrezime(prezime);
                zaposleni.setEmail(email);
                zaposleni.setLozinka(lozinka);
                Odgovor odg=Komunikacija.getInstance().kreirajZaposleni(zaposleni);
                
                if(odg.getOdgovor() != null)
                    
                    JOptionPane.showMessageDialog(tf, "Neuspesan unos zaposlenog, proverite podatke" );
                else{
                    vratiListuSvihZaposlenia();
                    tf.popuniTblZaposleni(); 
                    JOptionPane.showMessageDialog(tf, "Uspesan unos zaposlenog");
                }
            }
        });
    }
    
        private void addObrisiActionListener() {
        tf.obrisiAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row=tf.getTblZaposleni().getSelectedRow();
                if(row==-1){
                    JOptionPane.showMessageDialog(tf, "Selektujte red");
                }
                Zaposleni trotinet= new Zaposleni();
                trotinet.setIme((String) tf.getTblZaposleni().getValueAt(row, 1));
                trotinet.setIdZaposlenog((int) tf.getTblZaposleni().getValueAt(row, 0));
                Boolean uspeh=Komunikacija.getInstance().obrisiZaposleni(trotinet);
                
                if(uspeh == false)
                    JOptionPane.showMessageDialog(tf, "Neuspesno brisanje zaposlenog, proverite selekciju");
                else{
                    vratiListuSvihZaposlenia();
                    tf.popuniTblZaposleni(); 
                    JOptionPane.showMessageDialog(tf, "Uspesno brisanje zaposlenog");
                }
            }
        });
    }
        
                private void addPromeniActionListener() {
        tf.promeniAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                Zaposleni trotinet= new Zaposleni();
                if(!(tf.getTxtId().getText().isEmpty()) && !(tf.getTxtIme().getText().isEmpty()) && !(tf.getTxtPrezime().getText().isEmpty()) && !(tf.getTxtMail().getText().isEmpty()) 
                        && !(tf.getTxtLozinka().getText().isEmpty())){
              
                        trotinet.setIdZaposlenog(Integer.valueOf(tf.getTxtId().getText()));
                        trotinet.setIme(tf.getTxtIme().getText());
                        trotinet.setPrezime(tf.getTxtPrezime().getText());
                        trotinet.setEmail(tf.getTxtMail().getText());
                        trotinet.setLozinka(tf.getTxtLozinka().getText());
                 
                }else{
                    JOptionPane.showMessageDialog(tf, "Morate selektovati zaposlenog i uneti odgovarajuce podatke");
                    return;
                }
                
                Boolean uspeh=Komunikacija.getInstance().promeniZaposleni(trotinet);
                
                if(uspeh == false)
                    JOptionPane.showMessageDialog(tf, "Neuspesno menjanje zaposlenog, proverite naziv zaposlenog i da li cena brojcana vrednos veca od nule");
                else{
                    vratiListuSvihZaposlenia();
                    tf.popuniTblZaposleni(); 
                    tf.getTxtId().setEditable(true);
                tf.getBtnIzmeni().setEnabled(false);
                    JOptionPane.showMessageDialog(tf, "Uspesno menjanje zaposlenog");
                }
            }
        });
    }
                
                private void addPretraziActionListener() {
        tf.pretraziAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                Zaposleni trotinet= new Zaposleni();
                
                if(!(tf.getTxtId().getText().isEmpty()) )
                    try{
                    trotinet.setIdZaposlenog(Integer.valueOf(tf.getTxtId().getText()));
                    }catch(NumberFormatException ex){
                        JOptionPane.showMessageDialog(tf, "Id mora biti broj");
                    }
                if(!(tf.getTxtIme().getText().isEmpty()))    
                    trotinet.setIme(tf.getTxtIme().getText());
                if(!(tf.getTxtPrezime().getText().isEmpty()))
                    try{
                    trotinet.setPrezime(tf.getTxtPrezime().getText());
                    }catch(NumberFormatException ex){
                        JOptionPane.showMessageDialog(tf, "Cena po satu mora biti broj");
                    }
                
                List<Zaposleni> zaposleni=Komunikacija.getInstance().pretraziZaposleni(trotinet);
                
                    tf.setZaposleni(zaposleni);
                    tf.popuniTblZaposleni();
                }
                
            
        });
    }
                
                private void addSelectujActionListener() {
        tf.selektujAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row=tf.getTblZaposleni().getSelectedRow();
                if(row==-1){
                    JOptionPane.showMessageDialog(tf, "Selektujte red");
                    if(rf!=null){
                    rf.setZaposleni(null);
                    rf.getLblZaposleni().setText("Zaposleni nije izabran");
                    }
                }
                tf.getTxtId().setEditable(false);
                tf.getBtnIzmeni().setEnabled(true);
                tf.getTxtId().setText(String.valueOf(tf.getTblZaposleni().getValueAt(row, 0)));
                tf.getTxtIme().setText((String) tf.getTblZaposleni().getValueAt(row, 1));
                tf.getTxtPrezime().setText(String.valueOf(tf.getTblZaposleni().getValueAt(row, 2)));
                tf.getTxtMail().setText(String.valueOf(tf.getTblZaposleni().getValueAt(row, 3)));
                tf.getTxtLozinka().setText(String.valueOf(tf.getTblZaposleni().getValueAt(row, 4)));
                if(rf!=null){
                rf.setZaposleni(new Zaposleni((int) tf.getTblZaposleni().getValueAt(row, 0), (String) tf.getTblZaposleni().getValueAt(row, 1), (String) tf.getTblZaposleni().getValueAt(row, 2), (String) tf.getTblZaposleni().getValueAt(row, 3), (String) tf.getTblZaposleni().getValueAt(row, 4)));
                rf.getLblZaposleni().setText("Zaposleni sa imenom "+ tf.getTblZaposleni().getValueAt(row, 1)+" "+tf.getTblZaposleni().getValueAt(row, 2) + " je izabran");
                }
              
            }
        });
    }
                
                private void addIzadjiActionListener() {
        tf.izadjiAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tf.dispose();
                
              
            }
        });
    }
    
    public void otvoriZaposleniForma(){
        tf.setVisible(true);
    }

    private void vratiListuSvihZaposlenia() {
         List<Zaposleni> zaposleni=new ArrayList<>();
         zaposleni=Komunikacija.getInstance().vratiListuSvihZaposlenih();
         tf.setZaposleni(zaposleni);
    }
}
