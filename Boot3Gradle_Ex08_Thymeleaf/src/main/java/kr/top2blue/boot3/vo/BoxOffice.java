package kr.top2blue.boot3.vo;

import java.util.List;

import lombok.Data;

@Data
public class BoxOffice {

	private BoxOfficeResult boxOfficeResult;
	
	@Data
	public static class BoxOfficeResult{
		private String boxofficeType;
		private String showRange;
		private List<DailyBoxOfficeList> dailyBoxOfficeList;
	}
	
	@Data
	public static class DailyBoxOfficeList{
		private String rank;
		private String movieNm;
		private String openDt;
	}
}
