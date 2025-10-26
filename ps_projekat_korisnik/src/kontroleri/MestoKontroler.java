/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import forme.MestoForma;
import forme.PoslovniPartnerForma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import klijent.Komunikacija;
import modeli.Mesto;

/**
 *
 * @author User
 */
public class MestoKontroler {
     private final MestoForma mf;
     private PoslovniPartnerForma pf=null;
     private Mesto izabranoMesto=null;
     
     public MestoKontroler(MestoForma mf, PoslovniPartnerForma pf) {
        this.mf = mf;
        this.pf= pf;
         
        vratiListuSvihMesta();
        mf.popuniTblMesto();
        addKreirajActionListener();
        addObrisiActionListener();
        addPromeniActionListener();
        addSelectujActionListener();
        addIzadjiActionListener();
        addPretraziActionListener();
    }

    public MestoKontroler(MestoForma mf) {
        this.mf = mf;
        vratiListuSvihMesta();
        mf.popuniTblMesto();
        addKreirajActionListener();
        addObrisiActionListener();
        addPromeniActionListener();
        addSelectujActionListener();
        addIzadjiActionListener();
        addPretraziActionListener();
    }

    private void addKreirajActionListener() {
        mf.kreirajAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String naziv=mf.getTxtNaziv().getText().trim();
                Mesto mesto= new Mesto();
                mesto.setNaziv(naziv);
                Boolean uspeh=Komunikacija.getInstance().kreirajMesto(mesto);
                
                if(uspeh == false)
                    JOptionPane.showMessageDialog(mf, "Neuspesan unos mesta, proverite naziv");
                else{
                    vratiListuSvihMesta();
                    mf.popuniTblMesto(); 
                    JOptionPane.showMessageDialog(mf, "Uspesan unos mesta");
                }
            }
        });
    }
    
        private void addObrisiActionListener() {
        mf.obrisiAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row=mf.getTblMesto().getSelectedRow();
                if(row==-1){
                    JOptionPane.showMessageDialog(mf, "Selektujte red");
                }
                Mesto mesto= new Mesto();
                mesto.setNaziv((String) mf.getTblMesto().getValueAt(row, 1));
                mesto.setIdMesta((int) mf.getTblMesto().getValueAt(row, 0));
                Boolean uspeh=Komunikacija.getInstance().obrisiMesto(mesto);
                
                if(uspeh == false)
                    JOptionPane.showMessageDialog(mf, "Neuspesno brisanje mesta, proverite selekciju");
                else{
                    vratiListuSvihMesta();
                    mf.popuniTblMesto(); 
                    JOptionPane.showMessageDialog(mf, "Uspesno brisanje mesta");
                }
            }
        });
    }
        
                private void addPromeniActionListener() {
        mf.promeniAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                Mesto mesto= new Mesto();
                if(!(mf.getTxtId().getText().isEmpty()) && !(mf.getTxtNaziv().getText().isEmpty()) ){
               mesto.setIdMesta(Integer.valueOf(mf.getTxtId().getText()));
                mesto.setNaziv(mf.getTxtNaziv().getText());
                }else{
                    JOptionPane.showMessageDialog(mf, "Morate selektovati mesto i uneti odgovarajuce podatke");
                    return;
                }
                
                Boolean uspeh=Komunikacija.getInstance().promeniMesto(mesto);
                
                if(uspeh == false)
                    JOptionPane.showMessageDialog(mf, "Neuspesno menjanje mesta, proverite naziv mesta");
                else{
                    vratiListuSvihMesta();
                    mf.popuniTblMesto(); 
                    mf.getTxtId().setEditable(true);
                    mf.getBtnIzmeni().setEnabled(false);
                    JOptionPane.showMessageDialog(mf, "Uspesno menjanje mesta");
                }
            }
        });
    }
                
                private void addPretraziActionListener() {
        mf.pretraziAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                Mesto mesto= new Mesto();
                
                if(!(mf.getTxtId().getText().isEmpty()))
                    try{
                    mesto.setIdMesta(Integer.valueOf(mf.getTxtId().getText()));
                    }catch(NumberFormatException ex){
                        JOptionPane.showMessageDialog(mf, "Id mora biti broj");
                    }
                if(!(mf.getTxtNaziv().getText().isEmpty()))    
                    mesto.setNaziv(mf.getTxtNaziv().getText());
                
                
                List<Mesto> mesta=Komunikacija.getInstance().pretraziMesto(mesto);
                
                    mf.setMesta(mesta);
                    mf.popuniTblMesto();
                }
                
            
        });
    }
                
                private void addSelectujActionListener() {
        mf.selektujAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row=mf.getTblMesto().getSelectedRow();
                if(row==-1){
                    JOptionPane.showMessageDialog(mf, "Selektujte red ukoliko hocete da ga izmenite (resetovali ste selekciju)");
                    izabranoMesto=null;
                }else{
                mf.getTxtId().setEditable(false);
                mf.getBtnIzmeni().setEnabled(true);
                mf.getTxtId().setText(String.valueOf( mf.getTblMesto().getValueAt(row, 0)));
                mf.getTxtNaziv().setText((String) mf.getTblMesto().getValueAt(row, 1));
                izabranoMesto=new Mesto((int) mf.getTblMesto().getValueAt(row, 0), (String) mf.getTblMesto().getValueAt(row, 1));
                }
            }
        });
    }
                
                private void addIzadjiActionListener() {
        mf.izadjiAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               if(pf!=null){ 
                pf.setIzabranoMesto(izabranoMesto);
              if(izabranoMesto!=null)
                  pf.getLblMesto().setText("Mesto sa nazivom "+ izabranoMesto.getNaziv()+" je izabrano");
              else
                  pf.getLblMesto().setText("Mesto nije izabrano");
               }
              
              mf.dispose();
            }
        });
    }
    
    public void otvoriMestoForma(){
        mf.setVisible(true);
    }

    private void vratiListuSvihMesta() {
         List<Mesto> mesta=new ArrayList<>();
         mesta=Komunikacija.getInstance().vratiListuSvihMesta();
         mf.setMesta(mesta);
    }

    public Mesto getIzabranoMesto() {
        return izabranoMesto;
    }

    public void setIzabranoMesto(Mesto izabranoMesto) {
        this.izabranoMesto = izabranoMesto;
    }
     
    
    
}
