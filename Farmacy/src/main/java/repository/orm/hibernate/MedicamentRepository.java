package repository.orm.hibernate;

import domain.Medicament;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import repository.IMedicamentRepository;

import java.util.List;

public class MedicamentRepository implements IMedicamentRepository {

    public MedicamentRepository(){}

    @Override
    public Medicament findOne(Integer integer) throws IllegalArgumentException {
        SessionFactory sessionFactory = HibernateSession.getSessionFactory();
        Medicament medicament = null;

        try(Session session = sessionFactory.openSession()){
            session.beginTransaction();
            List<Medicament> medicaments = session.createQuery("from Medicament", Medicament.class).list();
            for (Medicament bk : medicaments) {
                if(bk.getId().equals(integer))
                    medicament  = new Medicament(bk.getId(),bk.getNume(),bk.getCategorie(),bk.getProspect(),bk.getPret());
            }
            session.getTransaction().commit();
        }

        if(medicament  != null)
            System.out.println(medicament);
        else
            System.out.println("Book null!!");

        HibernateSession.close();
        return medicament ;
    }

    @Override
    public List<Medicament> getAll() {
        SessionFactory sessionFactory = HibernateSession.getSessionFactory();
        try(Session  session = sessionFactory.openSession()){
            session.beginTransaction();
            List<Medicament> medicaments = session.createQuery("from Medicament", Medicament.class).list();

            if (!(medicaments).isEmpty()) {
                for (Medicament bk : medicaments) {
                    if (bk != null) {
                        System.out.println(bk);
                    }
                }
            } else {
                System.out.println("Nu exista medicamente in baza de date.");
            }
            session.getTransaction().commit();
            HibernateSession.close();
            return medicaments;
        }
    }

    @Override
    public void clear() {

    }

    @Override
    public void save(Medicament entity) {
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
    public void update(Medicament entity) {

    }

    @Override
    public void delete(Integer integer) {

    }
}
