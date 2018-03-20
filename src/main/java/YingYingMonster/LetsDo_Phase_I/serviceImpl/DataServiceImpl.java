package YingYingMonster.LetsDo_Phase_I.serviceImpl;

import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import YingYingMonster.LetsDo_Phase_I.dao.FileDAO;
import YingYingMonster.LetsDo_Phase_I.model.Tag;
import YingYingMonster.LetsDo_Phase_I.service.DataService;

@Component
public class DataServiceImpl implements DataService {

	//@Autowired
	private FileDAO fileDao;

	@Override
	public List<String> viewAllProjects(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> viewUndoData(String userId, String projectId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> viewDoneData(String userId, String projectId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAData(String userId, String projectId, String dataId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tag getATag(String userId, String projectId, String tagId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String uploadDataSet(String userId, MultipartFile dataSet) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean uploadTag(String userId, String projectId, String tagId, Tag tag) {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
