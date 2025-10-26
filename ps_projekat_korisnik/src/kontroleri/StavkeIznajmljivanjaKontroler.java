/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import forme.IznajmljivanjeForma;
import forme.StavkeIznajmljivanjaForma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import klijent.Komunikacija;
import kordinator.Kordinator;
import modeli.Iznajmljivanje;
import modeli.Mesto;
import modeli.StavkeIznajmljivanja;
import modeli.Trotinet;

/**
 *
 * @author User
 */
public class StavkeIznajmljivanjaKontroler {
     private final StavkeIznajmljivanjaForma sif;
     private Iznajmljivanje iznajmljivanje;   
     private IznajmljivanjeKontroler izKont;
     private StavkeIznajmljivanja stavka;
     
     
    public StavkeIznajmljivanjaKontroler(StavkeIznajmljivanjaForma mf, Iznajmljivanje iznajmljivanje, IznajmljivanjeKontroler izf){
        this.sif = mf;
        this.izKont= izf;
        this.iznajmljivanje=iznajmljivanje;
        vratiListuStavkeIznajmljivanja();
        mf.popuniTblStavke();
        addKreirajActionListener();
        addObrisiActionListener();
        addSelectujActionListener();
        addIzadjiActionListener();
        addPromeniActionListener();
        addIzaberiActionListener();
    }

    private void addKreirajActionListener() {
        sif.kreirajAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int brojSati=Integer.parseInt(sif.getTxtBrojSati().getText());
                int cenaPoSatu=Integer.parseInt(sif.getTxtCena().getText());
                StavkeIznajmljivanja stavka= new StavkeIznajmljivanja(0, iznajmljivanje.getIdIznajmljivanja(), sif.getTrotinet(), brojSati, cenaPoSatu);
                
                Boolean uspeh=Komunikacija.getInstance().kreirajStavkeIznajmljivanja(stavka);
                
                if(uspeh == false)
                    JOptionPane.showMessageDialog(sif, "Neuspesan unos stavke, proverite selekciju");
                else{
                    vratiListuStavkeIznajmljivanja();
                    sif.popuniTblStavke(); 
                    JOptionPane.showMessageDialog(sif, "Uspesan unos stavke");
                }
            }
        });
    }
    
     private void addPromeniActionListener() {
        sif.promeniAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                StavkeIznajmljivanja iznajmljivanje= new StavkeIznajmljivanja();
                if(!(sif.getTxtBrojSati().getText().isEmpty()) && !(sif.getTxtCena().getText().isEmpty()) && sif.getTrotinet()!=null){
               iznajmljivanje.setBrojSati(Integer.valueOf(sif.getTxtBrojSati().getText()));
                iznajmljivanje.setCenaPoSatu(Integer.valueOf(sif.getTxtCena().getText()));
                iznajmljivanje.setIdIznajmljivanja(stavka.getIdIznajmljivanja());
                iznajmljivanje.setIdStavke(stavka.getIdStavke());
                iznajmljivanje.setTrotinet(sif.getTrotinet());
                }else{
                    JOptionPane.showMessageDialog(sif, "Morate selektovati stavku");
                    return;
                }
                
                Boolean uspeh=Komunikacija.getInstance().promeniStavkuIznajmljivanja(iznajmljivanje);
                
                if(uspeh == false)
                    JOptionPane.showMessageDialog(sif, "Neuspesno menjanje iznajmljivanja");
                else{
                    vratiListuStavkeIznajmljivanja();
                    sif.popuniTblStavke();
                    
                    sif.getBtnIzmeni().setEnabled(false);
                    JOptionPane.showMessageDialog(sif, "Uspesno menjanje iznajmljivanja");
                }
            }
        });
    } 
    
        private void addObrisiActionListener() {
        sif.obrisiAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              
                
                
                
                 Boolean uspeh=Komunikacija.getInstance().obrisiStavkeIznajmljivanja(stavka);
                if(uspeh == false)
                    JOptionPane.showMessageDialog(sif, "Neuspesno brisanje stavke, proverite selekciju");
                else{
                    vratiListuStavkeIznajmljivanja();
                    sif.popuniTblStavke(); 
                    JOptionPane.showMessageDialog(sif, "Uspesno brisanje stavke");
                    stavka=null;
                }
            }
        });
    }
        
        private void addSelectujActionListener() {
        sif.selektujAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               int row=sif.getTblStavke().getSelectedRow();
                if(row==-1){
                    JOptionPane.showMessageDialog(sif, "Selektujte red");
                }else{
                
                sif.getBtnIzmeni().setEnabled(true);
                 stavka= new StavkeIznajmljivanja((int) sif.getTblStavke().getValueAt(row, 1), (int) sif.getTblStavke().getValueAt(row, 0),(Trotinet) sif.getTblStavke().getValueAt(row, 6), (int) sif.getTblStavke().getValueAt(row, 2), (int) sif.getTblStavke().getValueAt(row, 4) );
                sif.getTxtBrojSati().setText(""+stavka.getBrojSati());
                
                 sif.getTxtCena().setText(""+stavka.getCenaPoSatu());
                 sif.setTrotinet(stavka.getTrotinet());
                 sif.getLblTrotinet().setText("Trotinet sa nazivom "+ stavka.getTrotinet().getNaziv()+" je izabran" );
                }
            }
        });
    }
        
                
                
                private void addIzaberiActionListener() {
        sif.izaberiAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Kordinator.getInstance().otvoriPretraziTrotinetFormu(sif);
                
            }
            });
            }
                
                
                
                private void addIzadjiActionListener() {
        sif.izadjiAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                int cena=0;
                int lastRow = sif.getTblStavke().getRowCount() - 1;
                if(lastRow!=-1){
              for(int i=0; i<=lastRow; i++ ){
                  int brojSati=(int)sif.getTblStavke().getValueAt(i, 2);
               Trotinet trotinet=(Trotinet) sif.getTblStavke().getValueAt(i, 6);
               cena+=brojSati*trotinet.getCenaPoSatu();
              }
                iznajmljivanje.setCena(cena);
                Komunikacija.getInstance().promeniIznajmljivanje(iznajmljivanje);
                
                izKont.vratiListuIznajmljivanje();
                izKont.getIzForm().popuniTblIznajmljivanje();
                }
                sif.dispose();
                
            }
        });
    }
    
    public void otvoriStavkeIznajmljivanjaForma(){
        sif.setVisible(true);
    }

    private void vratiListuStavkeIznajmljivanja() {
         List<StavkeIznajmljivanja> stavke=new ArrayList<>();
         stavke=Komunikacija.getInstance().vratiListuStavkeIznajmljivanja(iznajmljivanje.getIdIznajmljivanja());
         sif.setStavke(stavke);
    }
}
