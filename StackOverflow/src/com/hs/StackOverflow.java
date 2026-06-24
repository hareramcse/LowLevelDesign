package com.hs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class StackOverflow {
	private final Map<String, User> users = new HashMap<>();
	private final Map<String, Question> questions = new HashMap<>();

	public void registerUser(User user) {
		users.put(user.id(), user);
	}

	public Question postQuestion(User author, String title, String body, List<String> tags) {
		Question question = new Question(UUID.randomUUID().toString(), title, body, author);
		tags.forEach(question::addTag);
		questions.put(question.id(), question);
		System.out.println("Posted: " + question);
		return question;
	}

	public Answer postAnswer(String questionId, User author, String body) {
		Question question = questions.get(questionId);
		if (question == null) {
			System.out.println("Question not found.");
			return null;
		}
		Answer answer = new Answer(UUID.randomUUID().toString(), body, author);
		question.addAnswer(answer);
		System.out.println("Answered: " + answer);
		return answer;
	}

	public void upvoteQuestion(String questionId) {
		Question question = questions.get(questionId);
		if (question != null) {
			question.upvote();
			System.out.println("Upvoted question: " + question.title());
		}
	}

	public void upvoteAnswer(String questionId, String answerId) {
		Question question = questions.get(questionId);
		if (question == null) {
			return;
		}
		question.answers().stream()
				.filter(a -> a.id().equals(answerId))
				.findFirst()
				.ifPresent(a -> {
					a.upvote();
					System.out.println("Upvoted answer by " + a.author().name());
				});
	}

	public List<Question> searchByTag(String tag) {
		return questions.values().stream().filter(q -> q.tags().contains(tag)).toList();
	}
}
