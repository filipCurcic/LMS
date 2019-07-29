package app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import app.entities.Exam;


@Repository
public interface ExamRepository extends JpaRepository<Exam, Long>{
	
	@Query("SELECT e FROM Exam e JOIN e.courseRealization cr JOIN cr.course co JOIN co.yearsOfStudy ys JOIN ys.studentsOnYear sy WHERE sy.student.id=?1")
	List<Exam> getExamsForStudent(Long studentId);

}
