package YingYingMonster.LetsDo_Phase_I.service;

import java.io.File;
import java.util.zip.ZipFile;

import YingYingMonster.LetsDo_Phase_I.model.Requirement;
import YingYingMonster.LetsDo_Phase_I.model.Tag;

public interface DataService {

	/**
	 * 上传数据集
	 * @param publisherId 发布人id
	 * @param zipFile zip形式的数据集
	 * @param requirement 要求说明书
	 */
	public void uploadDataSet(String publisherId,ZipFile zipFile,Requirement requirement);
	
	/**
	 * 上传单张做好的标记
	 * @param workerId 工人id
	 * @param tag 标记
	 */
	public void uploadTag(String workerId,Tag tag);
	
	/**
	 * 批量上传做好的标记
	 * @param workerId 工人id
	 * @param zipFile 标记
	 */
	public void uploadTags(String workerId,ZipFile zipFile);
	
	/**
	 * 下载整个数据集
	 * @param workerid 工人id
	 * @return zip形式数据集
	 */
	public ZipFile downloadDataSet(String workerid);
	
	/**
	 * 单个下载数据
	 * @param workerid 工人id
	 * @return 数据
	 */
	public File downloadData(String workerid);
}
