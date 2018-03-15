package YingYingMonster.LetsDo_Phase_I.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import YingYingMonster.LetsDo_Phase_I.model.User;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@PostMapping("/register")
	public String register(@ModelAttribute("user")User user){
		
		return null;
	}
	
	@PostMapping("/login")
	public String login(@RequestParam("username")String username
			,@RequestParam("password")String password){
		
		return null;
	}
	
	@PostMapping("/modify")
	public String modify(@ModelAttribute("user")User user){
		
		return null;
	}
}
