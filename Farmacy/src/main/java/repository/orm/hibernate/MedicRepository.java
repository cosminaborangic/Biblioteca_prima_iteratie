package repository.orm.hibernate;

import domain.Medic;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import repository.IMedicRepository;

import java.util.List;

public class MedicRepository implements IMedicRepository {
    private static SessionFactory sessionFactory;

    public MedicRepository(){}

    @Override
    public Medic findByUserAndPass(String username, String password) {
        SessionFactory sessionFactory = HibernateSession.getSessionFactory();
        Medic client = null;

        try(Session session = sessionFactory.openSession()){
            session.beginTransaction();
            List<Medic> clients = session.createQuery("from Medic", Medic.class).list();
            for (Medic cl : clients) {
                if(cl.getUsername().equals(username) && cl.getPassword().equals(password))
                    client = new Medic(cl.getId(),cl.getUsername(),cl.getPassword(),cl.getFirst_name(), cl.getLast_name(),cl.getSectie(),cl.getPhone_number());
            }
            session.getTransaction().commit();
        }

        if(client != null)
            System.out.println(client);
        else
            System.out.println("Client null!!");

        HibernateSession.close();
        return client;
    }

    @Override
    public Medic findOne(Integer integer) throws IllegalArgumentException {
        SessionFactory sessionFactory = HibernateSession.getSessionFactory();
        Medic client = null;

        try(Session session = sessionFactory.openSession()){
            session.beginTransaction();
            List<Medic> clients = session.createQuery("from Medic", Medic.class).list();
            for (Medic cl : clients) {
                if(cl.getId().equals(integer))
                    client = new Medic(cl.getId(),cl.getUsername(),cl.getPassword(),cl.getFirst_name(), cl.getLast_name(),cl.getSectie(),cl.getPhone_number());
            }
            session.getTransaction().commit();
        }

        if(client != null)
            System.out.println(client);
        else
            System.out.println("Client null!!");

        HibernateSession.close();
        return client;
    }

    @Override
    public List<Medic> getAll() {
        SessionFactory sessionFactory = HibernateSession.getSessionFactory();
        try(Session  session = sessionFactory.openSession()){
            session.beginTransaction();
            List<Medic> clients = session.createQuery("from Medic", Medic.class).list();

            if (!(clients).isEmpty()) {
                for (Medic cl : clients) {
                    if (cl != null) {
                        System.out.println(cl);
                    }
                }
            } else {
                System.out.println("Nu exista medici in baza de date.");
            }
            session.getTransaction().commit();
            HibernateSession.close();
            return clients;
        }
    }

    @Override
    public void clear() {

    }

    @Override
    public void save(Medic entity) {
        SessionFactory sessionFactory = HibernateSession.getSessionFactory();
        try(Session session = sessionFactory.openSession()) {
            Transaction tx = null;
            try {
                tx = session.beginTransaction();
                session.save(entity);
                tx.commit();
            } catch (RuntimeException ex) {
                HibernateSession.close();
                System.err.println("Eroare la inserare "+ex);
                if (tx != null)
                    tx.rollback();
            }
        }
        HibernateSession.close();
    }

    @Override
    public void update(Medic entity) {

    }

    @Override
    public void delete(Integer integer) {

    }
}
