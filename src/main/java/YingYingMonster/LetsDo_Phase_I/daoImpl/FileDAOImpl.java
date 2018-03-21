package YingYingMonster.LetsDo_Phase_I.daoImpl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveInputStream;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.assertj.core.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import YingYingMonster.LetsDo_Phase_I.dao.FileDAO;
import YingYingMonster.LetsDo_Phase_I.model.Requirement;
import YingYingMonster.LetsDo_Phase_I.model.Tag;
import au.com.bytecode.opencsv.CSVWriter;

@Component
public class FileDAOImpl implements FileDAO {

	@Autowired private String ROOT;
	
	private CSVHandler handler=new CSVHandler();
	
	
	/*
	 * 复制文件
	 */
	private void copyFile(File fromFile,File toFile) throws IOException{
        FileInputStream ins = new FileInputStream(fromFile);
        FileOutputStream out = new FileOutputStream(toFile);
        byte[] b = new byte[1024];
        int n=0;
        while((n=ins.read(b))!=-1){
            out.write(b, 0, n);
        }
        
        ins.close();
        out.close();
    }



	@Override
	public boolean uploadTag(String workerId, String projectId, String tagId,Tag tag) {
		// TODO Auto-generated method stub
		if(workerId==null||projectId==null||tagId==null||tag==null)
			return false;
		String path=ROOT+"/users/"+workerId+"/"+projectId+"/tags/"+tagId+".tag";
		File file=new File(path);
		
		try {
			ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(tag);
			oos.flush();
			oos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}



	@Override
	public boolean forkDataSetToAccount(String workerId, String publisherId, String dataSetId) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public Tag getATag(String workerId, String dataSetId, String tagId) {
		// TODO Auto-generated method stub
		if(workerId==null||dataSetId==null||tagId==null)
			return null;
		
		String path=ROOT+"/users/"+workerId+"/"+dataSetId+"/tags/"+tagId+".tag";
		File file=new File(path);
		Tag tag=null;
		
		try {
			ObjectInputStream ois=new ObjectInputStream(new FileInputStream(file));
			tag=(Tag)ois.readObject();
			ois.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tag;
	}



	@Override
	public String getAData(String workerId, String dataSetId, String dataId) {
		// TODO Auto-generated method stub
		if(workerId==null||dataSetId==null||dataId==null)
			return null;
		
		String path=ROOT+"/users/"+workerId+"/"+dataSetId;
		File completeDir=new File(path+"/complete");
		File incompleteDir=new File(path+"/incomplete");
		
		String[]cmpd=completeDir.list();
		String[]icmpd=incompleteDir.list();
		
		for(String s:icmpd){
			if(s.contains(dataId))
				return path+"/incomplete/"+s;
		}
		
		for(String s:cmpd){
			if(s.contains(dataId))
				return path+"/complete/"+s;
		}
		
		return null;
	}



	@Override
	public boolean uploadDataSet(String publisherId, String dataSetId, byte[] bytes) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public List<String> getUserAllProjectsName(String userId) {
		// TODO Auto-generated method stub
		String path=ROOT+"/users/"+userId;
		File userDir=new File(path);
		String[]list=userDir.list();
		
		if(list==null)//user doesn't exist
			return null;
		
		List<String>arr=new ArrayList<>();
		for(String s:list)
			arr.add(s);
		
		return arr;
	}



	@Override
	public List<String> viewUndoData(String userId, String dataSetId) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<String> viewDoneData(String userId, String dataSetId) {
		// TODO Auto-generated method stub
		return null;
	}

}
