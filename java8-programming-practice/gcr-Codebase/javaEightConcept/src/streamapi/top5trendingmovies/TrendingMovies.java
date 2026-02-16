package streamapi.top5trendingmovies;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TrendingMovies {
	public static void main(String[] args) {
		List<Movie> movies = new ArrayList<Movie>();

		movies.add(new Movie(1, "Inception", 2010, 8.8));
		movies.add(new Movie(2, "Interstellar", 2014, 8.6));
		movies.add(new Movie(3, "The Dark Knight", 2008, 9.0));
		movies.add(new Movie(4, "Avengers Endgame", 2019, 8.4));
		movies.add(new Movie(5, "Parasite", 2019, 8.6));
		movies.add(new Movie(6, "Joker", 2019, 8.5));
		movies.add(new Movie(7, "Titanic", 1997, 7.9));
		movies.add(new Movie(8, "Avatar", 2009, 7.8));
		movies.add(new Movie(9, "The Matrix", 1999, 8.7));
		movies.add(new Movie(10, "Gladiator", 2000, 8.5));

		movies.add(new Movie(11, "Forrest Gump", 1994, 8.8));
		movies.add(new Movie(12, "Fight Club", 1999, 8.8));
		movies.add(new Movie(13, "The Shawshank Redemption", 1994, 9.3));
		movies.add(new Movie(14, "The Godfather", 1972, 9.2));
		movies.add(new Movie(15, "The Godfather Part II", 1974, 9.0));
		movies.add(new Movie(16, "Pulp Fiction", 1994, 8.9));
		movies.add(new Movie(17, "The Prestige", 2006, 8.5));
		movies.add(new Movie(18, "Whiplash", 2014, 8.5));
		movies.add(new Movie(19, "Dune", 2021, 8.1));
		movies.add(new Movie(20, "Oppenheimer", 2023, 8.7));
		
		
		List<Movie> top5movies = movies.stream().filter(movie -> movie.getRating()>=8.0).sorted(Comparator.comparingDouble(Movie::getRating).reversed().thenComparing(Movie::getYearOfRelease, Comparator.reverseOrder())).limit(5).collect(Collectors.toList());
		
		top5movies.forEach(System.out::println);
	}
}
