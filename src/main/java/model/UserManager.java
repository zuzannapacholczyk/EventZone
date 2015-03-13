package model;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import util.HibernateUtil;

public class UserManager {
	
    public User getUserByLogin(String login)
    {
    	User user = null;

        Session session = HibernateUtil.getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();
        try
        {
        	user = (User) session.createQuery(
                    "from User" + " where login = ?").setString(0,
                    login).uniqueResult();
            session.getTransaction().commit();
        }
        catch (HibernateException e)
        {
            session.getTransaction().rollback();
            throw e;
        }

        return user;
    }

    public void saveUser(User user)
    {
        Session session = HibernateUtil.getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();
        try
        {
            session.saveOrUpdate(user);
            session.getTransaction().commit();
        }
        catch (HibernateException e)
        {
            session.getTransaction().rollback();
            throw e;
        }
    }
}
