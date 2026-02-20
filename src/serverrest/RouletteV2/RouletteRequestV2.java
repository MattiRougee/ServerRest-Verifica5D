/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serverrest.RouletteV2;

import serverrest.*;

/**
 *
 * @author delfo
 */
public class RouletteRequestV2 {
private String giocata;
    private Integer numero;
    private Float importo;
    
    // Costruttore vuoto necessario per GSON
    public RouletteRequestV2() {
    }
    
    public RouletteRequestV2(String giocata, Integer numero) {
        this.giocata = giocata;
        this.numero = numero;
    }

    public String getGiocata() {
        return giocata;
    }

    public void setGiocata(String giocata) {
        this.giocata = giocata;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Float getImporto() {
        return importo;
    }

    public void setImporto(Float importo) {
        this.importo = importo;
    }

}
