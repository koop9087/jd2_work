package data;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionFactoryHolder {
    private static SessionFactory sessionFactoryUser;

    private SessionFactoryHolder() {
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactoryUser == null) {
            StandardServiceRegistry reg =
                    new StandardServiceRegistryBuilder()
                            .configure("hibernate.user.cfg.xml")
                            .build();
            sessionFactoryUser = new MetadataSources(reg)
                    .buildMetadata()
                    .buildSessionFactory();

        }
        return sessionFactoryUser;
    }
}
