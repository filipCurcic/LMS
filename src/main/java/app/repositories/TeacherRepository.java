
package app.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import app.entities.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
	
	@Query("SELECT s FROM Student s WHERE s.registeredUser.username = ?1")
	Optional<Teacher> getByUsername(String username);
	
}