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
 * @see ValidatoreStandard
 */
public class Contatto implements Comparable<Contatto> {

    private String nome; ///< Nome del contatto.
    private String cognome; ///< Cognome del contatto.
    private  List<String> email; ///< Lista degli indirizzi email del contatto.
    private  List<String> numTelefono; ///< Lista dei numeri di telefono del contatto.
    
    
    private final Validatore validatore;    ///<oggetto per verificare la validità dei dati inseriti.

    /**
     * @brief Costruttore della classe.
     * 
     * @param[in] nome Il nome del contatto.
     * @param[in] cognome Il cognome del contatto.
     * 
     * @post Un'istanza della classe Contatto è inizializzata con almeno nome o cognome
     */
    public Contatto(String nome, String cognome) {
        this.validatore = new ValidatoreStandard();
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
    * @brief Imposta la lista di email per il contatto, validando ogni email prima di aggiungerla.
    * Ogni email deve essere valida secondo le regole definite nel validatore, e non possono esserci più di 3 email.
    * 
    * @param[in] email La lista di email da impostare per il contatto.
    * 
    * @pre La lista di email deve contenere al massimo 3 indirizzi.
    * @post La lista di email del contatto viene aggiornata con le nuove email valide.
    * 
    * @throws IllegalArgumentException Se una delle email non è valida o se il numero di email è maggiore di 3.
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
     * @brief Imposta la lista di numeri di telefono per il contatto, validando ogni numero prima di aggiungerlo.
     * Ogni numero di telefono deve essere valido secondo le regole definite nel validatore, e non possono esserci più di 3 numeri di telefono.
     * 
     * @param[in] numTelefono La lista di numeri di telefono da impostare per il contatto.
     * 
     * @pre La lista di numeri di telefono deve contenere al massimo 3 numeri.
     * @post La lista di numeri di telefono del contatto viene aggiornata con i nuovi numeri validi.
     * 
     * @throws IllegalArgumentException Se uno dei numeri di telefono non è valido o se il numero di numeri di telefono è maggiore di 3.
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
    * @brief Aggiunge una nuova email alla lista di email del contatto, dopo averla validata.
    * Se l'email non è valida, viene sollevata un'eccezione.
    * 
    * @param[in] email L'email da aggiungere al contatto.
    * 
    * @pre L'email deve essere valida secondo le regole definite nel validatore.
    * @post L'email viene aggiunta alla lista di email del contatto se è valida.
    * 
    * @throws IllegalArgumentException Se l'email non è valida.
    */
    public void aggiungiEmail(String email) {
        if(!validatore.validaEmail(email))
            throw new IllegalArgumentException("Inserire una mail valida!");
        this.email.add(email);
    }

   /**
    * @brief Confronta due oggetti `Contatto` in base ai loro cognomi e, in caso di parità, ai loro nomi.
    * Il confronto avviene in modo case-insensitive.
    * Se entrambi i cognomi sono vuoti, il confronto avviene in base ai nomi.
    * Se uno dei cognomi è vuoto, il contatto con il cognome non vuoto viene considerato maggiore.
    * 
    * @param[in] o Il contatto da confrontare con l'oggetto corrente.
    * @return Un intero negativo, zero o positivo, a seconda che l'oggetto corrente sia minore, uguale o maggiore dell'oggetto passato come parametro.
    * 
    * @pre L'oggetto passato come parametro deve essere un'istanza della classe `Contatto`.
    * @post Restituisce il risultato del confronto tra i cognomi, e se questi sono uguali, tra i nomi.
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
    * @brief Restituisce una rappresentazione testuale del contatto sotto forma di una stringa
    * contenente il cognome e il nome separati da uno spazio.
    * 
    * @return Una stringa che rappresenta il contatto nel formato "Cognome Nome".
    * 
    * @post Restituisce una rappresentazione leggibile del contatto utilizzata 
    *       per visualizzarlo in una lista o in un'interfaccia utente.
    */
    @Override
    public String toString() {
        return  getCognome()+ " " + getNome();
    }
}
