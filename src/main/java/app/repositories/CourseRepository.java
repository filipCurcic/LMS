package app.repositories;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entities.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
	
	//Iterable<Optional<Course>> findByNameLike(String name);
	//ArrayList<Course> findByStudyYearIdEquals(Long studyYearId);
}