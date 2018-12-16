package Hibernate.Storage;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;


public class AbstractDao<T> {
    SessionFactory sessionFactory = new Configuration().configure("hib.cfg.xml").buildSessionFactory();
    Class<T> tClass;

    public AbstractDao(Class tClass) {
        this.tClass = tClass;
    }

    public void createDao(T object) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(object);
        session.getTransaction().commit();
        session.close();
    }

    public void deleteDao(T object) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(object);
        session.getTransaction().commit();
        session.close();
    }

    public void updateDao(T object) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(object);
        session.getTransaction().commit();
        session.close();
    }

    public T getDaoById(long id) {
        Session session = sessionFactory.openSession();
        T obj = session.get(tClass, id);
        session.close();
        return obj;
    }

    public List<T> getAllDao() {
        List<T> list = new ArrayList<>();
        Session session = sessionFactory.openSession();
        String hql = "from " + tClass.getName();
        list = session.createQuery(hql).list();
        session.close();
        return list;
    }
}
