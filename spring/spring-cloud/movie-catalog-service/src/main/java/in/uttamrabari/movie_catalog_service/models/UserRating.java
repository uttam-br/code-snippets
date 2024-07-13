package in.uttamrabari.movie_catalog_service.models;

import java.util.List;

public class UserRating {
    List<Rating> userRating;

    public UserRating() {
    }

    public UserRating(List<Rating> userRatings) {
        this.userRating = userRatings;
    }

    public List<Rating> getUserRating() {
        return userRating;
    }

    public void setUserRating(List<Rating> userRating) {
        this.userRating = userRating;
    }
}
