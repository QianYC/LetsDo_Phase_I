package YingYingMonster.LetsDo_Phase_I.controller;

import java.io.File;
import java.util.zip.ZipFile;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dataSet")
public class DataSetController {
	
	@PostMapping("/sponsor/upload")
	public void sponsorUpload(@ModelAttribute("file")ZipFile file,
			@ModelAttribute("requirement")Requirement requirement){
		
	}
	
	
	
}
