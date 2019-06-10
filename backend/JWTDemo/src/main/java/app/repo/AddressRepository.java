package app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.model.Address;
import app.model.CourseDetails;

@Repository
public interface AddressRepository extends JpaRepository<Address,Integer>{
}
