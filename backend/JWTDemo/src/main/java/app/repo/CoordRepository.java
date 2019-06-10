package app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.model.CourseDetails;
import app.model.Schedule;

@Repository
public interface CoordRepository extends JpaRepository<CourseDetails,Integer>{
}
