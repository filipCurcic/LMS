
package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entities.Title;

@Repository
public interface TitleRepository extends JpaRepository<Title, Long> {
}