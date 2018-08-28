/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;


import entities.CategoriaProduto;
import entities.Produto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import session.CategoriaProdutoFacade;
import session.ProdutoFacade;

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


    public static void main(String[] args) throws SQLException {
      
         ProdutoFacade produtoFacade = new ProdutoFacade();
         List<Produto> pList =produtoFacade.findProdutoByCategoria(1);      
       //ProdutoFacade produtoFacade = new ProdutoFacade();
//       ProdutoFacade produtoFacade = new UssFacade();
//         List<Uss> pList =produtoFacade.findByDescricao("test");
//       String buscaProduto = "SELECT p FROM Produto p where p.des"; 
//        EntityManager entityManager;
//     //  Query query = 
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
