package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Zarz¹dzanie sesj¹ hibernate 
 */
public class HibernateUtil
{
    private static final SessionFactory sessionFactory;

    static
    {
        try
        {
            // Stworz SessionFactory 
            sessionFactory = new Configuration().configure()
                    .buildSessionFactory();
        }
        catch (Throwable ex)
        {
            // Obsluga bledow
            System.err
                    .println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory()
    {
        return sessionFactory;
    }
}
