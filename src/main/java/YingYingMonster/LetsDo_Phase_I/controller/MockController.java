package YingYingMonster.LetsDo_Phase_I.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MockController {

	@GetMapping("greetings")
	public String greet(){
		return "hello travis!";
	}
}
