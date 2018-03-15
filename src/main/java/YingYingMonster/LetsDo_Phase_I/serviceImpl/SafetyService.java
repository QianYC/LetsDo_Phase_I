package YingYingMonster.LetsDo_Phase_I.serviceImpl;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SafetyService {

//	@Before("execution(* YingYingMonster.LetsDo_Phase_I.controller.HelloController.hello(..))")
	public void log(){
		System.out.println("opening a hello html");
	}
}
