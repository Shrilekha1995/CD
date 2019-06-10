package app.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.model.Attendance;
import app.model.Room;
import app.model.Schedule;
import app.repo.AttendanceRepository;
import app.repo.RoomRepository;
import app.repo.ScheduleRepository;

@Service
public class AttendanceServiceImpl implements AttendanceService {
	@Autowired
	private AttendanceRepository attendanceRepo;
	@Autowired
	private ScheduleRepository schRepository;
	
	@Autowired
	private RoomRepository roomRepo;
	
	private File ips=new File("attendance.txt");
	
	@Override
	public Date getCreationDate(String path) {
		Date creationDate=null;
		Path p = Paths.get(path);
		try {
			BasicFileAttributes view
			   = Files.getFileAttributeView(p, BasicFileAttributeView.class)
			   .readAttributes();
			long creationTime=view.creationTime().to(TimeUnit.MILLISECONDS);
			creationDate=new Date(creationTime);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return creationDate;
	}
	
	public File getFile() throws IOException {
		if(ips.exists()) {
			if(getCreationDate(ips.getAbsolutePath()).equals(new Date())) {
				System.out.println(getCreationDate(ips.getAbsolutePath()));
				return ips;
			}else {
				System.out.println("else "+getCreationDate(ips.getAbsolutePath()));
				ips.delete();
				ips.createNewFile();
				return ips;
			}
		}else {
			System.out.println(getCreationDate(ips.getAbsolutePath()));
			ips.createNewFile();
			return ips;
			
		}
	}

	@Override
	public boolean save(Attendance attendance) {
		if(attendanceRepo.save(attendance)!=null) {
			return true; 
		}else {
			return false;
		}
	}
	
	@Override
	public Integer inTime(Integer integer) throws ParseException {
		// TODO Auto-generated method stub
		
		 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
	       Date date = new Date();  
	         
		 Schedule sch=schRepository.getSubj(integer,formatter.format(date));
		 System.out.println(sch);
		 
		 //check date validity
		 SimpleDateFormat formatter1 = new SimpleDateFormat("HH:mm");  
		// Date date1=formatter1.parse("16:45");
	             
	       Date date11=formatter1.parse(sch.getFrom1());
	       Date date21=formatter1.parse(sch.getTo1());
	       Date date12=formatter1.parse(sch.getFrom2());
	       Date date22=formatter1.parse(sch.getTo2());
	       
	       
	       Calendar calendar1 = Calendar.getInstance();
	       calendar1.setTime(date11);

	       Calendar calendar2 = Calendar.getInstance();
	       calendar2.setTime(date21);

	       Calendar calendar3 = Calendar.getInstance();
	       calendar3.setTime(formatter1.parse(formatter1.format(date)));
	      System.out.println(calendar3.getTime());
	      Date x = calendar3.getTime();
		    if (x.after(calendar1.getTime()) && x.before(calendar2.getTime())) {
		        //checkes whether the current time is between 14:49:00 and 20:11:13.
		    	System.out.println("c"+sch.getSubject1Id());
		        return sch.getSubject1Id();
		     }
        
		    calendar1.setTime(date12);
		    calendar2.setTime(date22);

	        
		    if (x.after(calendar1.getTime()) && x.before(calendar2.getTime())) {
		    	System.out.println(sch.getSubject2Id());
		        //checkes whether the current time is between 14:49:00 and 20:11:13.
		        return sch.getSubject2Id();
		     }
		    
		 return null;
		
	}


	@Override
	public HashMap<Integer,Integer> getAttDets(String prn) {
		// TODO Auto-generated method stub
	ArrayList<Attendance> ar=new ArrayList<>(attendanceRepo.getByPrn(prn));
	
	  HashMap<Integer,Integer> h1=new HashMap<>(); 
	  int count=0;
	  for(Attendance a:ar)
	 {
		if(h1.get(a.getSubjectId())!=null)
		{
           if(a.getProxy()==0)
           { count=h1.get(a.getSubjectId());
              count++;
        	 h1.put(a.getSubjectId(),count);
           }
           
        }
				  
		else
		{
           if(a.getProxy()==0)
           { count=1;
              
        	 h1.put(a.getSubjectId(),count);
           }
           
        }
		  
      }
	
      
	  
	  return h1;
	
	}

	@Override
	public int coords(String lat, String lon, Integer courseid) {
		// TODO Auto-generated method stub
		double lati = Double.parseDouble(lat);
		double loni = Double.parseDouble(lon);
		
		System.out.println("Lati and longi: "+lati+" "+loni);
		
		Room room = roomRepo.findByCourseId(courseid);
		System.out.println("Room in service: "+room.getId());
		
		double lat1 = room.getCoord1Lat();
		double lon1 = room.getCoord1Long();
		double lat2 = room.getCoord2Lat();
		double lon2 = room.getCoord2Long();
		double lat3 = room.getCoord3Lat();
		double lon3 = room.getCoord3Long();
		double lat4 = room.getCoord4Lat();
		double lon4 = room.getCoord4Long();
		double lat5 = room.getCoord5Lat();
		double lon5 = room.getCoord5Long();
		double lat6 = room.getCoord6Lat();
		double lon6 = room.getCoord6Long();
		
		double latHeight = lat2 - lat1;
		double lonHeight = lon2 - lon1;
		double latWidth = lat4 - lat3;
		double lonWidth = lon4 - lon3;
		double latBreadth = lat6 - lat5;
		double lonBreadth = lon6 - lon5;
		
		System.out.println("Room details "+room);
		
		if(((lati <= latHeight) || (lati <= latWidth) || (lati <= latBreadth)) && ((loni <= lonHeight) || (loni <= lonWidth) || (loni <= lonBreadth)))
		{
			System.out.println("Service valid coords");
			return 0;
			
		}
		else
		{
			System.out.println("Service invalid coords");
			if(latWidth<=9.799999999771103E-5) {
				System.out.println("valid");
				return 0;
			}
			return 1;
		}
	}
}
