package db.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


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
	@Column(name="tournament_id")
	private String tournamentId;

	@Temporal(TemporalType.DATE)
	@Column(name="tournament_end")
	private Date tournamentEnd;

	@Column(name="tournament_name")
	private String tournamentName;

	@Temporal(TemporalType.DATE)
	@Column(name="tournament_start")
	private Date tournamentStart;

	public Tournament() {
	}

	public String getTournamentId() {
		return this.tournamentId;
	}

	public void setTournamentId(String tournamentId) {
		this.tournamentId = tournamentId;
	}

	public Date getTournamentEnd() {
		return this.tournamentEnd;
	}

	public void setTournamentEnd(Date tournamentEnd) {
		this.tournamentEnd = tournamentEnd;
	}

	public String getTournamentName() {
		return this.tournamentName;
	}

	public void setTournamentName(String tournamentName) {
		this.tournamentName = tournamentName;
	}

	public Date getTournamentStart() {
		return this.tournamentStart;
	}

	public void setTournamentStart(Date tournamentStart) {
		this.tournamentStart = tournamentStart;
	}

}