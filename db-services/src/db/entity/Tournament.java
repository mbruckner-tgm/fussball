package db.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tournaments database table.
 * 
 */
@Entity
@Table(name="tournaments")
@NamedQuery(name="Tournament.findAll", query="SELECT t FROM Tournament t")
public class Tournament implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="tournament_id")
	private String tournamentId;

	@Column(name="tournament_name")
	private String tournamentName;

	@Column(name="tournament_year")
	private Integer tournamentYear;

	//bi-directional many-to-one association to Match
	@OneToMany(mappedBy="tournament")
	private List<Match> matches;

	public Tournament() {
	}

	public String getTournamentId() {
		return this.tournamentId;
	}

	public void setTournamentId(String tournamentId) {
		this.tournamentId = tournamentId;
	}

	public String getTournamentName() {
		return this.tournamentName;
	}

	public void setTournamentName(String tournamentName) {
		this.tournamentName = tournamentName;
	}

	public Integer getTournamentYear() {
		return this.tournamentYear;
	}

	public void setTournamentYear(Integer tournamentYear) {
		this.tournamentYear = tournamentYear;
	}

	public List<Match> getMatches() {
		return this.matches;
	}

	public void setMatches(List<Match> matches) {
		this.matches = matches;
	}

	public Match addMatch(Match match) {
		getMatches().add(match);
		match.setTournament(this);

		return match;
	}

	public Match removeMatch(Match match) {
		getMatches().remove(match);
		match.setTournament(null);

		return match;
	}

}