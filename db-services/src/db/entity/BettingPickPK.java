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

	@Column(name="betting_picks_collection_id")
	private String bettingPicksCollectionId;

	@Column(name="betting_pick_id")
	private String bettingPickId;

	@Column(name="user_id", insertable=false, updatable=false)
	private Integer userId;

	public BettingPickPK() {
	}
	public String getBettingPicksCollectionId() {
		return this.bettingPicksCollectionId;
	}
	public void setBettingPicksCollectionId(String bettingPicksCollectionId) {
		this.bettingPicksCollectionId = bettingPicksCollectionId;
	}
	public String getBettingPickId() {
		return this.bettingPickId;
	}
	public void setBettingPickId(String bettingPickId) {
		this.bettingPickId = bettingPickId;
	}
	public Integer getUserId() {
		return this.userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
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
			this.bettingPicksCollectionId.equals(castOther.bettingPicksCollectionId)
			&& this.bettingPickId.equals(castOther.bettingPickId)
			&& this.userId.equals(castOther.userId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.bettingPicksCollectionId.hashCode();
		hash = hash * prime + this.bettingPickId.hashCode();
		hash = hash * prime + this.userId.hashCode();
		
		return hash;
	}
}