package app.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entities.ForumFile;
import app.repositories.ForumFileRepository;

@Service
public class ForumFileService {
	@Autowired
	ForumFileRepository fr;

	public ForumFileService() {
	}

	public Iterable<ForumFile> getForumFiles() {
		return fr.findAll();
	}

	public Optional<ForumFile> getForumFile(Long id) {
		return fr.findById(id);
	}

	public void AddForumFile(ForumFile forumfile) {
		fr.save(forumfile);
	}

	public void deleteForumFile(Long id) {
		Optional<ForumFile> forumfile = fr.findById(id);
		fr.delete(forumfile.get());
	}
}