package org.example.movie.dao;

import org.example.movie.entity.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class MovieDaoImpl implements MovieDao {
    private final SessionFactory sessionFactory;

    public MovieDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public Movie saveMovie(Movie movie) {
        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Movie response = (Movie) session.save(movie);
            transaction.commit();
            return response;
        }
    }
}
