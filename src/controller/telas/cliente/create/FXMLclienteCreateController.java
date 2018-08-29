/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.telas.cliente.create;

import controller.FXMLcontroller;
import entities.Cliente;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import session.ClienteFacade;

/**
 * FXML Controller class
 *
 * @author wesle
 */

public class FXMLclienteCreateController implements Initializable {
    @FXML
    private TextField nome;
    @FXML
    private TextField cpf;
    @FXML
    private TextField tel1;
    @FXML
    private TextField tel2;
    @FXML
    private TextField endereco;
    @FXML
    private TextField cep;
    @FXML
    private Button button;
    @FXML
    private Label resultadoCreate;
    @FXML
    private ListView<Cliente> clientlist;
    @FXML
    private VBox vBox;
     protected ListProperty<Cliente> listProperty = new SimpleListProperty<>();
     private   List<Cliente> clientes;
    public FXMLclienteCreateController() {
        
       clientes = new ArrayList<>();
    }
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
         ClienteFacade clienteFacade = new ClienteFacade();
        // clientes = new ArrayList<>();
        clientes = clienteFacade.findClientes();
        clientlist.itemsProperty().bind(listProperty);
//        List<String> nomeClientes = new ArrayList<>();;;
//        for(Cliente c : clientes){
//            nomeClientes.add(c.getRazaoSocial());
//        }
        listProperty.set(FXCollections.observableArrayList(clientes));
     }  
    
    @FXML
    private void handleTextsFieldAction(ActionEvent event){
     resultadoCreate.setText("sdfs");
    
    }
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws InterruptedException {
        
        Cliente cliente = new Cliente();

        cliente.setRazaoSocial(nome.getText());
        cliente.setCpf(cpf.getText());
        cliente.setTelefone1(tel1.getText());
        cliente.setTelefone2(tel2.getText());
        cliente.setEndereco(endereco.getText());
        cliente.setCep(cep.getText());
        
        //objeto que possui o comando sql de inserção
        ClienteFacade clienteFacade = new ClienteFacade();
        clienteFacade.InsertCliente(cliente);
        
        resultadoCreate.setText("Cliente Salvo");
        clientes.add(cliente);
        //Atualiza a lista de clientes na tela
        listProperty.set(FXCollections.observableArrayList(clientes));
//         resultadoCreate.setText("");
        nome.setText("");
        cpf.setText("");
        tel1.setText("");
        tel2.setText("");
        endereco.setText("");
        cep.setText("");
       //label.setText("Olá Mundo!");

  
    }
}
