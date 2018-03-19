package YingYingMonster.LetsDo_Phase_I.daoImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Component;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;

@Component
public class CSVHandler {

	public List<String[]> readCSV(String path) throws FileNotFoundException {
		
		File users=new File(path);
		
		CSVReader cr=new CSVReader(new FileReader(users));
		List<String[]> list=null;
		try {
			list = cr.readAll();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				cr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	public boolean writeCSV(List<String[]>val,String path){

		File users=new File(path);
		CSVWriter cw=null;
		try {
			cw = new CSVWriter(new FileWriter(users,false),',');
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cw.writeAll(val);
		try {
			cw.flush();
			cw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
}
