package kr.human.list;

import java.util.Stack;

public class StackEx05 {
	public static void main(String[] args) {
	    System.out.println(solution("(){}[]"));             //true 
	    System.out.println(solution("{(})}){)}{(}{)})("));  //false
	    System.out.println(solution("{([])}"));             //true
	    System.out.println(solution("{[}]"));               //false
	}
	public static boolean solution(String s) {
		Stack<Character> stack = new Stack<>();
		for (char ch : s.toCharArray()) {
			switch (ch) {
			case ')': 
				if(!stack.isEmpty() && stack.peek()=='(') stack.pop();
				break;
			case '}': 
				if(!stack.isEmpty() && stack.peek()=='{') stack.pop();
				break;
			case ']': 
				if(!stack.isEmpty() && stack.peek()=='[') stack.pop();
				break;
			default:
				stack.push(ch);
				break;
			}
		}
		// 이 반복문이 끝났을때 스택이 비어있으면 맞는 괄호 남아있으면 짝이 맞지 않는 괄호
		return stack.isEmpty();
	}
}
