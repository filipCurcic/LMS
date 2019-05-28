
package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entities.CourseOutcome;

@Repository
public interface CourseOutcomeRepository extends JpaRepository<CourseOutcome, Long> {
}