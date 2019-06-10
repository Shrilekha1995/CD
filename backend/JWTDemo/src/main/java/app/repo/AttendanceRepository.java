package app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import app.model.Attendance;
import app.model.User;

@Repository
public interface AttendanceRepository extends  JpaRepository<Attendance,Integer> {

	@Query("select u from Attendance u where u.prn =?1")
	public List<Attendance> getByPrn(String a);
	
}
