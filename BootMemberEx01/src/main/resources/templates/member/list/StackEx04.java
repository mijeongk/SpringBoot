package kr.human.list;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Stack;

import org.junit.jupiter.api.Test;

public class StackEx04 {
	public boolean solution(String s) {
		Stack<String> stack = new Stack<>();
		for (char ch : s.toCharArray()) {
			if (ch == '(') { // 여는 괄호면 스택에 넣는다.
				stack.push(ch + "");
			} else { // 닫는 괄호라면
				// 스택이 비어 있으면 짝이 맞지 않는 괄호
				if (stack.isEmpty()) {
					return false;
				} else {
					// 비어있지 않으면 스택에서꺼내서 버린다.
					stack.pop();
				}
			}
		}
		// 이 반복문이 끝났을때 스택이 비어있으면 맞는 괄호 남아있으면 짝이 맞지 않는 괄호
		return stack.isEmpty();
	}

	@Test
	public void test() {
		StackEx04 ex = new StackEx04();
		assertTrue(ex.solution("()()"));
		assertTrue(ex.solution("(())()"));
		assertFalse(ex.solution(")()("));
		assertFalse(ex.solution("(()("));
	}
}
