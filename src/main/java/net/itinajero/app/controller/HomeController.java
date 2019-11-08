package net.itinajero.app.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String goHome(){
		return "home";
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String showMovie(Model model) {
		
		List<String> movies = new LinkedList<>();
		movies.add("Rapido y furiosos");
		movies.add("Aliens");
		movies.add("Brave heart");
		model.addAttribute("movies", movies);
		return "home";
	}
	
	@RequestMapping(value="/detail")
	public String mostrarDetalle(Model model) {
		String tituloPelicula = "Rapidos y furiosos";
		int duracion = 196;
		double precioEntrada = 50;
		model.addAttribute("titulo", tituloPelicula);
		model.addAttribute("duracion", duracion);
		model.addAttribute("precio", precioEntrada);
		return "detalle";
	}
	
}
