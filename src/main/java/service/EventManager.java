package service;

import java.util.ArrayList;
import java.util.List;

import model.Event;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import exceptions.CreateAccountException;
import exceptions.CreateEventException;
import output.EventInfoForParticipant;
import util.HibernateUtil;

/**
 * @author Zu
 *
 */
public class EventManager {
	
	public Event getEventById(String id){
		Event event = new Event();
		
		Session session = HibernateUtil.getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();
        try
        {
        	event = (Event) session
					.createQuery("from Event" 
							+ " where id = ?")
							.setString(0, id).uniqueResult();
			session.getTransaction().commit();
        }
        catch (HibernateException e)
        {
            session.getTransaction().rollback();
            throw e;
        }
		
		return event;
	}
	
	@SuppressWarnings("unchecked")
	public List<Event> getAllEventsInDataBase(){
		List<Event> allEvents = new ArrayList<Event>();
		
		Session session = HibernateUtil.getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();
        try
        {
        	allEvents = (List<Event>) session
					.createQuery("from Event").list();
			session.getTransaction().commit();
        }
        catch (HibernateException e)
        {
            session.getTransaction().rollback();
            throw e;
        }
		
		return allEvents;
	}
	
    @SuppressWarnings("unchecked")
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

    @SuppressWarnings("unchecked")
	public List<Event> searchForEvents(List<String> searchWords)
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
									+ " where name contains ? or subtitle contains ? or description contains ?")
					.setString(0, searchWords.get(0)).setString( 1, searchWords.get(0)).setString( 2, searchWords.get(0)).list();
			session.getTransaction().commit();
        }
        catch (HibernateException e)
        {
            session.getTransaction().rollback();
            throw e;
        }

        return events;
    }
    
    public void saveEvent(Event event) throws CreateEventException
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
            throw new CreateEventException("HibernateException");
        }
    }
}
