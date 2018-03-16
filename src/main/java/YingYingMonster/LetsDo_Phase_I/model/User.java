package YingYingMonster.LetsDo_Phase_I.model;

/**
 * 用户类，暂时包含姓名、账号、密码
 * @author 17678
 *
 */
public class User {

	private String name,id,pw;

	public String getName() {
		return name;
	}

	public String getPw() {
		return pw;
	}

	public String getId() {
		return id;
	}

	public User(String name, String id, String pw) {
		super();
		this.name = name;
		this.id = id;
		this.pw = pw;
	}

	
	
	
}
