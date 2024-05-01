package com.hs;

import java.util.ArrayList;
import java.util.List;

public class TheaterAdmin {
	private List<Theater> theaters;
	private List<Movie> movies;

	public TheaterAdmin() {
		addTheater();
		addMovie();
	}

	public Theater getTheater() {
		return theaters.get(0);
	}

	private void addTheater() {
		theaters = new ArrayList<Theater>();
		Theater theater = new Theater("T1", "PVR Cinemas", "Location 1", 100);

		Seat seat1 = new Seat("S1", SeatType.REGULAR, false);
		Seat seat2 = new Seat("S2", SeatType.VIP, false);
		Seat seat3 = new Seat("S3", SeatType.VIP, false);
		List<Seat> seats = new ArrayList<>();
		seats.add(seat1);
		seats.add(seat2);
		seats.add(seat3);
		theater.setAvailableSeats(seats);
		theaters.add(theater);
	}

	private void addMovie() {
		movies = new ArrayList<Movie>();
		Movie movie = new Movie("M1", "The Avengers", "Joss Whedon", Genre.ACTION);
		movies.add(movie);
		theaters.get(0).setMovies(movies);
	}
}
