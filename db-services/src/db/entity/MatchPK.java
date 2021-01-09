package db.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the matches database table.
 * 
 */
@Embeddable
public class MatchPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.DATE)
	@Column(name="match_day")
	private java.util.Date matchDay;

	@Column(name="home_team_id")
	private String homeTeamId;

	@Column(name="opponent_team_id")
	private String opponentTeamId;

	public MatchPK() {
	}
	public java.util.Date getMatchDay() {
		return this.matchDay;
	}
	public void setMatchDay(java.util.Date matchDay) {
		this.matchDay = matchDay;
	}
	public String getHomeTeamId() {
		return this.homeTeamId;
	}
	public void setHomeTeamId(String homeTeamId) {
		this.homeTeamId = homeTeamId;
	}
	public String getOpponentTeamId() {
		return this.opponentTeamId;
	}
	public void setOpponentTeamId(String opponentTeamId) {
		this.opponentTeamId = opponentTeamId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof MatchPK)) {
			return false;
		}
		MatchPK castOther = (MatchPK)other;
		return 
			this.matchDay.equals(castOther.matchDay)
			&& this.homeTeamId.equals(castOther.homeTeamId)
			&& this.opponentTeamId.equals(castOther.opponentTeamId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.matchDay.hashCode();
		hash = hash * prime + this.homeTeamId.hashCode();
		hash = hash * prime + this.opponentTeamId.hashCode();
		
		return hash;
	}
}