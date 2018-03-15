package YingYingMonster.LetsDo_Phase_I.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import YingYingMonster.LetsDo_Phase_I.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/user")
@Api()
public class UserController {
	
	@PostMapping("/register")
	@ApiOperation(value = "注册新用户，注册成功后跳转至登录界面")
	public String register(@ModelAttribute("user")User user){
		
		return null;
	}
	
	@PostMapping("/login")
	@ApiOperation(value = "用户登录，成功后返回用户主界面")
	public String login(@RequestParam("username")String username
			,@RequestParam("password")String password){
		
		return null;
	}
	
	@PostMapping("/modify")
	@ApiOperation(value = "用户修改自身信息，不做页面跳转")
	public String modify(@ModelAttribute("user")User user){
		
		return null;
	}
}
