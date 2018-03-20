package YingYingMonster.LetsDo_Phase_I;

import java.io.File;
import java.io.IOException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
//@EnableAspectJAutoProxy//在springboot这里可有可无
@Controller
public class LetsDoPhaseIApplication {

	public static void main(String[] args) {
		initialize();
		SpringApplication.run(LetsDoPhaseIApplication.class, args);
	}
	
	@Bean
	public String string(){
		return System.getProperty("user.home").replaceAll("\\\\", "/")+"/LetsDoPhase";
	}
	
	@GetMapping("/home")
	public String visitHome(){
		return "home";
	}
	
	/**
	 * 为整个程序搭建运行环境
	 */
	public static void initialize(){
		String root=System.getProperty("user.home").
				replaceAll("\\\\", "/")+"/LetsDoPhase";
		
		File appRoot=new File(root);
		if(!appRoot.exists())
			appRoot.mkdirs();
		
		File usercsv=new File(root+"/users.csv");
		if(!usercsv.exists())
			try {
				usercsv.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		File userDir=new File(root+"/users");
		if(!userDir.exists())
			userDir.mkdirs();
		
		String projectRoot=root+"/projects";
		File projectsRoot=new File(projectRoot);
		if(!projectsRoot.exists())
			projectsRoot.mkdirs();
	}
}
