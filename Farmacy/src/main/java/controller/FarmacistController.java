package controller;

import domain.Farmacist;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import service.Service;

import java.io.IOException;


public class FarmacistController {
    private Farmacist farmacist;
    public void setFarmacist(Farmacist farmacist){
        this.farmacist= farmacist;
    }

    private Service service;
    public void setService(Service service){
        this.service = service;
    }

    @FXML
    void clickAddMedicament(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/AddMedicamentView.fxml"));
        Parent root = fxmlLoader.load();
        AddMedicamentController ctrl = fxmlLoader.getController();
        ctrl.setService(service);
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void clickAddMedic(MouseEvent event) {

    }

    @FXML
    void clickDeleteMedicament(MouseEvent event) {

    }

    @FXML
    void clickDeleteMedic(MouseEvent event) {

    }

    @FXML
    void clickUpdateMedic(MouseEvent event) {

    }

    @FXML
    void clickViewMedicamente(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ViewMedicamenteView.fxml"));
        Parent root = fxmlLoader.load();
        ViewMedicamenteController ctrl = fxmlLoader.getController();
        ctrl.setService(service);
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void clickViewMedici(MouseEvent event) {

    }

}

