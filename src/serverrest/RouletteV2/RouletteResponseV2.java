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
public class RouletteResponseV2 {
    
    private String giocata;
    private Integer numero;
    private String vittoria; 
    
    public RouletteResponseV2() {
    }

    public RouletteResponseV2(String giocata, Integer numero, String vittoria) {
        this.giocata = giocata;
        this.numero = numero;
        this.vittoria = vittoria;
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

    public String getVittoria() {
        return vittoria;
    }

    public void setVittoria(String vittoria) {
        this.vittoria = vittoria;
    }



}


