package in.uttamrabari.movie_catalog_service.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Movie {
    @JsonProperty("id")
    String movieId;
    @JsonProperty("original_title")
    String movieName;
    @JsonProperty("overview")
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
