package com.jovioakz;

import java.net.URL;
import java.sql.Date;
import java.sql.Time;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.jovioakz.model.BookingData;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

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
   
        String[] value = tfCheckIn.getText().split(":");
        List<Integer> checkIn = Arrays.asList(value)
            .stream()
            .map(x -> Integer.parseInt(x))
            .collect(Collectors.toList());
        
        data.setCheckIn(new Time(checkIn.get(0), checkIn.get(1), 0));

        List<Integer> checkOut = Arrays.asList(tfCheckOut.getText().split(":"))
            .stream()
            .map(x -> Integer.parseInt(x))
            .collect(Collectors.toList());
        
        data.setCheckOut(new Time(checkOut.get(0), checkOut.get(1), 0));

        data.setDataStart(new Date(dpStart.getValue().toEpochDay()));
        data.setDataEnd(new Date(dpEnd.getValue().toEpochDay()));
        data.setClientName(tfName.getText());

        DataController.insertData(data);
    }
}