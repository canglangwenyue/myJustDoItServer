package wenyue.justdoit.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import wenyue.justdoit.Dao.userDao;
import wenyue.justdoit.DaoImpl.userDaoImpl;

public class userDaoImplTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	// @Test
	// public void testAdd() {
	// user u = new user();
	// u.setUsername("bjx");
	// u.setUserpassword("bjx");
	// userDao dao = new userDaoImpl();
	// dao.add(u);
	// }

	// @Test
	// public void testCheckUserExistsWithName() {
	// userDao dao = new userDaoImpl();
	// dao.checkUserExistsWithName("uu");
	//
	// }

	@Test
	public void testgetUserData() {
		userDao dao = new userDaoImpl();
		boolean bool = dao.getUserData("bjx", "bjx");
		if (bool) {
			System.out.println("success");
		} else {
			System.out.println("fuck");
		}
	}
}
