package YingYingMonster.LetsDo_Phase_I.daoImpl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

import YingYingMonster.LetsDo_Phase_I.dao.FileDAO;
import YingYingMonster.LetsDo_Phase_I.model.Requirement;
import YingYingMonster.LetsDo_Phase_I.model.Tag;

public class FileDAOImpl implements FileDAO {


	@Override
	public boolean workerUpload(Tag tag, String userId) {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public boolean workerDownload(String userId) {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public boolean sponsorUpload(ZipFile file, String userId, Requirement requirement) {
		// TODO 自动生成的方法存根
		File newProjectAd=new File("src/main/resources/stock/projects/"+userId+"_"+file.getName());
		newProjectAd.mkdirs();
		
		File newProject=new File("src/main/resources/stock/projects/"+userId+"_"+file.getName()+"/requirments");
		return true;
	}

}
