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
 * @date December 07, 2024
 * 
 *  
 */

package it.unisa.diem.sen.api;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
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
    * @see GestoreContatti
*/
public class Rubrica implements GestoreContatti<Contatto>{
    
    private ObservableList<Contatto> contatti;    ///< La lista di contatti gestita dalla rubrica.
    
    /**
     * @brief Crea un oggetto di tipo rubrica
     * 
     * Questo metodo crea un oggetto Rubrica e inizializza una lista di contatti
     * Inizializza una nuova rubrica vuota. 
     * @pre Rubrica inesistente
     *
     * @post Una nuova istanza di `Rubrica` è creata con una lista vuota di contatti.
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
     *  @param[in] contatto Il contatto da aggiungere alla rubrica.
    */
    @Override
    public void aggiungiContatto(Contatto contatto){
        if(!contatti.contains(contatto))
        this.contatti.add(contatto);
    }
    
    /**
     * @param contatto
     * @brief Rimuove un contatto dalla rubrica.
     * 
     * @param[in] contatto Il contatto da rimuovere dalla rubrica.
     * 
     * @pre contatto != null
     * @post Il contatto specificato è rimosso dalla lista dei contatti, se esiste.
     */
    @Override
    public void rimuoviContatto(Contatto contatto){
   
        this.contatti.remove(contatto);
    } 
    
    /**
    * @brief Esegue la ricerca di contatti in base al nome o cognome, ignorando maiuscole/minuscole.
    * La ricerca avviene sia per nome che per cognome, considerando anche le possibili combinazioni 
    * di nome e cognome invertiti (nome cognome e cognome nome).
    * 
    * @param[in] cerca La stringa di ricerca, rappresentante parte del nome o cognome del contatto.
    * @return Una lista di contatti che corrispondono alla stringa di ricerca.
    * 
    * @pre La lista di contatti deve essere inizializzata e contenere almeno un contatto.
    * @post Restituisce una lista di contatti che contengono il testo di ricerca nel nome, cognome o nelle combinazioni invertite di nome e cognome.
    */
    @Override
    public ObservableList<Contatto> cercaContatto(String cerca) {
        ObservableList<Contatto> result = FXCollections.observableArrayList();
        
         String cercaLower = cerca.trim().toLowerCase();

        for (Contatto contatto : contatti) {
            String nomeCognome = (contatto.getNome() + " " + contatto.getCognome()).toLowerCase();
            String cognomeNome =(contatto.getCognome()+ " " + contatto.getNome()).toLowerCase();

            if (contatto.getNome().toLowerCase().contains(cercaLower) || contatto.getCognome().toLowerCase().contains(cercaLower) || nomeCognome.contains(cercaLower) || cognomeNome.contains(cercaLower)) {
                result.add(contatto);
            }
        }
        return result;
    }
    
    /**
    * @brief Ordina la rubrica in base all'ordinamento naturale dei contatti.
    * Utilizza il metodo `compareTo` definito nella classe `Contatto` per ordinare la lista di contatti.
    * 
    * @pre La lista di contatti deve essere inizializzata e non vuota.
    * @post La lista di contatti sarà ordinata in ordine crescente in base all'ordinamento naturale definito nella classe `Contatto`.
    */
    @Override 
    public void ordinaRubrica() {
        FXCollections.sort(contatti);
    }
    
    /**
    * @brief Restituisce l'intera lista di contatti presenti nella rubrica.
    * 
    * @return La lista di tutti i contatti attualmente memorizzati nella rubrica.
    * 
    * @pre La lista di contatti deve essere inizializzata.
    * @post Viene restituita la lista completa di contatti.
    */
    @Override
    public List<Contatto> getTuttiContatti() {
        return this.contatti;
    }
    
    /**
    * @brief Carica la rubrica da un file CSV e restituisce un oggetto `Rubrica` contenente tutti i contatti letti.
    * I contatti nel file sono separati da punto e virgola (";"), e il formato previsto è:
    * cognome, nome, numeri di telefono (fino a 3), email (fino a 3).
    * 
    * @param[in] nomefile Il percorso del file CSV da cui caricare i contatti.
    * @return Un oggetto `Rubrica` contenente i contatti letti dal file.
    * 
    * @pre Il file deve esistere e deve essere accessibile per la lettura.
    * @post La rubrica verrà caricata con i contatti letti dal file.
    * 
    * @throws IOException Se si verifica un errore durante la lettura del file.
    */
    @Override
    public Rubrica caricaRubrica(String nomefile) throws IOException{
        Rubrica r = new Rubrica();
        r.contatti = this.contatti;
        try(Scanner s = new Scanner(new BufferedReader(new FileReader(nomefile)))){
            
            if (!s.hasNextLine())
                return r;
            else
                s.nextLine();
            
            s.useDelimiter("[;\n]");
            s.useLocale(Locale.US); 
            
            while(s.hasNext()){
                String linea = s.nextLine();
                String[] campi = linea.split(";");
                
                String cognome = campi.length > 0 ? campi[0].trim() : "";
                String nome = campi.length > 1 ? campi[1].trim() : "";
                
                String numTelefono1 = campi.length > 2 ? campi[2].trim() : "";
                String numTelefono2 = campi.length > 3 ? campi[3].trim() : "";
                String numTelefono3 = campi.length > 4 ? campi[4].trim() : "";

                String email1 = campi.length > 5 ? campi[5].trim() : "";
                String email2 = campi.length > 6 ? campi[6].trim() : "";
                String email3 = campi.length > 7 ? campi[7].trim() : "";
                
                Contatto c = new Contatto(nome, cognome);
                c.aggiungiNumeroTelefono(numTelefono1);
                c.aggiungiNumeroTelefono(numTelefono2);
                c.aggiungiNumeroTelefono(numTelefono3);
                c.aggiungiEmail(email1);
                c.aggiungiEmail(email2);
                c.aggiungiEmail(email3);
                
                r.aggiungiContatto(c);
                
            }
        }
        return r;
    }
    

    /**
    * @brief Salva la rubrica in un file CSV. Ogni contatto verrà scritto su una riga separata, con i suoi dettagli 
    * (cognome, nome, numeri di telefono ed email) separati da punto e virgola.
    * Se un contatto non ha uno o più numeri di telefono o email, il campo corrispondente sarà lasciato vuoto.
    * La prima riga del file conterrà l'intestazione con i nomi dei campi.
    * 
    * @param[in] nomefile Il percorso del file CSV in cui salvare i contatti.
    * @throws IOException Se si verifica un errore durante la scrittura nel file.
    * 
    * @pre Il file specificato dal parametro `nomefile` deve essere accessibile per la scrittura.
    * @post I contatti verranno salvati nel file.
    */
    @Override
    public void salvaRubrica(String nomefile) throws IOException {
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(nomefile)))) {
            pw.println("COGNOME;NOME;NUMERO DI TELEFONO 1;NUMERO DI TELEFONO 2;NUMERO DI TELEFONO 3;EMAIL 1;EMAIL 2;EMAIL 3");

            for (Contatto c : contatti) {
                pw.print(c.getCognome());
                pw.append(";");              
                pw.print(c.getNome());
                pw.append(";");

                List<String> t = c.getNumTelefono();
                for (int i = 0; i < 3; i++) {
                    pw.append(i < t.size() ? t.get(i) : "");
                    pw.append(";");
                }

                List<String> e = c.getEmail();
                for (int j = 0; j < 3; j++) {
                    pw.append(j < e.size() ? e.get(j) : "");
                    if (j < 2) {
                        pw.append(";");
                    } else {
                        pw.append("\n");
                    }
                }
            }
        }    
    }
}
