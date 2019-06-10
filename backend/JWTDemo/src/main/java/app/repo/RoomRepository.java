package app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import app.model.CourseDetails;
import app.model.Room;

public interface RoomRepository extends JpaRepository<Room,Integer>{

	public Room findByCourseId(int courseId);
}
