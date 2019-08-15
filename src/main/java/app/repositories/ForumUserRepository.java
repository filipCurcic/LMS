package app.repositories;


import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import app.entities.ForumUser;
import app.entities.Student;

public interface ForumUserRepository extends CrudRepository<ForumUser, Long>{

	@Query("SELECT u FROM ForumUser u WHERE u.registeredUser.username = ?1")
	Optional<ForumUser> getLoggedUser(String username);
	

}
