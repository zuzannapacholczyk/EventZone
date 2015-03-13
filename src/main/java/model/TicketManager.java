package model;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import util.HibernateUtil;

public class TicketManager {
	
    public Ticket getTicketById(int id)
    {
    	Ticket ticket = null;

        Session session = HibernateUtil.getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();
        try
        {
        	ticket = (Ticket) session.createQuery(
                    "from Ticket" + " where id = ?").setInteger(0,
                    id).uniqueResult();
            session.getTransaction().commit();
        }
        catch (HibernateException e)
        {
            session.getTransaction().rollback();
            throw e;
        }

        return ticket;
    }
    
    public List getTicketsByEventId(int id)
    {
    	List tickets = null;

        Session session = HibernateUtil.getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();
        try
        {
        	tickets = session.createQuery(
                    "from Ticket" + " where eventId = ?").setInteger(0,
                    id).list();
            session.getTransaction().commit();
        }
        catch (HibernateException e)
        {
            session.getTransaction().rollback();
            throw e;
        }

        return tickets;
    }

    public void saveTicket(Ticket ticket)
    {
        Session session = HibernateUtil.getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();
        try
        {
            session.saveOrUpdate(ticket);
            session.getTransaction().commit();
        }
        catch (HibernateException e)
        {
            session.getTransaction().rollback();
            throw e;
        }
    }
}
