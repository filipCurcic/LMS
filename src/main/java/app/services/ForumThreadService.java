package app.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entities.ForumReply;
import app.entities.ForumThread;
import app.repositories.ForumReplyRepository;
import app.repositories.ForumThreadRepository;

@Service
public class ForumThreadService {
	@Autowired
	ForumThreadRepository fr;
	
	@Autowired
	ForumReplyRepository frr;

	public ForumThreadService() {
	}

	public Iterable<ForumThread> getForumThreads() {
		return fr.findAll();
	}

	public Optional<ForumThread> getForumThread(Long id) {
		return fr.findById(id);
	}

	public void AddForumThread(ForumThread forumthread) {
		fr.save(forumthread);
	}

	public void deleteForumThread(Long id) {
		Optional<ForumThread> forumthread = fr.findById(id);
		fr.delete(forumthread.get());
	}
	
	public Iterable<ForumReply> getReplies(Long id) {
		return frr.getThreadReplies(id);
	}
}