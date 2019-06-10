package app.config;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

import app.model.User;


public class JwtUser implements UserDetails{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int id;
	private final String username;
	private final String password;
	private final User user;
	private final Collection<? extends GrantedAuthority> authorities;
	private final boolean enabled;
	
	
	
	public JwtUser(int id, String username, String password, User user,
			Collection<? extends GrantedAuthority> authorities, boolean enabled) {
		
		super();
		System.out.println("JwtUser()..");
		this.id = id;
		this.username = username;
		this.password = password;
		this.user = user;
		this.authorities = authorities;
		this.enabled = enabled;
	}

	
	@JsonIgnore
	public int getId() {
		return id;
	}



	

	public User getUser() {
		return user;
	}



	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return authorities;
	}

	@Override
	public String getPassword() {
		
		return password;
	}

	@Override
	public String getUsername() {
		
		return username;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return enabled;
	}

	
}
