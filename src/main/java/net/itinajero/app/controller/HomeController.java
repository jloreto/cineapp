package net.itinajero.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.itinajero.app.model.Movie;
import net.itinajero.app.services.IMoviesService;
import net.itinajero.app.util.Utilitis;

@Controller
public class HomeController {

	private SimpleDateFormat dateFmt = new SimpleDateFormat("yyyy-MM-dd");

	@Autowired
	private IMoviesService serviceMovies;

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String goHome() {
		return "home";
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String search(@RequestParam("date") String date, Model model) {

		System.out.println(date);

		List<String> nextDays = Utilitis.getNexDays(4);

		List<Movie> movies = serviceMovies.searchAll();
		System.out.println(nextDays);

		model.addAttribute("searchDate", date);
		model.addAttribute("movies", movies);
		model.addAttribute("nextDays", nextDays);
		return "home";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showMovies(Model model) {

		List<String> nextDays = Utilitis.getNexDays(4);
		List<Movie> movies = serviceMovies.searchAll();
		System.out.println(nextDays);

		model.addAttribute("searchDate", dateFmt.format(new Date()));
		model.addAttribute("movies", movies);
		model.addAttribute("nextDays", nextDays);
		return "home";
	}

	@RequestMapping(value = "/detail/{id}/{date}", method = RequestMethod.GET)
	public String showDetail(Model model, @PathVariable("id") Integer movieId, @PathVariable("date") String date) {

		System.out.println(movieId);
		System.out.println(date);

		model.addAttribute("movie", serviceMovies.searchById(movieId));
		
		return "detail";
	}

}
