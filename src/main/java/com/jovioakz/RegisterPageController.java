package com.jovioakz;

import java.net.URL;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
// import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegisterPageController {
    
    // Vamos fazer uma função CreateScene que irá
    // criar a cena apartir de um FXMLLoader carregando
    // o .fxml.
    public static Scene CreateScene() throws Exception {
        URL sceneUrl = RegisterPageController.class.getResource("register-page.fxml");
        Parent root = FXMLLoader.load(sceneUrl);
        Scene scene = new Scene(root);
        return scene;
    }

    // Variáveis que representam os componentes
    // Note que id/field devem ser iguais ao nome
    // que aparece aqui.
    @FXML
    protected Button btConfirm;

    @FXML
    protected TextField tfName;

    @FXML
    protected DatePicker dpStart;

    @FXML
    protected DatePicker dpEnd;

    @FXML
    protected TextField tfCheckIn;

    @FXML
    protected TextField tfCheckOut;

    @FXML
    protected void submit(ActionEvent e) throws Exception {
        
        

        // Fechando o register
        Stage crrStage = (Stage) btConfirm.getScene().getWindow();
        crrStage.close();
    }
}