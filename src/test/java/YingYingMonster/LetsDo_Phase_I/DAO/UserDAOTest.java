package YingYingMonster.LetsDo_Phase_I.DAO;

import static org.junit.Assert.*;

import org.junit.Test;

import YingYingMonster.LetsDo_Phase_I.dao.UserDAO;
import YingYingMonster.LetsDo_Phase_I.daoImpl.UserDAOImpl;
import YingYingMonster.LetsDo_Phase_I.model.User;

public class UserDAOTest {
	
	@Test
	public void testRegister(){
		User user=new User("admin1","11111","12345");
		UserDAO userImpl=new UserDAOImpl();
		//assertEquals(userImpl.register(user),true);
		assertEquals(userImpl.register(user),false);
	}
	
	@Test
	public void testModify(){
		User user=new User("admin1","11111","12346");
		UserDAO userImpl=new UserDAOImpl();
		assertEquals(userImpl.modify(user),true);
	}
}
