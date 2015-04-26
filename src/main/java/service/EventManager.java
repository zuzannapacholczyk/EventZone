package service;

import java.util.ArrayList;
import java.util.List;

import model.Event;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import output.EventInfoForParticipant;
import util.HibernateUtil;

/**
 * @author Zu
 *
 */
public class EventManager {
	
    public List<Event> getAllEventsByOrganizer(String organizer)
    {
    	List<Event> events = new ArrayList<Event>();

        Session session = HibernateUtil.getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();
        try
        {
        	events = (List<Event>) session
					.createQuery(
							"from Event "
									+ " where organizer = ?")
					.setString(0, organizer).list();
			session.getTransaction().commit();
        }
        catch (HibernateException e)
        {
            session.getTransaction().rollback();
            throw e;
        }

        return events;
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
