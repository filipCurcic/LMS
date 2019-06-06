package app.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import app.entities.News;
import app.repositories.NewsRepository;

@Service
public class NewsService {
	@Autowired
	NewsRepository nr;

	public NewsService() {
	}

	public Iterable<News> getNews() {
		return nr.findAll();
	}

	public Optional<News> getNews(Long id) {
		return nr.findById(id);
	}

	public void AddNews(News news) {
		nr.save(news);
	}

	public void deleteNews(Long id) {
		Optional<News> news = nr.findById(id);
		nr.delete(news.get());
	}
}
