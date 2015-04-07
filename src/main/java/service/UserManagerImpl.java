package service;

import model.User;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import util.HibernateUtil;
import exceptions.accountcreateexcpetions.EmailAlreadyInUse;
import exceptions.accountcreateexcpetions.LoginAlreadyInUse;

public class UserManagerImpl extends UserManager {

	private Session session;

	public User getUserByLogin(final String login) {
		User user = null;

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			user = (User) session.createQuery("from User" + " where login = ?").setString(0, login).uniqueResult();
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			throw e;
		}

		return user;
	}

	public void saveUser(final User user) throws EmailAlreadyInUse, LoginAlreadyInUse {
		// Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		// session.beginTransaction();
		// try {
		// session.saveOrUpdate(user);
		// session.getTransaction().commit();
		// } catch (HibernateException e) {
		// session.getTransaction().rollback();
		// throw e;
		// }

		throw new EmailAlreadyInUse("Given email is already in use!");
	}

}
