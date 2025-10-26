/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import forme.GlavnaForma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import kordinator.Kordinator;
import modeli.Zaposleni;

/**
 *
 * @author User
 */
public class GlavnaFormaKontroler {
        private final GlavnaForma gf;

    public GlavnaFormaKontroler(GlavnaForma gf) {
        this.gf = gf;
        addKreirajMestoActionListener();
       
        addPretraziMestoActionListener();
        addKreirajTrotinetActionListener();
   
        addPretraziTrotinetActionListener();
        addKreirajZaposleniActionListener();
     
        addPretraziZaposleniActionListener();
        addKreirajTerminActionListener();
     
        addPretraziTerminActionListener();
        addPretraziPoslovniPartnerActionListener();
        addKreirajPoslovniPartnerActionListener();
        
        addKreirajIznajmljivanjeActionListener();
        addPretraziIznajmljivanjePartnerActionListener();
    }

    public void otvoriFormu() {
        Zaposleni zaposleni= Kordinator.getInstance().getUlogovani();
        gf.getLblPozdrav().setText("Pozdrav "+ zaposleni.getIme()+ " "+ zaposleni.getPrezime() );
    gf.setVisible(true);
    }
    
     private void addKreirajMestoActionListener() {
        gf.kreirajMestoAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               Kordinator.getInstance().otvoriKreirajMestoFormu();
            }
            
        });
        
                
}
      
            
            private void addPretraziMestoActionListener() {
        gf.pretraziMestoAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               Kordinator.getInstance().otvoriPretraziMestoFormu(null);
            }
            
        });
        }
            
            private void addKreirajTrotinetActionListener() {
        gf.kreirajTrotinetAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               Kordinator.getInstance().otvoriKreirajTrotinetFormu();
            }
            
        });
        }

            
            private void addPretraziTrotinetActionListener() {
        gf.pretraziTrotinetAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               Kordinator.getInstance().otvoriPretraziTrotinetFormu(null);
            }
            
        });
        }
            
            private void addKreirajZaposleniActionListener() {
        gf.kreirajZaposleniAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               Kordinator.getInstance().otvoriKreirajZaposleniFormu();
            }
            
        });
        }
      
            
            private void addPretraziZaposleniActionListener() {
        gf.pretraziZaposleniAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               Kordinator.getInstance().otvoriPretraziZaposleniFormu(null);
            }
            
        });
        }
            
            private void addKreirajTerminActionListener() {
        gf.kreirajTerminAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               Kordinator.getInstance().otvoriKreirajTerminFormu();
            }
            
        });
        }
      
            
            private void addPretraziTerminActionListener() {
        gf.pretraziTerminAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               Kordinator.getInstance().otvoriPretraziTerminFormu();
            }
            
        });
        }
            
        private void addKreirajPoslovniPartnerActionListener() {
        gf.kreirajPoslovniPartnerAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               Kordinator.getInstance().otvoriKreirajPoslovniPartnerFormu();
            }
            
        });
        }
      
            
            private void addPretraziPoslovniPartnerActionListener() {
        gf.pretraziPoslovniPartnerAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               Kordinator.getInstance().otvoriPretraziPoslovniPartnerFormu(null);
            }
            
        });
        }
            
            private void addKreirajIznajmljivanjeActionListener() {
        gf.kreirajIznajmljivanjeAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               Kordinator.getInstance().otvoriKreirajIznajmljivanjeFormu();
            }
            
        });
        }
      
            
            private void addPretraziIznajmljivanjePartnerActionListener() {
        gf.pretraziIznajmljivanjeAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               Kordinator.getInstance().otvoriPrikaziIznajmljivanjeFormu();
            }
            
        });
        }
}