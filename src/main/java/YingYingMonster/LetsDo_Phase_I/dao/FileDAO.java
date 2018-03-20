package YingYingMonster.LetsDo_Phase_I.dao;

import java.io.File;
import java.util.List;
import java.util.zip.ZipFile;

import YingYingMonster.LetsDo_Phase_I.model.Requirement;
import YingYingMonster.LetsDo_Phase_I.model.Tag;

public interface FileDAO {
	
	/**
	 * 上传单张做好的标记
	 * @param workerId 工人id
	 * @param tag 标记
	 */
	public boolean uploadTag(String workerId,Tag tag);
	
	
	/**
	 * 把数据集添加到用户仓库
	 * @param workerId 工人id
	 * @param dataSetId 数据集id
	 * @param publisherId 发布者id
	 * @return
	 */
	public boolean forkDataSetToAccount(String workerId,String publisherId,String dataSetId);
	
	/**
	 * 
	 * @param workerId
	 * @param dataSetId
	 * @param tagId
	 * @return
	 */
	public Tag getATag(String workerId,String dataSetId,String tagId) ;
	
	/**
	 * 单个下载数据到客户端
	 * @param workerId 工人id
	 * @param dataId 数据id
	 * @param dataSetId 数据集id
	 * @return 数据
	 */
	public String getAData(String workerId,String dataSetId,String dataId);

	/**
	 * 
	 * @param publisherId 发布者id
	 * @param dataSetId 文件id
	 * @param bytes 文件内容
	 * @param requirement 要求说明
	 * @return 上传成功与否
	 */
	public boolean uploadDataSet(String publisherId, String dataSetId, byte[] bytes);
	
	/**
	 * 
	 * @param userId
	 * @return
	 */
	public List<String> getUserAllProjectsName(String userId);
	
	/**
	 * 
	 * @param userId 众包工人id
	 * @param dataSetId 数据集id
	 * @return 
	 */
	public List<String> viewUndoData(String userId,String dataSetId);
	
	/**
	 * 
	 * @param userId
	 * @param dataSetId
	 * @return
	 */
	public List<String> viewDoneData(String userId,String dataSetId);
}
