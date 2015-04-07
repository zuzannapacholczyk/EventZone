package hibernate;

import junit.framework.TestCase;
import model.User;
import service.UserManager;
import service.UserManagerImpl;
import exceptions.accountcreateexcpetions.EmailAlreadyInUse;
import exceptions.accountcreateexcpetions.LoginAlreadyInUse;

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
		UserManager userManager = new UserManagerImpl();
		try {
			userManager.saveUser(testUser);
		} catch (EmailAlreadyInUse e) {
			e.printStackTrace();
			fail();
		} catch (LoginAlreadyInUse e) {
			e.printStackTrace();
			fail();
		}
		User result = userManager.getUserByLogin("zuzanna");
		assertEquals(testUser.getLogin(), result.getLogin());
		assertNull(testUser.getName());
		assertNull(result.getName());
	}
}
