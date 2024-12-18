package in.uttamrabari.movie_catalog_service.resource;

import com.netflix.discovery.converters.Auto;
import in.uttamrabari.movie_catalog_service.models.CatalogItem;
import in.uttamrabari.movie_catalog_service.models.Movie;
import in.uttamrabari.movie_catalog_service.models.UserRating;
import in.uttamrabari.movie_catalog_service.services.MovieService;
import in.uttamrabari.movie_catalog_service.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    RatingService ratingService;

    @Autowired
    private MovieService movieService;

    @GetMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable String userId) {
        UserRating ratings = ratingService.getUserRating(userId);
        if (ratings != null) {
            return ratings.getUserRating().stream().map(rating -> {
                Movie movie = movieService.getMovie(rating.getMovieId());
                if (movie != null) {
                    return new CatalogItem(userId, movie.getMovieName(), movie.getMovieDescription(), rating.getRating());
                }
                return null;
            }).collect(Collectors.toList());
        }
        return null;
    }
}
