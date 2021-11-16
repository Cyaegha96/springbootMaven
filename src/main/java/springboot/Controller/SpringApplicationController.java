package springboot.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringApplicationController {
	
	@GetMapping("/")
	public String hello() {
		return "Hello world, from spring boot 2";
	}
}	
