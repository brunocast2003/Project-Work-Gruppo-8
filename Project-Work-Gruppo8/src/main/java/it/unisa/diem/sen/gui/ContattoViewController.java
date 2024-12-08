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
 * @author ggrie
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
    
    public ContattoViewController(Contatto contatto, Rubrica rubrica, RubricaViewController rubricaViewController) {
    
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void rimuoviContatto(ActionEvent event) {
    }

    @FXML
    private void salvaContatto(ActionEvent event) {
    }

    @FXML
    private void annulla(ActionEvent event) {
    }
    
    public void switchRubricaView() {
    }
   
}
