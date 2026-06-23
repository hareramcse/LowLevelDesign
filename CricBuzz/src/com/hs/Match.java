package com.hs;

import com.hs.Team.Team;
import com.hs.inning.InningDetails;

public class Match {
	Team teamA;
	Team teamB;
	Team tossWinner;
	InningDetails[] innings;
	MatchType matchType;

	public Match(Team teamA, Team teamB, MatchType matchType) {
		this.teamA = teamA;
		this.teamB = teamB;
		this.matchType = matchType;
		innings = new InningDetails[2];
	}

	public void startMatch() {
		tossWinner = toss(teamA, teamB);

		for (int inning = 1; inning <= 2; inning++) {
			InningDetails inningDetails;
			Team bowlingTeam;
			Team battingTeam;

			if (inning == 1) {
				battingTeam = tossWinner;
				bowlingTeam = tossWinner.teamName.equals(teamA.teamName) ? teamB : teamA;
				inningDetails = new InningDetails(battingTeam, bowlingTeam, matchType);
				inningDetails.start(-1);
			} else {
				bowlingTeam = tossWinner;
				battingTeam = tossWinner.teamName.equals(teamA.teamName) ? teamB : teamA;
				inningDetails = new InningDetails(battingTeam, bowlingTeam, matchType);
				inningDetails.start(innings[0].getTotalRuns());
				if (bowlingTeam.getTotalRuns() > battingTeam.getTotalRuns()) {
					bowlingTeam.isWinner = true;
				}
			}

			innings[inning - 1] = inningDetails;

			System.out.println();
			System.out.println("INNING " + inning + " -- total Run: " + battingTeam.getTotalRuns());
			System.out.println("---Batting ScoreCard : " + battingTeam.teamName + "---");
			battingTeam.printBattingScoreCard();

			System.out.println();
			System.out.println("---Bowling ScoreCard : " + bowlingTeam.teamName + "---");
			bowlingTeam.printBowlingScoreCard();
		}

		System.out.println();
		if (teamA.isWinner) {
			System.out.println("---WINNER---" + teamA.teamName);
		} else {
			System.out.println("---WINNER---" + teamB.teamName);
		}
	}

	private Team toss(Team teamA, Team teamB) {
		if (Math.random() < 0.5) {
			return teamA;
		} else {
			return teamB;
		}
	}
}
