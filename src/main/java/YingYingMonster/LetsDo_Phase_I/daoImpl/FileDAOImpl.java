package YingYingMonster.LetsDo_Phase_I.daoImpl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

import org.springframework.stereotype.Component;

import YingYingMonster.LetsDo_Phase_I.dao.FileDAO;
import YingYingMonster.LetsDo_Phase_I.model.Requirement;
import YingYingMonster.LetsDo_Phase_I.model.Tag;

@Component
public class FileDAOImpl implements FileDAO {

	@Override
	public void uploadTag(String workerId, Tag tag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void uploadTags(String workerId, ZipFile zipFile) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ZipFile downloadDataSet(String workerId, String dataSetId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public File downloadData(String workerId, String dataId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void uploadDataSet(String publisherId, String fileId, byte[] bytes, Requirement requirement) {
		// TODO Auto-generated method stub
		
	}


	

}
