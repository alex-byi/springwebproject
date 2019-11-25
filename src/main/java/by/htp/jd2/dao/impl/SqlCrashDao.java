package by.htp.jd2.dao.impl;

import by.htp.jd2.dao.CrashDao;
import by.htp.jd2.entity.Crash;
import by.htp.jd2.entity.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class SqlCrashDao implements CrashDao {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Crash> getAllCrashs(int page) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Crash").setFirstResult(4 * (page - 1)).setMaxResults(4).list();
    }

    @Override
    public int crashCount() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select count(*) from Crash", Number.class).getSingleResult().intValue();
    }

    @Override
    public Crash getCrashById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Crash where id = :paramName");
        query.setParameter("paramName", id);
        return (Crash) query.getSingleResult();
    }

    @Override
    public void addCrash(Crash crash) {
        sessionFactory.getCurrentSession().save(crash);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Crash> getUserCrashes(int userId, int page) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Crash where idUser = :paramName").setFirstResult(4 * (page - 1)).setMaxResults(4);
        query.setParameter("paramName", userId);
        return query.list();
    }

    @Override
    public int userCrashCount(int userId) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select count(*) from Crash where idUser = :paramName", Number.class)
                .setParameter("paramName", userId).getSingleResult().intValue();
    }

}
