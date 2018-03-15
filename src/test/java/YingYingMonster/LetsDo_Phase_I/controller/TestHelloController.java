package YingYingMonster.LetsDo_Phase_I.controller;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


public class TestHelloController {

	MockMvc mvc;
	
	@Before
	public void setUp() throws Exception {

		MockitoAnnotations.initMocks(this);
        InternalResourceViewResolver resolver = new InternalResourceViewResolver(); //在test中重新配置视图解析器
        resolver.setPrefix("src/main/resources/templates/");
        resolver.setSuffix(".html");
		mvc=MockMvcBuilders.standaloneSetup(new HelloController()).setViewResolvers(resolver).build();
	}

	@Test
	public void test_hello() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/hello")).andExpect(view().name("hello"));
	}

}
