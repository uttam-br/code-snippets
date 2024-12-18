package in.uttamrabari.movie_catalog_service.services;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import in.uttamrabari.movie_catalog_service.models.Rating;
import in.uttamrabari.movie_catalog_service.models.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@EnableHystrix
public class RatingService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getUserRatingFallback")
    public UserRating getUserRating(String userId) {
        return restTemplate.getForObject("http://movie-rating-service/ratings-data/users/" + userId, UserRating.class);
    }

    public UserRating getUserRatingFallback(String userId) {
        Rating rating = new Rating();
        rating.setUserId(userId);
        rating.setRating(0);
        return new UserRating(List.of(rating));
    }

}
