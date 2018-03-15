package YingYingMonster.LetsDo_Phase_I.controller;

import java.io.File;
import java.util.zip.ZipFile;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import YingYingMonster.LetsDo_Phase_I.model.Requirement;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/publisher")
@Api()
public class PublisherController {
	
	@PostMapping("/sponsor/upload")
	@ApiOperation(value = "发布者上传数据集（一般是压缩文件）和要求")
	public void sponsorUpload(@ModelAttribute("file")ZipFile file,
			@ModelAttribute("requirement")Requirement requirement){
		
	}
	
	
	
}
