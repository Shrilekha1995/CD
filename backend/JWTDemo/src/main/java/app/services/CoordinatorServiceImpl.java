package app.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.model.Address;
import app.model.Course;
import app.model.CourseDetails;
import app.repo.AddCourseRepository;
import app.repo.AddressRepository;
import app.repo.CoordRepository;

@Service
@Transactional
public class CoordinatorServiceImpl implements CoordinatorService 
{
	
	@Autowired
	private CoordRepository cR;
	@Autowired
	private AddCourseRepository acr;
	@Autowired
	private AddressRepository adr1;
	
	
	@Override
	public CourseDetails saveCourseDets(CourseDetails courseDets) throws Exception {
		// TODO Auto-generated method stub
		 return cR.save(courseDets);
	}
	

	@Override
	public Course saveAllCourse(Course course) {
		// TODO Auto-generated method stub
		return acr.save(course);
	}
	
	@Override
	public Address saveAddress(Address adr) throws Exception  {
		// TODO Auto-generated method stub
		return adr1.save(adr);
	}


	@Override
	public Integer getCourseId(String name) {
		// TODO Auto-generated method stub
		return acr.findIdByCourseName(name);
	}
	
	
	
}
