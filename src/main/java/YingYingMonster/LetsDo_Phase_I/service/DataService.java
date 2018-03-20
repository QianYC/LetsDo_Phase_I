package YingYingMonster.LetsDo_Phase_I.service;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import YingYingMonster.LetsDo_Phase_I.model.Tag;

public interface DataService {

	/**
	 * 
	 * @param userId
	 * @return 查看所有项目名
	 */
	public List<String>viewAllProjects(String userId);
	
	/**
	 * 
	 * @param userId
	 * @param projectId
	 * @return 查看未标记的数据名
	 */
	public List<String>viewUndoData(String userId,String projectId);
	
	/**
	 * 
	 * @param userId
	 * @param projectId
	 * @return 查看已标记的数据名
	 */
	public List<String>viewDoneData(String userId,String projectId);
	
	/**
	 * 
	 * @param userId
	 * @param projectId
	 * @param dataId
	 * @return 取得一个数据
	 */
	public String getAData(String userId,String projectId,String dataId);
	
	/**
	 * 
	 * @param userId
	 * @param projectId
	 * @param tagId
	 * @return 取得一个Tag
	 */
	public Tag getATag(String userId,String projectId,String tagId);
	
	/**
	 * 
	 * @param userId
	 * @param dataSet
	 * @return 上传数据集，返回生成的项目id
	 */
	public String uploadDataSet(String userId,MultipartFile dataSet);
	
	/**
	 * 
	 * @param userId
	 * @param projectId
	 * @param tagId
	 * @param tag
	 * @return 上传Tag结果
	 */
	public boolean uploadTag(String userId,String projectId,String tagId,Tag tag);
}
