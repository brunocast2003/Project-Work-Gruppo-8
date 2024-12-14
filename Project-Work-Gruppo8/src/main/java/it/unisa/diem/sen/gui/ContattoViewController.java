/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.sen.gui;

import it.unisa.diem.sen.api.Contatto;
import it.unisa.diem.sen.api.Rubrica;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
    private Label lblNome;
    @FXML
    private TextField tfdNome;
    @FXML
    private Label lblCognome;
    @FXML
    private Label lblTelefono1;
    @FXML
    private Label lblTelefono2;
    @FXML
    private Label lblTelefono3;
    @FXML
    private Label lblEmail1;
    @FXML
    private Label lblEmail2;
    @FXML
    private Label lblEmail3;
    @FXML
    private TextField tfdCognome;
    @FXML
    private TextField tfdTelefono1;
    @FXML
    private TextField tfdTelefono2;
    @FXML
    private TextField tfdTelefono3;
    @FXML
    private TextField tfdEmail1;
    @FXML
    private TextField tfdEmail2;
    @FXML
    private TextField tfdEmail3;
    @FXML
    private Button btnRimuoviContatto;
    @FXML
    private Button btnSalva;
    @FXML
    private Button btnAnnulla;
    
    private Contatto contatto;
    private Rubrica rubrica;
    private RubricaViewController rubricaViewController;

    private Stage stage;
    
    
    public void setStage(Stage stage) {
        this.stage = stage;
    }
    
    /**
     * @brief Crea un oggetto di ContattoViewController
     * 
     * @param contatto il contatto da visualizzare
     * @param rubrica la rubrica che contiene il contatto
     * @param rubricaViewController il controller dell'interfaccia della rubrica
     * 
     * @post un'istanza della classe ContattoViewController è inizializzato
     * 
     */
    public ContattoViewController() {
        
    }
    
    public void starter (Contatto contatto, Rubrica rubrica, RubricaViewController rubricaViewController) {
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
     * Inizializza i textfiled di ContattoView con i dati del contatto passato.
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
     * @brief Rimuove un contatto dalla rubrica.
     * 
     * @param event L'evento generato dalla selezione del bottone.
     * 
     * @pre Nessuna.
     * @post Il contatto, se esiste, è rimosso dalla rubrica.
     * 
     * @see RubricaView
     */
    @FXML
    private void rimuoviContatto(ActionEvent event) throws IOException {
        rubrica.rimuoviContatto(contatto);
        rubricaViewController.aggiornaListaContatti();
        rubricaViewController.starter(rubrica);
        switchRubricaView(event);
    }

    /**
     * @brief Aggiunge/modifica contatto e ritorna a RubricaView.
     * 
     * @param event L'evento generato dalla selezione del bottone.
     * 
     * @pre Nessuna.
     * @post Il contatto è salvato in rubrica.
     * 
     * @see RubricaView
     */
    @FXML
    private void salvaContatto(ActionEvent event) throws IOException {
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
        
        contatto.setNumTelefono(nuoviNumeri);

        List<String> nuoveEmail = new ArrayList<>();
        if (!tfdEmail1.getText().isEmpty()) 
            nuoveEmail.add(tfdEmail1.getText());
        if (!tfdEmail2.getText().isEmpty()) 
            nuoveEmail.add(tfdEmail2.getText());
        if (!tfdEmail3.getText().isEmpty()) 
            nuoveEmail.add(tfdEmail3.getText());

        contatto.setEmail(nuoveEmail);
        
        rubrica.aggiungiContatto(contatto);
        
        rubricaViewController.aggiornaListaContatti();
        rubricaViewController.starter(rubrica);

        switchRubricaView(event);
    }

    /**
     * @brief Annulla l'operazione e ritorna a RubricaView.
     * @param event L'evento generato dalla selezione del bottone.
     * 
     * @pre Nessuna.
     * @post Ritorno a RubricaView.
     * 
     * @see RubricaView
     */
    @FXML
    private void annulla(ActionEvent event) throws IOException {
        switchRubricaView(event);
    }
    
    /**
     * @brief Consente di passare all'interfaccia RubricaView
     * 
     * @pre Nessuna.
     * @post Ritorno a RubricaView.
     * 
     * @see RubricaView
     */
    public void switchRubricaView(ActionEvent event) throws IOException {
        
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();

        // Mostra la finestra precedente (RubricaViewController)
        rubricaViewController.getStage().show();
        
    }
   
}
