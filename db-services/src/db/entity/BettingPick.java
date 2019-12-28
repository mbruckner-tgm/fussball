package db.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the betting_picks database table.
 * 
 */
@Entity
@Table(name="betting_picks")
@NamedQuery(name="BettingPick.findAll", query="SELECT b FROM BettingPick b")
public class BettingPick implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private BettingPickPK id;

	@Column(name="betting_pick")
	private String bettingPick;

	@Column(name="betting_pick_points")
	private Integer bettingPickPoints;

	@Column(name="betting_pick_score")
	private String bettingPickScore;

	//bi-directional many-to-one association to Match
	@ManyToOne
	@JoinColumn(name="match_id", referencedColumnName="match_id")
	private Match match1;

	//bi-directional many-to-one association to Match
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="match_day", referencedColumnName="match_day"),
		@JoinColumn(name="match_id", referencedColumnName="match_id"),
		@JoinColumn(name="match_tournament_id", referencedColumnName="tournament_id")
		})
	private Match match2;

	//bi-directional many-to-one association to Player
	@ManyToOne
	@JoinColumn(name="player_id")
	private Player player;

	//bi-directional many-to-one association to BettingPicksCollection
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="betting_pick_collection_day", referencedColumnName="betting_pick_collection_day"),
		@JoinColumn(name="betting_pick_collection_id", referencedColumnName="betting_pick_collection_id")
		})
	private BettingPicksCollection bettingPicksCollection;

	public BettingPick() {
	}

	public BettingPickPK getId() {
		return this.id;
	}

	public void setId(BettingPickPK id) {
		this.id = id;
	}

	public String getBettingPick() {
		return this.bettingPick;
	}

	public void setBettingPick(String bettingPick) {
		this.bettingPick = bettingPick;
	}

	public Integer getBettingPickPoints() {
		return this.bettingPickPoints;
	}

	public void setBettingPickPoints(Integer bettingPickPoints) {
		this.bettingPickPoints = bettingPickPoints;
	}

	public String getBettingPickScore() {
		return this.bettingPickScore;
	}

	public void setBettingPickScore(String bettingPickScore) {
		this.bettingPickScore = bettingPickScore;
	}

	public Match getMatch1() {
		return this.match1;
	}

	public void setMatch1(Match match1) {
		this.match1 = match1;
	}

	public Match getMatch2() {
		return this.match2;
	}

	public void setMatch2(Match match2) {
		this.match2 = match2;
	}

	public Player getPlayer() {
		return this.player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public BettingPicksCollection getBettingPicksCollection() {
		return this.bettingPicksCollection;
	}

	public void setBettingPicksCollection(BettingPicksCollection bettingPicksCollection) {
		this.bettingPicksCollection = bettingPicksCollection;
	}

}