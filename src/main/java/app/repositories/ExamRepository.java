package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entities.Exam;
@Repository
public interface ExamRepository extends JpaRepository<Exam, Long>{

}
