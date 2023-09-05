package kr.human.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMessage.RecipientType;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MailController {

	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	private HomeService homeService;
	
	@Autowired
	private MailService mailService;
	
	
	// javaMailSender만으로 메일 보내기
	@GetMapping("/mail1")
	public String mailSend1(Model model) throws MessagingException {
		MimeMessage message = javaMailSender.createMimeMessage();
		message.setFrom("ithuman202303@gmail.com");
		message.setRecipients(RecipientType.TO, "ithuman202303@gmail.com");
		message.setSubject("하하하하 제목이래");
		message.setText("<h1>ㅋㅋㅋ 내용이라네요</h1>");
		
		javaMailSender.send(message);
		return "index";
	}
	
	
	
	
	@GetMapping(value = "/")
	public String index(Model model) {
		log.info("메일보내기를 시작합니다.....");
		MailHandler MailHandler = null;
		try {
			MailHandler = new MailHandler(javaMailSender);
			MailHandler.setFrom("ithuman202303@gmail.com", "웹마스터");
			MailHandler.setTo("ithuman202303@gmail.com");
			MailHandler.setSubject("정말 메일이 갈까요?");
			MailHandler.setText("<h1>하하하 태그가 먹을까?</h1>");
			MailHandler.send();
			
			// 서비스를 이용한 메일보내기
			mailService.mailSend("ithuman202303@gmail.com", "ithuman202303@gmail.com", "갈까?", "<h1>꽝!!!</h1>");

			// 그림도 가능할까?
			StringBuffer sb = new StringBuffer();
			sb.append("<h1>나는 내용이다.</h1>");
			sb.append("그림이 들어갈까? <br>");
			sb.append("<img src='cid:logo'/>");
			
			mailService.mailSend2("ithuman202303@gmail.com", "ithuman202303@gmail.com", "갈까?", sb.toString(),"logo");
			
			// 실제 메일에서 사용할 이미지 별명과 실제이미지 이름들...
			String[] cids = {"logo1", "logo2", "noimage"}; // 이미지 별명
			String[] filenames = {"linux-icon2.png", "linux-icon.png", "no_images.jpg"}; //  실제 서버에 있는 이미지 이름
			
			// 메일 내용에서는 별칭을 이용하여 만들어야 한다. 
			StringBuffer sb2 = new StringBuffer();
			sb2.append("<h1>나는 내용이다.</h1>");
			sb2.append("그림이 들어갈까? <br>");
			sb2.append("<img src='cid:logo2'/>");
			sb2.append("그림이 들어갈까? <br>");
			sb2.append("<img src='cid:logo1'/>");
			sb2.append("크크크크크크크");
			sb2.append("<img src='cid:noimage'/>");
			mailService.mailSend3("ithuman202303@gmail.com", "ithuman202303@gmail.com", "갈까5555555?", sb2.toString(),cids, filenames);
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		String serverTime = homeService.getToday();
		log.info("서버시간 : {}", serverTime);
		model.addAttribute("serverTime", serverTime);
		return "index";
	}
}
