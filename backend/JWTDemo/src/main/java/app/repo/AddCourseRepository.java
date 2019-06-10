package app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import app.model.Course;


@Repository
public interface AddCourseRepository extends JpaRepository<Course,Integer>{

	@Query(value="select course_id from courses  where course_name=?1 limit 1",nativeQuery=true)
	public Integer findIdByCourseName(String name);
}
