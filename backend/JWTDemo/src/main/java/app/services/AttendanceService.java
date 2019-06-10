package app.services;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;

import app.model.Attendance;

public interface AttendanceService {

	public Date getCreationDate(String path);
	public File getFile() throws IOException;
	public boolean save(Attendance attendance);
	public Integer inTime(Integer integer) throws ParseException;
	public HashMap<Integer,Integer> getAttDets(String prn);
	public int coords(String lat, String lon, Integer courseid);
}
