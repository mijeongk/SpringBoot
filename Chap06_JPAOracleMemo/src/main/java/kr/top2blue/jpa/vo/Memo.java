package kr.top2blue.jpa.vo;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Memo {
	@Id
	@GeneratedValue(generator = "generator", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "generator", sequenceName = "memo_id_seq", allocationSize = 1)
	private int id;
	private String name;
	private String password;
	private String content;
	private Date   regdate;
	private String ip;
	
	public Memo(String name, String password, String content, Date regDate, String ip) {
		this.name = name;
		this.password = password;
		this.content = content;
		this.regdate = regDate;
		this.ip = ip;
	}
}
