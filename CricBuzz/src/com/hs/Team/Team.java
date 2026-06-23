package com.hs.Team;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import com.hs.Team.Player.PlayerDetails;

public class Team {
	public String teamName;
	public Queue<PlayerDetails> playing11;
	public List<PlayerDetails> bench;
	public boolean isWinner;

	// batting state
	Queue<PlayerDetails> yetToPlay;
	public PlayerDetails striker;
	public PlayerDetails nonStriker;

	// bowling state
	Deque<PlayerDetails> bowlersList;
	Map<PlayerDetails, Integer> bowlerVsOverCount;
	public PlayerDetails currentBowler;

	public Team(String teamName, Queue<PlayerDetails> playing11, List<PlayerDetails> bench,
			List<PlayerDetails> bowlers) {
		this.teamName = teamName;
		this.playing11 = playing11;
		this.bench = bench;

		yetToPlay = new LinkedList<>();
		yetToPlay.addAll(playing11);

		bowlersList = new LinkedList<>();
		bowlerVsOverCount = new HashMap<>();
		for (PlayerDetails bowler : bowlers) {
			bowlersList.addLast(bowler);
			bowlerVsOverCount.put(bowler, 0);
		}
	}

	public void chooseNextBatsMan() throws Exception {
		if (yetToPlay.isEmpty()) {
			throw new Exception();
		}
		if (striker == null) {
			striker = yetToPlay.poll();
		}
		if (nonStriker == null) {
			nonStriker = yetToPlay.poll();
		}
	}

	public void chooseNextBowler(int maxOverCountPerBowler) {
		PlayerDetails playerDetails = bowlersList.poll();
		if (bowlerVsOverCount.get(playerDetails) + 1 == maxOverCountPerBowler) {
			currentBowler = playerDetails;
		} else {
			currentBowler = playerDetails;
			bowlersList.addLast(playerDetails);
			bowlerVsOverCount.put(playerDetails, bowlerVsOverCount.get(playerDetails) + 1);
		}
	}

	public void printBattingScoreCard() {
		for (PlayerDetails playerDetails : playing11) {
			playerDetails.printBattingScoreCard();
		}
	}

	public void printBowlingScoreCard() {
		for (PlayerDetails playerDetails : playing11) {
			if (playerDetails.bowlingScoreCard.totalOversCount > 0) {
				playerDetails.printBowlingScoreCard();
			}
		}
	}

	public int getTotalRuns() {
		int totalRun = 0;
		for (PlayerDetails player : playing11) {
			totalRun += player.battingScoreCard.totalRuns;
		}
		return totalRun;
	}
}
