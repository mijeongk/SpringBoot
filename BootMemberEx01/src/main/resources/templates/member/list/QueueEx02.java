package kr.human.list;

import java.util.PriorityQueue;

public class QueueEx02 {
	// 큐(Queue) : FIFO(First In First Out) : 먼저 들어온 놈을 먼저 처리한다.
	public static void main(String[] args) {
		// Queue는 인터페이스이므로 사용시에는 인터페이스를 구현한 클래스를 사용해야 한다.
		// 우선순위큐 : 꺼낼때 작은놈부터 꺼내진다.
		PriorityQueue<String> pQueue = new PriorityQueue<>();
		pQueue.offer("한놈");
		pQueue.offer("두식이");
		pQueue.offer("석삼");
		pQueue.offer("너구리");
		
		System.out.println(pQueue.size() + "개 : " + pQueue);
		System.out.println(pQueue.poll());
		while(!pQueue.isEmpty()) {
			System.out.println(pQueue.poll());
		}
	}
}
