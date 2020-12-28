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

	private String matchresult;

	@Column(name="team1_goals")
	private Integer team1Goals;

	@Column(name="team2_goals")
	private Integer team2Goals;

	//bi-directional many-to-one association to Match
	@ManyToOne
	@JoinColumn(name="match_id")
	private Match match;

	//bi-directional many-to-one association to Player
	@ManyToOne
	@JoinColumn(name="player_id")
	private Player player;

	public BettingPick() {
	}

	public BettingPickPK getId() {
		return this.id;
	}

	public void setId(BettingPickPK id) {
		this.id = id;
	}

	public String getMatchresult() {
		return this.matchresult;
	}

	public void setMatchresult(String matchresult) {
		this.matchresult = matchresult;
	}

	public Integer getTeam1Goals() {
		return this.team1Goals;
	}

	public void setTeam1Goals(Integer team1Goals) {
		this.team1Goals = team1Goals;
	}

	public Integer getTeam2Goals() {
		return this.team2Goals;
	}

	public void setTeam2Goals(Integer team2Goals) {
		this.team2Goals = team2Goals;
	}

	public Match getMatch() {
		return this.match;
	}

	public void setMatch(Match match) {
		this.match = match;
	}

	public Player getPlayer() {
		return this.player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

}