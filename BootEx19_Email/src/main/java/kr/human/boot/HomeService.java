package kr.human.boot;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;

@Service
public class HomeService {

	public String getToday() {
		return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yy-MM-dd(E) hh:mm:ss.S"));
	}
}
