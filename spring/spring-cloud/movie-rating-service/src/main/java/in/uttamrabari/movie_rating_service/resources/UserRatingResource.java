package in.uttamrabari.movie_rating_service.resources;

import in.uttamrabari.movie_rating_service.models.Rating;
import in.uttamrabari.movie_rating_service.models.UserRating;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ratings-data")
public class UserRatingResource {

    @GetMapping("/users/{userId}")
    public UserRating getUserRating(@PathVariable("userId") String userId) {
        return new UserRating(
                List.of(
                        new Rating(userId, "1", 4),
                        new Rating(userId, "2", 5)
                ));
    }

}
