package YingYingMonster.LetsDo_Phase_I.daoImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import org.springframework.stereotype.Component;
import YingYingMonster.LetsDo_Phase_I.dao.UserDAO;
import YingYingMonster.LetsDo_Phase_I.model.User;

@Component
public class UserDAOImpl implements UserDAO {

	private final static String basePath=System.getProperty("user.dir")
			.replaceAll("\\\\", "/")+"/database/";
	
	private CSVHandler handler=new CSVHandler();
	
	@Override
	public boolean register(User user) {
		// TODO 自动生成的方法存根
		
		String path=basePath+"users/"+user.getId();
		
		if(this.findById(user.getId())!=null)
			return false;
		else{
			//为新用户创建文件夹
			File upload=new File(basePath+"repository/"+user.getId());
			upload.mkdirs();
			
			File newUser=new File(path);
			if(!newUser.exists())
				newUser.mkdirs();
			
			File f=new File(path+"/tags");
			f.mkdirs();
			f=new File(path+"/fork.csv");
			try {
				f.createNewFile();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			List<String[]>list=null;
			try {
				list=handler.readCSV(basePath+"users.csv");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String[]attrs={user.getId(),user.getName(),user.getPw()};
			list.add(attrs);
			if(handler.writeCSV(list,basePath+"users.csv"))
				return true;
			else 
				return false;
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
		if(newUser.getId()==null||
				newUser.getName()==null||newUser.getPw()==null
				||findById(newUser.getId())==null)
			return false;
		
		String[]attrs={newUser.getId(),newUser.getName(),newUser.getPw()};
		
		List<String[]>list=null;
		try {
			list=handler.readCSV(basePath+"users.csv");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(list==null)
			return false;
		else{
			Iterator<String[]>it=list.iterator();
			while(it.hasNext()){
				String[]token=it.next();
				if(token[0].equals(attrs[0])){
					it.remove();
					break;
				}
			}
			list.add(attrs);
			return handler.writeCSV(list,basePath+"users.csv");
		}
		
	}

	@Override
	public User findById(String id) {
		// TODO 自动生成的方法存根
		List<String[]> users=null;
		try {			
			users=handler.readCSV(basePath+"users.csv");						
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		if(users!=null)
			for(String[] userInfo: users){
				if(userInfo[0].equals(id)){
					User u=new User();
					u.setId(userInfo[0]);
					u.setName(userInfo[1]);
					u.setPw(userInfo[2]);
					return u;
				}
			}
		
		return null;
	}

	
	
	@Override
	public void delete(String userId){
		
		List<String[]>list=null;
		try {
			list=handler.readCSV(basePath+"users.csv");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(list!=null){
			//把用户从记录中删去
			Iterator<String[]>it=list.iterator();
			while(it.hasNext()){
				if(it.next()[0].equals(userId)){
					it.remove();
					break;
				}
			}
			
			handler.writeCSV(list,basePath+"users.csv");
			
			//删除用户文件夹
			String path=basePath+"users/"+userId;
			File forkRecord=new File(path+"/fork.csv");
			forkRecord.delete();
			
			File tags=new File(path+"/tags");
			String[]subDir=tags.list();
			for(String s:subDir){
				File f=new File(tags.getPath()+"/"+s);
				f.delete();
			}
			tags.delete();
			File user=new File(path);
			user.delete();
		}		
	}
}
