package app.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonView;

import app.utils.View.ShowForumThread;

@Entity
public class ForumFile {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private Long id;
	
	private String description;
	
	@NotNull
	private String url;
	
	@JsonView(ShowForumThread.class)
	@OneToMany(mappedBy = "file")
	private Set<ForumThread> threads;

	public ForumFile(Long id, String description, @NotNull String url, Set<ForumThread> threads) {
		super();
		this.id = id;
		this.description = description;
		this.url = url;
		this.threads = threads;
	}
	
	
	public ForumFile() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Set<ForumThread> getThreads() {
		return threads;
	}

	public void setThreads(Set<ForumThread> threads) {
		this.threads = threads;
	}
	
	
}
