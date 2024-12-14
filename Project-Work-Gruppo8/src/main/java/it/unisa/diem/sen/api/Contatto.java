/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.sen.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * /**
 * @brief Un contatto nella rubrica.
 * La classe fornisce metodi per accedere e modificare  nome, cognome, email e numeri di telefono
 * Implementa l'interfaccia Validatore per verificare la correttezza dei dati inseriti
 * e l'interfaccia Comparable per confrontare i contatti.
 * 
 * @invariant Il contatto deve avere, qualora esistano, numeri di telefono ed email validi.
 * @invariant Il contatto può avere fino a un massimo di tre numeri di telefono.
 * @invariant Il contatto può avere fino a un massimo di tre indirizzi email.
 * 
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
public class Contatto implements Comparable<Contatto> {

    private String nome; ///< Nome del contatto.
    private String cognome; ///< Cognome del contatto.
    private  List<String> email; ///< Lista degli indirizzi email del contatto.
    private  List<String> numTelefono; ///< Lista dei numeri di telefono del contatto.
    
    
    private static Validatore<Contatto> validatore = new ValidatoreStandard();

    /**
     * @brief Costruttore della classe.
     * 
     * @param[in] nome Il nome del contatto.
     * @param[in] cognome Il cognome del contatto.
     * 
     * @post Un'istanza della classe Contatto è inizializzata con almeno nome o cognome
     */
    public Contatto(String nome, String cognome) {
        if((!validatore.validaNome(nome)) &&(!validatore.validaCognome(cognome)))
            throw new IllegalArgumentException("Inserisci almeno il nome o cognome!");
        this.nome = nome;
        this.cognome = cognome;
        this.email  = new ArrayList<>(3);
        this.numTelefono  = new ArrayList<>(3);
    }

    /**
     * @brief Restituisce il nome del contatto.
     * 
     * @return Il nome del contatto.
     */
    public String getNome() {
        return this.nome;
    }
    
    /**
     * @brief Imposta il nome del contatto.
     * 
     * @param[in] nome Il nuovo nome del contatto.
     * 
     * @pre nome != null
     * @post Il nome del contatto è aggiornato.
     */
    public void setNome(String nome) {
      this.nome=nome;
    }

    /**
     * @brief Restituisce il cognome del contatto.
     * 
     * @return Il cognome del contatto.
     */
    public String getCognome() {
        return this.cognome;
    }

    /**
     * @brief Imposta il cognome del contatto.
     * 
     * @param[in] cognome Il nuovo cognome del contatto.
     * 
     * @pre cognome != null
     * @post Il cognome del contatto è aggiornato.
     */
    public void setCognome(String cognome) {
        this.cognome=cognome;
    }

    /**
     * @brief Restituisce la lista degli indirizzi email del contatto.
     * 
     * @return La lista degli indirizzi email del contatto.
     */
    public List<String> getEmail() {
       return new ArrayList<>(this.email);
    }

    /**
     * @brief Associa una lista di email per il contatto.
     * 
     * @param[in] email la List di email da associare al contatto.
     * 
     * @pre email != null
     * @post La lista email è associata correttamente al contatto.
     */
    public void setEmail(List<String> email) {
        for(String e : email) {
            if(!(validatore.validaEmail(e) && email.size() < 3)){
                throw new IllegalArgumentException("Email non valida");
            }
        }
       this.email=email;
    }

    /**
     * @brief Restituisce la lista dei numeri di telefono del contatto.
     * 
     * @return La lista dei numeri di telefono del contatto.
     */
    public List<String> getNumTelefono() {
        return new ArrayList(this.numTelefono);
    }

    /**
     * @brief Associa una lista di numeri di telefono per il contatto.
     * 
     * @param[in] numTelefono La lista di numeri di telefono da associare al contatto.
     * 
     * @pre numTelefono != null
     * @post La lista di numeri di telefono è associata correttamente al contatto.
     */
    public void setNumTelefono(List<String> numTelefono) {
        for(String n : numTelefono) {
            if(!(validatore.validaNumTelefono(n) && numTelefono.size() < 3)){
                throw new IllegalArgumentException("Numero non valido");
            }
        }
        this.numTelefono = numTelefono;
    }

    /**
     * @brief Aggiunge un numero di telefono alla lista.
     * 
     * @param[in] numero Il numero di telefono da aggiungere.
     * 
     * @pre numero != null
     * @post Il numero di telefono è aggiunto alla lista.
     */
    public void aggiungiNumeroTelefono(String numero) { 
        if(validatore.validaNumTelefono(numero) && this.numTelefono.size() < 3){
            this.numTelefono.add(numero);
        }else throw new IllegalArgumentException("Numero non valido");
       
    }

    /**
     * @brief Aggiunge un indirizzo email alla lista.
     * 
     * In caso di email non valida, lancia una IllegalArgumentException per notificare l'utente
     * 
     * @param[in] email L'indirizzo email da aggiungere.
     * 
     * @pre email != null
     * @post L'indirizzo email è aggiunto alla lista.
     */
    public void aggiungiEmail(String email) {
        if(!validatore.validaEmail(email))
            throw new IllegalArgumentException("Inserire una mail valida!");
        this.email.add(email);
    }

    /**
     * @brief Confronta due contatti
     * 
     * @param[in] o L'altro contatto da confrontare.
     * 
     * @pre o != null
     * @return Un valore negativo, zero o positivo in base al confronto alfabetico di nome e cognome.
     * 
     */
    @Override
    public int compareTo(Contatto o) {
        if (cognome.isEmpty() && o.getCognome().isEmpty()) {
            return nome.compareToIgnoreCase(o.getNome());
        } else if (cognome.isEmpty()) {
            return 1;
        } else if (o.getCognome().isEmpty()) {
            return -1;
        }
        int risultato = this.cognome.compareToIgnoreCase(o.getCognome());
        if(risultato != 0) {
            return risultato;
        }
        return this.nome.compareToIgnoreCase(o.getNome());
    }

    /**
     * @brief Verifica la correttezza sintattica dell'indirizzo email fornito.
     * 
     * L'indirizzo email deve contenere al suo interno il carattere "@" ed almeno un ".".
     * 
     * @param[in] email L'indirizzo email da validare.
     * @return true se l'email è valida, false altrimenti.
     */

    
    @Override
    public String toString() {
        return  getCognome()+ " " + getNome();
    }
}
