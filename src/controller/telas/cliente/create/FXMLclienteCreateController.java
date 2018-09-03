/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.telas.cliente.create;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import controller.FXMLcontroller;
import entities.Cliente;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.util.Callback;
import org.eclipse.persistence.jpa.jpql.parser.UpdateItem;
import session.ClienteFacade;

/**
 * FXML Controller class
 *
 * @author wesle
 */
public class FXMLclienteCreateController extends Application implements Initializable {

    @FXML
    private Label nomeView;
    @FXML
    private Label cpfView;
    @FXML
    private Label tel1View;
    @FXML
    private Label tel2View;
    @FXML
    private Label enderecoView;
    @FXML
    private Label cepView;
    @FXML
    private TextField nomeEdit;
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
    private TableView<Cliente> tableClientes;
    @FXML
    private TableColumn<Cliente, String> nomeCol;
    @FXML
    private TableColumn<Cliente, String> cpfCol;
    @FXML
    private TableColumn<Cliente, String> numeroCol;
    @FXML
    private TableColumn<Cliente, String> enderecoCol;
    @FXML
    private TableColumn<Cliente, String> cepCol;
    @FXML
    private Button botaoEdit;
    @FXML
    private Button botaoDelete;
    private Cliente clienteSelecionado;
    @FXML
    protected ListProperty<Cliente> listProperty = new SimpleListProperty<>();
    private List<Cliente> clientes;
    private final ClienteFacade clienteFacade;
    private final ClienteFacade clienteFacadeBusca;
    
    
    public FXMLclienteCreateController() {
        clienteSelecionado = new Cliente();
        clientes = new ArrayList<>();
        clienteFacadeBusca = new ClienteFacade();
        clienteFacade = new ClienteFacade();
        clientes = listaDeClientes();
    }

    @Override
    public void start(Stage stage) {

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        nomeCol.setCellValueFactory(
                new PropertyValueFactory<>("razaoSocial"));
        cpfCol.setCellValueFactory(
                new PropertyValueFactory<>("cpf"));
        numeroCol.setCellValueFactory(
                new PropertyValueFactory<>("telefone1"));
        enderecoCol.setCellValueFactory(
                new PropertyValueFactory<>("endereco"));
        cepCol.setCellValueFactory(
                new PropertyValueFactory<>("cep"));

        tableClientes.setItems(listaDeClientes());

    }
    /*
        Método que pega no banco a lista de clientes
    */
    private ObservableList<Cliente> listaDeClientes() {
        clientes = clienteFacadeBusca.findClientes();
        return FXCollections.observableArrayList(clientes);
    }

    //Evento chamado quando um novo cliente é criado apertando no botão de 
    //salvar na aba 'cliente'
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
        clienteFacade.InsertCliente(cliente);

        resultadoCreate.setText("Cliente Salvo");
        clientes.add(cliente);
        //Atualiza a lista de clientes na tela
//        listProperty.set(FXCollections.observableArrayList(clientes));
        tableClientes.setItems(listaDeClientes());
        nomeCol.setCellFactory(TextFieldTableCell.forTableColumn());
        tableClientes.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        nome.setText("");
        cpf.setText("");
        tel1.setText("");
        tel2.setText("");
        endereco.setText("");
        cep.setText("");
    }
    /**
     * Ao clicar em um cliente na tabela, o clinete clicado é armazenado no
     * atributo 'clienteSelecionado' Serve para poder pegar um cliente exibir
     * sua fixa na tela ao lado e para poder edita-lo futuramente.
     */
    @FXML
    private void selecionaClienteAction() {
        clienteSelecionado = tableClientes.getSelectionModel().getSelectedItem();
        nomeView.setText(clienteSelecionado.getRazaoSocial());
        cpfView.setText(clienteSelecionado.getCpf());
        tel1View.setText(clienteSelecionado.getTelefone1());
        tel2View.setText(clienteSelecionado.getTelefone2());
        enderecoView.setText(clienteSelecionado.getEndereco());
        cepView.setText(clienteSelecionado.getCep());
        nomeEdit.setText(clienteSelecionado.getRazaoSocial());
    }
    
    @FXML
    private void editaClienteAction(ActionEvent event){       
        /*Alternado o nome do botão para "salvar".
        quando o botão "editar" é apertado ele alterna seu nome para 
        "salvar". 
        */
        if (botaoEdit.getText().equals("Editar")) {
            botaoEdit.setText("Salvar");
            botaoEdit.setTextFill(Paint.valueOf("#0a9331"));
            //atualiza a ficha
            selecionaClienteAction();
            botaoDelete.setText("Cancelar");
            botaoDelete.setTextFill(Paint.valueOf("#9d650b"));
            tableClientes.setItems(listaDeClientes());
            editTextVisibilidade(true);

        }
        /*Alternado o nome do botão para "editar".
        quando o botão "salvar" é apertado ele alterna seu nome para 
        "editar". 
        */        
        else if (botaoEdit.getText().equals("Salvar")) {

            botaoEdit.setText("Editar");
            botaoEdit.setTextFill(Paint.valueOf("#279ecd"));
            botaoDelete.setText("Deletar");
            botaoDelete.setTextFill(Paint.valueOf("#ba4423"));
            editTextVisibilidade(false);

            //Atualiza a instancia do cliente que está atualmente selecionado
            atualizaDados();
            //Atualiza os Label referente a cada atributo do cliente
            atualizaTelaFixa();
            
            //Atualiza os dados do cliente no banco
            clienteFacade.UpdateCliente(clienteSelecionado);
            
            /*
            -Atualiza os dados da tabela;
            -@listaDeClientes() faz a busca no banco e retorna a lista de
            clientes atualizada.
            */
            tableClientes.setItems(listaDeClientes());
            tableClientes.refresh();
        }
    }
    @FXML
    private void deletaClienteAction(ActionEvent actionEvent){
        if(botaoDelete.getText().equals("Cancelar")){
            botaoEdit.setText("Editar");
            botaoDelete.setText("Deletar");
            editTextVisibilidade(false);
            botaoDelete.setTextFill(Paint.valueOf("#ba4423"));
            
        }
    }
    
    //Atualiza a instancia do cliente que está atualmente selecionado
    private void atualizaDados(){
        clienteSelecionado.setRazaoSocial(nomeEdit.getText());
    
    }
    //Atualiza os Label referente a cada atributo do cliente
    private void atualizaTelaFixa(){
        nomeView.setText(nomeEdit.getText());    
    }
    private void editTextVisibilidade(boolean v){
          nomeEdit.setVisible(v);
    }
}