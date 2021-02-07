package db.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the matches database table.
 * 
 */
@Entity
@Table(name="matches")
@NamedQueries(value = {
		@NamedQuery(name = "Match.findAll", query="SELECT m FROM Match m"),
		@NamedQuery(name = "Match.findAllMatchesWhereMatchdayGreater", query="SELECT m FROM Match m where m.id.matchDay >= :stichtag"),
		@NamedQuery(name = "Match.findAllMatchesToMatchday", query="SELECT m FROM Match m where m.id.matchDay = :matchDay"),
		@NamedQuery(name = "Match.findAllMatchesToTeamId", query="SELECT m FROM Match m where m.id.homeTeamId = :teamId OR m.id.opponentTeamId = :teamId"),
		@NamedQuery(name = "Match.findAllMatchesToTurnier", query="SELECT m FROM Match m where m.tournamentId = :turnier"),
		@NamedQuery(name = "Match.findAllMatchesToMatchDayAndTeam", query="SELECT m FROM Match m where m.id.matchDay = :matchDay and (m.id.homeTeamId = :teamId OR m.id.opponentTeamId = :teamId)"),
		@NamedQuery(name = "Match.findAllMatchesToMatchDayAndTournament", query="SELECT m FROM Match m where m.id.matchDay = :matchDay and m.tournamentId = :turnier"),
		@NamedQuery(name = "Match.findAllMatchesToTournamentAndTeam", query="SELECT m FROM Match m where m.tournamentId = :turnier and (m.id.homeTeamId = :teamId OR m.id.opponentTeamId = :teamId)"),
})
public class Match implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MatchPK id;

	@Column(name="anlage_user")
	private String anlageUser;

	@Column(name="anlage_zeitpunkt")
	private Timestamp anlageZeitpunkt;

	@Column(name="home_team_goals")
	private Integer homeTeamGoals;

	private String kickoff;

	private String matchresult;

	@Column(name="opponent_team_goals")
	private Integer opponentTeamGoals;

	@Column(name="tournament_id")
	private String tournamentId;

	@Column(name="update_user")
	private String updateUser;

	@Column(name="update_zeitpunkt")
	private Timestamp updateZeitpunkt;

	public Match() {
	}

	public MatchPK getId() {
		return this.id;
	}

	public void setId(MatchPK id) {
		this.id = id;
	}

	public String getAnlageUser() {
		return this.anlageUser;
	}

	public void setAnlageUser(String anlageUser) {
		this.anlageUser = anlageUser;
	}

	public Timestamp getAnlageZeitpunkt() {
		return this.anlageZeitpunkt;
	}

	public void setAnlageZeitpunkt(Timestamp anlageZeitpunkt) {
		this.anlageZeitpunkt = anlageZeitpunkt;
	}

	public Integer getHomeTeamGoals() {
		return this.homeTeamGoals;
	}

	public void setHomeTeamGoals(Integer homeTeamGoals) {
		this.homeTeamGoals = homeTeamGoals;
	}

	public String getKickoff() {
		return this.kickoff;
	}

	public void setKickoff(String kickoff) {
		this.kickoff = kickoff;
	}

	public String getMatchresult() {
		return this.matchresult;
	}

	public void setMatchresult(String matchresult) {
		this.matchresult = matchresult;
	}

	public Integer getOpponentTeamGoals() {
		return this.opponentTeamGoals;
	}

	public void setOpponentTeamGoals(Integer opponentTeamGoals) {
		this.opponentTeamGoals = opponentTeamGoals;
	}

	public String getTournamentId() {
		return this.tournamentId;
	}

	public void setTournamentId(String tournamentId) {
		this.tournamentId = tournamentId;
	}

	public String getUpdateUser() {
		return this.updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public Timestamp getUpdateZeitpunkt() {
		return this.updateZeitpunkt;
	}

	public void setUpdateZeitpunkt(Timestamp updateZeitpunkt) {
		this.updateZeitpunkt = updateZeitpunkt;
	}

}