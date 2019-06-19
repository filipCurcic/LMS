package app.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import app.entities.ForumReply;
import app.repositories.ForumReplyRepository;

@Service
public class ForumReplyService {
	@Autowired
	ForumReplyRepository fr;

	public ForumReplyService() {
	}

	public Iterable<ForumReply> getForumReplies() {
		return fr.findAll();
	}

	public Optional<ForumReply> getForumReply(Long id) {
		return fr.findById(id);
	}

	public void AddForumReply(ForumReply forumreply) {
		fr.save(forumreply);
	}

	public void deleteForumReply(Long id) {
		Optional<ForumReply> forumreply = fr.findById(id);
		fr.delete(forumreply.get());
	}
}