package in.uttamrabari.movie_catalog_service.models;

public class Movie {
    String movieId;
    String movieName;
    String movieDescription;

    public Movie(String movieId, String name, String description) {
        this.movieId = movieId;
        this.movieName = name;
        this.movieDescription = description;
    }

    public Movie() {
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieDescription() {
        return movieDescription;
    }

    public void setMovieDescription(String movieDescription) {
        this.movieDescription = movieDescription;
    }
}
