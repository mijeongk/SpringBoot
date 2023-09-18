package kr.human.list;

import java.util.Stack;

public class StackEx03 {
	public static void main(String[] args) {
		String[] str = {"()()","(())()",")()(","(()("}; // true, true, false, false
		loop:
		for(String s : str) {
			Stack<String> stack = new Stack<>();
			for(char ch : s.toCharArray()) {
				if(ch=='(') { // 여는 괄호면 스택에 넣는다.
					stack.push(ch+"");
				}else { // 닫는 괄호라면
					// 스택이 비어 있으면 짝이 맞지 않는 괄호
					if(stack.isEmpty()) {
						System.out.println(false);
						continue loop;
					}else {
						// 비어있지 않으면 스택에서꺼내서 버린다.
						stack.pop();
					}
				}
			}
			// 이 반복문이 끝났을때 스택이 비어있으면 맞는 괄호 남아있으면 짝이 맞지 않는 괄호
			System.out.println(stack.isEmpty());
		}
	}
}
