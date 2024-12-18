package in.uttamrabari.movie_catalog_service.services;

import in.uttamrabari.movie_catalog_service.models.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieService {

    @Autowired
    RestTemplate restTemplate;

    public Movie getMovie(String movieId) {
        return restTemplate.getForObject("http://movie-info-service/movies/" + movieId, Movie.class);
    }

}
