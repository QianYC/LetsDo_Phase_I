package YingYingMonster.LetsDo_Phase_I.dao;

import static org.junit.Assert.*;

import org.junit.Test;
import YingYingMonster.LetsDo_Phase_I.dao.UserDAO;
import YingYingMonster.LetsDo_Phase_I.daoImpl.UserDAOImpl;
import YingYingMonster.LetsDo_Phase_I.model.User;


public class UserDAOTest {
	
	@Test
	public void testRegister(){
		User user=new User();
		user.setId("user1");
		user.setName("name1");
		user.setPw("pw1");
		UserDAO userImpl=new UserDAOImpl();
//		assertEquals(userImpl.register(user),true);
		assertEquals(userImpl.register(user),false);
	}
	
	@Test
	public void testModify(){
		User user=new User();
		user.setId("user1");
		user.setName("testname");
		user.setPw("testpw");
		UserDAO userImpl=new UserDAOImpl();
		assertEquals(userImpl.modify(user),true);
		
		user=userImpl.findById("user1");
		assertNotNull(user);
		assertEquals("testname",user.getName());
		assertEquals("testpw",user.getPw());
	}
	
	@Test
	public void testFind(){
		UserDAO userImpl=new UserDAOImpl();
		User user=userImpl.findById("17678");
		assertNull(user);
		
		user=userImpl.findById("user1");
		assertNotNull(user);
		assertEquals("testname",user.getName());
		assertEquals("testpw",user.getPw());
	}
	
//	@Test
	public void testDelete(){
		UserDAO userImpl=new UserDAOImpl();
		User user=userImpl.findById("user1");
		assertNotNull(user);
		userImpl.delete("user1");
		user=userImpl.findById("user1");
		assertNull(user);
		
		
		user=userImpl.findById("id");
		assertNotNull(user);
		userImpl.delete("id");
		user=userImpl.findById("id");
		assertNull(user);
	}
}
