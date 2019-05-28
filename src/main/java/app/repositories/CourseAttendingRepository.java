
package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entities.CourseAttending;

@Repository
public interface CourseAttendingRepository extends JpaRepository<CourseAttending, Long> {
}