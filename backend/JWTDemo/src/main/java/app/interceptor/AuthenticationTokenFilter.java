package app.interceptor;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import app.config.JwtTokenUtil;
import app.config.JwtUser;

public class AuthenticationTokenFilter extends OncePerRequestFilter{

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	@Value("${jwt.header}")
	private String tokenHeader;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
/*		String authToken = request.getHeader(this.tokenHeader);
		if(authToken != null && authToken.length() > 7) {
			authToken = authToken.substring(7);
		}
*/		
		String authToken=jwtTokenUtil.resolveToken(request);
		//SecurityContextHolder.setStrategyName(SecurityContextHolder.MODE_GLOBAL);
		String userName = jwtTokenUtil.getUserNameFromToken(authToken);
	
		
		
		if(userName != null) {
			System.out.println("Line1 in filter------");
			System.out.println("Username-----------"+userName);
			UserDetails userDetails = this.userDetailsService.loadUserByUsername(userName);
			System.out.println("User details-------"+userDetails);
			System.out.println("Token-----------"+authToken);
			boolean isValid = jwtTokenUtil.validateToken(authToken);
			if(isValid) {
				//UsernamePasswordAuthenticationToken authenticationToken= new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
				//authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				//Authentication authentication = this.authenticationManager.authenticate(authenticationToken);
				//SecurityContextHolder.getContext().setAuthentication(authentication);
				System.out.println("in filter");
				//System.out.println(authenticationToken.getPrincipal());
				//HttpSession session = request.getSession();
				//session.setAttribute("security_context", SecurityContextHolder.getContext());
			}
		}
		filterChain.doFilter(request, response);
	}

	
}
