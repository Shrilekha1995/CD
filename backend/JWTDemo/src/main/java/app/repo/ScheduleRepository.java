package app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import app.model.Schedule;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Integer>{

	@Query("select u from Schedule u where u.date =?1")
	  Schedule findByDate(String date);
	
	@Query("select u from Schedule u where u.date =?2 and u.courseId =?1")
	public Schedule getSubj(Integer a,String d1);
}
