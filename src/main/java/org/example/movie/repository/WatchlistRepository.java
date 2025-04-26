package org.example.movie.repository;

import org.example.movie.entity.Watchlist;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class WatchlistRepository {

    private SessionFactory sessionFactory;

    public WatchlistRepository() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public void save(Watchlist watchlist) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(watchlist);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public Watchlist findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Watchlist.class, id);
        }
    }

    public List<Watchlist> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Watchlist", Watchlist.class).list();
        }
    }

    public void update(Watchlist watchlist) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.update(watchlist);
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
            Watchlist watchlist = session.get(Watchlist.class, id);
            if (watchlist != null) {
                session.delete(watchlist);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }
}
