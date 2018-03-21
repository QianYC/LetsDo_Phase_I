package YingYingMonster.LetsDo_Phase_I.dao;

import YingYingMonster.LetsDo_Phase_I.model.User;

public interface UserDAO {

	/**
	 * 
	 * @param user
	 * @return false if user.id depublicated
	 */
	public boolean register(User user);
	
	/**
	 * 
	 * @param id
	 * @param pw
	 * @return false if pw doesn't match id
	 */
	public boolean login(String id,String pw);
	
	/**
	 * 
	 * @param user
	 * @return false if user doesn't exist
	 */
	public boolean modify(User user);
	
	/**
	 * 
	 * @param id
	 * @return null if user doesn't exist
	 */
	public User findById(String id);
	
	/**
	 * 
	 * @param id
	 * @return false if user doesn't exist
	 */
	public boolean delete(String id);
}
