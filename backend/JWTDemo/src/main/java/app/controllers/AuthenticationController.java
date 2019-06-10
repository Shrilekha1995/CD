package app.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import app.config.JwtTokenUtil;
import app.config.JwtUser;
import app.domain.UserDTO;
import app.exceptions.UnauthorizedException;
import app.model.User;

@RestController
public class AuthenticationController {

	@Value("${jwt.header}")
	private String tokenHeader;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@PostMapping("/login")
	public ResponseEntity<UserDTO> login(@RequestBody User user, HttpServletRequest request, HttpServletResponse response){
		
		System.out.println("in login................................");
		try {
			//SecurityContext securityContext = (SecurityContext) session.getAttribute("security_context");
		//	System.out.println("Authentication "+SecurityContextHolder.getContext().getAuthentication());
			System.out.println(user.getEmail());
			UsernamePasswordAuthenticationToken authenticationToken= new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword());
				//authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
			Authentication authentication = authenticationManager.authenticate(authenticationToken);
		
			//final Authentication authentication = securityContext.getAuthentication();
			final JwtUser userDetails = (JwtUser) authentication.getPrincipal();
			
			final String token = jwtTokenUtil.generateToken(authentication);
			System.out.println("Token---------"+token);
			System.out.println("Username from token-------"+jwtTokenUtil.getUserNameFromToken(token));
			
			System.out.println("User details--"+userDetails);
			System.out.println("Authentication--"+authentication);
			//SecurityContextHolder.setStrategyName(SecurityContextHolder.MODE_GLOBAL);
			SecurityContext securityContext = SecurityContextHolder.getContext();
			securityContext.setAuthentication(authentication);
			System.out.println("Authentication Token--"+securityContext.getAuthentication().getName());
			System.out.println("Principal--"+authenticationToken.getPrincipal());
			//SecurityContextHolder.setContext(securityContext);
			
			response.setHeader("Token", token);
			HttpSession session = request.getSession();
			System.out.println(session.getId());
			//session.setAttribute("security_context", securityContext);
			return new ResponseEntity<UserDTO>(new UserDTO(userDetails.getUser(),token),HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<UserDTO>(new UserDTO("Invalid Credentials!!"),HttpStatus.OK);
			//throw new UnauthorizedException(e.getMessage());
		}
	}
}
