package com.hs;

public class Movie {
	private String movieId;
	private String title;
	private String director;
	private Genre genre;

	public Movie(String movieId, String title, String director, Genre genre) {
		this.movieId = movieId;
		this.title = title;
		this.director = director;
		this.genre = genre;
	}

	// Getters and setters
	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

}
