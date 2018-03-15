package YingYingMonster.LetsDo_Phase_I.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomePageController {

	/**
	 * 显示主页
	 * @return
	 */
	@GetMapping("/home")
	public String showHomePage(){
		return "home";
	}
	
}
