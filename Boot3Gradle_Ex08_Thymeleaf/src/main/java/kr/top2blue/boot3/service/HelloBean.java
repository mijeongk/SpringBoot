package kr.top2blue.boot3.service;

import org.springframework.stereotype.Component;

@Component("helloBean")
public class HelloBean {
	public String hello(String name) {
		return " 반갑습니다. " + name + "님!!!";
	}
}
