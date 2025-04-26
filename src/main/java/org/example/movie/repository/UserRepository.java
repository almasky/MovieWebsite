package org.example.movie.repository;
import org.example.movie.entity.AdminMovie;
import org.example.movie.entity.Genre;
import org.example.movie.entity.UserMovie;
import org.example.movie.config.HibernateConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
public class UserRepository {
    public void saveUser(UserMovie user) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Retrieve all admins
    public List<UserMovie> getAllUsers() {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            return session.createQuery("from UserMovie", UserMovie.class).list();
        }
    }
    public UserMovie findMovieByTitle(String titleByUser) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            return session.get(UserMovie.class, titleByUser);
        }
    }
    public UserMovie findMovieByGenre(Genre GenreByUser) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            return session.get(UserMovie.class, GenreByUser);
        }
    }
    public UserMovie findUserById(Long id) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            return session.get(UserMovie.class, id);
        }
    }
    public void deleteUser(Long id) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            session.beginTransaction();
            UserMovie u = session.get(UserMovie.class, id);
            if (u != null) {
                session.delete(u);
                session.getTransaction().commit();
            }
        }
    }
}
