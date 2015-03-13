package hibernate;

import model.User;
import model.UserManager;
import junit.framework.TestCase;

/**
 * Test class for testing operations on User table via Hibernate connection.
 * 
 * @author Zu
 *
 */
public class UserHibernateTest extends TestCase {

	public void testAddingUser() {
		User testUser = new User();
		testUser.setLogin("zuzanna");
		testUser.setPassword("password");
		UserManager userManager = new UserManager();
		userManager.saveUser(testUser);
		User result = userManager.getUserByLogin("zuzanna");
		assertEquals(testUser.getLogin(), result.getLogin());
		assertNull(testUser.getName());
		assertNull(result.getName());
	}
}
