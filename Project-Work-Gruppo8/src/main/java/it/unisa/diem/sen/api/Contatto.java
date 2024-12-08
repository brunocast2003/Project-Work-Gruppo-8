/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.sen.api;

import java.util.List;

/**
 * @brief Classe che rappresenta un contatto nella rubrica.
 * 
 * La classe fornisce metodi per accedere e modificare  nome, cognome 
 * e fino a 3 email e 3 numeri di telefono.
 * Implementa l'interfaccia `Validatore` per verificare la validità dei dati inseriti
 * e l'interfaccia `Comparable` per confrontare i contatti.
 * 
 * @author Castellano Bruno
 * @author Grieco Giovanni
 * @author Giachetta Corradomaria
 * @author Di Carluccio Alesssandro
 * 
 * @date December 07, 2024
 * 
 * @see Validatore
 */
public class Contatto implements Comparable<Contatto>, Validatore {

    private String nome; ///< Nome del contatto.
    private String cognome; ///< Cognome del contatto.
    private List<String> email; ///< Lista degli indirizzi email del contatto.
    private List<String> numTelefono; ///< Lista dei numeri di telefono del contatto.

    /**
     * @brief Costruttore della classe.
     * 
     * @param nome Il nome del contatto.
     * @param cognome Il cognome del contatto.
     * 
     * @post Un'istanza della classe Contatto è inizializzata con almeno nome o cognome
     */
    public Contatto(String nome, String cognome) {
    }

    /**
     * @brief Restituisce il nome del contatto.
     * 
     * @return Il nome del contatto.
     */
    public String getNome() {
        return null;
    }

    /**
     * @brief Imposta il nome del contatto.
     * 
     * @param nome Il nuovo nome del contatto.
     * 
     * @pre nome != null
     * @post Il nome del contatto è aggiornato.
     */
    public void setNome(String nome) {
    }

    /**
     * @brief Restituisce il cognome del contatto.
     * 
     * @return Il cognome del contatto.
     */
    public String getCognome() {
        return null;
    }

    /**
     * @brief Imposta il cognome del contatto.
     * 
     * @param cognome Il nuovo cognome del contatto.
     * 
     * @pre cognome != null
     * @post Il cognome del contatto è aggiornato.
     */
    public void setCognome(String cognome) {
    }

    /**
     * @brief Restituisce la lista degli indirizzi email del contatto.
     * 
     * @return La lista degli indirizzi email del contatto.
     */
    public List<String> getEmail() {
        return null;
    }

    /**
     * @brief Imposta un indirizzo email per il contatto.
     * 
     * @param email L'indirizzo email da aggiungere.
     * 
     * @pre email != null
     * @post L'indirizzo email è aggiunto alla lista.
     */
    public void setEmail(String email) {
    }

    /**
     * @brief Restituisce la lista dei numeri di telefono del contatto.
     * 
     * @return La lista dei numeri di telefono del contatto.
     */
    public List<String> getNumTelefono() {
        return null;
    }

    /**
     * @brief Imposta un numero di telefono per il contatto.
     * 
     * @param numTelefono Il numero di telefono da aggiungere.
     * 
     * @pre numTelefono != null
     * @post Il numero di telefono è aggiunto alla lista.
     */
    public void setNumTelefono(String numTelefono) {
    }

    /**
     * @brief Aggiunge un numero di telefono alla lista.
     * 
     * @param numero Il numero di telefono da aggiungere.
     * 
     * @pre numero != null
     * @post Il numero di telefono è aggiunto alla lista.
     */
    public void aggiungiNumeroTelefono(String numero) {
    }

    /**
     * @brief Aggiunge un indirizzo email alla lista.
     * 
     * @param email L'indirizzo email da aggiungere.
     * 
     * @pre email != null
     * @post L'indirizzo email è aggiunto alla lista.
     */
    public void aggiungiEmail(String email) {
    }

    /**
     * @brief Confronta due contatti.
     * 
     * @param o L'altro contatto da confrontare.
     * @return Un valore negativo, zero o positivo in base al confronto alfabetico di nome e cognome.
     * 
     * @pre o != null
     */
    @Override
    public int compareTo(Contatto o) {
        return 0;
    }

    /**
     * @brief Verifica la correttezza sintattica dell'indirizzo email fornito.
     * 
     * La String della email deve contenere al suo interno il carattere "@" ed almeno un "." .
     * 
     * @param email L'indirizzo email da validare.
     * @return true se l'email è valida, false altrimenti.
     */
    @Override
    public boolean validaEmail(String email) {
        return false;
    }

    /**
     * @brief Verifica che il numero di telefono in input contenga solo caratteri
     * 
     * @param numTelefono Il numero di telefono da validare.
     * @return true se il numero è valido, false altrimenti.
     */
    @Override
    public boolean validaNumTelefono(String numTelefono) {
        return false;
    }

    /**
     * @brief Verifica che il contatto contenga almeno un nome o un cognome.
     * 
     * @param contatto Il contatto da validare.
     * @return true se il contatto è valido, false altrimenti.
     */
    @Override
    public boolean validaContatto(Contatto contatto) {
        return false;
    }
}
