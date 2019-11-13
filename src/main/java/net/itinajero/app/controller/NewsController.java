package net.itinajero.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.itinajero.app.model.News;

@Controller
@RequestMapping("/news")
public class NewsController {

	
	@GetMapping(value="/create")
	public String create() {
		return "news/newsForm";		
	}
	
	@PostMapping(value="/save")
	public String save(@RequestParam("title") String title, @RequestParam("status") String status,
			@RequestParam("detail") String detail) {
		
		
		News news = new News();
		news.setTitle(title);
		news.setStatus(status);
		news.setDetail(detail);	
		
		
		System.out.println(news);
		return "news/newsForm";		
	}
	
	
}
