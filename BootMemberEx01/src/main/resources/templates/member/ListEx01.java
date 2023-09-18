package kr.human.list;

import java.util.ArrayList;
import java.util.LinkedList;

public class ListEx01 {
	public static void main(String[] args) {
		ArrayList<Integer> list1 = new ArrayList<>();
		for(int i=1;i<=9;i++) list1.add(i*i); // 제곱수로 초기화 // 추가
		list1.add(0,999);
		list1.add(0,888);
		list1.add(0,777); // 삽입
		list1.set(1, 555); // 수정
		list1.remove(2); // 삭제
		System.out.println(list1.size() + "개 : " + list1);
		for(int n : list1) System.out.printf("%5d", n);
		System.out.println();
		// 리스트의 값을 모두 2배로 만들어라
		for(int i=0;i<list1.size();i++) list1.set(i, list1.get(i)*2); // 읽어서 2배로 만들고 다시 넣는다.
		System.out.println(list1.size() + "개 : " + list1);
		System.out.println("-".repeat(60));
		
		LinkedList<Integer> list2 = new LinkedList<>();
		for(int i=1;i<=9;i++) list2.add(i*i); // 제곱수로 초기화
		list2.add(0,999);
		list2.add(0,888);
		list2.add(0,777);
		list2.set(1, 555); // 수정
		list2.remove(2); // 삭제
		System.out.println(list2.size() + "개 : " + list2);
		for(int n : list2) System.out.printf("%5d", n);
		System.out.println();
		// 리스트의 값을 모두 2배로 만들어라
		for(int i=0;i<list2.size();i++) list2.set(i, list2.get(i)*2); // 읽어서 2배로 만들고 다시 넣는다.
		System.out.println(list2.size() + "개 : " + list2);
		System.out.println("-".repeat(60));
	}
}
