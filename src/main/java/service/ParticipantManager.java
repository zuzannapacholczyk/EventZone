package service;

import java.util.List;

import model.Participant;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import util.HibernateUtil;

public class ParticipantManager {
	
    public List getAllParticipantsByEventId(int eventId)
    {
    	List participants = null;

        Session session = HibernateUtil.getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();
        try
        {
        	participants = session.createQuery(
                    "from Participant" + " where eventId = ?").setInteger(0,
                    eventId).list();
            session.getTransaction().commit();
        }
        catch (HibernateException e)
        {
            session.getTransaction().rollback();
            throw e;
        }

        return participants;
    }

    public void saveParticipant(Participant participant)
    {
        Session session = HibernateUtil.getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();
        try
        {
            session.saveOrUpdate(participant);
            session.getTransaction().commit();
        }
        catch (HibernateException e)
        {
        	session.getTransaction().rollback();
            throw e;
        }
    }
    
    public boolean checkIfPaidForTicket(String personId) {
    	int ifPaidInt;

        Session session = HibernateUtil.getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();
        try
        {
        	ifPaidInt = (Integer) session.createQuery(
                    "from Participant" + " where personId = ?").setString(0,
                    personId).uniqueResult();
            session.getTransaction().commit();
        }
        catch (HibernateException e)
        {
            session.getTransaction().rollback();
            throw e;
        }
        if(ifPaidInt == 1)
        	return true;
        return false;
    }
}
