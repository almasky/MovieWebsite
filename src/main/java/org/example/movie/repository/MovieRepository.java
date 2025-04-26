package org.example.movie.repository;

import org.example.movie.entity.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class MovieRepository {

    private SessionFactory sessionFactory;

    public MovieRepository() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public void save(Movie movie) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(movie);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public Movie findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Movie.class, id);
        }
    }

    public List<Movie> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Movie", Movie.class).list();
        }
    }

    public void update(Movie movie) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.update(movie);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public void deleteById(Long id) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Movie movie = session.get(Movie.class, id);
            if (movie != null) {
                session.delete(movie);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }
}
