package com.hs.scoreupdater;

import com.hs.inning.BallDetails;
import com.hs.inning.RunType;

public class BattingScoreUpdater implements ScoreUpdaterObserver {
	@Override
	public void update(BallDetails ball) {
		int run = 0;

		if (RunType.ONE == ball.runType) {
			run = 1;
		} else if (RunType.TWO == ball.runType) {
			run = 2;
		} else if (RunType.FOUR == ball.runType) {
			run = 4;
			ball.playedBy.battingScoreCard.totalFours++;
		} else if (RunType.SIX == ball.runType) {
			run = 6;
			ball.playedBy.battingScoreCard.totalSix++;
		}
		ball.playedBy.battingScoreCard.totalRuns += run;
		ball.playedBy.battingScoreCard.totalBallsPlayed++;

		if (ball.wicket != null) {
			ball.playedBy.battingScoreCard.wicketDetails = ball.wicket;
		}
	}
}
