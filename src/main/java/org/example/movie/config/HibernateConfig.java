package org.example.movie.config;

import lombok.Getter;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConfig {

    // Provide access to the SessionFactory
    @Getter
    private static final SessionFactory sessionFactory;

    // Initialize the SessionFactory using the hibernate.cfg.xml file
    static {
        try {
            Configuration config = new Configuration();
            config.configure("hibernate.cfg.xml"); // Specify the Hibernate config file location
            sessionFactory = config.buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error initializing Hibernate SessionFactory");
        }
    }

}
