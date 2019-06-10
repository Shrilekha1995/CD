package app.services;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.model.User;
import app.repo.UserRepository;
import app.util.PasswordUtil;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User save(User user) {
		String password = PasswordUtil.getPasswordHash(user.getPassword());
		user.setPassword(password);
		user.setCreationDate(new Date());
		return userRepository.save(user);
	}

	@Override
	public List<User> findAll() {
		
		return (List<User>)userRepository.findAll();
	}

	@Override
	public User getUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public List<User> findByCreationDate(Date dt) {
		// TODO Auto-generated method stub
		return userRepository.findAllByCreationDate(dt);
	}

	@Override
	public User getUserByPrn(String prn) {
		// TODO Auto-generated method stub
		return userRepository.getByPrn(prn);
	}
	
	
}
