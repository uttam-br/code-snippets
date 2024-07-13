package in.uttamrabari.movie_rating_service.models;

import java.util.List;

public class UserRating {
    List<Rating> userRating;

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
