package org.example.movie.repository;

import org.example.movie.config.HibernateConfig;
import org.example.movie.entity.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public interface MovieRepository {

    SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
    Session session = sessionFactory.openSession();

    public default List<Movie> getAllMovies() {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            return session.createQuery("from Movie", Movie.class).list();
        }
    }


}


