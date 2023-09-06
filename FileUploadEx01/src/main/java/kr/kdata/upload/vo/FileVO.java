package kr.kdata.upload.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FileVO {
	private String uuid;		// 유일한 이름을 만들어 중복이름 처리할떄 사용할 ID
	private String fileName;	// 실제 파일이름
	private String contentType;	// 파일의 종류
}