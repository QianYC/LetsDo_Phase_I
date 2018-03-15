package YingYingMonster.LetsDo_Phase_I.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/worker")
public class WorkerController {
//
//	@PostMapping("/chooseProject")

	@PostMapping("/upload")
	public void uploadOne(@ModelAttribute("tag")Tag tag,
			@RequestParam ("userId")String userId){
		
	}
	
	@PostMapping("/download")//暂定返回值为String,应该返回picture
	public String getAPicture(@RequestParam ("userId")String userId){
		return null;
	}
}
