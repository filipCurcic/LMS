package app.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import app.entities.News;

@Repository
public interface NewsRepository extends CrudRepository<News, Long> { 
} 

