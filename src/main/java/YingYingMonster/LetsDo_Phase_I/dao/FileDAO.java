package YingYingMonster.LetsDo_Phase_I.dao;

import java.util.zip.ZipFile;

import YingYingMonster.LetsDo_Phase_I.model.Requirement;
import YingYingMonster.LetsDo_Phase_I.model.Tag;

public interface FileDAO {
	public boolean sponsorUpload(ZipFile file,String userId,Requirement requirement);
	public boolean workerUpload(Tag tag,String userId);
	public boolean workerDownload(String userId);//参数待定
}
