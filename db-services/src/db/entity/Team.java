package db.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the teams database table.
 * 
 */
@Entity
@Table(name="teams")
@NamedQuery(name="Team.findAll", query="SELECT t FROM Team t")
public class Team implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(name="team_id")
	private String teamId;

	@Column(name="team_name")
	private String teamName;

	//bi-directional many-to-one association to Match
	@OneToMany(mappedBy="team1")
	private List<Match> matches1;

	//bi-directional many-to-one association to Match
	@OneToMany(mappedBy="team2")
	private List<Match> matches2;

	public Team() {
	}

	public String getTeamId() {
		return this.teamId;
	}

	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}

	public String getTeamName() {
		return this.teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public List<Match> getMatches1() {
		return this.matches1;
	}

	public void setMatches1(List<Match> matches1) {
		this.matches1 = matches1;
	}

	public Match addMatches1(Match matches1) {
		getMatches1().add(matches1);
		matches1.setTeam1(this);

		return matches1;
	}

	public Match removeMatches1(Match matches1) {
		getMatches1().remove(matches1);
		matches1.setTeam1(null);

		return matches1;
	}

	public List<Match> getMatches2() {
		return this.matches2;
	}

	public void setMatches2(List<Match> matches2) {
		this.matches2 = matches2;
	}

	public Match addMatches2(Match matches2) {
		getMatches2().add(matches2);
		matches2.setTeam2(this);

		return matches2;
	}

	public Match removeMatches2(Match matches2) {
		getMatches2().remove(matches2);
		matches2.setTeam2(null);

		return matches2;
	}

}