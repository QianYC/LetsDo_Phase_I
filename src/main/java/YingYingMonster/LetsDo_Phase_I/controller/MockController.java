package YingYingMonster.LetsDo_Phase_I.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import YingYingMonster.LetsDo_Phase_I.service.MockService;

/**
 * 这个controller用于测试
 * @author 17678
 *
 */
@RestController
@RequestMapping("/")
public class MockController {

	@Autowired
	private MockService mockService;
	
	@GetMapping("greetings")
	public String greet(){
		return mockService.greet();
	}
}
