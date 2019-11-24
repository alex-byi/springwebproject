package by.htp.jd2.dao.impl;

import by.htp.jd2.dao.CrashDao;
import by.htp.jd2.entity.Crash;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
}
