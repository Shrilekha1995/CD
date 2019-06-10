package app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.model.Communication;

@Repository
public interface CommunicationRepository extends JpaRepository<Communication, Integer>{

}
