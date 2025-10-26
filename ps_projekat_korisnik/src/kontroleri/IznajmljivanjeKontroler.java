/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import forme.IznajmljivanjeForma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import klijent.Komunikacija;
import kordinator.Kordinator;
import modeli.Mesto;
import modeli.Iznajmljivanje;
import modeli.PoslovniPartner;
import modeli.Zaposleni;

/**
 *
 * @author User
 */
public class IznajmljivanjeKontroler {
     private final IznajmljivanjeForma rf;
     private int idIznajmljivanja=0;   
     private Zaposleni izabraniZaposleni;
     private PoslovniPartner izabraniPartner;
     private int cena;
     private Iznajmljivanje iznajmljivanje;

    public Iznajmljivanje getIznajmljivanje() {
        return iznajmljivanje;
    }
     
     
    public IznajmljivanjeForma getIzForm() {
        return rf;
    }
     
     

    public IznajmljivanjeKontroler(IznajmljivanjeForma mf) {
        this.rf = mf;
        vratiListuIznajmljivanje();
        mf.popuniTblIznajmljivanje();
        addKreirajActionListener();

        addSelectujActionListener();
        addIzadjiActionListener();
        addPretraziActionListener();
        addPromeniActionListener();
        addStavkePActionListener();
        addIzaberiZActionListener();
        addIzaberiPActionListener();
    }

    private void addKreirajActionListener() {
        rf.kreirajAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                
                
                 iznajmljivanje= new Iznajmljivanje(0, rf.getZaposleni(), rf.getPp(), 0);
                
                Boolean uspeh=Komunikacija.getInstance().kreirajIznajmljivanje(iznajmljivanje);
                
                if(uspeh == false)
                    JOptionPane.showMessageDialog(rf, "Sistem ne može da zapamti iznajmljivanje");
                else{
                    vratiListuIznajmljivanje();
                    rf.popuniTblIznajmljivanje(); 
                    JOptionPane.showMessageDialog(rf, "Sistem je zapamtio iznajmljivanje");
                    
                
                    
                    
                }
            }
        });
    }
    
    private void addPromeniActionListener() {
        rf.promeniAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                Iznajmljivanje iznajmljivanje= new Iznajmljivanje();
                if(!(rf.getTxtId().getText().isEmpty()) && rf.getZaposleni()!=null && rf.getPp()!=null){
               iznajmljivanje.setZaposleni(rf.getZaposleni());
                iznajmljivanje.setPartner(rf.getPp());
                iznajmljivanje.setIdIznajmljivanja(idIznajmljivanja);
                }else{
                    JOptionPane.showMessageDialog(rf, "Sistem nije mogao da zapamti iznajmljivanje");
                    return;
                }
                
                Boolean uspeh=Komunikacija.getInstance().promeniIznajmljivanje(iznajmljivanje);
                
                if(uspeh == false)
                    JOptionPane.showMessageDialog(rf, "Sistem nije mogao da zapamti iznajmljivanje");
                else{
                    vratiListuIznajmljivanje();
                    rf.popuniTblIznajmljivanje();
                    rf.getTxtId().setEditable(true);
                    rf.getBtnIzmeni().setEnabled(false);
                    JOptionPane.showMessageDialog(rf, "Sistem je zapamtio iznajmljivanja");
                }
            }
        });
    } 
      
        

                
                private void addPretraziActionListener() {
        rf.pretraziAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                Iznajmljivanje iznajmljivanje= new Iznajmljivanje();
                
                if(!(rf.getTxtId().getText().isEmpty()))
                    try{
                    iznajmljivanje.setIdIznajmljivanja(Integer.valueOf(rf.getTxtId().getText()));
                    }catch(NumberFormatException ex){
                        JOptionPane.showMessageDialog(rf, "Id mora biti broj");
                    }
              
                if(rf.getPp()!=null)    
                    iznajmljivanje.setPartner(rf.getPp());
                
                if(rf.getZaposleni()!=null)
                    iznajmljivanje.setZaposleni(rf.getZaposleni());
                
                
                List<Iznajmljivanje> Iznajmljivanja=Komunikacija.getInstance().pretraziIznajmljivanje(iznajmljivanje);
                
                    rf.setIznajmljivanja(Iznajmljivanja);
                    rf.popuniTblIznajmljivanje();
                    if(Iznajmljivanja.size()!=0)
                    JOptionPane.showMessageDialog(rf, "Sistem je nasao iznajmljivanjа po zadatim kriterijumima");
                    else
                        JOptionPane.showMessageDialog(rf, "Sistem ne moze da nadje iznajmljivanjа po zadatim kriterijumima");

                }
                
            
        });
    }
                
                private void addIzaberiZActionListener() {
        rf.izaberiZAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Kordinator.getInstance().otvoriPretraziZaposleniFormu(rf);
                
            }
            });
            }
                private void addIzaberiPActionListener() {
        rf.izaberiPAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Kordinator.getInstance().otvoriPretraziPoslovniPartnerFormu(rf);
                
            }
            });
            }
                
                private void addSelectujActionListener() {
        rf.selektujAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row=rf.getTblIznajmljivanje().getSelectedRow();
                if(row==-1){
                    JOptionPane.showMessageDialog(rf, "Selektujte red");
                }
                rf.getTxtId().setEditable(false);
                rf.getBtnIzmeni().setEnabled(true);
               
                idIznajmljivanja= (int) rf.getTblIznajmljivanje().getValueAt(row, 0);
                System.out.println(idIznajmljivanja);
                rf.getTxtId().setText(idIznajmljivanja+"");
                
                izabraniZaposleni=(Zaposleni) rf.getTblIznajmljivanje().getValueAt(row, 4);
                izabraniPartner=(PoslovniPartner) rf.getTblIznajmljivanje().getValueAt(row, 5);
                iznajmljivanje= new Iznajmljivanje(idIznajmljivanja, izabraniZaposleni, izabraniPartner, 0);
                rf.setZaposleni(izabraniZaposleni);
                rf.setPp(izabraniPartner);
                rf.getLblZaposleni().setText("Zaposleni sa imenom "+ izabraniZaposleni.getIme()+" "+ izabraniZaposleni.getPrezime()+" je izabran" );
                rf.getLblPartner().setText("Poslovni partner sa imenom "+ izabraniPartner.getIme()+" "+ izabraniPartner.getPrezime()+" je izabran" ); 
                JOptionPane.showMessageDialog(rf, "Sistem je nasao iznajmljivanje");
            }
        });
    }
                
                private void addIzadjiActionListener() {
        rf.izadjiAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rf.dispose();
                
              
            }
        });
    }
                
                
                private void addStavkePActionListener() {
        rf.stavkePAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(idIznajmljivanja==0)
                    JOptionPane.showMessageDialog(rf, "Niste selektovali iznajmljivanje");
                else
                Kordinator.getInstance().otvoriKreirajStavkeIznajmljivanjaFormu(iznajmljivanje, Kordinator.getInstance().getiKont());
                
                        
                    
                
              
            }
        });
    }
    
    public void otvoriIznajmljivanjeForma(){
        rf.setVisible(true);
    }

    public void vratiListuIznajmljivanje() {
         List<Iznajmljivanje> Iznajmljivanja=new ArrayList<>();
         Iznajmljivanja=Komunikacija.getInstance().vratiListuIznajmljivanje();
         rf.setIznajmljivanja(Iznajmljivanja);
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }
    
    

    
    
}
