package kr.top2blue.calendar.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class ImageUtil {
	// 이미지 URL주소를 받아 저장하는 메서드
	public static void imageSave(int count, String urlAddress) {
		// 이미지 이름에서 뒤에 3글자 잘라내기
		String ext = urlAddress.substring(urlAddress.length()-3);
		// 저장 파일이름을 0001.확장자 형태로 저장할 이름을 만든다.
		String filename = String.format("%04d." + ext, count);
		System.out.println(filename);
		InputStream fis = null;  // 입력스트림
		FileOutputStream fos = null; // 출력스트림
		try {
			URL url = new URL(urlAddress);
			fis = url.openStream(); // 여기서 읽어서
			fos = new FileOutputStream(filename); // 여기로 저장
			
			byte[] data = new byte[2048]; // 이 크기에 따라 속도가 정해짐
			int n = 0;
			while((n=fis.read(data))>0) {
				fos.write(data, 0, n); // 읽은 크기만큼 저장을 한다.
				fos.flush(); // 버퍼의 내용을 파일로 보내고 버퍼를 비운다.
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
