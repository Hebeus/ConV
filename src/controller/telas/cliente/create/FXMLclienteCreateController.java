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
    private TableView<Cliente> tableClientes;
    @FXML
    private TableColumn<Cliente, Boolean> selectCol;
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
    private Button listaAtual;
    private Cliente clienteSelecionado;
    private Event event;
    @FXML
    protected ListProperty<Cliente> listProperty = new SimpleListProperty<>();
    private List<Cliente> clientes;

    public FXMLclienteCreateController() {
        clienteSelecionado = new Cliente();
        clientes = new ArrayList<>();
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

        nomeCol.setCellFactory(
                TextFieldTableCell.forTableColumn());

        tableClientes.setItems(listaDeClientes());

    }

    private ObservableList<Cliente> listaDeClientes() {
        ClienteFacade clienteFacade = new ClienteFacade();
        clientes = clienteFacade.findClientes();
        return FXCollections.observableArrayList(clientes);
    }

    @FXML
    private void handleTextsFieldAction(ActionEvent event) {
        resultadoCreate.setText("sdfs");
    }

    @FXML
    private void verListaAction(ActionEvent event) {

        // TableView t = new TableView(FXCollections.observableArrayList());
        listProperty.set(FXCollections.observableArrayList());
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

//        Cliente c = (Cliente) selectCol.getUserData();
        //objeto que possui o comando sql de inserção
        ClienteFacade clienteFacade = new ClienteFacade();
        clienteFacade.InsertCliente(cliente);

        resultadoCreate.setText("Cliente Salvo");
        clientes.add(cliente);
        //Atualiza a lista de clientes na tela
        listProperty.set(FXCollections.observableArrayList(clientes));
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

    @FXML
    private void editNomeAction() {
        clienteSelecionado = tableClientes.getSelectionModel().getSelectedItem();
//        System.out.println("Cliente: " + clienteSelecionado.getRazaoSocial());
    }

    public void pegaNomeDoItemSelecionado() {

        tableClientes.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object oldValue, Object newValue) {
                //Check whether item is selected and set value of selected item to Label
                if (tableClientes.getSelectionModel().getSelectedItem() != null) {
                    TableViewSelectionModel selectionModel = tableClientes.getSelectionModel();
                    ObservableList selectedCells = selectionModel.getSelectedCells();
                    TablePosition tablePosition = (TablePosition) selectedCells.get(0);
                    Object val = tablePosition.getTableColumn().getCellData(newValue);
                    System.out.println("Selected Value" + val);
                }
            }
        });
    }
}

class EditingCell extends TableCell<Cliente, String> {

    private TextField textField;

    public EditingCell() {
    }

    @Override
    public void startEdit() {
        if (!isEmpty()) {
            super.startEdit();
            createTextField();
            setText(null);
            setGraphic(textField);
            textField.selectAll();
        }
    }

    @Override
    public void cancelEdit() {
        super.cancelEdit();

        setText((String) getItem());
        setGraphic(null);
    }

    @Override
    public void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);

        if (empty) {
            setText(null);
            setGraphic(null);
        } else if (isEditing()) {
            if (textField != null) {
                textField.setText(getString());
            }
            setText(null);
            setGraphic(textField);
        } else {
            setText(getString());
            setGraphic(null);
        }
    }

    private void createTextField() {
        textField = new TextField(getString());
        textField.setMinWidth(this.getWidth() - this.getGraphicTextGap() * 2);
        textField.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> arg0,
                    Boolean arg1, Boolean arg2) {
                if (!arg2) {
                    commitEdit(textField.getText());
                }
            }
        });
    }

    private String getString() {
        return getItem() == null ? "" : getItem().toString();
    }
}
