package by.academy.it.data;

import by.academy.it.repository.UserDaoImplements;
import by.academy.it.repository.UserLoginImplements;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import by.academy.it.pojo.User;

import java.io.Serializable;

import static org.junit.Assert.*;

public class UserDaoImplementsTest {
    static SessionFactory sessionFactory;
    UserDaoImplements userDaoImplements;
    UserLoginImplements userLoginImplements;

    @BeforeClass
    public static void init() {
        StandardServiceRegistry reg =
                new StandardServiceRegistryBuilder()
                        .configure("hibernate.user.cfg.test.xml")
                        .build();
        sessionFactory = new MetadataSources(reg)
                .buildMetadata()
                .buildSessionFactory();
    }

    @Before
    public void setUp() throws Exception {
        userDaoImplements = new UserDaoImplements(sessionFactory);
    }

    @After
    public void tearDown() {
        userDaoImplements = null;
    }

    @Test
    public void saveUser() {
        //given
        Session session = sessionFactory.openSession();
        Transaction tr = null;
        User user = new User("Jeka","Qqwer");
        //when
        tr = session.beginTransaction();
        Serializable id = session.save(user);
        tr.commit();
        //then
        assertNotEquals(100,id);
        session.close();
    }
    //todo
    @Test
    public void deleteUser() {
    }

    @Test
    public void readUser() {
    }

    @Test
    public void updateUser() {
        //UserLogin userLogin = userLoginImplements.readUserLogin("402880e47d61da4e017d61da6ac50000");
        //System.out.println(userLogin.getUser());
    }
}