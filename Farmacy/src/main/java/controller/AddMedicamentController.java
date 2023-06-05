package controller;

import domain.Medicament;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import service.Service;

import java.io.IOException;
import java.util.Objects;

public class AddMedicamentController {
    private Service service;
    public void setService(Service service){
        this.service = service;
    }

    @FXML
    private TextField txtNume;

    @FXML
    private TextField txtCategorie;

    @FXML
    private TextField txtProspect;

    @FXML
    private TextField txtPret;

    @FXML
    void clickAddMedicament(MouseEvent event) throws IOException {
        if(Objects.equals(txtNume.getText(), "") && Objects.equals(txtCategorie.getText(), "") && Objects.equals(txtProspect.getText(), "") && Objects.equals(txtPret.getText(), "") ){
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Message.fxml"));
            Parent root = fxmlLoader.load();
            MessageController ctrl = fxmlLoader.getController();
            ctrl.setMessage("Trebuie completate toate campurile corect!");
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        }else{
            String nume = txtNume.getText();
            String categorie = txtCategorie.getText();
            String prospect = txtProspect.getText();
            int pret = 0;
            try{
                pret = Integer.parseInt(txtPret.getText());
                Medicament medicament = new Medicament(0,nume, categorie, prospect, pret);
                service.addMedicament(medicament);
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Message.fxml"));
                Parent root = fxmlLoader.load();
                MessageController ctrl = fxmlLoader.getController();
                ctrl.setMessage("Medicamentul a fost adaugat cu succes!");
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();

                txtNume.setText("");
                txtCategorie.setText("");
                txtProspect.setText("");
                txtPret.setText("");

            }catch (Exception e){
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Message.fxml"));
                Parent root = fxmlLoader.load();
                MessageController ctrl = fxmlLoader.getController();
                ctrl.setMessage("Trebuie completate toate campurile corect!");
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
            }
        }
    }
}
