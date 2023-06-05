package controller;

import domain.Medic;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import service.Service;

public class MedicController {
    private Medic medic;
    public void setMedic(Medic medic){
        this.medic = medic;
        welcomeLabel.setText("Welcome "+ medic.getFirst_name() + " " + medic.getLast_name());
    }

    private Service service;
    public void setService(Service service){
        this.service = service;
    }

    @FXML
    private Label welcomeLabel;

    @FXML
    void clickComandaMedicamente(MouseEvent event) {

    }

    @FXML
    void clickViewComenzi(MouseEvent event) {

    }

}
