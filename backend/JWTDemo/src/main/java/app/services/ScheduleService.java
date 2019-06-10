package app.services;

import app.model.Room;
import app.model.Schedule;

public interface ScheduleService {
	Schedule save(Schedule sch);
	Schedule getTodaySch(String date);



	Schedule getTodaySch(int string);



	Room saveRoomDets(Room rm);
}
