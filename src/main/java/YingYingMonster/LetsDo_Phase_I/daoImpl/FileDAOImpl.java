package YingYingMonster.LetsDo_Phase_I.daoImpl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveInputStream;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.springframework.stereotype.Component;
import YingYingMonster.LetsDo_Phase_I.dao.FileDAO;
import YingYingMonster.LetsDo_Phase_I.model.Requirement;
import YingYingMonster.LetsDo_Phase_I.model.Tag;
import au.com.bytecode.opencsv.CSVWriter;

@Component
public class FileDAOImpl implements FileDAO {

	private final static String basePath=
			System.getProperty("user.dir").replaceAll("\\\\", "/")+"/database/";
	
	private CSVHandler handler=new CSVHandler();
	
	/**
	 * 找到数据集在数据库中的位置
	 * @param workerId
	 * @param dataSetId
	 * @return
	 */
	private String findDataSet(String workerId,String dataSetId){
		List<String[]>uploadRecords=null;
		try {
			uploadRecords=handler.readCSV(basePath+"uploadRecord.csv");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(uploadRecords!=null){
			for(String[]temp:uploadRecords)
				if(temp[0].equals(workerId)&&temp[1].equals(dataSetId))
					return basePath+"repository/"+workerId
							+"/"+dataSetId;//worker就是publisher
		}
		
		List<String[]>fork=null;
		try {
			fork=handler.readCSV(basePath+"users/"+workerId+"/fork.csv");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(fork!=null){
			for(String[]temp:fork)
				if(temp[1].equals(dataSetId))
					return basePath+"repository/"+temp[0]//找到相应的发布者
							+"/"+dataSetId;
		}
		
		return null;
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
	public byte[] downloadDataSet(String workerId, String dataSetId) {
		
		String path=findDataSet(workerId,dataSetId);
		if(path==null)
			return null;
		else
			return readFileAsStream(path+"/"+dataSetId+".zip");
	}

	private byte[]readFileAsStream(String path){
		
		byte[]bytes=null;

		File file=new File(path);		
		if(!file.exists())
			return null;
		
		try {
			FileInputStream fis=new FileInputStream(file);
			byte[]temp=new byte[1024];
			ByteArrayOutputStream baos=new ByteArrayOutputStream();
			int len=-1;
			while((len=fis.read(temp, 0, 1024))!=-1){
				baos.write(temp, 0, len);
			}
			bytes=baos.toByteArray();
			fis.close();
			baos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bytes;
	}
	
	@Override
	public boolean uploadDataSet(String publisherId, String dataSetId, 
			byte[] bytes, Requirement requirement) {
		// TODO Auto-generated method stub
		
		if(requirement==null)
			return false;
		
		List<String[]>uploadRecords=null;
		try {
			uploadRecords=handler.readCSV(basePath+"uploadRecord.csv");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(uploadRecords==null)
			return false;
		
		for(String[]temp:uploadRecords){
			if(temp[0].equals(publisherId)&&temp[1].equals(dataSetId))
				return false;//不能重复上传
		}
		//上传记录保存
		String[]val={publisherId,dataSetId};
		uploadRecords.add(val);
		handler.writeCSV(uploadRecords, basePath+"uploadRecord.csv");
//		//在该用户的fork记录中也保存一份，便于查询
//		List<String[]>fork=null;
//		try {
//			fork=handler.readCSV(basePath+"users/"+publisherId+"/fork.csv");
//		} catch (FileNotFoundException e2) {
//			// TODO Auto-generated catch block
//			e2.printStackTrace();
//		}
//		if(fork==null)
//			return false;
//		fork.add(val);
//		handler.writeCSV(fork, basePath+"users/"+publisherId+"/fork.csv");
//		
		
		File dir=new File(basePath+"repository/"+publisherId+"/"+dataSetId);
		dir.mkdirs();
		File zip=new File(dir.getPath()+"/"+dataSetId+".zip");
		try {
			BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(zip));
			bos.write(bytes);
			bos.close();
			unzipFile(zip);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//保存requirement
		File requirementTxt=new File(dir.getPath()+"/requirement.csv");
		try {
			CSVWriter cw=new CSVWriter(new FileWriter(requirementTxt));
			cw.writeNext(requirement.toStringCSV());
			cw.close();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return true;
	}

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
	public byte[] downloadData(String workerId, String dataId, String dataSetId) {
		// TODO Auto-generated method stub
		String path=findDataSet(workerId,dataSetId);
		if(path==null)
			return null;
		else
			return readFileAsStream(path+"/"+dataSetId);//应支持多种类型的图片
	}

	@Override
	public boolean forkDataSetToAccount(String workerId, String dataSetId
			, String publisherId) {
		// TODO Auto-generated method stub
		List<String[]>uploadRecords=null;
		try {
			uploadRecords=handler.readCSV(basePath+"uploadRecord.csv");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(uploadRecords!=null){
			boolean flag=false;
			Iterator<String[]>it=uploadRecords.iterator();
			while(it.hasNext()){
				String[]temp=it.next();
				if(temp[0].equals(publisherId)&&temp[1].equals(dataSetId)){
					flag=true;
					break;
				}
			}
			if(!flag)//没有在上传记录中找到数据集
				return false;
			
			//在上传记录中找到数据集
			File fork=new File(basePath+"users/"+workerId+"/fork.csv");
			List<String[]>forkRecords=null;
			
			try {
				forkRecords=handler.readCSV(fork.getPath());
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(forkRecords==null)
				return false;
			
			for(String[]temp:forkRecords){
				if(temp[0].equals(publisherId)&&temp[1].equals(dataSetId)){
					return false;//已经fork过了
				}
			}
			String[]val={publisherId,dataSetId};
			forkRecords.add(val);
			handler.writeCSV(forkRecords, fork.getPath());
			return true;
		}else
			return false;
	}

	private void unzipFile(File file) throws IOException{
		
		System.out.println(file.getPath());
		System.out.println(file.getParent());
		
		ZipArchiveInputStream is = new ZipArchiveInputStream(
				new BufferedInputStream(new FileInputStream(file), 1024));
		ZipArchiveEntry entry = null;
		
		while ((entry = is.getNextZipEntry()) != null) {
            if (entry.isDirectory()) {
            	File directory = new File(file.getParent(), entry.getName());
            	directory.mkdirs();
            }else {
            	OutputStream ops = new BufferedOutputStream(
            			new FileOutputStream(
            					new File(file.getParent(), entry.getName())), 1024);
            	IOUtils.copy(is, ops);
            	ops.close();
            }
		}
		is.close();
	}
}
