package com.hs.scoreupdater;

import com.hs.inning.BallDetails;

public interface ScoreUpdaterObserver {

	public void update(BallDetails ballDetails);
}
