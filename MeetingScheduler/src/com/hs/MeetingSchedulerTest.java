package com.hs;

import java.time.LocalDateTime;
import java.util.List;

public class MeetingSchedulerTest {
	public static void main(String[] args) {
		MeetingScheduler scheduler = new MeetingScheduler();
		scheduler.addRoom(new MeetingRoom("mr1", "Board Room", 10));
		scheduler.addRoom(new MeetingRoom("mr2", "Huddle", 4));

		User alice = new User("u1", "Alice");
		User bob = new User("u2", "Bob");
		User charlie = new User("u3", "Charlie");

		LocalDateTime start = LocalDateTime.of(2026, 6, 23, 10, 0);
		LocalDateTime end = LocalDateTime.of(2026, 6, 23, 11, 0);

		scheduler.schedule("Sprint Planning", alice, List.of(alice, bob, charlie), "mr1", start, end);
		scheduler.schedule("1:1", bob, List.of(bob, alice), "mr1",
				LocalDateTime.of(2026, 6, 23, 10, 30), LocalDateTime.of(2026, 6, 23, 11, 0)); // room conflict
		scheduler.schedule("Design Review", charlie, List.of(charlie, bob), "mr2",
				LocalDateTime.of(2026, 6, 23, 14, 0), LocalDateTime.of(2026, 6, 23, 15, 0));

		System.out.println("Alice's meetings: " + scheduler.getMeetingsForUser(alice));
	}
}
