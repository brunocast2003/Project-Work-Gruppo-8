/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package it.unisa.diem.sen.gui;
import it.unisa.diem.sen.api.*;
import java.io.File;
import java.io.IOException;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

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
    private ListView<Contatto> listaContatti; ///< Lista dei contatti visualizzati.
    @FXML
    private Button btnAggiungiContatto; ///< Bottone per aggiungere un nuovo contatto.
    @FXML
    private MenuItem caricaRubrica; ///< Opzione di menu per caricare una rubrica da file.
    @FXML
    private MenuItem salvaRubrica; ///< Opzione di menu per salvare la rubrica su file.
    @FXML
    private MenuItem esci; ///< Opzione di menu per chiudere l'applicazione.

    private Rubrica rubrica;
    
    private Stage stage;
    
    
    public void setStage(Stage stage) {
        this.stage = stage;
    }
    
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
        rubrica = new Rubrica();
        aggiornaListaContatti();
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
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll( new FileChooser.ExtensionFilter("CSV Files", "*.csv"));

        File file = fileChooser.showOpenDialog(stage);
        if (file != null) {
            try {
                rubrica = rubrica.caricaRubrica(file.getAbsolutePath());
                aggiornaListaContatti();
                System.out.println("Rubrica caricata da: " + file.getAbsolutePath());
            } catch (IOException e) {
                System.err.println("Errore durante il caricamento della rubrica: " + e.getMessage());
            }
        }
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
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV Files", "*.csv"));
    
        File file = fileChooser.showSaveDialog(stage);
        if (file != null) {
            try {
                rubrica.salvaRubrica(file.getAbsolutePath());
                System.out.println("Rubrica salvata in: " + file.getAbsolutePath());
            } catch (IOException e) {
                System.err.println("Errore durante il salvataggio della rubrica: " + e.getMessage());
            }
        }
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
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("Stai per uscire dal programma!");
        
        ButtonType cancelButtonType = new ButtonType("Annulla",ButtonData.CANCEL_CLOSE);
        ButtonType esciButtonType = new ButtonType("Esci", ButtonData.OK_DONE);
        
        alert.getButtonTypes().setAll(cancelButtonType, esciButtonType);
        
        if (alert.showAndWait().get() == esciButtonType){
            System.out.println("Uscito con successo!");
            this.stage.close();
        }
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
    private void switchContattoView(MouseEvent event) throws IOException {
        if (event.getClickCount() == 2) {
        Contatto contattoSelezionato = listaContatti.getSelectionModel().getSelectedItem();
        if (contattoSelezionato != null) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ContattoView.fxml"));

            loader.setControllerFactory(param -> 
                new ContattoViewController(contattoSelezionato, rubrica, this)
            );

            Parent root = loader.load();
            stage.setScene(new Scene(root));
            stage.show();
        }
    }
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
    private void switchContattoView(ActionEvent event) throws IOException {
        Contatto nuovoContatto = new Contatto("", "");

        rubrica.aggiungiContatto(nuovoContatto);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("ContattoView.fxml"));
        loader.setControllerFactory(param -> 
            new ContattoViewController(nuovoContatto, rubrica, this)
        );
        Parent root = loader.load();


        stage.setScene(new Scene(root));
        stage.show();
    }
    
    /**
     * @brief Aggiorna la ListView per mostrare i contatti attualmente presenti in rubrica.
     */
    private void aggiornaListaContatti() {
        listaContatti.getItems().clear();
        listaContatti.getItems().addAll(rubrica.getTuttiContatti());

        listaContatti.setCellFactory(lv -> new ListCell<Contatto>() {
            @Override
            protected void updateItem(Contatto contatto, boolean empty) {
                super.updateItem(contatto, empty);
                setText(empty || contatto == null ? null : contatto.getNome() + " " + contatto.getCognome());
            }
        });

    }
}
