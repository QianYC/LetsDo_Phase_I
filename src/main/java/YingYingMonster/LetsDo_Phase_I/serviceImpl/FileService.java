package YingYingMonster.LetsDo_Phase_I.serviceImpl;

import java.util.zip.ZipFile;

import YingYingMonster.LetsDo_Phase_I.dao.FileDAO;
import YingYingMonster.LetsDo_Phase_I.dao.UserDAO;
import YingYingMonster.LetsDo_Phase_I.daoImpl.FileDAOImpl;
import YingYingMonster.LetsDo_Phase_I.daoImpl.UserDAOImpl;
import YingYingMonster.LetsDo_Phase_I.model.Requirement;
import YingYingMonster.LetsDo_Phase_I.model.Tag;

public class FileService {
	FileDAO fileImpl=new FileDAOImpl();

	public void sponsorUpload(ZipFile file, String id, Requirement requirement) {
		// TODO 自动生成的方法存根
		fileImpl.sponsorUpload(file, id, requirement);
	}

	public void workerUpload(Tag tag, String userId) {
		// TODO 自动生成的方法存根
		fileImpl.workerUpload(tag, userId);
	}

	public void workerDownload(String userId) {
		// TODO 自动生成的方法存根
		fileImpl.workerDownload(userId);
	}
	
	
}
