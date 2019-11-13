package net.itinajero.app.services;

import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import net.itinajero.app.model.Movie;

@Service
public class MoviesServiceImpl implements IMoviesService {

	private List<Movie> list = null;

	public MoviesServiceImpl() {
		System.out.println("Creating instance MovieService");
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

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}

	}

	@Override
	public List<Movie> searchAll() {
		return list;
	}

	@Override
	public Movie searchById(Integer movieId) {

		for (Movie m : list) {
			if (m.getId().equals(movieId)) {
				return m;
			}
		}

		return null;
	}

	@Override
	public void insert(Movie movie) {
		list.add(movie);
		
	}

}
