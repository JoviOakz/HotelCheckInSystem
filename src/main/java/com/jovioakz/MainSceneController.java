package com.jovioakz;

import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Predicate;

import javax.annotation.Resources;

import com.jovioakz.model.BookingData;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class MainSceneController implements Initializable {

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
    private TableView<BookingData> dataTable;

    @FXML
    private TableColumn<BookingData, String> tableClient;

    @FXML
    private TableColumn<BookingData, String> tableStart;

    @FXML
    private TableColumn<BookingData, String> tableEnd;

    @FXML
    private TableColumn<BookingData, String> checkIn;

    @FXML
    private TableColumn<BookingData, String> checkOut;

    @FXML
    private TextField tbSearch;

    @FXML
    protected void newBookingClick(ActionEvent e) {
        try {
            Stage newStage = new Stage();
            Scene scene = RegisterPageController.CreateScene();

            newStage.setScene(scene);
            newStage.setTitle("Registro de reservas");

            newStage.showAndWait();

            loadDataTable();
            
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    @FXML
    protected void removeClick(ActionEvent e) {
        BookingData data = dataTable.getSelectionModel().getSelectedItem();

        if (data == null) {
            Alert alert = new Alert(AlertType.ERROR);

            alert.setTitle("Error");
            alert.setContentText("Selecione um dado!");

            alert.showAndWait();
            return;
        }

        DataController.removeData(data);

        loadDataTable();
    }

    @SuppressWarnings("deprecation")
    private String getDataString(Date date) {
        String value = String.format("%02d/%02d/%04d", date.getDate(), date.getMonth()+1, date.getYear()+1900);

        return value;
    }

    private ObservableList<BookingData> principalList = FXCollections.observableArrayList();

    private void loadDataTable() {
        principalList.clear();
        List<BookingData> data = DataController.getBookings();

        for (BookingData d : data) {
            principalList.add(d);
        }

        dataTable.refresh();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tableClient.setCellValueFactory(x -> new SimpleStringProperty(x.getValue().getClientName()));
        tableStart.setCellValueFactory(x -> new SimpleStringProperty(getDataString(x.getValue().getDataStart())));
        tableEnd.setCellValueFactory(x -> new SimpleStringProperty(getDataString(x.getValue().getDataEnd())));
        checkIn.setCellValueFactory(x -> new SimpleStringProperty(x.getValue().getCheckIn()));
        checkOut.setCellValueFactory(x -> new SimpleStringProperty(x.getValue().getCheckOut()));
        dataTable.setItems(principalList);
        loadDataTable();

    }

    @FXML
    protected void tbSearchPress(KeyEvent e) {
        String value = tbSearch.getText().toLowerCase();

        FilteredList<BookingData> filteredList = new FilteredList<>(principalList);

        dataTable.setItems(filteredList);

        filteredList.setPredicate(new Predicate<BookingData>() {
            public boolean test(BookingData b) {
                if (b.getClientName().toLowerCase().contains(value))
                    return true;
                
                return false;
            }
        });
    }
}