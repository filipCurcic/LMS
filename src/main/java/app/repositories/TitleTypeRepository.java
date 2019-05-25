
package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entities.TitleType;

@Repository
public interface TitleTypeRepository extends JpaRepository<TitleType, Long> {
}