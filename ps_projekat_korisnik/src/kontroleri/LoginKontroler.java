/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import forme.LoginForma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import klijent.Komunikacija;
import kordinator.Kordinator;
import modeli.Zaposleni;

/**
 *
 * @author User
 */
public class LoginKontroler {
    private final LoginForma lf;

    public LoginKontroler(LoginForma lf) {
        this.lf = lf;
        addActionListener();
    }

    private void addActionListener() {
        lf.loginAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String mail =lf.getTxtEmail().getText().trim();
                
                String pass = String.valueOf(lf.getPtxtPass().getPassword()) ;
                
                Zaposleni ulogovani =Komunikacija.getInstance().login(mail,pass) ;
                if(ulogovani== null){
                    JOptionPane.showMessageDialog(lf, "Korisničko ime i šifra nisu isparvni");
                }else{
                    JOptionPane.showMessageDialog(lf, "Korisničko ime i šifra su isparvni");
                    Kordinator.getInstance().setUlogovani(ulogovani);
                    Kordinator.getInstance().otvoriGlavnuFormu();
                    
                    lf.dispose();
                }
            }
        });
    }

    public void otvoriFormu() {
            lf.setVisible(true);
    }
    
    
}
