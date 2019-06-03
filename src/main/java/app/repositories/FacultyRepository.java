
package app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import app.entities.Faculty;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {
	@Query("SELECT f FROM Faculty f WHERE f.university.id=?1")
	List<Faculty> getFacultiesOnUni(Long id);
}