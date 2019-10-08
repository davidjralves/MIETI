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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author andre
 */
public class EdituserController implements Initializable {

    @FXML
    private AnchorPane root;
    @FXML
    private TextField nome;
    @FXML
    private TextField tipo;
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private TextField id;
    @FXML
    private TextField email;
    @FXML
    private TextField dataaniversario;
    @FXML
    private TextField dataregisto;
    @FXML
    private TextField morada;
    @FXML
    private TextArea respostaedituser;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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

    @FXML
    private void sendedituser(ActionEvent event) throws IOException, NoSuchAlgorithmException, KeyManagementException {

   
    ArrayList<String> User = new ArrayList<>();
        String[] trama = new String[10] ;
        trama[0]= "editUser";
        trama[1]= id.getText();
        trama[2]= nome.getText();
        trama[3]= tipo.getText();
        trama[4]= username.getText();
        trama[5]= email.getText();
        trama[6]=password.getText();
        trama[7]= morada.getText();
        trama[8]= dataaniversario.getText();
        trama[9]= dataregisto.getText();
        for (int i=0;i<10;i++) {
            User.add(trama[i]);
        }  
       
    
        
          Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Mensagem de Confirmação");
        alert.setHeaderText("Atenção!");
        alert.setContentText("Tem a certeza que pretendia pretende editar?");

        ButtonType buttonTypeOne = new ButtonType("Sim");
        ButtonType buttonTypeTwo = new ButtonType("Não");

        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonTypeOne){
            Client cli = new Client();
            String res = cli.criarcli(User);
            User.clear();  
            respostaedituser.setText(res);
            // ... user chose "One"
        } else if (result.get() == buttonTypeTwo) {
            // ... user chose "Two"
        }
        }

    private void loadalerttype(ActionEvent event) throws IOException {
        AnchorPane pane= FXMLLoader.load(getClass().getResource("AddalerttypeController.fxml"));
        root.getChildren().setAll(pane);
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


