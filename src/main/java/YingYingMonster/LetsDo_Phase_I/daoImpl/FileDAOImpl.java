package YingYingMonster.LetsDo_Phase_I.daoImpl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import YingYingMonster.LetsDo_Phase_I.dao.FileDAO;
import YingYingMonster.LetsDo_Phase_I.model.Requirement;
import YingYingMonster.LetsDo_Phase_I.model.Tag;
import au.com.bytecode.opencsv.CSVWriter;

@Component
public class FileDAOImpl implements FileDAO {

	@Override
	public void uploadDataSet(String publisherId, File zipFile, Requirement requirement) {
		// TODO Auto-generated method stub
		String newFilePath="src/main/resources/stock/projects/"+publisherId+"_"+zipFile.getName();
		File newFile=new File(newFilePath+"/"+zipFile.getName());
		zipFile.renameTo(newFile);
		File requirementTxt=new File(newFilePath+"/requirement.csv");
		try {
			FileWriter fw=new FileWriter(requirementTxt);
			CSVWriter cw=new CSVWriter(fw);
			cw.writeNext(requirement.toStringCSV());
			cw.close();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	@Override
	public void uploadTag(String workerId, Tag tag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void uploadTags(String workerId, File zipFile) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public File downloadDataSet(String workerId, String dataSetId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public File downloadData(String workerId, String dataId) {
		// TODO Auto-generated method stub
		return null;
	}


	

}
