package app.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonView;

import app.utils.View.ShowForumSubForum;


@Entity
public class ForumSubFacultyForum {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Forum forum;
	
	@JsonView(ShowForumSubForum.class)
	@OneToMany(mappedBy = "subFacultyForum")
	private Set<ForumSubForum> subForums;
	
	
	@NotNull
	@OneToOne
	private Faculty faculty;

	public ForumSubFacultyForum(Long id, Forum forum, Set<ForumSubForum> subForums, @NotNull Faculty faculty) {
		super();
		this.id = id;
		this.forum = forum;
		this.subForums = subForums;
		this.faculty = faculty;
	}

	public ForumSubFacultyForum(Long id, @NotNull Faculty faculty) {
		super();
		this.id = id;
		this.faculty = faculty;
	}
	
	
	public ForumSubFacultyForum() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Forum getForum() {
		return forum;
	}

	public void setForum(Forum forum) {
		this.forum = forum;
	}

	public Set<ForumSubForum> getSubForums() {
		return subForums;
	}

	public void setSubForums(Set<ForumSubForum> subForums) {
		this.subForums = subForums;
	}

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}
	
	

	
	
	
	
	
}
