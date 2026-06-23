package com.hs.inning;

import java.util.ArrayList;
import java.util.List;

import com.hs.MatchType;
import com.hs.Team.Team;
import com.hs.Team.Player.PlayerDetails;

public class InningDetails {
	Team battingTeam;
	Team bowlingTeam;
	MatchType matchType;
	List<OverDetails> overs;

	public InningDetails(Team battingTeam, Team bowlingTeam, MatchType matchType) {
		this.battingTeam = battingTeam;
		this.bowlingTeam = bowlingTeam;
		this.matchType = matchType;
		overs = new ArrayList<>();
	}

	public void start(int runsToWin) {
		try {
			battingTeam.chooseNextBatsMan();
		} catch (Exception e) {
		}

		int noOfOvers = matchType.noOfOvers();
		for (int overNumber = 1; overNumber <= noOfOvers; overNumber++) {
			bowlingTeam.chooseNextBowler(matchType.maxOverCountBowlers());

			OverDetails over = new OverDetails(overNumber, bowlingTeam.currentBowler);
			overs.add(over);
			try {
				boolean won = over.startOver(battingTeam, bowlingTeam, runsToWin);
				if (won) {
					break;
				}
			} catch (Exception e) {
				break;
			}

			PlayerDetails temp = battingTeam.striker;
			battingTeam.striker = battingTeam.nonStriker;
			battingTeam.nonStriker = temp;
		}
	}

	public int getTotalRuns() {
		return battingTeam.getTotalRuns();
	}
}
