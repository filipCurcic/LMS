package app.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class ForumSubForum {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@OneToOne
	private StudyCourse studyCourse;
	
	@OneToMany(mappedBy = "subForum")
	private Set<ForumThread> threads;
	
	@ManyToOne()
	private ForumSubFacultyForum subFacultyForum;	
	
	public ForumSubForum() {}

	public ForumSubForum(Long id, String name, StudyCourse studyCourse) {
		super();
		this.id = id;
		this.name = name;
		this.studyCourse = studyCourse;
	}

	public ForumSubForum(Long id, String name, StudyCourse studyCourse, Set<ForumThread> threads,
			ForumSubFacultyForum subFacultyForum) {
		super();
		this.id = id;
		this.name = name;
		this.studyCourse = studyCourse;
		this.threads = threads;
		this.subFacultyForum = subFacultyForum;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public StudyCourse getStudyCourse() {
		return studyCourse;
	}

	public void setStudyCourse(StudyCourse studyCourse) {
		this.studyCourse = studyCourse;
	}

	public Set<ForumThread> getThreads() {
		return threads;
	}

	public void setThreads(Set<ForumThread> threads) {
		this.threads = threads;
	}

	public ForumSubFacultyForum getSubFacultyForum() {
		return subFacultyForum;
	}

	public void setSubFacultyForum(ForumSubFacultyForum subFacultyForum) {
		this.subFacultyForum = subFacultyForum;
	}
	
	
	



}
