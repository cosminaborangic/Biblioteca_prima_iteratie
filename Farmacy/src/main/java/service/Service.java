package service;

import domain.Medicament;
import domain.Medic;
import domain.Farmacist;
import domain.User;
import repository.IMedicamentRepository;
import repository.IMedicRepository;
import repository.IFarmacistRepository;

import java.util.List;

public class Service {
    private IMedicamentRepository medicamentRepository;
    private IMedicRepository medicRepository;
    private IFarmacistRepository farmacistRepository;

    public Service(IMedicamentRepository medicamentRepository, IMedicRepository medicRepository, IFarmacistRepository farmacistRepository) {
        this.medicamentRepository = medicamentRepository;
        this.medicRepository = medicRepository;
        this.farmacistRepository = farmacistRepository;
    }

    public User findUser(String username, String password){
        Medic cl = medicRepository.findByUserAndPass(username,password);
        if(cl != null){
            return cl;
        }
        Farmacist lr = farmacistRepository.findByUserAndPass(username,password);
        if(lr != null){
            return lr;
        }
        return null;
    }

    public void addMedicament(Medicament med){
        medicamentRepository.save(med);
    }

    public List<Medicament> getAllMedicamente(){
        return medicamentRepository.getAll();
    }


}
