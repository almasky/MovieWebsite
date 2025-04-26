package org.example.movie.repository;

import org.example.movie.config.HibernateConfig;
import org.example.movie.entity.AdminMovie;
import org.hibernate.Session;

import java.util.List;

public class AdminRepository {

    // Method to retrieve all admins
    public List<AdminMovie> getAllAdmins() {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            return session.createQuery("from AdminMovie", AdminMovie.class).list(); // HQL to fetch all admins
        }
    }

    // Other methods (saveAdmin, findAdminById, deleteAdmin)
    public void saveAdmin(AdminMovie admin) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(admin);
            session.getTransaction().commit();
        }
    }

    public AdminMovie findAdminById(Long id) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            return session.get(AdminMovie.class, id);
        }
    }

    public void deleteAdmin(Long id) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            session.beginTransaction();
            AdminMovie admin = session.get(AdminMovie.class, id);
            if (admin != null) {
                session.delete(admin);
                session.getTransaction().commit();
            }
        }
    }
}