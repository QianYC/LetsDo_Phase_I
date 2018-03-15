package YingYingMonster.LetsDo_Phase_I.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="/",tags={"负责主页操作"})

@Controller
public class HomePageController {

	@ApiOperation("显示主页")
	@GetMapping("/home")
	public String showHomePage(){
		return "home";
	}
	
}
