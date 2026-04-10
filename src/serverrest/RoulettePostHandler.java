/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package serverrest;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;



/**
 *
 * @author delfo
 */


public class RoulettePostHandler implements HttpHandler {
    
    // Istanza Gson configurata per pretty printing
    private final Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();
    
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        
        // Verifica che sia una richiesta POST
        if (!exchange.getRequestMethod().equalsIgnoreCase("POST")) {
            inviaErrore(exchange, 405, "Metodo non consentito. Usa POST");
            return;
        }
        
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(exchange.getRequestBody(), StandardCharsets.UTF_8))) {
            
            RouletteRequest request = gson.fromJson(reader, RouletteRequest.class);
            
            if (request == null || !isValid(request)) {
                inviaErrore(exchange, 400, "Parametri mancanti: 'giocata' e 'numero' sono obbligatori");
                return;
            }
            
            // Conversione del numero da String a Integer prima del calcolo
            int numInt = Integer.parseInt(request.getNumero());
            boolean esito = RouletteService.logicaDiCalcolo(request.getGiocata(), numInt);
            
            RouletteResponse response = new RouletteResponse(request.getGiocata(), numInt, String.valueOf(esito));
            inviaRisposta(exchange, 200, gson.toJson(response));
            
        } catch (JsonSyntaxException | NumberFormatException e) {
            inviaErrore(exchange, 400, "Formato dati non valido: " + e.getMessage());
        } catch (Exception e) {
            inviaErrore(exchange, 500, "Errore interno: " + e.getMessage());
        }
    }
    
    // Validazione dei parametri (da implementare)
    private boolean isValid(RouletteRequest request) {
        return request.getGiocata() != null && request.getNumero() != null;
    }

    /**
     * Invia una risposta di successo
     */
    private void inviaRisposta(HttpExchange exchange, int codice, String jsonRisposta) 
            throws IOException {
        
        exchange.getResponseHeaders().set("Content-Type", "application/json; charset=UTF-8");
        exchange.getResponseHeaders().set("Access-Control-Allow-Origin", "*");
        
        byte[] bytes = jsonRisposta.getBytes(StandardCharsets.UTF_8);
        exchange.sendResponseHeaders(codice, bytes.length);
        
        OutputStream os = exchange.getResponseBody();
        os.write(bytes);
        os.close();
    }
    
    /**
     * Invia una risposta di errore in formato JSON
     */
    private void inviaErrore(HttpExchange exchange, int codice, String messaggio) 
            throws IOException {
        
        Map errore = new HashMap<>();
        errore.put("errore", messaggio);
        errore.put("status", codice);
        
        String jsonErrore = gson.toJson(errore);
        inviaRisposta(exchange, codice, jsonErrore);
    }
}
