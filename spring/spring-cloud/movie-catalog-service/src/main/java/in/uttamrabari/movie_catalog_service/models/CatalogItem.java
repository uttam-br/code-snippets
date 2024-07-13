package in.uttamrabari.movie_catalog_service.models;

public class CatalogItem {
    private String userId;
    private String movieName;
    private String movieDescription;
    private int ratings;

    public CatalogItem() {
    }

    public CatalogItem(String userId, String movieName, String movieDescription, int ratings) {
        this.userId = userId;
        this.movieName = movieName;
        this.movieDescription = movieDescription;
        this.ratings = ratings;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public int getRatings() {
        return ratings;
    }

    public void setRatings(int ratings) {
        this.ratings = ratings;
    }
}
