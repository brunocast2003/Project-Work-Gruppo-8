/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package it.unisa.diem.sen.gui;
import it.unisa.diem.sen.api.*;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * @brief Controller per la gestione dell'interfaccia principale della rubrica.
 * 
 * Questa classe è responsabile della gestione degli eventi e dell'interazione
 * con l'utente nella vista principale della rubrica.
 * 
 * @author Castellano Bruno
 * @author Grieco Giovanni
 * @author Giachetta Corradomaria
 * @author Di Carluccio Alesssandro
 * 
 * @date December 07, 2024
 * 
 * @see Rubrica
 */
public class RubricaViewController implements Initializable {

    @FXML
    private TextField barraRicerca; ///< Campo di testo per la ricerca dei contatti.
    @FXML
    private ListView<String> listaContatti; ///< Lista dei contatti visualizzati.
    @FXML
    private Button btnAggiungiContatto; ///< Bottone per aggiungere un nuovo contatto.
    @FXML
    private MenuItem caricaRubrica; ///< Opzione di menu per caricare una rubrica da file.
    @FXML
    private MenuItem salvaRubrica; ///< Opzione di menu per salvare la rubrica su file.
    @FXML
    private MenuItem esci; ///< Opzione di menu per chiudere l'applicazione.

    private Rubrica rubrica;
    
    /**
     * @brief Inizializza il controller della vista.
     * 
     * Questo metodo è chiamato automaticamente durante il caricamento della vista FXML.
     * 
     * @param url L'URL utilizzato per risolvere percorsi relativi al file FXML.
     * @param rb Il `ResourceBundle` per localizzare la vista.
     * 
     * @pre La vista FXML è stata caricata correttamente.
     * @post Il controller è stato inizializzato.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    


    /**
     * @brief Carica una rubrica da file.
     * 
     * Questo metodo è chiamato quando l'utente seleziona l'opzione di menu "Carica Rubrica".
     * 
     * @param event L'evento generato dalla selezione del menu.
     * 
     * @pre Nessuna.
     * @post Nessuna.
     */
    @FXML
    private void caricaRubrica(ActionEvent event) {
    }

    /**
     * @brief Salva la rubrica su file.
     * 
     * Questo metodo è chiamato quando l'utente seleziona l'opzione di menu "Salva Rubrica".
     * 
     * @param event L'evento generato dalla selezione del menu.
     * 
     * @pre Nessuna.
     * @post Nessuna.
     */
    @FXML
    private void salvaRubrica(ActionEvent event) {
    }

    /**
     * @brief Chiude l'applicazione.
     * 
     * Questo metodo è chiamato quando l'utente seleziona l'opzione di menu "Esci".
     * 
     * @param event L'evento generato dalla selezione del menu.
     * 
     * @pre Nessuna.
     * @post Nessuna.
     */
    @FXML
    private void esci(ActionEvent event) {
    }

    /**
     * @brief Cambia la vista per visualizzare i dettagli di un contatto.
     * 
     * Questo metodo è chiamato quando l'utente clicca due volte su un elemento della lista dei contatti.
     * 
     * @param event L'evento generato dal clic su un contatto.
     * 
     * @pre Nessuna.
     * @post Nessuna.
     */
    @FXML
    private void switchContattoView(MouseEvent event) {
    }

    /**
     * @brief Cambia la vista per visualizzare i dettagli di un contatto.
     * 
     * Questo metodo è chiamato quando l'utente clicca il bottone "Aggiungi contatto".
     * 
     * @param event L'evento generato dall'interazione col bottone "Aggiungi contatto".
     * 
     * @pre Nessuna.
     * @post Nessuna.
     */
    @FXML
    private void switchContattoView(ActionEvent event) {
    }
}
