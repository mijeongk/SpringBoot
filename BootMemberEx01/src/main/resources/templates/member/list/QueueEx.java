package kr.human.list;

import java.util.LinkedList;

public class QueueEx {
	// 큐(Queue) : FIFO(First In First Out) : 먼저 들어온 놈을 먼저 처리한다.
	public static void main(String[] args) {
		LinkedList<Integer> queue = new LinkedList<>();
		queue.offer(1);
		queue.offer(2);
		queue.offer(3);
		queue.offer(4); // 넣기
		System.out.println(queue.size() + "개 : " + queue);
		System.out.println(queue.peek());
		System.out.println(queue.peek()); // 맛보기. 제거되지 않는다.
		System.out.println(queue.size() + "개 : " + queue);
		
		System.out.println(queue.poll());
		System.out.println(queue.poll()); // 맨앞의 놈을 꺼내서 제거한다.
		System.out.println(queue.size() + "개 : " + queue);
		
		while (!queue.isEmpty()) {
			System.out.println(queue.poll());
		}
		System.out.println(queue.size() + "개 : " + queue);
	}
}
