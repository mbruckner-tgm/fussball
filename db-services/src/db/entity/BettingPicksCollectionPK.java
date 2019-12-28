package db.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the betting_picks_collection database table.
 * 
 */
@Embeddable
public class BettingPicksCollectionPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="betting_pick_collection_id")
	private String bettingPickCollectionId;

	@Temporal(TemporalType.DATE)
	@Column(name="betting_pick_collection_day")
	private java.util.Date bettingPickCollectionDay;

	public BettingPicksCollectionPK() {
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

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof BettingPicksCollectionPK)) {
			return false;
		}
		BettingPicksCollectionPK castOther = (BettingPicksCollectionPK)other;
		return 
			this.bettingPickCollectionId.equals(castOther.bettingPickCollectionId)
			&& this.bettingPickCollectionDay.equals(castOther.bettingPickCollectionDay);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.bettingPickCollectionId.hashCode();
		hash = hash * prime + this.bettingPickCollectionDay.hashCode();
		
		return hash;
	}
}