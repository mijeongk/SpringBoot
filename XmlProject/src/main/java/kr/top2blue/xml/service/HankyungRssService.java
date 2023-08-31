package kr.top2blue.xml.service;

import java.io.IOException;
import java.net.URL;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import kr.top2blue.xml.vo.HankyungRss;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class HankyungRssService {

	public HankyungRss getHankyungRss(String urlAddress) {
		log.info("getHankyungRss 호출 : {}", urlAddress);
		HankyungRss rss = null;
		
		XmlMapper xmlMapper = new XmlMapper();
		try {
			rss = xmlMapper.readValue(new URL(urlAddress), HankyungRss.class);
		} catch (IOException e) {
			e.printStackTrace();
		}

		log.info("getHankyungRss 리턴 : {}", rss);
		return rss;
	}
}
