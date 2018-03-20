package YingYingMonster.LetsDo_Phase_I.daoImpl;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import YingYingMonster.LetsDo_Phase_I.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestSimpleUserDAOImpl {

	@Autowired SimpleUserDAOImpl userImpl;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@Test
	public void test() {
		assertEquals("C:/Users/17678/LetsDoPhase",userImpl.ROOT);
	}

	@Test
	public void register(){
		User u=new User();
		u.setId("user1");
		u.setName("name1");
		u.setPw("pw1");
		assertEquals(true,userImpl.register(u));
		assertEquals(false,userImpl.register(u));
	}
}
