package net.therap.javafest.api.domain;

import java.io.Serializable;

/**
 * @author Musfekur Rahman
 * @since 1.0
 */
public class Movie implements Serializable {

    private static final long serialVersionUID = 1;

    private long id;
    private String name;
    private int year;
    private String genre;

    public Movie() {
    }

    public Movie(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Movie(long id, String name, int year, String genre) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.genre = genre;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
