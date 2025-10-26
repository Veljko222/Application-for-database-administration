/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacije;

/**
 *
 * @author User
 */
public class Operacije {
     public static final int Login=1;
     public static final int KreirajMesto=2;
     public static final int PretraziMesto=3;
     public static final int PromeniMesto=4;
     public static final int ObrisiMesto=5;
     public static final int VratiListuMesta=6;
     
      public static final int KreirajTrotinet=7;
     public static final int PretraziTrotinet=8;
     public static final int PromeniTrotinet=9;
     public static final int ObrisiTrotinet=10;
     public static final int VratiListuTrotineta=11;
     
     public static final int KreirajZaposleni = 12;
    public static final int PretraziZaposleni = 13;
    public static final int PromeniZaposleni = 14;
    public static final int ObrisiZaposleni = 15;
    public static final int VratiListuZaposlenih = 16;
    
      public static final int KreirajTerminD = 17;
    public static final int PretraziTerminD = 18;
    public static final int PromeniTerminD = 19;
    public static final int ObrisiTerminD = 20;
    public static final int VratiListuTerminaD = 21;
    
    public static final int KreirajPoslovniPartner = 22;
    public static final int PretraziPoslovniPartner = 23;
    public static final int PromeniPoslovniPartner = 24;
    public static final int ObrisiPoslovniPartner = 25;
    public static final int VratiListuPoslovniPartner = 26;
    
    public static final int KreirajIznajmljivanje = 27;
    public static final int PretraziIznajmljivanje = 28;
    public static final int PromeniIznajmljivanje = 29;
    public static final int ObrisiIznajmljivanje = 30;
    public static final int VratiListuIznajmljivanje = 31;
    
    public static final int KreirajStavkeIznajmljivanja = 32;
    public static final int ObrisiStavkeIznajmljivanja = 33;
    public static final int VratiListuStavkeIznajmljivanja = 34;
    public static final int PromeniStavkuIznajmljivanja=35;
     
     public static String getNazivOperacije(int code) {
        return switch (code) {
            case Login -> "Login";
            case KreirajMesto -> "KreirajMesto";
            case PretraziMesto -> "PretraziMesto";
            case PromeniMesto -> "PromeniMesto";
            case ObrisiMesto -> "ObrisiMesto";
            case VratiListuMesta -> "VratiListuMesta";
                
            case KreirajTrotinet -> "KreirajTrotinet";
            case PretraziTrotinet -> "PretraziTrotinet";
            case PromeniTrotinet -> "PromeniTrotinet";
            case ObrisiTrotinet -> "ObrisiTrotinet";
            case VratiListuTrotineta -> "VratiListuTrotineta";
                
            case KreirajZaposleni -> "KreirajZaposleni";
            case PretraziZaposleni -> "PretraziZaposleni";
            case PromeniZaposleni -> "PromeniZaposleni";
            case ObrisiZaposleni -> "ObrisiZaposleni";
            case VratiListuZaposlenih -> "VratiListuZaposlenih";
                
            case KreirajTerminD -> "KreirajTerminD";
            case PretraziTerminD -> "PretraziTerminD";
            case PromeniTerminD -> "PromeniTerminD";
            case ObrisiTerminD -> "ObrisiTerminD";
            case VratiListuTerminaD -> "VratiListuTerminaD";
                
            case KreirajPoslovniPartner -> "KreirajPoslovniPartner";
            case PretraziPoslovniPartner -> "PretraziPoslovniPartner";
            case PromeniPoslovniPartner -> "PromeniPoslovniPartner";
            case ObrisiPoslovniPartner -> "ObrisiPoslovniPartner";
            case VratiListuPoslovniPartner -> "VratiListuPoslovniPartner";
                
            case KreirajIznajmljivanje -> "KreirajIznajmljivanje";
            case PretraziIznajmljivanje -> "PretraziIznajmljivanje";
            case PromeniIznajmljivanje -> "PromeniIznajmljivanje";
            case ObrisiIznajmljivanje -> "ObrisiIznajmljivanje";
            case VratiListuIznajmljivanje -> "VratiListuIznajmljivanja";
            case KreirajStavkeIznajmljivanja -> "KreirajStavkeIznajmljivanja";
            case ObrisiStavkeIznajmljivanja -> "ObrisiStavkeIznajmljivanja";
            case  PromeniStavkuIznajmljivanja -> "PromeniStavkuIznajmljivanja";   
            case VratiListuStavkeIznajmljivanja-> "VratiListuStavkeIznajmljivanja";
            default -> "Nepoznata operacija"; // Unknown operation
                
        };
     }
}
