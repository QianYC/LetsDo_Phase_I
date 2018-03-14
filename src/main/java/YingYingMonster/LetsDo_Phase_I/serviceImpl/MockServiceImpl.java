package YingYingMonster.LetsDo_Phase_I.serviceImpl;

import org.springframework.stereotype.Component;

import YingYingMonster.LetsDo_Phase_I.service.MockService;

@Component
public class MockServiceImpl implements MockService {

	@Override
	public String greet() {
		// TODO Auto-generated method stub
		return "greeting from service impl!";
	}

}
