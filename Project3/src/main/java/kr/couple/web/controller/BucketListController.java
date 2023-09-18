package kr.couple.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.couple.web.service.BucketListService;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping(value = "/bucketList")
@Slf4j
public class BucketListController {

	@Autowired
	private BucketListService bucketListService;
	// -----------------------------------------------------------------------------------------
	// 목록보기
	//	@RequestMapping(value = {"/", "/bucketList"})
	
}
