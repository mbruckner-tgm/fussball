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

	@Column(name="match_id")
	private String matchId;

	@Temporal(TemporalType.DATE)
	@Column(name="match_day")
	private java.util.Date matchDay;

	@Column(name="tournament_id", insertable=false, updatable=false)
	private String tournamentId;

	public MatchPK() {
	}
	public String getMatchId() {
		return this.matchId;
	}
	public void setMatchId(String matchId) {
		this.matchId = matchId;
	}
	public java.util.Date getMatchDay() {
		return this.matchDay;
	}
	public void setMatchDay(java.util.Date matchDay) {
		this.matchDay = matchDay;
	}
	public String getTournamentId() {
		return this.tournamentId;
	}
	public void setTournamentId(String tournamentId) {
		this.tournamentId = tournamentId;
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
			this.matchId.equals(castOther.matchId)
			&& this.matchDay.equals(castOther.matchDay)
			&& this.tournamentId.equals(castOther.tournamentId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.matchId.hashCode();
		hash = hash * prime + this.matchDay.hashCode();
		hash = hash * prime + this.tournamentId.hashCode();
		
		return hash;
	}
}