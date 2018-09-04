/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;


import entities.CategoriaProduto;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author wesle
 */
public class FXMLcontroller implements Initializable {

@FXML
    private Label label;
    @FXML
    private Button button;
    @FXML
    private MenuItem clienteMenuItem;
    private CategoriaProduto categoriaProduto;

    public FXMLcontroller() {
        //this.categoriaProduto = categoriaProduto;
    }
    
    
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        Parent root;
    try {
        root = FXMLLoader.load(getClass().getResource("telas/cliente/create/FXMLclienteCreate.fxml"));      
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
       //label.setText("Olá Mundo!");
    } catch (IOException ex) {
        Logger.getLogger(FXMLcontroller.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
    
//    public void telaCliente(Stage stage) throws Exception {
//        Parent root = FXMLLoader.load(getClass().getResource("../telas/FXMLconV.fxml"));
//        
//        Scene scene = new Scene(root);
//        
//        stage.setScene(scene);
//        stage.show();
//    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
}
