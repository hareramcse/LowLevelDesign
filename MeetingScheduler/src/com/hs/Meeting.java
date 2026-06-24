package com.hs;

import java.time.LocalDateTime;
import java.util.List;

public class Meeting {
	private final String id;
	private final String title;
	private final User organizer;
	private final List<User> attendees;
	private final MeetingRoom room;
	private final LocalDateTime start;
	private final LocalDateTime end;

	public Meeting(String id, String title, User organizer, List<User> attendees, MeetingRoom room,
			LocalDateTime start, LocalDateTime end) {
		this.id = id;
		this.title = title;
		this.organizer = organizer;
		this.attendees = attendees;
		this.room = room;
		this.start = start;
		this.end = end;
	}

	public String id() {
		return id;
	}

	public MeetingRoom room() {
		return room;
	}

	public LocalDateTime start() {
		return start;
	}

	public LocalDateTime end() {
		return end;
	}

	public List<User> attendees() {
		return attendees;
	}

	boolean overlaps(LocalDateTime otherStart, LocalDateTime otherEnd) {
		return start.isBefore(otherEnd) && otherStart.isBefore(end);
	}

	@Override
	public String toString() {
		return "Meeting '" + title + "' in " + room + " [" + start + " - " + end + "] organizer=" + organizer;
	}
}
