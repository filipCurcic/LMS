package app.repositories;

import org.springframework.data.repository.CrudRepository;

import app.entities.ForumReply;

public interface ForumReplyRepository extends CrudRepository<ForumReply, Long>{

}
