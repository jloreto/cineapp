package net.itinajero.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.itinajero.app.model.Movie;
import net.itinajero.app.services.IMoviesService;

@Controller
@RequestMapping("/movies")
public class MovieController {

	@Autowired
	private IMoviesService serviceMovie;

	@GetMapping("/index")
	public String showIndex(Model model) {

		List<Movie> movies = serviceMovie.searchAll();
		model.addAttribute("movies", movies);
		return "/movies/movieList";
	}

	@GetMapping("/create")
	public String create() {

		return "movies/movieForm";
	}

	@PostMapping("/save")
	private String save(Movie movie, BindingResult result, RedirectAttributes attributes) {
		// TODO Auto-generated method stub
		System.out.println("Form entry: " + movie);

		if (result.hasErrors()) {
			for (ObjectError err : result.getAllErrors()) {
				System.out.println(err.getDefaultMessage());
			}
			return "movies/movieForm";
		}

		System.out.println("Count movie BEFORE insert: " + serviceMovie.searchAll().size());
		System.out.println("Adding movie");
		serviceMovie.insert(movie);
		System.out.println("Count movie AFTER insert: " + serviceMovie.searchAll().size());

		attributes.addFlashAttribute("messageInfo", "The Movie is saved");
		return "redirect:/movies/index";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, false));
	}

}
