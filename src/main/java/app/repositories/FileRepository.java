package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entities.File;

@Repository
public interface FileRepository extends JpaRepository<File, Long> {

}
