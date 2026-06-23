package com.hs.inning;

import java.util.ArrayList;
import java.util.List;

import com.hs.Team.Team;
import com.hs.Team.Wicket;
import com.hs.Team.WicketType;
import com.hs.Team.Player.PlayerDetails;
import com.hs.scoreupdater.BattingScoreUpdater;
import com.hs.scoreupdater.BowlingScoreUpdater;
import com.hs.scoreupdater.ScoreUpdaterObserver;

public class BallDetails {
	public int ballNumber;
	public BallType ballType;
	public RunType runType;
	public PlayerDetails playedBy;
	public PlayerDetails bowledBy;
	public Wicket wicket;
	List<ScoreUpdaterObserver> scoreUpdaters = new ArrayList<>();

	public BallDetails(int ballNumber) {
		this.ballNumber = ballNumber;
		scoreUpdaters.add(new BowlingScoreUpdater());
		scoreUpdaters.add(new BattingScoreUpdater());
	}

	public void startBallDelivery(Team battingTeam, Team bowlingTeam, OverDetails over) {
		playedBy = battingTeam.striker;
		bowledBy = over.bowledBy;
		ballType = BallType.NORMAL;

		if (isWicketTaken()) {
			runType = RunType.ZERO;
			wicket = new Wicket(WicketType.BOLD, bowlingTeam.currentBowler, over, this);
			battingTeam.striker = null;
		} else {
			runType = getRunType();

			if (runType == RunType.ONE || runType == RunType.THREE) {
				PlayerDetails temp = battingTeam.striker;
				battingTeam.striker = battingTeam.nonStriker;
				battingTeam.nonStriker = temp;
			}
		}

		for (ScoreUpdaterObserver observer : scoreUpdaters) {
			observer.update(this);
		}
	}

	public RunType getRunType() {
		double val = Math.random();
		if (val <= 0.2) {
			return RunType.ONE;
		} else if (val >= 0.3 && val <= 0.5) {
			return RunType.TWO;
		} else if (val >= 0.6 && val <= 0.8) {
			return RunType.FOUR;
		} else {
			return RunType.SIX;
		}
	}

	private boolean isWicketTaken() {
		return Math.random() < 0.2;
	}
}
