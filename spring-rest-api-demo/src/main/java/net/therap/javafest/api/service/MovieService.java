package net.therap.javafest.api.service;

import net.therap.javafest.api.domain.Movie;

import java.util.List;

/**
 * @author Mushfekur Rahman
 * @since 1.0
 */
public interface MovieService {
    Movie getMovieById(int id);

    List<Movie> getAll();

    void deleteAll();

    List<Movie> getMoviesByYear(int year);

    void addMovie(Movie movie);

    void deleteMovieById(int id);
}
