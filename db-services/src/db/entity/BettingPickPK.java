package db.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the betting_picks database table.
 * 
 */
@Embeddable
public class BettingPickPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="betting_pick_collection_id", insertable=false, updatable=false)
	private String bettingPickCollectionId;

	@Temporal(TemporalType.DATE)
	@Column(name="betting_pick_collection_day", insertable=false, updatable=false)
	private java.util.Date bettingPickCollectionDay;

	@Column(name="betting_pick_id")
	private String bettingPickId;

	@Column(name="match_id", insertable=false, updatable=false)
	private String matchId;

	@Temporal(TemporalType.DATE)
	@Column(name="match_day", insertable=false, updatable=false)
	private java.util.Date matchDay;

	@Column(name="match_tournament_id", insertable=false, updatable=false)
	private String matchTournamentId;

	public BettingPickPK() {
	}
	public String getBettingPickCollectionId() {
		return this.bettingPickCollectionId;
	}
	public void setBettingPickCollectionId(String bettingPickCollectionId) {
		this.bettingPickCollectionId = bettingPickCollectionId;
	}
	public java.util.Date getBettingPickCollectionDay() {
		return this.bettingPickCollectionDay;
	}
	public void setBettingPickCollectionDay(java.util.Date bettingPickCollectionDay) {
		this.bettingPickCollectionDay = bettingPickCollectionDay;
	}
	public String getBettingPickId() {
		return this.bettingPickId;
	}
	public void setBettingPickId(String bettingPickId) {
		this.bettingPickId = bettingPickId;
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
	public String getMatchTournamentId() {
		return this.matchTournamentId;
	}
	public void setMatchTournamentId(String matchTournamentId) {
		this.matchTournamentId = matchTournamentId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof BettingPickPK)) {
			return false;
		}
		BettingPickPK castOther = (BettingPickPK)other;
		return 
			this.bettingPickCollectionId.equals(castOther.bettingPickCollectionId)
			&& this.bettingPickCollectionDay.equals(castOther.bettingPickCollectionDay)
			&& this.bettingPickId.equals(castOther.bettingPickId)
			&& this.matchId.equals(castOther.matchId)
			&& this.matchDay.equals(castOther.matchDay)
			&& this.matchTournamentId.equals(castOther.matchTournamentId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.bettingPickCollectionId.hashCode();
		hash = hash * prime + this.bettingPickCollectionDay.hashCode();
		hash = hash * prime + this.bettingPickId.hashCode();
		hash = hash * prime + this.matchId.hashCode();
		hash = hash * prime + this.matchDay.hashCode();
		hash = hash * prime + this.matchTournamentId.hashCode();
		
		return hash;
	}
}