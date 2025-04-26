package org.example.movie.repository;

import org.example.movie.entity.AdminMovie;
import org.example.movie.config.HibernateConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;



public class AdminRepository {

    // Save an admin
    public void saveAdmin(AdminMovie admin) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(admin);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Retrieve all admins
    public List<AdminMovie> getAllAdmins() {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            return session.createQuery("from AdminMovie", AdminMovie.class).list();
        }
    }

    // Find admin by ID
    public AdminMovie findAdminById(Long id) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            return session.get(AdminMovie.class, id);
        }
    }

    // Delete an admin
    public void deleteAdmin(Long id) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            AdminMovie admin = session.get(AdminMovie.class, id);
            if (admin != null) {
                session.delete(admin);
                transaction.commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
