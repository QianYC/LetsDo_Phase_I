package YingYingMonster.LetsDo_Phase_I.dao;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

import YingYingMonster.LetsDo_Phase_I.dao.FileDAO;
import YingYingMonster.LetsDo_Phase_I.daoImpl.FileDAOImpl;

public class FileDAOTest {
	
	FileDAOImpl fileImpl=new FileDAOImpl();
	private final static String basePath=System.getProperty("user.dir")
			.replaceAll("\\\\", "/");
	
	@Test
	public void testFork(){
		assertEquals(false,fileImpl.forkDataSetToAccount("user1", "project1", "user1"));
	}

//	@Test
//	public void testFindDataSet(){
//		String path=basePath+"/database/repository/user1/project1";
//		assertEquals(path,fileImpl.findDataSet("user1", "project1"));
//	}

}
