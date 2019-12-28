package db.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the betting_picks_collection database table.
 * 
 */
@Entity
@Table(name="betting_picks_collection")
@NamedQuery(name="BettingPicksCollection.findAll", query="SELECT b FROM BettingPicksCollection b")
public class BettingPicksCollection implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private BettingPicksCollectionPK id;

	@Column(name="betting_pick_collection_points")
	private Integer bettingPickCollectionPoints;

	@Column(name="betting_pick_collection_type")
	private String bettingPickCollectionType;

	//bi-directional many-to-one association to BettingPick
	@OneToMany(mappedBy="bettingPicksCollection")
	private List<BettingPick> bettingPicks;

	//bi-directional many-to-one association to Player
	@ManyToOne
	@JoinColumn(name="player_id")
	private Player player;

	public BettingPicksCollection() {
	}

	public BettingPicksCollectionPK getId() {
		return this.id;
	}

	public void setId(BettingPicksCollectionPK id) {
		this.id = id;
	}

	public Integer getBettingPickCollectionPoints() {
		return this.bettingPickCollectionPoints;
	}

	public void setBettingPickCollectionPoints(Integer bettingPickCollectionPoints) {
		this.bettingPickCollectionPoints = bettingPickCollectionPoints;
	}

	public String getBettingPickCollectionType() {
		return this.bettingPickCollectionType;
	}

	public void setBettingPickCollectionType(String bettingPickCollectionType) {
		this.bettingPickCollectionType = bettingPickCollectionType;
	}

	public List<BettingPick> getBettingPicks() {
		return this.bettingPicks;
	}

	public void setBettingPicks(List<BettingPick> bettingPicks) {
		this.bettingPicks = bettingPicks;
	}

	public BettingPick addBettingPick(BettingPick bettingPick) {
		getBettingPicks().add(bettingPick);
		bettingPick.setBettingPicksCollection(this);

		return bettingPick;
	}

	public BettingPick removeBettingPick(BettingPick bettingPick) {
		getBettingPicks().remove(bettingPick);
		bettingPick.setBettingPicksCollection(null);

		return bettingPick;
	}

	public Player getPlayer() {
		return this.player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

}