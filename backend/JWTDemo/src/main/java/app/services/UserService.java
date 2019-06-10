package app.services;

import java.util.Date;
import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;

import app.model.User;

public interface UserService {

	User save(User user);
	
//	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	List<User> findAll();

	//@PreAuthorize("hasRole('ROLE_USER')")
	User getUserByEmail(String name);
	User getUserByPrn(String prn);
	List<User> findByCreationDate(Date dt);
}
