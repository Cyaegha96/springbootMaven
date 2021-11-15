package calcurator;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:your_external.properties")
@SpringBootApplication
public class SpringbootApplication {

	public static void main(String[] args) {
		
		var ctx = SpringApplication.run(SpringbootApplication.class, args);

	}
	
	@Bean
	public ApplicationRunner calculationRunner(Calculator calculator,
			@Value("${lhs}") int lhs,
			@Value("${rhs}") int rhs,
			@Value("${op}") char op) {
		return args -> calculator.calcurate(lhs, rhs, op);
	}

}
