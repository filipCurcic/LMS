package app.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import app.entities.Course;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {
}