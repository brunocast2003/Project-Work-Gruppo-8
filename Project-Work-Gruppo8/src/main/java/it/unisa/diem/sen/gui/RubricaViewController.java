/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.sen.gui;

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
 * FXML Controller class
 *
 * @author ggrie
 */
public class RubricaViewController implements Initializable {

    @FXML
    private TextField barraRicerca;
    @FXML
    private ListView<String> listaContatti;
    @FXML
    private Button btnAggiungiContatto;
    @FXML
    private MenuItem caricaRubrica;
    @FXML
    private MenuItem salvaRubrica;
    @FXML
    private MenuItem esci;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void aggiungiContatto(ActionEvent event) {
    }

    @FXML
    private void caricaRubrica(ActionEvent event) {
    }

    @FXML
    private void salvaRubrica(ActionEvent event) {
    }

    @FXML
    private void esci(ActionEvent event) {
    }

    @FXML
    private void switchContattoView(MouseEvent event) {
    }
    
}
