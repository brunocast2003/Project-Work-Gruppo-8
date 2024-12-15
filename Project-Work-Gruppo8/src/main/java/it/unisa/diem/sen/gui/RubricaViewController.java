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
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
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
    private Button btnCerca;    ///<Bottone per cercare dei contatti.
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

    private GestoreContatti<Contatto> rubrica;  ///<L'elenco dei contatti da gestire.
    
    private Stage stage;    ///<La finestra principale dell'applicazione.

    /**
    * @brief Inizializza la gestione dei contatti impostando la rubrica e aggiornando la lista dei contatti.
    *
    * @param rubrica La rubrica contenente l'elenco dei contatti da gestire.
    * @pre La rubrica passata come parametro deve essere non null.
    * @post Il riferimento alla rubrica viene memorizzato e la lista dei contatti viene aggiornata.
    */
    public void starter(GestoreContatti<Contatto> rubrica) {
        this.rubrica = rubrica;
        aggiornaListaContatti();
    }
    
    /**
    * @brief Imposta il riferimento allo stage principale dell'applicazione.
    *
    * @param[in] stage Rappresenta lo stage principale dell'interfaccia utente.
    * @pre Lo stage passato come parametro deve essere valido e non null.
    * @post Il riferimento allo stage viene aggiornato con l'istanza fornita.
    */
    public void setStage(Stage stage) {
        this.stage = stage;
    }
    
    /**
    * @brief Restituisce lo stage principale della finestra.
    *
    * @pre Il campo stage deve essere inizializzato e rappresentare una finestra valida.
    * @post Viene restituito l'oggetto Stage che rappresenta la finestra principale.
    *
    * @return L'oggetto stage.
    */
    public Stage getStage(){
        return stage;
    }

    /**
     * @brief Inizializza il controller della vista.
     * 
     * Questo metodo è chiamato automaticamente durante il caricamento della vista FXML.
     * 
     * @param[in] url L'URL utilizzato per risolvere percorsi relativi al file FXML.
     * @param[in] rb Il `ResourceBundle` per localizzare la vista.
     * 
     * @pre La vista FXML è stata caricata correttamente.
     * @post Il controller è stato inizializzato.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if(rubrica!=null)
            aggiornaListaContatti();

    }    

    /**
    * @brief Gestisce l'evento di ricerca di un contatto nella rubrica.
    * Effettua la ricerca del contatto in base al testo inserito nella barra di ricerca
    * e aggiorna la lista dei contatti visibile all'utente con i risultati trovati.
    *
    * @pre La barra di ricerca deve essere inizializzata e non null.
    *      La rubrica deve essere inizializzata e contenere dati validi.
    * @post Se il testo inserito è vuoto, viene ripristinata la lista completa dei contatti.
    *       Se il testo inserito è valido, la lista dei contatti viene aggiornata con i risultati della ricerca.
    *       In caso di nessun risultato, viene mostrato un warning.
    *
    * @param[in] event L'evento che ha scatenato l'azione.
    */
    @FXML
    private void cerca(ActionEvent event) {
    String testoRicerca = barraRicerca.getText().trim();
    
    if (!testoRicerca.isEmpty()) {
        ObservableList<Contatto> result = this.rubrica.cercaContatto(testoRicerca);
        if(result.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Nessun contatto trovato!");
            alert.show();
        }
        listaContatti.getItems().clear();
        listaContatti.getItems().addAll(result);
    }else{
        aggiornaListaContatti();
    }

    }

    /**
    * @brief Gestisce l'evento di caricamento della rubrica da un file CSV.
    *       Consente all'utente di selezionare un file tramite un file chooser e carica i dati nella rubrica.
    *
    * @pre Lo stage principale deve essere inizializzato e non null.
    * @post Se il file viene selezionato e caricato correttamente:
    *       - La rubrica viene aggiornata con i dati del file.
    *       - La lista dei contatti visibile viene aggiornata.
    *       - Viene mostrato un messaggio informativo di successo.
    *       Se si verifica un errore durante il caricamento:
    *       - Viene mostrato un messaggio di errore con i dettagli dell'eccezione.
    *
    * @param[in] event L'evento che ha scatenato l'azione.
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
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Rubrica caricata con successo da: "+file.getAbsolutePath());
                alert.show();
            } catch (IOException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Errore durante il caricamento");
                alert.setHeaderText("Non è stato possibile caricare la rubrica.");
                alert.setContentText(e.getMessage());
                alert.showAndWait();
            }
        }
    }

    /**
    * @brief Gestisce l'evento di salvataggio della rubrica su un file CSV.
    *       Consente all'utente di selezionare un percorso tramite un file chooser e salva i dati della rubrica.
    *
    * @pre Lo stage principale deve essere inizializzato e non null.
    *      La rubrica deve essere inizializzata.
    * @post Se il file viene selezionato e il salvataggio riesce:
    *       - I dati della rubrica vengono salvati nel file CSV specificato.
    *       - Viene mostrato un messaggio informativo di successo.
    *       Se si verifica un errore durante il salvataggio:
    *       - Viene mostrato un messaggio di errore con i dettagli dell'eccezione.
    *
    * @param[in] event L'evento che ha scatenato l'azione.
    */
    @FXML
    private void salvaRubrica(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV Files", "*.csv"));
    
        File file = fileChooser.showSaveDialog(stage);
        if (file != null) {
            try {
                rubrica.salvaRubrica(file.getAbsolutePath());
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Rubrica salvata con successo in: "+file.getAbsolutePath());
                alert.show();
            } catch (IOException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Errore durante il salvataggio");
                alert.setHeaderText("Non è stato possibile salvare la rubrica.");
                alert.setContentText(e.getMessage());
                alert.showAndWait();
            }
        }
    }

    /**
    * @brief Gestisce l'uscita dal programma con opzioni di conferma e salvataggio.
    *
    * @pre L'elemento che ha generato l'evento deve essere valido.
    * @post Se l'utente sceglie:
    *       - "Annulla", il programma rimane aperto e nessuna azione viene eseguita.
    *       - "Esci", l'applicazione viene chiusa senza salvare.
    *       - "Salva ed esci", i dati della rubrica vengono salvati e l'applicazione viene chiusa.
    *
    * @param[in] event L'evento che ha scatenato l'azione.
    */
    @FXML
    private void esci(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("Stai per uscire dal programma, vuoi salvare?");
        
        ButtonType cancelButtonType = new ButtonType("Annulla",ButtonData.CANCEL_CLOSE);
        ButtonType esciButtonType = new ButtonType("Esci", ButtonData.OK_DONE);
        ButtonType salvaButtonType = new ButtonType("Salva ed esci", ButtonData.OK_DONE);
        
        alert.getButtonTypes().setAll(cancelButtonType, esciButtonType, salvaButtonType);

        Optional<ButtonType> result = alert.showAndWait();
        
        if (result.isPresent()) {
            if (result.get() == salvaButtonType)
                salvaRubrica(event);
            if (result.get() == esciButtonType || result.get() == salvaButtonType) {
                Stage stage = (Stage) ((MenuItem) event.getSource()).getParentPopup().getOwnerWindow();                
                stage.close();
                System.out.println("Uscito con successo!");
            }
        }
    }

    /**
    * @breief Gestisce il doppio click su un contatto della lista.
    * Se l'utente fa doppio clic su un contatto nella lista, viene aperta una nuova vista
    * specifica per il contatto selezionato.
    *
    * @pre La lista dei contatti (listaContatti) deve essere inizializzata e popolata.
    * @post Il contatto selezionato viene passato alla vista specifica tramite il metodo switchContattoView.
    *
    * @param[in] event L'evento generato dall'interazione con la lista.
    * @throws IOException Se si verifica un errore durante il caricamento della nuova vista del contatto.
    */
    @FXML
    private void handleMouseEvent(MouseEvent event) throws IOException {
        if (event.getClickCount() == 2) {
            Contatto contattoSelezionato = listaContatti.getSelectionModel().getSelectedItem();
            if (contattoSelezionato != null) {
                switchContattoView(event, contattoSelezionato);
            }
        }
    }

    /**
    * @brief Gestisce l'evento generato dal pulsante "Aggiungi Contatto".
    *
    * @pre Nessuna.
    * @post Una nuova vista per l'aggiunta di un contatto viene caricata tramite switchContattoView.
    *
    * @param[in] event L'evento generato dalla pressione del pulsante "Aggiungi Contatto".
    * @throws IOException Se si verifica un errore durante il caricamento della nuova vista.
    */
    @FXML
    private void handleActionEvent(ActionEvent event) throws IOException {
        
        switchContattoView(event,null);
 
    }
    
    /**
    * @brief Gestisce la transizione verso una nuova vista per la visualizzazione, modifica o aggiunta di un contatto.
    *
    * @pre La vista deve essere disponibile nel percorso specificato.
    *      La variabile rubrica deve essere inizializzata e contenere i dati necessari.
    * @post La vista ContattoView viene caricata e mostrata in una nuova finestra.
    *       Se è presente un contatto, i suoi dati vengono passati alla vista per la modifica. 
    *       La finestra contenente la vista viene aperta e visualizzata.
    *
    * @param[in] event L'evento che ha causato il passaggio alla vista (clic sul pulsante o doppio click sul contatto).
    * @param[in] contatto Il contatto da visualizzare o modificare. Se null, la vista sarà per aggiungere un nuovo contatto.
    * @throws IOException Se si verifica un errore durante il caricamento della vista.
    */
    public void switchContattoView(Event event,Contatto contatto) throws IOException {
       
    FXMLLoader loader = new FXMLLoader(getClass().getResource("ContattoView.fxml"));

    Parent root = loader.load();

    ContattoViewController contattoViewController = loader.getController();
    contattoViewController.starter(contatto, rubrica, this);
    
    Scene scene = new Scene(root);
    
    Stage newStage = new Stage();
    newStage.setScene(scene);
    
    contattoViewController.setStage(this.stage);
    
    newStage.show();
    }
      
    /**
    * @brief Aggiorna la lista dei contatti visualizzati nell'interfaccia utente.
    * Ordina i contatti nella rubrica, aggiorna la visualizzazione dei contatti e gestisce il messaggio di placeholder
    * quando la rubrica è vuota.
    *
    * @pre La rubrica deve essere inizializzata.
    *      listaContatti deve essere inizializzato.
    * @post La lista dei contatti visualizzata viene aggiornata:
    *       - I contatti vengono ordinati.
    *       - Se la rubrica è vuota, viene mostrato un messaggio di placeholder che avvisa l'utente.
    *       - Se la rubrica non è vuota, il placeholder viene rimosso e i contatti vengono aggiunti alla lista.
    *
    * @throws NullPointerException Se rubrica o listaContatti non sono inizializzati.
    */
    public void aggiornaListaContatti() {
       rubrica.ordinaRubrica();
        if (rubrica.getTuttiContatti().isEmpty()) {
        listaContatti.setPlaceholder(new Label("La rubrica è vuota."));
        } else {
            listaContatti.setPlaceholder(null);
        }
       listaContatti.getItems().clear();
       listaContatti.getItems().addAll(rubrica.getTuttiContatti());
       
    }

}
