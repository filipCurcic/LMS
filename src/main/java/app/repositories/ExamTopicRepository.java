package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entities.ExamTopic;

@Repository
public interface ExamTopicRepository extends JpaRepository<ExamTopic, Long> {

}
