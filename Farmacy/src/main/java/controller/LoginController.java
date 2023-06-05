package controller;

import domain.Medic;
import domain.Farmacist;
import domain.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import service.Service;

import java.io.IOException;

public class LoginController {
    private Service service;

    public void setService(Service service){
        this.service = service;
    }

    @FXML
    private TextField txtUsername;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private Button btnLogin;

    @FXML
    void loginClick(MouseEvent event) throws IOException {
        String username = txtUsername.getText();
        String password = txtPassword.getText();
        User user = service.findUser(username,password);
        if(user instanceof Medic){
            Stage st = (Stage) btnLogin.getScene().getWindow();
            st.close();

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/MedicView.fxml"));
            Parent root = fxmlLoader.load();
            MedicController ctrl = fxmlLoader.getController();
            ctrl.setService(this.service);
            ctrl.setMedic((Medic) user);
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Welcome " + ((Medic) user).getLast_name());
            stage.show();
        }
        else if(user instanceof Farmacist){
            Stage st = (Stage) btnLogin.getScene().getWindow();
            st.close();

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FarmacistView.fxml"));
            Parent root = fxmlLoader.load();
            FarmacistController ctrl = fxmlLoader.getController();
            ctrl.setService(this.service);
            ctrl.setFarmacist((Farmacist) user);
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Welcome " + ((Farmacist) user).getLast_name());
            stage.show();

        }
        else{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Message.fxml"));
            Parent root = fxmlLoader.load();
            MessageController ctrl = fxmlLoader.getController();
            ctrl.setMessage("Datele de conectare sunt gresite!");
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            txtPassword.setText("");
            txtUsername.setText("");
        }

    }

}
