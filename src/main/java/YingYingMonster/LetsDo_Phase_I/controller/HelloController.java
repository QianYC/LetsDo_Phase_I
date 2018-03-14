package YingYingMonster.LetsDo_Phase_I.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller//方法返回的都是页面
public class HelloController {

	@GetMapping("/hello")
	public String hello(){
		return "hello";
	}
	
	@GetMapping("/hello/json")
	@ResponseBody//使方法返回json对象
	public String json(){
		return "JSON";
	}
	
	@GetMapping("/hello/newpage")
	public String newpage(){
		return "newpage";
	}
}
