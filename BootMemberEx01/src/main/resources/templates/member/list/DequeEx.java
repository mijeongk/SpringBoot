package kr.human.list;

import java.util.LinkedList;

public class DequeEx {
	// Deque : 앞뒤로 모두 입출력이 가능한 자료구조!!!!
	public static void main(String[] args) {
		LinkedList<Integer> deque = new LinkedList<>();
		
		deque.offer(11); // 추가
		deque.offerFirst(22); // 앞에 추가
		deque.offerLast(33); // 뒤에 추가
		deque.offerFirst(44); // 앞에 추가
		deque.offerLast(55); // 뒤에 추가
		
		System.out.println(deque.size() + "개 : " + deque);
		System.out.println(deque.poll());
		System.out.println(deque.pollFirst());
		System.out.println(deque.pollLast());
	}
}
