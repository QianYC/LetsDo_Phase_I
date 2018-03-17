package YingYingMonster.LetsDo_Phase_I.daoImpl;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import YingYingMonster.LetsDo_Phase_I.dao.UserDAO;
import YingYingMonster.LetsDo_Phase_I.model.User;
import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;

@Component
public class UserDAOImpl implements UserDAO {

	@Override
	public boolean register(User user) {
		// TODO 自动生成的方法存根
		if(this.findById(user.getId())!=null)
			return false;
		else{
			File newUser=new File("src/main/resources/stock/users/"+user.getId());
			newUser.mkdirs();
			File UserInfo=new File("src/main/resources/stock/users/users.csv");
			try {
				FileWriter fw=new FileWriter(UserInfo,true);
				CSVWriter cw=new CSVWriter(fw,',');
				String[] newUserInfo=new String[]{user.getId(),user.getName(),user.getPw()};
				cw.writeNext(newUserInfo);
				cw.close();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			} 
			return true;
		}
	}

	@Override
	public boolean login(String id, String psw) {
		if(findById(id)!=null){
			if(findById(id).getPw().equals(psw))
				return true;
			else
				return false;
		}
		else
			return false;
	}

	@Override
	public boolean modify(User newUser) {
		if(newUser.getId()==null||newUser.getName()==null||newUser.getPw()==null)
			return false;
		File UserInfo=new File("src/main/resources/stock/users/users.csv");
		try {
			FileReader fr=new FileReader(UserInfo);
			CSVReader cr=new CSVReader(fr);
			List<String[]> users=cr.readAll();
			List<String[]> newUsers = new ArrayList<String[]>();
			for(String[] userInfo: users){
				if(userInfo[0].equals(newUser.getId())){
					newUsers.add(new String[]{newUser.getId(),newUser.getName(),newUser.getPw()});
				}
				else{
					newUsers.add(userInfo);
				}
			}
			cr.close();
			FileWriter fw=new FileWriter(UserInfo,false);
			CSVWriter cw=new CSVWriter(fw,',');
			cw.writeAll(newUsers);
			cw.close();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public User findById(String id) {
		// TODO 自动生成的方法存根
		File UserInfo=new File("src/main/resources/stock/users/users.csv");
		try {
			FileReader fr=new FileReader(UserInfo);
			CSVReader cr=new CSVReader(fr);
			List<String[]> users=cr.readAll();
			for(String[] userInfo: users){
				if(userInfo[0].equals(id)){
					User u=new User();
					u.setId(userInfo[0]);
					u.setName(userInfo[1]);
					u.setPw(userInfo[2]);
					return u;
				}
			}
			cr.close();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;
	}

}
