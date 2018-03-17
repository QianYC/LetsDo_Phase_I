package YingYingMonster.LetsDo_Phase_I.daoImpl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import org.springframework.stereotype.Component;
import YingYingMonster.LetsDo_Phase_I.dao.FileDAO;
import YingYingMonster.LetsDo_Phase_I.model.Requirement;
import YingYingMonster.LetsDo_Phase_I.model.Tag;
import au.com.bytecode.opencsv.CSVWriter;

@Component
public class FileDAOImpl implements FileDAO {

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
		String[] name=dataSetId.split("_");
		File downloadDataSet=new File("src/main/resources/stock/projects/"+dataSetId+"/"+name[1]+".zip");
		File workerFile=new File("src/main/resources/stock/users/"+workerId);
		if(!workerFile.exists())
			return null;
		else{
			File workerNewFile=new File("src/main/resources/stock/users/"+workerId+"/"+dataSetId);
			if(workerNewFile.exists())
				return null;
			workerNewFile.mkdirs();
			File dataSetNewFile=new File("src/main/resources/stock/users"+workerId+"/"+dataSetId+"/"+dataSetId+".zip");
			downloadDataSet.renameTo(dataSetNewFile);
			return dataSetNewFile;
		}
	}

	@Override
	public File downloadData(String workerId, String dataId) {
		// TODO Auto-generated method stub
		File downloadFile=new File("src/main/resources/stock/projects/"+dataId);
		return null;
	}

	@Override
	public void uploadDataSet(String publisherId, String fileId, byte[] bytes, Requirement requirement) {
		// TODO Auto-generated method stub
		String newFilePath="src/main/resources/stock/projects/"+publisherId+"_"+fileId;
		File newDisk=new File(newFilePath);
		newDisk.mkdirs();
		File newFile=new File(newFilePath+"/"+fileId+".zip");
		try {
			//保存
			OutputStream os=new FileOutputStream(newFile);
			BufferedOutputStream bos=new BufferedOutputStream(os);
			bos.write(bytes);
			bos.close();
			
			//解压
			File outfile=null;
			ZipEntry zipEntry=null;
			InputStream is=null;
			OutputStream ops=null;
			ZipFile zipfile=new ZipFile(newFile);
			ZipInputStream zipInput=new ZipInputStream(new FileInputStream(newFile));
			while((zipEntry=zipInput.getNextEntry())!=null){
				outfile=new File(newFilePath+"/"+zipEntry.getName());
				if(!outfile.exists())
					outfile.createNewFile();
				is=zipfile.getInputStream(zipEntry);
				ops=new FileOutputStream(outfile);
				int temp=0;
				while((temp=is.read())!=-1)
					ops.write(temp);
			}
				is.close();
				ops.close();
				zipfile.close();
				zipInput.close();
			
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
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


	

}
