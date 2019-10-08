/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interface3;

import java.io.IOException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author andre
 */
public class AddalertController implements Initializable {
    @FXML
    private AnchorPane root;
    @FXML
    private TextField respostaaddalerta;
    @FXML
    private TextField nome;
    private TextField ipdestino;
    @FXML
    private TextField idlocal;
    @FXML
    private TextField iduser;
    @FXML
    private TextField iporigem;
    @FXML
    private ChoiceBox tipodealerta;
    
    ObservableList<String>opcoestipos = FXCollections.observableArrayList(
"1 - Meteorologia",
"2 - Obras",
"3 - Ambulância",
"4 - Acidente",
"5 - Trânsito");
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tipodealerta.setValue("Opções");
        tipodealerta.setItems(opcoestipos);
    }    

    @FXML
    private void loadaddlocal(ActionEvent event) throws IOException {
        AnchorPane pane= FXMLLoader.load(getClass().getResource("addlocal.fxml"));
        root.getChildren().setAll(pane);
    }
    @FXML
    private void loadadduser(ActionEvent event) throws IOException {
         AnchorPane pane= FXMLLoader.load(getClass().getResource("adduser.fxml"));
        root.getChildren().setAll(pane);
    }
    @FXML
    private void loadaddalerta(ActionEvent event) throws IOException {
         AnchorPane pane= FXMLLoader.load(getClass().getResource("addalert.fxml"));
        root.getChildren().setAll(pane);
    }
    @FXML
    private void loadedituser(ActionEvent event) throws IOException {
         AnchorPane pane= FXMLLoader.load(getClass().getResource("edituser.fxml"));
        root.getChildren().setAll(pane);
    }

    @FXML
    private void loadeditlocal(ActionEvent event) throws IOException {
         AnchorPane pane= FXMLLoader.load(getClass().getResource("editlocal.fxml"));
        root.getChildren().setAll(pane);
    }
    @FXML
    private void loadeditalert(ActionEvent event) throws IOException {
         AnchorPane pane= FXMLLoader.load(getClass().getResource("editalerta.fxml"));
        root.getChildren().setAll(pane);
    }
    
    @FXML
    private void loadrmalert(ActionEvent event) throws IOException {
         AnchorPane pane= FXMLLoader.load(getClass().getResource("rmalert.fxml"));
        root.getChildren().setAll(pane);
    }
    @FXML
    private void loadrmlocal(ActionEvent event) throws IOException {
         AnchorPane pane= FXMLLoader.load(getClass().getResource("rmlocal.fxml"));
        root.getChildren().setAll(pane);
    }
    @FXML
    private void loadrmuser(ActionEvent event) throws IOException {
         AnchorPane pane= FXMLLoader.load(getClass().getResource("rmuser.fxml"));
        root.getChildren().setAll(pane);
    }
    @FXML
    private void loadviewlocal(ActionEvent event) throws IOException {
        AnchorPane pane= FXMLLoader.load(getClass().getResource("viewlocal.fxml"));
        root.getChildren().setAll(pane);
    }
    
    @FXML
    private void loadviewalert(ActionEvent event) throws IOException {
         AnchorPane pane= FXMLLoader.load(getClass().getResource("viewalert.fxml"));
        root.getChildren().setAll(pane);
    }
    @FXML
    private void loadviewuser(ActionEvent event) throws IOException {
         AnchorPane pane= FXMLLoader.load(getClass().getResource("viewuser.fxml"));
        root.getChildren().setAll(pane);
    }

    @FXML
    private void loadviewsusers(ActionEvent event) throws IOException {
         AnchorPane pane= FXMLLoader.load(getClass().getResource("viewalluser.fxml"));
        root.getChildren().setAll(pane);
    }
    @FXML
    private void loadviewslocals(ActionEvent event) throws IOException {
         AnchorPane pane= FXMLLoader.load(getClass().getResource("viewalllocal.fxml"));
        root.getChildren().setAll(pane);
    }
    @FXML
    private void loadviewsalert(ActionEvent event) throws IOException {
         AnchorPane pane= FXMLLoader.load(getClass().getResource("viewallalerts.fxml"));
        root.getChildren().setAll(pane);
    }
    
    //1- METEOROLOGIA
    //2- OBRAS
    //3- AMBULANCIA
    //4- ACIDENTE
    //5- TRANSITO

    @FXML
    private void sendaddalert(ActionEvent event) throws IOException, NoSuchAlgorithmException, KeyManagementException {


        String tipo = null;
        String value = (String)tipodealerta.getValue();
        if(value == "1 - Meteorologia"){
            tipo = "1";
        }
        if (value == "2 - Obras"){
            tipo = "2";

            }
        if (value == "3 - Ambulância"){
            tipo = "3";

        }
        if (value == "4 - Acidente"){
            tipo = "4";

        }
        if (value == "5 - Trânsito"){
            tipo = "5";

        }


    

        ArrayList<String> User = new ArrayList<>();
        String[] trama = new String[7] ;
        trama[0]= "addAlerta";  
        trama[1]= nome.getText();
        trama[2]= "1";
        trama[3]= iporigem.getText();
        trama[4]= idlocal.getText();
        trama[5]= tipo;
        trama[6]= iduser.getText();
        for (int i=0;i<7;i++) {
            User.add(trama[i]);
        } 
         Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Mensagem de Confirmação");
        alert.setHeaderText("Atenção!");
        alert.setContentText("Tem a certeza que pretende abandonar a sessão?");

        ButtonType buttonTypeOne = new ButtonType("Sim");
        ButtonType buttonTypeTwo = new ButtonType("Não");

        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonTypeOne){
            Client cli = new Client();
                String res = cli.criarcli(User);
                User.clear();  
                respostaaddalerta.setText(res);
            // ... user chose "One"
        } else if (result.get() == buttonTypeTwo) {
            // ... user chose "Two"
        }
        }

    @FXML
    private void logoutbt(ActionEvent event) throws IOException {
        Alert logoutalt = new Alert(Alert.AlertType.CONFIRMATION);
        logoutalt.setTitle("Mensagem de Confirmação");
        logoutalt.setHeaderText("Atenção!");
        logoutalt.setContentText("Tem a certeza que pretende adicionar?");

        ButtonType losim = new ButtonType("Sim");
        ButtonType lonao = new ButtonType("Não");

        logoutalt.getButtonTypes().setAll(losim, lonao);

        Optional<ButtonType> resultados = logoutalt.showAndWait();
        if (resultados.get() == losim){
           
        AnchorPane pane= FXMLLoader.load(getClass().getResource("Login.fxml"));
        root.getChildren().setAll(pane);
            
            // ... user chose "One"
        } else if (resultados.get() == lonao) {
            // ... user chose "Two"
        }
    }
    
        

    }



