package app.controllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.Principal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import app.config.JwtTokenUtil;
import app.config.JwtUser;
import app.domain.AttendanceDets;
import app.domain.DateDTO;
import app.domain.UserDTO;
import app.model.Attendance;

import app.model.User;
import app.services.AttendanceService;
import app.services.ScheduleService;
import app.services.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private ScheduleService schService;
	@Autowired
	private AttendanceService attendanceService;
	
	@GetMapping("/users")
	//@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<List<User>> getAllUsers(){
		System.out.println("in getAllUsers()");
		List<User> users = userService.findAll();
		users.forEach(System.out::println);
		return new ResponseEntity<List<User>>(users,HttpStatus.OK);
		
	}
	
	@GetMapping("/getuser")
	//@PreAuthorize("hasRole('USER')")
	public ResponseEntity<User> getUser(HttpServletRequest request){
		System.out.println("in getUSer()");
		//System.out.println("getting session");
		HttpSession session=request.getSession();
		System.out.println(session.getId());
		//System.out.println("Principal "+principal);
		
		String token=jwtTokenUtil.resolveToken(request);
		System.out.println("Token recieved----"+token);
		String username=jwtTokenUtil.getUserNameFromToken(token);
		System.out.println("Username:"+username);
		
		//SecurityContext securityContext = (SecurityContext)session.getAttribute("security_context");
		//Authentication authentication =securityContext.getAuthentication();
		//Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		//final JwtUser usern=(JwtUser) authentication.getPrincipal();
		//System.out.println(principal);
		//System.out.println(principal);
//		System.out.println("Principal "+principal.getName());
		//User usert=(User)session.getAttribute("userName");
		//System.out.println(usert);
		//System.out.println(principal.getName());
		//System.out.println("Authentication---------"+principal);
		//System.out.println("Authentication Token "+principal.getName());
		User user1 = userService.getUserByEmail(username);
		return new ResponseEntity<User>(user1, HttpStatus.OK);
	}
	
	@PostMapping("/attendance")
	public ResponseEntity<String> submitAttendance(@RequestBody User user,HttpServletRequest request) throws IOException, ParseException{
		System.out.println("in submitAttendance()");
		File ips = attendanceService.getFile();
		int proxy=0;
		BufferedReader breader=new BufferedReader(new FileReader(ips));
		FileWriter writer = new FileWriter(ips,true);
		 String st; 
		 
		try {
			 while ((st = breader.readLine()) != null) {
				 if(st.equals(user.getIp())) {
					proxy=1;
					break;
				 }
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(user.getEmail());
		/*UsernamePasswordAuthenticationToken authenticationToken= new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword());
		Authentication authentication = authenticationManager.authenticate(authenticationToken);
		final JwtUser userDetails = (JwtUser) authentication.getPrincipal();
		System.out.println("User details--"+userDetails);
		System.out.println("Authentication--"+authentication);
		
		System.out.println("Principal--"+authenticationToken.getPrincipal());*/
		System.out.println(request.getHeader("Authorization"));
		String token=jwtTokenUtil.resolveToken(request);
		System.out.println("Token recieved----"+token);
		String username=jwtTokenUtil.getUserNameFromToken(token);
		System.out.println("Username:"+username);
		User user1 = userService.getUserByEmail(username);
		System.out.println(user.getIp());
		try {
		System.out.println(user.getLatitude()+" "+user.getLongitude());
		String lat = user.getLatitude();
		String lon = user.getLongitude();
		Attendance attendance;
		Integer subId=attendanceService.inTime(user1.getCourseId());
		System.out.println("a"+user1.getCourseId());
		System.out.println("b"+subId);
		Integer courseid = user1.getCourseId();
		int coord = attendanceService.coords(lat,lon,courseid);
		System.out.println("Controller coord: "+coord);
		
		System.out.println("controller subid: "+subId);
		
		if(subId!=null)
		{
		   if(proxy==1) {
			attendance=new Attendance(user1.getPrn(),proxy,subId);
			if(attendanceService.save(attendance))
				return new ResponseEntity<String>("duplicate attendance",HttpStatus.OK);
			else{
				return new ResponseEntity<String>("Attendance not submitted",HttpStatus.OK);
			}
		}else {
			
			writer.write(user.getIp());
			writer.write("\n");
			System.out.println("written to file");
			writer.close();
			attendance=new Attendance(user1.getPrn(),proxy,subId);
			if(attendanceService.save(attendance))
				return new ResponseEntity<String>("attendance submitted",HttpStatus.OK);
			else{
				return new ResponseEntity<String>("Attendance not submitted",HttpStatus.OK);
			}
		}
		
		}
		else
		{
			return new ResponseEntity<String>("no class scheduled right now",HttpStatus.OK);
			
		}}
		catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<String>("no class scheduled right now",HttpStatus.OK);
		}
		//return new ResponseEntity<String>("attendance submitted",HttpStatus.OK);
	}
	
	
	@PostMapping("/getall")
	//@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<List<User>> getAllUsersByDate(@RequestBody DateDTO date){
		System.out.println("in getAllUsersByDate()");
		
		Date dt=date.getDate();
		System.out.println(dt);
		List<User> users = userService.findByCreationDate(dt);
		users.forEach(System.out::println);
		return new ResponseEntity<List<User>>(users,HttpStatus.OK);
		
	}
	
	@PostMapping("/getatt")
	//@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<List<AttendanceDets>> getAttDets(@RequestBody AttendanceDets ats){
		ResponseEntity<List<AttendanceDets>> a1=null;
        
		try
		{
		
		User name=userService.getUserByPrn(ats.getPrn());
		System.out.println(name);
		ArrayList<AttendanceDets> l1=new ArrayList<>();;  
		HashMap<Integer,Integer> h1=new HashMap<>(attendanceService.getAttDets(ats.getPrn()));
		
		System.out.println("in cont"+h1);
		 
		 Iterator it=h1.entrySet().iterator();
		  
		  while(it.hasNext())
		  { 
			   Map.Entry pair=(Map.Entry)it.next();
		       l1.add(new AttendanceDets(ats.getPrn(),name.getFirstName(),Integer.valueOf((int)pair.getKey()),Integer.valueOf((int)pair.getValue())));
		    
		  
		  }
		  
		  a1=new ResponseEntity<>(l1, HttpStatus.OK);
		 
		  for(AttendanceDets a:l1)
		  {
			  System.out.println(a);
		  }
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	 		
	      return a1;
		}
	
}
