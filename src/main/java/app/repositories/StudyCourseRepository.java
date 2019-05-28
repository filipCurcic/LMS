
package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entities.StudyCourse;

@Repository
public interface StudyCourseRepository extends JpaRepository<StudyCourse, Long> {
}