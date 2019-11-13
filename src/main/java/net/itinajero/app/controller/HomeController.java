package net.itinajero.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.itinajero.app.model.Movie;
import net.itinajero.app.util.Utilitis;

@Controller
public class HomeController {
	
	private SimpleDateFormat dateFmt = new SimpleDateFormat("yyyy-MM-dd"	);

	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String goHome(){
		return "home";
	}
	
	@RequestMapping(value="/search", method = RequestMethod.POST)
	public String search(@RequestParam("date") String date, Model model) {
		
		System.out.println(date);
		
		List<String> nextDays = Utilitis.getNexDays(4);
		List<Movie> movies = getList();
		System.out.println(nextDays);

		model.addAttribute("searchDate", date);
		model.addAttribute("movies", movies);
		model.addAttribute("nextDays", nextDays);
		return "home";
	}
	
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String showMovies(Model model) {
		
		List<String> nextDays = Utilitis.getNexDays(4);
		List<Movie> movies = getList();
		System.out.println(nextDays);

		model.addAttribute("searchDate", dateFmt.format(new Date()));
		model.addAttribute("movies", movies);
		model.addAttribute("nextDays", nextDays);
		return "home";
	}
	
	@RequestMapping(value="/detail/{id}/{date}", method=RequestMethod.GET)
	public String showDetail(Model model, @PathVariable("id") Integer movieId, @PathVariable("date") String date) {
		
		System.out.println(movieId);
		System.out.println(date);

		String tituloPelicula = "Rapidos y furiosos";
		int duracion = 196;
		double precioEntrada = 50;
		model.addAttribute("titulo", tituloPelicula);
		model.addAttribute("duracion", duracion);
		model.addAttribute("precio", precioEntrada);
		return "detail";
	}
	
	public List<Movie> getList() {
		List<Movie> list = null;
		SimpleDateFormat fmtDate = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			
			list = new LinkedList<>();
			
			Movie movie = new Movie();
			movie.setId(1);
			movie.setTitle("Brave Hearts");
			movie.setDuration(177);
			movie.setClassification("R");
			movie.setGenre("Historical drama");
			movie.setPremiereDate(fmtDate.parse("1995-05-24"));
			movie.setImage("braveheart.jpg");
			list.add(movie);
			
			movie = new Movie();
			movie.setId(2);
			movie.setTitle("The hobbit");
			movie.setDuration(474);
			movie.setClassification("G");
			movie.setGenre("Adventure, Epic fantasy");
			movie.setPremiereDate(fmtDate.parse("2012-08-23"));
			movie.setImage("thehobbit.jpg");
			list.add(movie);			
			
		
			movie = new Movie();
			movie.setId(3);
			movie.setTitle("The Shawshank Redemption");
			movie.setDuration(142);
			movie.setClassification("R");
			movie.setGenre("Drama");
			movie.setPremiereDate(fmtDate.parse("1994-08-23"));
			movie.setImage("shawshank.jpg");
			list.add(movie);			
			
			movie = new Movie();
			movie.setId(4);
			movie.setTitle("Kong Skull island ");
			movie.setDuration(142);
			movie.setClassification("G");
			movie.setGenre("Adventure, Epic fantasy");
			movie.setPremiereDate(fmtDate.parse("2017-08-23"));
			movie.setImage("kong.png");
			movie.setStatus("Inactive");
			list.add(movie);	
			
			movie = new Movie();
			movie.setId(5);
			movie.setTitle("Life");
			movie.setDuration(142);
			movie.setClassification("G");
			movie.setGenre("Adventure, Epic fantasy");
			movie.setPremiereDate(fmtDate.parse("2017-08-23"));
			movie.setImage("estreno5.png");
			movie.setStatus("Inactive");
			list.add(movie);			
			
		}catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		
		
		return list;
	}
}
