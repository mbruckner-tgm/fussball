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

	@EmbeddedId
	private MatchPK id;

	@Column(name="home_team_goals")
	private Integer homeTeamGoals;

	@Column(name="home_team_points")
	private Integer homeTeamPoints;

	@Column(name="opponent_team_goals")
	private Integer opponentTeamGoals;

	@Column(name="opponent_team_points")
	private Integer opponentTeamPoints;

	//bi-directional many-to-one association to BettingPick
	@OneToMany(mappedBy="match1")
	private List<BettingPick> bettingPicks1;

	//bi-directional many-to-one association to BettingPick
	@OneToMany(mappedBy="match2")
	private List<BettingPick> bettingPicks2;

	//bi-directional many-to-one association to Team
	@ManyToOne
	@JoinColumn(name="home_team_id")
	private Team team1;

	//bi-directional many-to-one association to Team
	@ManyToOne
	@JoinColumn(name="opponent_team_id")
	private Team team2;

	//bi-directional many-to-one association to Tournament
	@ManyToOne
	@JoinColumn(name="tournament_id")
	private Tournament tournament;

	public Match() {
	}

	public MatchPK getId() {
		return this.id;
	}

	public void setId(MatchPK id) {
		this.id = id;
	}

	public Integer getHomeTeamGoals() {
		return this.homeTeamGoals;
	}

	public void setHomeTeamGoals(Integer homeTeamGoals) {
		this.homeTeamGoals = homeTeamGoals;
	}

	public Integer getHomeTeamPoints() {
		return this.homeTeamPoints;
	}

	public void setHomeTeamPoints(Integer homeTeamPoints) {
		this.homeTeamPoints = homeTeamPoints;
	}

	public Integer getOpponentTeamGoals() {
		return this.opponentTeamGoals;
	}

	public void setOpponentTeamGoals(Integer opponentTeamGoals) {
		this.opponentTeamGoals = opponentTeamGoals;
	}

	public Integer getOpponentTeamPoints() {
		return this.opponentTeamPoints;
	}

	public void setOpponentTeamPoints(Integer opponentTeamPoints) {
		this.opponentTeamPoints = opponentTeamPoints;
	}

	public List<BettingPick> getBettingPicks1() {
		return this.bettingPicks1;
	}

	public void setBettingPicks1(List<BettingPick> bettingPicks1) {
		this.bettingPicks1 = bettingPicks1;
	}

	public BettingPick addBettingPicks1(BettingPick bettingPicks1) {
		getBettingPicks1().add(bettingPicks1);
		bettingPicks1.setMatch1(this);

		return bettingPicks1;
	}

	public BettingPick removeBettingPicks1(BettingPick bettingPicks1) {
		getBettingPicks1().remove(bettingPicks1);
		bettingPicks1.setMatch1(null);

		return bettingPicks1;
	}

	public List<BettingPick> getBettingPicks2() {
		return this.bettingPicks2;
	}

	public void setBettingPicks2(List<BettingPick> bettingPicks2) {
		this.bettingPicks2 = bettingPicks2;
	}

	public BettingPick addBettingPicks2(BettingPick bettingPicks2) {
		getBettingPicks2().add(bettingPicks2);
		bettingPicks2.setMatch2(this);

		return bettingPicks2;
	}

	public BettingPick removeBettingPicks2(BettingPick bettingPicks2) {
		getBettingPicks2().remove(bettingPicks2);
		bettingPicks2.setMatch2(null);

		return bettingPicks2;
	}

	public Team getTeam1() {
		return this.team1;
	}

	public void setTeam1(Team team1) {
		this.team1 = team1;
	}

	public Team getTeam2() {
		return this.team2;
	}

	public void setTeam2(Team team2) {
		this.team2 = team2;
	}

	public Tournament getTournament() {
		return this.tournament;
	}

	public void setTournament(Tournament tournament) {
		this.tournament = tournament;
	}

}