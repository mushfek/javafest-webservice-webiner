package net.therap.javafest.api.controller;

import net.therap.javafest.api.domain.Movie;
import net.therap.javafest.api.service.MovieService;
import net.therap.javafest.api.util.ApiUtils;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Mushfekur Rahman
 * @since 1.0
 */
@Controller
@RequestMapping("/api")
public class MovieController {

    private static final Logger log = LoggerFactory.getLogger(MovieController.class);

    @Autowired
    private MovieService movieService;

    @RequestMapping(value = "/movies", method = RequestMethod.GET)
    @ResponseBody
    public List<Movie> getMovies() throws Exception {
        log.debug("getMovies:");

        return movieService.getAll();
    }

    @RequestMapping(value = "/movies", method = RequestMethod.POST)
    @ResponseBody
    public Object addMovie(@RequestBody String jsonMovie) throws Exception {
        log.debug("addMovie: ");

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Movie movie = objectMapper.readValue(jsonMovie, Movie.class);

        movieService.addMovie(movie);

        return ApiUtils.emptyJson();
    }

    @RequestMapping(value = "/movies", method = RequestMethod.DELETE)
    @ResponseBody
    public Object deleteMovies() throws Exception {
        log.debug("deleteMovies: ");

        movieService.deleteAll();

        return ApiUtils.emptyJson();
    }

    @RequestMapping(value = "movies/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Object getMovieById(@PathVariable("id") int id) throws Exception {
        log.debug("getMovieById: id={}", id);

        Movie movie = movieService.getMovieById(id);

        return movie == null ? ApiUtils.emptyJson() : movie;
    }

    @RequestMapping(value = "movies/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Object deleteMovieById(@PathVariable("id") int id) {
        log.debug("deleteMovieById: id={}", id);

        movieService.deleteMovieById(id);

        return ApiUtils.emptyJson();
    }
}
