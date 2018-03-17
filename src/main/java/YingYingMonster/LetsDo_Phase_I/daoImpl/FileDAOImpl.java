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



	public boolean workerUpload(Tag tag, String userId) {
		// TODO 自动生成的方法存根
		return false;
	}


	public boolean workerDownload(String userId) {
		// TODO 自动生成的方法存根
		return false;
	}


	public boolean sponsorUpload(ZipFile file, String userId, Requirement requirement) {
		// TODO 自动生成的方法存根
		File newProjectAd=new File("src/main/resources/stock/projects/"+userId+"_"+file.getName());
		newProjectAd.mkdirs();
		
		File newProject=new File("src/main/resources/stock/projects/"+userId+"_"+file.getName()+"/requirments");
		return true;
	}

	@Override
	public void uploadDataSet(String publisherId, ZipFile zipFile, Requirement requirement) {

	}

	@Override
	public void uploadTag(String workerId, Tag tag) {

	}

	@Override
	public void uploadTags(String workerId, ZipFile zipFile) {

	}

	@Override
	public ZipFile downloadDataSet(String workerId, String dataSetId) {
		return null;
	}

	@Override
	public File downloadData(String workerId, String dataId) {
		return null;
	}
}
