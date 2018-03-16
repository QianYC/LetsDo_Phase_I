package YingYingMonster.LetsDo_Phase_I.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import YingYingMonster.LetsDo_Phase_I.dao.FileDAO;
import YingYingMonster.LetsDo_Phase_I.dao.UserDAO;
import YingYingMonster.LetsDo_Phase_I.daoImpl.FileDAOImpl;
import YingYingMonster.LetsDo_Phase_I.daoImpl.UserDAOImpl;
import YingYingMonster.LetsDo_Phase_I.model.Tag;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/worker")
@Api()
public class WorkerController {
//
//	@PostMapping("/chooseProject")

	UserDAO userImpl=new UserDAOImpl();
	FileDAO fileImpl=new FileDAOImpl();
	
	@PostMapping("/upload")
	@ApiOperation(value = "工人验证身份后，上传一张图片的标签（Tag）",notes="用于在线作业，返回值未定")
	public void uploadOne(@ModelAttribute("tag")Tag tag,
			@RequestParam ("userId")String userId,@RequestParam ("userId")String pw){
		if(userImpl.login(userId, pw))
			fileImpl.workerUpload(tag, userId);
	}
	
	@PostMapping("/download")//暂定返回值为String,应该返回picture
	@ApiOperation(value = "工人验证身份后，下载一个数据",notes="用于在线作业，返回值未定")
	public String getAPicture(@RequestParam ("userId")String userId
			,@RequestParam ("password")String pw){
		if(userImpl.login(userId, pw)){
			fileImpl.workerDownload(userId);//参数待定
			return null;
		}
		else
			return null;
	}
}
