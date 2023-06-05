package repository;

import domain.Farmacist;

public interface IFarmacistRepository extends IRepository<Integer, Farmacist>{
    Farmacist findByUserAndPass(String username, String password);
}
