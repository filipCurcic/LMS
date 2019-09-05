package app.controllers;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import com.fasterxml.jackson.annotation.JsonView;


import app.entities.News;
import app.services.FileService;
import app.services.NewsService;
import app.utils.View.HideOptionalProperties;





@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/news")
public class NewsController {
	@Autowired
	NewsService ns;
	

	@Autowired
	FileService fileService;

	@RequestMapping("/all")
	public ResponseEntity<Iterable<News>> dobaviNews() {
		return new ResponseEntity<Iterable<News>>(ns.getNews(), HttpStatus.OK);
	}

	
	
	
	/*
	@JsonView(HideOptionalProperties.class)
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@Transactional
	public ResponseEntity<News> uploadFile(@RequestPart("profileImage") MultipartFile file, @RequestPart("data") News news) throws IOException {
		fileService.addImageNews(file, "news_" , news);
		ns.AddNews(news);
		return new ResponseEntity<News>(news, HttpStatus.OK);
	}
	
	*/
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<News> dodajNews(@RequestBody News news) {
		ns.AddNews(news);
		return new ResponseEntity<News>(news, HttpStatus.OK);
	}


	
	/*
	@JsonView(HideOptionalProperties.class)
    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@Transactional
	@PreAuthorize("hasAnyRole('ROLE_ADMINISTRATOR_STAFF','ROLE_ADMINISTRATOR')")
	public ResponseEntity<Teacher> uploadFile(@RequestPart("profileImage") MultipartFile file, @RequestPart("data") String teacherStr) throws IOException {
		Teacher teacher = new ObjectMapper().readValue(teacherStr, Teacher.class);
		fileService.addProfileImageTeacher(file, "teacher_" + teacher.getRegisteredUser().getUsername(), teacher);
		teacherService.addTeacher(teacher);
		return new ResponseEntity<Teacher>(teacher, HttpStatus.OK);
	}

*/
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<News> dobaviJedanNews(@PathVariable Long id) {
		Optional<News> news = ns.getNews(id);
		if (news.isPresent()) {
			return new ResponseEntity<News>(news.get(), HttpStatus.OK);
		}
		return new ResponseEntity<News>(HttpStatus.NOT_FOUND);
	}
	
	
	

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<News> obrisiNews(@PathVariable Long id) {
		try {
			ns.deleteNews(id);
		} catch (Exception e) {
			return new ResponseEntity<News>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<News>(HttpStatus.NO_CONTENT);
	}
}
