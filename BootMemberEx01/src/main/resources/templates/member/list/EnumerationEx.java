package kr.human.list;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

public class EnumerationEx {
	public static void main(String[] args) {
		String[] names = "한놈,두식이,석삼,너구리,오징어,육개장,칠면조,팔공산,구공탄,십장생".split(",");
		Vector<String> v = new Vector<>();
		for(String name : names) { // 배열을 Vector에 넣기
			v.add(name);
		}
		
		System.out.println(v.size() + "개 : " + v);
		
		// 반복 1
		for(int i=0;i<v.size();i++) 
			System.out.printf("%-6s", v.get(i));
		System.out.println("\n" + "-".repeat(100));
		
		// 반복 2
		for(String name : v) 
			System.out.printf("%-6s", name);
		System.out.println("\n" + "-".repeat(100));

		// 반복 3
		Enumeration<String> em = v.elements(); // 옛날것 : element가 다 붙어있다.
		while(em.hasMoreElements()) 
			System.out.printf("%-6s", em.nextElement());
		System.out.println("\n" + "-".repeat(100));

		// 반복 4
		Iterator<String> it = v.iterator();
		while(it.hasNext()) 
			System.out.printf("%-6s", it.next());
		System.out.println("\n" + "-".repeat(100));
		
	}
}
