
package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entities.Faculty;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {
}