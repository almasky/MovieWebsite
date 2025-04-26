package org.example.movie.dao;

import org.example.movie.entity.UserMovie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class UserMovieDaoImpl implements UserMovieDao {

    private final SessionFactory sessionFactory;

    public UserMovieDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public UserMovie saveUserMovie(UserMovie movie) {
        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            UserMovie response = (UserMovie) session.save(movie);
            transaction.commit();
            return response;
        }
    }
}
