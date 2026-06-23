package com.hs.Team.Player;

import com.hs.Team.Player.Score.BattingScoreCard;
import com.hs.Team.Player.Score.BowlingScoreCard;

public class PlayerDetails {

	public String name;
	public PlayerType playerType;
	public BattingScoreCard battingScoreCard;
	public BowlingScoreCard bowlingScoreCard;

	public PlayerDetails(String name, PlayerType playerType) {
		this.name = name;
		this.playerType = playerType;
		battingScoreCard = new BattingScoreCard();
		bowlingScoreCard = new BowlingScoreCard();
	}

	public void printBattingScoreCard() {
		System.out.println("PlayerName: " + name + " -- totalRuns: " + battingScoreCard.totalRuns
				+ " -- totalBallsPlayed: " + battingScoreCard.totalBallsPlayed + " -- 4s: "
				+ battingScoreCard.totalFours + " -- 6s: " + battingScoreCard.totalSix + " -- outby: "
				+ ((battingScoreCard.wicketDetails != null) ? battingScoreCard.wicketDetails.takenBy.name
						: "notout"));
	}

	public void printBowlingScoreCard() {
		System.out.println("PlayerName: " + name + " -- totalOversThrown: " + bowlingScoreCard.totalOversCount
				+ " -- totalRunsGiven: " + bowlingScoreCard.runsGiven + " -- WicketsTaken: "
				+ bowlingScoreCard.wicketsTaken);
	}
}
