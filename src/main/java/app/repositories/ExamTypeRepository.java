package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entities.ExamType;

public interface ExamTypeRepository extends JpaRepository<ExamType, Long> {

}
