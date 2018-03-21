package YingYingMonster.LetsDo_Phase_I.daoImpl;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import YingYingMonster.LetsDo_Phase_I.model.Tag;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestFileDAOImpl_QYC {

	@Autowired
	private FileDAOImpl fileImpl;
	
	@Autowired String ROOT;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void test() {
		Tag tag=new Tag();
		tag.setType(65536);
		HashMap<String,String>map=new HashMap<String,String>();
		map.put("姓名", "jbs");
		map.put("属性", "猪猪");
		tag.setTags(map);
		tag.setBytes(null);
		
		assertEquals(true,fileImpl.uploadTag("user1", "project1", "tag1", tag));
		assertEquals(false,fileImpl.uploadTag(null,null,null,null));
		
		
		Tag test=fileImpl.getATag("user1", "project1", "tag1");
		assertNotNull(test);
		assertNull(test.getBytes());
		assertEquals(65536,test.getType());
		assertEquals("jbs",test.getTags().get("姓名"));
		assertEquals("猪猪",test.getTags().get("属性"));
	}

	@Test
	public void test_getAData(){
		String pathA=fileImpl.getAData("user1", "project1", "哈哈");
		String pathB=fileImpl.getAData("user1", "project1", "b.jpg");
		String pathC=fileImpl.getAData("user2", null, null);
		
		assertEquals(ROOT+"/users/user1/project1/incomplete/哈哈.jpg",pathA);
		assertEquals(ROOT+"/users/user1/project1/complete/b.jpg",pathB);
		assertNull(pathC);
	}
	
	@Test
	public void test_getUserAllProjectsName(){
		List<String>list1=fileImpl.getUserAllProjectsName("user1");
		List<String>list2=fileImpl.getUserAllProjectsName("user2");
		
		assertEquals("project1",list1.get(0));
		assertNull(list2);
	}
}
