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

import java.util.List;
import javafx.collections.ObservableList;

/**
     * @brief La lista di contatti 
     * 
     * Questa classe viene usata per ospitare tutti i contatti in una lista ordinata per cognome e nome.
     *
*/
public class Rubrica<Contatto> implements FileIO{
    
    private ObservableList<Contatto> contatti;    ///< La lista di contatti gestita dalla rubrica.
    
    
    /**
     * @brief Crea un oggetto di tipo rubrica
     * 
     * Questo metodo crea un oggetto Rubrica con un nome dato in input ed inizializza una lista di contatti
     * 
     * @pre Rubrica inesistente
     * @post La rubrica è stata generata correttamente
     * 
     * 
    */
    public Rubrica(){
        
    }
    
    /**
     * @brief Aggiunge un contatto alla rubrica
     * Aggiunge un Contatto alla lista 
     * @pre Nessuna
     * @post Contatto generato ed aggiunto alla rubrica correttamente
     * j
     * @param[in] nome Il nome da assegnare alla rubrica.
    */
    public void aggiungiContatto(Contatto contatto){
    }
    
    public void rimuoviContatto(Contatto contatto){
    } 
    
    public void modificaContatto(Contatto contatto){
        
    }
    
    public List<Contatto> cercaContatto(String cerca) {
        return null;
    }
    
    public void ordinaRubrica() {
        
    }

    @Override
    public Rubrica caricaRubrica(String nomefile) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void salvaRubrica(String nomefile) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
