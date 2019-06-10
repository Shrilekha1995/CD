package app.services;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import app.model.Communication;
import app.model.User;
import app.repo.CommunicationRepository;

@Service
public class NotificationService {
	
	@Autowired
	private CommunicationRepository commRepo;

	private JavaMailSender javaMailSender;
	
	/*@Value("${spring.mail.password:}")
	private String password;*/
	
	@Autowired
	public NotificationService(JavaMailSender javaMailSender)
	{
		this.javaMailSender=javaMailSender;
	}
	
	public void sendNotification(String from,User user,String msg)throws MailException
	{
		System.out.println("in sendNotification()");
		SimpleMailMessage mail= new SimpleMailMessage();
	
		
		mail.setFrom(from);
		
		mail.setTo(user.getEmail());
		System.out.println(user.getEmail());
		//mail.setFrom("shrilekha3232@gmail.com");
		mail.setSubject("trial java api email");
		mail.setText(msg);
		
		javaMailSender.send(mail);
		
		System.out.println("msg sent");
		commRepo.save(new Communication(from, user.getEmail(), msg));
	}
}
