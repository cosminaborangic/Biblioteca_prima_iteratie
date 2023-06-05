package repository.orm.hibernate;

import domain.Farmacist;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import repository.IFarmacistRepository;

import java.util.List;

public class FarmacistRepository implements IFarmacistRepository {
    private static SessionFactory sessionFactory;

    public FarmacistRepository(){
    }

    @Override
    public Farmacist findByUserAndPass(String username, String password) {
        SessionFactory sessionFactory = HibernateSession.getSessionFactory();
        Farmacist farmacist = null;

        try(Session session = sessionFactory.openSession()){
            session.beginTransaction();
            List<Farmacist> librarians = session.createQuery("from Farmacist", Farmacist.class).list();
            for (Farmacist libr : librarians) {
                if(libr.getUsername().equals(username) && libr.getPassword().equals(password))
                    farmacist = new Farmacist(libr.getId(),libr.getUsername(),libr.getPassword(),libr.getFirst_name(), libr.getLast_name(),libr.getEmail());
            }
            session.getTransaction().commit();
        }

        if(farmacist != null)
            System.out.println(farmacist);
        else
            System.out.println("Farmacist null!!");

        HibernateSession.close();
        return farmacist;
    }

    @Override
    public Farmacist findOne(Integer integer) throws IllegalArgumentException {
        SessionFactory sessionFactory = HibernateSession.getSessionFactory();
        Farmacist farmacist = null;

        try(Session session = sessionFactory.openSession()){
            session.beginTransaction();
            List<Farmacist> librarians = session.createQuery("from Farmacist", Farmacist.class).list();
            for (Farmacist libr : librarians) {
                if(libr.getId().equals(integer))
                    farmacist = new Farmacist(libr.getId(),libr.getUsername(),libr.getPassword(),libr.getFirst_name(), libr.getLast_name(),libr.getEmail());
            }
            session.getTransaction().commit();
        }

        if(farmacist != null)
            System.out.println(farmacist);
        else
            System.out.println("Farmacist null!!");
        HibernateSession.close();
        return farmacist;
    }

    @Override
    public List<Farmacist> getAll() {
        SessionFactory sessionFactory = HibernateSession.getSessionFactory();
        try(Session  session = sessionFactory.openSession()){
            session.beginTransaction();
            List<Farmacist> farmacisti = session.createQuery("from Farmacist", Farmacist.class).list();

            if (!(farmacisti).isEmpty()) {
                for (Farmacist libr : farmacisti) {
                    if (libr != null) {
                        System.out.println(libr);
                    }
                }
            } else {
                System.out.println("Nu exista farmacisti in baza de date.");
            }
            session.getTransaction().commit();
            HibernateSession.close();
            return farmacisti;
        }
    }

    @Override
    public void clear() {

    }

    @Override
    public void save(Farmacist entity) {

    }

    @Override
    public void update(Farmacist entity) {

    }

    @Override
    public void delete(Integer integer) {

    }
}
