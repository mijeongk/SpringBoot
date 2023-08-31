package kr.dwacademy.chap03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Chap03ApplicationTests {

	@DisplayName("test1() 테스트를 합니다.")
	@Test
	public void test1() {
		// 테스트할 코드를 사용한다.
		int a=1, b=2, sum=4;
		assertEquals(a+b, sum);
		
	}

}
