package service;

import model.Event;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import util.HibernateUtil;

/**
 * @author Zu
 *
 */
public class EventManager {
	
    public Event getEventByOrganizer(String organizer)
    {
    	Event event = null;

        Session session = HibernateUtil.getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();
        try
        {
        	event = (Event) session.createQuery(
                    "from Event" + " where organizer = ?").setString(0,
                    organizer).uniqueResult();
            session.getTransaction().commit();
        }
        catch (HibernateException e)
        {
            session.getTransaction().rollback();
            throw e;
        }

        return event;
    }

    public void saveEvent(Event event)
    {
        Session session = HibernateUtil.getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();
        try
        {
            session.saveOrUpdate(event);
            session.getTransaction().commit();
        }
        catch (HibernateException e)
        {
            session.getTransaction().rollback();
            throw e;
        }
    }
}
