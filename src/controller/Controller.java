/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.CategoriaProduto;
/**
 *
 * @author wesle
 */
public class Controller extends Application {
    
//    private static final int JFXPANEL_WIDTH_INT = 300;
//    private static final int JFXPANEL_HEIGHT_INT = 250;
//    private static JFXPanel fxContainer;
private static CategoriaProduto categoriaProduto;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        categoriaProduto = new CategoriaProduto("grãos");
        
        System.out.println("leon");
        launch(args);
    }
    
   
        @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../telas/FXMLconV.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }
}
