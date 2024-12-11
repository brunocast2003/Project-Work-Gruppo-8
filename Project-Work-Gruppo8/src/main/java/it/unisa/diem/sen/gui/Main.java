/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.sen.gui;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @brief Classe main.
 * 
 * @author Castellano Bruno
 * @author Grieco Giovanni
 * @author Giachetta Corradomaria
 * @author Di Carluccio Alesssandro
 * 
 * @date December 07, 2024
 */
public class Main extends Application{

    /**
    * @brief Sovrascrive il metodo start della classe {@link javafx.application.Application}.
    * 
    * Questo metodo serve per avviare l'interfaccia utente dell'applicazione.
    * 
    * @param primaryStage Lo stage principale per questa applicazione
    * 
    * @see RubricaViewController
    */ 
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/it/unisa/diem/sen/gui/RubricaView.fxml"));
        
        Scene scene = new Scene(root);
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}