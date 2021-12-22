package by.academy.it.repository;

import by.academy.it.pojo.UserRole;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public class RoleDaoImpl implements RoleDao {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public UserRole getById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        UserRole userRole = session.load(UserRole.class, id);
        return userRole;
    }

    @Override
    public Serializable saveRole(UserRole userRole) {
        Session session = sessionFactory.getCurrentSession();
        Serializable id = session.save(userRole);
        return id;
    }
}
