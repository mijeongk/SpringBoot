package kr.top2blue.boot3.vo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyDataVO {
	private String string;
	private int number;
	private List<Integer> array;
	private InnerData object;
	
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class InnerData{
		private String property;
		private InnerData2 subobj;
	}

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class InnerData2{
		private String[] arr;
		private int numero;
	}
}
