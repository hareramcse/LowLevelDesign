package com.hs;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class MeetingScheduler {
	private final Map<String, MeetingRoom> rooms = new HashMap<>();
	private final List<Meeting> meetings = new ArrayList<>();

	public void addRoom(MeetingRoom room) {
		rooms.put(room.id(), room);
	}

	public Optional<Meeting> schedule(String title, User organizer, List<User> attendees, String roomId,
			LocalDateTime start, LocalDateTime end) {
		MeetingRoom room = rooms.get(roomId);
		if (room == null) {
			System.out.println("Room not found.");
			return Optional.empty();
		}
		if (attendees.size() > room.capacity()) {
			System.out.println("Room capacity exceeded.");
			return Optional.empty();
		}
		if (hasConflict(room, start, end)) {
			System.out.println("Room " + room.name() + " is not available at that time.");
			return Optional.empty();
		}
		for (User attendee : attendees) {
			if (hasUserConflict(attendee, start, end)) {
				System.out.println(attendee + " has a conflicting meeting.");
				return Optional.empty();
			}
		}
		Meeting meeting = new Meeting(UUID.randomUUID().toString(), title, organizer, attendees, room, start, end);
		meetings.add(meeting);
		System.out.println("Scheduled: " + meeting);
		return Optional.of(meeting);
	}

	private boolean hasConflict(MeetingRoom room, LocalDateTime start, LocalDateTime end) {
		return meetings.stream()
				.filter(m -> m.room().id().equals(room.id()))
				.anyMatch(m -> m.overlaps(start, end));
	}

	private boolean hasUserConflict(User user, LocalDateTime start, LocalDateTime end) {
		return meetings.stream()
				.filter(m -> m.attendees().contains(user))
				.anyMatch(m -> m.overlaps(start, end));
	}

	public void cancel(String meetingId) {
		meetings.removeIf(m -> {
			if (m.id().equals(meetingId)) {
				System.out.println("Cancelled: " + m);
				return true;
			}
			return false;
		});
	}

	public List<Meeting> getMeetingsForUser(User user) {
		return meetings.stream().filter(m -> m.attendees().contains(user)).toList();
	}
}
