package YingYingMonster.LetsDo_Phase_I.daoImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import YingYingMonster.LetsDo_Phase_I.LetsDoPhaseIApplication;
import YingYingMonster.LetsDo_Phase_I.dao.SimpleUserDAO;
import YingYingMonster.LetsDo_Phase_I.model.User;

@Component
public class SimpleUserDAOImpl implements SimpleUserDAO {

	@Autowired String ROOT;
	private CSVHandler handler=new CSVHandler();
	
	@Override
	public boolean register(User user) {
		// TODO Auto-generated method stub
		List<String[]>users=null;
		try {
			users=handler.readCSV(ROOT+"/users.csv");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(users==null){
			LetsDoPhaseIApplication.initialize();
			return this.register(user);
		}
		
		for(String[]temp:users)
			if(temp[0].equals(user.getId()))
				return false;
		
		String[]val={user.getId(),user.getPw()};
		users.add(val);
		handler.writeCSV(users, ROOT+"/users.csv");
		
		//create a folder for new user
		File folder=new File(ROOT+"/users/"+user.getId());
		if(!folder.exists())
			folder.mkdirs();
		
		return true;
	}

	@Override
	public boolean login(String id, String pw) {
		// TODO Auto-generated method stub
		
		return false;
	}

	@Override
	public boolean modify(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

}
