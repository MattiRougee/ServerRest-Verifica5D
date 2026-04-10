/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serverrest;

/**
 *
 * @author delfo
 */
public class RouletteRequest {
    
    private String giocata;
    private String numero;
    
    // Costruttore vuoto necessario per GSON
    public RouletteRequest() {
    }
    
    public RouletteRequest(String giocata, String numero) {
        this.giocata = giocata;
        this.numero = numero;
    }

    public String getGiocata() {
        return giocata;
    }

    public void setGiocata(String giocata) {
        this.giocata = giocata;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "RouletteRequest{" + "giocata=" + giocata + ", numero=" + numero + '}';
    }

    
}