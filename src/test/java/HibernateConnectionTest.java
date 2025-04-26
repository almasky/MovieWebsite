import org.example.movie.config.HibernateConfig;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class HibernateConnectionTest {
    public static void main(String[] args) {
        // Get the SessionFactory from your HibernateConfig
        SessionFactory sessionFactory = HibernateConfig.getSessionFactory();

        // Open a Hibernate session
        try (Session session = sessionFactory.openSession()) {
            // Begin a transaction
            session.beginTransaction();

            // Print a success message
            System.out.println("Hibernate connection is working fine!");

            // Commit the transaction (just to complete the workflow)
            session.getTransaction().commit();
        } catch (Exception e) {
            // Print any errors if the connection fails
            System.err.println("Hibernate connection failed: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
