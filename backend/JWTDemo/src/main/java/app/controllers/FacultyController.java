package app.controllers;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.config.JwtTokenUtil;
import app.config.JwtUser;
import app.domain.UserDTO;
import app.exceptions.UnauthorizedException;
import app.model.Communication;
import app.model.User;
import app.services.NotificationService;

@RestController
public class FacultyController {
	@Value("${jwt.header}")
	private String tokenHeader;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	private Logger logger =LoggerFactory.getLogger(FacultyController.class);
	
	@Autowired
	private NotificationService notificationService;
	@PostMapping("/cancelClass")	
      public/* ResponseEntity<UserDTO>*/String cancelClass(@RequestBody Communication msg,HttpServletRequest request){
		
		System.out.println("in faculty controller................................");
		System.out.println(msg.getSourceId());
		System.out.println(msg.getMessage());
		
		msg.setSourceId(jwtTokenUtil.getUserNameFromToken(msg.getSourceId()));
		System.out.println("email:"+msg.getSourceId());
	    String message=msg.getMessage();
	    String srcEmail=msg.getSourceId();
	    
	    //int CurrentUserId=msg.getId();
	    //System.out.println("current user id is"+CurrentUserId);
	  //  User currentUser=getEmailbyId(;
		
		//System.out.println(msg);
		User user1 =new User("admin","adminlastname","shrilekha3232@gmail.com");
		try{
	      notificationService.sendNotification(srcEmail,user1,message);
		}catch(MailException e){
			
			logger.info("error sending email" + e.getMessage());
		}
		
		return " faculty controller ";	
	}
	
	
	
	

}
