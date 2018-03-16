package YingYingMonster.LetsDo_Phase_I.serviceImpl;

import YingYingMonster.LetsDo_Phase_I.dao.UserDAO;
import YingYingMonster.LetsDo_Phase_I.daoImpl.UserDAOImpl;

public class UserService {
	UserDAO userImpl=new UserDAOImpl();

	public boolean login(String userId, String pw) {
		// TODO 自动生成的方法存根
		return userImpl.login(userId, pw);
	}

}
