package app.controllers;

import java.awt.PageAttributes.MediaType;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import app.config.JwtTokenUtil;
import app.config.JwtUser;
import app.domain.DateDTO;
import app.domain.Response;
import app.model.Address;
import app.model.Course;
import app.model.CourseDetails;
import app.model.Room;
import app.model.Schedule;
import app.model.User;
import app.services.CoordinatorService;
import app.services.ScheduleService;
import app.services.UserService;


@RestController
@CrossOrigin
public class ScheduleController {

	@Autowired
	private ScheduleService schService;
	@Autowired
	private CoordinatorService crdService;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@PostMapping("/schedule")
	public ResponseEntity<Response> setSchedule(@RequestBody Schedule sch){
		System.out.println("herer in schedule");
		System.out.println(" "+sch.getDate());
		Schedule sch11 = schService.save(sch);
		if(sch11 != null) {
			return new ResponseEntity<Response>(new Response("schedule is saved successfully"),HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<Response>(new Response("couldn't store the schedule"),HttpStatus.OK);
		}
		
		
	}
	
	
	@PostMapping("/addCourses")
	public ResponseEntity<Response> addCourse(@RequestBody CourseDetails courseDets,HttpServletRequest request){
		ResponseEntity<Response> rp=null;
		CourseDetails courseDets1=null;
		System.out.println("herer in course");
		String token=jwtTokenUtil.resolveToken(request);
		  String name=jwtTokenUtil.getUserNameFromToken(token);
		  
		System.out.println(" "+courseDets);
		try{ 
		courseDets1 = crdService.saveCourseDets(courseDets);
	
			rp= new ResponseEntity<Response>(new Response("course is saved successfully"),HttpStatus.OK);
	        
		}catch(Exception e)
		{
			System.out.println("in null response");
		    rp= new ResponseEntity<Response>(new Response("couldn't store the course details !!Course id doesn't match"),HttpStatus.OK);
		 }

	    return rp;
	}
	
	
	@PostMapping("/addAllCourses")
	public ResponseEntity<Response> addAllCourse(@RequestBody Course course,HttpServletRequest request){
		ResponseEntity<Response> rp=null;
		System.out.println("herer in course");
		String token=jwtTokenUtil.resolveToken(request);
		  String name=jwtTokenUtil.getUserNameFromToken(token);
		  System.out.println(name);
		System.out.println(" "+course);
		Course course1 = crdService.saveAllCourse(course);
		if(course1 != null) {
			System.out.println("course is saved successfully");
			int id=crdService.getCourseId(course.getCourseName());
			System.out.println("id"+id);
			rp= new ResponseEntity<Response>(new Response(id),HttpStatus.OK);
		}
		else
		{
			rp= new ResponseEntity<Response>(new Response("couldn't store the course details"),HttpStatus.OK);
		}

	    return rp;
	}
	
	
     @PostMapping("/viewschedule")
	public ResponseEntity<Schedule> viewSchedule(@RequestBody Schedule sch,HttpServletRequest request) throws ParseException{
	  System.out.println(sch.getDate()); 
	  String token=jwtTokenUtil.resolveToken(request);
	  String name=jwtTokenUtil.getUserNameFromToken(token);
	  
	  System.out.println(name);
	  ResponseEntity<Schedule> rp=null;
	   Schedule sch11=null;
	   sch11 = schService.getTodaySch(sch.getDate());
		 System.out.println(sch11);	
		 	rp= new ResponseEntity<Schedule>(sch11,HttpStatus.OK);
		return rp;
	
    	// return null;
       }
     
     @PostMapping("/saveRoomData")
 	public ResponseEntity<Response> saveRoomData(@RequestBody Room rm,HttpServletRequest request) 
     {
 	  System.out.println(rm); 
 	 String token=jwtTokenUtil.resolveToken(request);
	  String name=jwtTokenUtil.getUserNameFromToken(token);
	  
 	   ResponseEntity<Response> rp=null;
 	  Room rm1=null;
 	   rm1 = schService.saveRoomDets(rm);
		if(rm1 != null) {
			rp= new ResponseEntity<Response>(new Response("room details saved successfully"),HttpStatus.OK);
		}
		else
		{
			rp= new ResponseEntity<Response>(new Response("couldn't store the room  details,try again"),HttpStatus.OK);
		}
       return rp;  
     }
     
  
     
     
     @PostMapping("/address")
 	public ResponseEntity<Response> addAddress(@RequestBody Address adr){
 		
    	 System.out.println(adr);
    	 ResponseEntity<Response> rp=null;
 		 try
 		 {
    	   Address adr1 = crdService.saveAddress(adr);
 		
 		   rp= new ResponseEntity<Response>(new Response("address is saved successfully"),HttpStatus.OK);
 		
 		
 		 }
 		 catch(Exception e)
 		 {
 			rp= new ResponseEntity<Response>(new Response("couldn't store the address,try again"),HttpStatus.OK);
 		 }

 	    return rp;
 	}
     
     
	
}
