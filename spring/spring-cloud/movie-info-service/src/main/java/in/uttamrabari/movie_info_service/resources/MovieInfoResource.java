package in.uttamrabari.movie_info_service.resources;

import in.uttamrabari.movie_info_service.models.MovieInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieInfoResource {

    @GetMapping("/{movieId}")
    public MovieInfo getMovieInfo(@PathVariable("movieId") String movieId) {
        return new MovieInfo(movieId, "Title", "Description");
    }

}
