package YingYingMonster.LetsDo_Phase_I.daoImpl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import YingYingMonster.LetsDo_Phase_I.dao.UserDAO;
import YingYingMonster.LetsDo_Phase_I.model.User;
import au.com.bytecode.opencsv.CSVWriter;

public class UserDAOImpl implements UserDAO {

	@Override
	public boolean register(String id, String psw) {
		// TODO 自动生成的方法存根
		if(this.findById(id)!=null)
			return false;
		else{
			File newUser=new File("resources/stock"+id);
			newUser.mkdirs();
			File newUserInfo=new File("resources/stock/users.csv");
			try {
				newUserInfo.createNewFile();
				FileWriter fw=new FileWriter(newUserInfo,false);
				CSVWriter cw=new CSVWriter(fw,',');
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			return true;
		}
	}

	@Override
	public boolean login(String id, String psw) {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public boolean modify(User newUser) {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public User findById(String id) {
		// TODO 自动生成的方法存根
		return null;
	}

}
