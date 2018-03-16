package YingYingMonster.LetsDo_Phase_I.serviceImpl;

import java.io.File;
import java.util.zip.ZipFile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import YingYingMonster.LetsDo_Phase_I.dao.FileDAO;
import YingYingMonster.LetsDo_Phase_I.model.Requirement;
import YingYingMonster.LetsDo_Phase_I.model.Tag;
import YingYingMonster.LetsDo_Phase_I.service.DataService;

@Component
public class DataServiceImpl implements DataService {

	@Autowired
	private FileDAO fileDao;
	
	@Override
	public void uploadDataSet(String publisherId, ZipFile zipFile, Requirement requirement) {
		// TODO Auto-generated method stub
		fileDao.uploadDataSet(publisherId, zipFile, requirement);
	}

	@Override
	public void uploadTag(String workerId, Tag tag) {
		// TODO Auto-generated method stub
		fileDao.uploadTag(workerId, tag);
	}

	@Override
	public void uploadTags(String workerId, ZipFile zipFile) {
		// TODO Auto-generated method stub
		fileDao.uploadTags(workerId, zipFile);
	}

	@Override
	public ZipFile downloadDataSet(String workerid) {
		// TODO Auto-generated method stub
		return fileDao.downloadDataSet(workerid);
	}

	@Override
	public File downloadData(String workerid) {
		// TODO Auto-generated method stub
		return fileDao.downloadData(workerid);
	}

}
