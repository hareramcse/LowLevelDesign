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
	private int ballNumber;
	private BallType ballType;
	private RunType runType;
	private PlayerDetails playedBy;
	private PlayerDetails bowledBy;
	private Wicket wicket;
	List<ScoreUpdaterObserver> scoreUpdaterObserverList = new ArrayList<>();

	public BallDetails(int ballNumber) {
		this.ballNumber = ballNumber;
		scoreUpdaterObserverList.add(new BowlingScoreUpdater());
		scoreUpdaterObserverList.add(new BattingScoreUpdater());
	}

	public void startBallDelivery(Team battingTeam, Team bowlingTeam, OverDetails over) {

		playedBy = battingTeam.getStriker();
		this.bowledBy = over.bowledBy;
		// THROW BALL AND GET THE BALL TYPE, assuming here that ball type is always
		// NORMAL
		ballType = BallType.NORMAL;

		// wicket or no wicket
		if (isWicketTaken()) {
			runType = RunType.ZERO;
			// considering only BOLD
			wicket = new Wicket(WicketType.BOLD, bowlingTeam.getCurrentBowler(), over, this);
			// making only striker out for now
			battingTeam.setStriker(null);
		} else {
			runType = getRunType();

			if (runType == RunType.ONE || runType == RunType.THREE) {
				// swap striket and non striker
				PlayerDetails temp = battingTeam.getStriker();
				battingTeam.setStriker(battingTeam.getNonStriker());
				battingTeam.setNonStriker(temp);
			}
		}

		// update player scoreboard
		notifyUpdaters(this);
	}

	private void notifyUpdaters(BallDetails ballDetails) {

		for (ScoreUpdaterObserver observer : scoreUpdaterObserverList) {
			observer.update(ballDetails);
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
		// random function return value between 0 and 1
		if (Math.random() < 0.2) {
			return true;
		} else {
			return false;
		}
	}

	public int getBallNumber() {
		return ballNumber;
	}

	public void setBallNumber(int ballNumber) {
		this.ballNumber = ballNumber;
	}

	public BallType getBallType() {
		return ballType;
	}

	public void setBallType(BallType ballType) {
		this.ballType = ballType;
	}

	public PlayerDetails getPlayedBy() {
		return playedBy;
	}

	public void setPlayedBy(PlayerDetails playedBy) {
		this.playedBy = playedBy;
	}

	public PlayerDetails getBowledBy() {
		return bowledBy;
	}

	public void setBowledBy(PlayerDetails bowledBy) {
		this.bowledBy = bowledBy;
	}

	public Wicket getWicket() {
		return wicket;
	}

	public void setWicket(Wicket wicket) {
		this.wicket = wicket;
	}

	public List<ScoreUpdaterObserver> getScoreUpdaterObserverList() {
		return scoreUpdaterObserverList;
	}

	public void setScoreUpdaterObserverList(List<ScoreUpdaterObserver> scoreUpdaterObserverList) {
		this.scoreUpdaterObserverList = scoreUpdaterObserverList;
	}

	public void setRunType(RunType runType) {
		this.runType = runType;
	}

}
