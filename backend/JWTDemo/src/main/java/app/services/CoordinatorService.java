package app.services;

import app.model.Address;
import app.model.Course;
import app.model.CourseDetails;

public interface CoordinatorService {
    CourseDetails saveCourseDets(CourseDetails courseDets) throws Exception;
	
	Course saveAllCourse(Course course);
	Address saveAddress(Address adr) throws Exception ;
	
	Integer getCourseId(String name);
}
