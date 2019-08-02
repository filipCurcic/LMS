package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import app.entities.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
	
	//Iterable<Optional<Course>> findByNameLike(String name);
	//ArrayList<Course> findByStudyYearIdEquals(Long studyYearId);
	@Query("SELECT p FROM Course c JOIN c.precondition p WHERE c.mandatory = True AND c.yearsOfStudy.id = ?1")
	Iterable<Course> getPreconditionForMandatoryCourseByStudyYear(Long studyYearId);
}