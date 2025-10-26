/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import forme.IznajmljivanjeForma;
import forme.PoslovniPartnerForma;
import forme.PoslovniPartnerForma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import klijent.Komunikacija;
import kordinator.Kordinator;
import modeli.Mesto;
import modeli.PoslovniPartner;

/**
 *
 * @author User
 */
public class PoslovniPartnerKontroler {
        private final PoslovniPartnerForma pf;
        private IznajmljivanjeForma rf=null;

    public PoslovniPartnerKontroler(PoslovniPartnerForma mf, IznajmljivanjeForma rf) {
        this.pf = mf;
        this.rf=rf;
        vratiListuPoslovniPartner();
        mf.popuniTblPoslovniPartner();
        addKreirajActionListener();
        addObrisiActionListener();
        addPromeniActionListener();
        addSelectujActionListener();
        addIzadjiActionListener();
        addPretraziActionListener();
        addIzaberiActionListener();
    }

    private void addKreirajActionListener() {
        pf.kreirajAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ime=pf.getTxtIme().getText().trim();
                String prezime=pf.getTxtPrezime().getText().trim();
                PoslovniPartner partner= new PoslovniPartner(0, ime, prezime, pf.getIzabranoMesto());
                
                Boolean uspeh=Komunikacija.getInstance().kreirajPoslovniPartner(partner);
                
                if(uspeh == false)
                    JOptionPane.showMessageDialog(pf, "Sistem ne moze da zapamti poslovnog partnera");
                else{
                    vratiListuPoslovniPartner();
                    pf.popuniTblPoslovniPartner(); 
                    JOptionPane.showMessageDialog(pf, "Sistem je zapamtio poslovnog partnera");
                }
            }
        });
    }
    
        private void addObrisiActionListener() {
        pf.obrisiAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row=pf.getTblPoslovniPartner().getSelectedRow();
                if(row==-1){
                    JOptionPane.showMessageDialog(pf, "Selektujte red");
                }
                PoslovniPartner partner= new PoslovniPartner();
                
                partner.setIdPoslovniPartner((int) pf.getTblPoslovniPartner().getValueAt(row, 0));
                partner.setIme((String) pf.getTblPoslovniPartner().getValueAt(row, 1));
                partner.setPrezime((String) pf.getTblPoslovniPartner().getValueAt(row, 2));
                partner.setMesto((Mesto) pf.getTblPoslovniPartner().getValueAt(row, 4));
                
                 Boolean uspeh=Komunikacija.getInstance().obrisiPoslovniPartner(partner);
                if(uspeh == false)
                    JOptionPane.showMessageDialog(pf, "Sistem ne moze da obrise poslovnog partnera");
                else{
                    vratiListuPoslovniPartner();
                    pf.popuniTblPoslovniPartner(); 
                    JOptionPane.showMessageDialog(pf, "Sistem je obrisao poslovnog partnera");
                }
            }
        });
    }
        
                private void addPromeniActionListener() {
        pf.promeniAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                PoslovniPartner partner= new PoslovniPartner();
                if(!(pf.getTxtId().getText().isEmpty()) && !(pf.getTxtIme().getText().isEmpty()) && !(pf.getTxtIme().getText().isEmpty()) && pf.getIzabranoMesto()!=null){
               partner.setIdPoslovniPartner(Integer.valueOf(pf.getTxtId().getText()));
                partner.setIme(pf.getTxtIme().getText());
                partner.setPrezime(pf.getTxtPrezime().getText());
                partner.setMesto(pf.getIzabranoMesto());
                }else{
                    JOptionPane.showMessageDialog(pf, "Morate selektovati partner i uneti odgovarajuce podatke");
                    return;
                }
                System.out.println(partner.toString());
                Boolean uspeh=Komunikacija.getInstance().promeniPoslovniPartner(partner);
                
                if(uspeh == false)
                    JOptionPane.showMessageDialog(pf, "Sistem ne moze da zapamti poslovnog partnera");
                else{
                    vratiListuPoslovniPartner();
                    pf.popuniTblPoslovniPartner(); 
                    pf.getTxtId().setEditable(true);
                    pf.getBtnIzmeni().setEnabled(false);
                    JOptionPane.showMessageDialog(pf, "Sistem je zapamtio poslovnog partnera");
                }
            }
        });
    }
                
                private void addPretraziActionListener() {
        pf.pretraziAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                PoslovniPartner partner= new PoslovniPartner();
                
                if(!(pf.getTxtId().getText().isEmpty()))
                    try{
                    partner.setIdPoslovniPartner(Integer.valueOf(pf.getTxtId().getText()));
                    }catch(NumberFormatException ex){
                        JOptionPane.showMessageDialog(pf, "Id mora biti broj");
                    }
                if(!(pf.getTxtIme().getText().isEmpty()))    
                    partner.setIme(pf.getTxtIme().getText());
                if(!(pf.getTxtPrezime().getText().isEmpty()))    
                    partner.setPrezime(pf.getTxtPrezime().getText());
                
                if(pf.getIzabranoMesto()!=null)
                    partner.setMesto(pf.getIzabranoMesto());
                
                
                List<PoslovniPartner> partneri=Komunikacija.getInstance().pretraziPoslovniPartner(partner);
                
                    pf.setPartneri(partneri);
                    pf.popuniTblPoslovniPartner();
                    if(partneri.size()!=0)
                    JOptionPane.showMessageDialog(pf, "Sistem je nasao poslovne partnere po zadatim kriterijumima");
                    else
                        JOptionPane.showMessageDialog(pf, "Sistem ne moze da nadje poslovne partnere po zadatim kriterijumima");

                
                }
                
            
        });
    }
                
                private void addIzaberiActionListener() {
        pf.izaberiAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Kordinator.getInstance().otvoriPretraziMestoFormu(pf);
                
            }
            });
            }
                
                private void addSelectujActionListener() {
        pf.selektujAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row=pf.getTblPoslovniPartner().getSelectedRow();
                if(row==-1){
                    JOptionPane.showMessageDialog(pf, "Selektujte red (ponistili ste selekciju)");
                    if(rf!=null){
                    rf.setPp(null);
                    rf.getLblPartner().setText("Partner nije izabran");
                       
                    }
                    
                }else{
                pf.getTxtId().setEditable(false);
                pf.getBtnIzmeni().setEnabled(true);
                pf.getTxtId().setText(String.valueOf(pf.getTblPoslovniPartner().getValueAt(row, 0)));
                pf.getTxtIme().setText((String) pf.getTblPoslovniPartner().getValueAt(row, 1));
                pf.getTxtPrezime().setText((String) pf.getTblPoslovniPartner().getValueAt(row, 2));
                pf.setIzabranoMesto((Mesto) pf.getTblPoslovniPartner().getValueAt(row, 4));
                pf.getLblMesto().setText("Mesto sa nazivom "+ pf.getIzabranoMesto().getNaziv()+" je izabrano" );
                if(rf!=null){
                rf.setPp(new PoslovniPartner((int) pf.getTblPoslovniPartner().getValueAt(row, 0), (String) pf.getTblPoslovniPartner().getValueAt(row, 1), (String) pf.getTblPoslovniPartner().getValueAt(row, 2), (Mesto) pf.getTblPoslovniPartner().getValueAt(row, 4)));
                rf.getLblPartner().setText("Partner sa imenom "+ pf.getTblPoslovniPartner().getValueAt(row, 1)+" "+pf.getTblPoslovniPartner().getValueAt(row, 2) + " je izabran");
                
                }
                JOptionPane.showMessageDialog(pf,"Sistem je nasao poslovnog partnera");
                }
            }
        });
    }
                
                private void addIzadjiActionListener() {
        pf.izadjiAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
                pf.dispose();
                
              
            }
        });
    }
    
    public void otvoriPoslovniPartnerForma(){
        pf.setVisible(true);
    }

    private void vratiListuPoslovniPartner() {
         List<PoslovniPartner> partneri=new ArrayList<>();
         partneri=Komunikacija.getInstance().vratiListuPoslovniPartner();
         pf.setPartneri(partneri);
    }

    
    

}
