package repository;

import domain.Medic;

public interface IMedicRepository extends IRepository<Integer, Medic>{
    Medic findByUserAndPass(String username, String password);
}
