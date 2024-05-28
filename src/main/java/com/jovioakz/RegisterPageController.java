package com.jovioakz;

import java.net.URL;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.jovioakz.model.BookingData;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
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

    @SuppressWarnings("deprecation")
    @FXML
    protected void submit(ActionEvent e) throws Exception {
        BookingData data = new BookingData();
   
       
        data.setCheckIn(tfCheckIn.getText());
        
        data.setCheckOut(tfCheckOut.getText());

        LocalDate start_date = dpStart.getValue();
        LocalDate end_date = dpEnd.getValue();

        data.setDataStart(new java.util.Date(start_date.getYear()-1900, start_date.getMonthValue()-1, start_date.getDayOfMonth()));
        data.setDataEnd(new java.util.Date(end_date.getYear()-1900, end_date.getMonthValue()-1, end_date.getDayOfMonth()));
        data.setClientName(tfName.getText());

        DataController.insertData(data);

        Stage thisStage = (Stage)tfName.getScene().getWindow();
        thisStage.close();

    }
}