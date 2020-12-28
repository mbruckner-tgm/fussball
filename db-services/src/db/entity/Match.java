package db.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the matches database table.
 * 
 */
@Entity
@Table(name="matches")
@NamedQuery(name="Match.findAll", query="SELECT m FROM Match m")
public class Match implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="match_id")
	private String matchId;

	private String matchresult;

	@Column(name="team1_goals")
	private Integer team1Goals;

	@Column(name="team1_id")
	private String team1Id;

	@Column(name="team2_goals")
	private Integer team2Goals;

	@Column(name="team2_id")
	private String team2Id;

	//bi-directional many-to-one association to BettingPick
	@OneToMany(mappedBy="match")
	private List<BettingPick> bettingPicks;

	//bi-directional many-to-one association to Tournament
	@ManyToOne
	@JoinColumn(name="tournament_id")
	private Tournament tournament;

	public Match() {
	}

	public String getMatchId() {
		return this.matchId;
	}

	public void setMatchId(String matchId) {
		this.matchId = matchId;
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

	public String getTeam1Id() {
		return this.team1Id;
	}

	public void setTeam1Id(String team1Id) {
		this.team1Id = team1Id;
	}

	public Integer getTeam2Goals() {
		return this.team2Goals;
	}

	public void setTeam2Goals(Integer team2Goals) {
		this.team2Goals = team2Goals;
	}

	public String getTeam2Id() {
		return this.team2Id;
	}

	public void setTeam2Id(String team2Id) {
		this.team2Id = team2Id;
	}

	public List<BettingPick> getBettingPicks() {
		return this.bettingPicks;
	}

	public void setBettingPicks(List<BettingPick> bettingPicks) {
		this.bettingPicks = bettingPicks;
	}

	public BettingPick addBettingPick(BettingPick bettingPick) {
		getBettingPicks().add(bettingPick);
		bettingPick.setMatch(this);

		return bettingPick;
	}

	public BettingPick removeBettingPick(BettingPick bettingPick) {
		getBettingPicks().remove(bettingPick);
		bettingPick.setMatch(null);

		return bettingPick;
	}

	public Tournament getTournament() {
		return this.tournament;
	}

	public void setTournament(Tournament tournament) {
		this.tournament = tournament;
	}

}