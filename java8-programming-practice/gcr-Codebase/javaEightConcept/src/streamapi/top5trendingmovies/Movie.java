package streamapi.top5trendingmovies;

public class Movie {
	int id;
	String name;
	int yearOfRelease;
	double rating;

	public Movie(int id, String name, int yearOfRelease, double rating) {
		this.id=id;
		this.name=name;
		this.yearOfRelease=yearOfRelease;
		this.rating=rating;
	}
	
	 // Getter for movie id
    public int getId() {
        return id;
    }

    // Getter for movie name
    public String getName() {
        return name;
    }

    // Getter for year of release
    public int getYearOfRelease() {
        return yearOfRelease;
    }

    // Getter for movie rating
    public double getRating() {
        return rating;
    }
	
	@Override
	public String toString() {
	    return "Movie [id=" + id +
	           ", name=" + name +
	           ", yearOfRelease=" + yearOfRelease +
	           ", rating=" + rating + "]";
	}
}
