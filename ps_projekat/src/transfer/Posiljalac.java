/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transfer;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class Posiljalac {
    private Socket s;

    public Posiljalac(Socket s) {
        this.s = s;
    }
    
   public void posalji(Object so) {
         
        try {
            ObjectOutputStream oos;
      
            oos = new ObjectOutputStream(s.getOutputStream());
       
            oos.writeObject(so);
            oos.flush(); 
        } catch (IOException ex) {
            Logger.getLogger(Posiljalac.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
