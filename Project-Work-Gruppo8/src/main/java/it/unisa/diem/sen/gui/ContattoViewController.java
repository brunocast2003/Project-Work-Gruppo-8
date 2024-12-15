/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.sen.gui;

import it.unisa.diem.sen.api.Contatto;
import it.unisa.diem.sen.api.GestoreContatti;
import it.unisa.diem.sen.api.Rubrica;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 * 
* @author Castellano Bruno
 * @author Grieco Giovanni
 * @author Giachetta Corradomaria
 * @author Di Carluccio Alesssandro
 * 
   * @see Contatto
     * @see Rubrica
     * @see RubricaViewController
 * 
 */
public class ContattoViewController implements Initializable {

    @FXML
    private Label lblNome;  ///< Etichetta per il campo del nome del contatto.
    @FXML
    private TextField tfdNome;  ///< Campo di testo per inserire o visualizzare il nome del contatto.
    @FXML
    private Label lblCognome;   ///< Etichetta per il campo del cognome del contatto.
    @FXML
    private Label lblTelefono1; ///< Etichetta per il primo numero di telefono del contatto.
    @FXML
    private Label lblTelefono2; ///< Etichetta per il secondo numero di telefono del contatto.
    @FXML
    private Label lblTelefono3; ///< Etichetta per il terzo numero di telefono del contatto.
    @FXML
    private Label lblEmail1;    ///< Etichetta per la prima email del contatto.
    @FXML
    private Label lblEmail2;    ///< Etichetta per la seconda email del contatto.
    @FXML
    private Label lblEmail3;    ///< Etichetta per la terza email del contatto.
    @FXML
    private TextField tfdCognome;   ///< Campo di testo per inserire o visualizzare il cognome del contatto.
    @FXML
    private TextField tfdTelefono1; ///< Campo di testo per inserire o visualizzare il primo numero di telefono del contatto.
    @FXML
    private TextField tfdTelefono2; ///< Campo di testo per inserire o visualizzare il secondo numero di telefono del contatto.
    @FXML
    private TextField tfdTelefono3; ///< Campo di testo per inserire o visualizzare il terzo numero di telefono del contatto.
    @FXML
    private TextField tfdEmail1;    ///< Campo di testo per inserire o visualizzare la prima email del contatto.
    @FXML
    private TextField tfdEmail2;    ///< Campo di testo per inserire o visualizzare la seconda email del contatto.
    @FXML
    private TextField tfdEmail3;    ///< Campo di testo per inserire o visualizzare la terza email del contatto.
    @FXML
    private Button btnRimuoviContatto;  ///<Bottone per rimuovere.
    @FXML
    private Button btnSalva;    ///<Bottone per salvare.
    @FXML
    private Button btnAnnulla;  ///<Bottone per annullare l'operazione.
    
    private Contatto contatto;  ///<Riferimento al contatto attualmente visualizzato
    private GestoreContatti<Contatto> rubrica;  ///<Riferimento alla rubrica.
    private RubricaViewController rubricaViewController;    ///<Controller della vista della rubrica.

    private Stage stage;    ///<Riferimento alla finestra principale dell'applicazione.
    
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
    * @brief Inizializza il controller della vista per la gestione di un contatto.
    * Questo metodo è utilizzato per impostare i dati del contatto
    *
    * @pre contatto può essere null (per creare un nuovo contatto) o un oggetto valido di tipo Contatto.
    *      rubrica deve essere inizializzato e rappresentare la rubrica contenente i contatti.
    *      rubricaViewController deve essere valido.
    * @post Se il contatto è null, il pulsante di rimozione contatto viene nascosto.
    *       Se il contatto è valido, i suoi dati (nome, cognome, numeri di telefono ed email) vengono impostati nei campi di testo corrispondenti.
    *
    * @param[in] contatto Il contatto da visualizzare o modificare. Se  null, la vista sarà per un nuovo contatto.
    * @param[in] rubrica La rubrica che contiene il contatto.
    * @param[in] rubricaViewController Il controller della vista della rubrica.
    */
    public void starter (Contatto contatto, GestoreContatti<Contatto> rubrica, RubricaViewController rubricaViewController) {
        this.contatto = contatto;
        this.rubrica = rubrica;
        this.rubricaViewController = rubricaViewController;
        
        if (contatto == null){
            btnRimuoviContatto.setVisible(false);
        }
        
        if (contatto != null) {
            tfdNome.setText(contatto.getNome());
            tfdCognome.setText(contatto.getCognome());

            if (contatto.getNumTelefono().size() > 0)
                tfdTelefono1.setText(contatto.getNumTelefono().get(0));
            if (contatto.getNumTelefono().size() > 1)
                tfdTelefono2.setText(contatto.getNumTelefono().get(1));
            if (contatto.getNumTelefono().size() > 2)
                tfdTelefono3.setText(contatto.getNumTelefono().get(2));

            if (contatto.getEmail().size() > 0)
                tfdEmail1.setText(contatto.getEmail().get(0));
            if (contatto.getEmail().size() > 1)
                tfdEmail2.setText(contatto.getEmail().get(1));
            if (contatto.getEmail().size() > 2)
                tfdEmail3.setText(contatto.getEmail().get(2));
        }
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
        
    }
    
    /**
    * @brief Gestisce l'evento di rimozione di un contatto dalla rubrica.
    *
    * @pre Il contatto da rimuovere deve essere un contatto valido già esistente nella rubrica.
    *      La rubrica deve essere inizializzata e contenere il contatto da rimuovere.
    *      rubricaViewController deve essere inizializzato per permettere l'aggiornamento della lista.
    * @post Se l'utente conferma la rimozione, il contatto viene rimosso dalla rubrica,
    *       viene mostrato un messaggio di successo e la lista dei contatti viene aggiornata.
    *       Se l'utente annulla, viene mostrato un messaggio di annullamento.
    *       Infine, la vista della rubrica viene ricaricata.
    *
    * @param[i] event L'evento che ha attivato l'azione di rimozione del contatto.
    * @throws IOException Se si verifica un errore durante il passaggio alla vista della rubrica.
    */
    @FXML
    private void rimuoviContatto(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setHeaderText("Sei sicuro di voler rimuovere il contatto?");
    
    
    Optional<ButtonType> result = alert.showAndWait();
    
    if (result.isPresent() && result.get() == ButtonType.OK) {
        rubrica.rimuoviContatto(contatto);
        
        Alert successoAlert = new Alert(Alert.AlertType.INFORMATION);
        successoAlert.setHeaderText("Contatto rimosso con successo!");
        successoAlert.show();
        
        rubricaViewController.aggiornaListaContatti();
        rubricaViewController.starter(rubrica);
    } else {
        Alert annullaAlert = new Alert(Alert.AlertType.INFORMATION);
        annullaAlert.setHeaderText("Operazione annullata!");
        annullaAlert.show();
    }
    switchRubricaView(event);
    }

    /**
    * @brief Gestisce l'evento di salvataggio di un contatto.
    * Verifica che i campi obbligatori (nome e cognome) siano compilati e valida i numeri di telefono e le email.
    * Se il contatto è nuovo, lo crea, altrimenti aggiorna i dati del contatto esistente.
    * Dopo aver salvato il contatto, aggiorna la lista dei contatti nella vista e mostra un messaggio di successo.
    * Se si verificano errori di validazione, vengono mostrati degli alert di errore.
    *
    * @pre I campi di nome e cognome devono essere compilati.
    *      I numeri di telefono e le email devono essere nel formato corretto, se forniti.
    *      La rubrica deve essere inizializzata.
    *      rubricaViewController deve essere inizializzato per consentire l'aggiornamento della lista.
    * @post Se il contatto è nuovo, viene creato e aggiunto alla rubrica; se esiste già, i suoi dati vengono aggiornati.
    *       I numeri di telefono e le email vengono convalidati e, se corretti, vengono associati al contatto.
    *       La lista dei contatti viene aggiornata e viene mostrato un messaggio di successo. Se ci sono errori, vengono mostrati dei messaggi di errore.
    *
    * @param[in] event L'evento che ha attivato l'azione di salvataggio del contatto.
    * @throws IOException Se si verifica un errore durante il passaggio alla vista della rubrica.
    */
    @FXML
    private void salvaContatto(ActionEvent event) throws IOException {
        if (tfdNome.getText().trim().isEmpty() && tfdCognome.getText().trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Errore di validazione");
            alert.setHeaderText("Nome e Cognome mancanti");
            alert.setContentText("Per favore, inserisci almeno il nome o il cognome.");
            alert.showAndWait();
            return;
        }
        
        if(contatto == null) {
            contatto = new Contatto(tfdNome.getText(),tfdCognome.getText());
        }else{
            contatto.setNome(tfdNome.getText());
            contatto.setCognome(tfdCognome.getText());
        }
        
        List<String> nuoviNumeri = new ArrayList<>();
        if (!tfdTelefono1.getText().isEmpty()) 
            nuoviNumeri.add(tfdTelefono1.getText());
        if (!tfdTelefono2.getText().isEmpty()) 
            nuoviNumeri.add(tfdTelefono2.getText());
        if (!tfdTelefono3.getText().isEmpty()) 
            nuoviNumeri.add(tfdTelefono3.getText());
        
        try{
            contatto.setNumTelefono(nuoviNumeri);      
        }catch(IllegalArgumentException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Errore numeri");
            alert.setHeaderText("Formato numero di telefono non valido");
            alert.setContentText("Inserire nuovamente il numero di telefono!");
    
            alert.showAndWait();
            return;
        }

        List<String> nuoveEmail = new ArrayList<>();
        if (!tfdEmail1.getText().isEmpty()) 
            nuoveEmail.add(tfdEmail1.getText());
        if (!tfdEmail2.getText().isEmpty()) 
            nuoveEmail.add(tfdEmail2.getText());
        if (!tfdEmail3.getText().isEmpty()) 
            nuoveEmail.add(tfdEmail3.getText());

        try{
            contatto.setEmail(nuoveEmail);
        }catch(IllegalArgumentException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Errore mail");
            alert.setHeaderText("Formato email non valido");
            alert.setContentText("Inserire nuovamente l'email!");
    
            alert.showAndWait();
            return;
        }
        
        rubrica.aggiungiContatto(contatto);
        
        rubricaViewController.aggiornaListaContatti();
        rubricaViewController.starter(rubrica);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Contatto salvato con successo!");
        alert.show();
        
        switchRubricaView(event);
    }

    /**
    * @brief Gestisce l'evento di annullamento dell'operazione corrente e ritorna alla vista della rubrica.
    * Questo metodo viene utilizzato per annullare l'operazione di creazione o modifica di un contatto
    * e mostra la lista dei contatti senza modifiche.
    *
    * @pre Nessuna.
    * @post La vista della rubrica viene ripristinata, senza alcuna modifica ai dati esistenti.
    *
    * @param[in] event L'evento che ha attivato l'azione di annullamento.
    * @throws IOException Se si verifica un errore durante il passaggio alla vista della rubrica.
    */
    @FXML
    private void annulla(ActionEvent event) throws IOException {
        switchRubricaView(event);
    }
    
    /**
    * @brief Gestisce il passaggio alla vista della rubrica, chiudendo la vista corrente.
    *
    * @pre Nessuna.
    * @post La finestra corrente viene chiusa e la vista della rubrica viene mostrata.
    *
    * @param[in] event L'evento che ha attivato l'azione di cambio vista.
    * @throws IOException Se si verifica un errore durante il caricamento della vista della rubrica.
    */
    public void switchRubricaView(ActionEvent event) throws IOException {
        
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();

        rubricaViewController.getStage().show();       
    }
   
}
