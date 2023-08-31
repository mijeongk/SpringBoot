package kr.dwacademy.chap03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Chap03Application {

	public static void main(String[] args) {
		SpringApplication.run(Chap03Application.class, args);
	}

	@Autowired
	ApplicationContext context;
	// CommandLineRunner : 프로그램시작시 자동으로 시작되는 객체
	@Bean
	CommandLineRunner getCommandLineRunner() {
		return (args)->{
			System.out.println("-".repeat(80));
			System.out.println("등록된 객체");
			System.out.println("-".repeat(80));
			int count = 1;
			for(String beanName : context.getBeanDefinitionNames()) {
				System.out.println(count++ + ". " + beanName);
			}
			System.out.println("-".repeat(80));
		};
	}
}
