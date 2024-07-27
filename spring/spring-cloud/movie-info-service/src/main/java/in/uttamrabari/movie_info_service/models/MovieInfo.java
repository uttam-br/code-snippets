package in.uttamrabari.movie_info_service.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MovieInfo {
    @JsonProperty("id")
    String movieId;
    @JsonProperty("original_title")
    String movieName;
    @JsonProperty("overview")
    String movieDescription;

    public MovieInfo() {
    }

    public MovieInfo(String movieId, String movieName, String movieDescription) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.movieDescription = movieDescription;
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
