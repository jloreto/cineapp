package net.itinajero.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.itinajero.app.model.News;
import net.itinajero.app.services.INewsService;

@Controller
@RequestMapping("/news")
public class NewsController {

	@Autowired
	private INewsService newService;

	@GetMapping(value = "/create")
	public String create() {
		return "news/newsForm";
	}

	@PostMapping(value = "/save")
	public String save(News news) {
		newService.save(news);

		System.out.println(news);
		return "news/newsForm";
	}

}
