/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author User
 */
public class PokreniServer extends Thread {

   private boolean kraj;
   ServerSocket serverskiSocket;
       
   @Override
   public void run(){
        try {
             serverskiSocket= new ServerSocket(9000);
             kraj=false;
             
            System.out.println("Server pokrenut");
            while(!kraj){
                Socket s = null;
                try {
                    s = serverskiSocket.accept();
                    System.out.println("Klijent povezan");
                } catch (IOException e) {
                    System.out.println("Neuspesno povezivanje, soket je zauzet "+ e.getMessage());
                }
                ObradaKlijentskihZahteva nit=new ObradaKlijentskihZahteva(s);
                nit.start();
            }
        } catch (IOException ex) {
            System.out.println("Neuspesno pokretanje servera " + ex.getMessage());
        }
        

    }
   
   public void zaustaviServer(){
       kraj=true;
       try {
           serverskiSocket.close();
           System.out.println("zaustavljen");
           
       } catch (IOException ex) {
           System.out.println("Neuspesno zatvaranje servera");
       }
   }

    public boolean isKraj() {
        return kraj;
    }

    public void setKraj(boolean kraj) {
        this.kraj = kraj;
    }
   
   
}
    

