package test;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class SpringbootApplication {

	public static void main(String[] args) {
		
		var ctx = SpringApplication.run(SpringbootApplication.class, args);

	}
	
	@Bean
	public ApplicationRunner calculationRunner(Calculator calculator) {
		return args -> {
			calculator.calcurate(137, 21, '+');
			calculator.calcurate(137, 21, '*');
		};
	}

}
