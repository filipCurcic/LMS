
package app.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import app.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	@Query("SELECT s FROM Student s WHERE s.name LIKE ?1")
	Iterable<Optional<Student>> findStudentsByFirstName(String name);
	
	@Query("SELECT s FROM Student s WHERE s.jmbg = ?1")
	Optional<Student> findStudentByJmbg(String jmbg);
	
	@Query("SELECT s FROM Student s WHERE s.registeredUser.username = ?1")
	Optional<Student> getByUsername(String username);
	
	
}