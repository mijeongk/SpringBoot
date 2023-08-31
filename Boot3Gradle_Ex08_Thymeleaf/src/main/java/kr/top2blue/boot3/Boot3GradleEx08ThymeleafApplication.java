package kr.top2blue.boot3;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Boot3GradleEx08ThymeleafApplication {

	public static void main(String[] args) {
		SpringApplication.run(Boot3GradleEx08ThymeleafApplication.class, args);
	}
	@Bean
	CommandLineRunner getCommandLineRunner() {
		return (args)->{
			System.out.println("-".repeat(80));
			System.out.println("공식문서: https://springdoc.org/v2/");
			System.out.println("http://localhost:8080 으로 접속해서 확인하세요!!!");
			System.out.println("http://localhost:8080/swagger-ui/index.html 으로 접속해서 확인하세요!!!");
			System.out.println("-".repeat(80));
		};
	}
}
