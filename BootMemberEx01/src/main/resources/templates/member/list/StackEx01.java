package kr.human.list;

import java.util.Stack;

public class StackEx01 {
	public static void main(String[] args) {
		Stack<String> stack = new Stack<>();
		stack.push("한놈");
		stack.push("두식이");
		stack.push("석삼");
		stack.push("너구리");
		stack.push("오징어"); // 넣기
		System.out.println(stack.size() + "개 : " + stack);
		
		System.out.println(stack.peek());
		System.out.println(stack.peek());
		System.out.println(stack.peek()); // 맛보기 : 맨위의 값을 얻어온다. 제거하지는 않는다.
		System.out.println(stack.size() + "개 : " + stack);
		
		System.out.println(stack.pop());
		System.out.println(stack.pop()); // 꺼내오기 : 맨위에 것을 1개씩 꺼내온다. 제거 된다.
		System.out.println(stack.size() + "개 : " + stack);
		
		// 모두 꺼내기
		while(!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}
}
