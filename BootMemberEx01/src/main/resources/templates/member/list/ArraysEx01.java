package kr.human.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysEx01 {
	public static void main(String[] args) {
		int ar[] = new int[20];
		System.out.println(ar.length + "개 : " + ar);
		System.out.println(ar.length + "개 : " + Arrays.toString(ar));
		// 배열을 같은값으로 초기화 해라.
		for(int i=0;i<ar.length;i++) {
			ar[i] = 1;
		}
		System.out.println(ar.length + "개 : " + Arrays.toString(ar));
		
		// 배열을 같은값으로 초기화 해라.
		Arrays.fill(ar, 22);
		System.out.println(ar.length + "개 : " + Arrays.toString(ar));
		
		// 배열을 1, 3, 5, 7, 9.... 초기화 해라.
		for(int i=0;i<ar.length;i++) {
			ar[i] = (i+1)*2 -1;
		}
		System.out.println(ar.length + "개 : " + Arrays.toString(ar));
		
		// 배열을 2, 4, 6, 8, 10.... 초기화 해라.
		Arrays.setAll(ar, (i)->(i+1)*2); // 람다식 이용해서 초기화
		System.out.println(ar.length + "개 : " + Arrays.toString(ar));
		
		List<String> list1 = new ArrayList<>();
		list1.add("하나");
		list1.add("둘");
		list1.add("셋");
		System.out.println(list1.size() + "개 : " + list1);
		
		List<String> list2 = Arrays.asList("하나","둘","셋","넷"); // 목록을 리스트로
		System.out.println(list2.size() + "개 : " + list2);
		
		List<String> list3 = Arrays.asList("하나,둘,셋,넷".split(",")); // 배열을 리스트로
		System.out.println(list3.size() + "개 : " + list3);
		
		List<Integer> list4 = Arrays.asList(1,2, 3, 4, 5, 6);
		System.out.println(list4.size() + "개 : " + list4);
		
		// List<Integer> list5 = Arrays.asList(new int[] {1,2,3,4,5,6}); // 에러이다. 왜? 객체 배열만 된다.
		List<Integer> list5 = Arrays.asList(new Integer[] {1,2,3,4,5,6}); // 객체 배열만 된다.
		System.out.println(list5.size() + "개 : " + list5);
		System.out.println();
		
		// 리스트를 배열로 만들기
		Object[] arr1 = list3.toArray(); // Object배열이 된다.
		System.out.println(arr1.length + "개 : " + Arrays.toString(arr1));
		
		String[] arr2 = list3.toArray(new String[list3.size()]);
		System.out.println(arr2.length + "개 : " + Arrays.toString(arr2));
		
		//int[] arr3 = list4.toArray(new int[list4.size()]); // 에러다!!! 객체만 된다.
		Integer[] arr3 = list4.toArray(new Integer[list4.size()]); // 에러다!!! 객체만 된다.
		System.out.println(arr3.length + "개 : " + Arrays.toString(arr3));
		
	}
}
