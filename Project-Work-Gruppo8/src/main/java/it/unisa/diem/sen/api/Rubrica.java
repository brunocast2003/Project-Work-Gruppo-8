/**
 * @file Rubrica.java
 * 
 * @brief Questo file contiene l'implementazione della classe Rubrica
 * 
 * Tale file permette di istanziare oggetti di tipo rubrica, essenziali per il progetto
 * 
 * @author Bruno Castellano
 * 
 * @date December 02, 2024
 * 
 * @version 1.0
 * 
 */

package it.unisa.diem.sen.api;

import java.util.ArrayList;
import java.util.List;

/**
     * @brief La lista di contatti 
     * 
     * Questa classe viene usata per ospitare tutti i contatti in una lista ordinata per cognome e nome.
     *
*/
public class Rubrica<Contatto> {
    
    private String nome;    ///< Il nome dell'intera rubrica.
    private List<Contatto> contatti;    ///< La lista di contatti gestita dalla rubrica.
    
    
    /**
     * @brief Crea un oggetto di tipo rubrica
     * 
     * Questo metodo crea un oggetto Rubrica con un nome dato in input ed inizializza una lista di contatti
     * 
     * @pre Rubrica inesistente
     * @post La rubrica è stata generata correttamente
     * 
     * @param[in] nome Il nome da assegnare alla rubrica.
    */
    public Rubrica(String nome){
        
    }
    
    /**
     * @brief Aggiunge un contatto alla rubrica
     * Aggiunge un Contatto alla lista 
     * @pre Nessuna
     * @post Contatto generato ed aggiunto alla rubrica correttamente
     * j
     * @param[in] nome Il nome da assegnare alla rubrica.
    */
    public void aggiungiContatto(Contatto c){
    }
    
    public void rimuoviContatto(Contatto c){
    } 
    
}
