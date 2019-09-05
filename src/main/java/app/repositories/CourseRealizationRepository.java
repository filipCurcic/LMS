
package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import app.entities.CourseRealization;
import app.entities.Teacher;

@Repository
public interface CourseRealizationRepository extends JpaRepository<CourseRealization, Long> {
//	@Query("SELECT tr.teacher FROM TeacherRealization tr WHERE tr.teachingType.name='Exercises' AND tr.courseRealization.course.id = ?1")
//	Iterable<Teacher> findTeachersWhoTeachExercises(Long courseId);
	@Query("SELECT cr FROM CourseRealization cr JOIN cr.teacherOnRealizations tr WHERE tr.teacher.registeredUser.username= ?1")
	Iterable<CourseRealization> findByTeacherUsername(String username);
	
	Iterable<CourseRealization> findByStudyYearId(Long id);
}