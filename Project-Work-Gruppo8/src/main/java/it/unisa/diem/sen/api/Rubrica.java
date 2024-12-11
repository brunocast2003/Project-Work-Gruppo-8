/**
 * @file Rubrica.java
 * 
 * @brief Questo file contiene l'implementazione della classe Rubrica
 * 
 * Tale file permette di istanziare oggetti di tipo rubrica, essenziali per il progetto
 * 
 * @author Castellano Bruno
 * @author Grieco Giovanni
 * @author Giachetta Corradomaria
 * @author Di Carluccio Alesssandro
 * 
 * @date December 02, 2024
 * 
 * 
 */

package it.unisa.diem.sen.api;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
     * @brief La lista di contatti 
     * 
    * Questa classe permette di gestire una lista di contatti, offrendo funzionalità  
 * per aggiungere, rimuovere, modificare e cercare contatti, oltre a caricare e salvare la rubrica.
 * Implementa l'interfaccia `FileIO` per gestire l'importazione e l'esportazione da e verso file.
 * 
 * @tparam Contatto Il tipo di elemento gestito dalla rubrica.
 * 
 * @see FileIO

*/
public class Rubrica implements FileIO{
    
    private ObservableList<Contatto> contatti;    ///< La lista di contatti gestita dalla rubrica.
    
    /**
     * @brief Crea un oggetto di tipo rubrica
     * 
     * Questo metodo crea un oggetto Rubrica e inizializza una lista di contatti
     * Inizializza una nuova rubrica vuota. 
     * @pre Rubrica inesistente
     *
     * @post Una nuova istanza di `Rubrica` è creata con una lista vuota di contatti.

     * 
     * 
    */
    public Rubrica(){
        contatti = FXCollections.observableArrayList();
    }
    
    /**
     * @brief Aggiunge un contatto alla rubrica
     * Aggiunge un Contatto alla lista 
     * 
     * @pre contatto non nullo
     * 
     * @post Contatto generato ed aggiunto alla rubrica correttamente
     * 
     *  @param contatto Il contatto da aggiungere alla rubrica.
    */
    public void aggiungiContatto(Contatto contatto){
        this.contatti.add(contatto);
    }
    
    /**
     * @brief Rimuove un contatto dalla rubrica.
     * 
     * @param contatto Il contatto da rimuovere dalla rubrica.
     * 
     * @pre contatto != null
     * @post Il contatto specificato è rimosso dalla lista dei contatti, se esiste.
     */
    public void rimuoviContatto(Contatto contatto){
        this.contatti.remove(contatto);
    } 
    
    /**
     * @brief Modifica un contatto nella rubrica.
     * 
     * @param contatto Il contatto da modificare nella rubrica.
     * 
     * @pre contatto != null
     * @post Il contatto specificato è aggiornato nella lista dei contatti.
     */
    public void modificaContatto(Contatto contatto){
       for(Contatto c : contatti) {
           if(c == contatto){
               c.setNome(contatto.getNome());
               c.setCognome(contatto.getCognome());
               c.setNumTelefono(contatto.getNumTelefono());
               c.setEmail(contatto.getEmail());
           }
       }
    }
    
    /**
     * @brief Cerca contatti nella rubrica.
     * 
     * @param cerca La stringa di ricerca da utilizzare.
     * @return Una lista di contatti che corrispondono ai criteri di ricerca.
     * 
     * @pre cerca != null
     * @post Restituisce una lista di contatti che soddisfano i criteri di ricerca.
     */
    public ObservableList<Contatto> cercaContatto(String cerca) {
        ObservableList<Contatto> result = FXCollections.observableArrayList();

        for (Contatto contatto : contatti) {
            if (contatto.getNome().toLowerCase().contains(cerca.toLowerCase()) || contatto.getCognome().toLowerCase().contains(cerca.toLowerCase())) {
                result.add(contatto);
            }
        }
        return result;
    }
    
    /**
     * @brief Ordina la rubrica in base ai contatti.
     * 
     * Ordina i contatti in ordine alfabetico per cognome, e successivamente per nome.
     * 
     * @pre Nessuna
     * @post I contatti nella rubrica sono ordinati.
     */
    public void ordinaRubrica() {
        FXCollections.sort(contatti);
    }
    
    /**
     * @brief Ritorna la lista di contatti
     *
     * @return contatti
     */
    public List<Contatto> getTuttiContatti() {
        return this.contatti;
    }
    
    /**
     * @brief Carica una rubrica da file.
     * 
     * @param nomefile Il nome del file da cui caricare la rubrica.
     * @return Un'istanza di `Rubrica` caricata dal file.
     * 
     * @pre nomefile != null
     * @post Restituisce una rubrica caricata con i contatti presenti nel file.
     */
    @Override
    public Rubrica caricaRubrica(String nomefile) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * @brief Salva la rubrica su file.
     * 
     * @param nomefile Il nome del file in cui salvare la rubrica.
     * 
     * @pre nomefile != null
     * @post La rubrica è salvata nel file specificato.
     */
    @Override
    public void salvaRubrica(String nomefile) throws IOException {
        try(PrintWriter pw = new PrintWriter( new BufferedWriter( new FileWriter(nomefile))) ) {
           pw.println("NOME;COGNOME;NUMERO DI TELEFONO 1;NUMERO DI TELEFONO 2;NUMERO DI TELEFONO 3;EMAIL 1;EMAIL 2;EMAIL3");
           
           for(Contatto c : contatti) {
               pw.print(c.getNome());
               pw.print(";");
               pw.print(c.getCognome());
               pw.print(";");
               for(String t : c.getNumTelefono()) {
                   pw.print(t);
                   pw.print(";");
               }
               for(String e : c.getEmail()) {
                   pw.print(e);
                   pw.print(";");
               }
               pw.append("\n");
           }
        }
    }
}
