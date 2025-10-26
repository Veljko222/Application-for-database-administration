/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import forme.StavkeIznajmljivanjaForma;
import forme.TrotinetForma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import klijent.Komunikacija;
import modeli.Trotinet;

/**
 *
 * @author User
 */
public class TrotinetKontroler {
     private final TrotinetForma tf;
     private StavkeIznajmljivanjaForma rf =null;
     Trotinet izabraniTrotinet=null;

    public TrotinetKontroler( TrotinetForma tf , StavkeIznajmljivanjaForma rf) {
        this.tf = tf;
        this.rf=rf;
        vratiListuSvihTrotineta();
        tf.popuniTblTrotinet();
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
                int cena=0;
                String naziv=tf.getTxtNaziv().getText().trim();
                try {
                     cena = Integer.valueOf(tf.getTxtCena().getText().trim());
                } catch (NumberFormatException numberFormatException) {
                    JOptionPane.showMessageDialog(tf, "Morate uneti brojnu vrednost u polje 'Cena po satu'");
                    return;
                }
                Trotinet trotinet= new Trotinet();
                trotinet.setNaziv(naziv);
                trotinet.setCenaPoSatu(cena);
                Boolean uspeh=Komunikacija.getInstance().kreirajTrotinet(trotinet);
                
                if(uspeh == false)
                    JOptionPane.showMessageDialog(tf, "Neuspesan unos trotineta, proverite naziv i cenu");
                else{
                    vratiListuSvihTrotineta();
                    tf.popuniTblTrotinet(); 
                    JOptionPane.showMessageDialog(tf, "Uspesan unos trotineta");
                }
            }
        });
    }
    
        private void addObrisiActionListener() {
        tf.obrisiAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row=tf.getTblTrotinet().getSelectedRow();
                if(row==-1){
                    JOptionPane.showMessageDialog(tf, "Selektujte red");
                }
                Trotinet trotinet= new Trotinet();
                trotinet.setNaziv((String) tf.getTblTrotinet().getValueAt(row, 1));
                trotinet.setIdTrotineta((int) tf.getTblTrotinet().getValueAt(row, 0));
                Boolean uspeh=Komunikacija.getInstance().obrisiTrotinet(trotinet);
                
                if(uspeh == false)
                    JOptionPane.showMessageDialog(tf, "Neuspesno brisanje trotineta, proverite selekciju");
                else{
                    vratiListuSvihTrotineta();
                    tf.popuniTblTrotinet(); 
                    JOptionPane.showMessageDialog(tf, "Uspesno brisanje trotineta");
                }
            }
        });
    }
        
                private void addPromeniActionListener() {
        tf.promeniAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                Trotinet trotinet= new Trotinet();
                if(!(tf.getTxtId().getText().isEmpty()) && !(tf.getTxtNaziv().getText().isEmpty()) ){
                    
                    try {
                        trotinet.setIdTrotineta(Integer.valueOf(tf.getTxtId().getText()));
                        trotinet.setNaziv(tf.getTxtNaziv().getText());
                        trotinet.setCenaPoSatu(Integer.valueOf(tf.getTxtCena().getText()));
                    } catch (NumberFormatException numberFormatException) {
                        JOptionPane.showMessageDialog(tf, "Morate uneti brojnu vrednos vecu od nule u polje za cenu po satu");
                    }
                }else{
                    JOptionPane.showMessageDialog(tf, "Morate selektovati mesto i uneti odgovarajuce podatke");
                    return;
                }
                
                Boolean uspeh=Komunikacija.getInstance().promeniTrotinet(trotinet);
                
                if(uspeh == false)
                    JOptionPane.showMessageDialog(tf, "Neuspesno menjanje trotineta, proverite naziv trotineta i da li cena brojcana vrednos veca od nule");
                else{
                    vratiListuSvihTrotineta();
                    tf.popuniTblTrotinet();
                    tf.getTxtId().setEditable(true);
                tf.getBtnIzmeni().setEnabled(false);
                    JOptionPane.showMessageDialog(tf, "Uspesno menjanje trotineta");
                }
            }
        });
    }
                
                private void addPretraziActionListener() {
        tf.pretraziAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                Trotinet trotinet= new Trotinet();
                
                if(!(tf.getTxtId().getText().isEmpty()) )
                    try{
                    trotinet.setIdTrotineta(Integer.valueOf(tf.getTxtId().getText()));
                    }catch(NumberFormatException ex){
                        JOptionPane.showMessageDialog(tf, "Id mora biti broj");
                    }
                if(!(tf.getTxtNaziv().getText().isEmpty()))    
                    trotinet.setNaziv(tf.getTxtNaziv().getText());
                if(!(tf.getTxtCena().getText().isEmpty()))
                    try{
                    trotinet.setCenaPoSatu(Integer.valueOf(tf.getTxtCena().getText()));
                    }catch(NumberFormatException ex){
                        JOptionPane.showMessageDialog(tf, "Cena po satu mora biti broj");
                    }
                
                List<Trotinet> trotineti=Komunikacija.getInstance().pretraziTrotinet(trotinet);
                
                    tf.setTrotineti(trotineti);
                    tf.popuniTblTrotinet();
                }
                
            
        });
    }
                
                private void addSelectujActionListener() {
        tf.selektujAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row=tf.getTblTrotinet().getSelectedRow();
                if(row==-1){
                    JOptionPane.showMessageDialog(tf, "Selektujte red (ponistili ste selekciju)");
                    if(rf!=null){
                    izabraniTrotinet=null;
                    rf.setTrotinet(izabraniTrotinet);
                    rf.getLblTrotinet().setText("Trotinet nije izabran");
                    }
                }else{
                tf.getTxtId().setEditable(false);
                tf.getBtnIzmeni().setEnabled(true);
                tf.getTxtId().setText(String.valueOf(tf.getTblTrotinet().getValueAt(row, 0)));
                tf.getTxtNaziv().setText((String) tf.getTblTrotinet().getValueAt(row, 1));
                tf.getTxtCena().setText(String.valueOf(tf.getTblTrotinet().getValueAt(row, 2)));
                
                if(rf!=null){
                    izabraniTrotinet=new Trotinet((int) tf.getTblTrotinet().getValueAt(row, 0), String.valueOf( tf.getTblTrotinet().getValueAt(row, 1)),(int) tf.getTblTrotinet().getValueAt(row, 2));
                    rf.setTrotinet(izabraniTrotinet);
                    rf.getLblTrotinet().setText("Trotinet sa nazivom "+ izabraniTrotinet.getNaziv()+ " je izabran");
                    rf.getTxtCena().setText(""+ izabraniTrotinet.getCenaPoSatu());
                }
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
    
    public void otvoriTrotinetForma(){
        tf.setVisible(true);
    }

    private void vratiListuSvihTrotineta() {
         List<Trotinet> trotineti=new ArrayList<>();
         trotineti=Komunikacija.getInstance().vratiListuSvihTrotineta();
         tf.setTrotineti(trotineti);
    }
}
