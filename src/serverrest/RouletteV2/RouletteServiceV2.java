/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serverrest.RouletteV2;

import serverrest.*;

/**
 * Servizio contenente la logica di business della Roulette
 * * @author delfo
 */
public class RouletteServiceV2 {
    
    /**
     * Esegue la logica di calcolo per determinare la vittoria
     * * @param giocata la stringa puntata ("PARI" o "DISPARI")
     * @param numero il numero estratto dalla roulette (0-36)
     * @return true se il giocatore ha vinto, false se ha perso
     * @throws IllegalArgumentException se i parametri non sono validi
     */
    public static boolean logicaDiCalcolo(String giocata, Integer numero) 
            throws IllegalArgumentException {
        
        // Controllo se i parametri passati sono validi
        if (!parametriValidi(giocata, numero)) {
            throw new IllegalArgumentException(
                "Parametri non validi. La giocata deve essere PARI o DISPARI e il numero compreso tra 0 e 36.");
        }
        
        if (numero == 0) {
            return false;
        }
        
        boolean isPari = (numero % 2 == 0);
        
        if (giocata.equals("PARI")) {
            return isPari;       
        } else {
            return !isPari;
        }
    }

    /**
     * Metodo di validazione dei parametri in ingresso
     */
    private static boolean parametriValidi(String giocata, Integer numero) {
        if (giocata == null || numero == null) {
            return false;
        }
        
        if (!giocata.equals("PARI") && !giocata.equals("DISPARI")) {
            return false;
        }
        if (numero < 0 || numero > 36) {
            return false;
        }
        
        return true; 
    }
}