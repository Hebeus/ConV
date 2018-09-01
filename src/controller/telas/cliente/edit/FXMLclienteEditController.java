/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.telas.cliente.edit;

import entities.Cliente;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldTableCell;
import session.ClienteFacade;

/**
 * FXML Controller class
 *
 * @author wesle
 */
public class FXMLclienteEditController implements Initializable  {
    
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
    private TableColumn<Cliente, String> nomeCol;
    @FXML
    private TableView<Cliente> tableClientes;
    private List<Cliente> clientes;

    public FXMLclienteEditController() {
        clientes = new ArrayList<>();
        clientes = listaDeClientes();
    }
    /**
     * Initializes the controller class.
     */
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
    @FXML
    private void handleButtonAction(ActionEvent event)  {

        Cliente cliente = new Cliente();

        cliente.setRazaoSocial(nome.getText());
        cliente.setCpf(cpf.getText());
        cliente.setTelefone1(tel1.getText());
        cliente.setTelefone2(tel2.getText());
        cliente.setEndereco(endereco.getText());
        cliente.setCep(cep.getText());

//        Cliente c = (Cliente) selectCol.getUserData();
        //objeto que possui o comando sql de inserção
        ClienteFacade clienteFacade = new ClienteFacade();
        clienteFacade.UpdateCliente(cliente);

      //  resultadoCreate.setText("Cliente Salvo");
       // clientes.add(cliente);
        //Atualiza a lista de clientes na tela
       // listProperty.set(FXCollections.observableArrayList(clientes));
        tableClientes.setItems(listaDeClientes());
        nomeCol.setCellFactory(TextFieldTableCell.forTableColumn());
        tableClientes.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
//         resultadoCreate.setText("");
        nome.setText("");
        cpf.setText("");
        tel1.setText("");
        tel2.setText("");
        endereco.setText("");
        cep.setText("");
        //label.setText("Olá Mundo!");

    }
      private ObservableList<Cliente> listaDeClientes() {
        ClienteFacade clienteFacade = new ClienteFacade();
        clientes = clienteFacade.findClientes();
        return FXCollections.observableArrayList(clientes);
    }
    
}
