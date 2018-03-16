package YingYingMonster.LetsDo_Phase_I.controller;

import java.util.zip.ZipFile;

import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import YingYingMonster.LetsDo_Phase_I.model.Requirement;
import YingYingMonster.LetsDo_Phase_I.model.User;
import YingYingMonster.LetsDo_Phase_I.serviceImpl.FileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/publisher")
@Api()
public class PublisherController {
	
	FileService fileservice=new FileService();
	static User sponsor;
	
	@Before(value = "绑定当前上传者")
	@GetMapping("/sponsor")
	public void setSponsor(User user){
		sponsor=user;
	}
	
	@PostMapping("/sponsor/upload")
	@ApiOperation(value = "发布者上传数据集（一般是压缩文件）和要求")
	public void sponsorUpload(@ModelAttribute("file")ZipFile file,
			@ModelAttribute("requirement")Requirement requirement){
		fileservice.sponsorUpload(file,sponsor.getId(), requirement);
	}
	
	
	
}
