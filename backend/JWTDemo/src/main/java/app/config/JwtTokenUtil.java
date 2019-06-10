package app.config;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenUtil implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static final String CLAIM_KEY_USERNAME="sub";
	//static final String CLAIM_KEY_AUDIENCE="audience";
	static final String CLAIM_KEY_CREATED="created";
	
	@Value("${jwt.secret}")
	private String secret;
	@Value("${jwt.expiration}")
	private Long expiration;
	
	@Autowired
	private JwtUserDetailsServiceImpl userDetailsService;
	

	public String generateToken(Authentication auth) {
		System.out.println("JwtTokenUtil generateToken()..");
		return Jwts.builder().setSubject(auth.getName())
				.claim("authorities", auth.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
				.setIssuedAt(new Date()).setExpiration(generateExpirationDate()).signWith(SignatureAlgorithm.HS512,secret.getBytes()).compact();
	}

	
	private Date generateExpirationDate() {
		Date now=new Date();
		return new Date(now.getTime()+ expiration *1000);
	}

	
	public String getUserNameFromToken(String token) {
		System.out.println("JwtTokenUtil getUserNameFromToken()..");
		String username=null;
		try {
			//final Claims claims = getClaimsFromToken(token);
			username=((Claims) Jwts.parser().setSigningKey(secret.getBytes()).parse(token).getBody()).getSubject();
		}catch (Exception e) {
			username=null;
		}
		
		return username;
	}


	public boolean validateToken(String authToken) {
//		JwtUser user = (JwtUser) userDetails;
		System.out.println("JwtTokenUtil validateToken()");
		final String username=getUserNameFromToken(authToken);
		
		//return (username.equals(user.getUsername()) && !isTokenExpired(authToken));

	try {
	;
		if(((Claims) Jwts.parser().setSigningKey(secret.getBytes()).parse(authToken).getBody()).getExpiration().before(new Date())) {
			return false;
		}
		System.out.println("Username in validate token-----"+username);
		return true;
	}catch(JwtException | IllegalArgumentException e) {
		throw new JwtException("Expired token");
	}
}
	
	
	public String resolveToken(HttpServletRequest request) {
		System.out.println("JwtTokenUtil resolveToken()");
		String token = request.getHeader("Authorization");
		if(token !=null && token.startsWith("Bearer")) {
			return token.substring(7,token.length());
		}
		return null;
	}

	private boolean isTokenExpired(String authToken) {
		final Date expiration = getExpirationDateFromToken(authToken);
		return expiration.before(new Date());
	}

	private Date getExpirationDateFromToken(String authToken) {
		Date expiration=null;
		try {
			expiration=((Claims) Jwts.parser().setSigningKey(secret.getBytes()).parse(authToken).getBody()).getExpiration();
			if(expiration != null) {
				return expiration;
			}else {
				expiration=null;
			}
		}catch (Exception e) {
			expiration=null;
		}
		return expiration;
	}


	
	
	 
}
