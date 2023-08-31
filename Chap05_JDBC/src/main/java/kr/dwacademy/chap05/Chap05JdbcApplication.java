package kr.dwacademy.chap05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Chap05JdbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(Chap05JdbcApplication.class, args);
	}

	@Autowired
	ApplicationContext context;
	
//	@Bean // 애플리케이션 실행시 자동으로 먼저 실행된다.
//	CommandLineRunner getCommandLineRunner() {
//		return (args)->{
//			System.out.println("=".repeat(80));
//			System.out.println("스프링 부트에 자동으로 등록된 객체 목록");
//			System.out.println("=".repeat(80));
//			int count = 0;
//			for(String beanName : context.getBeanDefinitionNames()) {
//				System.out.println(String.format("%03d : %s", ++count, beanName));
//			}
//			System.out.println("=".repeat(80));
//		};
//	}
}
