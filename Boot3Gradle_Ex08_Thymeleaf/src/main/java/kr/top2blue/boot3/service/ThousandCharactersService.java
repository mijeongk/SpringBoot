package kr.top2blue.boot3.service;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import kr.top2blue.boot3.vo.BibleNameVO;
import kr.top2blue.boot3.vo.BoxOffice;
import kr.top2blue.boot3.vo.FestivalVO;
import kr.top2blue.boot3.vo.HankyungRss;
import kr.top2blue.boot3.vo.ThousandCharacters;
import kr.top2blue.boot3.vo.ThousandCharacters2;

@Service("thousandCharactersService")
public class ThousandCharactersService {

	public List<ThousandCharacters> getHousandCharacters() {
		List<ThousandCharacters> list = new ArrayList<>();
		try {
			List<String> lines = Files.readAllLines(Paths.get("src/main/resources/static/data/chunja.txt"));
			for (String line : lines) {
				String[] t = line.split("\\|");
				list.add(new ThousandCharacters(Integer.parseInt(t[0]), t[1], t[2], t[3]));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<ThousandCharacters2> getHousandCharacters2() {
		List<ThousandCharacters2> list = new ArrayList<>();
		try {
			List<String> lines = Files.readAllLines(Paths.get("src/main/resources/static/data/chunja2.txt"));
			for (String line : lines) {
				String[] t = line.split("\\|");
				list.add(new ThousandCharacters2(Integer.parseInt(t[0]), t[1], t[2], t[3], t[4]));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public List<BibleNameVO> getBibleNames() {
		List<BibleNameVO> list = null;
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			list = objectMapper.readValue(new File("src/main/resources/static/data/bible_name.json"), List.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public BoxOffice getBoxOffice() {
		BoxOffice boxOffice = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			// 옵션 지정이 가능하다.
			// 알 수 없는 속성이 발생할 때 예외를 방지
			mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
			// 빈 문자열을 null 객체 값으로 강제 변환 허용
			mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
			// 어제 날짜
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DATE, -1);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			String urlAddress = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json";
			urlAddress += "?key=f5eef3421c602c6cb7ea224104795888";
			urlAddress += "&targetDt=" + sdf.format(cal.getTime());
			
			boxOffice = mapper.readValue(new URL(urlAddress), BoxOffice.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return boxOffice;
	}
	
	public HankyungRss getHankyungRss() {
		HankyungRss rss = null;
		XmlMapper mapper = new XmlMapper();
		String urlAddress = "https://www.hankyung.com/feed/it";
		// String urlAddress = "https://rss.hankyung.com/feed/land";
		try {
			rss = mapper.readValue(new URL(urlAddress), HankyungRss.class);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return rss;
	}
	
	public FestivalVO getFestival() {
		FestivalVO festivalVO = null;
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			// File에서 읽기
			festivalVO = objectMapper.readValue(new File("src/main/resources/static/data/전국문화축제표준데이터.json"), FestivalVO.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return festivalVO;
	}
}
