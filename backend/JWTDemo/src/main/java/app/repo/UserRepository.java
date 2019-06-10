package app.repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import app.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	User findByEmail(String username);

	List<User> findAllByCreationDate(Date date);
	
	@Query("select u from User u where u.prn =?1")
	public User getByPrn(String a);
}
