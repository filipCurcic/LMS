package app.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import app.entities.News;
import app.services.NewsService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/news")
public class NewsController {
	@Autowired
	NewsService ns;

	@RequestMapping("/all")
	public ResponseEntity<Iterable<News>> dobaviNews() {
		return new ResponseEntity<Iterable<News>>(ns.getNews(), HttpStatus.OK);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<News> dodajNews(@RequestBody News news) {
		ns.AddNews(news);
		return new ResponseEntity<News>(news, HttpStatus.OK);
	}

	
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
