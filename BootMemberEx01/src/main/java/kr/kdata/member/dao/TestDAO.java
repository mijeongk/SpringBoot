package kr.kdata.member.dao;

import java.util.Date;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TestDAO {
	Date selectToday();
}
