package controller;

import domain.Medicament;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import service.Service;

public class ViewMedicamenteController {
    private Service service;
    public void setService(Service service){
        this.service = service;
        getMedicamente();

    }

    public void getMedicamente(){
        clmId.setCellValueFactory(new PropertyValueFactory<Medicament,Integer>("id"));
        clmNume.setCellValueFactory(new PropertyValueFactory<Medicament,String>("nume"));
        clmCategorie.setCellValueFactory(new PropertyValueFactory<Medicament,String>("categorie"));
        clmProspect.setCellValueFactory(new PropertyValueFactory<Medicament,String>("prospect"));
        clmPret.setCellValueFactory(new PropertyValueFactory<Medicament,Integer>("pret"));
        for(Medicament medicament: service.getAllMedicamente()){
            medicamente.add(medicament);
        }
        tabelMedicamente.setItems(medicamente);
    }
    @FXML
    private TableView<Medicament> tabelMedicamente;

    @FXML
    private TableColumn<Medicament, Integer> clmId;

    @FXML
    private TableColumn<Medicament, String> clmNume;

    @FXML
    private TableColumn<Medicament, String> clmCategorie;

    @FXML
    private TableColumn<Medicament, String> clmProspect;

    @FXML
    private TableColumn<Medicament, Integer> clmPret;

    ObservableList<Medicament> medicamente = FXCollections.observableArrayList();
}
