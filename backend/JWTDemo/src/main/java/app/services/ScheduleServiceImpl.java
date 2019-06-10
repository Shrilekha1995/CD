package app.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.model.Room;
import app.model.Schedule;
import app.repo.RoomRepository;
import app.repo.ScheduleRepository;
import app.repo.UserRepository;

@Service
@Transactional
public class ScheduleServiceImpl implements ScheduleService{

	@Autowired
	private ScheduleRepository schRepository;
	@Autowired
	private RoomRepository rmRepository;

	@Override
	public Schedule save(Schedule sch) {
		// TODO Auto-generated method stub
		return schRepository.save(sch);
	}

	
	@Override
	public Schedule getTodaySch(int string) {
		// TODO Auto-generated method stub
		return schRepository.getOne(string);
	}



	@Override
	public Schedule getTodaySch(String date1)   {
		// TODO Auto-generated method stub
	System.out.println("in getTodaySch " + date1);
	
		return schRepository.findByDate(date1);
	}



	@Override
	public Room saveRoomDets(Room rm) {
		// TODO Auto-generated method stub
		return rmRepository.save(rm);
	}

	
	
}
