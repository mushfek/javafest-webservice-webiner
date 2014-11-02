package net.therap.javafest.api.service;

import net.therap.javafest.api.domain.Movie;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Mushfekur Rahman
 * @since 1.0
 */
@Service
public class MovieServiceImpl implements MovieService {

    List<Movie> movieList;

    public MovieServiceImpl() {
        this.movieList = new ArrayList<>();

        this.movieList.add(new Movie(1, "The Great Gatsby", 2014, "Drama"));
        this.movieList.add(new Movie(2, "Catch Me If You Can", 1994, "Thriller"));
        this.movieList.add(new Movie(3, "Fury", 2014, "Action"));
        this.movieList.add(new Movie(4, "How To Train Your Dragon", 2010, "Animation"));
        this.movieList.add(new Movie(5, "127 Hours", 2011, "Thriller"));
    }

    @Override
    public List<Movie> getAll() {
        return movieList;
    }

    @Override
    public void deleteAll() {
        movieList.clear();
    }

    @Override
    public Movie getMovieById(int id) {
        for (Movie m : movieList) {
            if (id == m.getId()) return m;
        }

        return null;
    }

    @Override
    public List<Movie> getMoviesByYear(int year) {
        List<Movie> result = new ArrayList<>();
        for (Movie m : movieList) {
            if (year == m.getYear()) {
                result.add(m);
            }
        }

        return result;
    }

    @Override
    public void addMovie(Movie movie) {
        movieList.add(movie);
    }

    @Override
    public void deleteMovieById(int id) {
        Iterator<Movie> it = movieList.listIterator();
        while (it.hasNext()) {
            if (id == it.next().getId()) {
                it.remove();
            }
        }
    }
}
