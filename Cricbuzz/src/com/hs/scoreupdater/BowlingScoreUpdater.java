package com.hs.scoreupdater;

import com.hs.inning.BallDetails;
import com.hs.inning.BallType;
import com.hs.inning.RunType;

public class BowlingScoreUpdater implements ScoreUpdaterObserver {

	@Override
	public void update(BallDetails ballDetails) {

		if (ballDetails.getBallNumber() == 6 && ballDetails.getBallType() == BallType.NORMAL) {
			ballDetails.getBowledBy().bowlingScoreCard.totalOversCount++;
		}

		if (RunType.ONE == ballDetails.getRunType()) {
			ballDetails.getBowledBy().bowlingScoreCard.runsGiven += 1;
		} else if (RunType.TWO == ballDetails.getRunType()) {
			ballDetails.getBowledBy().bowlingScoreCard.runsGiven += 2;
		} else if (RunType.FOUR == ballDetails.getRunType()) {
			ballDetails.getBowledBy().bowlingScoreCard.runsGiven += 4;
		} else if (RunType.SIX == ballDetails.getRunType()) {
			ballDetails.getBowledBy().bowlingScoreCard.runsGiven += 6;
		}

		if (ballDetails.getWicket() != null) {
			ballDetails.getBowledBy().bowlingScoreCard.wicketsTaken++;
		}

		if (ballDetails.getBallType() == BallType.NOBALL) {
			ballDetails.getBowledBy().bowlingScoreCard.noBallCount++;
		}

		if (ballDetails.getBallType() == BallType.WIDEBALL) {
			ballDetails.getBowledBy().bowlingScoreCard.wideBallCount++;
		}
	}
}
