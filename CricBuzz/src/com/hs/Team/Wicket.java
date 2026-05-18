package com.hs.Team;

import com.hs.Team.Player.PlayerDetails;
import com.hs.inning.BallDetails;
import com.hs.inning.OverDetails;

public class Wicket {

	public WicketType wicketType;
	public PlayerDetails takenBy;
	public OverDetails overDetail;
	public BallDetails ballDetail;

	public Wicket(WicketType wicketType, PlayerDetails takenBy, OverDetails overDetail, BallDetails ballDetail) {

		this.wicketType = wicketType;
		this.takenBy = takenBy;
		this.overDetail = overDetail;
		this.ballDetail = ballDetail;
	}
}
