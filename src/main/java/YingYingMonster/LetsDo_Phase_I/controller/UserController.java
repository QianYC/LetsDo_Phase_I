package YingYingMonster.LetsDo_Phase_I.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import YingYingMonster.LetsDo_Phase_I.model.User;
import YingYingMonster.LetsDo_Phase_I.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/user")
@Api()
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/register")
	@ApiOperation(value = "访问用户注册界面")
	public String visitRegisterPage(){
		return "register";
	}
	
	@PostMapping("/register")
	@ApiOperation(value = "注册新用户，注册成功后跳转至登录界面；失败则返回注册界面，显示错误信息")
	public String register(@ModelAttribute("user")User user){
		if(userService.register(user))
			return "redirect:/user/login";
		else
			return "register";
	}
	
	@GetMapping("/login")
	@ApiOperation(value = "访问用户登录界面")
	public String visitLoginPage(){
		return "login";
	}
	
	@PostMapping("/login")
	@ApiOperation(value = "用户登录，成功后返回用户主界面；失败则返回登录界面，显示错误信息")
	public String login(@RequestParam("userId")String id
			,@RequestParam("password")String password){
		if(userService.login(id, password))
			return "workSpace";
		else
			return "login";
	}
	
	@PostMapping("/modify")
	@ApiOperation(value = "用户修改自身信息")
	public String modify(@ModelAttribute("user")User user){
		if(userService.modify(user))
			return "workSpace";
		else
			return "wrong";
	}
}
