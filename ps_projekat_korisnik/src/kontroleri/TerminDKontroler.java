/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import forme.TerminDForma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import klijent.Komunikacija;
import modeli.TerminDezurstva;

/**
 *
 * @author User
 */
public class TerminDKontroler {
    private final TerminDForma tf;

    public TerminDKontroler( TerminDForma tf) {
        this.tf = tf;
        vratiListuSvihTermina();
        tf.popuniTblTermin();
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
                
                
                
                   LocalTime pocetak = null;
                   LocalTime kraj = null;
                try {
                    pocetak = LocalTime.parse(tf.getTxtPocetak().getText().trim());
                     kraj = LocalTime.parse(tf.getTxtKraj().getText().trim());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(tf, "Satnica mora biti formata hh:mm(:ss) i pocetak mora biti pre kraja");
                }
             
                TerminDezurstva termin= new TerminDezurstva();
                termin.setPocetak(pocetak);
                termin.setKraj(kraj);
                termin.setTrajanje();
                Boolean uspeh=Komunikacija.getInstance().kreirajTerminDezurstva(termin);
                
                if(uspeh == false)
                    JOptionPane.showMessageDialog(tf, "Sistem ne moze da zapamti termin dezurstva");
                else{
                    vratiListuSvihTermina();
                    tf.popuniTblTermin(); 
                    JOptionPane.showMessageDialog(tf, "Sistem je zapamtio termin dezurstva");
                }
            }
        });
    }
    
        private void addObrisiActionListener() {
        tf.obrisiAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row=tf.getTblTermin().getSelectedRow();
                if(row==-1){
                    JOptionPane.showMessageDialog(tf, "Selektujte red");
                }
                TerminDezurstva termin= new TerminDezurstva();
                termin.setPocetak((LocalTime) tf.getTblTermin().getValueAt(row, 1));
                termin.setIdDezurstva((int) tf.getTblTermin().getValueAt(row, 0));
                termin.setKraj((LocalTime) tf.getTblTermin().getValueAt(row, 2));
                termin.setTrajanje();
                Boolean uspeh=Komunikacija.getInstance().obrisiTerminDezurstva(termin);
                
                if(uspeh == false)
                    JOptionPane.showMessageDialog(tf, "Neuspesno brisanje termina, proverite selekciju");
                else{
                    vratiListuSvihTermina();
                    tf.popuniTblTermin(); 
                    JOptionPane.showMessageDialog(tf, "Uspesno brisanje termina");
                }
            }
        });
    }
        
                private void addPromeniActionListener() {
        tf.promeniAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                TerminDezurstva termin= new TerminDezurstva();
                if(!(tf.getTxtId().getText().isEmpty()) && !(tf.getTxtPocetak().getText().isEmpty()) && !(tf.getTxtKraj().getText().isEmpty()) ){
                    
                    try {
                        termin.setIdDezurstva(Integer.valueOf(tf.getTxtId().getText()));
                        termin.setPocetak(LocalTime.parse(tf.getTxtPocetak().getText().trim()));
                        termin.setKraj(LocalTime.parse(tf.getTxtKraj().getText().trim()));
                        termin.setTrajanje();
                    } catch (NumberFormatException numberFormatException) {
                        JOptionPane.showMessageDialog(tf, "Morate uneti brojnu vrednos vecu od nule u polje za cenu po satu");
                    }
                }else{
                    JOptionPane.showMessageDialog(tf, "Morate selektovati mesto i uneti odgovarajuce podatke");
                    return;
                }
                
                Boolean uspeh=Komunikacija.getInstance().promeniTerminDezurstva(termin);
                
                if(uspeh == false)
                    JOptionPane.showMessageDialog(tf, "Neuspesno menjanje termina, proverite parametre");
                else{
                    vratiListuSvihTermina();
                    tf.popuniTblTermin(); 
                    tf.getBtnIzmeni().setEnabled(false);
                    tf.getTxtId().setEditable(true);
                tf.getBtnIzmeni().setEnabled(false);
                    JOptionPane.showMessageDialog(tf, "Uspesno menjanje termina");
                }
            }
        });
    }
                
                private void addPretraziActionListener() {
        tf.pretraziAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                TerminDezurstva termin= new TerminDezurstva();
                
                if(!(tf.getTxtId().getText().isEmpty()) )
                    try{
                    termin.setIdDezurstva(Integer.valueOf(tf.getTxtId().getText()));
                    }catch(NumberFormatException ex){
                        JOptionPane.showMessageDialog(tf, "Id mora biti broj");
                    }
                if(!(tf.getTxtPocetak().getText().isEmpty())) 
                    try{
                    termin.setPocetak(LocalTime.parse(tf.getTxtPocetak().getText().trim()));
                    }catch(Exception ex){
                        JOptionPane.showMessageDialog(tf, "Proverite format satnice");
                    }
                if(!(tf.getTxtKraj().getText().isEmpty()))
                    try{
                    termin.setKraj(LocalTime.parse(tf.getTxtKraj().getText().trim()));
                    }catch(Exception ex){
                        JOptionPane.showMessageDialog(tf, "Proverite format satnice");
                    }
                if(!(tf.getTxtTrajanje().getText().isEmpty()))
                    try{
                   termin.setTrajanjeRucno(Integer.parseInt(tf.getTxtTrajanje().getText()));
                    }catch(NumberFormatException ex){
                        JOptionPane.showMessageDialog(tf, "Trajanje mora biti broj");
                    }
                
                List<TerminDezurstva> termini=Komunikacija.getInstance().pretraziTerminDezurstva(termin);
                
                    tf.setTermini(termini);
                    tf.popuniTblTermin();
                }
                
            
        });
    }
                
                private void addSelectujActionListener() {
        tf.selektujAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row=tf.getTblTermin().getSelectedRow();
                if(row==-1){
                    JOptionPane.showMessageDialog(tf, "Selektujte red");
                }
                tf.getTxtId().setEditable(false);
                tf.getBtnIzmeni().setEnabled(true);
                tf.getTxtId().setText(String.valueOf(tf.getTblTermin().getValueAt(row, 0)));
                tf.getTxtPocetak().setText(String.valueOf( tf.getTblTermin().getValueAt(row, 1)));
                tf.getTxtKraj().setText(String.valueOf(tf.getTblTermin().getValueAt(row, 2)));
                tf.getTxtTrajanje().setText(String.valueOf(tf.getTblTermin().getValueAt(row, 3)));
              
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
    
    public void otvoriTerminDForma(){
        tf.setVisible(true);
    }

    private void vratiListuSvihTermina() {
        
         List<TerminDezurstva> termini=new ArrayList<>();
         termini=Komunikacija.getInstance().vratiListuSvihTermina();
         tf.setTermini(termini);
    }
}
