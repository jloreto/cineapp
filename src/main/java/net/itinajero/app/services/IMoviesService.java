package net.itinajero.app.services;

import java.util.List;

import net.itinajero.app.model.Movie;

public interface IMoviesService {

	List<Movie> searchAll();

	Movie searchById(Integer movieId);

	void insert(Movie movie);

}
