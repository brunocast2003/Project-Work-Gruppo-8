/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.sen.gui;

import it.unisa.diem.sen.api.Contatto;
import it.unisa.diem.sen.api.Rubrica;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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
    public ContattoViewController(Contatto contatto, Rubrica rubrica, RubricaViewController rubricaViewController) {
    
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
        // TODO
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
    private void rimuoviContatto(ActionEvent event) {
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
    private void salvaContatto(ActionEvent event) {
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
    private void annulla(ActionEvent event) {
    }
    
    /**
     * @brief Consente di passare all'interfaccia RubricaView
     * 
     * @pre Nessuna.
     * @post Ritorno a RubricaView.
     * 
     * @see RubricaView
     */
    public void switchRubricaView() {
    }
   
}
