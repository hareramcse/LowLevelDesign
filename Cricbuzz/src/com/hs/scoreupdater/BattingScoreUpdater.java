package com.hs.scoreupdater;

import com.hs.inning.BallDetails;
import com.hs.inning.RunType;

public class BattingScoreUpdater implements ScoreUpdaterObserver {
	@Override
	public void update(BallDetails ballDetails) {
		int run = 0;

		if (RunType.ONE == ballDetails.getRunType()) {
			run = 1;
		} else if (RunType.TWO == ballDetails.getRunType()) {
			run = 2;
		} else if (RunType.FOUR == ballDetails.getRunType()) {
			run = 4;
			ballDetails.getPlayedBy().battingScoreCard.totalFours++;
		} else if (RunType.SIX == ballDetails.getRunType()) {
			run = 6;
			ballDetails.getPlayedBy().battingScoreCard.totalSix++;
		}
		ballDetails.getPlayedBy().battingScoreCard.totalRuns += run;

		ballDetails.getPlayedBy().battingScoreCard.totalBallsPlayed++;

		if (ballDetails.getWicket() != null) {
			ballDetails.getPlayedBy().battingScoreCard.wicketDetails = ballDetails.getWicket();
		}
	}
}
