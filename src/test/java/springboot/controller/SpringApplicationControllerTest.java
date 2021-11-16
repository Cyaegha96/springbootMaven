package springboot.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import springboot.Controller.SpringApplicationController;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(SpringApplicationController.class)
public class SpringApplicationControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testSpringApplicationController() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/"))
		.andExpect(status().isOk())
		.andExpect(content().string("Hello World, from Spring Boot 2!"))
		.andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_PLAIN));
	}

}