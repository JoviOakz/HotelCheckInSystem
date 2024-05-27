package com.jovioakz;

import java.net.URL;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class MainSceneController {
    
    // Vamos fazer uma função CreateScene que irá
    // criar a cena apartir de um FXMLLoader carregando
    // o .fxml.
    public static Scene CreateScene() throws Exception {
        URL sceneUrl = MainSceneController.class
                .getResource("main-page.fxml");
        Parent root = FXMLLoader.load(sceneUrl);
        Scene scene = new Scene(root);
        return scene;
    }

    @FXML
    private TableView<?> dataTable;
    
    @FXML
    private TableColumn<?, ?> tableClient;

    @FXML
    private TableColumn<?, ?> tableStart;

    @FXML
    private TableColumn<?, ?> tableEnd;

    @FXML
    private TableColumn<?, ?> checkIn;

    @FXML
    private TableColumn<?, ?> checkOut;


    @FXML
    protected void newBookingClick(ActionEvent e) {
        
    }

    @FXML
    protected void removeClick(ActionEvent e) {
        
    }
}