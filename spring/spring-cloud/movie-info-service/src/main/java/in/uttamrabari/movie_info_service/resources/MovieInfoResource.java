package in.uttamrabari.movie_info_service.resources;

import in.uttamrabari.movie_info_service.models.MovieInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/movies")
public class MovieInfoResource {

    RestTemplate restTemplate;

    @Value("${moviedb.api.key}")
    String apiKey;

    public MovieInfoResource(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/{movieId}")
    public MovieInfo getMovieInfo(@PathVariable("movieId") String movieId) {
        String url = "https://api.themoviedb.org/3/movie/" + movieId + "?api_key=" + apiKey;
        return restTemplate.getForObject(url, MovieInfo.class);
    }

}
