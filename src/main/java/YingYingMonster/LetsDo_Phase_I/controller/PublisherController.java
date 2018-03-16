package YingYingMonster.LetsDo_Phase_I.controller;

import java.util.zip.ZipFile;

import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import YingYingMonster.LetsDo_Phase_I.model.Requirement;
import YingYingMonster.LetsDo_Phase_I.model.User;
import YingYingMonster.LetsDo_Phase_I.service.DataService;
import YingYingMonster.LetsDo_Phase_I.serviceImpl.FileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/publisher")
@Api()
public class PublisherController {
	
	@Autowired
	private DataService dataService;
	
	@PostMapping("/sponsor/upload")
	@ApiOperation(value = "发布者上传数据集（一般是压缩文件）和要求")
	public void sponsorUpload(@RequestParam("publisherId")String publisherId,
			@ModelAttribute("file")ZipFile file,
			@ModelAttribute("requirement")Requirement requirement){
		dataService.uploadDataSet(publisherId, file, requirement);
	}
	
	
	
}
