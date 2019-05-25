package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableAsync(mode = AdviceMode.ASPECTJ)
@EnableScheduling
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);

	}
	
	

}
