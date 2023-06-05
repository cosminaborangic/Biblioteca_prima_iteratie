package ui;

import controller.LoginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import repository.orm.hibernate.MedicamentRepository;
import repository.orm.hibernate.MedicRepository;
import repository.orm.hibernate.FarmacistRepository;
import service.Service;

public class MainFX extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        MedicamentRepository medRepository = new MedicamentRepository();
        MedicRepository medicRepository = new MedicRepository();
        FarmacistRepository farmacistRepository = new FarmacistRepository();

        Service service = new Service(medRepository,medicRepository,farmacistRepository);

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/LoginView.fxml"));
            Parent root = loader.load();
            LoginController ctrl = loader.getController();
            ctrl.setService(service);
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Hello");
            primaryStage.show();
        }catch(Exception e){
            System.out.println(e);
        }

    }
}
