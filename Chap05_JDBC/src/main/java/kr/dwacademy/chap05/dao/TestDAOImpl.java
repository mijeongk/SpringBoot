package kr.dwacademy.chap05.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("testDAO") // 스프링 컨테이너에게 DAO객체를 등록한다.
public class TestDAOImpl implements TestDAO{
	@Autowired
	private DataSource dataSource;
	@Override
	public String selectToday() {
		String today="";
		Connection conn = null;
		Statement  stmt = null;
		ResultSet  rs = null;
		try {
			conn = dataSource.getConnection();// 연결 객체 생성
			stmt = conn.createStatement(); // 명령 객체 생성
			rs = stmt.executeQuery("select sysdate from dual"); // SQL명령 실행
			if(rs.next()) {
				today = rs.getString(1); // 날짜 얻기
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return today;
	}

}
